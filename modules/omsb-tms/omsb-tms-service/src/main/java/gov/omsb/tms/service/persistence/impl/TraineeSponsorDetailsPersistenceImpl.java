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

import gov.omsb.tms.exception.NoSuchTraineeSponsorDetailsException;
import gov.omsb.tms.model.TraineeSponsorDetails;
import gov.omsb.tms.model.TraineeSponsorDetailsTable;
import gov.omsb.tms.model.impl.TraineeSponsorDetailsImpl;
import gov.omsb.tms.model.impl.TraineeSponsorDetailsModelImpl;
import gov.omsb.tms.service.persistence.TraineeSponsorDetailsPersistence;
import gov.omsb.tms.service.persistence.TraineeSponsorDetailsUtil;
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
 * The persistence implementation for the trainee sponsor details service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = TraineeSponsorDetailsPersistence.class)
public class TraineeSponsorDetailsPersistenceImpl
	extends BasePersistenceImpl<TraineeSponsorDetails>
	implements TraineeSponsorDetailsPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>TraineeSponsorDetailsUtil</code> to access the trainee sponsor details persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		TraineeSponsorDetailsImpl.class.getName();

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
	 * Returns all the trainee sponsor detailses where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching trainee sponsor detailses
	 */
	@Override
	public List<TraineeSponsorDetails> findByUuid(String uuid) {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the trainee sponsor detailses where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TraineeSponsorDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of trainee sponsor detailses
	 * @param end the upper bound of the range of trainee sponsor detailses (not inclusive)
	 * @return the range of matching trainee sponsor detailses
	 */
	@Override
	public List<TraineeSponsorDetails> findByUuid(
		String uuid, int start, int end) {

		return findByUuid(uuid, start, end, null);
	}

	/**
	 * Returns an ordered range of all the trainee sponsor detailses where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TraineeSponsorDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of trainee sponsor detailses
	 * @param end the upper bound of the range of trainee sponsor detailses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching trainee sponsor detailses
	 */
	@Override
	public List<TraineeSponsorDetails> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<TraineeSponsorDetails> orderByComparator) {

		return findByUuid(uuid, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the trainee sponsor detailses where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TraineeSponsorDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of trainee sponsor detailses
	 * @param end the upper bound of the range of trainee sponsor detailses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching trainee sponsor detailses
	 */
	@Override
	public List<TraineeSponsorDetails> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<TraineeSponsorDetails> orderByComparator,
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

		List<TraineeSponsorDetails> list = null;

		if (useFinderCache) {
			list = (List<TraineeSponsorDetails>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (TraineeSponsorDetails traineeSponsorDetails : list) {
					if (!uuid.equals(traineeSponsorDetails.getUuid())) {
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

			sb.append(_SQL_SELECT_TRAINEESPONSORDETAILS_WHERE);

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
				sb.append(TraineeSponsorDetailsModelImpl.ORDER_BY_JPQL);
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

				list = (List<TraineeSponsorDetails>)QueryUtil.list(
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
	 * Returns the first trainee sponsor details in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching trainee sponsor details
	 * @throws NoSuchTraineeSponsorDetailsException if a matching trainee sponsor details could not be found
	 */
	@Override
	public TraineeSponsorDetails findByUuid_First(
			String uuid,
			OrderByComparator<TraineeSponsorDetails> orderByComparator)
		throws NoSuchTraineeSponsorDetailsException {

		TraineeSponsorDetails traineeSponsorDetails = fetchByUuid_First(
			uuid, orderByComparator);

		if (traineeSponsorDetails != null) {
			return traineeSponsorDetails;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchTraineeSponsorDetailsException(sb.toString());
	}

	/**
	 * Returns the first trainee sponsor details in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching trainee sponsor details, or <code>null</code> if a matching trainee sponsor details could not be found
	 */
	@Override
	public TraineeSponsorDetails fetchByUuid_First(
		String uuid,
		OrderByComparator<TraineeSponsorDetails> orderByComparator) {

		List<TraineeSponsorDetails> list = findByUuid(
			uuid, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last trainee sponsor details in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching trainee sponsor details
	 * @throws NoSuchTraineeSponsorDetailsException if a matching trainee sponsor details could not be found
	 */
	@Override
	public TraineeSponsorDetails findByUuid_Last(
			String uuid,
			OrderByComparator<TraineeSponsorDetails> orderByComparator)
		throws NoSuchTraineeSponsorDetailsException {

		TraineeSponsorDetails traineeSponsorDetails = fetchByUuid_Last(
			uuid, orderByComparator);

		if (traineeSponsorDetails != null) {
			return traineeSponsorDetails;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchTraineeSponsorDetailsException(sb.toString());
	}

	/**
	 * Returns the last trainee sponsor details in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching trainee sponsor details, or <code>null</code> if a matching trainee sponsor details could not be found
	 */
	@Override
	public TraineeSponsorDetails fetchByUuid_Last(
		String uuid,
		OrderByComparator<TraineeSponsorDetails> orderByComparator) {

		int count = countByUuid(uuid);

		if (count == 0) {
			return null;
		}

		List<TraineeSponsorDetails> list = findByUuid(
			uuid, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the trainee sponsor detailses before and after the current trainee sponsor details in the ordered set where uuid = &#63;.
	 *
	 * @param traineeSponsorDetailsId the primary key of the current trainee sponsor details
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next trainee sponsor details
	 * @throws NoSuchTraineeSponsorDetailsException if a trainee sponsor details with the primary key could not be found
	 */
	@Override
	public TraineeSponsorDetails[] findByUuid_PrevAndNext(
			long traineeSponsorDetailsId, String uuid,
			OrderByComparator<TraineeSponsorDetails> orderByComparator)
		throws NoSuchTraineeSponsorDetailsException {

		uuid = Objects.toString(uuid, "");

		TraineeSponsorDetails traineeSponsorDetails = findByPrimaryKey(
			traineeSponsorDetailsId);

		Session session = null;

		try {
			session = openSession();

			TraineeSponsorDetails[] array = new TraineeSponsorDetailsImpl[3];

			array[0] = getByUuid_PrevAndNext(
				session, traineeSponsorDetails, uuid, orderByComparator, true);

			array[1] = traineeSponsorDetails;

			array[2] = getByUuid_PrevAndNext(
				session, traineeSponsorDetails, uuid, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected TraineeSponsorDetails getByUuid_PrevAndNext(
		Session session, TraineeSponsorDetails traineeSponsorDetails,
		String uuid, OrderByComparator<TraineeSponsorDetails> orderByComparator,
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

		sb.append(_SQL_SELECT_TRAINEESPONSORDETAILS_WHERE);

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
			sb.append(TraineeSponsorDetailsModelImpl.ORDER_BY_JPQL);
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
						traineeSponsorDetails)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<TraineeSponsorDetails> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the trainee sponsor detailses where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	@Override
	public void removeByUuid(String uuid) {
		for (TraineeSponsorDetails traineeSponsorDetails :
				findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(traineeSponsorDetails);
		}
	}

	/**
	 * Returns the number of trainee sponsor detailses where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching trainee sponsor detailses
	 */
	@Override
	public int countByUuid(String uuid) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid;

		Object[] finderArgs = new Object[] {uuid};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_TRAINEESPONSORDETAILS_WHERE);

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
		"traineeSponsorDetails.uuid = ?";

	private static final String _FINDER_COLUMN_UUID_UUID_3 =
		"(traineeSponsorDetails.uuid IS NULL OR traineeSponsorDetails.uuid = '')";

	private FinderPath _finderPathFetchByUUID_G;
	private FinderPath _finderPathCountByUUID_G;

	/**
	 * Returns the trainee sponsor details where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchTraineeSponsorDetailsException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching trainee sponsor details
	 * @throws NoSuchTraineeSponsorDetailsException if a matching trainee sponsor details could not be found
	 */
	@Override
	public TraineeSponsorDetails findByUUID_G(String uuid, long groupId)
		throws NoSuchTraineeSponsorDetailsException {

		TraineeSponsorDetails traineeSponsorDetails = fetchByUUID_G(
			uuid, groupId);

		if (traineeSponsorDetails == null) {
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

			throw new NoSuchTraineeSponsorDetailsException(sb.toString());
		}

		return traineeSponsorDetails;
	}

	/**
	 * Returns the trainee sponsor details where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching trainee sponsor details, or <code>null</code> if a matching trainee sponsor details could not be found
	 */
	@Override
	public TraineeSponsorDetails fetchByUUID_G(String uuid, long groupId) {
		return fetchByUUID_G(uuid, groupId, true);
	}

	/**
	 * Returns the trainee sponsor details where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching trainee sponsor details, or <code>null</code> if a matching trainee sponsor details could not be found
	 */
	@Override
	public TraineeSponsorDetails fetchByUUID_G(
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

		if (result instanceof TraineeSponsorDetails) {
			TraineeSponsorDetails traineeSponsorDetails =
				(TraineeSponsorDetails)result;

			if (!Objects.equals(uuid, traineeSponsorDetails.getUuid()) ||
				(groupId != traineeSponsorDetails.getGroupId())) {

				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_SQL_SELECT_TRAINEESPONSORDETAILS_WHERE);

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

				List<TraineeSponsorDetails> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchByUUID_G, finderArgs, list);
					}
				}
				else {
					TraineeSponsorDetails traineeSponsorDetails = list.get(0);

					result = traineeSponsorDetails;

					cacheResult(traineeSponsorDetails);
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
			return (TraineeSponsorDetails)result;
		}
	}

	/**
	 * Removes the trainee sponsor details where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the trainee sponsor details that was removed
	 */
	@Override
	public TraineeSponsorDetails removeByUUID_G(String uuid, long groupId)
		throws NoSuchTraineeSponsorDetailsException {

		TraineeSponsorDetails traineeSponsorDetails = findByUUID_G(
			uuid, groupId);

		return remove(traineeSponsorDetails);
	}

	/**
	 * Returns the number of trainee sponsor detailses where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching trainee sponsor detailses
	 */
	@Override
	public int countByUUID_G(String uuid, long groupId) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUUID_G;

		Object[] finderArgs = new Object[] {uuid, groupId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_TRAINEESPONSORDETAILS_WHERE);

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
		"traineeSponsorDetails.uuid = ? AND ";

	private static final String _FINDER_COLUMN_UUID_G_UUID_3 =
		"(traineeSponsorDetails.uuid IS NULL OR traineeSponsorDetails.uuid = '') AND ";

	private static final String _FINDER_COLUMN_UUID_G_GROUPID_2 =
		"traineeSponsorDetails.groupId = ?";

	private FinderPath _finderPathWithPaginationFindByUuid_C;
	private FinderPath _finderPathWithoutPaginationFindByUuid_C;
	private FinderPath _finderPathCountByUuid_C;

	/**
	 * Returns all the trainee sponsor detailses where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching trainee sponsor detailses
	 */
	@Override
	public List<TraineeSponsorDetails> findByUuid_C(
		String uuid, long companyId) {

		return findByUuid_C(
			uuid, companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the trainee sponsor detailses where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TraineeSponsorDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of trainee sponsor detailses
	 * @param end the upper bound of the range of trainee sponsor detailses (not inclusive)
	 * @return the range of matching trainee sponsor detailses
	 */
	@Override
	public List<TraineeSponsorDetails> findByUuid_C(
		String uuid, long companyId, int start, int end) {

		return findByUuid_C(uuid, companyId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the trainee sponsor detailses where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TraineeSponsorDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of trainee sponsor detailses
	 * @param end the upper bound of the range of trainee sponsor detailses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching trainee sponsor detailses
	 */
	@Override
	public List<TraineeSponsorDetails> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<TraineeSponsorDetails> orderByComparator) {

		return findByUuid_C(
			uuid, companyId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the trainee sponsor detailses where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TraineeSponsorDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of trainee sponsor detailses
	 * @param end the upper bound of the range of trainee sponsor detailses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching trainee sponsor detailses
	 */
	@Override
	public List<TraineeSponsorDetails> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<TraineeSponsorDetails> orderByComparator,
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

		List<TraineeSponsorDetails> list = null;

		if (useFinderCache) {
			list = (List<TraineeSponsorDetails>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (TraineeSponsorDetails traineeSponsorDetails : list) {
					if (!uuid.equals(traineeSponsorDetails.getUuid()) ||
						(companyId != traineeSponsorDetails.getCompanyId())) {

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

			sb.append(_SQL_SELECT_TRAINEESPONSORDETAILS_WHERE);

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
				sb.append(TraineeSponsorDetailsModelImpl.ORDER_BY_JPQL);
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

				list = (List<TraineeSponsorDetails>)QueryUtil.list(
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
	 * Returns the first trainee sponsor details in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching trainee sponsor details
	 * @throws NoSuchTraineeSponsorDetailsException if a matching trainee sponsor details could not be found
	 */
	@Override
	public TraineeSponsorDetails findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<TraineeSponsorDetails> orderByComparator)
		throws NoSuchTraineeSponsorDetailsException {

		TraineeSponsorDetails traineeSponsorDetails = fetchByUuid_C_First(
			uuid, companyId, orderByComparator);

		if (traineeSponsorDetails != null) {
			return traineeSponsorDetails;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append(", companyId=");
		sb.append(companyId);

		sb.append("}");

		throw new NoSuchTraineeSponsorDetailsException(sb.toString());
	}

	/**
	 * Returns the first trainee sponsor details in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching trainee sponsor details, or <code>null</code> if a matching trainee sponsor details could not be found
	 */
	@Override
	public TraineeSponsorDetails fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<TraineeSponsorDetails> orderByComparator) {

		List<TraineeSponsorDetails> list = findByUuid_C(
			uuid, companyId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last trainee sponsor details in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching trainee sponsor details
	 * @throws NoSuchTraineeSponsorDetailsException if a matching trainee sponsor details could not be found
	 */
	@Override
	public TraineeSponsorDetails findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<TraineeSponsorDetails> orderByComparator)
		throws NoSuchTraineeSponsorDetailsException {

		TraineeSponsorDetails traineeSponsorDetails = fetchByUuid_C_Last(
			uuid, companyId, orderByComparator);

		if (traineeSponsorDetails != null) {
			return traineeSponsorDetails;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append(", companyId=");
		sb.append(companyId);

		sb.append("}");

		throw new NoSuchTraineeSponsorDetailsException(sb.toString());
	}

	/**
	 * Returns the last trainee sponsor details in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching trainee sponsor details, or <code>null</code> if a matching trainee sponsor details could not be found
	 */
	@Override
	public TraineeSponsorDetails fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<TraineeSponsorDetails> orderByComparator) {

		int count = countByUuid_C(uuid, companyId);

		if (count == 0) {
			return null;
		}

		List<TraineeSponsorDetails> list = findByUuid_C(
			uuid, companyId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the trainee sponsor detailses before and after the current trainee sponsor details in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param traineeSponsorDetailsId the primary key of the current trainee sponsor details
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next trainee sponsor details
	 * @throws NoSuchTraineeSponsorDetailsException if a trainee sponsor details with the primary key could not be found
	 */
	@Override
	public TraineeSponsorDetails[] findByUuid_C_PrevAndNext(
			long traineeSponsorDetailsId, String uuid, long companyId,
			OrderByComparator<TraineeSponsorDetails> orderByComparator)
		throws NoSuchTraineeSponsorDetailsException {

		uuid = Objects.toString(uuid, "");

		TraineeSponsorDetails traineeSponsorDetails = findByPrimaryKey(
			traineeSponsorDetailsId);

		Session session = null;

		try {
			session = openSession();

			TraineeSponsorDetails[] array = new TraineeSponsorDetailsImpl[3];

			array[0] = getByUuid_C_PrevAndNext(
				session, traineeSponsorDetails, uuid, companyId,
				orderByComparator, true);

			array[1] = traineeSponsorDetails;

			array[2] = getByUuid_C_PrevAndNext(
				session, traineeSponsorDetails, uuid, companyId,
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

	protected TraineeSponsorDetails getByUuid_C_PrevAndNext(
		Session session, TraineeSponsorDetails traineeSponsorDetails,
		String uuid, long companyId,
		OrderByComparator<TraineeSponsorDetails> orderByComparator,
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

		sb.append(_SQL_SELECT_TRAINEESPONSORDETAILS_WHERE);

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
			sb.append(TraineeSponsorDetailsModelImpl.ORDER_BY_JPQL);
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
						traineeSponsorDetails)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<TraineeSponsorDetails> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the trainee sponsor detailses where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	@Override
	public void removeByUuid_C(String uuid, long companyId) {
		for (TraineeSponsorDetails traineeSponsorDetails :
				findByUuid_C(
					uuid, companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(traineeSponsorDetails);
		}
	}

	/**
	 * Returns the number of trainee sponsor detailses where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching trainee sponsor detailses
	 */
	@Override
	public int countByUuid_C(String uuid, long companyId) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid_C;

		Object[] finderArgs = new Object[] {uuid, companyId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_TRAINEESPONSORDETAILS_WHERE);

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
		"traineeSponsorDetails.uuid = ? AND ";

	private static final String _FINDER_COLUMN_UUID_C_UUID_3 =
		"(traineeSponsorDetails.uuid IS NULL OR traineeSponsorDetails.uuid = '') AND ";

	private static final String _FINDER_COLUMN_UUID_C_COMPANYID_2 =
		"traineeSponsorDetails.companyId = ?";

	private FinderPath _finderPathFetchBytraineeId;
	private FinderPath _finderPathCountBytraineeId;

	/**
	 * Returns the trainee sponsor details where traineeId = &#63; or throws a <code>NoSuchTraineeSponsorDetailsException</code> if it could not be found.
	 *
	 * @param traineeId the trainee ID
	 * @return the matching trainee sponsor details
	 * @throws NoSuchTraineeSponsorDetailsException if a matching trainee sponsor details could not be found
	 */
	@Override
	public TraineeSponsorDetails findBytraineeId(long traineeId)
		throws NoSuchTraineeSponsorDetailsException {

		TraineeSponsorDetails traineeSponsorDetails = fetchBytraineeId(
			traineeId);

		if (traineeSponsorDetails == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_NO_SUCH_ENTITY_WITH_KEY);

			sb.append("traineeId=");
			sb.append(traineeId);

			sb.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(sb.toString());
			}

			throw new NoSuchTraineeSponsorDetailsException(sb.toString());
		}

		return traineeSponsorDetails;
	}

	/**
	 * Returns the trainee sponsor details where traineeId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param traineeId the trainee ID
	 * @return the matching trainee sponsor details, or <code>null</code> if a matching trainee sponsor details could not be found
	 */
	@Override
	public TraineeSponsorDetails fetchBytraineeId(long traineeId) {
		return fetchBytraineeId(traineeId, true);
	}

	/**
	 * Returns the trainee sponsor details where traineeId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param traineeId the trainee ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching trainee sponsor details, or <code>null</code> if a matching trainee sponsor details could not be found
	 */
	@Override
	public TraineeSponsorDetails fetchBytraineeId(
		long traineeId, boolean useFinderCache) {

		Object[] finderArgs = null;

		if (useFinderCache) {
			finderArgs = new Object[] {traineeId};
		}

		Object result = null;

		if (useFinderCache) {
			result = finderCache.getResult(
				_finderPathFetchBytraineeId, finderArgs, this);
		}

		if (result instanceof TraineeSponsorDetails) {
			TraineeSponsorDetails traineeSponsorDetails =
				(TraineeSponsorDetails)result;

			if (traineeId != traineeSponsorDetails.getTraineeId()) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_SELECT_TRAINEESPONSORDETAILS_WHERE);

			sb.append(_FINDER_COLUMN_TRAINEEID_TRAINEEID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(traineeId);

				List<TraineeSponsorDetails> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchBytraineeId, finderArgs, list);
					}
				}
				else {
					if (list.size() > 1) {
						Collections.sort(list, Collections.reverseOrder());

						if (_log.isWarnEnabled()) {
							if (!useFinderCache) {
								finderArgs = new Object[] {traineeId};
							}

							_log.warn(
								"TraineeSponsorDetailsPersistenceImpl.fetchBytraineeId(long, boolean) with parameters (" +
									StringUtil.merge(finderArgs) +
										") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
						}
					}

					TraineeSponsorDetails traineeSponsorDetails = list.get(0);

					result = traineeSponsorDetails;

					cacheResult(traineeSponsorDetails);
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
			return (TraineeSponsorDetails)result;
		}
	}

	/**
	 * Removes the trainee sponsor details where traineeId = &#63; from the database.
	 *
	 * @param traineeId the trainee ID
	 * @return the trainee sponsor details that was removed
	 */
	@Override
	public TraineeSponsorDetails removeBytraineeId(long traineeId)
		throws NoSuchTraineeSponsorDetailsException {

		TraineeSponsorDetails traineeSponsorDetails = findBytraineeId(
			traineeId);

		return remove(traineeSponsorDetails);
	}

	/**
	 * Returns the number of trainee sponsor detailses where traineeId = &#63;.
	 *
	 * @param traineeId the trainee ID
	 * @return the number of matching trainee sponsor detailses
	 */
	@Override
	public int countBytraineeId(long traineeId) {
		FinderPath finderPath = _finderPathCountBytraineeId;

		Object[] finderArgs = new Object[] {traineeId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_TRAINEESPONSORDETAILS_WHERE);

			sb.append(_FINDER_COLUMN_TRAINEEID_TRAINEEID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(traineeId);

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

	private static final String _FINDER_COLUMN_TRAINEEID_TRAINEEID_2 =
		"traineeSponsorDetails.traineeId = ?";

	public TraineeSponsorDetailsPersistenceImpl() {
		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("uuid", "uuid_");
		dbColumnNames.put(
			"traineeSponsorDetailsId", "trainee_sponsor_details_id");
		dbColumnNames.put("groupId", "group_id");
		dbColumnNames.put("companyId", "company_id");
		dbColumnNames.put("createdDate", "created_date");
		dbColumnNames.put("createdBy", "created_by");
		dbColumnNames.put("modifiedDate", "modified_date");
		dbColumnNames.put("modifiedBy", "modified_by");
		dbColumnNames.put("traineeId", "trainee_id");
		dbColumnNames.put("programDurationId", "program_duration_Id");

		setDBColumnNames(dbColumnNames);

		setModelClass(TraineeSponsorDetails.class);

		setModelImplClass(TraineeSponsorDetailsImpl.class);
		setModelPKClass(long.class);

		setTable(TraineeSponsorDetailsTable.INSTANCE);
	}

	/**
	 * Caches the trainee sponsor details in the entity cache if it is enabled.
	 *
	 * @param traineeSponsorDetails the trainee sponsor details
	 */
	@Override
	public void cacheResult(TraineeSponsorDetails traineeSponsorDetails) {
		entityCache.putResult(
			TraineeSponsorDetailsImpl.class,
			traineeSponsorDetails.getPrimaryKey(), traineeSponsorDetails);

		finderCache.putResult(
			_finderPathFetchByUUID_G,
			new Object[] {
				traineeSponsorDetails.getUuid(),
				traineeSponsorDetails.getGroupId()
			},
			traineeSponsorDetails);

		finderCache.putResult(
			_finderPathFetchBytraineeId,
			new Object[] {traineeSponsorDetails.getTraineeId()},
			traineeSponsorDetails);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the trainee sponsor detailses in the entity cache if it is enabled.
	 *
	 * @param traineeSponsorDetailses the trainee sponsor detailses
	 */
	@Override
	public void cacheResult(
		List<TraineeSponsorDetails> traineeSponsorDetailses) {

		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (traineeSponsorDetailses.size() >
				 _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (TraineeSponsorDetails traineeSponsorDetails :
				traineeSponsorDetailses) {

			if (entityCache.getResult(
					TraineeSponsorDetailsImpl.class,
					traineeSponsorDetails.getPrimaryKey()) == null) {

				cacheResult(traineeSponsorDetails);
			}
		}
	}

	/**
	 * Clears the cache for all trainee sponsor detailses.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(TraineeSponsorDetailsImpl.class);

		finderCache.clearCache(TraineeSponsorDetailsImpl.class);
	}

	/**
	 * Clears the cache for the trainee sponsor details.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(TraineeSponsorDetails traineeSponsorDetails) {
		entityCache.removeResult(
			TraineeSponsorDetailsImpl.class, traineeSponsorDetails);
	}

	@Override
	public void clearCache(
		List<TraineeSponsorDetails> traineeSponsorDetailses) {

		for (TraineeSponsorDetails traineeSponsorDetails :
				traineeSponsorDetailses) {

			entityCache.removeResult(
				TraineeSponsorDetailsImpl.class, traineeSponsorDetails);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(TraineeSponsorDetailsImpl.class);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(
				TraineeSponsorDetailsImpl.class, primaryKey);
		}
	}

	protected void cacheUniqueFindersCache(
		TraineeSponsorDetailsModelImpl traineeSponsorDetailsModelImpl) {

		Object[] args = new Object[] {
			traineeSponsorDetailsModelImpl.getUuid(),
			traineeSponsorDetailsModelImpl.getGroupId()
		};

		finderCache.putResult(_finderPathCountByUUID_G, args, Long.valueOf(1));
		finderCache.putResult(
			_finderPathFetchByUUID_G, args, traineeSponsorDetailsModelImpl);

		args = new Object[] {traineeSponsorDetailsModelImpl.getTraineeId()};

		finderCache.putResult(
			_finderPathCountBytraineeId, args, Long.valueOf(1));
		finderCache.putResult(
			_finderPathFetchBytraineeId, args, traineeSponsorDetailsModelImpl);
	}

	/**
	 * Creates a new trainee sponsor details with the primary key. Does not add the trainee sponsor details to the database.
	 *
	 * @param traineeSponsorDetailsId the primary key for the new trainee sponsor details
	 * @return the new trainee sponsor details
	 */
	@Override
	public TraineeSponsorDetails create(long traineeSponsorDetailsId) {
		TraineeSponsorDetails traineeSponsorDetails =
			new TraineeSponsorDetailsImpl();

		traineeSponsorDetails.setNew(true);
		traineeSponsorDetails.setPrimaryKey(traineeSponsorDetailsId);

		String uuid = _portalUUID.generate();

		traineeSponsorDetails.setUuid(uuid);

		traineeSponsorDetails.setCompanyId(CompanyThreadLocal.getCompanyId());

		return traineeSponsorDetails;
	}

	/**
	 * Removes the trainee sponsor details with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param traineeSponsorDetailsId the primary key of the trainee sponsor details
	 * @return the trainee sponsor details that was removed
	 * @throws NoSuchTraineeSponsorDetailsException if a trainee sponsor details with the primary key could not be found
	 */
	@Override
	public TraineeSponsorDetails remove(long traineeSponsorDetailsId)
		throws NoSuchTraineeSponsorDetailsException {

		return remove((Serializable)traineeSponsorDetailsId);
	}

	/**
	 * Removes the trainee sponsor details with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the trainee sponsor details
	 * @return the trainee sponsor details that was removed
	 * @throws NoSuchTraineeSponsorDetailsException if a trainee sponsor details with the primary key could not be found
	 */
	@Override
	public TraineeSponsorDetails remove(Serializable primaryKey)
		throws NoSuchTraineeSponsorDetailsException {

		Session session = null;

		try {
			session = openSession();

			TraineeSponsorDetails traineeSponsorDetails =
				(TraineeSponsorDetails)session.get(
					TraineeSponsorDetailsImpl.class, primaryKey);

			if (traineeSponsorDetails == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchTraineeSponsorDetailsException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(traineeSponsorDetails);
		}
		catch (NoSuchTraineeSponsorDetailsException noSuchEntityException) {
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
	protected TraineeSponsorDetails removeImpl(
		TraineeSponsorDetails traineeSponsorDetails) {

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(traineeSponsorDetails)) {
				traineeSponsorDetails = (TraineeSponsorDetails)session.get(
					TraineeSponsorDetailsImpl.class,
					traineeSponsorDetails.getPrimaryKeyObj());
			}

			if (traineeSponsorDetails != null) {
				session.delete(traineeSponsorDetails);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (traineeSponsorDetails != null) {
			clearCache(traineeSponsorDetails);
		}

		return traineeSponsorDetails;
	}

	@Override
	public TraineeSponsorDetails updateImpl(
		TraineeSponsorDetails traineeSponsorDetails) {

		boolean isNew = traineeSponsorDetails.isNew();

		if (!(traineeSponsorDetails instanceof
				TraineeSponsorDetailsModelImpl)) {

			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(traineeSponsorDetails.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(
					traineeSponsorDetails);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in traineeSponsorDetails proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom TraineeSponsorDetails implementation " +
					traineeSponsorDetails.getClass());
		}

		TraineeSponsorDetailsModelImpl traineeSponsorDetailsModelImpl =
			(TraineeSponsorDetailsModelImpl)traineeSponsorDetails;

		if (Validator.isNull(traineeSponsorDetails.getUuid())) {
			String uuid = _portalUUID.generate();

			traineeSponsorDetails.setUuid(uuid);
		}

		if (!traineeSponsorDetailsModelImpl.hasSetModifiedDate()) {
			ServiceContext serviceContext =
				ServiceContextThreadLocal.getServiceContext();

			Date date = new Date();

			if (serviceContext == null) {
				traineeSponsorDetails.setModifiedDate(date);
			}
			else {
				traineeSponsorDetails.setModifiedDate(
					serviceContext.getModifiedDate(date));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(traineeSponsorDetails);
			}
			else {
				traineeSponsorDetails = (TraineeSponsorDetails)session.merge(
					traineeSponsorDetails);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(
			TraineeSponsorDetailsImpl.class, traineeSponsorDetailsModelImpl,
			false, true);

		cacheUniqueFindersCache(traineeSponsorDetailsModelImpl);

		if (isNew) {
			traineeSponsorDetails.setNew(false);
		}

		traineeSponsorDetails.resetOriginalValues();

		return traineeSponsorDetails;
	}

	/**
	 * Returns the trainee sponsor details with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the trainee sponsor details
	 * @return the trainee sponsor details
	 * @throws NoSuchTraineeSponsorDetailsException if a trainee sponsor details with the primary key could not be found
	 */
	@Override
	public TraineeSponsorDetails findByPrimaryKey(Serializable primaryKey)
		throws NoSuchTraineeSponsorDetailsException {

		TraineeSponsorDetails traineeSponsorDetails = fetchByPrimaryKey(
			primaryKey);

		if (traineeSponsorDetails == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchTraineeSponsorDetailsException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return traineeSponsorDetails;
	}

	/**
	 * Returns the trainee sponsor details with the primary key or throws a <code>NoSuchTraineeSponsorDetailsException</code> if it could not be found.
	 *
	 * @param traineeSponsorDetailsId the primary key of the trainee sponsor details
	 * @return the trainee sponsor details
	 * @throws NoSuchTraineeSponsorDetailsException if a trainee sponsor details with the primary key could not be found
	 */
	@Override
	public TraineeSponsorDetails findByPrimaryKey(long traineeSponsorDetailsId)
		throws NoSuchTraineeSponsorDetailsException {

		return findByPrimaryKey((Serializable)traineeSponsorDetailsId);
	}

	/**
	 * Returns the trainee sponsor details with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param traineeSponsorDetailsId the primary key of the trainee sponsor details
	 * @return the trainee sponsor details, or <code>null</code> if a trainee sponsor details with the primary key could not be found
	 */
	@Override
	public TraineeSponsorDetails fetchByPrimaryKey(
		long traineeSponsorDetailsId) {

		return fetchByPrimaryKey((Serializable)traineeSponsorDetailsId);
	}

	/**
	 * Returns all the trainee sponsor detailses.
	 *
	 * @return the trainee sponsor detailses
	 */
	@Override
	public List<TraineeSponsorDetails> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the trainee sponsor detailses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TraineeSponsorDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of trainee sponsor detailses
	 * @param end the upper bound of the range of trainee sponsor detailses (not inclusive)
	 * @return the range of trainee sponsor detailses
	 */
	@Override
	public List<TraineeSponsorDetails> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the trainee sponsor detailses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TraineeSponsorDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of trainee sponsor detailses
	 * @param end the upper bound of the range of trainee sponsor detailses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of trainee sponsor detailses
	 */
	@Override
	public List<TraineeSponsorDetails> findAll(
		int start, int end,
		OrderByComparator<TraineeSponsorDetails> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the trainee sponsor detailses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TraineeSponsorDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of trainee sponsor detailses
	 * @param end the upper bound of the range of trainee sponsor detailses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of trainee sponsor detailses
	 */
	@Override
	public List<TraineeSponsorDetails> findAll(
		int start, int end,
		OrderByComparator<TraineeSponsorDetails> orderByComparator,
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

		List<TraineeSponsorDetails> list = null;

		if (useFinderCache) {
			list = (List<TraineeSponsorDetails>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_TRAINEESPONSORDETAILS);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_TRAINEESPONSORDETAILS;

				sql = sql.concat(TraineeSponsorDetailsModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<TraineeSponsorDetails>)QueryUtil.list(
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
	 * Removes all the trainee sponsor detailses from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (TraineeSponsorDetails traineeSponsorDetails : findAll()) {
			remove(traineeSponsorDetails);
		}
	}

	/**
	 * Returns the number of trainee sponsor detailses.
	 *
	 * @return the number of trainee sponsor detailses
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
					_SQL_COUNT_TRAINEESPONSORDETAILS);

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
		return "trainee_sponsor_details_id";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_TRAINEESPONSORDETAILS;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return TraineeSponsorDetailsModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the trainee sponsor details persistence.
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

		_finderPathFetchBytraineeId = new FinderPath(
			FINDER_CLASS_NAME_ENTITY, "fetchBytraineeId",
			new String[] {Long.class.getName()}, new String[] {"trainee_id"},
			true);

		_finderPathCountBytraineeId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countBytraineeId",
			new String[] {Long.class.getName()}, new String[] {"trainee_id"},
			false);

		_setTraineeSponsorDetailsUtilPersistence(this);
	}

	@Deactivate
	public void deactivate() {
		_setTraineeSponsorDetailsUtilPersistence(null);

		entityCache.removeCache(TraineeSponsorDetailsImpl.class.getName());
	}

	private void _setTraineeSponsorDetailsUtilPersistence(
		TraineeSponsorDetailsPersistence traineeSponsorDetailsPersistence) {

		try {
			Field field = TraineeSponsorDetailsUtil.class.getDeclaredField(
				"_persistence");

			field.setAccessible(true);

			field.set(null, traineeSponsorDetailsPersistence);
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

	private static final String _SQL_SELECT_TRAINEESPONSORDETAILS =
		"SELECT traineeSponsorDetails FROM TraineeSponsorDetails traineeSponsorDetails";

	private static final String _SQL_SELECT_TRAINEESPONSORDETAILS_WHERE =
		"SELECT traineeSponsorDetails FROM TraineeSponsorDetails traineeSponsorDetails WHERE ";

	private static final String _SQL_COUNT_TRAINEESPONSORDETAILS =
		"SELECT COUNT(traineeSponsorDetails) FROM TraineeSponsorDetails traineeSponsorDetails";

	private static final String _SQL_COUNT_TRAINEESPONSORDETAILS_WHERE =
		"SELECT COUNT(traineeSponsorDetails) FROM TraineeSponsorDetails traineeSponsorDetails WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS =
		"traineeSponsorDetails.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No TraineeSponsorDetails exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No TraineeSponsorDetails exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		TraineeSponsorDetailsPersistenceImpl.class);

	private static final Set<String> _badColumnNames = SetUtil.fromArray(
		new String[] {
			"uuid", "traineeSponsorDetailsId", "groupId", "companyId",
			"createdDate", "createdBy", "modifiedDate", "modifiedBy",
			"traineeId", "programDurationId"
		});

	@Override
	protected FinderCache getFinderCache() {
		return finderCache;
	}

	@Reference
	private PortalUUID _portalUUID;

}
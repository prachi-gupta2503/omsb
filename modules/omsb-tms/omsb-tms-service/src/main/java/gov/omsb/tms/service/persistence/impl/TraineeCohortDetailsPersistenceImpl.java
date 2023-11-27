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

import gov.omsb.tms.exception.NoSuchTraineeCohortDetailsException;
import gov.omsb.tms.model.TraineeCohortDetails;
import gov.omsb.tms.model.TraineeCohortDetailsTable;
import gov.omsb.tms.model.impl.TraineeCohortDetailsImpl;
import gov.omsb.tms.model.impl.TraineeCohortDetailsModelImpl;
import gov.omsb.tms.service.persistence.TraineeCohortDetailsPersistence;
import gov.omsb.tms.service.persistence.TraineeCohortDetailsUtil;
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
 * The persistence implementation for the trainee cohort details service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = TraineeCohortDetailsPersistence.class)
public class TraineeCohortDetailsPersistenceImpl
	extends BasePersistenceImpl<TraineeCohortDetails>
	implements TraineeCohortDetailsPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>TraineeCohortDetailsUtil</code> to access the trainee cohort details persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		TraineeCohortDetailsImpl.class.getName();

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
	 * Returns all the trainee cohort detailses where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching trainee cohort detailses
	 */
	@Override
	public List<TraineeCohortDetails> findByUuid(String uuid) {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the trainee cohort detailses where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TraineeCohortDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of trainee cohort detailses
	 * @param end the upper bound of the range of trainee cohort detailses (not inclusive)
	 * @return the range of matching trainee cohort detailses
	 */
	@Override
	public List<TraineeCohortDetails> findByUuid(
		String uuid, int start, int end) {

		return findByUuid(uuid, start, end, null);
	}

	/**
	 * Returns an ordered range of all the trainee cohort detailses where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TraineeCohortDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of trainee cohort detailses
	 * @param end the upper bound of the range of trainee cohort detailses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching trainee cohort detailses
	 */
	@Override
	public List<TraineeCohortDetails> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<TraineeCohortDetails> orderByComparator) {

		return findByUuid(uuid, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the trainee cohort detailses where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TraineeCohortDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of trainee cohort detailses
	 * @param end the upper bound of the range of trainee cohort detailses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching trainee cohort detailses
	 */
	@Override
	public List<TraineeCohortDetails> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<TraineeCohortDetails> orderByComparator,
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

		List<TraineeCohortDetails> list = null;

		if (useFinderCache) {
			list = (List<TraineeCohortDetails>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (TraineeCohortDetails traineeCohortDetails : list) {
					if (!uuid.equals(traineeCohortDetails.getUuid())) {
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

			sb.append(_SQL_SELECT_TRAINEECOHORTDETAILS_WHERE);

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
				sb.append(TraineeCohortDetailsModelImpl.ORDER_BY_JPQL);
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

				list = (List<TraineeCohortDetails>)QueryUtil.list(
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
	 * Returns the first trainee cohort details in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching trainee cohort details
	 * @throws NoSuchTraineeCohortDetailsException if a matching trainee cohort details could not be found
	 */
	@Override
	public TraineeCohortDetails findByUuid_First(
			String uuid,
			OrderByComparator<TraineeCohortDetails> orderByComparator)
		throws NoSuchTraineeCohortDetailsException {

		TraineeCohortDetails traineeCohortDetails = fetchByUuid_First(
			uuid, orderByComparator);

		if (traineeCohortDetails != null) {
			return traineeCohortDetails;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchTraineeCohortDetailsException(sb.toString());
	}

	/**
	 * Returns the first trainee cohort details in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching trainee cohort details, or <code>null</code> if a matching trainee cohort details could not be found
	 */
	@Override
	public TraineeCohortDetails fetchByUuid_First(
		String uuid,
		OrderByComparator<TraineeCohortDetails> orderByComparator) {

		List<TraineeCohortDetails> list = findByUuid(
			uuid, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last trainee cohort details in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching trainee cohort details
	 * @throws NoSuchTraineeCohortDetailsException if a matching trainee cohort details could not be found
	 */
	@Override
	public TraineeCohortDetails findByUuid_Last(
			String uuid,
			OrderByComparator<TraineeCohortDetails> orderByComparator)
		throws NoSuchTraineeCohortDetailsException {

		TraineeCohortDetails traineeCohortDetails = fetchByUuid_Last(
			uuid, orderByComparator);

		if (traineeCohortDetails != null) {
			return traineeCohortDetails;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchTraineeCohortDetailsException(sb.toString());
	}

	/**
	 * Returns the last trainee cohort details in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching trainee cohort details, or <code>null</code> if a matching trainee cohort details could not be found
	 */
	@Override
	public TraineeCohortDetails fetchByUuid_Last(
		String uuid,
		OrderByComparator<TraineeCohortDetails> orderByComparator) {

		int count = countByUuid(uuid);

		if (count == 0) {
			return null;
		}

		List<TraineeCohortDetails> list = findByUuid(
			uuid, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the trainee cohort detailses before and after the current trainee cohort details in the ordered set where uuid = &#63;.
	 *
	 * @param traineeCohortDetailsId the primary key of the current trainee cohort details
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next trainee cohort details
	 * @throws NoSuchTraineeCohortDetailsException if a trainee cohort details with the primary key could not be found
	 */
	@Override
	public TraineeCohortDetails[] findByUuid_PrevAndNext(
			long traineeCohortDetailsId, String uuid,
			OrderByComparator<TraineeCohortDetails> orderByComparator)
		throws NoSuchTraineeCohortDetailsException {

		uuid = Objects.toString(uuid, "");

		TraineeCohortDetails traineeCohortDetails = findByPrimaryKey(
			traineeCohortDetailsId);

		Session session = null;

		try {
			session = openSession();

			TraineeCohortDetails[] array = new TraineeCohortDetailsImpl[3];

			array[0] = getByUuid_PrevAndNext(
				session, traineeCohortDetails, uuid, orderByComparator, true);

			array[1] = traineeCohortDetails;

			array[2] = getByUuid_PrevAndNext(
				session, traineeCohortDetails, uuid, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected TraineeCohortDetails getByUuid_PrevAndNext(
		Session session, TraineeCohortDetails traineeCohortDetails, String uuid,
		OrderByComparator<TraineeCohortDetails> orderByComparator,
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

		sb.append(_SQL_SELECT_TRAINEECOHORTDETAILS_WHERE);

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
			sb.append(TraineeCohortDetailsModelImpl.ORDER_BY_JPQL);
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
						traineeCohortDetails)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<TraineeCohortDetails> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the trainee cohort detailses where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	@Override
	public void removeByUuid(String uuid) {
		for (TraineeCohortDetails traineeCohortDetails :
				findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(traineeCohortDetails);
		}
	}

	/**
	 * Returns the number of trainee cohort detailses where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching trainee cohort detailses
	 */
	@Override
	public int countByUuid(String uuid) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid;

		Object[] finderArgs = new Object[] {uuid};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_TRAINEECOHORTDETAILS_WHERE);

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
		"traineeCohortDetails.uuid = ?";

	private static final String _FINDER_COLUMN_UUID_UUID_3 =
		"(traineeCohortDetails.uuid IS NULL OR traineeCohortDetails.uuid = '')";

	private FinderPath _finderPathFetchByUUID_G;
	private FinderPath _finderPathCountByUUID_G;

	/**
	 * Returns the trainee cohort details where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchTraineeCohortDetailsException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching trainee cohort details
	 * @throws NoSuchTraineeCohortDetailsException if a matching trainee cohort details could not be found
	 */
	@Override
	public TraineeCohortDetails findByUUID_G(String uuid, long groupId)
		throws NoSuchTraineeCohortDetailsException {

		TraineeCohortDetails traineeCohortDetails = fetchByUUID_G(
			uuid, groupId);

		if (traineeCohortDetails == null) {
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

			throw new NoSuchTraineeCohortDetailsException(sb.toString());
		}

		return traineeCohortDetails;
	}

	/**
	 * Returns the trainee cohort details where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching trainee cohort details, or <code>null</code> if a matching trainee cohort details could not be found
	 */
	@Override
	public TraineeCohortDetails fetchByUUID_G(String uuid, long groupId) {
		return fetchByUUID_G(uuid, groupId, true);
	}

	/**
	 * Returns the trainee cohort details where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching trainee cohort details, or <code>null</code> if a matching trainee cohort details could not be found
	 */
	@Override
	public TraineeCohortDetails fetchByUUID_G(
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

		if (result instanceof TraineeCohortDetails) {
			TraineeCohortDetails traineeCohortDetails =
				(TraineeCohortDetails)result;

			if (!Objects.equals(uuid, traineeCohortDetails.getUuid()) ||
				(groupId != traineeCohortDetails.getGroupId())) {

				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_SQL_SELECT_TRAINEECOHORTDETAILS_WHERE);

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

				List<TraineeCohortDetails> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchByUUID_G, finderArgs, list);
					}
				}
				else {
					TraineeCohortDetails traineeCohortDetails = list.get(0);

					result = traineeCohortDetails;

					cacheResult(traineeCohortDetails);
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
			return (TraineeCohortDetails)result;
		}
	}

	/**
	 * Removes the trainee cohort details where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the trainee cohort details that was removed
	 */
	@Override
	public TraineeCohortDetails removeByUUID_G(String uuid, long groupId)
		throws NoSuchTraineeCohortDetailsException {

		TraineeCohortDetails traineeCohortDetails = findByUUID_G(uuid, groupId);

		return remove(traineeCohortDetails);
	}

	/**
	 * Returns the number of trainee cohort detailses where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching trainee cohort detailses
	 */
	@Override
	public int countByUUID_G(String uuid, long groupId) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUUID_G;

		Object[] finderArgs = new Object[] {uuid, groupId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_TRAINEECOHORTDETAILS_WHERE);

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
		"traineeCohortDetails.uuid = ? AND ";

	private static final String _FINDER_COLUMN_UUID_G_UUID_3 =
		"(traineeCohortDetails.uuid IS NULL OR traineeCohortDetails.uuid = '') AND ";

	private static final String _FINDER_COLUMN_UUID_G_GROUPID_2 =
		"traineeCohortDetails.groupId = ?";

	private FinderPath _finderPathWithPaginationFindByUuid_C;
	private FinderPath _finderPathWithoutPaginationFindByUuid_C;
	private FinderPath _finderPathCountByUuid_C;

	/**
	 * Returns all the trainee cohort detailses where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching trainee cohort detailses
	 */
	@Override
	public List<TraineeCohortDetails> findByUuid_C(
		String uuid, long companyId) {

		return findByUuid_C(
			uuid, companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the trainee cohort detailses where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TraineeCohortDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of trainee cohort detailses
	 * @param end the upper bound of the range of trainee cohort detailses (not inclusive)
	 * @return the range of matching trainee cohort detailses
	 */
	@Override
	public List<TraineeCohortDetails> findByUuid_C(
		String uuid, long companyId, int start, int end) {

		return findByUuid_C(uuid, companyId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the trainee cohort detailses where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TraineeCohortDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of trainee cohort detailses
	 * @param end the upper bound of the range of trainee cohort detailses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching trainee cohort detailses
	 */
	@Override
	public List<TraineeCohortDetails> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<TraineeCohortDetails> orderByComparator) {

		return findByUuid_C(
			uuid, companyId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the trainee cohort detailses where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TraineeCohortDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of trainee cohort detailses
	 * @param end the upper bound of the range of trainee cohort detailses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching trainee cohort detailses
	 */
	@Override
	public List<TraineeCohortDetails> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<TraineeCohortDetails> orderByComparator,
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

		List<TraineeCohortDetails> list = null;

		if (useFinderCache) {
			list = (List<TraineeCohortDetails>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (TraineeCohortDetails traineeCohortDetails : list) {
					if (!uuid.equals(traineeCohortDetails.getUuid()) ||
						(companyId != traineeCohortDetails.getCompanyId())) {

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

			sb.append(_SQL_SELECT_TRAINEECOHORTDETAILS_WHERE);

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
				sb.append(TraineeCohortDetailsModelImpl.ORDER_BY_JPQL);
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

				list = (List<TraineeCohortDetails>)QueryUtil.list(
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
	 * Returns the first trainee cohort details in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching trainee cohort details
	 * @throws NoSuchTraineeCohortDetailsException if a matching trainee cohort details could not be found
	 */
	@Override
	public TraineeCohortDetails findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<TraineeCohortDetails> orderByComparator)
		throws NoSuchTraineeCohortDetailsException {

		TraineeCohortDetails traineeCohortDetails = fetchByUuid_C_First(
			uuid, companyId, orderByComparator);

		if (traineeCohortDetails != null) {
			return traineeCohortDetails;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append(", companyId=");
		sb.append(companyId);

		sb.append("}");

		throw new NoSuchTraineeCohortDetailsException(sb.toString());
	}

	/**
	 * Returns the first trainee cohort details in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching trainee cohort details, or <code>null</code> if a matching trainee cohort details could not be found
	 */
	@Override
	public TraineeCohortDetails fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<TraineeCohortDetails> orderByComparator) {

		List<TraineeCohortDetails> list = findByUuid_C(
			uuid, companyId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last trainee cohort details in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching trainee cohort details
	 * @throws NoSuchTraineeCohortDetailsException if a matching trainee cohort details could not be found
	 */
	@Override
	public TraineeCohortDetails findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<TraineeCohortDetails> orderByComparator)
		throws NoSuchTraineeCohortDetailsException {

		TraineeCohortDetails traineeCohortDetails = fetchByUuid_C_Last(
			uuid, companyId, orderByComparator);

		if (traineeCohortDetails != null) {
			return traineeCohortDetails;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append(", companyId=");
		sb.append(companyId);

		sb.append("}");

		throw new NoSuchTraineeCohortDetailsException(sb.toString());
	}

	/**
	 * Returns the last trainee cohort details in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching trainee cohort details, or <code>null</code> if a matching trainee cohort details could not be found
	 */
	@Override
	public TraineeCohortDetails fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<TraineeCohortDetails> orderByComparator) {

		int count = countByUuid_C(uuid, companyId);

		if (count == 0) {
			return null;
		}

		List<TraineeCohortDetails> list = findByUuid_C(
			uuid, companyId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the trainee cohort detailses before and after the current trainee cohort details in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param traineeCohortDetailsId the primary key of the current trainee cohort details
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next trainee cohort details
	 * @throws NoSuchTraineeCohortDetailsException if a trainee cohort details with the primary key could not be found
	 */
	@Override
	public TraineeCohortDetails[] findByUuid_C_PrevAndNext(
			long traineeCohortDetailsId, String uuid, long companyId,
			OrderByComparator<TraineeCohortDetails> orderByComparator)
		throws NoSuchTraineeCohortDetailsException {

		uuid = Objects.toString(uuid, "");

		TraineeCohortDetails traineeCohortDetails = findByPrimaryKey(
			traineeCohortDetailsId);

		Session session = null;

		try {
			session = openSession();

			TraineeCohortDetails[] array = new TraineeCohortDetailsImpl[3];

			array[0] = getByUuid_C_PrevAndNext(
				session, traineeCohortDetails, uuid, companyId,
				orderByComparator, true);

			array[1] = traineeCohortDetails;

			array[2] = getByUuid_C_PrevAndNext(
				session, traineeCohortDetails, uuid, companyId,
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

	protected TraineeCohortDetails getByUuid_C_PrevAndNext(
		Session session, TraineeCohortDetails traineeCohortDetails, String uuid,
		long companyId,
		OrderByComparator<TraineeCohortDetails> orderByComparator,
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

		sb.append(_SQL_SELECT_TRAINEECOHORTDETAILS_WHERE);

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
			sb.append(TraineeCohortDetailsModelImpl.ORDER_BY_JPQL);
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
						traineeCohortDetails)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<TraineeCohortDetails> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the trainee cohort detailses where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	@Override
	public void removeByUuid_C(String uuid, long companyId) {
		for (TraineeCohortDetails traineeCohortDetails :
				findByUuid_C(
					uuid, companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(traineeCohortDetails);
		}
	}

	/**
	 * Returns the number of trainee cohort detailses where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching trainee cohort detailses
	 */
	@Override
	public int countByUuid_C(String uuid, long companyId) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid_C;

		Object[] finderArgs = new Object[] {uuid, companyId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_TRAINEECOHORTDETAILS_WHERE);

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
		"traineeCohortDetails.uuid = ? AND ";

	private static final String _FINDER_COLUMN_UUID_C_UUID_3 =
		"(traineeCohortDetails.uuid IS NULL OR traineeCohortDetails.uuid = '') AND ";

	private static final String _FINDER_COLUMN_UUID_C_COMPANYID_2 =
		"traineeCohortDetails.companyId = ?";

	private FinderPath
		_finderPathWithPaginationFindByTraineeAdmissionDetailsRelIdAndCohortYearAndTraineeLevelId;
	private FinderPath
		_finderPathWithoutPaginationFindByTraineeAdmissionDetailsRelIdAndCohortYearAndTraineeLevelId;
	private FinderPath
		_finderPathCountByTraineeAdmissionDetailsRelIdAndCohortYearAndTraineeLevelId;

	/**
	 * Returns all the trainee cohort detailses where traineeAdmissionDetailsRelId = &#63; and cohortYear = &#63; and traineeLevelId = &#63;.
	 *
	 * @param traineeAdmissionDetailsRelId the trainee admission details rel ID
	 * @param cohortYear the cohort year
	 * @param traineeLevelId the trainee level ID
	 * @return the matching trainee cohort detailses
	 */
	@Override
	public List<TraineeCohortDetails>
		findByTraineeAdmissionDetailsRelIdAndCohortYearAndTraineeLevelId(
			long traineeAdmissionDetailsRelId, String cohortYear,
			long traineeLevelId) {

		return findByTraineeAdmissionDetailsRelIdAndCohortYearAndTraineeLevelId(
			traineeAdmissionDetailsRelId, cohortYear, traineeLevelId,
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the trainee cohort detailses where traineeAdmissionDetailsRelId = &#63; and cohortYear = &#63; and traineeLevelId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TraineeCohortDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param traineeAdmissionDetailsRelId the trainee admission details rel ID
	 * @param cohortYear the cohort year
	 * @param traineeLevelId the trainee level ID
	 * @param start the lower bound of the range of trainee cohort detailses
	 * @param end the upper bound of the range of trainee cohort detailses (not inclusive)
	 * @return the range of matching trainee cohort detailses
	 */
	@Override
	public List<TraineeCohortDetails>
		findByTraineeAdmissionDetailsRelIdAndCohortYearAndTraineeLevelId(
			long traineeAdmissionDetailsRelId, String cohortYear,
			long traineeLevelId, int start, int end) {

		return findByTraineeAdmissionDetailsRelIdAndCohortYearAndTraineeLevelId(
			traineeAdmissionDetailsRelId, cohortYear, traineeLevelId, start,
			end, null);
	}

	/**
	 * Returns an ordered range of all the trainee cohort detailses where traineeAdmissionDetailsRelId = &#63; and cohortYear = &#63; and traineeLevelId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TraineeCohortDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param traineeAdmissionDetailsRelId the trainee admission details rel ID
	 * @param cohortYear the cohort year
	 * @param traineeLevelId the trainee level ID
	 * @param start the lower bound of the range of trainee cohort detailses
	 * @param end the upper bound of the range of trainee cohort detailses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching trainee cohort detailses
	 */
	@Override
	public List<TraineeCohortDetails>
		findByTraineeAdmissionDetailsRelIdAndCohortYearAndTraineeLevelId(
			long traineeAdmissionDetailsRelId, String cohortYear,
			long traineeLevelId, int start, int end,
			OrderByComparator<TraineeCohortDetails> orderByComparator) {

		return findByTraineeAdmissionDetailsRelIdAndCohortYearAndTraineeLevelId(
			traineeAdmissionDetailsRelId, cohortYear, traineeLevelId, start,
			end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the trainee cohort detailses where traineeAdmissionDetailsRelId = &#63; and cohortYear = &#63; and traineeLevelId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TraineeCohortDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param traineeAdmissionDetailsRelId the trainee admission details rel ID
	 * @param cohortYear the cohort year
	 * @param traineeLevelId the trainee level ID
	 * @param start the lower bound of the range of trainee cohort detailses
	 * @param end the upper bound of the range of trainee cohort detailses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching trainee cohort detailses
	 */
	@Override
	public List<TraineeCohortDetails>
		findByTraineeAdmissionDetailsRelIdAndCohortYearAndTraineeLevelId(
			long traineeAdmissionDetailsRelId, String cohortYear,
			long traineeLevelId, int start, int end,
			OrderByComparator<TraineeCohortDetails> orderByComparator,
			boolean useFinderCache) {

		cohortYear = Objects.toString(cohortYear, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath =
					_finderPathWithoutPaginationFindByTraineeAdmissionDetailsRelIdAndCohortYearAndTraineeLevelId;
				finderArgs = new Object[] {
					traineeAdmissionDetailsRelId, cohortYear, traineeLevelId
				};
			}
		}
		else if (useFinderCache) {
			finderPath =
				_finderPathWithPaginationFindByTraineeAdmissionDetailsRelIdAndCohortYearAndTraineeLevelId;
			finderArgs = new Object[] {
				traineeAdmissionDetailsRelId, cohortYear, traineeLevelId, start,
				end, orderByComparator
			};
		}

		List<TraineeCohortDetails> list = null;

		if (useFinderCache) {
			list = (List<TraineeCohortDetails>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (TraineeCohortDetails traineeCohortDetails : list) {
					if ((traineeAdmissionDetailsRelId !=
							traineeCohortDetails.
								getTraineeAdmissionDetailsRelId()) ||
						!cohortYear.equals(
							traineeCohortDetails.getCohortYear()) ||
						(traineeLevelId !=
							traineeCohortDetails.getTraineeLevelId())) {

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

			sb.append(_SQL_SELECT_TRAINEECOHORTDETAILS_WHERE);

			sb.append(
				_FINDER_COLUMN_TRAINEEADMISSIONDETAILSRELIDANDCOHORTYEARANDTRAINEELEVELID_TRAINEEADMISSIONDETAILSRELID_2);

			boolean bindCohortYear = false;

			if (cohortYear.isEmpty()) {
				sb.append(
					_FINDER_COLUMN_TRAINEEADMISSIONDETAILSRELIDANDCOHORTYEARANDTRAINEELEVELID_COHORTYEAR_3);
			}
			else {
				bindCohortYear = true;

				sb.append(
					_FINDER_COLUMN_TRAINEEADMISSIONDETAILSRELIDANDCOHORTYEARANDTRAINEELEVELID_COHORTYEAR_2);
			}

			sb.append(
				_FINDER_COLUMN_TRAINEEADMISSIONDETAILSRELIDANDCOHORTYEARANDTRAINEELEVELID_TRAINEELEVELID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(TraineeCohortDetailsModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(traineeAdmissionDetailsRelId);

				if (bindCohortYear) {
					queryPos.add(cohortYear);
				}

				queryPos.add(traineeLevelId);

				list = (List<TraineeCohortDetails>)QueryUtil.list(
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
	 * Returns the first trainee cohort details in the ordered set where traineeAdmissionDetailsRelId = &#63; and cohortYear = &#63; and traineeLevelId = &#63;.
	 *
	 * @param traineeAdmissionDetailsRelId the trainee admission details rel ID
	 * @param cohortYear the cohort year
	 * @param traineeLevelId the trainee level ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching trainee cohort details
	 * @throws NoSuchTraineeCohortDetailsException if a matching trainee cohort details could not be found
	 */
	@Override
	public TraineeCohortDetails
			findByTraineeAdmissionDetailsRelIdAndCohortYearAndTraineeLevelId_First(
				long traineeAdmissionDetailsRelId, String cohortYear,
				long traineeLevelId,
				OrderByComparator<TraineeCohortDetails> orderByComparator)
		throws NoSuchTraineeCohortDetailsException {

		TraineeCohortDetails traineeCohortDetails =
			fetchByTraineeAdmissionDetailsRelIdAndCohortYearAndTraineeLevelId_First(
				traineeAdmissionDetailsRelId, cohortYear, traineeLevelId,
				orderByComparator);

		if (traineeCohortDetails != null) {
			return traineeCohortDetails;
		}

		StringBundler sb = new StringBundler(8);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("traineeAdmissionDetailsRelId=");
		sb.append(traineeAdmissionDetailsRelId);

		sb.append(", cohortYear=");
		sb.append(cohortYear);

		sb.append(", traineeLevelId=");
		sb.append(traineeLevelId);

		sb.append("}");

		throw new NoSuchTraineeCohortDetailsException(sb.toString());
	}

	/**
	 * Returns the first trainee cohort details in the ordered set where traineeAdmissionDetailsRelId = &#63; and cohortYear = &#63; and traineeLevelId = &#63;.
	 *
	 * @param traineeAdmissionDetailsRelId the trainee admission details rel ID
	 * @param cohortYear the cohort year
	 * @param traineeLevelId the trainee level ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching trainee cohort details, or <code>null</code> if a matching trainee cohort details could not be found
	 */
	@Override
	public TraineeCohortDetails
		fetchByTraineeAdmissionDetailsRelIdAndCohortYearAndTraineeLevelId_First(
			long traineeAdmissionDetailsRelId, String cohortYear,
			long traineeLevelId,
			OrderByComparator<TraineeCohortDetails> orderByComparator) {

		List<TraineeCohortDetails> list =
			findByTraineeAdmissionDetailsRelIdAndCohortYearAndTraineeLevelId(
				traineeAdmissionDetailsRelId, cohortYear, traineeLevelId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last trainee cohort details in the ordered set where traineeAdmissionDetailsRelId = &#63; and cohortYear = &#63; and traineeLevelId = &#63;.
	 *
	 * @param traineeAdmissionDetailsRelId the trainee admission details rel ID
	 * @param cohortYear the cohort year
	 * @param traineeLevelId the trainee level ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching trainee cohort details
	 * @throws NoSuchTraineeCohortDetailsException if a matching trainee cohort details could not be found
	 */
	@Override
	public TraineeCohortDetails
			findByTraineeAdmissionDetailsRelIdAndCohortYearAndTraineeLevelId_Last(
				long traineeAdmissionDetailsRelId, String cohortYear,
				long traineeLevelId,
				OrderByComparator<TraineeCohortDetails> orderByComparator)
		throws NoSuchTraineeCohortDetailsException {

		TraineeCohortDetails traineeCohortDetails =
			fetchByTraineeAdmissionDetailsRelIdAndCohortYearAndTraineeLevelId_Last(
				traineeAdmissionDetailsRelId, cohortYear, traineeLevelId,
				orderByComparator);

		if (traineeCohortDetails != null) {
			return traineeCohortDetails;
		}

		StringBundler sb = new StringBundler(8);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("traineeAdmissionDetailsRelId=");
		sb.append(traineeAdmissionDetailsRelId);

		sb.append(", cohortYear=");
		sb.append(cohortYear);

		sb.append(", traineeLevelId=");
		sb.append(traineeLevelId);

		sb.append("}");

		throw new NoSuchTraineeCohortDetailsException(sb.toString());
	}

	/**
	 * Returns the last trainee cohort details in the ordered set where traineeAdmissionDetailsRelId = &#63; and cohortYear = &#63; and traineeLevelId = &#63;.
	 *
	 * @param traineeAdmissionDetailsRelId the trainee admission details rel ID
	 * @param cohortYear the cohort year
	 * @param traineeLevelId the trainee level ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching trainee cohort details, or <code>null</code> if a matching trainee cohort details could not be found
	 */
	@Override
	public TraineeCohortDetails
		fetchByTraineeAdmissionDetailsRelIdAndCohortYearAndTraineeLevelId_Last(
			long traineeAdmissionDetailsRelId, String cohortYear,
			long traineeLevelId,
			OrderByComparator<TraineeCohortDetails> orderByComparator) {

		int count =
			countByTraineeAdmissionDetailsRelIdAndCohortYearAndTraineeLevelId(
				traineeAdmissionDetailsRelId, cohortYear, traineeLevelId);

		if (count == 0) {
			return null;
		}

		List<TraineeCohortDetails> list =
			findByTraineeAdmissionDetailsRelIdAndCohortYearAndTraineeLevelId(
				traineeAdmissionDetailsRelId, cohortYear, traineeLevelId,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the trainee cohort detailses before and after the current trainee cohort details in the ordered set where traineeAdmissionDetailsRelId = &#63; and cohortYear = &#63; and traineeLevelId = &#63;.
	 *
	 * @param traineeCohortDetailsId the primary key of the current trainee cohort details
	 * @param traineeAdmissionDetailsRelId the trainee admission details rel ID
	 * @param cohortYear the cohort year
	 * @param traineeLevelId the trainee level ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next trainee cohort details
	 * @throws NoSuchTraineeCohortDetailsException if a trainee cohort details with the primary key could not be found
	 */
	@Override
	public TraineeCohortDetails[]
			findByTraineeAdmissionDetailsRelIdAndCohortYearAndTraineeLevelId_PrevAndNext(
				long traineeCohortDetailsId, long traineeAdmissionDetailsRelId,
				String cohortYear, long traineeLevelId,
				OrderByComparator<TraineeCohortDetails> orderByComparator)
		throws NoSuchTraineeCohortDetailsException {

		cohortYear = Objects.toString(cohortYear, "");

		TraineeCohortDetails traineeCohortDetails = findByPrimaryKey(
			traineeCohortDetailsId);

		Session session = null;

		try {
			session = openSession();

			TraineeCohortDetails[] array = new TraineeCohortDetailsImpl[3];

			array[0] =
				getByTraineeAdmissionDetailsRelIdAndCohortYearAndTraineeLevelId_PrevAndNext(
					session, traineeCohortDetails, traineeAdmissionDetailsRelId,
					cohortYear, traineeLevelId, orderByComparator, true);

			array[1] = traineeCohortDetails;

			array[2] =
				getByTraineeAdmissionDetailsRelIdAndCohortYearAndTraineeLevelId_PrevAndNext(
					session, traineeCohortDetails, traineeAdmissionDetailsRelId,
					cohortYear, traineeLevelId, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected TraineeCohortDetails
		getByTraineeAdmissionDetailsRelIdAndCohortYearAndTraineeLevelId_PrevAndNext(
			Session session, TraineeCohortDetails traineeCohortDetails,
			long traineeAdmissionDetailsRelId, String cohortYear,
			long traineeLevelId,
			OrderByComparator<TraineeCohortDetails> orderByComparator,
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

		sb.append(_SQL_SELECT_TRAINEECOHORTDETAILS_WHERE);

		sb.append(
			_FINDER_COLUMN_TRAINEEADMISSIONDETAILSRELIDANDCOHORTYEARANDTRAINEELEVELID_TRAINEEADMISSIONDETAILSRELID_2);

		boolean bindCohortYear = false;

		if (cohortYear.isEmpty()) {
			sb.append(
				_FINDER_COLUMN_TRAINEEADMISSIONDETAILSRELIDANDCOHORTYEARANDTRAINEELEVELID_COHORTYEAR_3);
		}
		else {
			bindCohortYear = true;

			sb.append(
				_FINDER_COLUMN_TRAINEEADMISSIONDETAILSRELIDANDCOHORTYEARANDTRAINEELEVELID_COHORTYEAR_2);
		}

		sb.append(
			_FINDER_COLUMN_TRAINEEADMISSIONDETAILSRELIDANDCOHORTYEARANDTRAINEELEVELID_TRAINEELEVELID_2);

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
			sb.append(TraineeCohortDetailsModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(traineeAdmissionDetailsRelId);

		if (bindCohortYear) {
			queryPos.add(cohortYear);
		}

		queryPos.add(traineeLevelId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						traineeCohortDetails)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<TraineeCohortDetails> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the trainee cohort detailses where traineeAdmissionDetailsRelId = &#63; and cohortYear = &#63; and traineeLevelId = &#63; from the database.
	 *
	 * @param traineeAdmissionDetailsRelId the trainee admission details rel ID
	 * @param cohortYear the cohort year
	 * @param traineeLevelId the trainee level ID
	 */
	@Override
	public void
		removeByTraineeAdmissionDetailsRelIdAndCohortYearAndTraineeLevelId(
			long traineeAdmissionDetailsRelId, String cohortYear,
			long traineeLevelId) {

		for (TraineeCohortDetails traineeCohortDetails :
				findByTraineeAdmissionDetailsRelIdAndCohortYearAndTraineeLevelId(
					traineeAdmissionDetailsRelId, cohortYear, traineeLevelId,
					QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(traineeCohortDetails);
		}
	}

	/**
	 * Returns the number of trainee cohort detailses where traineeAdmissionDetailsRelId = &#63; and cohortYear = &#63; and traineeLevelId = &#63;.
	 *
	 * @param traineeAdmissionDetailsRelId the trainee admission details rel ID
	 * @param cohortYear the cohort year
	 * @param traineeLevelId the trainee level ID
	 * @return the number of matching trainee cohort detailses
	 */
	@Override
	public int
		countByTraineeAdmissionDetailsRelIdAndCohortYearAndTraineeLevelId(
			long traineeAdmissionDetailsRelId, String cohortYear,
			long traineeLevelId) {

		cohortYear = Objects.toString(cohortYear, "");

		FinderPath finderPath =
			_finderPathCountByTraineeAdmissionDetailsRelIdAndCohortYearAndTraineeLevelId;

		Object[] finderArgs = new Object[] {
			traineeAdmissionDetailsRelId, cohortYear, traineeLevelId
		};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_SQL_COUNT_TRAINEECOHORTDETAILS_WHERE);

			sb.append(
				_FINDER_COLUMN_TRAINEEADMISSIONDETAILSRELIDANDCOHORTYEARANDTRAINEELEVELID_TRAINEEADMISSIONDETAILSRELID_2);

			boolean bindCohortYear = false;

			if (cohortYear.isEmpty()) {
				sb.append(
					_FINDER_COLUMN_TRAINEEADMISSIONDETAILSRELIDANDCOHORTYEARANDTRAINEELEVELID_COHORTYEAR_3);
			}
			else {
				bindCohortYear = true;

				sb.append(
					_FINDER_COLUMN_TRAINEEADMISSIONDETAILSRELIDANDCOHORTYEARANDTRAINEELEVELID_COHORTYEAR_2);
			}

			sb.append(
				_FINDER_COLUMN_TRAINEEADMISSIONDETAILSRELIDANDCOHORTYEARANDTRAINEELEVELID_TRAINEELEVELID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(traineeAdmissionDetailsRelId);

				if (bindCohortYear) {
					queryPos.add(cohortYear);
				}

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
		_FINDER_COLUMN_TRAINEEADMISSIONDETAILSRELIDANDCOHORTYEARANDTRAINEELEVELID_TRAINEEADMISSIONDETAILSRELID_2 =
			"traineeCohortDetails.traineeAdmissionDetailsRelId = ? AND ";

	private static final String
		_FINDER_COLUMN_TRAINEEADMISSIONDETAILSRELIDANDCOHORTYEARANDTRAINEELEVELID_COHORTYEAR_2 =
			"traineeCohortDetails.cohortYear = ? AND ";

	private static final String
		_FINDER_COLUMN_TRAINEEADMISSIONDETAILSRELIDANDCOHORTYEARANDTRAINEELEVELID_COHORTYEAR_3 =
			"(traineeCohortDetails.cohortYear IS NULL OR traineeCohortDetails.cohortYear = '') AND ";

	private static final String
		_FINDER_COLUMN_TRAINEEADMISSIONDETAILSRELIDANDCOHORTYEARANDTRAINEELEVELID_TRAINEELEVELID_2 =
			"traineeCohortDetails.traineeLevelId = ?";

	private FinderPath
		_finderPathFetchByTraineeAdmissionDetailsRelIdAndIsCurrentTraineeLevel;
	private FinderPath
		_finderPathCountByTraineeAdmissionDetailsRelIdAndIsCurrentTraineeLevel;

	/**
	 * Returns the trainee cohort details where traineeAdmissionDetailsRelId = &#63; and isCurrentTraineeLevel = &#63; or throws a <code>NoSuchTraineeCohortDetailsException</code> if it could not be found.
	 *
	 * @param traineeAdmissionDetailsRelId the trainee admission details rel ID
	 * @param isCurrentTraineeLevel the is current trainee level
	 * @return the matching trainee cohort details
	 * @throws NoSuchTraineeCohortDetailsException if a matching trainee cohort details could not be found
	 */
	@Override
	public TraineeCohortDetails
			findByTraineeAdmissionDetailsRelIdAndIsCurrentTraineeLevel(
				long traineeAdmissionDetailsRelId,
				Boolean isCurrentTraineeLevel)
		throws NoSuchTraineeCohortDetailsException {

		TraineeCohortDetails traineeCohortDetails =
			fetchByTraineeAdmissionDetailsRelIdAndIsCurrentTraineeLevel(
				traineeAdmissionDetailsRelId, isCurrentTraineeLevel);

		if (traineeCohortDetails == null) {
			StringBundler sb = new StringBundler(6);

			sb.append(_NO_SUCH_ENTITY_WITH_KEY);

			sb.append("traineeAdmissionDetailsRelId=");
			sb.append(traineeAdmissionDetailsRelId);

			sb.append(", isCurrentTraineeLevel=");
			sb.append(isCurrentTraineeLevel);

			sb.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(sb.toString());
			}

			throw new NoSuchTraineeCohortDetailsException(sb.toString());
		}

		return traineeCohortDetails;
	}

	/**
	 * Returns the trainee cohort details where traineeAdmissionDetailsRelId = &#63; and isCurrentTraineeLevel = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param traineeAdmissionDetailsRelId the trainee admission details rel ID
	 * @param isCurrentTraineeLevel the is current trainee level
	 * @return the matching trainee cohort details, or <code>null</code> if a matching trainee cohort details could not be found
	 */
	@Override
	public TraineeCohortDetails
		fetchByTraineeAdmissionDetailsRelIdAndIsCurrentTraineeLevel(
			long traineeAdmissionDetailsRelId, Boolean isCurrentTraineeLevel) {

		return fetchByTraineeAdmissionDetailsRelIdAndIsCurrentTraineeLevel(
			traineeAdmissionDetailsRelId, isCurrentTraineeLevel, true);
	}

	/**
	 * Returns the trainee cohort details where traineeAdmissionDetailsRelId = &#63; and isCurrentTraineeLevel = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param traineeAdmissionDetailsRelId the trainee admission details rel ID
	 * @param isCurrentTraineeLevel the is current trainee level
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching trainee cohort details, or <code>null</code> if a matching trainee cohort details could not be found
	 */
	@Override
	public TraineeCohortDetails
		fetchByTraineeAdmissionDetailsRelIdAndIsCurrentTraineeLevel(
			long traineeAdmissionDetailsRelId, Boolean isCurrentTraineeLevel,
			boolean useFinderCache) {

		Object[] finderArgs = null;

		if (useFinderCache) {
			finderArgs = new Object[] {
				traineeAdmissionDetailsRelId, isCurrentTraineeLevel
			};
		}

		Object result = null;

		if (useFinderCache) {
			result = finderCache.getResult(
				_finderPathFetchByTraineeAdmissionDetailsRelIdAndIsCurrentTraineeLevel,
				finderArgs, this);
		}

		if (result instanceof TraineeCohortDetails) {
			TraineeCohortDetails traineeCohortDetails =
				(TraineeCohortDetails)result;

			if ((traineeAdmissionDetailsRelId !=
					traineeCohortDetails.getTraineeAdmissionDetailsRelId()) ||
				!Objects.equals(
					isCurrentTraineeLevel,
					traineeCohortDetails.getIsCurrentTraineeLevel())) {

				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_SQL_SELECT_TRAINEECOHORTDETAILS_WHERE);

			sb.append(
				_FINDER_COLUMN_TRAINEEADMISSIONDETAILSRELIDANDISCURRENTTRAINEELEVEL_TRAINEEADMISSIONDETAILSRELID_2);

			sb.append(
				_FINDER_COLUMN_TRAINEEADMISSIONDETAILSRELIDANDISCURRENTTRAINEELEVEL_ISCURRENTTRAINEELEVEL_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(traineeAdmissionDetailsRelId);

				queryPos.add(isCurrentTraineeLevel.booleanValue());

				List<TraineeCohortDetails> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchByTraineeAdmissionDetailsRelIdAndIsCurrentTraineeLevel,
							finderArgs, list);
					}
				}
				else {
					if (list.size() > 1) {
						Collections.sort(list, Collections.reverseOrder());

						if (_log.isWarnEnabled()) {
							if (!useFinderCache) {
								finderArgs = new Object[] {
									traineeAdmissionDetailsRelId,
									isCurrentTraineeLevel
								};
							}

							_log.warn(
								"TraineeCohortDetailsPersistenceImpl.fetchByTraineeAdmissionDetailsRelIdAndIsCurrentTraineeLevel(long, Boolean, boolean) with parameters (" +
									StringUtil.merge(finderArgs) +
										") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
						}
					}

					TraineeCohortDetails traineeCohortDetails = list.get(0);

					result = traineeCohortDetails;

					cacheResult(traineeCohortDetails);
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
			return (TraineeCohortDetails)result;
		}
	}

	/**
	 * Removes the trainee cohort details where traineeAdmissionDetailsRelId = &#63; and isCurrentTraineeLevel = &#63; from the database.
	 *
	 * @param traineeAdmissionDetailsRelId the trainee admission details rel ID
	 * @param isCurrentTraineeLevel the is current trainee level
	 * @return the trainee cohort details that was removed
	 */
	@Override
	public TraineeCohortDetails
			removeByTraineeAdmissionDetailsRelIdAndIsCurrentTraineeLevel(
				long traineeAdmissionDetailsRelId,
				Boolean isCurrentTraineeLevel)
		throws NoSuchTraineeCohortDetailsException {

		TraineeCohortDetails traineeCohortDetails =
			findByTraineeAdmissionDetailsRelIdAndIsCurrentTraineeLevel(
				traineeAdmissionDetailsRelId, isCurrentTraineeLevel);

		return remove(traineeCohortDetails);
	}

	/**
	 * Returns the number of trainee cohort detailses where traineeAdmissionDetailsRelId = &#63; and isCurrentTraineeLevel = &#63;.
	 *
	 * @param traineeAdmissionDetailsRelId the trainee admission details rel ID
	 * @param isCurrentTraineeLevel the is current trainee level
	 * @return the number of matching trainee cohort detailses
	 */
	@Override
	public int countByTraineeAdmissionDetailsRelIdAndIsCurrentTraineeLevel(
		long traineeAdmissionDetailsRelId, Boolean isCurrentTraineeLevel) {

		FinderPath finderPath =
			_finderPathCountByTraineeAdmissionDetailsRelIdAndIsCurrentTraineeLevel;

		Object[] finderArgs = new Object[] {
			traineeAdmissionDetailsRelId, isCurrentTraineeLevel
		};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_TRAINEECOHORTDETAILS_WHERE);

			sb.append(
				_FINDER_COLUMN_TRAINEEADMISSIONDETAILSRELIDANDISCURRENTTRAINEELEVEL_TRAINEEADMISSIONDETAILSRELID_2);

			sb.append(
				_FINDER_COLUMN_TRAINEEADMISSIONDETAILSRELIDANDISCURRENTTRAINEELEVEL_ISCURRENTTRAINEELEVEL_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(traineeAdmissionDetailsRelId);

				queryPos.add(isCurrentTraineeLevel.booleanValue());

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
		_FINDER_COLUMN_TRAINEEADMISSIONDETAILSRELIDANDISCURRENTTRAINEELEVEL_TRAINEEADMISSIONDETAILSRELID_2 =
			"traineeCohortDetails.traineeAdmissionDetailsRelId = ? AND ";

	private static final String
		_FINDER_COLUMN_TRAINEEADMISSIONDETAILSRELIDANDISCURRENTTRAINEELEVEL_ISCURRENTTRAINEELEVEL_2 =
			"traineeCohortDetails.isCurrentTraineeLevel = ?";

	private FinderPath
		_finderPathWithPaginationFindByTraineeAdmissionDetailsRelId;
	private FinderPath
		_finderPathWithoutPaginationFindByTraineeAdmissionDetailsRelId;
	private FinderPath _finderPathCountByTraineeAdmissionDetailsRelId;

	/**
	 * Returns all the trainee cohort detailses where traineeAdmissionDetailsRelId = &#63;.
	 *
	 * @param traineeAdmissionDetailsRelId the trainee admission details rel ID
	 * @return the matching trainee cohort detailses
	 */
	@Override
	public List<TraineeCohortDetails> findByTraineeAdmissionDetailsRelId(
		long traineeAdmissionDetailsRelId) {

		return findByTraineeAdmissionDetailsRelId(
			traineeAdmissionDetailsRelId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
	}

	/**
	 * Returns a range of all the trainee cohort detailses where traineeAdmissionDetailsRelId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TraineeCohortDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param traineeAdmissionDetailsRelId the trainee admission details rel ID
	 * @param start the lower bound of the range of trainee cohort detailses
	 * @param end the upper bound of the range of trainee cohort detailses (not inclusive)
	 * @return the range of matching trainee cohort detailses
	 */
	@Override
	public List<TraineeCohortDetails> findByTraineeAdmissionDetailsRelId(
		long traineeAdmissionDetailsRelId, int start, int end) {

		return findByTraineeAdmissionDetailsRelId(
			traineeAdmissionDetailsRelId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the trainee cohort detailses where traineeAdmissionDetailsRelId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TraineeCohortDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param traineeAdmissionDetailsRelId the trainee admission details rel ID
	 * @param start the lower bound of the range of trainee cohort detailses
	 * @param end the upper bound of the range of trainee cohort detailses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching trainee cohort detailses
	 */
	@Override
	public List<TraineeCohortDetails> findByTraineeAdmissionDetailsRelId(
		long traineeAdmissionDetailsRelId, int start, int end,
		OrderByComparator<TraineeCohortDetails> orderByComparator) {

		return findByTraineeAdmissionDetailsRelId(
			traineeAdmissionDetailsRelId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the trainee cohort detailses where traineeAdmissionDetailsRelId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TraineeCohortDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param traineeAdmissionDetailsRelId the trainee admission details rel ID
	 * @param start the lower bound of the range of trainee cohort detailses
	 * @param end the upper bound of the range of trainee cohort detailses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching trainee cohort detailses
	 */
	@Override
	public List<TraineeCohortDetails> findByTraineeAdmissionDetailsRelId(
		long traineeAdmissionDetailsRelId, int start, int end,
		OrderByComparator<TraineeCohortDetails> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath =
					_finderPathWithoutPaginationFindByTraineeAdmissionDetailsRelId;
				finderArgs = new Object[] {traineeAdmissionDetailsRelId};
			}
		}
		else if (useFinderCache) {
			finderPath =
				_finderPathWithPaginationFindByTraineeAdmissionDetailsRelId;
			finderArgs = new Object[] {
				traineeAdmissionDetailsRelId, start, end, orderByComparator
			};
		}

		List<TraineeCohortDetails> list = null;

		if (useFinderCache) {
			list = (List<TraineeCohortDetails>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (TraineeCohortDetails traineeCohortDetails : list) {
					if (traineeAdmissionDetailsRelId !=
							traineeCohortDetails.
								getTraineeAdmissionDetailsRelId()) {

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

			sb.append(_SQL_SELECT_TRAINEECOHORTDETAILS_WHERE);

			sb.append(
				_FINDER_COLUMN_TRAINEEADMISSIONDETAILSRELID_TRAINEEADMISSIONDETAILSRELID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(TraineeCohortDetailsModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(traineeAdmissionDetailsRelId);

				list = (List<TraineeCohortDetails>)QueryUtil.list(
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
	 * Returns the first trainee cohort details in the ordered set where traineeAdmissionDetailsRelId = &#63;.
	 *
	 * @param traineeAdmissionDetailsRelId the trainee admission details rel ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching trainee cohort details
	 * @throws NoSuchTraineeCohortDetailsException if a matching trainee cohort details could not be found
	 */
	@Override
	public TraineeCohortDetails findByTraineeAdmissionDetailsRelId_First(
			long traineeAdmissionDetailsRelId,
			OrderByComparator<TraineeCohortDetails> orderByComparator)
		throws NoSuchTraineeCohortDetailsException {

		TraineeCohortDetails traineeCohortDetails =
			fetchByTraineeAdmissionDetailsRelId_First(
				traineeAdmissionDetailsRelId, orderByComparator);

		if (traineeCohortDetails != null) {
			return traineeCohortDetails;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("traineeAdmissionDetailsRelId=");
		sb.append(traineeAdmissionDetailsRelId);

		sb.append("}");

		throw new NoSuchTraineeCohortDetailsException(sb.toString());
	}

	/**
	 * Returns the first trainee cohort details in the ordered set where traineeAdmissionDetailsRelId = &#63;.
	 *
	 * @param traineeAdmissionDetailsRelId the trainee admission details rel ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching trainee cohort details, or <code>null</code> if a matching trainee cohort details could not be found
	 */
	@Override
	public TraineeCohortDetails fetchByTraineeAdmissionDetailsRelId_First(
		long traineeAdmissionDetailsRelId,
		OrderByComparator<TraineeCohortDetails> orderByComparator) {

		List<TraineeCohortDetails> list = findByTraineeAdmissionDetailsRelId(
			traineeAdmissionDetailsRelId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last trainee cohort details in the ordered set where traineeAdmissionDetailsRelId = &#63;.
	 *
	 * @param traineeAdmissionDetailsRelId the trainee admission details rel ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching trainee cohort details
	 * @throws NoSuchTraineeCohortDetailsException if a matching trainee cohort details could not be found
	 */
	@Override
	public TraineeCohortDetails findByTraineeAdmissionDetailsRelId_Last(
			long traineeAdmissionDetailsRelId,
			OrderByComparator<TraineeCohortDetails> orderByComparator)
		throws NoSuchTraineeCohortDetailsException {

		TraineeCohortDetails traineeCohortDetails =
			fetchByTraineeAdmissionDetailsRelId_Last(
				traineeAdmissionDetailsRelId, orderByComparator);

		if (traineeCohortDetails != null) {
			return traineeCohortDetails;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("traineeAdmissionDetailsRelId=");
		sb.append(traineeAdmissionDetailsRelId);

		sb.append("}");

		throw new NoSuchTraineeCohortDetailsException(sb.toString());
	}

	/**
	 * Returns the last trainee cohort details in the ordered set where traineeAdmissionDetailsRelId = &#63;.
	 *
	 * @param traineeAdmissionDetailsRelId the trainee admission details rel ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching trainee cohort details, or <code>null</code> if a matching trainee cohort details could not be found
	 */
	@Override
	public TraineeCohortDetails fetchByTraineeAdmissionDetailsRelId_Last(
		long traineeAdmissionDetailsRelId,
		OrderByComparator<TraineeCohortDetails> orderByComparator) {

		int count = countByTraineeAdmissionDetailsRelId(
			traineeAdmissionDetailsRelId);

		if (count == 0) {
			return null;
		}

		List<TraineeCohortDetails> list = findByTraineeAdmissionDetailsRelId(
			traineeAdmissionDetailsRelId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the trainee cohort detailses before and after the current trainee cohort details in the ordered set where traineeAdmissionDetailsRelId = &#63;.
	 *
	 * @param traineeCohortDetailsId the primary key of the current trainee cohort details
	 * @param traineeAdmissionDetailsRelId the trainee admission details rel ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next trainee cohort details
	 * @throws NoSuchTraineeCohortDetailsException if a trainee cohort details with the primary key could not be found
	 */
	@Override
	public TraineeCohortDetails[]
			findByTraineeAdmissionDetailsRelId_PrevAndNext(
				long traineeCohortDetailsId, long traineeAdmissionDetailsRelId,
				OrderByComparator<TraineeCohortDetails> orderByComparator)
		throws NoSuchTraineeCohortDetailsException {

		TraineeCohortDetails traineeCohortDetails = findByPrimaryKey(
			traineeCohortDetailsId);

		Session session = null;

		try {
			session = openSession();

			TraineeCohortDetails[] array = new TraineeCohortDetailsImpl[3];

			array[0] = getByTraineeAdmissionDetailsRelId_PrevAndNext(
				session, traineeCohortDetails, traineeAdmissionDetailsRelId,
				orderByComparator, true);

			array[1] = traineeCohortDetails;

			array[2] = getByTraineeAdmissionDetailsRelId_PrevAndNext(
				session, traineeCohortDetails, traineeAdmissionDetailsRelId,
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

	protected TraineeCohortDetails
		getByTraineeAdmissionDetailsRelId_PrevAndNext(
			Session session, TraineeCohortDetails traineeCohortDetails,
			long traineeAdmissionDetailsRelId,
			OrderByComparator<TraineeCohortDetails> orderByComparator,
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

		sb.append(_SQL_SELECT_TRAINEECOHORTDETAILS_WHERE);

		sb.append(
			_FINDER_COLUMN_TRAINEEADMISSIONDETAILSRELID_TRAINEEADMISSIONDETAILSRELID_2);

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
			sb.append(TraineeCohortDetailsModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(traineeAdmissionDetailsRelId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						traineeCohortDetails)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<TraineeCohortDetails> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the trainee cohort detailses where traineeAdmissionDetailsRelId = &#63; from the database.
	 *
	 * @param traineeAdmissionDetailsRelId the trainee admission details rel ID
	 */
	@Override
	public void removeByTraineeAdmissionDetailsRelId(
		long traineeAdmissionDetailsRelId) {

		for (TraineeCohortDetails traineeCohortDetails :
				findByTraineeAdmissionDetailsRelId(
					traineeAdmissionDetailsRelId, QueryUtil.ALL_POS,
					QueryUtil.ALL_POS, null)) {

			remove(traineeCohortDetails);
		}
	}

	/**
	 * Returns the number of trainee cohort detailses where traineeAdmissionDetailsRelId = &#63;.
	 *
	 * @param traineeAdmissionDetailsRelId the trainee admission details rel ID
	 * @return the number of matching trainee cohort detailses
	 */
	@Override
	public int countByTraineeAdmissionDetailsRelId(
		long traineeAdmissionDetailsRelId) {

		FinderPath finderPath = _finderPathCountByTraineeAdmissionDetailsRelId;

		Object[] finderArgs = new Object[] {traineeAdmissionDetailsRelId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_TRAINEECOHORTDETAILS_WHERE);

			sb.append(
				_FINDER_COLUMN_TRAINEEADMISSIONDETAILSRELID_TRAINEEADMISSIONDETAILSRELID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(traineeAdmissionDetailsRelId);

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
		_FINDER_COLUMN_TRAINEEADMISSIONDETAILSRELID_TRAINEEADMISSIONDETAILSRELID_2 =
			"traineeCohortDetails.traineeAdmissionDetailsRelId = ?";

	public TraineeCohortDetailsPersistenceImpl() {
		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("uuid", "uuid_");
		dbColumnNames.put(
			"traineeCohortDetailsId", "trainee_cohort_details_id");
		dbColumnNames.put("groupId", "group_id");
		dbColumnNames.put("companyId", "company_id");
		dbColumnNames.put("createDate", "create_date");
		dbColumnNames.put("modifiedDate", "modified_date");
		dbColumnNames.put("createdBy", "created_by");
		dbColumnNames.put("modifiedBy", "modified_by");
		dbColumnNames.put(
			"traineeAdmissionDetailsRelId", "trainee_admission_details_rel_id");
		dbColumnNames.put("cohortYear", "cohort_year");
		dbColumnNames.put("isCurrentCohort", "is_current_cohort");
		dbColumnNames.put("traineeLevelId", "trainee_level_id");
		dbColumnNames.put("isCurrentTraineeLevel", "is_current_trainee_level");

		setDBColumnNames(dbColumnNames);

		setModelClass(TraineeCohortDetails.class);

		setModelImplClass(TraineeCohortDetailsImpl.class);
		setModelPKClass(long.class);

		setTable(TraineeCohortDetailsTable.INSTANCE);
	}

	/**
	 * Caches the trainee cohort details in the entity cache if it is enabled.
	 *
	 * @param traineeCohortDetails the trainee cohort details
	 */
	@Override
	public void cacheResult(TraineeCohortDetails traineeCohortDetails) {
		entityCache.putResult(
			TraineeCohortDetailsImpl.class,
			traineeCohortDetails.getPrimaryKey(), traineeCohortDetails);

		finderCache.putResult(
			_finderPathFetchByUUID_G,
			new Object[] {
				traineeCohortDetails.getUuid(),
				traineeCohortDetails.getGroupId()
			},
			traineeCohortDetails);

		finderCache.putResult(
			_finderPathFetchByTraineeAdmissionDetailsRelIdAndIsCurrentTraineeLevel,
			new Object[] {
				traineeCohortDetails.getTraineeAdmissionDetailsRelId(),
				traineeCohortDetails.getIsCurrentTraineeLevel()
			},
			traineeCohortDetails);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the trainee cohort detailses in the entity cache if it is enabled.
	 *
	 * @param traineeCohortDetailses the trainee cohort detailses
	 */
	@Override
	public void cacheResult(List<TraineeCohortDetails> traineeCohortDetailses) {
		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (traineeCohortDetailses.size() >
				 _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (TraineeCohortDetails traineeCohortDetails :
				traineeCohortDetailses) {

			if (entityCache.getResult(
					TraineeCohortDetailsImpl.class,
					traineeCohortDetails.getPrimaryKey()) == null) {

				cacheResult(traineeCohortDetails);
			}
		}
	}

	/**
	 * Clears the cache for all trainee cohort detailses.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(TraineeCohortDetailsImpl.class);

		finderCache.clearCache(TraineeCohortDetailsImpl.class);
	}

	/**
	 * Clears the cache for the trainee cohort details.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(TraineeCohortDetails traineeCohortDetails) {
		entityCache.removeResult(
			TraineeCohortDetailsImpl.class, traineeCohortDetails);
	}

	@Override
	public void clearCache(List<TraineeCohortDetails> traineeCohortDetailses) {
		for (TraineeCohortDetails traineeCohortDetails :
				traineeCohortDetailses) {

			entityCache.removeResult(
				TraineeCohortDetailsImpl.class, traineeCohortDetails);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(TraineeCohortDetailsImpl.class);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(
				TraineeCohortDetailsImpl.class, primaryKey);
		}
	}

	protected void cacheUniqueFindersCache(
		TraineeCohortDetailsModelImpl traineeCohortDetailsModelImpl) {

		Object[] args = new Object[] {
			traineeCohortDetailsModelImpl.getUuid(),
			traineeCohortDetailsModelImpl.getGroupId()
		};

		finderCache.putResult(_finderPathCountByUUID_G, args, Long.valueOf(1));
		finderCache.putResult(
			_finderPathFetchByUUID_G, args, traineeCohortDetailsModelImpl);

		args = new Object[] {
			traineeCohortDetailsModelImpl.getTraineeAdmissionDetailsRelId(),
			traineeCohortDetailsModelImpl.getIsCurrentTraineeLevel()
		};

		finderCache.putResult(
			_finderPathCountByTraineeAdmissionDetailsRelIdAndIsCurrentTraineeLevel,
			args, Long.valueOf(1));
		finderCache.putResult(
			_finderPathFetchByTraineeAdmissionDetailsRelIdAndIsCurrentTraineeLevel,
			args, traineeCohortDetailsModelImpl);
	}

	/**
	 * Creates a new trainee cohort details with the primary key. Does not add the trainee cohort details to the database.
	 *
	 * @param traineeCohortDetailsId the primary key for the new trainee cohort details
	 * @return the new trainee cohort details
	 */
	@Override
	public TraineeCohortDetails create(long traineeCohortDetailsId) {
		TraineeCohortDetails traineeCohortDetails =
			new TraineeCohortDetailsImpl();

		traineeCohortDetails.setNew(true);
		traineeCohortDetails.setPrimaryKey(traineeCohortDetailsId);

		String uuid = _portalUUID.generate();

		traineeCohortDetails.setUuid(uuid);

		traineeCohortDetails.setCompanyId(CompanyThreadLocal.getCompanyId());

		return traineeCohortDetails;
	}

	/**
	 * Removes the trainee cohort details with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param traineeCohortDetailsId the primary key of the trainee cohort details
	 * @return the trainee cohort details that was removed
	 * @throws NoSuchTraineeCohortDetailsException if a trainee cohort details with the primary key could not be found
	 */
	@Override
	public TraineeCohortDetails remove(long traineeCohortDetailsId)
		throws NoSuchTraineeCohortDetailsException {

		return remove((Serializable)traineeCohortDetailsId);
	}

	/**
	 * Removes the trainee cohort details with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the trainee cohort details
	 * @return the trainee cohort details that was removed
	 * @throws NoSuchTraineeCohortDetailsException if a trainee cohort details with the primary key could not be found
	 */
	@Override
	public TraineeCohortDetails remove(Serializable primaryKey)
		throws NoSuchTraineeCohortDetailsException {

		Session session = null;

		try {
			session = openSession();

			TraineeCohortDetails traineeCohortDetails =
				(TraineeCohortDetails)session.get(
					TraineeCohortDetailsImpl.class, primaryKey);

			if (traineeCohortDetails == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchTraineeCohortDetailsException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(traineeCohortDetails);
		}
		catch (NoSuchTraineeCohortDetailsException noSuchEntityException) {
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
	protected TraineeCohortDetails removeImpl(
		TraineeCohortDetails traineeCohortDetails) {

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(traineeCohortDetails)) {
				traineeCohortDetails = (TraineeCohortDetails)session.get(
					TraineeCohortDetailsImpl.class,
					traineeCohortDetails.getPrimaryKeyObj());
			}

			if (traineeCohortDetails != null) {
				session.delete(traineeCohortDetails);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (traineeCohortDetails != null) {
			clearCache(traineeCohortDetails);
		}

		return traineeCohortDetails;
	}

	@Override
	public TraineeCohortDetails updateImpl(
		TraineeCohortDetails traineeCohortDetails) {

		boolean isNew = traineeCohortDetails.isNew();

		if (!(traineeCohortDetails instanceof TraineeCohortDetailsModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(traineeCohortDetails.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(
					traineeCohortDetails);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in traineeCohortDetails proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom TraineeCohortDetails implementation " +
					traineeCohortDetails.getClass());
		}

		TraineeCohortDetailsModelImpl traineeCohortDetailsModelImpl =
			(TraineeCohortDetailsModelImpl)traineeCohortDetails;

		if (Validator.isNull(traineeCohortDetails.getUuid())) {
			String uuid = _portalUUID.generate();

			traineeCohortDetails.setUuid(uuid);
		}

		ServiceContext serviceContext =
			ServiceContextThreadLocal.getServiceContext();

		Date date = new Date();

		if (isNew && (traineeCohortDetails.getCreateDate() == null)) {
			if (serviceContext == null) {
				traineeCohortDetails.setCreateDate(date);
			}
			else {
				traineeCohortDetails.setCreateDate(
					serviceContext.getCreateDate(date));
			}
		}

		if (!traineeCohortDetailsModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				traineeCohortDetails.setModifiedDate(date);
			}
			else {
				traineeCohortDetails.setModifiedDate(
					serviceContext.getModifiedDate(date));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(traineeCohortDetails);
			}
			else {
				traineeCohortDetails = (TraineeCohortDetails)session.merge(
					traineeCohortDetails);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(
			TraineeCohortDetailsImpl.class, traineeCohortDetailsModelImpl,
			false, true);

		cacheUniqueFindersCache(traineeCohortDetailsModelImpl);

		if (isNew) {
			traineeCohortDetails.setNew(false);
		}

		traineeCohortDetails.resetOriginalValues();

		return traineeCohortDetails;
	}

	/**
	 * Returns the trainee cohort details with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the trainee cohort details
	 * @return the trainee cohort details
	 * @throws NoSuchTraineeCohortDetailsException if a trainee cohort details with the primary key could not be found
	 */
	@Override
	public TraineeCohortDetails findByPrimaryKey(Serializable primaryKey)
		throws NoSuchTraineeCohortDetailsException {

		TraineeCohortDetails traineeCohortDetails = fetchByPrimaryKey(
			primaryKey);

		if (traineeCohortDetails == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchTraineeCohortDetailsException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return traineeCohortDetails;
	}

	/**
	 * Returns the trainee cohort details with the primary key or throws a <code>NoSuchTraineeCohortDetailsException</code> if it could not be found.
	 *
	 * @param traineeCohortDetailsId the primary key of the trainee cohort details
	 * @return the trainee cohort details
	 * @throws NoSuchTraineeCohortDetailsException if a trainee cohort details with the primary key could not be found
	 */
	@Override
	public TraineeCohortDetails findByPrimaryKey(long traineeCohortDetailsId)
		throws NoSuchTraineeCohortDetailsException {

		return findByPrimaryKey((Serializable)traineeCohortDetailsId);
	}

	/**
	 * Returns the trainee cohort details with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param traineeCohortDetailsId the primary key of the trainee cohort details
	 * @return the trainee cohort details, or <code>null</code> if a trainee cohort details with the primary key could not be found
	 */
	@Override
	public TraineeCohortDetails fetchByPrimaryKey(long traineeCohortDetailsId) {
		return fetchByPrimaryKey((Serializable)traineeCohortDetailsId);
	}

	/**
	 * Returns all the trainee cohort detailses.
	 *
	 * @return the trainee cohort detailses
	 */
	@Override
	public List<TraineeCohortDetails> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the trainee cohort detailses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TraineeCohortDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of trainee cohort detailses
	 * @param end the upper bound of the range of trainee cohort detailses (not inclusive)
	 * @return the range of trainee cohort detailses
	 */
	@Override
	public List<TraineeCohortDetails> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the trainee cohort detailses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TraineeCohortDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of trainee cohort detailses
	 * @param end the upper bound of the range of trainee cohort detailses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of trainee cohort detailses
	 */
	@Override
	public List<TraineeCohortDetails> findAll(
		int start, int end,
		OrderByComparator<TraineeCohortDetails> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the trainee cohort detailses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TraineeCohortDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of trainee cohort detailses
	 * @param end the upper bound of the range of trainee cohort detailses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of trainee cohort detailses
	 */
	@Override
	public List<TraineeCohortDetails> findAll(
		int start, int end,
		OrderByComparator<TraineeCohortDetails> orderByComparator,
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

		List<TraineeCohortDetails> list = null;

		if (useFinderCache) {
			list = (List<TraineeCohortDetails>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_TRAINEECOHORTDETAILS);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_TRAINEECOHORTDETAILS;

				sql = sql.concat(TraineeCohortDetailsModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<TraineeCohortDetails>)QueryUtil.list(
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
	 * Removes all the trainee cohort detailses from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (TraineeCohortDetails traineeCohortDetails : findAll()) {
			remove(traineeCohortDetails);
		}
	}

	/**
	 * Returns the number of trainee cohort detailses.
	 *
	 * @return the number of trainee cohort detailses
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
					_SQL_COUNT_TRAINEECOHORTDETAILS);

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
		return "trainee_cohort_details_id";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_TRAINEECOHORTDETAILS;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return TraineeCohortDetailsModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the trainee cohort details persistence.
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

		_finderPathWithPaginationFindByTraineeAdmissionDetailsRelIdAndCohortYearAndTraineeLevelId =
			new FinderPath(
				FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
				"findByTraineeAdmissionDetailsRelIdAndCohortYearAndTraineeLevelId",
				new String[] {
					Long.class.getName(), String.class.getName(),
					Long.class.getName(), Integer.class.getName(),
					Integer.class.getName(), OrderByComparator.class.getName()
				},
				new String[] {
					"trainee_admission_details_rel_id", "cohort_year",
					"trainee_level_id"
				},
				true);

		_finderPathWithoutPaginationFindByTraineeAdmissionDetailsRelIdAndCohortYearAndTraineeLevelId =
			new FinderPath(
				FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
				"findByTraineeAdmissionDetailsRelIdAndCohortYearAndTraineeLevelId",
				new String[] {
					Long.class.getName(), String.class.getName(),
					Long.class.getName()
				},
				new String[] {
					"trainee_admission_details_rel_id", "cohort_year",
					"trainee_level_id"
				},
				true);

		_finderPathCountByTraineeAdmissionDetailsRelIdAndCohortYearAndTraineeLevelId =
			new FinderPath(
				FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
				"countByTraineeAdmissionDetailsRelIdAndCohortYearAndTraineeLevelId",
				new String[] {
					Long.class.getName(), String.class.getName(),
					Long.class.getName()
				},
				new String[] {
					"trainee_admission_details_rel_id", "cohort_year",
					"trainee_level_id"
				},
				false);

		_finderPathFetchByTraineeAdmissionDetailsRelIdAndIsCurrentTraineeLevel =
			new FinderPath(
				FINDER_CLASS_NAME_ENTITY,
				"fetchByTraineeAdmissionDetailsRelIdAndIsCurrentTraineeLevel",
				new String[] {Long.class.getName(), Boolean.class.getName()},
				new String[] {
					"trainee_admission_details_rel_id",
					"is_current_trainee_level"
				},
				true);

		_finderPathCountByTraineeAdmissionDetailsRelIdAndIsCurrentTraineeLevel =
			new FinderPath(
				FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
				"countByTraineeAdmissionDetailsRelIdAndIsCurrentTraineeLevel",
				new String[] {Long.class.getName(), Boolean.class.getName()},
				new String[] {
					"trainee_admission_details_rel_id",
					"is_current_trainee_level"
				},
				false);

		_finderPathWithPaginationFindByTraineeAdmissionDetailsRelId =
			new FinderPath(
				FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
				"findByTraineeAdmissionDetailsRelId",
				new String[] {
					Long.class.getName(), Integer.class.getName(),
					Integer.class.getName(), OrderByComparator.class.getName()
				},
				new String[] {"trainee_admission_details_rel_id"}, true);

		_finderPathWithoutPaginationFindByTraineeAdmissionDetailsRelId =
			new FinderPath(
				FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
				"findByTraineeAdmissionDetailsRelId",
				new String[] {Long.class.getName()},
				new String[] {"trainee_admission_details_rel_id"}, true);

		_finderPathCountByTraineeAdmissionDetailsRelId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByTraineeAdmissionDetailsRelId",
			new String[] {Long.class.getName()},
			new String[] {"trainee_admission_details_rel_id"}, false);

		_setTraineeCohortDetailsUtilPersistence(this);
	}

	@Deactivate
	public void deactivate() {
		_setTraineeCohortDetailsUtilPersistence(null);

		entityCache.removeCache(TraineeCohortDetailsImpl.class.getName());
	}

	private void _setTraineeCohortDetailsUtilPersistence(
		TraineeCohortDetailsPersistence traineeCohortDetailsPersistence) {

		try {
			Field field = TraineeCohortDetailsUtil.class.getDeclaredField(
				"_persistence");

			field.setAccessible(true);

			field.set(null, traineeCohortDetailsPersistence);
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

	private static final String _SQL_SELECT_TRAINEECOHORTDETAILS =
		"SELECT traineeCohortDetails FROM TraineeCohortDetails traineeCohortDetails";

	private static final String _SQL_SELECT_TRAINEECOHORTDETAILS_WHERE =
		"SELECT traineeCohortDetails FROM TraineeCohortDetails traineeCohortDetails WHERE ";

	private static final String _SQL_COUNT_TRAINEECOHORTDETAILS =
		"SELECT COUNT(traineeCohortDetails) FROM TraineeCohortDetails traineeCohortDetails";

	private static final String _SQL_COUNT_TRAINEECOHORTDETAILS_WHERE =
		"SELECT COUNT(traineeCohortDetails) FROM TraineeCohortDetails traineeCohortDetails WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS =
		"traineeCohortDetails.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No TraineeCohortDetails exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No TraineeCohortDetails exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		TraineeCohortDetailsPersistenceImpl.class);

	private static final Set<String> _badColumnNames = SetUtil.fromArray(
		new String[] {
			"uuid", "traineeCohortDetailsId", "groupId", "companyId",
			"createDate", "modifiedDate", "createdBy", "modifiedBy",
			"traineeAdmissionDetailsRelId", "cohortYear", "isCurrentCohort",
			"traineeLevelId", "isCurrentTraineeLevel"
		});

	@Override
	protected FinderCache getFinderCache() {
		return finderCache;
	}

	@Reference
	private PortalUUID _portalUUID;

}
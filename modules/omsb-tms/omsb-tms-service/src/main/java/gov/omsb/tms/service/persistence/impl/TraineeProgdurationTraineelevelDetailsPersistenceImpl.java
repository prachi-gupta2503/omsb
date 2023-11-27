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

import gov.omsb.tms.exception.NoSuchTraineeProgdurationTraineelevelDetailsException;
import gov.omsb.tms.model.TraineeProgdurationTraineelevelDetails;
import gov.omsb.tms.model.TraineeProgdurationTraineelevelDetailsTable;
import gov.omsb.tms.model.impl.TraineeProgdurationTraineelevelDetailsImpl;
import gov.omsb.tms.model.impl.TraineeProgdurationTraineelevelDetailsModelImpl;
import gov.omsb.tms.service.persistence.TraineeProgdurationTraineelevelDetailsPersistence;
import gov.omsb.tms.service.persistence.TraineeProgdurationTraineelevelDetailsUtil;
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
 * The persistence implementation for the trainee progduration traineelevel details service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = TraineeProgdurationTraineelevelDetailsPersistence.class)
public class TraineeProgdurationTraineelevelDetailsPersistenceImpl
	extends BasePersistenceImpl<TraineeProgdurationTraineelevelDetails>
	implements TraineeProgdurationTraineelevelDetailsPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>TraineeProgdurationTraineelevelDetailsUtil</code> to access the trainee progduration traineelevel details persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		TraineeProgdurationTraineelevelDetailsImpl.class.getName();

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
	 * Returns all the trainee progduration traineelevel detailses where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching trainee progduration traineelevel detailses
	 */
	@Override
	public List<TraineeProgdurationTraineelevelDetails> findByUuid(
		String uuid) {

		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the trainee progduration traineelevel detailses where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TraineeProgdurationTraineelevelDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of trainee progduration traineelevel detailses
	 * @param end the upper bound of the range of trainee progduration traineelevel detailses (not inclusive)
	 * @return the range of matching trainee progduration traineelevel detailses
	 */
	@Override
	public List<TraineeProgdurationTraineelevelDetails> findByUuid(
		String uuid, int start, int end) {

		return findByUuid(uuid, start, end, null);
	}

	/**
	 * Returns an ordered range of all the trainee progduration traineelevel detailses where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TraineeProgdurationTraineelevelDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of trainee progduration traineelevel detailses
	 * @param end the upper bound of the range of trainee progduration traineelevel detailses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching trainee progduration traineelevel detailses
	 */
	@Override
	public List<TraineeProgdurationTraineelevelDetails> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<TraineeProgdurationTraineelevelDetails>
			orderByComparator) {

		return findByUuid(uuid, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the trainee progduration traineelevel detailses where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TraineeProgdurationTraineelevelDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of trainee progduration traineelevel detailses
	 * @param end the upper bound of the range of trainee progduration traineelevel detailses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching trainee progduration traineelevel detailses
	 */
	@Override
	public List<TraineeProgdurationTraineelevelDetails> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<TraineeProgdurationTraineelevelDetails>
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

		List<TraineeProgdurationTraineelevelDetails> list = null;

		if (useFinderCache) {
			list =
				(List<TraineeProgdurationTraineelevelDetails>)
					finderCache.getResult(finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (TraineeProgdurationTraineelevelDetails
						traineeProgdurationTraineelevelDetails : list) {

					if (!uuid.equals(
							traineeProgdurationTraineelevelDetails.getUuid())) {

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

			sb.append(_SQL_SELECT_TRAINEEPROGDURATIONTRAINEELEVELDETAILS_WHERE);

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
					TraineeProgdurationTraineelevelDetailsModelImpl.
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
					(List<TraineeProgdurationTraineelevelDetails>)
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
	 * Returns the first trainee progduration traineelevel details in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching trainee progduration traineelevel details
	 * @throws NoSuchTraineeProgdurationTraineelevelDetailsException if a matching trainee progduration traineelevel details could not be found
	 */
	@Override
	public TraineeProgdurationTraineelevelDetails findByUuid_First(
			String uuid,
			OrderByComparator<TraineeProgdurationTraineelevelDetails>
				orderByComparator)
		throws NoSuchTraineeProgdurationTraineelevelDetailsException {

		TraineeProgdurationTraineelevelDetails
			traineeProgdurationTraineelevelDetails = fetchByUuid_First(
				uuid, orderByComparator);

		if (traineeProgdurationTraineelevelDetails != null) {
			return traineeProgdurationTraineelevelDetails;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchTraineeProgdurationTraineelevelDetailsException(
			sb.toString());
	}

	/**
	 * Returns the first trainee progduration traineelevel details in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching trainee progduration traineelevel details, or <code>null</code> if a matching trainee progduration traineelevel details could not be found
	 */
	@Override
	public TraineeProgdurationTraineelevelDetails fetchByUuid_First(
		String uuid,
		OrderByComparator<TraineeProgdurationTraineelevelDetails>
			orderByComparator) {

		List<TraineeProgdurationTraineelevelDetails> list = findByUuid(
			uuid, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last trainee progduration traineelevel details in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching trainee progduration traineelevel details
	 * @throws NoSuchTraineeProgdurationTraineelevelDetailsException if a matching trainee progduration traineelevel details could not be found
	 */
	@Override
	public TraineeProgdurationTraineelevelDetails findByUuid_Last(
			String uuid,
			OrderByComparator<TraineeProgdurationTraineelevelDetails>
				orderByComparator)
		throws NoSuchTraineeProgdurationTraineelevelDetailsException {

		TraineeProgdurationTraineelevelDetails
			traineeProgdurationTraineelevelDetails = fetchByUuid_Last(
				uuid, orderByComparator);

		if (traineeProgdurationTraineelevelDetails != null) {
			return traineeProgdurationTraineelevelDetails;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchTraineeProgdurationTraineelevelDetailsException(
			sb.toString());
	}

	/**
	 * Returns the last trainee progduration traineelevel details in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching trainee progduration traineelevel details, or <code>null</code> if a matching trainee progduration traineelevel details could not be found
	 */
	@Override
	public TraineeProgdurationTraineelevelDetails fetchByUuid_Last(
		String uuid,
		OrderByComparator<TraineeProgdurationTraineelevelDetails>
			orderByComparator) {

		int count = countByUuid(uuid);

		if (count == 0) {
			return null;
		}

		List<TraineeProgdurationTraineelevelDetails> list = findByUuid(
			uuid, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the trainee progduration traineelevel detailses before and after the current trainee progduration traineelevel details in the ordered set where uuid = &#63;.
	 *
	 * @param traineePdTlErDetailsId the primary key of the current trainee progduration traineelevel details
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next trainee progduration traineelevel details
	 * @throws NoSuchTraineeProgdurationTraineelevelDetailsException if a trainee progduration traineelevel details with the primary key could not be found
	 */
	@Override
	public TraineeProgdurationTraineelevelDetails[] findByUuid_PrevAndNext(
			long traineePdTlErDetailsId, String uuid,
			OrderByComparator<TraineeProgdurationTraineelevelDetails>
				orderByComparator)
		throws NoSuchTraineeProgdurationTraineelevelDetailsException {

		uuid = Objects.toString(uuid, "");

		TraineeProgdurationTraineelevelDetails
			traineeProgdurationTraineelevelDetails = findByPrimaryKey(
				traineePdTlErDetailsId);

		Session session = null;

		try {
			session = openSession();

			TraineeProgdurationTraineelevelDetails[] array =
				new TraineeProgdurationTraineelevelDetailsImpl[3];

			array[0] = getByUuid_PrevAndNext(
				session, traineeProgdurationTraineelevelDetails, uuid,
				orderByComparator, true);

			array[1] = traineeProgdurationTraineelevelDetails;

			array[2] = getByUuid_PrevAndNext(
				session, traineeProgdurationTraineelevelDetails, uuid,
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

	protected TraineeProgdurationTraineelevelDetails getByUuid_PrevAndNext(
		Session session,
		TraineeProgdurationTraineelevelDetails
			traineeProgdurationTraineelevelDetails,
		String uuid,
		OrderByComparator<TraineeProgdurationTraineelevelDetails>
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

		sb.append(_SQL_SELECT_TRAINEEPROGDURATIONTRAINEELEVELDETAILS_WHERE);

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
				TraineeProgdurationTraineelevelDetailsModelImpl.ORDER_BY_JPQL);
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
						traineeProgdurationTraineelevelDetails)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<TraineeProgdurationTraineelevelDetails> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the trainee progduration traineelevel detailses where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	@Override
	public void removeByUuid(String uuid) {
		for (TraineeProgdurationTraineelevelDetails
				traineeProgdurationTraineelevelDetails :
					findByUuid(
						uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(traineeProgdurationTraineelevelDetails);
		}
	}

	/**
	 * Returns the number of trainee progduration traineelevel detailses where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching trainee progduration traineelevel detailses
	 */
	@Override
	public int countByUuid(String uuid) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid;

		Object[] finderArgs = new Object[] {uuid};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_TRAINEEPROGDURATIONTRAINEELEVELDETAILS_WHERE);

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
		"traineeProgdurationTraineelevelDetails.uuid = ?";

	private static final String _FINDER_COLUMN_UUID_UUID_3 =
		"(traineeProgdurationTraineelevelDetails.uuid IS NULL OR traineeProgdurationTraineelevelDetails.uuid = '')";

	private FinderPath _finderPathFetchByUUID_G;
	private FinderPath _finderPathCountByUUID_G;

	/**
	 * Returns the trainee progduration traineelevel details where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchTraineeProgdurationTraineelevelDetailsException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching trainee progduration traineelevel details
	 * @throws NoSuchTraineeProgdurationTraineelevelDetailsException if a matching trainee progduration traineelevel details could not be found
	 */
	@Override
	public TraineeProgdurationTraineelevelDetails findByUUID_G(
			String uuid, long groupId)
		throws NoSuchTraineeProgdurationTraineelevelDetailsException {

		TraineeProgdurationTraineelevelDetails
			traineeProgdurationTraineelevelDetails = fetchByUUID_G(
				uuid, groupId);

		if (traineeProgdurationTraineelevelDetails == null) {
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

			throw new NoSuchTraineeProgdurationTraineelevelDetailsException(
				sb.toString());
		}

		return traineeProgdurationTraineelevelDetails;
	}

	/**
	 * Returns the trainee progduration traineelevel details where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching trainee progduration traineelevel details, or <code>null</code> if a matching trainee progduration traineelevel details could not be found
	 */
	@Override
	public TraineeProgdurationTraineelevelDetails fetchByUUID_G(
		String uuid, long groupId) {

		return fetchByUUID_G(uuid, groupId, true);
	}

	/**
	 * Returns the trainee progduration traineelevel details where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching trainee progduration traineelevel details, or <code>null</code> if a matching trainee progduration traineelevel details could not be found
	 */
	@Override
	public TraineeProgdurationTraineelevelDetails fetchByUUID_G(
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

		if (result instanceof TraineeProgdurationTraineelevelDetails) {
			TraineeProgdurationTraineelevelDetails
				traineeProgdurationTraineelevelDetails =
					(TraineeProgdurationTraineelevelDetails)result;

			if (!Objects.equals(
					uuid, traineeProgdurationTraineelevelDetails.getUuid()) ||
				(groupId !=
					traineeProgdurationTraineelevelDetails.getGroupId())) {

				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_SQL_SELECT_TRAINEEPROGDURATIONTRAINEELEVELDETAILS_WHERE);

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

				List<TraineeProgdurationTraineelevelDetails> list =
					query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchByUUID_G, finderArgs, list);
					}
				}
				else {
					TraineeProgdurationTraineelevelDetails
						traineeProgdurationTraineelevelDetails = list.get(0);

					result = traineeProgdurationTraineelevelDetails;

					cacheResult(traineeProgdurationTraineelevelDetails);
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
			return (TraineeProgdurationTraineelevelDetails)result;
		}
	}

	/**
	 * Removes the trainee progduration traineelevel details where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the trainee progduration traineelevel details that was removed
	 */
	@Override
	public TraineeProgdurationTraineelevelDetails removeByUUID_G(
			String uuid, long groupId)
		throws NoSuchTraineeProgdurationTraineelevelDetailsException {

		TraineeProgdurationTraineelevelDetails
			traineeProgdurationTraineelevelDetails = findByUUID_G(
				uuid, groupId);

		return remove(traineeProgdurationTraineelevelDetails);
	}

	/**
	 * Returns the number of trainee progduration traineelevel detailses where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching trainee progduration traineelevel detailses
	 */
	@Override
	public int countByUUID_G(String uuid, long groupId) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUUID_G;

		Object[] finderArgs = new Object[] {uuid, groupId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_TRAINEEPROGDURATIONTRAINEELEVELDETAILS_WHERE);

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
		"traineeProgdurationTraineelevelDetails.uuid = ? AND ";

	private static final String _FINDER_COLUMN_UUID_G_UUID_3 =
		"(traineeProgdurationTraineelevelDetails.uuid IS NULL OR traineeProgdurationTraineelevelDetails.uuid = '') AND ";

	private static final String _FINDER_COLUMN_UUID_G_GROUPID_2 =
		"traineeProgdurationTraineelevelDetails.groupId = ?";

	private FinderPath _finderPathWithPaginationFindByUuid_C;
	private FinderPath _finderPathWithoutPaginationFindByUuid_C;
	private FinderPath _finderPathCountByUuid_C;

	/**
	 * Returns all the trainee progduration traineelevel detailses where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching trainee progduration traineelevel detailses
	 */
	@Override
	public List<TraineeProgdurationTraineelevelDetails> findByUuid_C(
		String uuid, long companyId) {

		return findByUuid_C(
			uuid, companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the trainee progduration traineelevel detailses where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TraineeProgdurationTraineelevelDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of trainee progduration traineelevel detailses
	 * @param end the upper bound of the range of trainee progduration traineelevel detailses (not inclusive)
	 * @return the range of matching trainee progduration traineelevel detailses
	 */
	@Override
	public List<TraineeProgdurationTraineelevelDetails> findByUuid_C(
		String uuid, long companyId, int start, int end) {

		return findByUuid_C(uuid, companyId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the trainee progduration traineelevel detailses where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TraineeProgdurationTraineelevelDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of trainee progduration traineelevel detailses
	 * @param end the upper bound of the range of trainee progduration traineelevel detailses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching trainee progduration traineelevel detailses
	 */
	@Override
	public List<TraineeProgdurationTraineelevelDetails> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<TraineeProgdurationTraineelevelDetails>
			orderByComparator) {

		return findByUuid_C(
			uuid, companyId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the trainee progduration traineelevel detailses where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TraineeProgdurationTraineelevelDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of trainee progduration traineelevel detailses
	 * @param end the upper bound of the range of trainee progduration traineelevel detailses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching trainee progduration traineelevel detailses
	 */
	@Override
	public List<TraineeProgdurationTraineelevelDetails> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<TraineeProgdurationTraineelevelDetails>
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

		List<TraineeProgdurationTraineelevelDetails> list = null;

		if (useFinderCache) {
			list =
				(List<TraineeProgdurationTraineelevelDetails>)
					finderCache.getResult(finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (TraineeProgdurationTraineelevelDetails
						traineeProgdurationTraineelevelDetails : list) {

					if (!uuid.equals(
							traineeProgdurationTraineelevelDetails.getUuid()) ||
						(companyId !=
							traineeProgdurationTraineelevelDetails.
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

			sb.append(_SQL_SELECT_TRAINEEPROGDURATIONTRAINEELEVELDETAILS_WHERE);

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
					TraineeProgdurationTraineelevelDetailsModelImpl.
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
					(List<TraineeProgdurationTraineelevelDetails>)
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
	 * Returns the first trainee progduration traineelevel details in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching trainee progduration traineelevel details
	 * @throws NoSuchTraineeProgdurationTraineelevelDetailsException if a matching trainee progduration traineelevel details could not be found
	 */
	@Override
	public TraineeProgdurationTraineelevelDetails findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<TraineeProgdurationTraineelevelDetails>
				orderByComparator)
		throws NoSuchTraineeProgdurationTraineelevelDetailsException {

		TraineeProgdurationTraineelevelDetails
			traineeProgdurationTraineelevelDetails = fetchByUuid_C_First(
				uuid, companyId, orderByComparator);

		if (traineeProgdurationTraineelevelDetails != null) {
			return traineeProgdurationTraineelevelDetails;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append(", companyId=");
		sb.append(companyId);

		sb.append("}");

		throw new NoSuchTraineeProgdurationTraineelevelDetailsException(
			sb.toString());
	}

	/**
	 * Returns the first trainee progduration traineelevel details in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching trainee progduration traineelevel details, or <code>null</code> if a matching trainee progduration traineelevel details could not be found
	 */
	@Override
	public TraineeProgdurationTraineelevelDetails fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<TraineeProgdurationTraineelevelDetails>
			orderByComparator) {

		List<TraineeProgdurationTraineelevelDetails> list = findByUuid_C(
			uuid, companyId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last trainee progduration traineelevel details in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching trainee progduration traineelevel details
	 * @throws NoSuchTraineeProgdurationTraineelevelDetailsException if a matching trainee progduration traineelevel details could not be found
	 */
	@Override
	public TraineeProgdurationTraineelevelDetails findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<TraineeProgdurationTraineelevelDetails>
				orderByComparator)
		throws NoSuchTraineeProgdurationTraineelevelDetailsException {

		TraineeProgdurationTraineelevelDetails
			traineeProgdurationTraineelevelDetails = fetchByUuid_C_Last(
				uuid, companyId, orderByComparator);

		if (traineeProgdurationTraineelevelDetails != null) {
			return traineeProgdurationTraineelevelDetails;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append(", companyId=");
		sb.append(companyId);

		sb.append("}");

		throw new NoSuchTraineeProgdurationTraineelevelDetailsException(
			sb.toString());
	}

	/**
	 * Returns the last trainee progduration traineelevel details in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching trainee progduration traineelevel details, or <code>null</code> if a matching trainee progduration traineelevel details could not be found
	 */
	@Override
	public TraineeProgdurationTraineelevelDetails fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<TraineeProgdurationTraineelevelDetails>
			orderByComparator) {

		int count = countByUuid_C(uuid, companyId);

		if (count == 0) {
			return null;
		}

		List<TraineeProgdurationTraineelevelDetails> list = findByUuid_C(
			uuid, companyId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the trainee progduration traineelevel detailses before and after the current trainee progduration traineelevel details in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param traineePdTlErDetailsId the primary key of the current trainee progduration traineelevel details
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next trainee progduration traineelevel details
	 * @throws NoSuchTraineeProgdurationTraineelevelDetailsException if a trainee progduration traineelevel details with the primary key could not be found
	 */
	@Override
	public TraineeProgdurationTraineelevelDetails[] findByUuid_C_PrevAndNext(
			long traineePdTlErDetailsId, String uuid, long companyId,
			OrderByComparator<TraineeProgdurationTraineelevelDetails>
				orderByComparator)
		throws NoSuchTraineeProgdurationTraineelevelDetailsException {

		uuid = Objects.toString(uuid, "");

		TraineeProgdurationTraineelevelDetails
			traineeProgdurationTraineelevelDetails = findByPrimaryKey(
				traineePdTlErDetailsId);

		Session session = null;

		try {
			session = openSession();

			TraineeProgdurationTraineelevelDetails[] array =
				new TraineeProgdurationTraineelevelDetailsImpl[3];

			array[0] = getByUuid_C_PrevAndNext(
				session, traineeProgdurationTraineelevelDetails, uuid,
				companyId, orderByComparator, true);

			array[1] = traineeProgdurationTraineelevelDetails;

			array[2] = getByUuid_C_PrevAndNext(
				session, traineeProgdurationTraineelevelDetails, uuid,
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

	protected TraineeProgdurationTraineelevelDetails getByUuid_C_PrevAndNext(
		Session session,
		TraineeProgdurationTraineelevelDetails
			traineeProgdurationTraineelevelDetails,
		String uuid, long companyId,
		OrderByComparator<TraineeProgdurationTraineelevelDetails>
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

		sb.append(_SQL_SELECT_TRAINEEPROGDURATIONTRAINEELEVELDETAILS_WHERE);

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
				TraineeProgdurationTraineelevelDetailsModelImpl.ORDER_BY_JPQL);
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
						traineeProgdurationTraineelevelDetails)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<TraineeProgdurationTraineelevelDetails> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the trainee progduration traineelevel detailses where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	@Override
	public void removeByUuid_C(String uuid, long companyId) {
		for (TraineeProgdurationTraineelevelDetails
				traineeProgdurationTraineelevelDetails :
					findByUuid_C(
						uuid, companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
						null)) {

			remove(traineeProgdurationTraineelevelDetails);
		}
	}

	/**
	 * Returns the number of trainee progduration traineelevel detailses where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching trainee progduration traineelevel detailses
	 */
	@Override
	public int countByUuid_C(String uuid, long companyId) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid_C;

		Object[] finderArgs = new Object[] {uuid, companyId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_TRAINEEPROGDURATIONTRAINEELEVELDETAILS_WHERE);

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
		"traineeProgdurationTraineelevelDetails.uuid = ? AND ";

	private static final String _FINDER_COLUMN_UUID_C_UUID_3 =
		"(traineeProgdurationTraineelevelDetails.uuid IS NULL OR traineeProgdurationTraineelevelDetails.uuid = '') AND ";

	private static final String _FINDER_COLUMN_UUID_C_COMPANYID_2 =
		"traineeProgdurationTraineelevelDetails.companyId = ?";

	private FinderPath _finderPathWithPaginationFindByTraineeId;
	private FinderPath _finderPathWithoutPaginationFindByTraineeId;
	private FinderPath _finderPathCountByTraineeId;

	/**
	 * Returns all the trainee progduration traineelevel detailses where traineeId = &#63;.
	 *
	 * @param traineeId the trainee ID
	 * @return the matching trainee progduration traineelevel detailses
	 */
	@Override
	public List<TraineeProgdurationTraineelevelDetails> findByTraineeId(
		long traineeId) {

		return findByTraineeId(
			traineeId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the trainee progduration traineelevel detailses where traineeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TraineeProgdurationTraineelevelDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param traineeId the trainee ID
	 * @param start the lower bound of the range of trainee progduration traineelevel detailses
	 * @param end the upper bound of the range of trainee progduration traineelevel detailses (not inclusive)
	 * @return the range of matching trainee progduration traineelevel detailses
	 */
	@Override
	public List<TraineeProgdurationTraineelevelDetails> findByTraineeId(
		long traineeId, int start, int end) {

		return findByTraineeId(traineeId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the trainee progduration traineelevel detailses where traineeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TraineeProgdurationTraineelevelDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param traineeId the trainee ID
	 * @param start the lower bound of the range of trainee progduration traineelevel detailses
	 * @param end the upper bound of the range of trainee progduration traineelevel detailses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching trainee progduration traineelevel detailses
	 */
	@Override
	public List<TraineeProgdurationTraineelevelDetails> findByTraineeId(
		long traineeId, int start, int end,
		OrderByComparator<TraineeProgdurationTraineelevelDetails>
			orderByComparator) {

		return findByTraineeId(traineeId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the trainee progduration traineelevel detailses where traineeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TraineeProgdurationTraineelevelDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param traineeId the trainee ID
	 * @param start the lower bound of the range of trainee progduration traineelevel detailses
	 * @param end the upper bound of the range of trainee progduration traineelevel detailses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching trainee progduration traineelevel detailses
	 */
	@Override
	public List<TraineeProgdurationTraineelevelDetails> findByTraineeId(
		long traineeId, int start, int end,
		OrderByComparator<TraineeProgdurationTraineelevelDetails>
			orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByTraineeId;
				finderArgs = new Object[] {traineeId};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByTraineeId;
			finderArgs = new Object[] {
				traineeId, start, end, orderByComparator
			};
		}

		List<TraineeProgdurationTraineelevelDetails> list = null;

		if (useFinderCache) {
			list =
				(List<TraineeProgdurationTraineelevelDetails>)
					finderCache.getResult(finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (TraineeProgdurationTraineelevelDetails
						traineeProgdurationTraineelevelDetails : list) {

					if (traineeId !=
							traineeProgdurationTraineelevelDetails.
								getTraineeId()) {

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

			sb.append(_SQL_SELECT_TRAINEEPROGDURATIONTRAINEELEVELDETAILS_WHERE);

			sb.append(_FINDER_COLUMN_TRAINEEID_TRAINEEID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(
					TraineeProgdurationTraineelevelDetailsModelImpl.
						ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(traineeId);

				list =
					(List<TraineeProgdurationTraineelevelDetails>)
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
	 * Returns the first trainee progduration traineelevel details in the ordered set where traineeId = &#63;.
	 *
	 * @param traineeId the trainee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching trainee progduration traineelevel details
	 * @throws NoSuchTraineeProgdurationTraineelevelDetailsException if a matching trainee progduration traineelevel details could not be found
	 */
	@Override
	public TraineeProgdurationTraineelevelDetails findByTraineeId_First(
			long traineeId,
			OrderByComparator<TraineeProgdurationTraineelevelDetails>
				orderByComparator)
		throws NoSuchTraineeProgdurationTraineelevelDetailsException {

		TraineeProgdurationTraineelevelDetails
			traineeProgdurationTraineelevelDetails = fetchByTraineeId_First(
				traineeId, orderByComparator);

		if (traineeProgdurationTraineelevelDetails != null) {
			return traineeProgdurationTraineelevelDetails;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("traineeId=");
		sb.append(traineeId);

		sb.append("}");

		throw new NoSuchTraineeProgdurationTraineelevelDetailsException(
			sb.toString());
	}

	/**
	 * Returns the first trainee progduration traineelevel details in the ordered set where traineeId = &#63;.
	 *
	 * @param traineeId the trainee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching trainee progduration traineelevel details, or <code>null</code> if a matching trainee progduration traineelevel details could not be found
	 */
	@Override
	public TraineeProgdurationTraineelevelDetails fetchByTraineeId_First(
		long traineeId,
		OrderByComparator<TraineeProgdurationTraineelevelDetails>
			orderByComparator) {

		List<TraineeProgdurationTraineelevelDetails> list = findByTraineeId(
			traineeId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last trainee progduration traineelevel details in the ordered set where traineeId = &#63;.
	 *
	 * @param traineeId the trainee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching trainee progduration traineelevel details
	 * @throws NoSuchTraineeProgdurationTraineelevelDetailsException if a matching trainee progduration traineelevel details could not be found
	 */
	@Override
	public TraineeProgdurationTraineelevelDetails findByTraineeId_Last(
			long traineeId,
			OrderByComparator<TraineeProgdurationTraineelevelDetails>
				orderByComparator)
		throws NoSuchTraineeProgdurationTraineelevelDetailsException {

		TraineeProgdurationTraineelevelDetails
			traineeProgdurationTraineelevelDetails = fetchByTraineeId_Last(
				traineeId, orderByComparator);

		if (traineeProgdurationTraineelevelDetails != null) {
			return traineeProgdurationTraineelevelDetails;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("traineeId=");
		sb.append(traineeId);

		sb.append("}");

		throw new NoSuchTraineeProgdurationTraineelevelDetailsException(
			sb.toString());
	}

	/**
	 * Returns the last trainee progduration traineelevel details in the ordered set where traineeId = &#63;.
	 *
	 * @param traineeId the trainee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching trainee progduration traineelevel details, or <code>null</code> if a matching trainee progduration traineelevel details could not be found
	 */
	@Override
	public TraineeProgdurationTraineelevelDetails fetchByTraineeId_Last(
		long traineeId,
		OrderByComparator<TraineeProgdurationTraineelevelDetails>
			orderByComparator) {

		int count = countByTraineeId(traineeId);

		if (count == 0) {
			return null;
		}

		List<TraineeProgdurationTraineelevelDetails> list = findByTraineeId(
			traineeId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the trainee progduration traineelevel detailses before and after the current trainee progduration traineelevel details in the ordered set where traineeId = &#63;.
	 *
	 * @param traineePdTlErDetailsId the primary key of the current trainee progduration traineelevel details
	 * @param traineeId the trainee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next trainee progduration traineelevel details
	 * @throws NoSuchTraineeProgdurationTraineelevelDetailsException if a trainee progduration traineelevel details with the primary key could not be found
	 */
	@Override
	public TraineeProgdurationTraineelevelDetails[] findByTraineeId_PrevAndNext(
			long traineePdTlErDetailsId, long traineeId,
			OrderByComparator<TraineeProgdurationTraineelevelDetails>
				orderByComparator)
		throws NoSuchTraineeProgdurationTraineelevelDetailsException {

		TraineeProgdurationTraineelevelDetails
			traineeProgdurationTraineelevelDetails = findByPrimaryKey(
				traineePdTlErDetailsId);

		Session session = null;

		try {
			session = openSession();

			TraineeProgdurationTraineelevelDetails[] array =
				new TraineeProgdurationTraineelevelDetailsImpl[3];

			array[0] = getByTraineeId_PrevAndNext(
				session, traineeProgdurationTraineelevelDetails, traineeId,
				orderByComparator, true);

			array[1] = traineeProgdurationTraineelevelDetails;

			array[2] = getByTraineeId_PrevAndNext(
				session, traineeProgdurationTraineelevelDetails, traineeId,
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

	protected TraineeProgdurationTraineelevelDetails getByTraineeId_PrevAndNext(
		Session session,
		TraineeProgdurationTraineelevelDetails
			traineeProgdurationTraineelevelDetails,
		long traineeId,
		OrderByComparator<TraineeProgdurationTraineelevelDetails>
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

		sb.append(_SQL_SELECT_TRAINEEPROGDURATIONTRAINEELEVELDETAILS_WHERE);

		sb.append(_FINDER_COLUMN_TRAINEEID_TRAINEEID_2);

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
				TraineeProgdurationTraineelevelDetailsModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(traineeId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						traineeProgdurationTraineelevelDetails)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<TraineeProgdurationTraineelevelDetails> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the trainee progduration traineelevel detailses where traineeId = &#63; from the database.
	 *
	 * @param traineeId the trainee ID
	 */
	@Override
	public void removeByTraineeId(long traineeId) {
		for (TraineeProgdurationTraineelevelDetails
				traineeProgdurationTraineelevelDetails :
					findByTraineeId(
						traineeId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
						null)) {

			remove(traineeProgdurationTraineelevelDetails);
		}
	}

	/**
	 * Returns the number of trainee progduration traineelevel detailses where traineeId = &#63;.
	 *
	 * @param traineeId the trainee ID
	 * @return the number of matching trainee progduration traineelevel detailses
	 */
	@Override
	public int countByTraineeId(long traineeId) {
		FinderPath finderPath = _finderPathCountByTraineeId;

		Object[] finderArgs = new Object[] {traineeId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_TRAINEEPROGDURATIONTRAINEELEVELDETAILS_WHERE);

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
		"traineeProgdurationTraineelevelDetails.traineeId = ?";

	private FinderPath _finderPathFetchByTraineeIdAndTraineeLevelId;
	private FinderPath _finderPathCountByTraineeIdAndTraineeLevelId;

	/**
	 * Returns the trainee progduration traineelevel details where traineeId = &#63; and traineeLevelId = &#63; or throws a <code>NoSuchTraineeProgdurationTraineelevelDetailsException</code> if it could not be found.
	 *
	 * @param traineeId the trainee ID
	 * @param traineeLevelId the trainee level ID
	 * @return the matching trainee progduration traineelevel details
	 * @throws NoSuchTraineeProgdurationTraineelevelDetailsException if a matching trainee progduration traineelevel details could not be found
	 */
	@Override
	public TraineeProgdurationTraineelevelDetails
			findByTraineeIdAndTraineeLevelId(
				long traineeId, long traineeLevelId)
		throws NoSuchTraineeProgdurationTraineelevelDetailsException {

		TraineeProgdurationTraineelevelDetails
			traineeProgdurationTraineelevelDetails =
				fetchByTraineeIdAndTraineeLevelId(traineeId, traineeLevelId);

		if (traineeProgdurationTraineelevelDetails == null) {
			StringBundler sb = new StringBundler(6);

			sb.append(_NO_SUCH_ENTITY_WITH_KEY);

			sb.append("traineeId=");
			sb.append(traineeId);

			sb.append(", traineeLevelId=");
			sb.append(traineeLevelId);

			sb.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(sb.toString());
			}

			throw new NoSuchTraineeProgdurationTraineelevelDetailsException(
				sb.toString());
		}

		return traineeProgdurationTraineelevelDetails;
	}

	/**
	 * Returns the trainee progduration traineelevel details where traineeId = &#63; and traineeLevelId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param traineeId the trainee ID
	 * @param traineeLevelId the trainee level ID
	 * @return the matching trainee progduration traineelevel details, or <code>null</code> if a matching trainee progduration traineelevel details could not be found
	 */
	@Override
	public TraineeProgdurationTraineelevelDetails
		fetchByTraineeIdAndTraineeLevelId(long traineeId, long traineeLevelId) {

		return fetchByTraineeIdAndTraineeLevelId(
			traineeId, traineeLevelId, true);
	}

	/**
	 * Returns the trainee progduration traineelevel details where traineeId = &#63; and traineeLevelId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param traineeId the trainee ID
	 * @param traineeLevelId the trainee level ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching trainee progduration traineelevel details, or <code>null</code> if a matching trainee progduration traineelevel details could not be found
	 */
	@Override
	public TraineeProgdurationTraineelevelDetails
		fetchByTraineeIdAndTraineeLevelId(
			long traineeId, long traineeLevelId, boolean useFinderCache) {

		Object[] finderArgs = null;

		if (useFinderCache) {
			finderArgs = new Object[] {traineeId, traineeLevelId};
		}

		Object result = null;

		if (useFinderCache) {
			result = finderCache.getResult(
				_finderPathFetchByTraineeIdAndTraineeLevelId, finderArgs, this);
		}

		if (result instanceof TraineeProgdurationTraineelevelDetails) {
			TraineeProgdurationTraineelevelDetails
				traineeProgdurationTraineelevelDetails =
					(TraineeProgdurationTraineelevelDetails)result;

			if ((traineeId !=
					traineeProgdurationTraineelevelDetails.getTraineeId()) ||
				(traineeLevelId !=
					traineeProgdurationTraineelevelDetails.
						getTraineeLevelId())) {

				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_SQL_SELECT_TRAINEEPROGDURATIONTRAINEELEVELDETAILS_WHERE);

			sb.append(_FINDER_COLUMN_TRAINEEIDANDTRAINEELEVELID_TRAINEEID_2);

			sb.append(
				_FINDER_COLUMN_TRAINEEIDANDTRAINEELEVELID_TRAINEELEVELID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(traineeId);

				queryPos.add(traineeLevelId);

				List<TraineeProgdurationTraineelevelDetails> list =
					query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchByTraineeIdAndTraineeLevelId,
							finderArgs, list);
					}
				}
				else {
					if (list.size() > 1) {
						Collections.sort(list, Collections.reverseOrder());

						if (_log.isWarnEnabled()) {
							if (!useFinderCache) {
								finderArgs = new Object[] {
									traineeId, traineeLevelId
								};
							}

							_log.warn(
								"TraineeProgdurationTraineelevelDetailsPersistenceImpl.fetchByTraineeIdAndTraineeLevelId(long, long, boolean) with parameters (" +
									StringUtil.merge(finderArgs) +
										") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
						}
					}

					TraineeProgdurationTraineelevelDetails
						traineeProgdurationTraineelevelDetails = list.get(0);

					result = traineeProgdurationTraineelevelDetails;

					cacheResult(traineeProgdurationTraineelevelDetails);
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
			return (TraineeProgdurationTraineelevelDetails)result;
		}
	}

	/**
	 * Removes the trainee progduration traineelevel details where traineeId = &#63; and traineeLevelId = &#63; from the database.
	 *
	 * @param traineeId the trainee ID
	 * @param traineeLevelId the trainee level ID
	 * @return the trainee progduration traineelevel details that was removed
	 */
	@Override
	public TraineeProgdurationTraineelevelDetails
			removeByTraineeIdAndTraineeLevelId(
				long traineeId, long traineeLevelId)
		throws NoSuchTraineeProgdurationTraineelevelDetailsException {

		TraineeProgdurationTraineelevelDetails
			traineeProgdurationTraineelevelDetails =
				findByTraineeIdAndTraineeLevelId(traineeId, traineeLevelId);

		return remove(traineeProgdurationTraineelevelDetails);
	}

	/**
	 * Returns the number of trainee progduration traineelevel detailses where traineeId = &#63; and traineeLevelId = &#63;.
	 *
	 * @param traineeId the trainee ID
	 * @param traineeLevelId the trainee level ID
	 * @return the number of matching trainee progduration traineelevel detailses
	 */
	@Override
	public int countByTraineeIdAndTraineeLevelId(
		long traineeId, long traineeLevelId) {

		FinderPath finderPath = _finderPathCountByTraineeIdAndTraineeLevelId;

		Object[] finderArgs = new Object[] {traineeId, traineeLevelId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_TRAINEEPROGDURATIONTRAINEELEVELDETAILS_WHERE);

			sb.append(_FINDER_COLUMN_TRAINEEIDANDTRAINEELEVELID_TRAINEEID_2);

			sb.append(
				_FINDER_COLUMN_TRAINEEIDANDTRAINEELEVELID_TRAINEELEVELID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(traineeId);

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
		_FINDER_COLUMN_TRAINEEIDANDTRAINEELEVELID_TRAINEEID_2 =
			"traineeProgdurationTraineelevelDetails.traineeId = ? AND ";

	private static final String
		_FINDER_COLUMN_TRAINEEIDANDTRAINEELEVELID_TRAINEELEVELID_2 =
			"traineeProgdurationTraineelevelDetails.traineeLevelId = ?";

	private FinderPath
		_finderPathWithPaginationFindByTraineeIdAndProgramDurationId;
	private FinderPath
		_finderPathWithoutPaginationFindByTraineeIdAndProgramDurationId;
	private FinderPath _finderPathCountByTraineeIdAndProgramDurationId;

	/**
	 * Returns all the trainee progduration traineelevel detailses where traineeId = &#63; and programDurationId = &#63;.
	 *
	 * @param traineeId the trainee ID
	 * @param programDurationId the program duration ID
	 * @return the matching trainee progduration traineelevel detailses
	 */
	@Override
	public List<TraineeProgdurationTraineelevelDetails>
		findByTraineeIdAndProgramDurationId(
			long traineeId, long programDurationId) {

		return findByTraineeIdAndProgramDurationId(
			traineeId, programDurationId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
	}

	/**
	 * Returns a range of all the trainee progduration traineelevel detailses where traineeId = &#63; and programDurationId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TraineeProgdurationTraineelevelDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param traineeId the trainee ID
	 * @param programDurationId the program duration ID
	 * @param start the lower bound of the range of trainee progduration traineelevel detailses
	 * @param end the upper bound of the range of trainee progduration traineelevel detailses (not inclusive)
	 * @return the range of matching trainee progduration traineelevel detailses
	 */
	@Override
	public List<TraineeProgdurationTraineelevelDetails>
		findByTraineeIdAndProgramDurationId(
			long traineeId, long programDurationId, int start, int end) {

		return findByTraineeIdAndProgramDurationId(
			traineeId, programDurationId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the trainee progduration traineelevel detailses where traineeId = &#63; and programDurationId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TraineeProgdurationTraineelevelDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param traineeId the trainee ID
	 * @param programDurationId the program duration ID
	 * @param start the lower bound of the range of trainee progduration traineelevel detailses
	 * @param end the upper bound of the range of trainee progduration traineelevel detailses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching trainee progduration traineelevel detailses
	 */
	@Override
	public List<TraineeProgdurationTraineelevelDetails>
		findByTraineeIdAndProgramDurationId(
			long traineeId, long programDurationId, int start, int end,
			OrderByComparator<TraineeProgdurationTraineelevelDetails>
				orderByComparator) {

		return findByTraineeIdAndProgramDurationId(
			traineeId, programDurationId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the trainee progduration traineelevel detailses where traineeId = &#63; and programDurationId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TraineeProgdurationTraineelevelDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param traineeId the trainee ID
	 * @param programDurationId the program duration ID
	 * @param start the lower bound of the range of trainee progduration traineelevel detailses
	 * @param end the upper bound of the range of trainee progduration traineelevel detailses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching trainee progduration traineelevel detailses
	 */
	@Override
	public List<TraineeProgdurationTraineelevelDetails>
		findByTraineeIdAndProgramDurationId(
			long traineeId, long programDurationId, int start, int end,
			OrderByComparator<TraineeProgdurationTraineelevelDetails>
				orderByComparator,
			boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath =
					_finderPathWithoutPaginationFindByTraineeIdAndProgramDurationId;
				finderArgs = new Object[] {traineeId, programDurationId};
			}
		}
		else if (useFinderCache) {
			finderPath =
				_finderPathWithPaginationFindByTraineeIdAndProgramDurationId;
			finderArgs = new Object[] {
				traineeId, programDurationId, start, end, orderByComparator
			};
		}

		List<TraineeProgdurationTraineelevelDetails> list = null;

		if (useFinderCache) {
			list =
				(List<TraineeProgdurationTraineelevelDetails>)
					finderCache.getResult(finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (TraineeProgdurationTraineelevelDetails
						traineeProgdurationTraineelevelDetails : list) {

					if ((traineeId !=
							traineeProgdurationTraineelevelDetails.
								getTraineeId()) ||
						(programDurationId !=
							traineeProgdurationTraineelevelDetails.
								getProgramDurationId())) {

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

			sb.append(_SQL_SELECT_TRAINEEPROGDURATIONTRAINEELEVELDETAILS_WHERE);

			sb.append(_FINDER_COLUMN_TRAINEEIDANDPROGRAMDURATIONID_TRAINEEID_2);

			sb.append(
				_FINDER_COLUMN_TRAINEEIDANDPROGRAMDURATIONID_PROGRAMDURATIONID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(
					TraineeProgdurationTraineelevelDetailsModelImpl.
						ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(traineeId);

				queryPos.add(programDurationId);

				list =
					(List<TraineeProgdurationTraineelevelDetails>)
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
	 * Returns the first trainee progduration traineelevel details in the ordered set where traineeId = &#63; and programDurationId = &#63;.
	 *
	 * @param traineeId the trainee ID
	 * @param programDurationId the program duration ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching trainee progduration traineelevel details
	 * @throws NoSuchTraineeProgdurationTraineelevelDetailsException if a matching trainee progduration traineelevel details could not be found
	 */
	@Override
	public TraineeProgdurationTraineelevelDetails
			findByTraineeIdAndProgramDurationId_First(
				long traineeId, long programDurationId,
				OrderByComparator<TraineeProgdurationTraineelevelDetails>
					orderByComparator)
		throws NoSuchTraineeProgdurationTraineelevelDetailsException {

		TraineeProgdurationTraineelevelDetails
			traineeProgdurationTraineelevelDetails =
				fetchByTraineeIdAndProgramDurationId_First(
					traineeId, programDurationId, orderByComparator);

		if (traineeProgdurationTraineelevelDetails != null) {
			return traineeProgdurationTraineelevelDetails;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("traineeId=");
		sb.append(traineeId);

		sb.append(", programDurationId=");
		sb.append(programDurationId);

		sb.append("}");

		throw new NoSuchTraineeProgdurationTraineelevelDetailsException(
			sb.toString());
	}

	/**
	 * Returns the first trainee progduration traineelevel details in the ordered set where traineeId = &#63; and programDurationId = &#63;.
	 *
	 * @param traineeId the trainee ID
	 * @param programDurationId the program duration ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching trainee progduration traineelevel details, or <code>null</code> if a matching trainee progduration traineelevel details could not be found
	 */
	@Override
	public TraineeProgdurationTraineelevelDetails
		fetchByTraineeIdAndProgramDurationId_First(
			long traineeId, long programDurationId,
			OrderByComparator<TraineeProgdurationTraineelevelDetails>
				orderByComparator) {

		List<TraineeProgdurationTraineelevelDetails> list =
			findByTraineeIdAndProgramDurationId(
				traineeId, programDurationId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last trainee progduration traineelevel details in the ordered set where traineeId = &#63; and programDurationId = &#63;.
	 *
	 * @param traineeId the trainee ID
	 * @param programDurationId the program duration ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching trainee progduration traineelevel details
	 * @throws NoSuchTraineeProgdurationTraineelevelDetailsException if a matching trainee progduration traineelevel details could not be found
	 */
	@Override
	public TraineeProgdurationTraineelevelDetails
			findByTraineeIdAndProgramDurationId_Last(
				long traineeId, long programDurationId,
				OrderByComparator<TraineeProgdurationTraineelevelDetails>
					orderByComparator)
		throws NoSuchTraineeProgdurationTraineelevelDetailsException {

		TraineeProgdurationTraineelevelDetails
			traineeProgdurationTraineelevelDetails =
				fetchByTraineeIdAndProgramDurationId_Last(
					traineeId, programDurationId, orderByComparator);

		if (traineeProgdurationTraineelevelDetails != null) {
			return traineeProgdurationTraineelevelDetails;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("traineeId=");
		sb.append(traineeId);

		sb.append(", programDurationId=");
		sb.append(programDurationId);

		sb.append("}");

		throw new NoSuchTraineeProgdurationTraineelevelDetailsException(
			sb.toString());
	}

	/**
	 * Returns the last trainee progduration traineelevel details in the ordered set where traineeId = &#63; and programDurationId = &#63;.
	 *
	 * @param traineeId the trainee ID
	 * @param programDurationId the program duration ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching trainee progduration traineelevel details, or <code>null</code> if a matching trainee progduration traineelevel details could not be found
	 */
	@Override
	public TraineeProgdurationTraineelevelDetails
		fetchByTraineeIdAndProgramDurationId_Last(
			long traineeId, long programDurationId,
			OrderByComparator<TraineeProgdurationTraineelevelDetails>
				orderByComparator) {

		int count = countByTraineeIdAndProgramDurationId(
			traineeId, programDurationId);

		if (count == 0) {
			return null;
		}

		List<TraineeProgdurationTraineelevelDetails> list =
			findByTraineeIdAndProgramDurationId(
				traineeId, programDurationId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the trainee progduration traineelevel detailses before and after the current trainee progduration traineelevel details in the ordered set where traineeId = &#63; and programDurationId = &#63;.
	 *
	 * @param traineePdTlErDetailsId the primary key of the current trainee progduration traineelevel details
	 * @param traineeId the trainee ID
	 * @param programDurationId the program duration ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next trainee progduration traineelevel details
	 * @throws NoSuchTraineeProgdurationTraineelevelDetailsException if a trainee progduration traineelevel details with the primary key could not be found
	 */
	@Override
	public TraineeProgdurationTraineelevelDetails[]
			findByTraineeIdAndProgramDurationId_PrevAndNext(
				long traineePdTlErDetailsId, long traineeId,
				long programDurationId,
				OrderByComparator<TraineeProgdurationTraineelevelDetails>
					orderByComparator)
		throws NoSuchTraineeProgdurationTraineelevelDetailsException {

		TraineeProgdurationTraineelevelDetails
			traineeProgdurationTraineelevelDetails = findByPrimaryKey(
				traineePdTlErDetailsId);

		Session session = null;

		try {
			session = openSession();

			TraineeProgdurationTraineelevelDetails[] array =
				new TraineeProgdurationTraineelevelDetailsImpl[3];

			array[0] = getByTraineeIdAndProgramDurationId_PrevAndNext(
				session, traineeProgdurationTraineelevelDetails, traineeId,
				programDurationId, orderByComparator, true);

			array[1] = traineeProgdurationTraineelevelDetails;

			array[2] = getByTraineeIdAndProgramDurationId_PrevAndNext(
				session, traineeProgdurationTraineelevelDetails, traineeId,
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

	protected TraineeProgdurationTraineelevelDetails
		getByTraineeIdAndProgramDurationId_PrevAndNext(
			Session session,
			TraineeProgdurationTraineelevelDetails
				traineeProgdurationTraineelevelDetails,
			long traineeId, long programDurationId,
			OrderByComparator<TraineeProgdurationTraineelevelDetails>
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

		sb.append(_SQL_SELECT_TRAINEEPROGDURATIONTRAINEELEVELDETAILS_WHERE);

		sb.append(_FINDER_COLUMN_TRAINEEIDANDPROGRAMDURATIONID_TRAINEEID_2);

		sb.append(
			_FINDER_COLUMN_TRAINEEIDANDPROGRAMDURATIONID_PROGRAMDURATIONID_2);

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
				TraineeProgdurationTraineelevelDetailsModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(traineeId);

		queryPos.add(programDurationId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						traineeProgdurationTraineelevelDetails)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<TraineeProgdurationTraineelevelDetails> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the trainee progduration traineelevel detailses where traineeId = &#63; and programDurationId = &#63; from the database.
	 *
	 * @param traineeId the trainee ID
	 * @param programDurationId the program duration ID
	 */
	@Override
	public void removeByTraineeIdAndProgramDurationId(
		long traineeId, long programDurationId) {

		for (TraineeProgdurationTraineelevelDetails
				traineeProgdurationTraineelevelDetails :
					findByTraineeIdAndProgramDurationId(
						traineeId, programDurationId, QueryUtil.ALL_POS,
						QueryUtil.ALL_POS, null)) {

			remove(traineeProgdurationTraineelevelDetails);
		}
	}

	/**
	 * Returns the number of trainee progduration traineelevel detailses where traineeId = &#63; and programDurationId = &#63;.
	 *
	 * @param traineeId the trainee ID
	 * @param programDurationId the program duration ID
	 * @return the number of matching trainee progduration traineelevel detailses
	 */
	@Override
	public int countByTraineeIdAndProgramDurationId(
		long traineeId, long programDurationId) {

		FinderPath finderPath = _finderPathCountByTraineeIdAndProgramDurationId;

		Object[] finderArgs = new Object[] {traineeId, programDurationId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_TRAINEEPROGDURATIONTRAINEELEVELDETAILS_WHERE);

			sb.append(_FINDER_COLUMN_TRAINEEIDANDPROGRAMDURATIONID_TRAINEEID_2);

			sb.append(
				_FINDER_COLUMN_TRAINEEIDANDPROGRAMDURATIONID_PROGRAMDURATIONID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(traineeId);

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
		_FINDER_COLUMN_TRAINEEIDANDPROGRAMDURATIONID_TRAINEEID_2 =
			"traineeProgdurationTraineelevelDetails.traineeId = ? AND ";

	private static final String
		_FINDER_COLUMN_TRAINEEIDANDPROGRAMDURATIONID_PROGRAMDURATIONID_2 =
			"traineeProgdurationTraineelevelDetails.programDurationId = ?";

	public TraineeProgdurationTraineelevelDetailsPersistenceImpl() {
		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("uuid", "uuid_");
		dbColumnNames.put(
			"traineePdTlErDetailsId", "trainee_pd_tl_er_details_id");
		dbColumnNames.put("traineeId", "trainee_id");
		dbColumnNames.put("programDurationId", "program_duration_id");
		dbColumnNames.put("traineeLevelId", "trainee_level_id");
		dbColumnNames.put("groupId", "group_id");
		dbColumnNames.put("companyId", "company_id");
		dbColumnNames.put("createDate", "create_date");
		dbColumnNames.put("createdBy", "created_by");
		dbColumnNames.put("modifiedDate", "modified_date");
		dbColumnNames.put("modifiedBy", "modified_by");

		setDBColumnNames(dbColumnNames);

		setModelClass(TraineeProgdurationTraineelevelDetails.class);

		setModelImplClass(TraineeProgdurationTraineelevelDetailsImpl.class);
		setModelPKClass(long.class);

		setTable(TraineeProgdurationTraineelevelDetailsTable.INSTANCE);
	}

	/**
	 * Caches the trainee progduration traineelevel details in the entity cache if it is enabled.
	 *
	 * @param traineeProgdurationTraineelevelDetails the trainee progduration traineelevel details
	 */
	@Override
	public void cacheResult(
		TraineeProgdurationTraineelevelDetails
			traineeProgdurationTraineelevelDetails) {

		entityCache.putResult(
			TraineeProgdurationTraineelevelDetailsImpl.class,
			traineeProgdurationTraineelevelDetails.getPrimaryKey(),
			traineeProgdurationTraineelevelDetails);

		finderCache.putResult(
			_finderPathFetchByUUID_G,
			new Object[] {
				traineeProgdurationTraineelevelDetails.getUuid(),
				traineeProgdurationTraineelevelDetails.getGroupId()
			},
			traineeProgdurationTraineelevelDetails);

		finderCache.putResult(
			_finderPathFetchByTraineeIdAndTraineeLevelId,
			new Object[] {
				traineeProgdurationTraineelevelDetails.getTraineeId(),
				traineeProgdurationTraineelevelDetails.getTraineeLevelId()
			},
			traineeProgdurationTraineelevelDetails);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the trainee progduration traineelevel detailses in the entity cache if it is enabled.
	 *
	 * @param traineeProgdurationTraineelevelDetailses the trainee progduration traineelevel detailses
	 */
	@Override
	public void cacheResult(
		List<TraineeProgdurationTraineelevelDetails>
			traineeProgdurationTraineelevelDetailses) {

		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (traineeProgdurationTraineelevelDetailses.size() >
				 _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (TraineeProgdurationTraineelevelDetails
				traineeProgdurationTraineelevelDetails :
					traineeProgdurationTraineelevelDetailses) {

			if (entityCache.getResult(
					TraineeProgdurationTraineelevelDetailsImpl.class,
					traineeProgdurationTraineelevelDetails.getPrimaryKey()) ==
						null) {

				cacheResult(traineeProgdurationTraineelevelDetails);
			}
		}
	}

	/**
	 * Clears the cache for all trainee progduration traineelevel detailses.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(
			TraineeProgdurationTraineelevelDetailsImpl.class);

		finderCache.clearCache(
			TraineeProgdurationTraineelevelDetailsImpl.class);
	}

	/**
	 * Clears the cache for the trainee progduration traineelevel details.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(
		TraineeProgdurationTraineelevelDetails
			traineeProgdurationTraineelevelDetails) {

		entityCache.removeResult(
			TraineeProgdurationTraineelevelDetailsImpl.class,
			traineeProgdurationTraineelevelDetails);
	}

	@Override
	public void clearCache(
		List<TraineeProgdurationTraineelevelDetails>
			traineeProgdurationTraineelevelDetailses) {

		for (TraineeProgdurationTraineelevelDetails
				traineeProgdurationTraineelevelDetails :
					traineeProgdurationTraineelevelDetailses) {

			entityCache.removeResult(
				TraineeProgdurationTraineelevelDetailsImpl.class,
				traineeProgdurationTraineelevelDetails);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(
			TraineeProgdurationTraineelevelDetailsImpl.class);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(
				TraineeProgdurationTraineelevelDetailsImpl.class, primaryKey);
		}
	}

	protected void cacheUniqueFindersCache(
		TraineeProgdurationTraineelevelDetailsModelImpl
			traineeProgdurationTraineelevelDetailsModelImpl) {

		Object[] args = new Object[] {
			traineeProgdurationTraineelevelDetailsModelImpl.getUuid(),
			traineeProgdurationTraineelevelDetailsModelImpl.getGroupId()
		};

		finderCache.putResult(_finderPathCountByUUID_G, args, Long.valueOf(1));
		finderCache.putResult(
			_finderPathFetchByUUID_G, args,
			traineeProgdurationTraineelevelDetailsModelImpl);

		args = new Object[] {
			traineeProgdurationTraineelevelDetailsModelImpl.getTraineeId(),
			traineeProgdurationTraineelevelDetailsModelImpl.getTraineeLevelId()
		};

		finderCache.putResult(
			_finderPathCountByTraineeIdAndTraineeLevelId, args,
			Long.valueOf(1));
		finderCache.putResult(
			_finderPathFetchByTraineeIdAndTraineeLevelId, args,
			traineeProgdurationTraineelevelDetailsModelImpl);
	}

	/**
	 * Creates a new trainee progduration traineelevel details with the primary key. Does not add the trainee progduration traineelevel details to the database.
	 *
	 * @param traineePdTlErDetailsId the primary key for the new trainee progduration traineelevel details
	 * @return the new trainee progduration traineelevel details
	 */
	@Override
	public TraineeProgdurationTraineelevelDetails create(
		long traineePdTlErDetailsId) {

		TraineeProgdurationTraineelevelDetails
			traineeProgdurationTraineelevelDetails =
				new TraineeProgdurationTraineelevelDetailsImpl();

		traineeProgdurationTraineelevelDetails.setNew(true);
		traineeProgdurationTraineelevelDetails.setPrimaryKey(
			traineePdTlErDetailsId);

		String uuid = _portalUUID.generate();

		traineeProgdurationTraineelevelDetails.setUuid(uuid);

		traineeProgdurationTraineelevelDetails.setCompanyId(
			CompanyThreadLocal.getCompanyId());

		return traineeProgdurationTraineelevelDetails;
	}

	/**
	 * Removes the trainee progduration traineelevel details with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param traineePdTlErDetailsId the primary key of the trainee progduration traineelevel details
	 * @return the trainee progduration traineelevel details that was removed
	 * @throws NoSuchTraineeProgdurationTraineelevelDetailsException if a trainee progduration traineelevel details with the primary key could not be found
	 */
	@Override
	public TraineeProgdurationTraineelevelDetails remove(
			long traineePdTlErDetailsId)
		throws NoSuchTraineeProgdurationTraineelevelDetailsException {

		return remove((Serializable)traineePdTlErDetailsId);
	}

	/**
	 * Removes the trainee progduration traineelevel details with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the trainee progduration traineelevel details
	 * @return the trainee progduration traineelevel details that was removed
	 * @throws NoSuchTraineeProgdurationTraineelevelDetailsException if a trainee progduration traineelevel details with the primary key could not be found
	 */
	@Override
	public TraineeProgdurationTraineelevelDetails remove(
			Serializable primaryKey)
		throws NoSuchTraineeProgdurationTraineelevelDetailsException {

		Session session = null;

		try {
			session = openSession();

			TraineeProgdurationTraineelevelDetails
				traineeProgdurationTraineelevelDetails =
					(TraineeProgdurationTraineelevelDetails)session.get(
						TraineeProgdurationTraineelevelDetailsImpl.class,
						primaryKey);

			if (traineeProgdurationTraineelevelDetails == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchTraineeProgdurationTraineelevelDetailsException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(traineeProgdurationTraineelevelDetails);
		}
		catch (NoSuchTraineeProgdurationTraineelevelDetailsException
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
	protected TraineeProgdurationTraineelevelDetails removeImpl(
		TraineeProgdurationTraineelevelDetails
			traineeProgdurationTraineelevelDetails) {

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(traineeProgdurationTraineelevelDetails)) {
				traineeProgdurationTraineelevelDetails =
					(TraineeProgdurationTraineelevelDetails)session.get(
						TraineeProgdurationTraineelevelDetailsImpl.class,
						traineeProgdurationTraineelevelDetails.
							getPrimaryKeyObj());
			}

			if (traineeProgdurationTraineelevelDetails != null) {
				session.delete(traineeProgdurationTraineelevelDetails);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (traineeProgdurationTraineelevelDetails != null) {
			clearCache(traineeProgdurationTraineelevelDetails);
		}

		return traineeProgdurationTraineelevelDetails;
	}

	@Override
	public TraineeProgdurationTraineelevelDetails updateImpl(
		TraineeProgdurationTraineelevelDetails
			traineeProgdurationTraineelevelDetails) {

		boolean isNew = traineeProgdurationTraineelevelDetails.isNew();

		if (!(traineeProgdurationTraineelevelDetails instanceof
				TraineeProgdurationTraineelevelDetailsModelImpl)) {

			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(
					traineeProgdurationTraineelevelDetails.getClass())) {

				invocationHandler = ProxyUtil.getInvocationHandler(
					traineeProgdurationTraineelevelDetails);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in traineeProgdurationTraineelevelDetails proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom TraineeProgdurationTraineelevelDetails implementation " +
					traineeProgdurationTraineelevelDetails.getClass());
		}

		TraineeProgdurationTraineelevelDetailsModelImpl
			traineeProgdurationTraineelevelDetailsModelImpl =
				(TraineeProgdurationTraineelevelDetailsModelImpl)
					traineeProgdurationTraineelevelDetails;

		if (Validator.isNull(
				traineeProgdurationTraineelevelDetails.getUuid())) {

			String uuid = _portalUUID.generate();

			traineeProgdurationTraineelevelDetails.setUuid(uuid);
		}

		ServiceContext serviceContext =
			ServiceContextThreadLocal.getServiceContext();

		Date date = new Date();

		if (isNew &&
			(traineeProgdurationTraineelevelDetails.getCreateDate() == null)) {

			if (serviceContext == null) {
				traineeProgdurationTraineelevelDetails.setCreateDate(date);
			}
			else {
				traineeProgdurationTraineelevelDetails.setCreateDate(
					serviceContext.getCreateDate(date));
			}
		}

		if (!traineeProgdurationTraineelevelDetailsModelImpl.
				hasSetModifiedDate()) {

			if (serviceContext == null) {
				traineeProgdurationTraineelevelDetails.setModifiedDate(date);
			}
			else {
				traineeProgdurationTraineelevelDetails.setModifiedDate(
					serviceContext.getModifiedDate(date));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(traineeProgdurationTraineelevelDetails);
			}
			else {
				traineeProgdurationTraineelevelDetails =
					(TraineeProgdurationTraineelevelDetails)session.merge(
						traineeProgdurationTraineelevelDetails);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(
			TraineeProgdurationTraineelevelDetailsImpl.class,
			traineeProgdurationTraineelevelDetailsModelImpl, false, true);

		cacheUniqueFindersCache(
			traineeProgdurationTraineelevelDetailsModelImpl);

		if (isNew) {
			traineeProgdurationTraineelevelDetails.setNew(false);
		}

		traineeProgdurationTraineelevelDetails.resetOriginalValues();

		return traineeProgdurationTraineelevelDetails;
	}

	/**
	 * Returns the trainee progduration traineelevel details with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the trainee progduration traineelevel details
	 * @return the trainee progduration traineelevel details
	 * @throws NoSuchTraineeProgdurationTraineelevelDetailsException if a trainee progduration traineelevel details with the primary key could not be found
	 */
	@Override
	public TraineeProgdurationTraineelevelDetails findByPrimaryKey(
			Serializable primaryKey)
		throws NoSuchTraineeProgdurationTraineelevelDetailsException {

		TraineeProgdurationTraineelevelDetails
			traineeProgdurationTraineelevelDetails = fetchByPrimaryKey(
				primaryKey);

		if (traineeProgdurationTraineelevelDetails == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchTraineeProgdurationTraineelevelDetailsException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return traineeProgdurationTraineelevelDetails;
	}

	/**
	 * Returns the trainee progduration traineelevel details with the primary key or throws a <code>NoSuchTraineeProgdurationTraineelevelDetailsException</code> if it could not be found.
	 *
	 * @param traineePdTlErDetailsId the primary key of the trainee progduration traineelevel details
	 * @return the trainee progduration traineelevel details
	 * @throws NoSuchTraineeProgdurationTraineelevelDetailsException if a trainee progduration traineelevel details with the primary key could not be found
	 */
	@Override
	public TraineeProgdurationTraineelevelDetails findByPrimaryKey(
			long traineePdTlErDetailsId)
		throws NoSuchTraineeProgdurationTraineelevelDetailsException {

		return findByPrimaryKey((Serializable)traineePdTlErDetailsId);
	}

	/**
	 * Returns the trainee progduration traineelevel details with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param traineePdTlErDetailsId the primary key of the trainee progduration traineelevel details
	 * @return the trainee progduration traineelevel details, or <code>null</code> if a trainee progduration traineelevel details with the primary key could not be found
	 */
	@Override
	public TraineeProgdurationTraineelevelDetails fetchByPrimaryKey(
		long traineePdTlErDetailsId) {

		return fetchByPrimaryKey((Serializable)traineePdTlErDetailsId);
	}

	/**
	 * Returns all the trainee progduration traineelevel detailses.
	 *
	 * @return the trainee progduration traineelevel detailses
	 */
	@Override
	public List<TraineeProgdurationTraineelevelDetails> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the trainee progduration traineelevel detailses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TraineeProgdurationTraineelevelDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of trainee progduration traineelevel detailses
	 * @param end the upper bound of the range of trainee progduration traineelevel detailses (not inclusive)
	 * @return the range of trainee progduration traineelevel detailses
	 */
	@Override
	public List<TraineeProgdurationTraineelevelDetails> findAll(
		int start, int end) {

		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the trainee progduration traineelevel detailses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TraineeProgdurationTraineelevelDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of trainee progduration traineelevel detailses
	 * @param end the upper bound of the range of trainee progduration traineelevel detailses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of trainee progduration traineelevel detailses
	 */
	@Override
	public List<TraineeProgdurationTraineelevelDetails> findAll(
		int start, int end,
		OrderByComparator<TraineeProgdurationTraineelevelDetails>
			orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the trainee progduration traineelevel detailses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TraineeProgdurationTraineelevelDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of trainee progduration traineelevel detailses
	 * @param end the upper bound of the range of trainee progduration traineelevel detailses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of trainee progduration traineelevel detailses
	 */
	@Override
	public List<TraineeProgdurationTraineelevelDetails> findAll(
		int start, int end,
		OrderByComparator<TraineeProgdurationTraineelevelDetails>
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

		List<TraineeProgdurationTraineelevelDetails> list = null;

		if (useFinderCache) {
			list =
				(List<TraineeProgdurationTraineelevelDetails>)
					finderCache.getResult(finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_TRAINEEPROGDURATIONTRAINEELEVELDETAILS);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_TRAINEEPROGDURATIONTRAINEELEVELDETAILS;

				sql = sql.concat(
					TraineeProgdurationTraineelevelDetailsModelImpl.
						ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list =
					(List<TraineeProgdurationTraineelevelDetails>)
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
	 * Removes all the trainee progduration traineelevel detailses from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (TraineeProgdurationTraineelevelDetails
				traineeProgdurationTraineelevelDetails : findAll()) {

			remove(traineeProgdurationTraineelevelDetails);
		}
	}

	/**
	 * Returns the number of trainee progduration traineelevel detailses.
	 *
	 * @return the number of trainee progduration traineelevel detailses
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
					_SQL_COUNT_TRAINEEPROGDURATIONTRAINEELEVELDETAILS);

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
		return "trainee_pd_tl_er_details_id";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_TRAINEEPROGDURATIONTRAINEELEVELDETAILS;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return TraineeProgdurationTraineelevelDetailsModelImpl.
			TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the trainee progduration traineelevel details persistence.
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

		_finderPathWithPaginationFindByTraineeId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByTraineeId",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"trainee_id"}, true);

		_finderPathWithoutPaginationFindByTraineeId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByTraineeId",
			new String[] {Long.class.getName()}, new String[] {"trainee_id"},
			true);

		_finderPathCountByTraineeId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByTraineeId",
			new String[] {Long.class.getName()}, new String[] {"trainee_id"},
			false);

		_finderPathFetchByTraineeIdAndTraineeLevelId = new FinderPath(
			FINDER_CLASS_NAME_ENTITY, "fetchByTraineeIdAndTraineeLevelId",
			new String[] {Long.class.getName(), Long.class.getName()},
			new String[] {"trainee_id", "trainee_level_id"}, true);

		_finderPathCountByTraineeIdAndTraineeLevelId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByTraineeIdAndTraineeLevelId",
			new String[] {Long.class.getName(), Long.class.getName()},
			new String[] {"trainee_id", "trainee_level_id"}, false);

		_finderPathWithPaginationFindByTraineeIdAndProgramDurationId =
			new FinderPath(
				FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
				"findByTraineeIdAndProgramDurationId",
				new String[] {
					Long.class.getName(), Long.class.getName(),
					Integer.class.getName(), Integer.class.getName(),
					OrderByComparator.class.getName()
				},
				new String[] {"trainee_id", "program_duration_id"}, true);

		_finderPathWithoutPaginationFindByTraineeIdAndProgramDurationId =
			new FinderPath(
				FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
				"findByTraineeIdAndProgramDurationId",
				new String[] {Long.class.getName(), Long.class.getName()},
				new String[] {"trainee_id", "program_duration_id"}, true);

		_finderPathCountByTraineeIdAndProgramDurationId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByTraineeIdAndProgramDurationId",
			new String[] {Long.class.getName(), Long.class.getName()},
			new String[] {"trainee_id", "program_duration_id"}, false);

		_setTraineeProgdurationTraineelevelDetailsUtilPersistence(this);
	}

	@Deactivate
	public void deactivate() {
		_setTraineeProgdurationTraineelevelDetailsUtilPersistence(null);

		entityCache.removeCache(
			TraineeProgdurationTraineelevelDetailsImpl.class.getName());
	}

	private void _setTraineeProgdurationTraineelevelDetailsUtilPersistence(
		TraineeProgdurationTraineelevelDetailsPersistence
			traineeProgdurationTraineelevelDetailsPersistence) {

		try {
			Field field =
				TraineeProgdurationTraineelevelDetailsUtil.class.
					getDeclaredField("_persistence");

			field.setAccessible(true);

			field.set(null, traineeProgdurationTraineelevelDetailsPersistence);
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
		_SQL_SELECT_TRAINEEPROGDURATIONTRAINEELEVELDETAILS =
			"SELECT traineeProgdurationTraineelevelDetails FROM TraineeProgdurationTraineelevelDetails traineeProgdurationTraineelevelDetails";

	private static final String
		_SQL_SELECT_TRAINEEPROGDURATIONTRAINEELEVELDETAILS_WHERE =
			"SELECT traineeProgdurationTraineelevelDetails FROM TraineeProgdurationTraineelevelDetails traineeProgdurationTraineelevelDetails WHERE ";

	private static final String
		_SQL_COUNT_TRAINEEPROGDURATIONTRAINEELEVELDETAILS =
			"SELECT COUNT(traineeProgdurationTraineelevelDetails) FROM TraineeProgdurationTraineelevelDetails traineeProgdurationTraineelevelDetails";

	private static final String
		_SQL_COUNT_TRAINEEPROGDURATIONTRAINEELEVELDETAILS_WHERE =
			"SELECT COUNT(traineeProgdurationTraineelevelDetails) FROM TraineeProgdurationTraineelevelDetails traineeProgdurationTraineelevelDetails WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS =
		"traineeProgdurationTraineelevelDetails.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No TraineeProgdurationTraineelevelDetails exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No TraineeProgdurationTraineelevelDetails exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		TraineeProgdurationTraineelevelDetailsPersistenceImpl.class);

	private static final Set<String> _badColumnNames = SetUtil.fromArray(
		new String[] {
			"uuid", "traineePdTlErDetailsId", "traineeId", "programDurationId",
			"traineeLevelId", "groupId", "companyId", "createDate", "createdBy",
			"modifiedDate", "modifiedBy"
		});

	@Override
	protected FinderCache getFinderCache() {
		return finderCache;
	}

	@Reference
	private PortalUUID _portalUUID;

}
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
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.uuid.PortalUUID;

import gov.omsb.tms.exception.NoSuchTraineeElectiverotationPriorityDetailsException;
import gov.omsb.tms.model.TraineeElectiverotationPriorityDetails;
import gov.omsb.tms.model.TraineeElectiverotationPriorityDetailsTable;
import gov.omsb.tms.model.impl.TraineeElectiverotationPriorityDetailsImpl;
import gov.omsb.tms.model.impl.TraineeElectiverotationPriorityDetailsModelImpl;
import gov.omsb.tms.service.persistence.TraineeElectiverotationPriorityDetailsPersistence;
import gov.omsb.tms.service.persistence.TraineeElectiverotationPriorityDetailsUtil;
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
 * The persistence implementation for the trainee electiverotation priority details service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = TraineeElectiverotationPriorityDetailsPersistence.class)
public class TraineeElectiverotationPriorityDetailsPersistenceImpl
	extends BasePersistenceImpl<TraineeElectiverotationPriorityDetails>
	implements TraineeElectiverotationPriorityDetailsPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>TraineeElectiverotationPriorityDetailsUtil</code> to access the trainee electiverotation priority details persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		TraineeElectiverotationPriorityDetailsImpl.class.getName();

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
	 * Returns all the trainee electiverotation priority detailses where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching trainee electiverotation priority detailses
	 */
	@Override
	public List<TraineeElectiverotationPriorityDetails> findByUuid(
		String uuid) {

		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the trainee electiverotation priority detailses where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TraineeElectiverotationPriorityDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of trainee electiverotation priority detailses
	 * @param end the upper bound of the range of trainee electiverotation priority detailses (not inclusive)
	 * @return the range of matching trainee electiverotation priority detailses
	 */
	@Override
	public List<TraineeElectiverotationPriorityDetails> findByUuid(
		String uuid, int start, int end) {

		return findByUuid(uuid, start, end, null);
	}

	/**
	 * Returns an ordered range of all the trainee electiverotation priority detailses where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TraineeElectiverotationPriorityDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of trainee electiverotation priority detailses
	 * @param end the upper bound of the range of trainee electiverotation priority detailses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching trainee electiverotation priority detailses
	 */
	@Override
	public List<TraineeElectiverotationPriorityDetails> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<TraineeElectiverotationPriorityDetails>
			orderByComparator) {

		return findByUuid(uuid, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the trainee electiverotation priority detailses where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TraineeElectiverotationPriorityDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of trainee electiverotation priority detailses
	 * @param end the upper bound of the range of trainee electiverotation priority detailses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching trainee electiverotation priority detailses
	 */
	@Override
	public List<TraineeElectiverotationPriorityDetails> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<TraineeElectiverotationPriorityDetails>
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

		List<TraineeElectiverotationPriorityDetails> list = null;

		if (useFinderCache) {
			list =
				(List<TraineeElectiverotationPriorityDetails>)
					finderCache.getResult(finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (TraineeElectiverotationPriorityDetails
						traineeElectiverotationPriorityDetails : list) {

					if (!uuid.equals(
							traineeElectiverotationPriorityDetails.getUuid())) {

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

			sb.append(_SQL_SELECT_TRAINEEELECTIVEROTATIONPRIORITYDETAILS_WHERE);

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
					TraineeElectiverotationPriorityDetailsModelImpl.
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
					(List<TraineeElectiverotationPriorityDetails>)
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
	 * Returns the first trainee electiverotation priority details in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching trainee electiverotation priority details
	 * @throws NoSuchTraineeElectiverotationPriorityDetailsException if a matching trainee electiverotation priority details could not be found
	 */
	@Override
	public TraineeElectiverotationPriorityDetails findByUuid_First(
			String uuid,
			OrderByComparator<TraineeElectiverotationPriorityDetails>
				orderByComparator)
		throws NoSuchTraineeElectiverotationPriorityDetailsException {

		TraineeElectiverotationPriorityDetails
			traineeElectiverotationPriorityDetails = fetchByUuid_First(
				uuid, orderByComparator);

		if (traineeElectiverotationPriorityDetails != null) {
			return traineeElectiverotationPriorityDetails;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchTraineeElectiverotationPriorityDetailsException(
			sb.toString());
	}

	/**
	 * Returns the first trainee electiverotation priority details in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching trainee electiverotation priority details, or <code>null</code> if a matching trainee electiverotation priority details could not be found
	 */
	@Override
	public TraineeElectiverotationPriorityDetails fetchByUuid_First(
		String uuid,
		OrderByComparator<TraineeElectiverotationPriorityDetails>
			orderByComparator) {

		List<TraineeElectiverotationPriorityDetails> list = findByUuid(
			uuid, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last trainee electiverotation priority details in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching trainee electiverotation priority details
	 * @throws NoSuchTraineeElectiverotationPriorityDetailsException if a matching trainee electiverotation priority details could not be found
	 */
	@Override
	public TraineeElectiverotationPriorityDetails findByUuid_Last(
			String uuid,
			OrderByComparator<TraineeElectiverotationPriorityDetails>
				orderByComparator)
		throws NoSuchTraineeElectiverotationPriorityDetailsException {

		TraineeElectiverotationPriorityDetails
			traineeElectiverotationPriorityDetails = fetchByUuid_Last(
				uuid, orderByComparator);

		if (traineeElectiverotationPriorityDetails != null) {
			return traineeElectiverotationPriorityDetails;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchTraineeElectiverotationPriorityDetailsException(
			sb.toString());
	}

	/**
	 * Returns the last trainee electiverotation priority details in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching trainee electiverotation priority details, or <code>null</code> if a matching trainee electiverotation priority details could not be found
	 */
	@Override
	public TraineeElectiverotationPriorityDetails fetchByUuid_Last(
		String uuid,
		OrderByComparator<TraineeElectiverotationPriorityDetails>
			orderByComparator) {

		int count = countByUuid(uuid);

		if (count == 0) {
			return null;
		}

		List<TraineeElectiverotationPriorityDetails> list = findByUuid(
			uuid, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the trainee electiverotation priority detailses before and after the current trainee electiverotation priority details in the ordered set where uuid = &#63;.
	 *
	 * @param traineeElectiverotationPriorityDetailsId the primary key of the current trainee electiverotation priority details
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next trainee electiverotation priority details
	 * @throws NoSuchTraineeElectiverotationPriorityDetailsException if a trainee electiverotation priority details with the primary key could not be found
	 */
	@Override
	public TraineeElectiverotationPriorityDetails[] findByUuid_PrevAndNext(
			long traineeElectiverotationPriorityDetailsId, String uuid,
			OrderByComparator<TraineeElectiverotationPriorityDetails>
				orderByComparator)
		throws NoSuchTraineeElectiverotationPriorityDetailsException {

		uuid = Objects.toString(uuid, "");

		TraineeElectiverotationPriorityDetails
			traineeElectiverotationPriorityDetails = findByPrimaryKey(
				traineeElectiverotationPriorityDetailsId);

		Session session = null;

		try {
			session = openSession();

			TraineeElectiverotationPriorityDetails[] array =
				new TraineeElectiverotationPriorityDetailsImpl[3];

			array[0] = getByUuid_PrevAndNext(
				session, traineeElectiverotationPriorityDetails, uuid,
				orderByComparator, true);

			array[1] = traineeElectiverotationPriorityDetails;

			array[2] = getByUuid_PrevAndNext(
				session, traineeElectiverotationPriorityDetails, uuid,
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

	protected TraineeElectiverotationPriorityDetails getByUuid_PrevAndNext(
		Session session,
		TraineeElectiverotationPriorityDetails
			traineeElectiverotationPriorityDetails,
		String uuid,
		OrderByComparator<TraineeElectiverotationPriorityDetails>
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

		sb.append(_SQL_SELECT_TRAINEEELECTIVEROTATIONPRIORITYDETAILS_WHERE);

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
				TraineeElectiverotationPriorityDetailsModelImpl.ORDER_BY_JPQL);
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
						traineeElectiverotationPriorityDetails)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<TraineeElectiverotationPriorityDetails> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the trainee electiverotation priority detailses where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	@Override
	public void removeByUuid(String uuid) {
		for (TraineeElectiverotationPriorityDetails
				traineeElectiverotationPriorityDetails :
					findByUuid(
						uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(traineeElectiverotationPriorityDetails);
		}
	}

	/**
	 * Returns the number of trainee electiverotation priority detailses where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching trainee electiverotation priority detailses
	 */
	@Override
	public int countByUuid(String uuid) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid;

		Object[] finderArgs = new Object[] {uuid};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_TRAINEEELECTIVEROTATIONPRIORITYDETAILS_WHERE);

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
		"traineeElectiverotationPriorityDetails.uuid = ?";

	private static final String _FINDER_COLUMN_UUID_UUID_3 =
		"(traineeElectiverotationPriorityDetails.uuid IS NULL OR traineeElectiverotationPriorityDetails.uuid = '')";

	private FinderPath _finderPathFetchByUUID_G;
	private FinderPath _finderPathCountByUUID_G;

	/**
	 * Returns the trainee electiverotation priority details where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchTraineeElectiverotationPriorityDetailsException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching trainee electiverotation priority details
	 * @throws NoSuchTraineeElectiverotationPriorityDetailsException if a matching trainee electiverotation priority details could not be found
	 */
	@Override
	public TraineeElectiverotationPriorityDetails findByUUID_G(
			String uuid, long groupId)
		throws NoSuchTraineeElectiverotationPriorityDetailsException {

		TraineeElectiverotationPriorityDetails
			traineeElectiverotationPriorityDetails = fetchByUUID_G(
				uuid, groupId);

		if (traineeElectiverotationPriorityDetails == null) {
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

			throw new NoSuchTraineeElectiverotationPriorityDetailsException(
				sb.toString());
		}

		return traineeElectiverotationPriorityDetails;
	}

	/**
	 * Returns the trainee electiverotation priority details where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching trainee electiverotation priority details, or <code>null</code> if a matching trainee electiverotation priority details could not be found
	 */
	@Override
	public TraineeElectiverotationPriorityDetails fetchByUUID_G(
		String uuid, long groupId) {

		return fetchByUUID_G(uuid, groupId, true);
	}

	/**
	 * Returns the trainee electiverotation priority details where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching trainee electiverotation priority details, or <code>null</code> if a matching trainee electiverotation priority details could not be found
	 */
	@Override
	public TraineeElectiverotationPriorityDetails fetchByUUID_G(
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

		if (result instanceof TraineeElectiverotationPriorityDetails) {
			TraineeElectiverotationPriorityDetails
				traineeElectiverotationPriorityDetails =
					(TraineeElectiverotationPriorityDetails)result;

			if (!Objects.equals(
					uuid, traineeElectiverotationPriorityDetails.getUuid()) ||
				(groupId !=
					traineeElectiverotationPriorityDetails.getGroupId())) {

				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_SQL_SELECT_TRAINEEELECTIVEROTATIONPRIORITYDETAILS_WHERE);

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

				List<TraineeElectiverotationPriorityDetails> list =
					query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchByUUID_G, finderArgs, list);
					}
				}
				else {
					TraineeElectiverotationPriorityDetails
						traineeElectiverotationPriorityDetails = list.get(0);

					result = traineeElectiverotationPriorityDetails;

					cacheResult(traineeElectiverotationPriorityDetails);
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
			return (TraineeElectiverotationPriorityDetails)result;
		}
	}

	/**
	 * Removes the trainee electiverotation priority details where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the trainee electiverotation priority details that was removed
	 */
	@Override
	public TraineeElectiverotationPriorityDetails removeByUUID_G(
			String uuid, long groupId)
		throws NoSuchTraineeElectiverotationPriorityDetailsException {

		TraineeElectiverotationPriorityDetails
			traineeElectiverotationPriorityDetails = findByUUID_G(
				uuid, groupId);

		return remove(traineeElectiverotationPriorityDetails);
	}

	/**
	 * Returns the number of trainee electiverotation priority detailses where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching trainee electiverotation priority detailses
	 */
	@Override
	public int countByUUID_G(String uuid, long groupId) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUUID_G;

		Object[] finderArgs = new Object[] {uuid, groupId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_TRAINEEELECTIVEROTATIONPRIORITYDETAILS_WHERE);

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
		"traineeElectiverotationPriorityDetails.uuid = ? AND ";

	private static final String _FINDER_COLUMN_UUID_G_UUID_3 =
		"(traineeElectiverotationPriorityDetails.uuid IS NULL OR traineeElectiverotationPriorityDetails.uuid = '') AND ";

	private static final String _FINDER_COLUMN_UUID_G_GROUPID_2 =
		"traineeElectiverotationPriorityDetails.groupId = ?";

	private FinderPath _finderPathWithPaginationFindByUuid_C;
	private FinderPath _finderPathWithoutPaginationFindByUuid_C;
	private FinderPath _finderPathCountByUuid_C;

	/**
	 * Returns all the trainee electiverotation priority detailses where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching trainee electiverotation priority detailses
	 */
	@Override
	public List<TraineeElectiverotationPriorityDetails> findByUuid_C(
		String uuid, long companyId) {

		return findByUuid_C(
			uuid, companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the trainee electiverotation priority detailses where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TraineeElectiverotationPriorityDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of trainee electiverotation priority detailses
	 * @param end the upper bound of the range of trainee electiverotation priority detailses (not inclusive)
	 * @return the range of matching trainee electiverotation priority detailses
	 */
	@Override
	public List<TraineeElectiverotationPriorityDetails> findByUuid_C(
		String uuid, long companyId, int start, int end) {

		return findByUuid_C(uuid, companyId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the trainee electiverotation priority detailses where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TraineeElectiverotationPriorityDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of trainee electiverotation priority detailses
	 * @param end the upper bound of the range of trainee electiverotation priority detailses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching trainee electiverotation priority detailses
	 */
	@Override
	public List<TraineeElectiverotationPriorityDetails> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<TraineeElectiverotationPriorityDetails>
			orderByComparator) {

		return findByUuid_C(
			uuid, companyId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the trainee electiverotation priority detailses where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TraineeElectiverotationPriorityDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of trainee electiverotation priority detailses
	 * @param end the upper bound of the range of trainee electiverotation priority detailses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching trainee electiverotation priority detailses
	 */
	@Override
	public List<TraineeElectiverotationPriorityDetails> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<TraineeElectiverotationPriorityDetails>
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

		List<TraineeElectiverotationPriorityDetails> list = null;

		if (useFinderCache) {
			list =
				(List<TraineeElectiverotationPriorityDetails>)
					finderCache.getResult(finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (TraineeElectiverotationPriorityDetails
						traineeElectiverotationPriorityDetails : list) {

					if (!uuid.equals(
							traineeElectiverotationPriorityDetails.getUuid()) ||
						(companyId !=
							traineeElectiverotationPriorityDetails.
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

			sb.append(_SQL_SELECT_TRAINEEELECTIVEROTATIONPRIORITYDETAILS_WHERE);

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
					TraineeElectiverotationPriorityDetailsModelImpl.
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
					(List<TraineeElectiverotationPriorityDetails>)
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
	 * Returns the first trainee electiverotation priority details in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching trainee electiverotation priority details
	 * @throws NoSuchTraineeElectiverotationPriorityDetailsException if a matching trainee electiverotation priority details could not be found
	 */
	@Override
	public TraineeElectiverotationPriorityDetails findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<TraineeElectiverotationPriorityDetails>
				orderByComparator)
		throws NoSuchTraineeElectiverotationPriorityDetailsException {

		TraineeElectiverotationPriorityDetails
			traineeElectiverotationPriorityDetails = fetchByUuid_C_First(
				uuid, companyId, orderByComparator);

		if (traineeElectiverotationPriorityDetails != null) {
			return traineeElectiverotationPriorityDetails;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append(", companyId=");
		sb.append(companyId);

		sb.append("}");

		throw new NoSuchTraineeElectiverotationPriorityDetailsException(
			sb.toString());
	}

	/**
	 * Returns the first trainee electiverotation priority details in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching trainee electiverotation priority details, or <code>null</code> if a matching trainee electiverotation priority details could not be found
	 */
	@Override
	public TraineeElectiverotationPriorityDetails fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<TraineeElectiverotationPriorityDetails>
			orderByComparator) {

		List<TraineeElectiverotationPriorityDetails> list = findByUuid_C(
			uuid, companyId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last trainee electiverotation priority details in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching trainee electiverotation priority details
	 * @throws NoSuchTraineeElectiverotationPriorityDetailsException if a matching trainee electiverotation priority details could not be found
	 */
	@Override
	public TraineeElectiverotationPriorityDetails findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<TraineeElectiverotationPriorityDetails>
				orderByComparator)
		throws NoSuchTraineeElectiverotationPriorityDetailsException {

		TraineeElectiverotationPriorityDetails
			traineeElectiverotationPriorityDetails = fetchByUuid_C_Last(
				uuid, companyId, orderByComparator);

		if (traineeElectiverotationPriorityDetails != null) {
			return traineeElectiverotationPriorityDetails;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append(", companyId=");
		sb.append(companyId);

		sb.append("}");

		throw new NoSuchTraineeElectiverotationPriorityDetailsException(
			sb.toString());
	}

	/**
	 * Returns the last trainee electiverotation priority details in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching trainee electiverotation priority details, or <code>null</code> if a matching trainee electiverotation priority details could not be found
	 */
	@Override
	public TraineeElectiverotationPriorityDetails fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<TraineeElectiverotationPriorityDetails>
			orderByComparator) {

		int count = countByUuid_C(uuid, companyId);

		if (count == 0) {
			return null;
		}

		List<TraineeElectiverotationPriorityDetails> list = findByUuid_C(
			uuid, companyId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the trainee electiverotation priority detailses before and after the current trainee electiverotation priority details in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param traineeElectiverotationPriorityDetailsId the primary key of the current trainee electiverotation priority details
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next trainee electiverotation priority details
	 * @throws NoSuchTraineeElectiverotationPriorityDetailsException if a trainee electiverotation priority details with the primary key could not be found
	 */
	@Override
	public TraineeElectiverotationPriorityDetails[] findByUuid_C_PrevAndNext(
			long traineeElectiverotationPriorityDetailsId, String uuid,
			long companyId,
			OrderByComparator<TraineeElectiverotationPriorityDetails>
				orderByComparator)
		throws NoSuchTraineeElectiverotationPriorityDetailsException {

		uuid = Objects.toString(uuid, "");

		TraineeElectiverotationPriorityDetails
			traineeElectiverotationPriorityDetails = findByPrimaryKey(
				traineeElectiverotationPriorityDetailsId);

		Session session = null;

		try {
			session = openSession();

			TraineeElectiverotationPriorityDetails[] array =
				new TraineeElectiverotationPriorityDetailsImpl[3];

			array[0] = getByUuid_C_PrevAndNext(
				session, traineeElectiverotationPriorityDetails, uuid,
				companyId, orderByComparator, true);

			array[1] = traineeElectiverotationPriorityDetails;

			array[2] = getByUuid_C_PrevAndNext(
				session, traineeElectiverotationPriorityDetails, uuid,
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

	protected TraineeElectiverotationPriorityDetails getByUuid_C_PrevAndNext(
		Session session,
		TraineeElectiverotationPriorityDetails
			traineeElectiverotationPriorityDetails,
		String uuid, long companyId,
		OrderByComparator<TraineeElectiverotationPriorityDetails>
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

		sb.append(_SQL_SELECT_TRAINEEELECTIVEROTATIONPRIORITYDETAILS_WHERE);

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
				TraineeElectiverotationPriorityDetailsModelImpl.ORDER_BY_JPQL);
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
						traineeElectiverotationPriorityDetails)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<TraineeElectiverotationPriorityDetails> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the trainee electiverotation priority detailses where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	@Override
	public void removeByUuid_C(String uuid, long companyId) {
		for (TraineeElectiverotationPriorityDetails
				traineeElectiverotationPriorityDetails :
					findByUuid_C(
						uuid, companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
						null)) {

			remove(traineeElectiverotationPriorityDetails);
		}
	}

	/**
	 * Returns the number of trainee electiverotation priority detailses where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching trainee electiverotation priority detailses
	 */
	@Override
	public int countByUuid_C(String uuid, long companyId) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid_C;

		Object[] finderArgs = new Object[] {uuid, companyId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_TRAINEEELECTIVEROTATIONPRIORITYDETAILS_WHERE);

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
		"traineeElectiverotationPriorityDetails.uuid = ? AND ";

	private static final String _FINDER_COLUMN_UUID_C_UUID_3 =
		"(traineeElectiverotationPriorityDetails.uuid IS NULL OR traineeElectiverotationPriorityDetails.uuid = '') AND ";

	private static final String _FINDER_COLUMN_UUID_C_COMPANYID_2 =
		"traineeElectiverotationPriorityDetails.companyId = ?";

	private FinderPath _finderPathWithPaginationFindByTraineePdTlErDetailsId;
	private FinderPath _finderPathWithoutPaginationFindByTraineePdTlErDetailsId;
	private FinderPath _finderPathCountByTraineePdTlErDetailsId;

	/**
	 * Returns all the trainee electiverotation priority detailses where traineePdTlErDetailsId = &#63;.
	 *
	 * @param traineePdTlErDetailsId the trainee pd tl er details ID
	 * @return the matching trainee electiverotation priority detailses
	 */
	@Override
	public List<TraineeElectiverotationPriorityDetails>
		findByTraineePdTlErDetailsId(long traineePdTlErDetailsId) {

		return findByTraineePdTlErDetailsId(
			traineePdTlErDetailsId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the trainee electiverotation priority detailses where traineePdTlErDetailsId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TraineeElectiverotationPriorityDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param traineePdTlErDetailsId the trainee pd tl er details ID
	 * @param start the lower bound of the range of trainee electiverotation priority detailses
	 * @param end the upper bound of the range of trainee electiverotation priority detailses (not inclusive)
	 * @return the range of matching trainee electiverotation priority detailses
	 */
	@Override
	public List<TraineeElectiverotationPriorityDetails>
		findByTraineePdTlErDetailsId(
			long traineePdTlErDetailsId, int start, int end) {

		return findByTraineePdTlErDetailsId(
			traineePdTlErDetailsId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the trainee electiverotation priority detailses where traineePdTlErDetailsId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TraineeElectiverotationPriorityDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param traineePdTlErDetailsId the trainee pd tl er details ID
	 * @param start the lower bound of the range of trainee electiverotation priority detailses
	 * @param end the upper bound of the range of trainee electiverotation priority detailses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching trainee electiverotation priority detailses
	 */
	@Override
	public List<TraineeElectiverotationPriorityDetails>
		findByTraineePdTlErDetailsId(
			long traineePdTlErDetailsId, int start, int end,
			OrderByComparator<TraineeElectiverotationPriorityDetails>
				orderByComparator) {

		return findByTraineePdTlErDetailsId(
			traineePdTlErDetailsId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the trainee electiverotation priority detailses where traineePdTlErDetailsId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TraineeElectiverotationPriorityDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param traineePdTlErDetailsId the trainee pd tl er details ID
	 * @param start the lower bound of the range of trainee electiverotation priority detailses
	 * @param end the upper bound of the range of trainee electiverotation priority detailses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching trainee electiverotation priority detailses
	 */
	@Override
	public List<TraineeElectiverotationPriorityDetails>
		findByTraineePdTlErDetailsId(
			long traineePdTlErDetailsId, int start, int end,
			OrderByComparator<TraineeElectiverotationPriorityDetails>
				orderByComparator,
			boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath =
					_finderPathWithoutPaginationFindByTraineePdTlErDetailsId;
				finderArgs = new Object[] {traineePdTlErDetailsId};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByTraineePdTlErDetailsId;
			finderArgs = new Object[] {
				traineePdTlErDetailsId, start, end, orderByComparator
			};
		}

		List<TraineeElectiverotationPriorityDetails> list = null;

		if (useFinderCache) {
			list =
				(List<TraineeElectiverotationPriorityDetails>)
					finderCache.getResult(finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (TraineeElectiverotationPriorityDetails
						traineeElectiverotationPriorityDetails : list) {

					if (traineePdTlErDetailsId !=
							traineeElectiverotationPriorityDetails.
								getTraineePdTlErDetailsId()) {

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

			sb.append(_SQL_SELECT_TRAINEEELECTIVEROTATIONPRIORITYDETAILS_WHERE);

			sb.append(
				_FINDER_COLUMN_TRAINEEPDTLERDETAILSID_TRAINEEPDTLERDETAILSID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(
					TraineeElectiverotationPriorityDetailsModelImpl.
						ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(traineePdTlErDetailsId);

				list =
					(List<TraineeElectiverotationPriorityDetails>)
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
	 * Returns the first trainee electiverotation priority details in the ordered set where traineePdTlErDetailsId = &#63;.
	 *
	 * @param traineePdTlErDetailsId the trainee pd tl er details ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching trainee electiverotation priority details
	 * @throws NoSuchTraineeElectiverotationPriorityDetailsException if a matching trainee electiverotation priority details could not be found
	 */
	@Override
	public TraineeElectiverotationPriorityDetails
			findByTraineePdTlErDetailsId_First(
				long traineePdTlErDetailsId,
				OrderByComparator<TraineeElectiverotationPriorityDetails>
					orderByComparator)
		throws NoSuchTraineeElectiverotationPriorityDetailsException {

		TraineeElectiverotationPriorityDetails
			traineeElectiverotationPriorityDetails =
				fetchByTraineePdTlErDetailsId_First(
					traineePdTlErDetailsId, orderByComparator);

		if (traineeElectiverotationPriorityDetails != null) {
			return traineeElectiverotationPriorityDetails;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("traineePdTlErDetailsId=");
		sb.append(traineePdTlErDetailsId);

		sb.append("}");

		throw new NoSuchTraineeElectiverotationPriorityDetailsException(
			sb.toString());
	}

	/**
	 * Returns the first trainee electiverotation priority details in the ordered set where traineePdTlErDetailsId = &#63;.
	 *
	 * @param traineePdTlErDetailsId the trainee pd tl er details ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching trainee electiverotation priority details, or <code>null</code> if a matching trainee electiverotation priority details could not be found
	 */
	@Override
	public TraineeElectiverotationPriorityDetails
		fetchByTraineePdTlErDetailsId_First(
			long traineePdTlErDetailsId,
			OrderByComparator<TraineeElectiverotationPriorityDetails>
				orderByComparator) {

		List<TraineeElectiverotationPriorityDetails> list =
			findByTraineePdTlErDetailsId(
				traineePdTlErDetailsId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last trainee electiverotation priority details in the ordered set where traineePdTlErDetailsId = &#63;.
	 *
	 * @param traineePdTlErDetailsId the trainee pd tl er details ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching trainee electiverotation priority details
	 * @throws NoSuchTraineeElectiverotationPriorityDetailsException if a matching trainee electiverotation priority details could not be found
	 */
	@Override
	public TraineeElectiverotationPriorityDetails
			findByTraineePdTlErDetailsId_Last(
				long traineePdTlErDetailsId,
				OrderByComparator<TraineeElectiverotationPriorityDetails>
					orderByComparator)
		throws NoSuchTraineeElectiverotationPriorityDetailsException {

		TraineeElectiverotationPriorityDetails
			traineeElectiverotationPriorityDetails =
				fetchByTraineePdTlErDetailsId_Last(
					traineePdTlErDetailsId, orderByComparator);

		if (traineeElectiverotationPriorityDetails != null) {
			return traineeElectiverotationPriorityDetails;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("traineePdTlErDetailsId=");
		sb.append(traineePdTlErDetailsId);

		sb.append("}");

		throw new NoSuchTraineeElectiverotationPriorityDetailsException(
			sb.toString());
	}

	/**
	 * Returns the last trainee electiverotation priority details in the ordered set where traineePdTlErDetailsId = &#63;.
	 *
	 * @param traineePdTlErDetailsId the trainee pd tl er details ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching trainee electiverotation priority details, or <code>null</code> if a matching trainee electiverotation priority details could not be found
	 */
	@Override
	public TraineeElectiverotationPriorityDetails
		fetchByTraineePdTlErDetailsId_Last(
			long traineePdTlErDetailsId,
			OrderByComparator<TraineeElectiverotationPriorityDetails>
				orderByComparator) {

		int count = countByTraineePdTlErDetailsId(traineePdTlErDetailsId);

		if (count == 0) {
			return null;
		}

		List<TraineeElectiverotationPriorityDetails> list =
			findByTraineePdTlErDetailsId(
				traineePdTlErDetailsId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the trainee electiverotation priority detailses before and after the current trainee electiverotation priority details in the ordered set where traineePdTlErDetailsId = &#63;.
	 *
	 * @param traineeElectiverotationPriorityDetailsId the primary key of the current trainee electiverotation priority details
	 * @param traineePdTlErDetailsId the trainee pd tl er details ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next trainee electiverotation priority details
	 * @throws NoSuchTraineeElectiverotationPriorityDetailsException if a trainee electiverotation priority details with the primary key could not be found
	 */
	@Override
	public TraineeElectiverotationPriorityDetails[]
			findByTraineePdTlErDetailsId_PrevAndNext(
				long traineeElectiverotationPriorityDetailsId,
				long traineePdTlErDetailsId,
				OrderByComparator<TraineeElectiverotationPriorityDetails>
					orderByComparator)
		throws NoSuchTraineeElectiverotationPriorityDetailsException {

		TraineeElectiverotationPriorityDetails
			traineeElectiverotationPriorityDetails = findByPrimaryKey(
				traineeElectiverotationPriorityDetailsId);

		Session session = null;

		try {
			session = openSession();

			TraineeElectiverotationPriorityDetails[] array =
				new TraineeElectiverotationPriorityDetailsImpl[3];

			array[0] = getByTraineePdTlErDetailsId_PrevAndNext(
				session, traineeElectiverotationPriorityDetails,
				traineePdTlErDetailsId, orderByComparator, true);

			array[1] = traineeElectiverotationPriorityDetails;

			array[2] = getByTraineePdTlErDetailsId_PrevAndNext(
				session, traineeElectiverotationPriorityDetails,
				traineePdTlErDetailsId, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected TraineeElectiverotationPriorityDetails
		getByTraineePdTlErDetailsId_PrevAndNext(
			Session session,
			TraineeElectiverotationPriorityDetails
				traineeElectiverotationPriorityDetails,
			long traineePdTlErDetailsId,
			OrderByComparator<TraineeElectiverotationPriorityDetails>
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

		sb.append(_SQL_SELECT_TRAINEEELECTIVEROTATIONPRIORITYDETAILS_WHERE);

		sb.append(
			_FINDER_COLUMN_TRAINEEPDTLERDETAILSID_TRAINEEPDTLERDETAILSID_2);

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
				TraineeElectiverotationPriorityDetailsModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(traineePdTlErDetailsId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						traineeElectiverotationPriorityDetails)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<TraineeElectiverotationPriorityDetails> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the trainee electiverotation priority detailses where traineePdTlErDetailsId = &#63; from the database.
	 *
	 * @param traineePdTlErDetailsId the trainee pd tl er details ID
	 */
	@Override
	public void removeByTraineePdTlErDetailsId(long traineePdTlErDetailsId) {
		for (TraineeElectiverotationPriorityDetails
				traineeElectiverotationPriorityDetails :
					findByTraineePdTlErDetailsId(
						traineePdTlErDetailsId, QueryUtil.ALL_POS,
						QueryUtil.ALL_POS, null)) {

			remove(traineeElectiverotationPriorityDetails);
		}
	}

	/**
	 * Returns the number of trainee electiverotation priority detailses where traineePdTlErDetailsId = &#63;.
	 *
	 * @param traineePdTlErDetailsId the trainee pd tl er details ID
	 * @return the number of matching trainee electiverotation priority detailses
	 */
	@Override
	public int countByTraineePdTlErDetailsId(long traineePdTlErDetailsId) {
		FinderPath finderPath = _finderPathCountByTraineePdTlErDetailsId;

		Object[] finderArgs = new Object[] {traineePdTlErDetailsId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_TRAINEEELECTIVEROTATIONPRIORITYDETAILS_WHERE);

			sb.append(
				_FINDER_COLUMN_TRAINEEPDTLERDETAILSID_TRAINEEPDTLERDETAILSID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(traineePdTlErDetailsId);

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
		_FINDER_COLUMN_TRAINEEPDTLERDETAILSID_TRAINEEPDTLERDETAILSID_2 =
			"traineeElectiverotationPriorityDetails.traineePdTlErDetailsId = ?";

	public TraineeElectiverotationPriorityDetailsPersistenceImpl() {
		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("uuid", "uuid_");
		dbColumnNames.put(
			"traineeElectiverotationPriorityDetailsId",
			"trainee_electiverotation_priority_details_id");
		dbColumnNames.put(
			"traineePdTlErDetailsId", "trainee_pd_tl_er_details_id");
		dbColumnNames.put("rotationId", "rotation_id");
		dbColumnNames.put("groupId", "group_id");
		dbColumnNames.put("companyId", "company_id");
		dbColumnNames.put("createDate", "create_date");
		dbColumnNames.put("createdBy", "created_by");
		dbColumnNames.put("modifiedDate", "modified_date");
		dbColumnNames.put("modifiedBy", "modified_by");

		setDBColumnNames(dbColumnNames);

		setModelClass(TraineeElectiverotationPriorityDetails.class);

		setModelImplClass(TraineeElectiverotationPriorityDetailsImpl.class);
		setModelPKClass(long.class);

		setTable(TraineeElectiverotationPriorityDetailsTable.INSTANCE);
	}

	/**
	 * Caches the trainee electiverotation priority details in the entity cache if it is enabled.
	 *
	 * @param traineeElectiverotationPriorityDetails the trainee electiverotation priority details
	 */
	@Override
	public void cacheResult(
		TraineeElectiverotationPriorityDetails
			traineeElectiverotationPriorityDetails) {

		entityCache.putResult(
			TraineeElectiverotationPriorityDetailsImpl.class,
			traineeElectiverotationPriorityDetails.getPrimaryKey(),
			traineeElectiverotationPriorityDetails);

		finderCache.putResult(
			_finderPathFetchByUUID_G,
			new Object[] {
				traineeElectiverotationPriorityDetails.getUuid(),
				traineeElectiverotationPriorityDetails.getGroupId()
			},
			traineeElectiverotationPriorityDetails);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the trainee electiverotation priority detailses in the entity cache if it is enabled.
	 *
	 * @param traineeElectiverotationPriorityDetailses the trainee electiverotation priority detailses
	 */
	@Override
	public void cacheResult(
		List<TraineeElectiverotationPriorityDetails>
			traineeElectiverotationPriorityDetailses) {

		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (traineeElectiverotationPriorityDetailses.size() >
				 _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (TraineeElectiverotationPriorityDetails
				traineeElectiverotationPriorityDetails :
					traineeElectiverotationPriorityDetailses) {

			if (entityCache.getResult(
					TraineeElectiverotationPriorityDetailsImpl.class,
					traineeElectiverotationPriorityDetails.getPrimaryKey()) ==
						null) {

				cacheResult(traineeElectiverotationPriorityDetails);
			}
		}
	}

	/**
	 * Clears the cache for all trainee electiverotation priority detailses.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(
			TraineeElectiverotationPriorityDetailsImpl.class);

		finderCache.clearCache(
			TraineeElectiverotationPriorityDetailsImpl.class);
	}

	/**
	 * Clears the cache for the trainee electiverotation priority details.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(
		TraineeElectiverotationPriorityDetails
			traineeElectiverotationPriorityDetails) {

		entityCache.removeResult(
			TraineeElectiverotationPriorityDetailsImpl.class,
			traineeElectiverotationPriorityDetails);
	}

	@Override
	public void clearCache(
		List<TraineeElectiverotationPriorityDetails>
			traineeElectiverotationPriorityDetailses) {

		for (TraineeElectiverotationPriorityDetails
				traineeElectiverotationPriorityDetails :
					traineeElectiverotationPriorityDetailses) {

			entityCache.removeResult(
				TraineeElectiverotationPriorityDetailsImpl.class,
				traineeElectiverotationPriorityDetails);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(
			TraineeElectiverotationPriorityDetailsImpl.class);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(
				TraineeElectiverotationPriorityDetailsImpl.class, primaryKey);
		}
	}

	protected void cacheUniqueFindersCache(
		TraineeElectiverotationPriorityDetailsModelImpl
			traineeElectiverotationPriorityDetailsModelImpl) {

		Object[] args = new Object[] {
			traineeElectiverotationPriorityDetailsModelImpl.getUuid(),
			traineeElectiverotationPriorityDetailsModelImpl.getGroupId()
		};

		finderCache.putResult(_finderPathCountByUUID_G, args, Long.valueOf(1));
		finderCache.putResult(
			_finderPathFetchByUUID_G, args,
			traineeElectiverotationPriorityDetailsModelImpl);
	}

	/**
	 * Creates a new trainee electiverotation priority details with the primary key. Does not add the trainee electiverotation priority details to the database.
	 *
	 * @param traineeElectiverotationPriorityDetailsId the primary key for the new trainee electiverotation priority details
	 * @return the new trainee electiverotation priority details
	 */
	@Override
	public TraineeElectiverotationPriorityDetails create(
		long traineeElectiverotationPriorityDetailsId) {

		TraineeElectiverotationPriorityDetails
			traineeElectiverotationPriorityDetails =
				new TraineeElectiverotationPriorityDetailsImpl();

		traineeElectiverotationPriorityDetails.setNew(true);
		traineeElectiverotationPriorityDetails.setPrimaryKey(
			traineeElectiverotationPriorityDetailsId);

		String uuid = _portalUUID.generate();

		traineeElectiverotationPriorityDetails.setUuid(uuid);

		traineeElectiverotationPriorityDetails.setCompanyId(
			CompanyThreadLocal.getCompanyId());

		return traineeElectiverotationPriorityDetails;
	}

	/**
	 * Removes the trainee electiverotation priority details with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param traineeElectiverotationPriorityDetailsId the primary key of the trainee electiverotation priority details
	 * @return the trainee electiverotation priority details that was removed
	 * @throws NoSuchTraineeElectiverotationPriorityDetailsException if a trainee electiverotation priority details with the primary key could not be found
	 */
	@Override
	public TraineeElectiverotationPriorityDetails remove(
			long traineeElectiverotationPriorityDetailsId)
		throws NoSuchTraineeElectiverotationPriorityDetailsException {

		return remove((Serializable)traineeElectiverotationPriorityDetailsId);
	}

	/**
	 * Removes the trainee electiverotation priority details with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the trainee electiverotation priority details
	 * @return the trainee electiverotation priority details that was removed
	 * @throws NoSuchTraineeElectiverotationPriorityDetailsException if a trainee electiverotation priority details with the primary key could not be found
	 */
	@Override
	public TraineeElectiverotationPriorityDetails remove(
			Serializable primaryKey)
		throws NoSuchTraineeElectiverotationPriorityDetailsException {

		Session session = null;

		try {
			session = openSession();

			TraineeElectiverotationPriorityDetails
				traineeElectiverotationPriorityDetails =
					(TraineeElectiverotationPriorityDetails)session.get(
						TraineeElectiverotationPriorityDetailsImpl.class,
						primaryKey);

			if (traineeElectiverotationPriorityDetails == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchTraineeElectiverotationPriorityDetailsException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(traineeElectiverotationPriorityDetails);
		}
		catch (NoSuchTraineeElectiverotationPriorityDetailsException
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
	protected TraineeElectiverotationPriorityDetails removeImpl(
		TraineeElectiverotationPriorityDetails
			traineeElectiverotationPriorityDetails) {

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(traineeElectiverotationPriorityDetails)) {
				traineeElectiverotationPriorityDetails =
					(TraineeElectiverotationPriorityDetails)session.get(
						TraineeElectiverotationPriorityDetailsImpl.class,
						traineeElectiverotationPriorityDetails.
							getPrimaryKeyObj());
			}

			if (traineeElectiverotationPriorityDetails != null) {
				session.delete(traineeElectiverotationPriorityDetails);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (traineeElectiverotationPriorityDetails != null) {
			clearCache(traineeElectiverotationPriorityDetails);
		}

		return traineeElectiverotationPriorityDetails;
	}

	@Override
	public TraineeElectiverotationPriorityDetails updateImpl(
		TraineeElectiverotationPriorityDetails
			traineeElectiverotationPriorityDetails) {

		boolean isNew = traineeElectiverotationPriorityDetails.isNew();

		if (!(traineeElectiverotationPriorityDetails instanceof
				TraineeElectiverotationPriorityDetailsModelImpl)) {

			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(
					traineeElectiverotationPriorityDetails.getClass())) {

				invocationHandler = ProxyUtil.getInvocationHandler(
					traineeElectiverotationPriorityDetails);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in traineeElectiverotationPriorityDetails proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom TraineeElectiverotationPriorityDetails implementation " +
					traineeElectiverotationPriorityDetails.getClass());
		}

		TraineeElectiverotationPriorityDetailsModelImpl
			traineeElectiverotationPriorityDetailsModelImpl =
				(TraineeElectiverotationPriorityDetailsModelImpl)
					traineeElectiverotationPriorityDetails;

		if (Validator.isNull(
				traineeElectiverotationPriorityDetails.getUuid())) {

			String uuid = _portalUUID.generate();

			traineeElectiverotationPriorityDetails.setUuid(uuid);
		}

		ServiceContext serviceContext =
			ServiceContextThreadLocal.getServiceContext();

		Date date = new Date();

		if (isNew &&
			(traineeElectiverotationPriorityDetails.getCreateDate() == null)) {

			if (serviceContext == null) {
				traineeElectiverotationPriorityDetails.setCreateDate(date);
			}
			else {
				traineeElectiverotationPriorityDetails.setCreateDate(
					serviceContext.getCreateDate(date));
			}
		}

		if (!traineeElectiverotationPriorityDetailsModelImpl.
				hasSetModifiedDate()) {

			if (serviceContext == null) {
				traineeElectiverotationPriorityDetails.setModifiedDate(date);
			}
			else {
				traineeElectiverotationPriorityDetails.setModifiedDate(
					serviceContext.getModifiedDate(date));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(traineeElectiverotationPriorityDetails);
			}
			else {
				traineeElectiverotationPriorityDetails =
					(TraineeElectiverotationPriorityDetails)session.merge(
						traineeElectiverotationPriorityDetails);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(
			TraineeElectiverotationPriorityDetailsImpl.class,
			traineeElectiverotationPriorityDetailsModelImpl, false, true);

		cacheUniqueFindersCache(
			traineeElectiverotationPriorityDetailsModelImpl);

		if (isNew) {
			traineeElectiverotationPriorityDetails.setNew(false);
		}

		traineeElectiverotationPriorityDetails.resetOriginalValues();

		return traineeElectiverotationPriorityDetails;
	}

	/**
	 * Returns the trainee electiverotation priority details with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the trainee electiverotation priority details
	 * @return the trainee electiverotation priority details
	 * @throws NoSuchTraineeElectiverotationPriorityDetailsException if a trainee electiverotation priority details with the primary key could not be found
	 */
	@Override
	public TraineeElectiverotationPriorityDetails findByPrimaryKey(
			Serializable primaryKey)
		throws NoSuchTraineeElectiverotationPriorityDetailsException {

		TraineeElectiverotationPriorityDetails
			traineeElectiverotationPriorityDetails = fetchByPrimaryKey(
				primaryKey);

		if (traineeElectiverotationPriorityDetails == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchTraineeElectiverotationPriorityDetailsException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return traineeElectiverotationPriorityDetails;
	}

	/**
	 * Returns the trainee electiverotation priority details with the primary key or throws a <code>NoSuchTraineeElectiverotationPriorityDetailsException</code> if it could not be found.
	 *
	 * @param traineeElectiverotationPriorityDetailsId the primary key of the trainee electiverotation priority details
	 * @return the trainee electiverotation priority details
	 * @throws NoSuchTraineeElectiverotationPriorityDetailsException if a trainee electiverotation priority details with the primary key could not be found
	 */
	@Override
	public TraineeElectiverotationPriorityDetails findByPrimaryKey(
			long traineeElectiverotationPriorityDetailsId)
		throws NoSuchTraineeElectiverotationPriorityDetailsException {

		return findByPrimaryKey(
			(Serializable)traineeElectiverotationPriorityDetailsId);
	}

	/**
	 * Returns the trainee electiverotation priority details with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param traineeElectiverotationPriorityDetailsId the primary key of the trainee electiverotation priority details
	 * @return the trainee electiverotation priority details, or <code>null</code> if a trainee electiverotation priority details with the primary key could not be found
	 */
	@Override
	public TraineeElectiverotationPriorityDetails fetchByPrimaryKey(
		long traineeElectiverotationPriorityDetailsId) {

		return fetchByPrimaryKey(
			(Serializable)traineeElectiverotationPriorityDetailsId);
	}

	/**
	 * Returns all the trainee electiverotation priority detailses.
	 *
	 * @return the trainee electiverotation priority detailses
	 */
	@Override
	public List<TraineeElectiverotationPriorityDetails> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the trainee electiverotation priority detailses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TraineeElectiverotationPriorityDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of trainee electiverotation priority detailses
	 * @param end the upper bound of the range of trainee electiverotation priority detailses (not inclusive)
	 * @return the range of trainee electiverotation priority detailses
	 */
	@Override
	public List<TraineeElectiverotationPriorityDetails> findAll(
		int start, int end) {

		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the trainee electiverotation priority detailses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TraineeElectiverotationPriorityDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of trainee electiverotation priority detailses
	 * @param end the upper bound of the range of trainee electiverotation priority detailses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of trainee electiverotation priority detailses
	 */
	@Override
	public List<TraineeElectiverotationPriorityDetails> findAll(
		int start, int end,
		OrderByComparator<TraineeElectiverotationPriorityDetails>
			orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the trainee electiverotation priority detailses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TraineeElectiverotationPriorityDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of trainee electiverotation priority detailses
	 * @param end the upper bound of the range of trainee electiverotation priority detailses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of trainee electiverotation priority detailses
	 */
	@Override
	public List<TraineeElectiverotationPriorityDetails> findAll(
		int start, int end,
		OrderByComparator<TraineeElectiverotationPriorityDetails>
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

		List<TraineeElectiverotationPriorityDetails> list = null;

		if (useFinderCache) {
			list =
				(List<TraineeElectiverotationPriorityDetails>)
					finderCache.getResult(finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_TRAINEEELECTIVEROTATIONPRIORITYDETAILS);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_TRAINEEELECTIVEROTATIONPRIORITYDETAILS;

				sql = sql.concat(
					TraineeElectiverotationPriorityDetailsModelImpl.
						ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list =
					(List<TraineeElectiverotationPriorityDetails>)
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
	 * Removes all the trainee electiverotation priority detailses from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (TraineeElectiverotationPriorityDetails
				traineeElectiverotationPriorityDetails : findAll()) {

			remove(traineeElectiverotationPriorityDetails);
		}
	}

	/**
	 * Returns the number of trainee electiverotation priority detailses.
	 *
	 * @return the number of trainee electiverotation priority detailses
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
					_SQL_COUNT_TRAINEEELECTIVEROTATIONPRIORITYDETAILS);

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
		return "trainee_electiverotation_priority_details_id";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_TRAINEEELECTIVEROTATIONPRIORITYDETAILS;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return TraineeElectiverotationPriorityDetailsModelImpl.
			TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the trainee electiverotation priority details persistence.
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

		_finderPathWithPaginationFindByTraineePdTlErDetailsId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByTraineePdTlErDetailsId",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"trainee_pd_tl_er_details_id"}, true);

		_finderPathWithoutPaginationFindByTraineePdTlErDetailsId =
			new FinderPath(
				FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
				"findByTraineePdTlErDetailsId",
				new String[] {Long.class.getName()},
				new String[] {"trainee_pd_tl_er_details_id"}, true);

		_finderPathCountByTraineePdTlErDetailsId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByTraineePdTlErDetailsId",
			new String[] {Long.class.getName()},
			new String[] {"trainee_pd_tl_er_details_id"}, false);

		_setTraineeElectiverotationPriorityDetailsUtilPersistence(this);
	}

	@Deactivate
	public void deactivate() {
		_setTraineeElectiverotationPriorityDetailsUtilPersistence(null);

		entityCache.removeCache(
			TraineeElectiverotationPriorityDetailsImpl.class.getName());
	}

	private void _setTraineeElectiverotationPriorityDetailsUtilPersistence(
		TraineeElectiverotationPriorityDetailsPersistence
			traineeElectiverotationPriorityDetailsPersistence) {

		try {
			Field field =
				TraineeElectiverotationPriorityDetailsUtil.class.
					getDeclaredField("_persistence");

			field.setAccessible(true);

			field.set(null, traineeElectiverotationPriorityDetailsPersistence);
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
		_SQL_SELECT_TRAINEEELECTIVEROTATIONPRIORITYDETAILS =
			"SELECT traineeElectiverotationPriorityDetails FROM TraineeElectiverotationPriorityDetails traineeElectiverotationPriorityDetails";

	private static final String
		_SQL_SELECT_TRAINEEELECTIVEROTATIONPRIORITYDETAILS_WHERE =
			"SELECT traineeElectiverotationPriorityDetails FROM TraineeElectiverotationPriorityDetails traineeElectiverotationPriorityDetails WHERE ";

	private static final String
		_SQL_COUNT_TRAINEEELECTIVEROTATIONPRIORITYDETAILS =
			"SELECT COUNT(traineeElectiverotationPriorityDetails) FROM TraineeElectiverotationPriorityDetails traineeElectiverotationPriorityDetails";

	private static final String
		_SQL_COUNT_TRAINEEELECTIVEROTATIONPRIORITYDETAILS_WHERE =
			"SELECT COUNT(traineeElectiverotationPriorityDetails) FROM TraineeElectiverotationPriorityDetails traineeElectiverotationPriorityDetails WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS =
		"traineeElectiverotationPriorityDetails.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No TraineeElectiverotationPriorityDetails exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No TraineeElectiverotationPriorityDetails exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		TraineeElectiverotationPriorityDetailsPersistenceImpl.class);

	private static final Set<String> _badColumnNames = SetUtil.fromArray(
		new String[] {
			"uuid", "traineeElectiverotationPriorityDetailsId",
			"traineePdTlErDetailsId", "rotationId", "groupId", "companyId",
			"createDate", "createdBy", "modifiedDate", "modifiedBy"
		});

	@Override
	protected FinderCache getFinderCache() {
		return finderCache;
	}

	@Reference
	private PortalUUID _portalUUID;

}
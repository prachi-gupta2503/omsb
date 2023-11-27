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

import gov.omsb.tms.exception.NoSuchTraineeLoggedProcedureDetailsException;
import gov.omsb.tms.model.TraineeLoggedProcedureDetails;
import gov.omsb.tms.model.TraineeLoggedProcedureDetailsTable;
import gov.omsb.tms.model.impl.TraineeLoggedProcedureDetailsImpl;
import gov.omsb.tms.model.impl.TraineeLoggedProcedureDetailsModelImpl;
import gov.omsb.tms.service.persistence.TraineeLoggedProcedureDetailsPersistence;
import gov.omsb.tms.service.persistence.TraineeLoggedProcedureDetailsUtil;
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
 * The persistence implementation for the trainee logged procedure details service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = TraineeLoggedProcedureDetailsPersistence.class)
public class TraineeLoggedProcedureDetailsPersistenceImpl
	extends BasePersistenceImpl<TraineeLoggedProcedureDetails>
	implements TraineeLoggedProcedureDetailsPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>TraineeLoggedProcedureDetailsUtil</code> to access the trainee logged procedure details persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		TraineeLoggedProcedureDetailsImpl.class.getName();

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
	 * Returns all the trainee logged procedure detailses where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching trainee logged procedure detailses
	 */
	@Override
	public List<TraineeLoggedProcedureDetails> findByUuid(String uuid) {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the trainee logged procedure detailses where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TraineeLoggedProcedureDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of trainee logged procedure detailses
	 * @param end the upper bound of the range of trainee logged procedure detailses (not inclusive)
	 * @return the range of matching trainee logged procedure detailses
	 */
	@Override
	public List<TraineeLoggedProcedureDetails> findByUuid(
		String uuid, int start, int end) {

		return findByUuid(uuid, start, end, null);
	}

	/**
	 * Returns an ordered range of all the trainee logged procedure detailses where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TraineeLoggedProcedureDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of trainee logged procedure detailses
	 * @param end the upper bound of the range of trainee logged procedure detailses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching trainee logged procedure detailses
	 */
	@Override
	public List<TraineeLoggedProcedureDetails> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<TraineeLoggedProcedureDetails> orderByComparator) {

		return findByUuid(uuid, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the trainee logged procedure detailses where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TraineeLoggedProcedureDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of trainee logged procedure detailses
	 * @param end the upper bound of the range of trainee logged procedure detailses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching trainee logged procedure detailses
	 */
	@Override
	public List<TraineeLoggedProcedureDetails> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<TraineeLoggedProcedureDetails> orderByComparator,
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

		List<TraineeLoggedProcedureDetails> list = null;

		if (useFinderCache) {
			list = (List<TraineeLoggedProcedureDetails>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (TraineeLoggedProcedureDetails
						traineeLoggedProcedureDetails : list) {

					if (!uuid.equals(traineeLoggedProcedureDetails.getUuid())) {
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

			sb.append(_SQL_SELECT_TRAINEELOGGEDPROCEDUREDETAILS_WHERE);

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
				sb.append(TraineeLoggedProcedureDetailsModelImpl.ORDER_BY_JPQL);
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

				list = (List<TraineeLoggedProcedureDetails>)QueryUtil.list(
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
	 * Returns the first trainee logged procedure details in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching trainee logged procedure details
	 * @throws NoSuchTraineeLoggedProcedureDetailsException if a matching trainee logged procedure details could not be found
	 */
	@Override
	public TraineeLoggedProcedureDetails findByUuid_First(
			String uuid,
			OrderByComparator<TraineeLoggedProcedureDetails> orderByComparator)
		throws NoSuchTraineeLoggedProcedureDetailsException {

		TraineeLoggedProcedureDetails traineeLoggedProcedureDetails =
			fetchByUuid_First(uuid, orderByComparator);

		if (traineeLoggedProcedureDetails != null) {
			return traineeLoggedProcedureDetails;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchTraineeLoggedProcedureDetailsException(sb.toString());
	}

	/**
	 * Returns the first trainee logged procedure details in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching trainee logged procedure details, or <code>null</code> if a matching trainee logged procedure details could not be found
	 */
	@Override
	public TraineeLoggedProcedureDetails fetchByUuid_First(
		String uuid,
		OrderByComparator<TraineeLoggedProcedureDetails> orderByComparator) {

		List<TraineeLoggedProcedureDetails> list = findByUuid(
			uuid, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last trainee logged procedure details in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching trainee logged procedure details
	 * @throws NoSuchTraineeLoggedProcedureDetailsException if a matching trainee logged procedure details could not be found
	 */
	@Override
	public TraineeLoggedProcedureDetails findByUuid_Last(
			String uuid,
			OrderByComparator<TraineeLoggedProcedureDetails> orderByComparator)
		throws NoSuchTraineeLoggedProcedureDetailsException {

		TraineeLoggedProcedureDetails traineeLoggedProcedureDetails =
			fetchByUuid_Last(uuid, orderByComparator);

		if (traineeLoggedProcedureDetails != null) {
			return traineeLoggedProcedureDetails;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchTraineeLoggedProcedureDetailsException(sb.toString());
	}

	/**
	 * Returns the last trainee logged procedure details in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching trainee logged procedure details, or <code>null</code> if a matching trainee logged procedure details could not be found
	 */
	@Override
	public TraineeLoggedProcedureDetails fetchByUuid_Last(
		String uuid,
		OrderByComparator<TraineeLoggedProcedureDetails> orderByComparator) {

		int count = countByUuid(uuid);

		if (count == 0) {
			return null;
		}

		List<TraineeLoggedProcedureDetails> list = findByUuid(
			uuid, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the trainee logged procedure detailses before and after the current trainee logged procedure details in the ordered set where uuid = &#63;.
	 *
	 * @param traineeLoggedProcedureDetailsId the primary key of the current trainee logged procedure details
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next trainee logged procedure details
	 * @throws NoSuchTraineeLoggedProcedureDetailsException if a trainee logged procedure details with the primary key could not be found
	 */
	@Override
	public TraineeLoggedProcedureDetails[] findByUuid_PrevAndNext(
			long traineeLoggedProcedureDetailsId, String uuid,
			OrderByComparator<TraineeLoggedProcedureDetails> orderByComparator)
		throws NoSuchTraineeLoggedProcedureDetailsException {

		uuid = Objects.toString(uuid, "");

		TraineeLoggedProcedureDetails traineeLoggedProcedureDetails =
			findByPrimaryKey(traineeLoggedProcedureDetailsId);

		Session session = null;

		try {
			session = openSession();

			TraineeLoggedProcedureDetails[] array =
				new TraineeLoggedProcedureDetailsImpl[3];

			array[0] = getByUuid_PrevAndNext(
				session, traineeLoggedProcedureDetails, uuid, orderByComparator,
				true);

			array[1] = traineeLoggedProcedureDetails;

			array[2] = getByUuid_PrevAndNext(
				session, traineeLoggedProcedureDetails, uuid, orderByComparator,
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

	protected TraineeLoggedProcedureDetails getByUuid_PrevAndNext(
		Session session,
		TraineeLoggedProcedureDetails traineeLoggedProcedureDetails,
		String uuid,
		OrderByComparator<TraineeLoggedProcedureDetails> orderByComparator,
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

		sb.append(_SQL_SELECT_TRAINEELOGGEDPROCEDUREDETAILS_WHERE);

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
			sb.append(TraineeLoggedProcedureDetailsModelImpl.ORDER_BY_JPQL);
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
						traineeLoggedProcedureDetails)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<TraineeLoggedProcedureDetails> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the trainee logged procedure detailses where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	@Override
	public void removeByUuid(String uuid) {
		for (TraineeLoggedProcedureDetails traineeLoggedProcedureDetails :
				findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(traineeLoggedProcedureDetails);
		}
	}

	/**
	 * Returns the number of trainee logged procedure detailses where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching trainee logged procedure detailses
	 */
	@Override
	public int countByUuid(String uuid) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid;

		Object[] finderArgs = new Object[] {uuid};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_TRAINEELOGGEDPROCEDUREDETAILS_WHERE);

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
		"traineeLoggedProcedureDetails.uuid = ?";

	private static final String _FINDER_COLUMN_UUID_UUID_3 =
		"(traineeLoggedProcedureDetails.uuid IS NULL OR traineeLoggedProcedureDetails.uuid = '')";

	private FinderPath _finderPathFetchByUUID_G;
	private FinderPath _finderPathCountByUUID_G;

	/**
	 * Returns the trainee logged procedure details where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchTraineeLoggedProcedureDetailsException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching trainee logged procedure details
	 * @throws NoSuchTraineeLoggedProcedureDetailsException if a matching trainee logged procedure details could not be found
	 */
	@Override
	public TraineeLoggedProcedureDetails findByUUID_G(String uuid, long groupId)
		throws NoSuchTraineeLoggedProcedureDetailsException {

		TraineeLoggedProcedureDetails traineeLoggedProcedureDetails =
			fetchByUUID_G(uuid, groupId);

		if (traineeLoggedProcedureDetails == null) {
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

			throw new NoSuchTraineeLoggedProcedureDetailsException(
				sb.toString());
		}

		return traineeLoggedProcedureDetails;
	}

	/**
	 * Returns the trainee logged procedure details where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching trainee logged procedure details, or <code>null</code> if a matching trainee logged procedure details could not be found
	 */
	@Override
	public TraineeLoggedProcedureDetails fetchByUUID_G(
		String uuid, long groupId) {

		return fetchByUUID_G(uuid, groupId, true);
	}

	/**
	 * Returns the trainee logged procedure details where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching trainee logged procedure details, or <code>null</code> if a matching trainee logged procedure details could not be found
	 */
	@Override
	public TraineeLoggedProcedureDetails fetchByUUID_G(
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

		if (result instanceof TraineeLoggedProcedureDetails) {
			TraineeLoggedProcedureDetails traineeLoggedProcedureDetails =
				(TraineeLoggedProcedureDetails)result;

			if (!Objects.equals(
					uuid, traineeLoggedProcedureDetails.getUuid()) ||
				(groupId != traineeLoggedProcedureDetails.getGroupId())) {

				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_SQL_SELECT_TRAINEELOGGEDPROCEDUREDETAILS_WHERE);

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

				List<TraineeLoggedProcedureDetails> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchByUUID_G, finderArgs, list);
					}
				}
				else {
					TraineeLoggedProcedureDetails
						traineeLoggedProcedureDetails = list.get(0);

					result = traineeLoggedProcedureDetails;

					cacheResult(traineeLoggedProcedureDetails);
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
			return (TraineeLoggedProcedureDetails)result;
		}
	}

	/**
	 * Removes the trainee logged procedure details where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the trainee logged procedure details that was removed
	 */
	@Override
	public TraineeLoggedProcedureDetails removeByUUID_G(
			String uuid, long groupId)
		throws NoSuchTraineeLoggedProcedureDetailsException {

		TraineeLoggedProcedureDetails traineeLoggedProcedureDetails =
			findByUUID_G(uuid, groupId);

		return remove(traineeLoggedProcedureDetails);
	}

	/**
	 * Returns the number of trainee logged procedure detailses where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching trainee logged procedure detailses
	 */
	@Override
	public int countByUUID_G(String uuid, long groupId) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUUID_G;

		Object[] finderArgs = new Object[] {uuid, groupId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_TRAINEELOGGEDPROCEDUREDETAILS_WHERE);

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
		"traineeLoggedProcedureDetails.uuid = ? AND ";

	private static final String _FINDER_COLUMN_UUID_G_UUID_3 =
		"(traineeLoggedProcedureDetails.uuid IS NULL OR traineeLoggedProcedureDetails.uuid = '') AND ";

	private static final String _FINDER_COLUMN_UUID_G_GROUPID_2 =
		"traineeLoggedProcedureDetails.groupId = ?";

	private FinderPath _finderPathWithPaginationFindByUuid_C;
	private FinderPath _finderPathWithoutPaginationFindByUuid_C;
	private FinderPath _finderPathCountByUuid_C;

	/**
	 * Returns all the trainee logged procedure detailses where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching trainee logged procedure detailses
	 */
	@Override
	public List<TraineeLoggedProcedureDetails> findByUuid_C(
		String uuid, long companyId) {

		return findByUuid_C(
			uuid, companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the trainee logged procedure detailses where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TraineeLoggedProcedureDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of trainee logged procedure detailses
	 * @param end the upper bound of the range of trainee logged procedure detailses (not inclusive)
	 * @return the range of matching trainee logged procedure detailses
	 */
	@Override
	public List<TraineeLoggedProcedureDetails> findByUuid_C(
		String uuid, long companyId, int start, int end) {

		return findByUuid_C(uuid, companyId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the trainee logged procedure detailses where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TraineeLoggedProcedureDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of trainee logged procedure detailses
	 * @param end the upper bound of the range of trainee logged procedure detailses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching trainee logged procedure detailses
	 */
	@Override
	public List<TraineeLoggedProcedureDetails> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<TraineeLoggedProcedureDetails> orderByComparator) {

		return findByUuid_C(
			uuid, companyId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the trainee logged procedure detailses where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TraineeLoggedProcedureDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of trainee logged procedure detailses
	 * @param end the upper bound of the range of trainee logged procedure detailses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching trainee logged procedure detailses
	 */
	@Override
	public List<TraineeLoggedProcedureDetails> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<TraineeLoggedProcedureDetails> orderByComparator,
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

		List<TraineeLoggedProcedureDetails> list = null;

		if (useFinderCache) {
			list = (List<TraineeLoggedProcedureDetails>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (TraineeLoggedProcedureDetails
						traineeLoggedProcedureDetails : list) {

					if (!uuid.equals(traineeLoggedProcedureDetails.getUuid()) ||
						(companyId !=
							traineeLoggedProcedureDetails.getCompanyId())) {

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

			sb.append(_SQL_SELECT_TRAINEELOGGEDPROCEDUREDETAILS_WHERE);

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
				sb.append(TraineeLoggedProcedureDetailsModelImpl.ORDER_BY_JPQL);
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

				list = (List<TraineeLoggedProcedureDetails>)QueryUtil.list(
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
	 * Returns the first trainee logged procedure details in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching trainee logged procedure details
	 * @throws NoSuchTraineeLoggedProcedureDetailsException if a matching trainee logged procedure details could not be found
	 */
	@Override
	public TraineeLoggedProcedureDetails findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<TraineeLoggedProcedureDetails> orderByComparator)
		throws NoSuchTraineeLoggedProcedureDetailsException {

		TraineeLoggedProcedureDetails traineeLoggedProcedureDetails =
			fetchByUuid_C_First(uuid, companyId, orderByComparator);

		if (traineeLoggedProcedureDetails != null) {
			return traineeLoggedProcedureDetails;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append(", companyId=");
		sb.append(companyId);

		sb.append("}");

		throw new NoSuchTraineeLoggedProcedureDetailsException(sb.toString());
	}

	/**
	 * Returns the first trainee logged procedure details in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching trainee logged procedure details, or <code>null</code> if a matching trainee logged procedure details could not be found
	 */
	@Override
	public TraineeLoggedProcedureDetails fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<TraineeLoggedProcedureDetails> orderByComparator) {

		List<TraineeLoggedProcedureDetails> list = findByUuid_C(
			uuid, companyId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last trainee logged procedure details in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching trainee logged procedure details
	 * @throws NoSuchTraineeLoggedProcedureDetailsException if a matching trainee logged procedure details could not be found
	 */
	@Override
	public TraineeLoggedProcedureDetails findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<TraineeLoggedProcedureDetails> orderByComparator)
		throws NoSuchTraineeLoggedProcedureDetailsException {

		TraineeLoggedProcedureDetails traineeLoggedProcedureDetails =
			fetchByUuid_C_Last(uuid, companyId, orderByComparator);

		if (traineeLoggedProcedureDetails != null) {
			return traineeLoggedProcedureDetails;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append(", companyId=");
		sb.append(companyId);

		sb.append("}");

		throw new NoSuchTraineeLoggedProcedureDetailsException(sb.toString());
	}

	/**
	 * Returns the last trainee logged procedure details in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching trainee logged procedure details, or <code>null</code> if a matching trainee logged procedure details could not be found
	 */
	@Override
	public TraineeLoggedProcedureDetails fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<TraineeLoggedProcedureDetails> orderByComparator) {

		int count = countByUuid_C(uuid, companyId);

		if (count == 0) {
			return null;
		}

		List<TraineeLoggedProcedureDetails> list = findByUuid_C(
			uuid, companyId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the trainee logged procedure detailses before and after the current trainee logged procedure details in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param traineeLoggedProcedureDetailsId the primary key of the current trainee logged procedure details
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next trainee logged procedure details
	 * @throws NoSuchTraineeLoggedProcedureDetailsException if a trainee logged procedure details with the primary key could not be found
	 */
	@Override
	public TraineeLoggedProcedureDetails[] findByUuid_C_PrevAndNext(
			long traineeLoggedProcedureDetailsId, String uuid, long companyId,
			OrderByComparator<TraineeLoggedProcedureDetails> orderByComparator)
		throws NoSuchTraineeLoggedProcedureDetailsException {

		uuid = Objects.toString(uuid, "");

		TraineeLoggedProcedureDetails traineeLoggedProcedureDetails =
			findByPrimaryKey(traineeLoggedProcedureDetailsId);

		Session session = null;

		try {
			session = openSession();

			TraineeLoggedProcedureDetails[] array =
				new TraineeLoggedProcedureDetailsImpl[3];

			array[0] = getByUuid_C_PrevAndNext(
				session, traineeLoggedProcedureDetails, uuid, companyId,
				orderByComparator, true);

			array[1] = traineeLoggedProcedureDetails;

			array[2] = getByUuid_C_PrevAndNext(
				session, traineeLoggedProcedureDetails, uuid, companyId,
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

	protected TraineeLoggedProcedureDetails getByUuid_C_PrevAndNext(
		Session session,
		TraineeLoggedProcedureDetails traineeLoggedProcedureDetails,
		String uuid, long companyId,
		OrderByComparator<TraineeLoggedProcedureDetails> orderByComparator,
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

		sb.append(_SQL_SELECT_TRAINEELOGGEDPROCEDUREDETAILS_WHERE);

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
			sb.append(TraineeLoggedProcedureDetailsModelImpl.ORDER_BY_JPQL);
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
						traineeLoggedProcedureDetails)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<TraineeLoggedProcedureDetails> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the trainee logged procedure detailses where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	@Override
	public void removeByUuid_C(String uuid, long companyId) {
		for (TraineeLoggedProcedureDetails traineeLoggedProcedureDetails :
				findByUuid_C(
					uuid, companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(traineeLoggedProcedureDetails);
		}
	}

	/**
	 * Returns the number of trainee logged procedure detailses where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching trainee logged procedure detailses
	 */
	@Override
	public int countByUuid_C(String uuid, long companyId) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid_C;

		Object[] finderArgs = new Object[] {uuid, companyId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_TRAINEELOGGEDPROCEDUREDETAILS_WHERE);

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
		"traineeLoggedProcedureDetails.uuid = ? AND ";

	private static final String _FINDER_COLUMN_UUID_C_UUID_3 =
		"(traineeLoggedProcedureDetails.uuid IS NULL OR traineeLoggedProcedureDetails.uuid = '') AND ";

	private static final String _FINDER_COLUMN_UUID_C_COMPANYID_2 =
		"traineeLoggedProcedureDetails.companyId = ?";

	private FinderPath _finderPathWithPaginationFindByPatientId;
	private FinderPath _finderPathWithoutPaginationFindByPatientId;
	private FinderPath _finderPathCountByPatientId;

	/**
	 * Returns all the trainee logged procedure detailses where patientId = &#63;.
	 *
	 * @param patientId the patient ID
	 * @return the matching trainee logged procedure detailses
	 */
	@Override
	public List<TraineeLoggedProcedureDetails> findByPatientId(
		String patientId) {

		return findByPatientId(
			patientId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the trainee logged procedure detailses where patientId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TraineeLoggedProcedureDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param patientId the patient ID
	 * @param start the lower bound of the range of trainee logged procedure detailses
	 * @param end the upper bound of the range of trainee logged procedure detailses (not inclusive)
	 * @return the range of matching trainee logged procedure detailses
	 */
	@Override
	public List<TraineeLoggedProcedureDetails> findByPatientId(
		String patientId, int start, int end) {

		return findByPatientId(patientId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the trainee logged procedure detailses where patientId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TraineeLoggedProcedureDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param patientId the patient ID
	 * @param start the lower bound of the range of trainee logged procedure detailses
	 * @param end the upper bound of the range of trainee logged procedure detailses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching trainee logged procedure detailses
	 */
	@Override
	public List<TraineeLoggedProcedureDetails> findByPatientId(
		String patientId, int start, int end,
		OrderByComparator<TraineeLoggedProcedureDetails> orderByComparator) {

		return findByPatientId(patientId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the trainee logged procedure detailses where patientId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TraineeLoggedProcedureDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param patientId the patient ID
	 * @param start the lower bound of the range of trainee logged procedure detailses
	 * @param end the upper bound of the range of trainee logged procedure detailses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching trainee logged procedure detailses
	 */
	@Override
	public List<TraineeLoggedProcedureDetails> findByPatientId(
		String patientId, int start, int end,
		OrderByComparator<TraineeLoggedProcedureDetails> orderByComparator,
		boolean useFinderCache) {

		patientId = Objects.toString(patientId, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByPatientId;
				finderArgs = new Object[] {patientId};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByPatientId;
			finderArgs = new Object[] {
				patientId, start, end, orderByComparator
			};
		}

		List<TraineeLoggedProcedureDetails> list = null;

		if (useFinderCache) {
			list = (List<TraineeLoggedProcedureDetails>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (TraineeLoggedProcedureDetails
						traineeLoggedProcedureDetails : list) {

					if (!patientId.equals(
							traineeLoggedProcedureDetails.getPatientId())) {

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

			sb.append(_SQL_SELECT_TRAINEELOGGEDPROCEDUREDETAILS_WHERE);

			boolean bindPatientId = false;

			if (patientId.isEmpty()) {
				sb.append(_FINDER_COLUMN_PATIENTID_PATIENTID_3);
			}
			else {
				bindPatientId = true;

				sb.append(_FINDER_COLUMN_PATIENTID_PATIENTID_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(TraineeLoggedProcedureDetailsModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindPatientId) {
					queryPos.add(patientId);
				}

				list = (List<TraineeLoggedProcedureDetails>)QueryUtil.list(
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
	 * Returns the first trainee logged procedure details in the ordered set where patientId = &#63;.
	 *
	 * @param patientId the patient ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching trainee logged procedure details
	 * @throws NoSuchTraineeLoggedProcedureDetailsException if a matching trainee logged procedure details could not be found
	 */
	@Override
	public TraineeLoggedProcedureDetails findByPatientId_First(
			String patientId,
			OrderByComparator<TraineeLoggedProcedureDetails> orderByComparator)
		throws NoSuchTraineeLoggedProcedureDetailsException {

		TraineeLoggedProcedureDetails traineeLoggedProcedureDetails =
			fetchByPatientId_First(patientId, orderByComparator);

		if (traineeLoggedProcedureDetails != null) {
			return traineeLoggedProcedureDetails;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("patientId=");
		sb.append(patientId);

		sb.append("}");

		throw new NoSuchTraineeLoggedProcedureDetailsException(sb.toString());
	}

	/**
	 * Returns the first trainee logged procedure details in the ordered set where patientId = &#63;.
	 *
	 * @param patientId the patient ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching trainee logged procedure details, or <code>null</code> if a matching trainee logged procedure details could not be found
	 */
	@Override
	public TraineeLoggedProcedureDetails fetchByPatientId_First(
		String patientId,
		OrderByComparator<TraineeLoggedProcedureDetails> orderByComparator) {

		List<TraineeLoggedProcedureDetails> list = findByPatientId(
			patientId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last trainee logged procedure details in the ordered set where patientId = &#63;.
	 *
	 * @param patientId the patient ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching trainee logged procedure details
	 * @throws NoSuchTraineeLoggedProcedureDetailsException if a matching trainee logged procedure details could not be found
	 */
	@Override
	public TraineeLoggedProcedureDetails findByPatientId_Last(
			String patientId,
			OrderByComparator<TraineeLoggedProcedureDetails> orderByComparator)
		throws NoSuchTraineeLoggedProcedureDetailsException {

		TraineeLoggedProcedureDetails traineeLoggedProcedureDetails =
			fetchByPatientId_Last(patientId, orderByComparator);

		if (traineeLoggedProcedureDetails != null) {
			return traineeLoggedProcedureDetails;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("patientId=");
		sb.append(patientId);

		sb.append("}");

		throw new NoSuchTraineeLoggedProcedureDetailsException(sb.toString());
	}

	/**
	 * Returns the last trainee logged procedure details in the ordered set where patientId = &#63;.
	 *
	 * @param patientId the patient ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching trainee logged procedure details, or <code>null</code> if a matching trainee logged procedure details could not be found
	 */
	@Override
	public TraineeLoggedProcedureDetails fetchByPatientId_Last(
		String patientId,
		OrderByComparator<TraineeLoggedProcedureDetails> orderByComparator) {

		int count = countByPatientId(patientId);

		if (count == 0) {
			return null;
		}

		List<TraineeLoggedProcedureDetails> list = findByPatientId(
			patientId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the trainee logged procedure detailses before and after the current trainee logged procedure details in the ordered set where patientId = &#63;.
	 *
	 * @param traineeLoggedProcedureDetailsId the primary key of the current trainee logged procedure details
	 * @param patientId the patient ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next trainee logged procedure details
	 * @throws NoSuchTraineeLoggedProcedureDetailsException if a trainee logged procedure details with the primary key could not be found
	 */
	@Override
	public TraineeLoggedProcedureDetails[] findByPatientId_PrevAndNext(
			long traineeLoggedProcedureDetailsId, String patientId,
			OrderByComparator<TraineeLoggedProcedureDetails> orderByComparator)
		throws NoSuchTraineeLoggedProcedureDetailsException {

		patientId = Objects.toString(patientId, "");

		TraineeLoggedProcedureDetails traineeLoggedProcedureDetails =
			findByPrimaryKey(traineeLoggedProcedureDetailsId);

		Session session = null;

		try {
			session = openSession();

			TraineeLoggedProcedureDetails[] array =
				new TraineeLoggedProcedureDetailsImpl[3];

			array[0] = getByPatientId_PrevAndNext(
				session, traineeLoggedProcedureDetails, patientId,
				orderByComparator, true);

			array[1] = traineeLoggedProcedureDetails;

			array[2] = getByPatientId_PrevAndNext(
				session, traineeLoggedProcedureDetails, patientId,
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

	protected TraineeLoggedProcedureDetails getByPatientId_PrevAndNext(
		Session session,
		TraineeLoggedProcedureDetails traineeLoggedProcedureDetails,
		String patientId,
		OrderByComparator<TraineeLoggedProcedureDetails> orderByComparator,
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

		sb.append(_SQL_SELECT_TRAINEELOGGEDPROCEDUREDETAILS_WHERE);

		boolean bindPatientId = false;

		if (patientId.isEmpty()) {
			sb.append(_FINDER_COLUMN_PATIENTID_PATIENTID_3);
		}
		else {
			bindPatientId = true;

			sb.append(_FINDER_COLUMN_PATIENTID_PATIENTID_2);
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
			sb.append(TraineeLoggedProcedureDetailsModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		if (bindPatientId) {
			queryPos.add(patientId);
		}

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						traineeLoggedProcedureDetails)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<TraineeLoggedProcedureDetails> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the trainee logged procedure detailses where patientId = &#63; from the database.
	 *
	 * @param patientId the patient ID
	 */
	@Override
	public void removeByPatientId(String patientId) {
		for (TraineeLoggedProcedureDetails traineeLoggedProcedureDetails :
				findByPatientId(
					patientId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(traineeLoggedProcedureDetails);
		}
	}

	/**
	 * Returns the number of trainee logged procedure detailses where patientId = &#63;.
	 *
	 * @param patientId the patient ID
	 * @return the number of matching trainee logged procedure detailses
	 */
	@Override
	public int countByPatientId(String patientId) {
		patientId = Objects.toString(patientId, "");

		FinderPath finderPath = _finderPathCountByPatientId;

		Object[] finderArgs = new Object[] {patientId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_TRAINEELOGGEDPROCEDUREDETAILS_WHERE);

			boolean bindPatientId = false;

			if (patientId.isEmpty()) {
				sb.append(_FINDER_COLUMN_PATIENTID_PATIENTID_3);
			}
			else {
				bindPatientId = true;

				sb.append(_FINDER_COLUMN_PATIENTID_PATIENTID_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindPatientId) {
					queryPos.add(patientId);
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

	private static final String _FINDER_COLUMN_PATIENTID_PATIENTID_2 =
		"traineeLoggedProcedureDetails.patientId = ?";

	private static final String _FINDER_COLUMN_PATIENTID_PATIENTID_3 =
		"(traineeLoggedProcedureDetails.patientId IS NULL OR traineeLoggedProcedureDetails.patientId = '')";

	private FinderPath _finderPathWithPaginationFindByPatientIdByLike;
	private FinderPath _finderPathWithPaginationCountByPatientIdByLike;

	/**
	 * Returns all the trainee logged procedure detailses where patientId LIKE &#63;.
	 *
	 * @param patientId the patient ID
	 * @return the matching trainee logged procedure detailses
	 */
	@Override
	public List<TraineeLoggedProcedureDetails> findByPatientIdByLike(
		String patientId) {

		return findByPatientIdByLike(
			patientId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the trainee logged procedure detailses where patientId LIKE &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TraineeLoggedProcedureDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param patientId the patient ID
	 * @param start the lower bound of the range of trainee logged procedure detailses
	 * @param end the upper bound of the range of trainee logged procedure detailses (not inclusive)
	 * @return the range of matching trainee logged procedure detailses
	 */
	@Override
	public List<TraineeLoggedProcedureDetails> findByPatientIdByLike(
		String patientId, int start, int end) {

		return findByPatientIdByLike(patientId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the trainee logged procedure detailses where patientId LIKE &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TraineeLoggedProcedureDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param patientId the patient ID
	 * @param start the lower bound of the range of trainee logged procedure detailses
	 * @param end the upper bound of the range of trainee logged procedure detailses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching trainee logged procedure detailses
	 */
	@Override
	public List<TraineeLoggedProcedureDetails> findByPatientIdByLike(
		String patientId, int start, int end,
		OrderByComparator<TraineeLoggedProcedureDetails> orderByComparator) {

		return findByPatientIdByLike(
			patientId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the trainee logged procedure detailses where patientId LIKE &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TraineeLoggedProcedureDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param patientId the patient ID
	 * @param start the lower bound of the range of trainee logged procedure detailses
	 * @param end the upper bound of the range of trainee logged procedure detailses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching trainee logged procedure detailses
	 */
	@Override
	public List<TraineeLoggedProcedureDetails> findByPatientIdByLike(
		String patientId, int start, int end,
		OrderByComparator<TraineeLoggedProcedureDetails> orderByComparator,
		boolean useFinderCache) {

		patientId = Objects.toString(patientId, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		finderPath = _finderPathWithPaginationFindByPatientIdByLike;
		finderArgs = new Object[] {patientId, start, end, orderByComparator};

		List<TraineeLoggedProcedureDetails> list = null;

		if (useFinderCache) {
			list = (List<TraineeLoggedProcedureDetails>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (TraineeLoggedProcedureDetails
						traineeLoggedProcedureDetails : list) {

					if (!StringUtil.wildcardMatches(
							traineeLoggedProcedureDetails.getPatientId(),
							patientId, '_', '%', '\\', false)) {

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

			sb.append(_SQL_SELECT_TRAINEELOGGEDPROCEDUREDETAILS_WHERE);

			boolean bindPatientId = false;

			if (patientId.isEmpty()) {
				sb.append(_FINDER_COLUMN_PATIENTIDBYLIKE_PATIENTID_3);
			}
			else {
				bindPatientId = true;

				sb.append(_FINDER_COLUMN_PATIENTIDBYLIKE_PATIENTID_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(TraineeLoggedProcedureDetailsModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindPatientId) {
					queryPos.add(StringUtil.toLowerCase(patientId));
				}

				list = (List<TraineeLoggedProcedureDetails>)QueryUtil.list(
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
	 * Returns the first trainee logged procedure details in the ordered set where patientId LIKE &#63;.
	 *
	 * @param patientId the patient ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching trainee logged procedure details
	 * @throws NoSuchTraineeLoggedProcedureDetailsException if a matching trainee logged procedure details could not be found
	 */
	@Override
	public TraineeLoggedProcedureDetails findByPatientIdByLike_First(
			String patientId,
			OrderByComparator<TraineeLoggedProcedureDetails> orderByComparator)
		throws NoSuchTraineeLoggedProcedureDetailsException {

		TraineeLoggedProcedureDetails traineeLoggedProcedureDetails =
			fetchByPatientIdByLike_First(patientId, orderByComparator);

		if (traineeLoggedProcedureDetails != null) {
			return traineeLoggedProcedureDetails;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("patientIdLIKE");
		sb.append(patientId);

		sb.append("}");

		throw new NoSuchTraineeLoggedProcedureDetailsException(sb.toString());
	}

	/**
	 * Returns the first trainee logged procedure details in the ordered set where patientId LIKE &#63;.
	 *
	 * @param patientId the patient ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching trainee logged procedure details, or <code>null</code> if a matching trainee logged procedure details could not be found
	 */
	@Override
	public TraineeLoggedProcedureDetails fetchByPatientIdByLike_First(
		String patientId,
		OrderByComparator<TraineeLoggedProcedureDetails> orderByComparator) {

		List<TraineeLoggedProcedureDetails> list = findByPatientIdByLike(
			patientId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last trainee logged procedure details in the ordered set where patientId LIKE &#63;.
	 *
	 * @param patientId the patient ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching trainee logged procedure details
	 * @throws NoSuchTraineeLoggedProcedureDetailsException if a matching trainee logged procedure details could not be found
	 */
	@Override
	public TraineeLoggedProcedureDetails findByPatientIdByLike_Last(
			String patientId,
			OrderByComparator<TraineeLoggedProcedureDetails> orderByComparator)
		throws NoSuchTraineeLoggedProcedureDetailsException {

		TraineeLoggedProcedureDetails traineeLoggedProcedureDetails =
			fetchByPatientIdByLike_Last(patientId, orderByComparator);

		if (traineeLoggedProcedureDetails != null) {
			return traineeLoggedProcedureDetails;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("patientIdLIKE");
		sb.append(patientId);

		sb.append("}");

		throw new NoSuchTraineeLoggedProcedureDetailsException(sb.toString());
	}

	/**
	 * Returns the last trainee logged procedure details in the ordered set where patientId LIKE &#63;.
	 *
	 * @param patientId the patient ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching trainee logged procedure details, or <code>null</code> if a matching trainee logged procedure details could not be found
	 */
	@Override
	public TraineeLoggedProcedureDetails fetchByPatientIdByLike_Last(
		String patientId,
		OrderByComparator<TraineeLoggedProcedureDetails> orderByComparator) {

		int count = countByPatientIdByLike(patientId);

		if (count == 0) {
			return null;
		}

		List<TraineeLoggedProcedureDetails> list = findByPatientIdByLike(
			patientId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the trainee logged procedure detailses before and after the current trainee logged procedure details in the ordered set where patientId LIKE &#63;.
	 *
	 * @param traineeLoggedProcedureDetailsId the primary key of the current trainee logged procedure details
	 * @param patientId the patient ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next trainee logged procedure details
	 * @throws NoSuchTraineeLoggedProcedureDetailsException if a trainee logged procedure details with the primary key could not be found
	 */
	@Override
	public TraineeLoggedProcedureDetails[] findByPatientIdByLike_PrevAndNext(
			long traineeLoggedProcedureDetailsId, String patientId,
			OrderByComparator<TraineeLoggedProcedureDetails> orderByComparator)
		throws NoSuchTraineeLoggedProcedureDetailsException {

		patientId = Objects.toString(patientId, "");

		TraineeLoggedProcedureDetails traineeLoggedProcedureDetails =
			findByPrimaryKey(traineeLoggedProcedureDetailsId);

		Session session = null;

		try {
			session = openSession();

			TraineeLoggedProcedureDetails[] array =
				new TraineeLoggedProcedureDetailsImpl[3];

			array[0] = getByPatientIdByLike_PrevAndNext(
				session, traineeLoggedProcedureDetails, patientId,
				orderByComparator, true);

			array[1] = traineeLoggedProcedureDetails;

			array[2] = getByPatientIdByLike_PrevAndNext(
				session, traineeLoggedProcedureDetails, patientId,
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

	protected TraineeLoggedProcedureDetails getByPatientIdByLike_PrevAndNext(
		Session session,
		TraineeLoggedProcedureDetails traineeLoggedProcedureDetails,
		String patientId,
		OrderByComparator<TraineeLoggedProcedureDetails> orderByComparator,
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

		sb.append(_SQL_SELECT_TRAINEELOGGEDPROCEDUREDETAILS_WHERE);

		boolean bindPatientId = false;

		if (patientId.isEmpty()) {
			sb.append(_FINDER_COLUMN_PATIENTIDBYLIKE_PATIENTID_3);
		}
		else {
			bindPatientId = true;

			sb.append(_FINDER_COLUMN_PATIENTIDBYLIKE_PATIENTID_2);
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
			sb.append(TraineeLoggedProcedureDetailsModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		if (bindPatientId) {
			queryPos.add(StringUtil.toLowerCase(patientId));
		}

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						traineeLoggedProcedureDetails)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<TraineeLoggedProcedureDetails> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the trainee logged procedure detailses where patientId LIKE &#63; from the database.
	 *
	 * @param patientId the patient ID
	 */
	@Override
	public void removeByPatientIdByLike(String patientId) {
		for (TraineeLoggedProcedureDetails traineeLoggedProcedureDetails :
				findByPatientIdByLike(
					patientId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(traineeLoggedProcedureDetails);
		}
	}

	/**
	 * Returns the number of trainee logged procedure detailses where patientId LIKE &#63;.
	 *
	 * @param patientId the patient ID
	 * @return the number of matching trainee logged procedure detailses
	 */
	@Override
	public int countByPatientIdByLike(String patientId) {
		patientId = Objects.toString(patientId, "");

		FinderPath finderPath = _finderPathWithPaginationCountByPatientIdByLike;

		Object[] finderArgs = new Object[] {patientId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_TRAINEELOGGEDPROCEDUREDETAILS_WHERE);

			boolean bindPatientId = false;

			if (patientId.isEmpty()) {
				sb.append(_FINDER_COLUMN_PATIENTIDBYLIKE_PATIENTID_3);
			}
			else {
				bindPatientId = true;

				sb.append(_FINDER_COLUMN_PATIENTIDBYLIKE_PATIENTID_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindPatientId) {
					queryPos.add(StringUtil.toLowerCase(patientId));
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

	private static final String _FINDER_COLUMN_PATIENTIDBYLIKE_PATIENTID_2 =
		"lower(traineeLoggedProcedureDetails.patientId) LIKE ?";

	private static final String _FINDER_COLUMN_PATIENTIDBYLIKE_PATIENTID_3 =
		"(traineeLoggedProcedureDetails.patientId IS NULL OR traineeLoggedProcedureDetails.patientId LIKE '')";

	private FinderPath _finderPathWithPaginationFindByTraineeId;
	private FinderPath _finderPathWithoutPaginationFindByTraineeId;
	private FinderPath _finderPathCountByTraineeId;

	/**
	 * Returns all the trainee logged procedure detailses where traineeId = &#63;.
	 *
	 * @param traineeId the trainee ID
	 * @return the matching trainee logged procedure detailses
	 */
	@Override
	public List<TraineeLoggedProcedureDetails> findByTraineeId(long traineeId) {
		return findByTraineeId(
			traineeId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the trainee logged procedure detailses where traineeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TraineeLoggedProcedureDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param traineeId the trainee ID
	 * @param start the lower bound of the range of trainee logged procedure detailses
	 * @param end the upper bound of the range of trainee logged procedure detailses (not inclusive)
	 * @return the range of matching trainee logged procedure detailses
	 */
	@Override
	public List<TraineeLoggedProcedureDetails> findByTraineeId(
		long traineeId, int start, int end) {

		return findByTraineeId(traineeId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the trainee logged procedure detailses where traineeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TraineeLoggedProcedureDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param traineeId the trainee ID
	 * @param start the lower bound of the range of trainee logged procedure detailses
	 * @param end the upper bound of the range of trainee logged procedure detailses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching trainee logged procedure detailses
	 */
	@Override
	public List<TraineeLoggedProcedureDetails> findByTraineeId(
		long traineeId, int start, int end,
		OrderByComparator<TraineeLoggedProcedureDetails> orderByComparator) {

		return findByTraineeId(traineeId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the trainee logged procedure detailses where traineeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TraineeLoggedProcedureDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param traineeId the trainee ID
	 * @param start the lower bound of the range of trainee logged procedure detailses
	 * @param end the upper bound of the range of trainee logged procedure detailses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching trainee logged procedure detailses
	 */
	@Override
	public List<TraineeLoggedProcedureDetails> findByTraineeId(
		long traineeId, int start, int end,
		OrderByComparator<TraineeLoggedProcedureDetails> orderByComparator,
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

		List<TraineeLoggedProcedureDetails> list = null;

		if (useFinderCache) {
			list = (List<TraineeLoggedProcedureDetails>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (TraineeLoggedProcedureDetails
						traineeLoggedProcedureDetails : list) {

					if (traineeId !=
							traineeLoggedProcedureDetails.getTraineeId()) {

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

			sb.append(_SQL_SELECT_TRAINEELOGGEDPROCEDUREDETAILS_WHERE);

			sb.append(_FINDER_COLUMN_TRAINEEID_TRAINEEID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(TraineeLoggedProcedureDetailsModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(traineeId);

				list = (List<TraineeLoggedProcedureDetails>)QueryUtil.list(
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
	 * Returns the first trainee logged procedure details in the ordered set where traineeId = &#63;.
	 *
	 * @param traineeId the trainee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching trainee logged procedure details
	 * @throws NoSuchTraineeLoggedProcedureDetailsException if a matching trainee logged procedure details could not be found
	 */
	@Override
	public TraineeLoggedProcedureDetails findByTraineeId_First(
			long traineeId,
			OrderByComparator<TraineeLoggedProcedureDetails> orderByComparator)
		throws NoSuchTraineeLoggedProcedureDetailsException {

		TraineeLoggedProcedureDetails traineeLoggedProcedureDetails =
			fetchByTraineeId_First(traineeId, orderByComparator);

		if (traineeLoggedProcedureDetails != null) {
			return traineeLoggedProcedureDetails;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("traineeId=");
		sb.append(traineeId);

		sb.append("}");

		throw new NoSuchTraineeLoggedProcedureDetailsException(sb.toString());
	}

	/**
	 * Returns the first trainee logged procedure details in the ordered set where traineeId = &#63;.
	 *
	 * @param traineeId the trainee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching trainee logged procedure details, or <code>null</code> if a matching trainee logged procedure details could not be found
	 */
	@Override
	public TraineeLoggedProcedureDetails fetchByTraineeId_First(
		long traineeId,
		OrderByComparator<TraineeLoggedProcedureDetails> orderByComparator) {

		List<TraineeLoggedProcedureDetails> list = findByTraineeId(
			traineeId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last trainee logged procedure details in the ordered set where traineeId = &#63;.
	 *
	 * @param traineeId the trainee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching trainee logged procedure details
	 * @throws NoSuchTraineeLoggedProcedureDetailsException if a matching trainee logged procedure details could not be found
	 */
	@Override
	public TraineeLoggedProcedureDetails findByTraineeId_Last(
			long traineeId,
			OrderByComparator<TraineeLoggedProcedureDetails> orderByComparator)
		throws NoSuchTraineeLoggedProcedureDetailsException {

		TraineeLoggedProcedureDetails traineeLoggedProcedureDetails =
			fetchByTraineeId_Last(traineeId, orderByComparator);

		if (traineeLoggedProcedureDetails != null) {
			return traineeLoggedProcedureDetails;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("traineeId=");
		sb.append(traineeId);

		sb.append("}");

		throw new NoSuchTraineeLoggedProcedureDetailsException(sb.toString());
	}

	/**
	 * Returns the last trainee logged procedure details in the ordered set where traineeId = &#63;.
	 *
	 * @param traineeId the trainee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching trainee logged procedure details, or <code>null</code> if a matching trainee logged procedure details could not be found
	 */
	@Override
	public TraineeLoggedProcedureDetails fetchByTraineeId_Last(
		long traineeId,
		OrderByComparator<TraineeLoggedProcedureDetails> orderByComparator) {

		int count = countByTraineeId(traineeId);

		if (count == 0) {
			return null;
		}

		List<TraineeLoggedProcedureDetails> list = findByTraineeId(
			traineeId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the trainee logged procedure detailses before and after the current trainee logged procedure details in the ordered set where traineeId = &#63;.
	 *
	 * @param traineeLoggedProcedureDetailsId the primary key of the current trainee logged procedure details
	 * @param traineeId the trainee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next trainee logged procedure details
	 * @throws NoSuchTraineeLoggedProcedureDetailsException if a trainee logged procedure details with the primary key could not be found
	 */
	@Override
	public TraineeLoggedProcedureDetails[] findByTraineeId_PrevAndNext(
			long traineeLoggedProcedureDetailsId, long traineeId,
			OrderByComparator<TraineeLoggedProcedureDetails> orderByComparator)
		throws NoSuchTraineeLoggedProcedureDetailsException {

		TraineeLoggedProcedureDetails traineeLoggedProcedureDetails =
			findByPrimaryKey(traineeLoggedProcedureDetailsId);

		Session session = null;

		try {
			session = openSession();

			TraineeLoggedProcedureDetails[] array =
				new TraineeLoggedProcedureDetailsImpl[3];

			array[0] = getByTraineeId_PrevAndNext(
				session, traineeLoggedProcedureDetails, traineeId,
				orderByComparator, true);

			array[1] = traineeLoggedProcedureDetails;

			array[2] = getByTraineeId_PrevAndNext(
				session, traineeLoggedProcedureDetails, traineeId,
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

	protected TraineeLoggedProcedureDetails getByTraineeId_PrevAndNext(
		Session session,
		TraineeLoggedProcedureDetails traineeLoggedProcedureDetails,
		long traineeId,
		OrderByComparator<TraineeLoggedProcedureDetails> orderByComparator,
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

		sb.append(_SQL_SELECT_TRAINEELOGGEDPROCEDUREDETAILS_WHERE);

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
			sb.append(TraineeLoggedProcedureDetailsModelImpl.ORDER_BY_JPQL);
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
						traineeLoggedProcedureDetails)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<TraineeLoggedProcedureDetails> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the trainee logged procedure detailses where traineeId = &#63; from the database.
	 *
	 * @param traineeId the trainee ID
	 */
	@Override
	public void removeByTraineeId(long traineeId) {
		for (TraineeLoggedProcedureDetails traineeLoggedProcedureDetails :
				findByTraineeId(
					traineeId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(traineeLoggedProcedureDetails);
		}
	}

	/**
	 * Returns the number of trainee logged procedure detailses where traineeId = &#63;.
	 *
	 * @param traineeId the trainee ID
	 * @return the number of matching trainee logged procedure detailses
	 */
	@Override
	public int countByTraineeId(long traineeId) {
		FinderPath finderPath = _finderPathCountByTraineeId;

		Object[] finderArgs = new Object[] {traineeId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_TRAINEELOGGEDPROCEDUREDETAILS_WHERE);

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
		"traineeLoggedProcedureDetails.traineeId = ?";

	public TraineeLoggedProcedureDetailsPersistenceImpl() {
		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("uuid", "uuid_");
		dbColumnNames.put(
			"traineeLoggedProcedureDetailsId",
			"trainee_logged_procedure_details_id");
		dbColumnNames.put("groupId", "group_id");
		dbColumnNames.put("companyId", "company_id");
		dbColumnNames.put("createDate", "create_date");
		dbColumnNames.put("createdBy", "created_by");
		dbColumnNames.put("modifiedDate", "modified_date");
		dbColumnNames.put("modifiedBy", "modified_by");
		dbColumnNames.put("programDurationId", "program_duration_id");
		dbColumnNames.put("rotationId", "rotation_id");
		dbColumnNames.put("traineeLevelId", "trainee_level_id");
		dbColumnNames.put("procedureGroupId", "procedure_group_id");
		dbColumnNames.put("procedureId", "procedure_id");
		dbColumnNames.put("genderId", "gender_id");
		dbColumnNames.put("patientTypeId", "patient_type_id");
		dbColumnNames.put("visitTypeId", "visit_type_id");
		dbColumnNames.put("cptCode", "cpt_code");
		dbColumnNames.put("trainingSitesId", "training_sites_id");
		dbColumnNames.put("roleTypeId", "role_type_id");
		dbColumnNames.put("facultyId", "faculty_id");
		dbColumnNames.put("traineeId", "trainee_id");
		dbColumnNames.put("patientId", "patient_id");
		dbColumnNames.put("patientDOB", "patient_dob");
		dbColumnNames.put("procedurePerformedDate", "procedure_performed_date");
		dbColumnNames.put("diagnosisDescription", "diagnosis_description");
		dbColumnNames.put("traineeComments", "trainee_comments");
		dbColumnNames.put("supervisorComments", "supervisor_comments");
		dbColumnNames.put("procedureStatus", "procedure_status");

		setDBColumnNames(dbColumnNames);

		setModelClass(TraineeLoggedProcedureDetails.class);

		setModelImplClass(TraineeLoggedProcedureDetailsImpl.class);
		setModelPKClass(long.class);

		setTable(TraineeLoggedProcedureDetailsTable.INSTANCE);
	}

	/**
	 * Caches the trainee logged procedure details in the entity cache if it is enabled.
	 *
	 * @param traineeLoggedProcedureDetails the trainee logged procedure details
	 */
	@Override
	public void cacheResult(
		TraineeLoggedProcedureDetails traineeLoggedProcedureDetails) {

		entityCache.putResult(
			TraineeLoggedProcedureDetailsImpl.class,
			traineeLoggedProcedureDetails.getPrimaryKey(),
			traineeLoggedProcedureDetails);

		finderCache.putResult(
			_finderPathFetchByUUID_G,
			new Object[] {
				traineeLoggedProcedureDetails.getUuid(),
				traineeLoggedProcedureDetails.getGroupId()
			},
			traineeLoggedProcedureDetails);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the trainee logged procedure detailses in the entity cache if it is enabled.
	 *
	 * @param traineeLoggedProcedureDetailses the trainee logged procedure detailses
	 */
	@Override
	public void cacheResult(
		List<TraineeLoggedProcedureDetails> traineeLoggedProcedureDetailses) {

		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (traineeLoggedProcedureDetailses.size() >
				 _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (TraineeLoggedProcedureDetails traineeLoggedProcedureDetails :
				traineeLoggedProcedureDetailses) {

			if (entityCache.getResult(
					TraineeLoggedProcedureDetailsImpl.class,
					traineeLoggedProcedureDetails.getPrimaryKey()) == null) {

				cacheResult(traineeLoggedProcedureDetails);
			}
		}
	}

	/**
	 * Clears the cache for all trainee logged procedure detailses.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(TraineeLoggedProcedureDetailsImpl.class);

		finderCache.clearCache(TraineeLoggedProcedureDetailsImpl.class);
	}

	/**
	 * Clears the cache for the trainee logged procedure details.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(
		TraineeLoggedProcedureDetails traineeLoggedProcedureDetails) {

		entityCache.removeResult(
			TraineeLoggedProcedureDetailsImpl.class,
			traineeLoggedProcedureDetails);
	}

	@Override
	public void clearCache(
		List<TraineeLoggedProcedureDetails> traineeLoggedProcedureDetailses) {

		for (TraineeLoggedProcedureDetails traineeLoggedProcedureDetails :
				traineeLoggedProcedureDetailses) {

			entityCache.removeResult(
				TraineeLoggedProcedureDetailsImpl.class,
				traineeLoggedProcedureDetails);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(TraineeLoggedProcedureDetailsImpl.class);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(
				TraineeLoggedProcedureDetailsImpl.class, primaryKey);
		}
	}

	protected void cacheUniqueFindersCache(
		TraineeLoggedProcedureDetailsModelImpl
			traineeLoggedProcedureDetailsModelImpl) {

		Object[] args = new Object[] {
			traineeLoggedProcedureDetailsModelImpl.getUuid(),
			traineeLoggedProcedureDetailsModelImpl.getGroupId()
		};

		finderCache.putResult(_finderPathCountByUUID_G, args, Long.valueOf(1));
		finderCache.putResult(
			_finderPathFetchByUUID_G, args,
			traineeLoggedProcedureDetailsModelImpl);
	}

	/**
	 * Creates a new trainee logged procedure details with the primary key. Does not add the trainee logged procedure details to the database.
	 *
	 * @param traineeLoggedProcedureDetailsId the primary key for the new trainee logged procedure details
	 * @return the new trainee logged procedure details
	 */
	@Override
	public TraineeLoggedProcedureDetails create(
		long traineeLoggedProcedureDetailsId) {

		TraineeLoggedProcedureDetails traineeLoggedProcedureDetails =
			new TraineeLoggedProcedureDetailsImpl();

		traineeLoggedProcedureDetails.setNew(true);
		traineeLoggedProcedureDetails.setPrimaryKey(
			traineeLoggedProcedureDetailsId);

		String uuid = _portalUUID.generate();

		traineeLoggedProcedureDetails.setUuid(uuid);

		traineeLoggedProcedureDetails.setCompanyId(
			CompanyThreadLocal.getCompanyId());

		return traineeLoggedProcedureDetails;
	}

	/**
	 * Removes the trainee logged procedure details with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param traineeLoggedProcedureDetailsId the primary key of the trainee logged procedure details
	 * @return the trainee logged procedure details that was removed
	 * @throws NoSuchTraineeLoggedProcedureDetailsException if a trainee logged procedure details with the primary key could not be found
	 */
	@Override
	public TraineeLoggedProcedureDetails remove(
			long traineeLoggedProcedureDetailsId)
		throws NoSuchTraineeLoggedProcedureDetailsException {

		return remove((Serializable)traineeLoggedProcedureDetailsId);
	}

	/**
	 * Removes the trainee logged procedure details with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the trainee logged procedure details
	 * @return the trainee logged procedure details that was removed
	 * @throws NoSuchTraineeLoggedProcedureDetailsException if a trainee logged procedure details with the primary key could not be found
	 */
	@Override
	public TraineeLoggedProcedureDetails remove(Serializable primaryKey)
		throws NoSuchTraineeLoggedProcedureDetailsException {

		Session session = null;

		try {
			session = openSession();

			TraineeLoggedProcedureDetails traineeLoggedProcedureDetails =
				(TraineeLoggedProcedureDetails)session.get(
					TraineeLoggedProcedureDetailsImpl.class, primaryKey);

			if (traineeLoggedProcedureDetails == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchTraineeLoggedProcedureDetailsException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(traineeLoggedProcedureDetails);
		}
		catch (NoSuchTraineeLoggedProcedureDetailsException
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
	protected TraineeLoggedProcedureDetails removeImpl(
		TraineeLoggedProcedureDetails traineeLoggedProcedureDetails) {

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(traineeLoggedProcedureDetails)) {
				traineeLoggedProcedureDetails =
					(TraineeLoggedProcedureDetails)session.get(
						TraineeLoggedProcedureDetailsImpl.class,
						traineeLoggedProcedureDetails.getPrimaryKeyObj());
			}

			if (traineeLoggedProcedureDetails != null) {
				session.delete(traineeLoggedProcedureDetails);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (traineeLoggedProcedureDetails != null) {
			clearCache(traineeLoggedProcedureDetails);
		}

		return traineeLoggedProcedureDetails;
	}

	@Override
	public TraineeLoggedProcedureDetails updateImpl(
		TraineeLoggedProcedureDetails traineeLoggedProcedureDetails) {

		boolean isNew = traineeLoggedProcedureDetails.isNew();

		if (!(traineeLoggedProcedureDetails instanceof
				TraineeLoggedProcedureDetailsModelImpl)) {

			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(
					traineeLoggedProcedureDetails.getClass())) {

				invocationHandler = ProxyUtil.getInvocationHandler(
					traineeLoggedProcedureDetails);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in traineeLoggedProcedureDetails proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom TraineeLoggedProcedureDetails implementation " +
					traineeLoggedProcedureDetails.getClass());
		}

		TraineeLoggedProcedureDetailsModelImpl
			traineeLoggedProcedureDetailsModelImpl =
				(TraineeLoggedProcedureDetailsModelImpl)
					traineeLoggedProcedureDetails;

		if (Validator.isNull(traineeLoggedProcedureDetails.getUuid())) {
			String uuid = _portalUUID.generate();

			traineeLoggedProcedureDetails.setUuid(uuid);
		}

		ServiceContext serviceContext =
			ServiceContextThreadLocal.getServiceContext();

		Date date = new Date();

		if (isNew && (traineeLoggedProcedureDetails.getCreateDate() == null)) {
			if (serviceContext == null) {
				traineeLoggedProcedureDetails.setCreateDate(date);
			}
			else {
				traineeLoggedProcedureDetails.setCreateDate(
					serviceContext.getCreateDate(date));
			}
		}

		if (!traineeLoggedProcedureDetailsModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				traineeLoggedProcedureDetails.setModifiedDate(date);
			}
			else {
				traineeLoggedProcedureDetails.setModifiedDate(
					serviceContext.getModifiedDate(date));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(traineeLoggedProcedureDetails);
			}
			else {
				traineeLoggedProcedureDetails =
					(TraineeLoggedProcedureDetails)session.merge(
						traineeLoggedProcedureDetails);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(
			TraineeLoggedProcedureDetailsImpl.class,
			traineeLoggedProcedureDetailsModelImpl, false, true);

		cacheUniqueFindersCache(traineeLoggedProcedureDetailsModelImpl);

		if (isNew) {
			traineeLoggedProcedureDetails.setNew(false);
		}

		traineeLoggedProcedureDetails.resetOriginalValues();

		return traineeLoggedProcedureDetails;
	}

	/**
	 * Returns the trainee logged procedure details with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the trainee logged procedure details
	 * @return the trainee logged procedure details
	 * @throws NoSuchTraineeLoggedProcedureDetailsException if a trainee logged procedure details with the primary key could not be found
	 */
	@Override
	public TraineeLoggedProcedureDetails findByPrimaryKey(
			Serializable primaryKey)
		throws NoSuchTraineeLoggedProcedureDetailsException {

		TraineeLoggedProcedureDetails traineeLoggedProcedureDetails =
			fetchByPrimaryKey(primaryKey);

		if (traineeLoggedProcedureDetails == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchTraineeLoggedProcedureDetailsException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return traineeLoggedProcedureDetails;
	}

	/**
	 * Returns the trainee logged procedure details with the primary key or throws a <code>NoSuchTraineeLoggedProcedureDetailsException</code> if it could not be found.
	 *
	 * @param traineeLoggedProcedureDetailsId the primary key of the trainee logged procedure details
	 * @return the trainee logged procedure details
	 * @throws NoSuchTraineeLoggedProcedureDetailsException if a trainee logged procedure details with the primary key could not be found
	 */
	@Override
	public TraineeLoggedProcedureDetails findByPrimaryKey(
			long traineeLoggedProcedureDetailsId)
		throws NoSuchTraineeLoggedProcedureDetailsException {

		return findByPrimaryKey((Serializable)traineeLoggedProcedureDetailsId);
	}

	/**
	 * Returns the trainee logged procedure details with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param traineeLoggedProcedureDetailsId the primary key of the trainee logged procedure details
	 * @return the trainee logged procedure details, or <code>null</code> if a trainee logged procedure details with the primary key could not be found
	 */
	@Override
	public TraineeLoggedProcedureDetails fetchByPrimaryKey(
		long traineeLoggedProcedureDetailsId) {

		return fetchByPrimaryKey((Serializable)traineeLoggedProcedureDetailsId);
	}

	/**
	 * Returns all the trainee logged procedure detailses.
	 *
	 * @return the trainee logged procedure detailses
	 */
	@Override
	public List<TraineeLoggedProcedureDetails> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the trainee logged procedure detailses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TraineeLoggedProcedureDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of trainee logged procedure detailses
	 * @param end the upper bound of the range of trainee logged procedure detailses (not inclusive)
	 * @return the range of trainee logged procedure detailses
	 */
	@Override
	public List<TraineeLoggedProcedureDetails> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the trainee logged procedure detailses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TraineeLoggedProcedureDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of trainee logged procedure detailses
	 * @param end the upper bound of the range of trainee logged procedure detailses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of trainee logged procedure detailses
	 */
	@Override
	public List<TraineeLoggedProcedureDetails> findAll(
		int start, int end,
		OrderByComparator<TraineeLoggedProcedureDetails> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the trainee logged procedure detailses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TraineeLoggedProcedureDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of trainee logged procedure detailses
	 * @param end the upper bound of the range of trainee logged procedure detailses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of trainee logged procedure detailses
	 */
	@Override
	public List<TraineeLoggedProcedureDetails> findAll(
		int start, int end,
		OrderByComparator<TraineeLoggedProcedureDetails> orderByComparator,
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

		List<TraineeLoggedProcedureDetails> list = null;

		if (useFinderCache) {
			list = (List<TraineeLoggedProcedureDetails>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_TRAINEELOGGEDPROCEDUREDETAILS);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_TRAINEELOGGEDPROCEDUREDETAILS;

				sql = sql.concat(
					TraineeLoggedProcedureDetailsModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<TraineeLoggedProcedureDetails>)QueryUtil.list(
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
	 * Removes all the trainee logged procedure detailses from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (TraineeLoggedProcedureDetails traineeLoggedProcedureDetails :
				findAll()) {

			remove(traineeLoggedProcedureDetails);
		}
	}

	/**
	 * Returns the number of trainee logged procedure detailses.
	 *
	 * @return the number of trainee logged procedure detailses
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
					_SQL_COUNT_TRAINEELOGGEDPROCEDUREDETAILS);

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
		return "trainee_logged_procedure_details_id";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_TRAINEELOGGEDPROCEDUREDETAILS;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return TraineeLoggedProcedureDetailsModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the trainee logged procedure details persistence.
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

		_finderPathWithPaginationFindByPatientId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByPatientId",
			new String[] {
				String.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"patient_id"}, true);

		_finderPathWithoutPaginationFindByPatientId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByPatientId",
			new String[] {String.class.getName()}, new String[] {"patient_id"},
			true);

		_finderPathCountByPatientId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByPatientId",
			new String[] {String.class.getName()}, new String[] {"patient_id"},
			false);

		_finderPathWithPaginationFindByPatientIdByLike = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByPatientIdByLike",
			new String[] {
				String.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"patient_id"}, true);

		_finderPathWithPaginationCountByPatientIdByLike = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "countByPatientIdByLike",
			new String[] {String.class.getName()}, new String[] {"patient_id"},
			false);

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

		_setTraineeLoggedProcedureDetailsUtilPersistence(this);
	}

	@Deactivate
	public void deactivate() {
		_setTraineeLoggedProcedureDetailsUtilPersistence(null);

		entityCache.removeCache(
			TraineeLoggedProcedureDetailsImpl.class.getName());
	}

	private void _setTraineeLoggedProcedureDetailsUtilPersistence(
		TraineeLoggedProcedureDetailsPersistence
			traineeLoggedProcedureDetailsPersistence) {

		try {
			Field field =
				TraineeLoggedProcedureDetailsUtil.class.getDeclaredField(
					"_persistence");

			field.setAccessible(true);

			field.set(null, traineeLoggedProcedureDetailsPersistence);
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

	private static final String _SQL_SELECT_TRAINEELOGGEDPROCEDUREDETAILS =
		"SELECT traineeLoggedProcedureDetails FROM TraineeLoggedProcedureDetails traineeLoggedProcedureDetails";

	private static final String
		_SQL_SELECT_TRAINEELOGGEDPROCEDUREDETAILS_WHERE =
			"SELECT traineeLoggedProcedureDetails FROM TraineeLoggedProcedureDetails traineeLoggedProcedureDetails WHERE ";

	private static final String _SQL_COUNT_TRAINEELOGGEDPROCEDUREDETAILS =
		"SELECT COUNT(traineeLoggedProcedureDetails) FROM TraineeLoggedProcedureDetails traineeLoggedProcedureDetails";

	private static final String _SQL_COUNT_TRAINEELOGGEDPROCEDUREDETAILS_WHERE =
		"SELECT COUNT(traineeLoggedProcedureDetails) FROM TraineeLoggedProcedureDetails traineeLoggedProcedureDetails WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS =
		"traineeLoggedProcedureDetails.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No TraineeLoggedProcedureDetails exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No TraineeLoggedProcedureDetails exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		TraineeLoggedProcedureDetailsPersistenceImpl.class);

	private static final Set<String> _badColumnNames = SetUtil.fromArray(
		new String[] {
			"uuid", "traineeLoggedProcedureDetailsId", "groupId", "companyId",
			"createDate", "createdBy", "modifiedDate", "modifiedBy",
			"programDurationId", "rotationId", "traineeLevelId",
			"procedureGroupId", "procedureId", "genderId", "patientTypeId",
			"visitTypeId", "cptCode", "trainingSitesId", "roleTypeId",
			"facultyId", "traineeId", "patientId", "patientDOB",
			"procedurePerformedDate", "diagnosisDescription", "traineeComments",
			"supervisorComments", "procedureStatus"
		});

	@Override
	protected FinderCache getFinderCache() {
		return finderCache;
	}

	@Reference
	private PortalUUID _portalUUID;

}
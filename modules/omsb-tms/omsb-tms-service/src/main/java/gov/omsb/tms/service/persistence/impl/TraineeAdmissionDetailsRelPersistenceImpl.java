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

import gov.omsb.tms.exception.NoSuchTraineeAdmissionDetailsRelException;
import gov.omsb.tms.model.TraineeAdmissionDetailsRel;
import gov.omsb.tms.model.TraineeAdmissionDetailsRelTable;
import gov.omsb.tms.model.impl.TraineeAdmissionDetailsRelImpl;
import gov.omsb.tms.model.impl.TraineeAdmissionDetailsRelModelImpl;
import gov.omsb.tms.service.persistence.TraineeAdmissionDetailsRelPersistence;
import gov.omsb.tms.service.persistence.TraineeAdmissionDetailsRelUtil;
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
 * The persistence implementation for the trainee admission details rel service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = TraineeAdmissionDetailsRelPersistence.class)
public class TraineeAdmissionDetailsRelPersistenceImpl
	extends BasePersistenceImpl<TraineeAdmissionDetailsRel>
	implements TraineeAdmissionDetailsRelPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>TraineeAdmissionDetailsRelUtil</code> to access the trainee admission details rel persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		TraineeAdmissionDetailsRelImpl.class.getName();

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
	 * Returns all the trainee admission details rels where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching trainee admission details rels
	 */
	@Override
	public List<TraineeAdmissionDetailsRel> findByUuid(String uuid) {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the trainee admission details rels where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TraineeAdmissionDetailsRelModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of trainee admission details rels
	 * @param end the upper bound of the range of trainee admission details rels (not inclusive)
	 * @return the range of matching trainee admission details rels
	 */
	@Override
	public List<TraineeAdmissionDetailsRel> findByUuid(
		String uuid, int start, int end) {

		return findByUuid(uuid, start, end, null);
	}

	/**
	 * Returns an ordered range of all the trainee admission details rels where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TraineeAdmissionDetailsRelModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of trainee admission details rels
	 * @param end the upper bound of the range of trainee admission details rels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching trainee admission details rels
	 */
	@Override
	public List<TraineeAdmissionDetailsRel> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<TraineeAdmissionDetailsRel> orderByComparator) {

		return findByUuid(uuid, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the trainee admission details rels where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TraineeAdmissionDetailsRelModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of trainee admission details rels
	 * @param end the upper bound of the range of trainee admission details rels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching trainee admission details rels
	 */
	@Override
	public List<TraineeAdmissionDetailsRel> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<TraineeAdmissionDetailsRel> orderByComparator,
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

		List<TraineeAdmissionDetailsRel> list = null;

		if (useFinderCache) {
			list = (List<TraineeAdmissionDetailsRel>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (TraineeAdmissionDetailsRel traineeAdmissionDetailsRel :
						list) {

					if (!uuid.equals(traineeAdmissionDetailsRel.getUuid())) {
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

			sb.append(_SQL_SELECT_TRAINEEADMISSIONDETAILSREL_WHERE);

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
				sb.append(TraineeAdmissionDetailsRelModelImpl.ORDER_BY_JPQL);
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

				list = (List<TraineeAdmissionDetailsRel>)QueryUtil.list(
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
	 * Returns the first trainee admission details rel in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching trainee admission details rel
	 * @throws NoSuchTraineeAdmissionDetailsRelException if a matching trainee admission details rel could not be found
	 */
	@Override
	public TraineeAdmissionDetailsRel findByUuid_First(
			String uuid,
			OrderByComparator<TraineeAdmissionDetailsRel> orderByComparator)
		throws NoSuchTraineeAdmissionDetailsRelException {

		TraineeAdmissionDetailsRel traineeAdmissionDetailsRel =
			fetchByUuid_First(uuid, orderByComparator);

		if (traineeAdmissionDetailsRel != null) {
			return traineeAdmissionDetailsRel;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchTraineeAdmissionDetailsRelException(sb.toString());
	}

	/**
	 * Returns the first trainee admission details rel in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching trainee admission details rel, or <code>null</code> if a matching trainee admission details rel could not be found
	 */
	@Override
	public TraineeAdmissionDetailsRel fetchByUuid_First(
		String uuid,
		OrderByComparator<TraineeAdmissionDetailsRel> orderByComparator) {

		List<TraineeAdmissionDetailsRel> list = findByUuid(
			uuid, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last trainee admission details rel in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching trainee admission details rel
	 * @throws NoSuchTraineeAdmissionDetailsRelException if a matching trainee admission details rel could not be found
	 */
	@Override
	public TraineeAdmissionDetailsRel findByUuid_Last(
			String uuid,
			OrderByComparator<TraineeAdmissionDetailsRel> orderByComparator)
		throws NoSuchTraineeAdmissionDetailsRelException {

		TraineeAdmissionDetailsRel traineeAdmissionDetailsRel =
			fetchByUuid_Last(uuid, orderByComparator);

		if (traineeAdmissionDetailsRel != null) {
			return traineeAdmissionDetailsRel;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchTraineeAdmissionDetailsRelException(sb.toString());
	}

	/**
	 * Returns the last trainee admission details rel in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching trainee admission details rel, or <code>null</code> if a matching trainee admission details rel could not be found
	 */
	@Override
	public TraineeAdmissionDetailsRel fetchByUuid_Last(
		String uuid,
		OrderByComparator<TraineeAdmissionDetailsRel> orderByComparator) {

		int count = countByUuid(uuid);

		if (count == 0) {
			return null;
		}

		List<TraineeAdmissionDetailsRel> list = findByUuid(
			uuid, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the trainee admission details rels before and after the current trainee admission details rel in the ordered set where uuid = &#63;.
	 *
	 * @param traineeAdmissionDetailsRelId the primary key of the current trainee admission details rel
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next trainee admission details rel
	 * @throws NoSuchTraineeAdmissionDetailsRelException if a trainee admission details rel with the primary key could not be found
	 */
	@Override
	public TraineeAdmissionDetailsRel[] findByUuid_PrevAndNext(
			long traineeAdmissionDetailsRelId, String uuid,
			OrderByComparator<TraineeAdmissionDetailsRel> orderByComparator)
		throws NoSuchTraineeAdmissionDetailsRelException {

		uuid = Objects.toString(uuid, "");

		TraineeAdmissionDetailsRel traineeAdmissionDetailsRel =
			findByPrimaryKey(traineeAdmissionDetailsRelId);

		Session session = null;

		try {
			session = openSession();

			TraineeAdmissionDetailsRel[] array =
				new TraineeAdmissionDetailsRelImpl[3];

			array[0] = getByUuid_PrevAndNext(
				session, traineeAdmissionDetailsRel, uuid, orderByComparator,
				true);

			array[1] = traineeAdmissionDetailsRel;

			array[2] = getByUuid_PrevAndNext(
				session, traineeAdmissionDetailsRel, uuid, orderByComparator,
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

	protected TraineeAdmissionDetailsRel getByUuid_PrevAndNext(
		Session session, TraineeAdmissionDetailsRel traineeAdmissionDetailsRel,
		String uuid,
		OrderByComparator<TraineeAdmissionDetailsRel> orderByComparator,
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

		sb.append(_SQL_SELECT_TRAINEEADMISSIONDETAILSREL_WHERE);

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
			sb.append(TraineeAdmissionDetailsRelModelImpl.ORDER_BY_JPQL);
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
						traineeAdmissionDetailsRel)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<TraineeAdmissionDetailsRel> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the trainee admission details rels where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	@Override
	public void removeByUuid(String uuid) {
		for (TraineeAdmissionDetailsRel traineeAdmissionDetailsRel :
				findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(traineeAdmissionDetailsRel);
		}
	}

	/**
	 * Returns the number of trainee admission details rels where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching trainee admission details rels
	 */
	@Override
	public int countByUuid(String uuid) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid;

		Object[] finderArgs = new Object[] {uuid};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_TRAINEEADMISSIONDETAILSREL_WHERE);

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
		"traineeAdmissionDetailsRel.uuid = ?";

	private static final String _FINDER_COLUMN_UUID_UUID_3 =
		"(traineeAdmissionDetailsRel.uuid IS NULL OR traineeAdmissionDetailsRel.uuid = '')";

	private FinderPath _finderPathFetchByUUID_G;
	private FinderPath _finderPathCountByUUID_G;

	/**
	 * Returns the trainee admission details rel where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchTraineeAdmissionDetailsRelException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching trainee admission details rel
	 * @throws NoSuchTraineeAdmissionDetailsRelException if a matching trainee admission details rel could not be found
	 */
	@Override
	public TraineeAdmissionDetailsRel findByUUID_G(String uuid, long groupId)
		throws NoSuchTraineeAdmissionDetailsRelException {

		TraineeAdmissionDetailsRel traineeAdmissionDetailsRel = fetchByUUID_G(
			uuid, groupId);

		if (traineeAdmissionDetailsRel == null) {
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

			throw new NoSuchTraineeAdmissionDetailsRelException(sb.toString());
		}

		return traineeAdmissionDetailsRel;
	}

	/**
	 * Returns the trainee admission details rel where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching trainee admission details rel, or <code>null</code> if a matching trainee admission details rel could not be found
	 */
	@Override
	public TraineeAdmissionDetailsRel fetchByUUID_G(String uuid, long groupId) {
		return fetchByUUID_G(uuid, groupId, true);
	}

	/**
	 * Returns the trainee admission details rel where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching trainee admission details rel, or <code>null</code> if a matching trainee admission details rel could not be found
	 */
	@Override
	public TraineeAdmissionDetailsRel fetchByUUID_G(
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

		if (result instanceof TraineeAdmissionDetailsRel) {
			TraineeAdmissionDetailsRel traineeAdmissionDetailsRel =
				(TraineeAdmissionDetailsRel)result;

			if (!Objects.equals(uuid, traineeAdmissionDetailsRel.getUuid()) ||
				(groupId != traineeAdmissionDetailsRel.getGroupId())) {

				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_SQL_SELECT_TRAINEEADMISSIONDETAILSREL_WHERE);

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

				List<TraineeAdmissionDetailsRel> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchByUUID_G, finderArgs, list);
					}
				}
				else {
					TraineeAdmissionDetailsRel traineeAdmissionDetailsRel =
						list.get(0);

					result = traineeAdmissionDetailsRel;

					cacheResult(traineeAdmissionDetailsRel);
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
			return (TraineeAdmissionDetailsRel)result;
		}
	}

	/**
	 * Removes the trainee admission details rel where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the trainee admission details rel that was removed
	 */
	@Override
	public TraineeAdmissionDetailsRel removeByUUID_G(String uuid, long groupId)
		throws NoSuchTraineeAdmissionDetailsRelException {

		TraineeAdmissionDetailsRel traineeAdmissionDetailsRel = findByUUID_G(
			uuid, groupId);

		return remove(traineeAdmissionDetailsRel);
	}

	/**
	 * Returns the number of trainee admission details rels where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching trainee admission details rels
	 */
	@Override
	public int countByUUID_G(String uuid, long groupId) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUUID_G;

		Object[] finderArgs = new Object[] {uuid, groupId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_TRAINEEADMISSIONDETAILSREL_WHERE);

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
		"traineeAdmissionDetailsRel.uuid = ? AND ";

	private static final String _FINDER_COLUMN_UUID_G_UUID_3 =
		"(traineeAdmissionDetailsRel.uuid IS NULL OR traineeAdmissionDetailsRel.uuid = '') AND ";

	private static final String _FINDER_COLUMN_UUID_G_GROUPID_2 =
		"traineeAdmissionDetailsRel.groupId = ?";

	private FinderPath _finderPathWithPaginationFindByUuid_C;
	private FinderPath _finderPathWithoutPaginationFindByUuid_C;
	private FinderPath _finderPathCountByUuid_C;

	/**
	 * Returns all the trainee admission details rels where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching trainee admission details rels
	 */
	@Override
	public List<TraineeAdmissionDetailsRel> findByUuid_C(
		String uuid, long companyId) {

		return findByUuid_C(
			uuid, companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the trainee admission details rels where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TraineeAdmissionDetailsRelModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of trainee admission details rels
	 * @param end the upper bound of the range of trainee admission details rels (not inclusive)
	 * @return the range of matching trainee admission details rels
	 */
	@Override
	public List<TraineeAdmissionDetailsRel> findByUuid_C(
		String uuid, long companyId, int start, int end) {

		return findByUuid_C(uuid, companyId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the trainee admission details rels where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TraineeAdmissionDetailsRelModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of trainee admission details rels
	 * @param end the upper bound of the range of trainee admission details rels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching trainee admission details rels
	 */
	@Override
	public List<TraineeAdmissionDetailsRel> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<TraineeAdmissionDetailsRel> orderByComparator) {

		return findByUuid_C(
			uuid, companyId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the trainee admission details rels where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TraineeAdmissionDetailsRelModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of trainee admission details rels
	 * @param end the upper bound of the range of trainee admission details rels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching trainee admission details rels
	 */
	@Override
	public List<TraineeAdmissionDetailsRel> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<TraineeAdmissionDetailsRel> orderByComparator,
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

		List<TraineeAdmissionDetailsRel> list = null;

		if (useFinderCache) {
			list = (List<TraineeAdmissionDetailsRel>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (TraineeAdmissionDetailsRel traineeAdmissionDetailsRel :
						list) {

					if (!uuid.equals(traineeAdmissionDetailsRel.getUuid()) ||
						(companyId !=
							traineeAdmissionDetailsRel.getCompanyId())) {

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

			sb.append(_SQL_SELECT_TRAINEEADMISSIONDETAILSREL_WHERE);

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
				sb.append(TraineeAdmissionDetailsRelModelImpl.ORDER_BY_JPQL);
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

				list = (List<TraineeAdmissionDetailsRel>)QueryUtil.list(
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
	 * Returns the first trainee admission details rel in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching trainee admission details rel
	 * @throws NoSuchTraineeAdmissionDetailsRelException if a matching trainee admission details rel could not be found
	 */
	@Override
	public TraineeAdmissionDetailsRel findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<TraineeAdmissionDetailsRel> orderByComparator)
		throws NoSuchTraineeAdmissionDetailsRelException {

		TraineeAdmissionDetailsRel traineeAdmissionDetailsRel =
			fetchByUuid_C_First(uuid, companyId, orderByComparator);

		if (traineeAdmissionDetailsRel != null) {
			return traineeAdmissionDetailsRel;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append(", companyId=");
		sb.append(companyId);

		sb.append("}");

		throw new NoSuchTraineeAdmissionDetailsRelException(sb.toString());
	}

	/**
	 * Returns the first trainee admission details rel in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching trainee admission details rel, or <code>null</code> if a matching trainee admission details rel could not be found
	 */
	@Override
	public TraineeAdmissionDetailsRel fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<TraineeAdmissionDetailsRel> orderByComparator) {

		List<TraineeAdmissionDetailsRel> list = findByUuid_C(
			uuid, companyId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last trainee admission details rel in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching trainee admission details rel
	 * @throws NoSuchTraineeAdmissionDetailsRelException if a matching trainee admission details rel could not be found
	 */
	@Override
	public TraineeAdmissionDetailsRel findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<TraineeAdmissionDetailsRel> orderByComparator)
		throws NoSuchTraineeAdmissionDetailsRelException {

		TraineeAdmissionDetailsRel traineeAdmissionDetailsRel =
			fetchByUuid_C_Last(uuid, companyId, orderByComparator);

		if (traineeAdmissionDetailsRel != null) {
			return traineeAdmissionDetailsRel;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append(", companyId=");
		sb.append(companyId);

		sb.append("}");

		throw new NoSuchTraineeAdmissionDetailsRelException(sb.toString());
	}

	/**
	 * Returns the last trainee admission details rel in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching trainee admission details rel, or <code>null</code> if a matching trainee admission details rel could not be found
	 */
	@Override
	public TraineeAdmissionDetailsRel fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<TraineeAdmissionDetailsRel> orderByComparator) {

		int count = countByUuid_C(uuid, companyId);

		if (count == 0) {
			return null;
		}

		List<TraineeAdmissionDetailsRel> list = findByUuid_C(
			uuid, companyId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the trainee admission details rels before and after the current trainee admission details rel in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param traineeAdmissionDetailsRelId the primary key of the current trainee admission details rel
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next trainee admission details rel
	 * @throws NoSuchTraineeAdmissionDetailsRelException if a trainee admission details rel with the primary key could not be found
	 */
	@Override
	public TraineeAdmissionDetailsRel[] findByUuid_C_PrevAndNext(
			long traineeAdmissionDetailsRelId, String uuid, long companyId,
			OrderByComparator<TraineeAdmissionDetailsRel> orderByComparator)
		throws NoSuchTraineeAdmissionDetailsRelException {

		uuid = Objects.toString(uuid, "");

		TraineeAdmissionDetailsRel traineeAdmissionDetailsRel =
			findByPrimaryKey(traineeAdmissionDetailsRelId);

		Session session = null;

		try {
			session = openSession();

			TraineeAdmissionDetailsRel[] array =
				new TraineeAdmissionDetailsRelImpl[3];

			array[0] = getByUuid_C_PrevAndNext(
				session, traineeAdmissionDetailsRel, uuid, companyId,
				orderByComparator, true);

			array[1] = traineeAdmissionDetailsRel;

			array[2] = getByUuid_C_PrevAndNext(
				session, traineeAdmissionDetailsRel, uuid, companyId,
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

	protected TraineeAdmissionDetailsRel getByUuid_C_PrevAndNext(
		Session session, TraineeAdmissionDetailsRel traineeAdmissionDetailsRel,
		String uuid, long companyId,
		OrderByComparator<TraineeAdmissionDetailsRel> orderByComparator,
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

		sb.append(_SQL_SELECT_TRAINEEADMISSIONDETAILSREL_WHERE);

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
			sb.append(TraineeAdmissionDetailsRelModelImpl.ORDER_BY_JPQL);
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
						traineeAdmissionDetailsRel)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<TraineeAdmissionDetailsRel> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the trainee admission details rels where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	@Override
	public void removeByUuid_C(String uuid, long companyId) {
		for (TraineeAdmissionDetailsRel traineeAdmissionDetailsRel :
				findByUuid_C(
					uuid, companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(traineeAdmissionDetailsRel);
		}
	}

	/**
	 * Returns the number of trainee admission details rels where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching trainee admission details rels
	 */
	@Override
	public int countByUuid_C(String uuid, long companyId) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid_C;

		Object[] finderArgs = new Object[] {uuid, companyId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_TRAINEEADMISSIONDETAILSREL_WHERE);

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
		"traineeAdmissionDetailsRel.uuid = ? AND ";

	private static final String _FINDER_COLUMN_UUID_C_UUID_3 =
		"(traineeAdmissionDetailsRel.uuid IS NULL OR traineeAdmissionDetailsRel.uuid = '') AND ";

	private static final String _FINDER_COLUMN_UUID_C_COMPANYID_2 =
		"traineeAdmissionDetailsRel.companyId = ?";

	private FinderPath _finderPathWithPaginationFindByProgramDurationId;
	private FinderPath _finderPathWithoutPaginationFindByProgramDurationId;
	private FinderPath _finderPathCountByProgramDurationId;

	/**
	 * Returns all the trainee admission details rels where programDurationId = &#63;.
	 *
	 * @param programDurationId the program duration ID
	 * @return the matching trainee admission details rels
	 */
	@Override
	public List<TraineeAdmissionDetailsRel> findByProgramDurationId(
		long programDurationId) {

		return findByProgramDurationId(
			programDurationId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the trainee admission details rels where programDurationId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TraineeAdmissionDetailsRelModelImpl</code>.
	 * </p>
	 *
	 * @param programDurationId the program duration ID
	 * @param start the lower bound of the range of trainee admission details rels
	 * @param end the upper bound of the range of trainee admission details rels (not inclusive)
	 * @return the range of matching trainee admission details rels
	 */
	@Override
	public List<TraineeAdmissionDetailsRel> findByProgramDurationId(
		long programDurationId, int start, int end) {

		return findByProgramDurationId(programDurationId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the trainee admission details rels where programDurationId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TraineeAdmissionDetailsRelModelImpl</code>.
	 * </p>
	 *
	 * @param programDurationId the program duration ID
	 * @param start the lower bound of the range of trainee admission details rels
	 * @param end the upper bound of the range of trainee admission details rels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching trainee admission details rels
	 */
	@Override
	public List<TraineeAdmissionDetailsRel> findByProgramDurationId(
		long programDurationId, int start, int end,
		OrderByComparator<TraineeAdmissionDetailsRel> orderByComparator) {

		return findByProgramDurationId(
			programDurationId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the trainee admission details rels where programDurationId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TraineeAdmissionDetailsRelModelImpl</code>.
	 * </p>
	 *
	 * @param programDurationId the program duration ID
	 * @param start the lower bound of the range of trainee admission details rels
	 * @param end the upper bound of the range of trainee admission details rels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching trainee admission details rels
	 */
	@Override
	public List<TraineeAdmissionDetailsRel> findByProgramDurationId(
		long programDurationId, int start, int end,
		OrderByComparator<TraineeAdmissionDetailsRel> orderByComparator,
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

		List<TraineeAdmissionDetailsRel> list = null;

		if (useFinderCache) {
			list = (List<TraineeAdmissionDetailsRel>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (TraineeAdmissionDetailsRel traineeAdmissionDetailsRel :
						list) {

					if (programDurationId !=
							traineeAdmissionDetailsRel.getProgramDurationId()) {

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

			sb.append(_SQL_SELECT_TRAINEEADMISSIONDETAILSREL_WHERE);

			sb.append(_FINDER_COLUMN_PROGRAMDURATIONID_PROGRAMDURATIONID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(TraineeAdmissionDetailsRelModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(programDurationId);

				list = (List<TraineeAdmissionDetailsRel>)QueryUtil.list(
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
	 * Returns the first trainee admission details rel in the ordered set where programDurationId = &#63;.
	 *
	 * @param programDurationId the program duration ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching trainee admission details rel
	 * @throws NoSuchTraineeAdmissionDetailsRelException if a matching trainee admission details rel could not be found
	 */
	@Override
	public TraineeAdmissionDetailsRel findByProgramDurationId_First(
			long programDurationId,
			OrderByComparator<TraineeAdmissionDetailsRel> orderByComparator)
		throws NoSuchTraineeAdmissionDetailsRelException {

		TraineeAdmissionDetailsRel traineeAdmissionDetailsRel =
			fetchByProgramDurationId_First(
				programDurationId, orderByComparator);

		if (traineeAdmissionDetailsRel != null) {
			return traineeAdmissionDetailsRel;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("programDurationId=");
		sb.append(programDurationId);

		sb.append("}");

		throw new NoSuchTraineeAdmissionDetailsRelException(sb.toString());
	}

	/**
	 * Returns the first trainee admission details rel in the ordered set where programDurationId = &#63;.
	 *
	 * @param programDurationId the program duration ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching trainee admission details rel, or <code>null</code> if a matching trainee admission details rel could not be found
	 */
	@Override
	public TraineeAdmissionDetailsRel fetchByProgramDurationId_First(
		long programDurationId,
		OrderByComparator<TraineeAdmissionDetailsRel> orderByComparator) {

		List<TraineeAdmissionDetailsRel> list = findByProgramDurationId(
			programDurationId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last trainee admission details rel in the ordered set where programDurationId = &#63;.
	 *
	 * @param programDurationId the program duration ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching trainee admission details rel
	 * @throws NoSuchTraineeAdmissionDetailsRelException if a matching trainee admission details rel could not be found
	 */
	@Override
	public TraineeAdmissionDetailsRel findByProgramDurationId_Last(
			long programDurationId,
			OrderByComparator<TraineeAdmissionDetailsRel> orderByComparator)
		throws NoSuchTraineeAdmissionDetailsRelException {

		TraineeAdmissionDetailsRel traineeAdmissionDetailsRel =
			fetchByProgramDurationId_Last(programDurationId, orderByComparator);

		if (traineeAdmissionDetailsRel != null) {
			return traineeAdmissionDetailsRel;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("programDurationId=");
		sb.append(programDurationId);

		sb.append("}");

		throw new NoSuchTraineeAdmissionDetailsRelException(sb.toString());
	}

	/**
	 * Returns the last trainee admission details rel in the ordered set where programDurationId = &#63;.
	 *
	 * @param programDurationId the program duration ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching trainee admission details rel, or <code>null</code> if a matching trainee admission details rel could not be found
	 */
	@Override
	public TraineeAdmissionDetailsRel fetchByProgramDurationId_Last(
		long programDurationId,
		OrderByComparator<TraineeAdmissionDetailsRel> orderByComparator) {

		int count = countByProgramDurationId(programDurationId);

		if (count == 0) {
			return null;
		}

		List<TraineeAdmissionDetailsRel> list = findByProgramDurationId(
			programDurationId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the trainee admission details rels before and after the current trainee admission details rel in the ordered set where programDurationId = &#63;.
	 *
	 * @param traineeAdmissionDetailsRelId the primary key of the current trainee admission details rel
	 * @param programDurationId the program duration ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next trainee admission details rel
	 * @throws NoSuchTraineeAdmissionDetailsRelException if a trainee admission details rel with the primary key could not be found
	 */
	@Override
	public TraineeAdmissionDetailsRel[] findByProgramDurationId_PrevAndNext(
			long traineeAdmissionDetailsRelId, long programDurationId,
			OrderByComparator<TraineeAdmissionDetailsRel> orderByComparator)
		throws NoSuchTraineeAdmissionDetailsRelException {

		TraineeAdmissionDetailsRel traineeAdmissionDetailsRel =
			findByPrimaryKey(traineeAdmissionDetailsRelId);

		Session session = null;

		try {
			session = openSession();

			TraineeAdmissionDetailsRel[] array =
				new TraineeAdmissionDetailsRelImpl[3];

			array[0] = getByProgramDurationId_PrevAndNext(
				session, traineeAdmissionDetailsRel, programDurationId,
				orderByComparator, true);

			array[1] = traineeAdmissionDetailsRel;

			array[2] = getByProgramDurationId_PrevAndNext(
				session, traineeAdmissionDetailsRel, programDurationId,
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

	protected TraineeAdmissionDetailsRel getByProgramDurationId_PrevAndNext(
		Session session, TraineeAdmissionDetailsRel traineeAdmissionDetailsRel,
		long programDurationId,
		OrderByComparator<TraineeAdmissionDetailsRel> orderByComparator,
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

		sb.append(_SQL_SELECT_TRAINEEADMISSIONDETAILSREL_WHERE);

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
			sb.append(TraineeAdmissionDetailsRelModelImpl.ORDER_BY_JPQL);
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
						traineeAdmissionDetailsRel)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<TraineeAdmissionDetailsRel> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the trainee admission details rels where programDurationId = &#63; from the database.
	 *
	 * @param programDurationId the program duration ID
	 */
	@Override
	public void removeByProgramDurationId(long programDurationId) {
		for (TraineeAdmissionDetailsRel traineeAdmissionDetailsRel :
				findByProgramDurationId(
					programDurationId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(traineeAdmissionDetailsRel);
		}
	}

	/**
	 * Returns the number of trainee admission details rels where programDurationId = &#63;.
	 *
	 * @param programDurationId the program duration ID
	 * @return the number of matching trainee admission details rels
	 */
	@Override
	public int countByProgramDurationId(long programDurationId) {
		FinderPath finderPath = _finderPathCountByProgramDurationId;

		Object[] finderArgs = new Object[] {programDurationId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_TRAINEEADMISSIONDETAILSREL_WHERE);

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
			"traineeAdmissionDetailsRel.programDurationId = ?";

	private FinderPath _finderPathFetchByTraineeId;
	private FinderPath _finderPathCountByTraineeId;

	/**
	 * Returns the trainee admission details rel where traineeId = &#63; or throws a <code>NoSuchTraineeAdmissionDetailsRelException</code> if it could not be found.
	 *
	 * @param traineeId the trainee ID
	 * @return the matching trainee admission details rel
	 * @throws NoSuchTraineeAdmissionDetailsRelException if a matching trainee admission details rel could not be found
	 */
	@Override
	public TraineeAdmissionDetailsRel findByTraineeId(long traineeId)
		throws NoSuchTraineeAdmissionDetailsRelException {

		TraineeAdmissionDetailsRel traineeAdmissionDetailsRel =
			fetchByTraineeId(traineeId);

		if (traineeAdmissionDetailsRel == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_NO_SUCH_ENTITY_WITH_KEY);

			sb.append("traineeId=");
			sb.append(traineeId);

			sb.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(sb.toString());
			}

			throw new NoSuchTraineeAdmissionDetailsRelException(sb.toString());
		}

		return traineeAdmissionDetailsRel;
	}

	/**
	 * Returns the trainee admission details rel where traineeId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param traineeId the trainee ID
	 * @return the matching trainee admission details rel, or <code>null</code> if a matching trainee admission details rel could not be found
	 */
	@Override
	public TraineeAdmissionDetailsRel fetchByTraineeId(long traineeId) {
		return fetchByTraineeId(traineeId, true);
	}

	/**
	 * Returns the trainee admission details rel where traineeId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param traineeId the trainee ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching trainee admission details rel, or <code>null</code> if a matching trainee admission details rel could not be found
	 */
	@Override
	public TraineeAdmissionDetailsRel fetchByTraineeId(
		long traineeId, boolean useFinderCache) {

		Object[] finderArgs = null;

		if (useFinderCache) {
			finderArgs = new Object[] {traineeId};
		}

		Object result = null;

		if (useFinderCache) {
			result = finderCache.getResult(
				_finderPathFetchByTraineeId, finderArgs, this);
		}

		if (result instanceof TraineeAdmissionDetailsRel) {
			TraineeAdmissionDetailsRel traineeAdmissionDetailsRel =
				(TraineeAdmissionDetailsRel)result;

			if (traineeId != traineeAdmissionDetailsRel.getTraineeId()) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_SELECT_TRAINEEADMISSIONDETAILSREL_WHERE);

			sb.append(_FINDER_COLUMN_TRAINEEID_TRAINEEID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(traineeId);

				List<TraineeAdmissionDetailsRel> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchByTraineeId, finderArgs, list);
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
								"TraineeAdmissionDetailsRelPersistenceImpl.fetchByTraineeId(long, boolean) with parameters (" +
									StringUtil.merge(finderArgs) +
										") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
						}
					}

					TraineeAdmissionDetailsRel traineeAdmissionDetailsRel =
						list.get(0);

					result = traineeAdmissionDetailsRel;

					cacheResult(traineeAdmissionDetailsRel);
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
			return (TraineeAdmissionDetailsRel)result;
		}
	}

	/**
	 * Removes the trainee admission details rel where traineeId = &#63; from the database.
	 *
	 * @param traineeId the trainee ID
	 * @return the trainee admission details rel that was removed
	 */
	@Override
	public TraineeAdmissionDetailsRel removeByTraineeId(long traineeId)
		throws NoSuchTraineeAdmissionDetailsRelException {

		TraineeAdmissionDetailsRel traineeAdmissionDetailsRel = findByTraineeId(
			traineeId);

		return remove(traineeAdmissionDetailsRel);
	}

	/**
	 * Returns the number of trainee admission details rels where traineeId = &#63;.
	 *
	 * @param traineeId the trainee ID
	 * @return the number of matching trainee admission details rels
	 */
	@Override
	public int countByTraineeId(long traineeId) {
		FinderPath finderPath = _finderPathCountByTraineeId;

		Object[] finderArgs = new Object[] {traineeId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_TRAINEEADMISSIONDETAILSREL_WHERE);

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
		"traineeAdmissionDetailsRel.traineeId = ?";

	public TraineeAdmissionDetailsRelPersistenceImpl() {
		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("uuid", "uuid_");
		dbColumnNames.put(
			"traineeAdmissionDetailsRelId", "trainee_admission_details_rel_id");
		dbColumnNames.put("groupId", "group_id");
		dbColumnNames.put("companyId", "company_id");
		dbColumnNames.put("createDate", "create_date");
		dbColumnNames.put("modifiedDate", "modified_date");
		dbColumnNames.put("createdBy", "created_by");
		dbColumnNames.put("modifiedBy", "modified_by");
		dbColumnNames.put("traineeId", "trainee_id");
		dbColumnNames.put("programDurationId", "program_duration_id");
		dbColumnNames.put("admissionYear", "admission_year");
		dbColumnNames.put("omsbNumber", "omsb_number");
		dbColumnNames.put("traineeAddress", "trainee_address");

		setDBColumnNames(dbColumnNames);

		setModelClass(TraineeAdmissionDetailsRel.class);

		setModelImplClass(TraineeAdmissionDetailsRelImpl.class);
		setModelPKClass(long.class);

		setTable(TraineeAdmissionDetailsRelTable.INSTANCE);
	}

	/**
	 * Caches the trainee admission details rel in the entity cache if it is enabled.
	 *
	 * @param traineeAdmissionDetailsRel the trainee admission details rel
	 */
	@Override
	public void cacheResult(
		TraineeAdmissionDetailsRel traineeAdmissionDetailsRel) {

		entityCache.putResult(
			TraineeAdmissionDetailsRelImpl.class,
			traineeAdmissionDetailsRel.getPrimaryKey(),
			traineeAdmissionDetailsRel);

		finderCache.putResult(
			_finderPathFetchByUUID_G,
			new Object[] {
				traineeAdmissionDetailsRel.getUuid(),
				traineeAdmissionDetailsRel.getGroupId()
			},
			traineeAdmissionDetailsRel);

		finderCache.putResult(
			_finderPathFetchByTraineeId,
			new Object[] {traineeAdmissionDetailsRel.getTraineeId()},
			traineeAdmissionDetailsRel);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the trainee admission details rels in the entity cache if it is enabled.
	 *
	 * @param traineeAdmissionDetailsRels the trainee admission details rels
	 */
	@Override
	public void cacheResult(
		List<TraineeAdmissionDetailsRel> traineeAdmissionDetailsRels) {

		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (traineeAdmissionDetailsRels.size() >
				 _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (TraineeAdmissionDetailsRel traineeAdmissionDetailsRel :
				traineeAdmissionDetailsRels) {

			if (entityCache.getResult(
					TraineeAdmissionDetailsRelImpl.class,
					traineeAdmissionDetailsRel.getPrimaryKey()) == null) {

				cacheResult(traineeAdmissionDetailsRel);
			}
		}
	}

	/**
	 * Clears the cache for all trainee admission details rels.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(TraineeAdmissionDetailsRelImpl.class);

		finderCache.clearCache(TraineeAdmissionDetailsRelImpl.class);
	}

	/**
	 * Clears the cache for the trainee admission details rel.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(
		TraineeAdmissionDetailsRel traineeAdmissionDetailsRel) {

		entityCache.removeResult(
			TraineeAdmissionDetailsRelImpl.class, traineeAdmissionDetailsRel);
	}

	@Override
	public void clearCache(
		List<TraineeAdmissionDetailsRel> traineeAdmissionDetailsRels) {

		for (TraineeAdmissionDetailsRel traineeAdmissionDetailsRel :
				traineeAdmissionDetailsRels) {

			entityCache.removeResult(
				TraineeAdmissionDetailsRelImpl.class,
				traineeAdmissionDetailsRel);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(TraineeAdmissionDetailsRelImpl.class);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(
				TraineeAdmissionDetailsRelImpl.class, primaryKey);
		}
	}

	protected void cacheUniqueFindersCache(
		TraineeAdmissionDetailsRelModelImpl
			traineeAdmissionDetailsRelModelImpl) {

		Object[] args = new Object[] {
			traineeAdmissionDetailsRelModelImpl.getUuid(),
			traineeAdmissionDetailsRelModelImpl.getGroupId()
		};

		finderCache.putResult(_finderPathCountByUUID_G, args, Long.valueOf(1));
		finderCache.putResult(
			_finderPathFetchByUUID_G, args,
			traineeAdmissionDetailsRelModelImpl);

		args = new Object[] {
			traineeAdmissionDetailsRelModelImpl.getTraineeId()
		};

		finderCache.putResult(
			_finderPathCountByTraineeId, args, Long.valueOf(1));
		finderCache.putResult(
			_finderPathFetchByTraineeId, args,
			traineeAdmissionDetailsRelModelImpl);
	}

	/**
	 * Creates a new trainee admission details rel with the primary key. Does not add the trainee admission details rel to the database.
	 *
	 * @param traineeAdmissionDetailsRelId the primary key for the new trainee admission details rel
	 * @return the new trainee admission details rel
	 */
	@Override
	public TraineeAdmissionDetailsRel create(
		long traineeAdmissionDetailsRelId) {

		TraineeAdmissionDetailsRel traineeAdmissionDetailsRel =
			new TraineeAdmissionDetailsRelImpl();

		traineeAdmissionDetailsRel.setNew(true);
		traineeAdmissionDetailsRel.setPrimaryKey(traineeAdmissionDetailsRelId);

		String uuid = _portalUUID.generate();

		traineeAdmissionDetailsRel.setUuid(uuid);

		traineeAdmissionDetailsRel.setCompanyId(
			CompanyThreadLocal.getCompanyId());

		return traineeAdmissionDetailsRel;
	}

	/**
	 * Removes the trainee admission details rel with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param traineeAdmissionDetailsRelId the primary key of the trainee admission details rel
	 * @return the trainee admission details rel that was removed
	 * @throws NoSuchTraineeAdmissionDetailsRelException if a trainee admission details rel with the primary key could not be found
	 */
	@Override
	public TraineeAdmissionDetailsRel remove(long traineeAdmissionDetailsRelId)
		throws NoSuchTraineeAdmissionDetailsRelException {

		return remove((Serializable)traineeAdmissionDetailsRelId);
	}

	/**
	 * Removes the trainee admission details rel with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the trainee admission details rel
	 * @return the trainee admission details rel that was removed
	 * @throws NoSuchTraineeAdmissionDetailsRelException if a trainee admission details rel with the primary key could not be found
	 */
	@Override
	public TraineeAdmissionDetailsRel remove(Serializable primaryKey)
		throws NoSuchTraineeAdmissionDetailsRelException {

		Session session = null;

		try {
			session = openSession();

			TraineeAdmissionDetailsRel traineeAdmissionDetailsRel =
				(TraineeAdmissionDetailsRel)session.get(
					TraineeAdmissionDetailsRelImpl.class, primaryKey);

			if (traineeAdmissionDetailsRel == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchTraineeAdmissionDetailsRelException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(traineeAdmissionDetailsRel);
		}
		catch (NoSuchTraineeAdmissionDetailsRelException
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
	protected TraineeAdmissionDetailsRel removeImpl(
		TraineeAdmissionDetailsRel traineeAdmissionDetailsRel) {

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(traineeAdmissionDetailsRel)) {
				traineeAdmissionDetailsRel =
					(TraineeAdmissionDetailsRel)session.get(
						TraineeAdmissionDetailsRelImpl.class,
						traineeAdmissionDetailsRel.getPrimaryKeyObj());
			}

			if (traineeAdmissionDetailsRel != null) {
				session.delete(traineeAdmissionDetailsRel);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (traineeAdmissionDetailsRel != null) {
			clearCache(traineeAdmissionDetailsRel);
		}

		return traineeAdmissionDetailsRel;
	}

	@Override
	public TraineeAdmissionDetailsRel updateImpl(
		TraineeAdmissionDetailsRel traineeAdmissionDetailsRel) {

		boolean isNew = traineeAdmissionDetailsRel.isNew();

		if (!(traineeAdmissionDetailsRel instanceof
				TraineeAdmissionDetailsRelModelImpl)) {

			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(traineeAdmissionDetailsRel.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(
					traineeAdmissionDetailsRel);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in traineeAdmissionDetailsRel proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom TraineeAdmissionDetailsRel implementation " +
					traineeAdmissionDetailsRel.getClass());
		}

		TraineeAdmissionDetailsRelModelImpl
			traineeAdmissionDetailsRelModelImpl =
				(TraineeAdmissionDetailsRelModelImpl)traineeAdmissionDetailsRel;

		if (Validator.isNull(traineeAdmissionDetailsRel.getUuid())) {
			String uuid = _portalUUID.generate();

			traineeAdmissionDetailsRel.setUuid(uuid);
		}

		ServiceContext serviceContext =
			ServiceContextThreadLocal.getServiceContext();

		Date date = new Date();

		if (isNew && (traineeAdmissionDetailsRel.getCreateDate() == null)) {
			if (serviceContext == null) {
				traineeAdmissionDetailsRel.setCreateDate(date);
			}
			else {
				traineeAdmissionDetailsRel.setCreateDate(
					serviceContext.getCreateDate(date));
			}
		}

		if (!traineeAdmissionDetailsRelModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				traineeAdmissionDetailsRel.setModifiedDate(date);
			}
			else {
				traineeAdmissionDetailsRel.setModifiedDate(
					serviceContext.getModifiedDate(date));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(traineeAdmissionDetailsRel);
			}
			else {
				traineeAdmissionDetailsRel =
					(TraineeAdmissionDetailsRel)session.merge(
						traineeAdmissionDetailsRel);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(
			TraineeAdmissionDetailsRelImpl.class,
			traineeAdmissionDetailsRelModelImpl, false, true);

		cacheUniqueFindersCache(traineeAdmissionDetailsRelModelImpl);

		if (isNew) {
			traineeAdmissionDetailsRel.setNew(false);
		}

		traineeAdmissionDetailsRel.resetOriginalValues();

		return traineeAdmissionDetailsRel;
	}

	/**
	 * Returns the trainee admission details rel with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the trainee admission details rel
	 * @return the trainee admission details rel
	 * @throws NoSuchTraineeAdmissionDetailsRelException if a trainee admission details rel with the primary key could not be found
	 */
	@Override
	public TraineeAdmissionDetailsRel findByPrimaryKey(Serializable primaryKey)
		throws NoSuchTraineeAdmissionDetailsRelException {

		TraineeAdmissionDetailsRel traineeAdmissionDetailsRel =
			fetchByPrimaryKey(primaryKey);

		if (traineeAdmissionDetailsRel == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchTraineeAdmissionDetailsRelException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return traineeAdmissionDetailsRel;
	}

	/**
	 * Returns the trainee admission details rel with the primary key or throws a <code>NoSuchTraineeAdmissionDetailsRelException</code> if it could not be found.
	 *
	 * @param traineeAdmissionDetailsRelId the primary key of the trainee admission details rel
	 * @return the trainee admission details rel
	 * @throws NoSuchTraineeAdmissionDetailsRelException if a trainee admission details rel with the primary key could not be found
	 */
	@Override
	public TraineeAdmissionDetailsRel findByPrimaryKey(
			long traineeAdmissionDetailsRelId)
		throws NoSuchTraineeAdmissionDetailsRelException {

		return findByPrimaryKey((Serializable)traineeAdmissionDetailsRelId);
	}

	/**
	 * Returns the trainee admission details rel with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param traineeAdmissionDetailsRelId the primary key of the trainee admission details rel
	 * @return the trainee admission details rel, or <code>null</code> if a trainee admission details rel with the primary key could not be found
	 */
	@Override
	public TraineeAdmissionDetailsRel fetchByPrimaryKey(
		long traineeAdmissionDetailsRelId) {

		return fetchByPrimaryKey((Serializable)traineeAdmissionDetailsRelId);
	}

	/**
	 * Returns all the trainee admission details rels.
	 *
	 * @return the trainee admission details rels
	 */
	@Override
	public List<TraineeAdmissionDetailsRel> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the trainee admission details rels.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TraineeAdmissionDetailsRelModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of trainee admission details rels
	 * @param end the upper bound of the range of trainee admission details rels (not inclusive)
	 * @return the range of trainee admission details rels
	 */
	@Override
	public List<TraineeAdmissionDetailsRel> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the trainee admission details rels.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TraineeAdmissionDetailsRelModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of trainee admission details rels
	 * @param end the upper bound of the range of trainee admission details rels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of trainee admission details rels
	 */
	@Override
	public List<TraineeAdmissionDetailsRel> findAll(
		int start, int end,
		OrderByComparator<TraineeAdmissionDetailsRel> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the trainee admission details rels.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TraineeAdmissionDetailsRelModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of trainee admission details rels
	 * @param end the upper bound of the range of trainee admission details rels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of trainee admission details rels
	 */
	@Override
	public List<TraineeAdmissionDetailsRel> findAll(
		int start, int end,
		OrderByComparator<TraineeAdmissionDetailsRel> orderByComparator,
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

		List<TraineeAdmissionDetailsRel> list = null;

		if (useFinderCache) {
			list = (List<TraineeAdmissionDetailsRel>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_TRAINEEADMISSIONDETAILSREL);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_TRAINEEADMISSIONDETAILSREL;

				sql = sql.concat(
					TraineeAdmissionDetailsRelModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<TraineeAdmissionDetailsRel>)QueryUtil.list(
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
	 * Removes all the trainee admission details rels from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (TraineeAdmissionDetailsRel traineeAdmissionDetailsRel :
				findAll()) {

			remove(traineeAdmissionDetailsRel);
		}
	}

	/**
	 * Returns the number of trainee admission details rels.
	 *
	 * @return the number of trainee admission details rels
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
					_SQL_COUNT_TRAINEEADMISSIONDETAILSREL);

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
		return "trainee_admission_details_rel_id";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_TRAINEEADMISSIONDETAILSREL;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return TraineeAdmissionDetailsRelModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the trainee admission details rel persistence.
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

		_finderPathFetchByTraineeId = new FinderPath(
			FINDER_CLASS_NAME_ENTITY, "fetchByTraineeId",
			new String[] {Long.class.getName()}, new String[] {"trainee_id"},
			true);

		_finderPathCountByTraineeId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByTraineeId",
			new String[] {Long.class.getName()}, new String[] {"trainee_id"},
			false);

		_setTraineeAdmissionDetailsRelUtilPersistence(this);
	}

	@Deactivate
	public void deactivate() {
		_setTraineeAdmissionDetailsRelUtilPersistence(null);

		entityCache.removeCache(TraineeAdmissionDetailsRelImpl.class.getName());
	}

	private void _setTraineeAdmissionDetailsRelUtilPersistence(
		TraineeAdmissionDetailsRelPersistence
			traineeAdmissionDetailsRelPersistence) {

		try {
			Field field = TraineeAdmissionDetailsRelUtil.class.getDeclaredField(
				"_persistence");

			field.setAccessible(true);

			field.set(null, traineeAdmissionDetailsRelPersistence);
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

	private static final String _SQL_SELECT_TRAINEEADMISSIONDETAILSREL =
		"SELECT traineeAdmissionDetailsRel FROM TraineeAdmissionDetailsRel traineeAdmissionDetailsRel";

	private static final String _SQL_SELECT_TRAINEEADMISSIONDETAILSREL_WHERE =
		"SELECT traineeAdmissionDetailsRel FROM TraineeAdmissionDetailsRel traineeAdmissionDetailsRel WHERE ";

	private static final String _SQL_COUNT_TRAINEEADMISSIONDETAILSREL =
		"SELECT COUNT(traineeAdmissionDetailsRel) FROM TraineeAdmissionDetailsRel traineeAdmissionDetailsRel";

	private static final String _SQL_COUNT_TRAINEEADMISSIONDETAILSREL_WHERE =
		"SELECT COUNT(traineeAdmissionDetailsRel) FROM TraineeAdmissionDetailsRel traineeAdmissionDetailsRel WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS =
		"traineeAdmissionDetailsRel.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No TraineeAdmissionDetailsRel exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No TraineeAdmissionDetailsRel exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		TraineeAdmissionDetailsRelPersistenceImpl.class);

	private static final Set<String> _badColumnNames = SetUtil.fromArray(
		new String[] {
			"uuid", "traineeAdmissionDetailsRelId", "groupId", "companyId",
			"createDate", "modifiedDate", "createdBy", "modifiedBy",
			"traineeId", "programDurationId", "admissionYear", "omsbNumber",
			"traineeAddress"
		});

	@Override
	protected FinderCache getFinderCache() {
		return finderCache;
	}

	@Reference
	private PortalUUID _portalUUID;

}
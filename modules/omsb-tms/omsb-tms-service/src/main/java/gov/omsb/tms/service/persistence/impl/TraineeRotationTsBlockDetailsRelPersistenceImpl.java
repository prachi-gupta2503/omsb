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

import gov.omsb.tms.exception.NoSuchTraineeRotationTsBlockDetailsRelException;
import gov.omsb.tms.model.TraineeRotationTsBlockDetailsRel;
import gov.omsb.tms.model.TraineeRotationTsBlockDetailsRelTable;
import gov.omsb.tms.model.impl.TraineeRotationTsBlockDetailsRelImpl;
import gov.omsb.tms.model.impl.TraineeRotationTsBlockDetailsRelModelImpl;
import gov.omsb.tms.service.persistence.TraineeRotationTsBlockDetailsRelPersistence;
import gov.omsb.tms.service.persistence.TraineeRotationTsBlockDetailsRelUtil;
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
 * The persistence implementation for the trainee rotation ts block details rel service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = TraineeRotationTsBlockDetailsRelPersistence.class)
public class TraineeRotationTsBlockDetailsRelPersistenceImpl
	extends BasePersistenceImpl<TraineeRotationTsBlockDetailsRel>
	implements TraineeRotationTsBlockDetailsRelPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>TraineeRotationTsBlockDetailsRelUtil</code> to access the trainee rotation ts block details rel persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		TraineeRotationTsBlockDetailsRelImpl.class.getName();

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
	 * Returns all the trainee rotation ts block details rels where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching trainee rotation ts block details rels
	 */
	@Override
	public List<TraineeRotationTsBlockDetailsRel> findByUuid(String uuid) {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the trainee rotation ts block details rels where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TraineeRotationTsBlockDetailsRelModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of trainee rotation ts block details rels
	 * @param end the upper bound of the range of trainee rotation ts block details rels (not inclusive)
	 * @return the range of matching trainee rotation ts block details rels
	 */
	@Override
	public List<TraineeRotationTsBlockDetailsRel> findByUuid(
		String uuid, int start, int end) {

		return findByUuid(uuid, start, end, null);
	}

	/**
	 * Returns an ordered range of all the trainee rotation ts block details rels where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TraineeRotationTsBlockDetailsRelModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of trainee rotation ts block details rels
	 * @param end the upper bound of the range of trainee rotation ts block details rels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching trainee rotation ts block details rels
	 */
	@Override
	public List<TraineeRotationTsBlockDetailsRel> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<TraineeRotationTsBlockDetailsRel> orderByComparator) {

		return findByUuid(uuid, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the trainee rotation ts block details rels where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TraineeRotationTsBlockDetailsRelModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of trainee rotation ts block details rels
	 * @param end the upper bound of the range of trainee rotation ts block details rels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching trainee rotation ts block details rels
	 */
	@Override
	public List<TraineeRotationTsBlockDetailsRel> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<TraineeRotationTsBlockDetailsRel> orderByComparator,
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

		List<TraineeRotationTsBlockDetailsRel> list = null;

		if (useFinderCache) {
			list =
				(List<TraineeRotationTsBlockDetailsRel>)finderCache.getResult(
					finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (TraineeRotationTsBlockDetailsRel
						traineeRotationTsBlockDetailsRel : list) {

					if (!uuid.equals(
							traineeRotationTsBlockDetailsRel.getUuid())) {

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

			sb.append(_SQL_SELECT_TRAINEEROTATIONTSBLOCKDETAILSREL_WHERE);

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
					TraineeRotationTsBlockDetailsRelModelImpl.ORDER_BY_JPQL);
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

				list = (List<TraineeRotationTsBlockDetailsRel>)QueryUtil.list(
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
	 * Returns the first trainee rotation ts block details rel in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching trainee rotation ts block details rel
	 * @throws NoSuchTraineeRotationTsBlockDetailsRelException if a matching trainee rotation ts block details rel could not be found
	 */
	@Override
	public TraineeRotationTsBlockDetailsRel findByUuid_First(
			String uuid,
			OrderByComparator<TraineeRotationTsBlockDetailsRel>
				orderByComparator)
		throws NoSuchTraineeRotationTsBlockDetailsRelException {

		TraineeRotationTsBlockDetailsRel traineeRotationTsBlockDetailsRel =
			fetchByUuid_First(uuid, orderByComparator);

		if (traineeRotationTsBlockDetailsRel != null) {
			return traineeRotationTsBlockDetailsRel;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchTraineeRotationTsBlockDetailsRelException(
			sb.toString());
	}

	/**
	 * Returns the first trainee rotation ts block details rel in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching trainee rotation ts block details rel, or <code>null</code> if a matching trainee rotation ts block details rel could not be found
	 */
	@Override
	public TraineeRotationTsBlockDetailsRel fetchByUuid_First(
		String uuid,
		OrderByComparator<TraineeRotationTsBlockDetailsRel> orderByComparator) {

		List<TraineeRotationTsBlockDetailsRel> list = findByUuid(
			uuid, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last trainee rotation ts block details rel in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching trainee rotation ts block details rel
	 * @throws NoSuchTraineeRotationTsBlockDetailsRelException if a matching trainee rotation ts block details rel could not be found
	 */
	@Override
	public TraineeRotationTsBlockDetailsRel findByUuid_Last(
			String uuid,
			OrderByComparator<TraineeRotationTsBlockDetailsRel>
				orderByComparator)
		throws NoSuchTraineeRotationTsBlockDetailsRelException {

		TraineeRotationTsBlockDetailsRel traineeRotationTsBlockDetailsRel =
			fetchByUuid_Last(uuid, orderByComparator);

		if (traineeRotationTsBlockDetailsRel != null) {
			return traineeRotationTsBlockDetailsRel;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchTraineeRotationTsBlockDetailsRelException(
			sb.toString());
	}

	/**
	 * Returns the last trainee rotation ts block details rel in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching trainee rotation ts block details rel, or <code>null</code> if a matching trainee rotation ts block details rel could not be found
	 */
	@Override
	public TraineeRotationTsBlockDetailsRel fetchByUuid_Last(
		String uuid,
		OrderByComparator<TraineeRotationTsBlockDetailsRel> orderByComparator) {

		int count = countByUuid(uuid);

		if (count == 0) {
			return null;
		}

		List<TraineeRotationTsBlockDetailsRel> list = findByUuid(
			uuid, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the trainee rotation ts block details rels before and after the current trainee rotation ts block details rel in the ordered set where uuid = &#63;.
	 *
	 * @param traineeRotationTsBlockDetailsRelId the primary key of the current trainee rotation ts block details rel
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next trainee rotation ts block details rel
	 * @throws NoSuchTraineeRotationTsBlockDetailsRelException if a trainee rotation ts block details rel with the primary key could not be found
	 */
	@Override
	public TraineeRotationTsBlockDetailsRel[] findByUuid_PrevAndNext(
			long traineeRotationTsBlockDetailsRelId, String uuid,
			OrderByComparator<TraineeRotationTsBlockDetailsRel>
				orderByComparator)
		throws NoSuchTraineeRotationTsBlockDetailsRelException {

		uuid = Objects.toString(uuid, "");

		TraineeRotationTsBlockDetailsRel traineeRotationTsBlockDetailsRel =
			findByPrimaryKey(traineeRotationTsBlockDetailsRelId);

		Session session = null;

		try {
			session = openSession();

			TraineeRotationTsBlockDetailsRel[] array =
				new TraineeRotationTsBlockDetailsRelImpl[3];

			array[0] = getByUuid_PrevAndNext(
				session, traineeRotationTsBlockDetailsRel, uuid,
				orderByComparator, true);

			array[1] = traineeRotationTsBlockDetailsRel;

			array[2] = getByUuid_PrevAndNext(
				session, traineeRotationTsBlockDetailsRel, uuid,
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

	protected TraineeRotationTsBlockDetailsRel getByUuid_PrevAndNext(
		Session session,
		TraineeRotationTsBlockDetailsRel traineeRotationTsBlockDetailsRel,
		String uuid,
		OrderByComparator<TraineeRotationTsBlockDetailsRel> orderByComparator,
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

		sb.append(_SQL_SELECT_TRAINEEROTATIONTSBLOCKDETAILSREL_WHERE);

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
			sb.append(TraineeRotationTsBlockDetailsRelModelImpl.ORDER_BY_JPQL);
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
						traineeRotationTsBlockDetailsRel)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<TraineeRotationTsBlockDetailsRel> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the trainee rotation ts block details rels where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	@Override
	public void removeByUuid(String uuid) {
		for (TraineeRotationTsBlockDetailsRel traineeRotationTsBlockDetailsRel :
				findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(traineeRotationTsBlockDetailsRel);
		}
	}

	/**
	 * Returns the number of trainee rotation ts block details rels where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching trainee rotation ts block details rels
	 */
	@Override
	public int countByUuid(String uuid) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid;

		Object[] finderArgs = new Object[] {uuid};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_TRAINEEROTATIONTSBLOCKDETAILSREL_WHERE);

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
		"traineeRotationTsBlockDetailsRel.uuid = ?";

	private static final String _FINDER_COLUMN_UUID_UUID_3 =
		"(traineeRotationTsBlockDetailsRel.uuid IS NULL OR traineeRotationTsBlockDetailsRel.uuid = '')";

	private FinderPath _finderPathFetchByUUID_G;
	private FinderPath _finderPathCountByUUID_G;

	/**
	 * Returns the trainee rotation ts block details rel where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchTraineeRotationTsBlockDetailsRelException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching trainee rotation ts block details rel
	 * @throws NoSuchTraineeRotationTsBlockDetailsRelException if a matching trainee rotation ts block details rel could not be found
	 */
	@Override
	public TraineeRotationTsBlockDetailsRel findByUUID_G(
			String uuid, long groupId)
		throws NoSuchTraineeRotationTsBlockDetailsRelException {

		TraineeRotationTsBlockDetailsRel traineeRotationTsBlockDetailsRel =
			fetchByUUID_G(uuid, groupId);

		if (traineeRotationTsBlockDetailsRel == null) {
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

			throw new NoSuchTraineeRotationTsBlockDetailsRelException(
				sb.toString());
		}

		return traineeRotationTsBlockDetailsRel;
	}

	/**
	 * Returns the trainee rotation ts block details rel where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching trainee rotation ts block details rel, or <code>null</code> if a matching trainee rotation ts block details rel could not be found
	 */
	@Override
	public TraineeRotationTsBlockDetailsRel fetchByUUID_G(
		String uuid, long groupId) {

		return fetchByUUID_G(uuid, groupId, true);
	}

	/**
	 * Returns the trainee rotation ts block details rel where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching trainee rotation ts block details rel, or <code>null</code> if a matching trainee rotation ts block details rel could not be found
	 */
	@Override
	public TraineeRotationTsBlockDetailsRel fetchByUUID_G(
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

		if (result instanceof TraineeRotationTsBlockDetailsRel) {
			TraineeRotationTsBlockDetailsRel traineeRotationTsBlockDetailsRel =
				(TraineeRotationTsBlockDetailsRel)result;

			if (!Objects.equals(
					uuid, traineeRotationTsBlockDetailsRel.getUuid()) ||
				(groupId != traineeRotationTsBlockDetailsRel.getGroupId())) {

				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_SQL_SELECT_TRAINEEROTATIONTSBLOCKDETAILSREL_WHERE);

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

				List<TraineeRotationTsBlockDetailsRel> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchByUUID_G, finderArgs, list);
					}
				}
				else {
					TraineeRotationTsBlockDetailsRel
						traineeRotationTsBlockDetailsRel = list.get(0);

					result = traineeRotationTsBlockDetailsRel;

					cacheResult(traineeRotationTsBlockDetailsRel);
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
			return (TraineeRotationTsBlockDetailsRel)result;
		}
	}

	/**
	 * Removes the trainee rotation ts block details rel where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the trainee rotation ts block details rel that was removed
	 */
	@Override
	public TraineeRotationTsBlockDetailsRel removeByUUID_G(
			String uuid, long groupId)
		throws NoSuchTraineeRotationTsBlockDetailsRelException {

		TraineeRotationTsBlockDetailsRel traineeRotationTsBlockDetailsRel =
			findByUUID_G(uuid, groupId);

		return remove(traineeRotationTsBlockDetailsRel);
	}

	/**
	 * Returns the number of trainee rotation ts block details rels where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching trainee rotation ts block details rels
	 */
	@Override
	public int countByUUID_G(String uuid, long groupId) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUUID_G;

		Object[] finderArgs = new Object[] {uuid, groupId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_TRAINEEROTATIONTSBLOCKDETAILSREL_WHERE);

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
		"traineeRotationTsBlockDetailsRel.uuid = ? AND ";

	private static final String _FINDER_COLUMN_UUID_G_UUID_3 =
		"(traineeRotationTsBlockDetailsRel.uuid IS NULL OR traineeRotationTsBlockDetailsRel.uuid = '') AND ";

	private static final String _FINDER_COLUMN_UUID_G_GROUPID_2 =
		"traineeRotationTsBlockDetailsRel.groupId = ?";

	private FinderPath _finderPathWithPaginationFindByUuid_C;
	private FinderPath _finderPathWithoutPaginationFindByUuid_C;
	private FinderPath _finderPathCountByUuid_C;

	/**
	 * Returns all the trainee rotation ts block details rels where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching trainee rotation ts block details rels
	 */
	@Override
	public List<TraineeRotationTsBlockDetailsRel> findByUuid_C(
		String uuid, long companyId) {

		return findByUuid_C(
			uuid, companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the trainee rotation ts block details rels where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TraineeRotationTsBlockDetailsRelModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of trainee rotation ts block details rels
	 * @param end the upper bound of the range of trainee rotation ts block details rels (not inclusive)
	 * @return the range of matching trainee rotation ts block details rels
	 */
	@Override
	public List<TraineeRotationTsBlockDetailsRel> findByUuid_C(
		String uuid, long companyId, int start, int end) {

		return findByUuid_C(uuid, companyId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the trainee rotation ts block details rels where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TraineeRotationTsBlockDetailsRelModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of trainee rotation ts block details rels
	 * @param end the upper bound of the range of trainee rotation ts block details rels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching trainee rotation ts block details rels
	 */
	@Override
	public List<TraineeRotationTsBlockDetailsRel> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<TraineeRotationTsBlockDetailsRel> orderByComparator) {

		return findByUuid_C(
			uuid, companyId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the trainee rotation ts block details rels where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TraineeRotationTsBlockDetailsRelModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of trainee rotation ts block details rels
	 * @param end the upper bound of the range of trainee rotation ts block details rels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching trainee rotation ts block details rels
	 */
	@Override
	public List<TraineeRotationTsBlockDetailsRel> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<TraineeRotationTsBlockDetailsRel> orderByComparator,
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

		List<TraineeRotationTsBlockDetailsRel> list = null;

		if (useFinderCache) {
			list =
				(List<TraineeRotationTsBlockDetailsRel>)finderCache.getResult(
					finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (TraineeRotationTsBlockDetailsRel
						traineeRotationTsBlockDetailsRel : list) {

					if (!uuid.equals(
							traineeRotationTsBlockDetailsRel.getUuid()) ||
						(companyId !=
							traineeRotationTsBlockDetailsRel.getCompanyId())) {

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

			sb.append(_SQL_SELECT_TRAINEEROTATIONTSBLOCKDETAILSREL_WHERE);

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
					TraineeRotationTsBlockDetailsRelModelImpl.ORDER_BY_JPQL);
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

				list = (List<TraineeRotationTsBlockDetailsRel>)QueryUtil.list(
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
	 * Returns the first trainee rotation ts block details rel in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching trainee rotation ts block details rel
	 * @throws NoSuchTraineeRotationTsBlockDetailsRelException if a matching trainee rotation ts block details rel could not be found
	 */
	@Override
	public TraineeRotationTsBlockDetailsRel findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<TraineeRotationTsBlockDetailsRel>
				orderByComparator)
		throws NoSuchTraineeRotationTsBlockDetailsRelException {

		TraineeRotationTsBlockDetailsRel traineeRotationTsBlockDetailsRel =
			fetchByUuid_C_First(uuid, companyId, orderByComparator);

		if (traineeRotationTsBlockDetailsRel != null) {
			return traineeRotationTsBlockDetailsRel;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append(", companyId=");
		sb.append(companyId);

		sb.append("}");

		throw new NoSuchTraineeRotationTsBlockDetailsRelException(
			sb.toString());
	}

	/**
	 * Returns the first trainee rotation ts block details rel in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching trainee rotation ts block details rel, or <code>null</code> if a matching trainee rotation ts block details rel could not be found
	 */
	@Override
	public TraineeRotationTsBlockDetailsRel fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<TraineeRotationTsBlockDetailsRel> orderByComparator) {

		List<TraineeRotationTsBlockDetailsRel> list = findByUuid_C(
			uuid, companyId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last trainee rotation ts block details rel in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching trainee rotation ts block details rel
	 * @throws NoSuchTraineeRotationTsBlockDetailsRelException if a matching trainee rotation ts block details rel could not be found
	 */
	@Override
	public TraineeRotationTsBlockDetailsRel findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<TraineeRotationTsBlockDetailsRel>
				orderByComparator)
		throws NoSuchTraineeRotationTsBlockDetailsRelException {

		TraineeRotationTsBlockDetailsRel traineeRotationTsBlockDetailsRel =
			fetchByUuid_C_Last(uuid, companyId, orderByComparator);

		if (traineeRotationTsBlockDetailsRel != null) {
			return traineeRotationTsBlockDetailsRel;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append(", companyId=");
		sb.append(companyId);

		sb.append("}");

		throw new NoSuchTraineeRotationTsBlockDetailsRelException(
			sb.toString());
	}

	/**
	 * Returns the last trainee rotation ts block details rel in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching trainee rotation ts block details rel, or <code>null</code> if a matching trainee rotation ts block details rel could not be found
	 */
	@Override
	public TraineeRotationTsBlockDetailsRel fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<TraineeRotationTsBlockDetailsRel> orderByComparator) {

		int count = countByUuid_C(uuid, companyId);

		if (count == 0) {
			return null;
		}

		List<TraineeRotationTsBlockDetailsRel> list = findByUuid_C(
			uuid, companyId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the trainee rotation ts block details rels before and after the current trainee rotation ts block details rel in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param traineeRotationTsBlockDetailsRelId the primary key of the current trainee rotation ts block details rel
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next trainee rotation ts block details rel
	 * @throws NoSuchTraineeRotationTsBlockDetailsRelException if a trainee rotation ts block details rel with the primary key could not be found
	 */
	@Override
	public TraineeRotationTsBlockDetailsRel[] findByUuid_C_PrevAndNext(
			long traineeRotationTsBlockDetailsRelId, String uuid,
			long companyId,
			OrderByComparator<TraineeRotationTsBlockDetailsRel>
				orderByComparator)
		throws NoSuchTraineeRotationTsBlockDetailsRelException {

		uuid = Objects.toString(uuid, "");

		TraineeRotationTsBlockDetailsRel traineeRotationTsBlockDetailsRel =
			findByPrimaryKey(traineeRotationTsBlockDetailsRelId);

		Session session = null;

		try {
			session = openSession();

			TraineeRotationTsBlockDetailsRel[] array =
				new TraineeRotationTsBlockDetailsRelImpl[3];

			array[0] = getByUuid_C_PrevAndNext(
				session, traineeRotationTsBlockDetailsRel, uuid, companyId,
				orderByComparator, true);

			array[1] = traineeRotationTsBlockDetailsRel;

			array[2] = getByUuid_C_PrevAndNext(
				session, traineeRotationTsBlockDetailsRel, uuid, companyId,
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

	protected TraineeRotationTsBlockDetailsRel getByUuid_C_PrevAndNext(
		Session session,
		TraineeRotationTsBlockDetailsRel traineeRotationTsBlockDetailsRel,
		String uuid, long companyId,
		OrderByComparator<TraineeRotationTsBlockDetailsRel> orderByComparator,
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

		sb.append(_SQL_SELECT_TRAINEEROTATIONTSBLOCKDETAILSREL_WHERE);

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
			sb.append(TraineeRotationTsBlockDetailsRelModelImpl.ORDER_BY_JPQL);
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
						traineeRotationTsBlockDetailsRel)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<TraineeRotationTsBlockDetailsRel> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the trainee rotation ts block details rels where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	@Override
	public void removeByUuid_C(String uuid, long companyId) {
		for (TraineeRotationTsBlockDetailsRel traineeRotationTsBlockDetailsRel :
				findByUuid_C(
					uuid, companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(traineeRotationTsBlockDetailsRel);
		}
	}

	/**
	 * Returns the number of trainee rotation ts block details rels where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching trainee rotation ts block details rels
	 */
	@Override
	public int countByUuid_C(String uuid, long companyId) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid_C;

		Object[] finderArgs = new Object[] {uuid, companyId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_TRAINEEROTATIONTSBLOCKDETAILSREL_WHERE);

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
		"traineeRotationTsBlockDetailsRel.uuid = ? AND ";

	private static final String _FINDER_COLUMN_UUID_C_UUID_3 =
		"(traineeRotationTsBlockDetailsRel.uuid IS NULL OR traineeRotationTsBlockDetailsRel.uuid = '') AND ";

	private static final String _FINDER_COLUMN_UUID_C_COMPANYID_2 =
		"traineeRotationTsBlockDetailsRel.companyId = ?";

	private FinderPath
		_finderPathWithPaginationFindByBlocksMetadataDetailsRelId;
	private FinderPath
		_finderPathWithoutPaginationFindByBlocksMetadataDetailsRelId;
	private FinderPath _finderPathCountByBlocksMetadataDetailsRelId;

	/**
	 * Returns all the trainee rotation ts block details rels where blocksMetadataDetailsRelId = &#63;.
	 *
	 * @param blocksMetadataDetailsRelId the blocks metadata details rel ID
	 * @return the matching trainee rotation ts block details rels
	 */
	@Override
	public List<TraineeRotationTsBlockDetailsRel>
		findByBlocksMetadataDetailsRelId(long blocksMetadataDetailsRelId) {

		return findByBlocksMetadataDetailsRelId(
			blocksMetadataDetailsRelId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
	}

	/**
	 * Returns a range of all the trainee rotation ts block details rels where blocksMetadataDetailsRelId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TraineeRotationTsBlockDetailsRelModelImpl</code>.
	 * </p>
	 *
	 * @param blocksMetadataDetailsRelId the blocks metadata details rel ID
	 * @param start the lower bound of the range of trainee rotation ts block details rels
	 * @param end the upper bound of the range of trainee rotation ts block details rels (not inclusive)
	 * @return the range of matching trainee rotation ts block details rels
	 */
	@Override
	public List<TraineeRotationTsBlockDetailsRel>
		findByBlocksMetadataDetailsRelId(
			long blocksMetadataDetailsRelId, int start, int end) {

		return findByBlocksMetadataDetailsRelId(
			blocksMetadataDetailsRelId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the trainee rotation ts block details rels where blocksMetadataDetailsRelId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TraineeRotationTsBlockDetailsRelModelImpl</code>.
	 * </p>
	 *
	 * @param blocksMetadataDetailsRelId the blocks metadata details rel ID
	 * @param start the lower bound of the range of trainee rotation ts block details rels
	 * @param end the upper bound of the range of trainee rotation ts block details rels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching trainee rotation ts block details rels
	 */
	@Override
	public List<TraineeRotationTsBlockDetailsRel>
		findByBlocksMetadataDetailsRelId(
			long blocksMetadataDetailsRelId, int start, int end,
			OrderByComparator<TraineeRotationTsBlockDetailsRel>
				orderByComparator) {

		return findByBlocksMetadataDetailsRelId(
			blocksMetadataDetailsRelId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the trainee rotation ts block details rels where blocksMetadataDetailsRelId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TraineeRotationTsBlockDetailsRelModelImpl</code>.
	 * </p>
	 *
	 * @param blocksMetadataDetailsRelId the blocks metadata details rel ID
	 * @param start the lower bound of the range of trainee rotation ts block details rels
	 * @param end the upper bound of the range of trainee rotation ts block details rels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching trainee rotation ts block details rels
	 */
	@Override
	public List<TraineeRotationTsBlockDetailsRel>
		findByBlocksMetadataDetailsRelId(
			long blocksMetadataDetailsRelId, int start, int end,
			OrderByComparator<TraineeRotationTsBlockDetailsRel>
				orderByComparator,
			boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath =
					_finderPathWithoutPaginationFindByBlocksMetadataDetailsRelId;
				finderArgs = new Object[] {blocksMetadataDetailsRelId};
			}
		}
		else if (useFinderCache) {
			finderPath =
				_finderPathWithPaginationFindByBlocksMetadataDetailsRelId;
			finderArgs = new Object[] {
				blocksMetadataDetailsRelId, start, end, orderByComparator
			};
		}

		List<TraineeRotationTsBlockDetailsRel> list = null;

		if (useFinderCache) {
			list =
				(List<TraineeRotationTsBlockDetailsRel>)finderCache.getResult(
					finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (TraineeRotationTsBlockDetailsRel
						traineeRotationTsBlockDetailsRel : list) {

					if (blocksMetadataDetailsRelId !=
							traineeRotationTsBlockDetailsRel.
								getBlocksMetadataDetailsRelId()) {

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

			sb.append(_SQL_SELECT_TRAINEEROTATIONTSBLOCKDETAILSREL_WHERE);

			sb.append(
				_FINDER_COLUMN_BLOCKSMETADATADETAILSRELID_BLOCKSMETADATADETAILSRELID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(
					TraineeRotationTsBlockDetailsRelModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(blocksMetadataDetailsRelId);

				list = (List<TraineeRotationTsBlockDetailsRel>)QueryUtil.list(
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
	 * Returns the first trainee rotation ts block details rel in the ordered set where blocksMetadataDetailsRelId = &#63;.
	 *
	 * @param blocksMetadataDetailsRelId the blocks metadata details rel ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching trainee rotation ts block details rel
	 * @throws NoSuchTraineeRotationTsBlockDetailsRelException if a matching trainee rotation ts block details rel could not be found
	 */
	@Override
	public TraineeRotationTsBlockDetailsRel
			findByBlocksMetadataDetailsRelId_First(
				long blocksMetadataDetailsRelId,
				OrderByComparator<TraineeRotationTsBlockDetailsRel>
					orderByComparator)
		throws NoSuchTraineeRotationTsBlockDetailsRelException {

		TraineeRotationTsBlockDetailsRel traineeRotationTsBlockDetailsRel =
			fetchByBlocksMetadataDetailsRelId_First(
				blocksMetadataDetailsRelId, orderByComparator);

		if (traineeRotationTsBlockDetailsRel != null) {
			return traineeRotationTsBlockDetailsRel;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("blocksMetadataDetailsRelId=");
		sb.append(blocksMetadataDetailsRelId);

		sb.append("}");

		throw new NoSuchTraineeRotationTsBlockDetailsRelException(
			sb.toString());
	}

	/**
	 * Returns the first trainee rotation ts block details rel in the ordered set where blocksMetadataDetailsRelId = &#63;.
	 *
	 * @param blocksMetadataDetailsRelId the blocks metadata details rel ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching trainee rotation ts block details rel, or <code>null</code> if a matching trainee rotation ts block details rel could not be found
	 */
	@Override
	public TraineeRotationTsBlockDetailsRel
		fetchByBlocksMetadataDetailsRelId_First(
			long blocksMetadataDetailsRelId,
			OrderByComparator<TraineeRotationTsBlockDetailsRel>
				orderByComparator) {

		List<TraineeRotationTsBlockDetailsRel> list =
			findByBlocksMetadataDetailsRelId(
				blocksMetadataDetailsRelId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last trainee rotation ts block details rel in the ordered set where blocksMetadataDetailsRelId = &#63;.
	 *
	 * @param blocksMetadataDetailsRelId the blocks metadata details rel ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching trainee rotation ts block details rel
	 * @throws NoSuchTraineeRotationTsBlockDetailsRelException if a matching trainee rotation ts block details rel could not be found
	 */
	@Override
	public TraineeRotationTsBlockDetailsRel
			findByBlocksMetadataDetailsRelId_Last(
				long blocksMetadataDetailsRelId,
				OrderByComparator<TraineeRotationTsBlockDetailsRel>
					orderByComparator)
		throws NoSuchTraineeRotationTsBlockDetailsRelException {

		TraineeRotationTsBlockDetailsRel traineeRotationTsBlockDetailsRel =
			fetchByBlocksMetadataDetailsRelId_Last(
				blocksMetadataDetailsRelId, orderByComparator);

		if (traineeRotationTsBlockDetailsRel != null) {
			return traineeRotationTsBlockDetailsRel;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("blocksMetadataDetailsRelId=");
		sb.append(blocksMetadataDetailsRelId);

		sb.append("}");

		throw new NoSuchTraineeRotationTsBlockDetailsRelException(
			sb.toString());
	}

	/**
	 * Returns the last trainee rotation ts block details rel in the ordered set where blocksMetadataDetailsRelId = &#63;.
	 *
	 * @param blocksMetadataDetailsRelId the blocks metadata details rel ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching trainee rotation ts block details rel, or <code>null</code> if a matching trainee rotation ts block details rel could not be found
	 */
	@Override
	public TraineeRotationTsBlockDetailsRel
		fetchByBlocksMetadataDetailsRelId_Last(
			long blocksMetadataDetailsRelId,
			OrderByComparator<TraineeRotationTsBlockDetailsRel>
				orderByComparator) {

		int count = countByBlocksMetadataDetailsRelId(
			blocksMetadataDetailsRelId);

		if (count == 0) {
			return null;
		}

		List<TraineeRotationTsBlockDetailsRel> list =
			findByBlocksMetadataDetailsRelId(
				blocksMetadataDetailsRelId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the trainee rotation ts block details rels before and after the current trainee rotation ts block details rel in the ordered set where blocksMetadataDetailsRelId = &#63;.
	 *
	 * @param traineeRotationTsBlockDetailsRelId the primary key of the current trainee rotation ts block details rel
	 * @param blocksMetadataDetailsRelId the blocks metadata details rel ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next trainee rotation ts block details rel
	 * @throws NoSuchTraineeRotationTsBlockDetailsRelException if a trainee rotation ts block details rel with the primary key could not be found
	 */
	@Override
	public TraineeRotationTsBlockDetailsRel[]
			findByBlocksMetadataDetailsRelId_PrevAndNext(
				long traineeRotationTsBlockDetailsRelId,
				long blocksMetadataDetailsRelId,
				OrderByComparator<TraineeRotationTsBlockDetailsRel>
					orderByComparator)
		throws NoSuchTraineeRotationTsBlockDetailsRelException {

		TraineeRotationTsBlockDetailsRel traineeRotationTsBlockDetailsRel =
			findByPrimaryKey(traineeRotationTsBlockDetailsRelId);

		Session session = null;

		try {
			session = openSession();

			TraineeRotationTsBlockDetailsRel[] array =
				new TraineeRotationTsBlockDetailsRelImpl[3];

			array[0] = getByBlocksMetadataDetailsRelId_PrevAndNext(
				session, traineeRotationTsBlockDetailsRel,
				blocksMetadataDetailsRelId, orderByComparator, true);

			array[1] = traineeRotationTsBlockDetailsRel;

			array[2] = getByBlocksMetadataDetailsRelId_PrevAndNext(
				session, traineeRotationTsBlockDetailsRel,
				blocksMetadataDetailsRelId, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected TraineeRotationTsBlockDetailsRel
		getByBlocksMetadataDetailsRelId_PrevAndNext(
			Session session,
			TraineeRotationTsBlockDetailsRel traineeRotationTsBlockDetailsRel,
			long blocksMetadataDetailsRelId,
			OrderByComparator<TraineeRotationTsBlockDetailsRel>
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

		sb.append(_SQL_SELECT_TRAINEEROTATIONTSBLOCKDETAILSREL_WHERE);

		sb.append(
			_FINDER_COLUMN_BLOCKSMETADATADETAILSRELID_BLOCKSMETADATADETAILSRELID_2);

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
			sb.append(TraineeRotationTsBlockDetailsRelModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(blocksMetadataDetailsRelId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						traineeRotationTsBlockDetailsRel)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<TraineeRotationTsBlockDetailsRel> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the trainee rotation ts block details rels where blocksMetadataDetailsRelId = &#63; from the database.
	 *
	 * @param blocksMetadataDetailsRelId the blocks metadata details rel ID
	 */
	@Override
	public void removeByBlocksMetadataDetailsRelId(
		long blocksMetadataDetailsRelId) {

		for (TraineeRotationTsBlockDetailsRel traineeRotationTsBlockDetailsRel :
				findByBlocksMetadataDetailsRelId(
					blocksMetadataDetailsRelId, QueryUtil.ALL_POS,
					QueryUtil.ALL_POS, null)) {

			remove(traineeRotationTsBlockDetailsRel);
		}
	}

	/**
	 * Returns the number of trainee rotation ts block details rels where blocksMetadataDetailsRelId = &#63;.
	 *
	 * @param blocksMetadataDetailsRelId the blocks metadata details rel ID
	 * @return the number of matching trainee rotation ts block details rels
	 */
	@Override
	public int countByBlocksMetadataDetailsRelId(
		long blocksMetadataDetailsRelId) {

		FinderPath finderPath = _finderPathCountByBlocksMetadataDetailsRelId;

		Object[] finderArgs = new Object[] {blocksMetadataDetailsRelId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_TRAINEEROTATIONTSBLOCKDETAILSREL_WHERE);

			sb.append(
				_FINDER_COLUMN_BLOCKSMETADATADETAILSRELID_BLOCKSMETADATADETAILSRELID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(blocksMetadataDetailsRelId);

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
		_FINDER_COLUMN_BLOCKSMETADATADETAILSRELID_BLOCKSMETADATADETAILSRELID_2 =
			"traineeRotationTsBlockDetailsRel.blocksMetadataDetailsRelId = ?";

	private FinderPath _finderPathWithPaginationFindByTraineeId;
	private FinderPath _finderPathWithoutPaginationFindByTraineeId;
	private FinderPath _finderPathCountByTraineeId;

	/**
	 * Returns all the trainee rotation ts block details rels where traineeId = &#63;.
	 *
	 * @param traineeId the trainee ID
	 * @return the matching trainee rotation ts block details rels
	 */
	@Override
	public List<TraineeRotationTsBlockDetailsRel> findByTraineeId(
		long traineeId) {

		return findByTraineeId(
			traineeId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the trainee rotation ts block details rels where traineeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TraineeRotationTsBlockDetailsRelModelImpl</code>.
	 * </p>
	 *
	 * @param traineeId the trainee ID
	 * @param start the lower bound of the range of trainee rotation ts block details rels
	 * @param end the upper bound of the range of trainee rotation ts block details rels (not inclusive)
	 * @return the range of matching trainee rotation ts block details rels
	 */
	@Override
	public List<TraineeRotationTsBlockDetailsRel> findByTraineeId(
		long traineeId, int start, int end) {

		return findByTraineeId(traineeId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the trainee rotation ts block details rels where traineeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TraineeRotationTsBlockDetailsRelModelImpl</code>.
	 * </p>
	 *
	 * @param traineeId the trainee ID
	 * @param start the lower bound of the range of trainee rotation ts block details rels
	 * @param end the upper bound of the range of trainee rotation ts block details rels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching trainee rotation ts block details rels
	 */
	@Override
	public List<TraineeRotationTsBlockDetailsRel> findByTraineeId(
		long traineeId, int start, int end,
		OrderByComparator<TraineeRotationTsBlockDetailsRel> orderByComparator) {

		return findByTraineeId(traineeId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the trainee rotation ts block details rels where traineeId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TraineeRotationTsBlockDetailsRelModelImpl</code>.
	 * </p>
	 *
	 * @param traineeId the trainee ID
	 * @param start the lower bound of the range of trainee rotation ts block details rels
	 * @param end the upper bound of the range of trainee rotation ts block details rels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching trainee rotation ts block details rels
	 */
	@Override
	public List<TraineeRotationTsBlockDetailsRel> findByTraineeId(
		long traineeId, int start, int end,
		OrderByComparator<TraineeRotationTsBlockDetailsRel> orderByComparator,
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

		List<TraineeRotationTsBlockDetailsRel> list = null;

		if (useFinderCache) {
			list =
				(List<TraineeRotationTsBlockDetailsRel>)finderCache.getResult(
					finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (TraineeRotationTsBlockDetailsRel
						traineeRotationTsBlockDetailsRel : list) {

					if (traineeId !=
							traineeRotationTsBlockDetailsRel.getTraineeId()) {

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

			sb.append(_SQL_SELECT_TRAINEEROTATIONTSBLOCKDETAILSREL_WHERE);

			sb.append(_FINDER_COLUMN_TRAINEEID_TRAINEEID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(
					TraineeRotationTsBlockDetailsRelModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(traineeId);

				list = (List<TraineeRotationTsBlockDetailsRel>)QueryUtil.list(
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
	 * Returns the first trainee rotation ts block details rel in the ordered set where traineeId = &#63;.
	 *
	 * @param traineeId the trainee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching trainee rotation ts block details rel
	 * @throws NoSuchTraineeRotationTsBlockDetailsRelException if a matching trainee rotation ts block details rel could not be found
	 */
	@Override
	public TraineeRotationTsBlockDetailsRel findByTraineeId_First(
			long traineeId,
			OrderByComparator<TraineeRotationTsBlockDetailsRel>
				orderByComparator)
		throws NoSuchTraineeRotationTsBlockDetailsRelException {

		TraineeRotationTsBlockDetailsRel traineeRotationTsBlockDetailsRel =
			fetchByTraineeId_First(traineeId, orderByComparator);

		if (traineeRotationTsBlockDetailsRel != null) {
			return traineeRotationTsBlockDetailsRel;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("traineeId=");
		sb.append(traineeId);

		sb.append("}");

		throw new NoSuchTraineeRotationTsBlockDetailsRelException(
			sb.toString());
	}

	/**
	 * Returns the first trainee rotation ts block details rel in the ordered set where traineeId = &#63;.
	 *
	 * @param traineeId the trainee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching trainee rotation ts block details rel, or <code>null</code> if a matching trainee rotation ts block details rel could not be found
	 */
	@Override
	public TraineeRotationTsBlockDetailsRel fetchByTraineeId_First(
		long traineeId,
		OrderByComparator<TraineeRotationTsBlockDetailsRel> orderByComparator) {

		List<TraineeRotationTsBlockDetailsRel> list = findByTraineeId(
			traineeId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last trainee rotation ts block details rel in the ordered set where traineeId = &#63;.
	 *
	 * @param traineeId the trainee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching trainee rotation ts block details rel
	 * @throws NoSuchTraineeRotationTsBlockDetailsRelException if a matching trainee rotation ts block details rel could not be found
	 */
	@Override
	public TraineeRotationTsBlockDetailsRel findByTraineeId_Last(
			long traineeId,
			OrderByComparator<TraineeRotationTsBlockDetailsRel>
				orderByComparator)
		throws NoSuchTraineeRotationTsBlockDetailsRelException {

		TraineeRotationTsBlockDetailsRel traineeRotationTsBlockDetailsRel =
			fetchByTraineeId_Last(traineeId, orderByComparator);

		if (traineeRotationTsBlockDetailsRel != null) {
			return traineeRotationTsBlockDetailsRel;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("traineeId=");
		sb.append(traineeId);

		sb.append("}");

		throw new NoSuchTraineeRotationTsBlockDetailsRelException(
			sb.toString());
	}

	/**
	 * Returns the last trainee rotation ts block details rel in the ordered set where traineeId = &#63;.
	 *
	 * @param traineeId the trainee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching trainee rotation ts block details rel, or <code>null</code> if a matching trainee rotation ts block details rel could not be found
	 */
	@Override
	public TraineeRotationTsBlockDetailsRel fetchByTraineeId_Last(
		long traineeId,
		OrderByComparator<TraineeRotationTsBlockDetailsRel> orderByComparator) {

		int count = countByTraineeId(traineeId);

		if (count == 0) {
			return null;
		}

		List<TraineeRotationTsBlockDetailsRel> list = findByTraineeId(
			traineeId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the trainee rotation ts block details rels before and after the current trainee rotation ts block details rel in the ordered set where traineeId = &#63;.
	 *
	 * @param traineeRotationTsBlockDetailsRelId the primary key of the current trainee rotation ts block details rel
	 * @param traineeId the trainee ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next trainee rotation ts block details rel
	 * @throws NoSuchTraineeRotationTsBlockDetailsRelException if a trainee rotation ts block details rel with the primary key could not be found
	 */
	@Override
	public TraineeRotationTsBlockDetailsRel[] findByTraineeId_PrevAndNext(
			long traineeRotationTsBlockDetailsRelId, long traineeId,
			OrderByComparator<TraineeRotationTsBlockDetailsRel>
				orderByComparator)
		throws NoSuchTraineeRotationTsBlockDetailsRelException {

		TraineeRotationTsBlockDetailsRel traineeRotationTsBlockDetailsRel =
			findByPrimaryKey(traineeRotationTsBlockDetailsRelId);

		Session session = null;

		try {
			session = openSession();

			TraineeRotationTsBlockDetailsRel[] array =
				new TraineeRotationTsBlockDetailsRelImpl[3];

			array[0] = getByTraineeId_PrevAndNext(
				session, traineeRotationTsBlockDetailsRel, traineeId,
				orderByComparator, true);

			array[1] = traineeRotationTsBlockDetailsRel;

			array[2] = getByTraineeId_PrevAndNext(
				session, traineeRotationTsBlockDetailsRel, traineeId,
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

	protected TraineeRotationTsBlockDetailsRel getByTraineeId_PrevAndNext(
		Session session,
		TraineeRotationTsBlockDetailsRel traineeRotationTsBlockDetailsRel,
		long traineeId,
		OrderByComparator<TraineeRotationTsBlockDetailsRel> orderByComparator,
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

		sb.append(_SQL_SELECT_TRAINEEROTATIONTSBLOCKDETAILSREL_WHERE);

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
			sb.append(TraineeRotationTsBlockDetailsRelModelImpl.ORDER_BY_JPQL);
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
						traineeRotationTsBlockDetailsRel)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<TraineeRotationTsBlockDetailsRel> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the trainee rotation ts block details rels where traineeId = &#63; from the database.
	 *
	 * @param traineeId the trainee ID
	 */
	@Override
	public void removeByTraineeId(long traineeId) {
		for (TraineeRotationTsBlockDetailsRel traineeRotationTsBlockDetailsRel :
				findByTraineeId(
					traineeId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(traineeRotationTsBlockDetailsRel);
		}
	}

	/**
	 * Returns the number of trainee rotation ts block details rels where traineeId = &#63;.
	 *
	 * @param traineeId the trainee ID
	 * @return the number of matching trainee rotation ts block details rels
	 */
	@Override
	public int countByTraineeId(long traineeId) {
		FinderPath finderPath = _finderPathCountByTraineeId;

		Object[] finderArgs = new Object[] {traineeId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_TRAINEEROTATIONTSBLOCKDETAILSREL_WHERE);

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
		"traineeRotationTsBlockDetailsRel.traineeId = ?";

	private FinderPath
		_finderPathWithPaginationFindByProgDurationRotationTsRelId;
	private FinderPath
		_finderPathWithoutPaginationFindByProgDurationRotationTsRelId;
	private FinderPath _finderPathCountByProgDurationRotationTsRelId;

	/**
	 * Returns all the trainee rotation ts block details rels where progDurationRotationTsRelId = &#63;.
	 *
	 * @param progDurationRotationTsRelId the prog duration rotation ts rel ID
	 * @return the matching trainee rotation ts block details rels
	 */
	@Override
	public List<TraineeRotationTsBlockDetailsRel>
		findByProgDurationRotationTsRelId(long progDurationRotationTsRelId) {

		return findByProgDurationRotationTsRelId(
			progDurationRotationTsRelId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
	}

	/**
	 * Returns a range of all the trainee rotation ts block details rels where progDurationRotationTsRelId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TraineeRotationTsBlockDetailsRelModelImpl</code>.
	 * </p>
	 *
	 * @param progDurationRotationTsRelId the prog duration rotation ts rel ID
	 * @param start the lower bound of the range of trainee rotation ts block details rels
	 * @param end the upper bound of the range of trainee rotation ts block details rels (not inclusive)
	 * @return the range of matching trainee rotation ts block details rels
	 */
	@Override
	public List<TraineeRotationTsBlockDetailsRel>
		findByProgDurationRotationTsRelId(
			long progDurationRotationTsRelId, int start, int end) {

		return findByProgDurationRotationTsRelId(
			progDurationRotationTsRelId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the trainee rotation ts block details rels where progDurationRotationTsRelId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TraineeRotationTsBlockDetailsRelModelImpl</code>.
	 * </p>
	 *
	 * @param progDurationRotationTsRelId the prog duration rotation ts rel ID
	 * @param start the lower bound of the range of trainee rotation ts block details rels
	 * @param end the upper bound of the range of trainee rotation ts block details rels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching trainee rotation ts block details rels
	 */
	@Override
	public List<TraineeRotationTsBlockDetailsRel>
		findByProgDurationRotationTsRelId(
			long progDurationRotationTsRelId, int start, int end,
			OrderByComparator<TraineeRotationTsBlockDetailsRel>
				orderByComparator) {

		return findByProgDurationRotationTsRelId(
			progDurationRotationTsRelId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the trainee rotation ts block details rels where progDurationRotationTsRelId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TraineeRotationTsBlockDetailsRelModelImpl</code>.
	 * </p>
	 *
	 * @param progDurationRotationTsRelId the prog duration rotation ts rel ID
	 * @param start the lower bound of the range of trainee rotation ts block details rels
	 * @param end the upper bound of the range of trainee rotation ts block details rels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching trainee rotation ts block details rels
	 */
	@Override
	public List<TraineeRotationTsBlockDetailsRel>
		findByProgDurationRotationTsRelId(
			long progDurationRotationTsRelId, int start, int end,
			OrderByComparator<TraineeRotationTsBlockDetailsRel>
				orderByComparator,
			boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath =
					_finderPathWithoutPaginationFindByProgDurationRotationTsRelId;
				finderArgs = new Object[] {progDurationRotationTsRelId};
			}
		}
		else if (useFinderCache) {
			finderPath =
				_finderPathWithPaginationFindByProgDurationRotationTsRelId;
			finderArgs = new Object[] {
				progDurationRotationTsRelId, start, end, orderByComparator
			};
		}

		List<TraineeRotationTsBlockDetailsRel> list = null;

		if (useFinderCache) {
			list =
				(List<TraineeRotationTsBlockDetailsRel>)finderCache.getResult(
					finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (TraineeRotationTsBlockDetailsRel
						traineeRotationTsBlockDetailsRel : list) {

					if (progDurationRotationTsRelId !=
							traineeRotationTsBlockDetailsRel.
								getProgDurationRotationTsRelId()) {

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

			sb.append(_SQL_SELECT_TRAINEEROTATIONTSBLOCKDETAILSREL_WHERE);

			sb.append(
				_FINDER_COLUMN_PROGDURATIONROTATIONTSRELID_PROGDURATIONROTATIONTSRELID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(
					TraineeRotationTsBlockDetailsRelModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(progDurationRotationTsRelId);

				list = (List<TraineeRotationTsBlockDetailsRel>)QueryUtil.list(
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
	 * Returns the first trainee rotation ts block details rel in the ordered set where progDurationRotationTsRelId = &#63;.
	 *
	 * @param progDurationRotationTsRelId the prog duration rotation ts rel ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching trainee rotation ts block details rel
	 * @throws NoSuchTraineeRotationTsBlockDetailsRelException if a matching trainee rotation ts block details rel could not be found
	 */
	@Override
	public TraineeRotationTsBlockDetailsRel
			findByProgDurationRotationTsRelId_First(
				long progDurationRotationTsRelId,
				OrderByComparator<TraineeRotationTsBlockDetailsRel>
					orderByComparator)
		throws NoSuchTraineeRotationTsBlockDetailsRelException {

		TraineeRotationTsBlockDetailsRel traineeRotationTsBlockDetailsRel =
			fetchByProgDurationRotationTsRelId_First(
				progDurationRotationTsRelId, orderByComparator);

		if (traineeRotationTsBlockDetailsRel != null) {
			return traineeRotationTsBlockDetailsRel;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("progDurationRotationTsRelId=");
		sb.append(progDurationRotationTsRelId);

		sb.append("}");

		throw new NoSuchTraineeRotationTsBlockDetailsRelException(
			sb.toString());
	}

	/**
	 * Returns the first trainee rotation ts block details rel in the ordered set where progDurationRotationTsRelId = &#63;.
	 *
	 * @param progDurationRotationTsRelId the prog duration rotation ts rel ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching trainee rotation ts block details rel, or <code>null</code> if a matching trainee rotation ts block details rel could not be found
	 */
	@Override
	public TraineeRotationTsBlockDetailsRel
		fetchByProgDurationRotationTsRelId_First(
			long progDurationRotationTsRelId,
			OrderByComparator<TraineeRotationTsBlockDetailsRel>
				orderByComparator) {

		List<TraineeRotationTsBlockDetailsRel> list =
			findByProgDurationRotationTsRelId(
				progDurationRotationTsRelId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last trainee rotation ts block details rel in the ordered set where progDurationRotationTsRelId = &#63;.
	 *
	 * @param progDurationRotationTsRelId the prog duration rotation ts rel ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching trainee rotation ts block details rel
	 * @throws NoSuchTraineeRotationTsBlockDetailsRelException if a matching trainee rotation ts block details rel could not be found
	 */
	@Override
	public TraineeRotationTsBlockDetailsRel
			findByProgDurationRotationTsRelId_Last(
				long progDurationRotationTsRelId,
				OrderByComparator<TraineeRotationTsBlockDetailsRel>
					orderByComparator)
		throws NoSuchTraineeRotationTsBlockDetailsRelException {

		TraineeRotationTsBlockDetailsRel traineeRotationTsBlockDetailsRel =
			fetchByProgDurationRotationTsRelId_Last(
				progDurationRotationTsRelId, orderByComparator);

		if (traineeRotationTsBlockDetailsRel != null) {
			return traineeRotationTsBlockDetailsRel;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("progDurationRotationTsRelId=");
		sb.append(progDurationRotationTsRelId);

		sb.append("}");

		throw new NoSuchTraineeRotationTsBlockDetailsRelException(
			sb.toString());
	}

	/**
	 * Returns the last trainee rotation ts block details rel in the ordered set where progDurationRotationTsRelId = &#63;.
	 *
	 * @param progDurationRotationTsRelId the prog duration rotation ts rel ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching trainee rotation ts block details rel, or <code>null</code> if a matching trainee rotation ts block details rel could not be found
	 */
	@Override
	public TraineeRotationTsBlockDetailsRel
		fetchByProgDurationRotationTsRelId_Last(
			long progDurationRotationTsRelId,
			OrderByComparator<TraineeRotationTsBlockDetailsRel>
				orderByComparator) {

		int count = countByProgDurationRotationTsRelId(
			progDurationRotationTsRelId);

		if (count == 0) {
			return null;
		}

		List<TraineeRotationTsBlockDetailsRel> list =
			findByProgDurationRotationTsRelId(
				progDurationRotationTsRelId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the trainee rotation ts block details rels before and after the current trainee rotation ts block details rel in the ordered set where progDurationRotationTsRelId = &#63;.
	 *
	 * @param traineeRotationTsBlockDetailsRelId the primary key of the current trainee rotation ts block details rel
	 * @param progDurationRotationTsRelId the prog duration rotation ts rel ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next trainee rotation ts block details rel
	 * @throws NoSuchTraineeRotationTsBlockDetailsRelException if a trainee rotation ts block details rel with the primary key could not be found
	 */
	@Override
	public TraineeRotationTsBlockDetailsRel[]
			findByProgDurationRotationTsRelId_PrevAndNext(
				long traineeRotationTsBlockDetailsRelId,
				long progDurationRotationTsRelId,
				OrderByComparator<TraineeRotationTsBlockDetailsRel>
					orderByComparator)
		throws NoSuchTraineeRotationTsBlockDetailsRelException {

		TraineeRotationTsBlockDetailsRel traineeRotationTsBlockDetailsRel =
			findByPrimaryKey(traineeRotationTsBlockDetailsRelId);

		Session session = null;

		try {
			session = openSession();

			TraineeRotationTsBlockDetailsRel[] array =
				new TraineeRotationTsBlockDetailsRelImpl[3];

			array[0] = getByProgDurationRotationTsRelId_PrevAndNext(
				session, traineeRotationTsBlockDetailsRel,
				progDurationRotationTsRelId, orderByComparator, true);

			array[1] = traineeRotationTsBlockDetailsRel;

			array[2] = getByProgDurationRotationTsRelId_PrevAndNext(
				session, traineeRotationTsBlockDetailsRel,
				progDurationRotationTsRelId, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected TraineeRotationTsBlockDetailsRel
		getByProgDurationRotationTsRelId_PrevAndNext(
			Session session,
			TraineeRotationTsBlockDetailsRel traineeRotationTsBlockDetailsRel,
			long progDurationRotationTsRelId,
			OrderByComparator<TraineeRotationTsBlockDetailsRel>
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

		sb.append(_SQL_SELECT_TRAINEEROTATIONTSBLOCKDETAILSREL_WHERE);

		sb.append(
			_FINDER_COLUMN_PROGDURATIONROTATIONTSRELID_PROGDURATIONROTATIONTSRELID_2);

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
			sb.append(TraineeRotationTsBlockDetailsRelModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(progDurationRotationTsRelId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						traineeRotationTsBlockDetailsRel)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<TraineeRotationTsBlockDetailsRel> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the trainee rotation ts block details rels where progDurationRotationTsRelId = &#63; from the database.
	 *
	 * @param progDurationRotationTsRelId the prog duration rotation ts rel ID
	 */
	@Override
	public void removeByProgDurationRotationTsRelId(
		long progDurationRotationTsRelId) {

		for (TraineeRotationTsBlockDetailsRel traineeRotationTsBlockDetailsRel :
				findByProgDurationRotationTsRelId(
					progDurationRotationTsRelId, QueryUtil.ALL_POS,
					QueryUtil.ALL_POS, null)) {

			remove(traineeRotationTsBlockDetailsRel);
		}
	}

	/**
	 * Returns the number of trainee rotation ts block details rels where progDurationRotationTsRelId = &#63;.
	 *
	 * @param progDurationRotationTsRelId the prog duration rotation ts rel ID
	 * @return the number of matching trainee rotation ts block details rels
	 */
	@Override
	public int countByProgDurationRotationTsRelId(
		long progDurationRotationTsRelId) {

		FinderPath finderPath = _finderPathCountByProgDurationRotationTsRelId;

		Object[] finderArgs = new Object[] {progDurationRotationTsRelId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_TRAINEEROTATIONTSBLOCKDETAILSREL_WHERE);

			sb.append(
				_FINDER_COLUMN_PROGDURATIONROTATIONTSRELID_PROGDURATIONROTATIONTSRELID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(progDurationRotationTsRelId);

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
		_FINDER_COLUMN_PROGDURATIONROTATIONTSRELID_PROGDURATIONROTATIONTSRELID_2 =
			"traineeRotationTsBlockDetailsRel.progDurationRotationTsRelId = ?";

	private FinderPath _finderPathWithPaginationFindByTraineeIdAndStatus;
	private FinderPath _finderPathWithoutPaginationFindByTraineeIdAndStatus;
	private FinderPath _finderPathCountByTraineeIdAndStatus;

	/**
	 * Returns all the trainee rotation ts block details rels where traineeId = &#63; and status = &#63;.
	 *
	 * @param traineeId the trainee ID
	 * @param status the status
	 * @return the matching trainee rotation ts block details rels
	 */
	@Override
	public List<TraineeRotationTsBlockDetailsRel> findByTraineeIdAndStatus(
		long traineeId, String status) {

		return findByTraineeIdAndStatus(
			traineeId, status, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the trainee rotation ts block details rels where traineeId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TraineeRotationTsBlockDetailsRelModelImpl</code>.
	 * </p>
	 *
	 * @param traineeId the trainee ID
	 * @param status the status
	 * @param start the lower bound of the range of trainee rotation ts block details rels
	 * @param end the upper bound of the range of trainee rotation ts block details rels (not inclusive)
	 * @return the range of matching trainee rotation ts block details rels
	 */
	@Override
	public List<TraineeRotationTsBlockDetailsRel> findByTraineeIdAndStatus(
		long traineeId, String status, int start, int end) {

		return findByTraineeIdAndStatus(traineeId, status, start, end, null);
	}

	/**
	 * Returns an ordered range of all the trainee rotation ts block details rels where traineeId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TraineeRotationTsBlockDetailsRelModelImpl</code>.
	 * </p>
	 *
	 * @param traineeId the trainee ID
	 * @param status the status
	 * @param start the lower bound of the range of trainee rotation ts block details rels
	 * @param end the upper bound of the range of trainee rotation ts block details rels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching trainee rotation ts block details rels
	 */
	@Override
	public List<TraineeRotationTsBlockDetailsRel> findByTraineeIdAndStatus(
		long traineeId, String status, int start, int end,
		OrderByComparator<TraineeRotationTsBlockDetailsRel> orderByComparator) {

		return findByTraineeIdAndStatus(
			traineeId, status, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the trainee rotation ts block details rels where traineeId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TraineeRotationTsBlockDetailsRelModelImpl</code>.
	 * </p>
	 *
	 * @param traineeId the trainee ID
	 * @param status the status
	 * @param start the lower bound of the range of trainee rotation ts block details rels
	 * @param end the upper bound of the range of trainee rotation ts block details rels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching trainee rotation ts block details rels
	 */
	@Override
	public List<TraineeRotationTsBlockDetailsRel> findByTraineeIdAndStatus(
		long traineeId, String status, int start, int end,
		OrderByComparator<TraineeRotationTsBlockDetailsRel> orderByComparator,
		boolean useFinderCache) {

		status = Objects.toString(status, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath =
					_finderPathWithoutPaginationFindByTraineeIdAndStatus;
				finderArgs = new Object[] {traineeId, status};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByTraineeIdAndStatus;
			finderArgs = new Object[] {
				traineeId, status, start, end, orderByComparator
			};
		}

		List<TraineeRotationTsBlockDetailsRel> list = null;

		if (useFinderCache) {
			list =
				(List<TraineeRotationTsBlockDetailsRel>)finderCache.getResult(
					finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (TraineeRotationTsBlockDetailsRel
						traineeRotationTsBlockDetailsRel : list) {

					if ((traineeId !=
							traineeRotationTsBlockDetailsRel.getTraineeId()) ||
						!status.equals(
							traineeRotationTsBlockDetailsRel.getStatus())) {

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

			sb.append(_SQL_SELECT_TRAINEEROTATIONTSBLOCKDETAILSREL_WHERE);

			sb.append(_FINDER_COLUMN_TRAINEEIDANDSTATUS_TRAINEEID_2);

			boolean bindStatus = false;

			if (status.isEmpty()) {
				sb.append(_FINDER_COLUMN_TRAINEEIDANDSTATUS_STATUS_3);
			}
			else {
				bindStatus = true;

				sb.append(_FINDER_COLUMN_TRAINEEIDANDSTATUS_STATUS_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(
					TraineeRotationTsBlockDetailsRelModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(traineeId);

				if (bindStatus) {
					queryPos.add(status);
				}

				list = (List<TraineeRotationTsBlockDetailsRel>)QueryUtil.list(
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
	 * Returns the first trainee rotation ts block details rel in the ordered set where traineeId = &#63; and status = &#63;.
	 *
	 * @param traineeId the trainee ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching trainee rotation ts block details rel
	 * @throws NoSuchTraineeRotationTsBlockDetailsRelException if a matching trainee rotation ts block details rel could not be found
	 */
	@Override
	public TraineeRotationTsBlockDetailsRel findByTraineeIdAndStatus_First(
			long traineeId, String status,
			OrderByComparator<TraineeRotationTsBlockDetailsRel>
				orderByComparator)
		throws NoSuchTraineeRotationTsBlockDetailsRelException {

		TraineeRotationTsBlockDetailsRel traineeRotationTsBlockDetailsRel =
			fetchByTraineeIdAndStatus_First(
				traineeId, status, orderByComparator);

		if (traineeRotationTsBlockDetailsRel != null) {
			return traineeRotationTsBlockDetailsRel;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("traineeId=");
		sb.append(traineeId);

		sb.append(", status=");
		sb.append(status);

		sb.append("}");

		throw new NoSuchTraineeRotationTsBlockDetailsRelException(
			sb.toString());
	}

	/**
	 * Returns the first trainee rotation ts block details rel in the ordered set where traineeId = &#63; and status = &#63;.
	 *
	 * @param traineeId the trainee ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching trainee rotation ts block details rel, or <code>null</code> if a matching trainee rotation ts block details rel could not be found
	 */
	@Override
	public TraineeRotationTsBlockDetailsRel fetchByTraineeIdAndStatus_First(
		long traineeId, String status,
		OrderByComparator<TraineeRotationTsBlockDetailsRel> orderByComparator) {

		List<TraineeRotationTsBlockDetailsRel> list = findByTraineeIdAndStatus(
			traineeId, status, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last trainee rotation ts block details rel in the ordered set where traineeId = &#63; and status = &#63;.
	 *
	 * @param traineeId the trainee ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching trainee rotation ts block details rel
	 * @throws NoSuchTraineeRotationTsBlockDetailsRelException if a matching trainee rotation ts block details rel could not be found
	 */
	@Override
	public TraineeRotationTsBlockDetailsRel findByTraineeIdAndStatus_Last(
			long traineeId, String status,
			OrderByComparator<TraineeRotationTsBlockDetailsRel>
				orderByComparator)
		throws NoSuchTraineeRotationTsBlockDetailsRelException {

		TraineeRotationTsBlockDetailsRel traineeRotationTsBlockDetailsRel =
			fetchByTraineeIdAndStatus_Last(
				traineeId, status, orderByComparator);

		if (traineeRotationTsBlockDetailsRel != null) {
			return traineeRotationTsBlockDetailsRel;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("traineeId=");
		sb.append(traineeId);

		sb.append(", status=");
		sb.append(status);

		sb.append("}");

		throw new NoSuchTraineeRotationTsBlockDetailsRelException(
			sb.toString());
	}

	/**
	 * Returns the last trainee rotation ts block details rel in the ordered set where traineeId = &#63; and status = &#63;.
	 *
	 * @param traineeId the trainee ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching trainee rotation ts block details rel, or <code>null</code> if a matching trainee rotation ts block details rel could not be found
	 */
	@Override
	public TraineeRotationTsBlockDetailsRel fetchByTraineeIdAndStatus_Last(
		long traineeId, String status,
		OrderByComparator<TraineeRotationTsBlockDetailsRel> orderByComparator) {

		int count = countByTraineeIdAndStatus(traineeId, status);

		if (count == 0) {
			return null;
		}

		List<TraineeRotationTsBlockDetailsRel> list = findByTraineeIdAndStatus(
			traineeId, status, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the trainee rotation ts block details rels before and after the current trainee rotation ts block details rel in the ordered set where traineeId = &#63; and status = &#63;.
	 *
	 * @param traineeRotationTsBlockDetailsRelId the primary key of the current trainee rotation ts block details rel
	 * @param traineeId the trainee ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next trainee rotation ts block details rel
	 * @throws NoSuchTraineeRotationTsBlockDetailsRelException if a trainee rotation ts block details rel with the primary key could not be found
	 */
	@Override
	public TraineeRotationTsBlockDetailsRel[]
			findByTraineeIdAndStatus_PrevAndNext(
				long traineeRotationTsBlockDetailsRelId, long traineeId,
				String status,
				OrderByComparator<TraineeRotationTsBlockDetailsRel>
					orderByComparator)
		throws NoSuchTraineeRotationTsBlockDetailsRelException {

		status = Objects.toString(status, "");

		TraineeRotationTsBlockDetailsRel traineeRotationTsBlockDetailsRel =
			findByPrimaryKey(traineeRotationTsBlockDetailsRelId);

		Session session = null;

		try {
			session = openSession();

			TraineeRotationTsBlockDetailsRel[] array =
				new TraineeRotationTsBlockDetailsRelImpl[3];

			array[0] = getByTraineeIdAndStatus_PrevAndNext(
				session, traineeRotationTsBlockDetailsRel, traineeId, status,
				orderByComparator, true);

			array[1] = traineeRotationTsBlockDetailsRel;

			array[2] = getByTraineeIdAndStatus_PrevAndNext(
				session, traineeRotationTsBlockDetailsRel, traineeId, status,
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

	protected TraineeRotationTsBlockDetailsRel
		getByTraineeIdAndStatus_PrevAndNext(
			Session session,
			TraineeRotationTsBlockDetailsRel traineeRotationTsBlockDetailsRel,
			long traineeId, String status,
			OrderByComparator<TraineeRotationTsBlockDetailsRel>
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

		sb.append(_SQL_SELECT_TRAINEEROTATIONTSBLOCKDETAILSREL_WHERE);

		sb.append(_FINDER_COLUMN_TRAINEEIDANDSTATUS_TRAINEEID_2);

		boolean bindStatus = false;

		if (status.isEmpty()) {
			sb.append(_FINDER_COLUMN_TRAINEEIDANDSTATUS_STATUS_3);
		}
		else {
			bindStatus = true;

			sb.append(_FINDER_COLUMN_TRAINEEIDANDSTATUS_STATUS_2);
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
			sb.append(TraineeRotationTsBlockDetailsRelModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(traineeId);

		if (bindStatus) {
			queryPos.add(status);
		}

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						traineeRotationTsBlockDetailsRel)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<TraineeRotationTsBlockDetailsRel> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the trainee rotation ts block details rels where traineeId = &#63; and status = &#63; from the database.
	 *
	 * @param traineeId the trainee ID
	 * @param status the status
	 */
	@Override
	public void removeByTraineeIdAndStatus(long traineeId, String status) {
		for (TraineeRotationTsBlockDetailsRel traineeRotationTsBlockDetailsRel :
				findByTraineeIdAndStatus(
					traineeId, status, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(traineeRotationTsBlockDetailsRel);
		}
	}

	/**
	 * Returns the number of trainee rotation ts block details rels where traineeId = &#63; and status = &#63;.
	 *
	 * @param traineeId the trainee ID
	 * @param status the status
	 * @return the number of matching trainee rotation ts block details rels
	 */
	@Override
	public int countByTraineeIdAndStatus(long traineeId, String status) {
		status = Objects.toString(status, "");

		FinderPath finderPath = _finderPathCountByTraineeIdAndStatus;

		Object[] finderArgs = new Object[] {traineeId, status};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_TRAINEEROTATIONTSBLOCKDETAILSREL_WHERE);

			sb.append(_FINDER_COLUMN_TRAINEEIDANDSTATUS_TRAINEEID_2);

			boolean bindStatus = false;

			if (status.isEmpty()) {
				sb.append(_FINDER_COLUMN_TRAINEEIDANDSTATUS_STATUS_3);
			}
			else {
				bindStatus = true;

				sb.append(_FINDER_COLUMN_TRAINEEIDANDSTATUS_STATUS_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(traineeId);

				if (bindStatus) {
					queryPos.add(status);
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

	private static final String _FINDER_COLUMN_TRAINEEIDANDSTATUS_TRAINEEID_2 =
		"traineeRotationTsBlockDetailsRel.traineeId = ? AND ";

	private static final String _FINDER_COLUMN_TRAINEEIDANDSTATUS_STATUS_2 =
		"traineeRotationTsBlockDetailsRel.status = ?";

	private static final String _FINDER_COLUMN_TRAINEEIDANDSTATUS_STATUS_3 =
		"(traineeRotationTsBlockDetailsRel.status IS NULL OR traineeRotationTsBlockDetailsRel.status = '')";

	private FinderPath _finderPathFetchByTraineeIdAndBlocksMetadataDetailsRelId;
	private FinderPath _finderPathCountByTraineeIdAndBlocksMetadataDetailsRelId;

	/**
	 * Returns the trainee rotation ts block details rel where traineeId = &#63; and blocksMetadataDetailsRelId = &#63; or throws a <code>NoSuchTraineeRotationTsBlockDetailsRelException</code> if it could not be found.
	 *
	 * @param traineeId the trainee ID
	 * @param blocksMetadataDetailsRelId the blocks metadata details rel ID
	 * @return the matching trainee rotation ts block details rel
	 * @throws NoSuchTraineeRotationTsBlockDetailsRelException if a matching trainee rotation ts block details rel could not be found
	 */
	@Override
	public TraineeRotationTsBlockDetailsRel
			findByTraineeIdAndBlocksMetadataDetailsRelId(
				long traineeId, long blocksMetadataDetailsRelId)
		throws NoSuchTraineeRotationTsBlockDetailsRelException {

		TraineeRotationTsBlockDetailsRel traineeRotationTsBlockDetailsRel =
			fetchByTraineeIdAndBlocksMetadataDetailsRelId(
				traineeId, blocksMetadataDetailsRelId);

		if (traineeRotationTsBlockDetailsRel == null) {
			StringBundler sb = new StringBundler(6);

			sb.append(_NO_SUCH_ENTITY_WITH_KEY);

			sb.append("traineeId=");
			sb.append(traineeId);

			sb.append(", blocksMetadataDetailsRelId=");
			sb.append(blocksMetadataDetailsRelId);

			sb.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(sb.toString());
			}

			throw new NoSuchTraineeRotationTsBlockDetailsRelException(
				sb.toString());
		}

		return traineeRotationTsBlockDetailsRel;
	}

	/**
	 * Returns the trainee rotation ts block details rel where traineeId = &#63; and blocksMetadataDetailsRelId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param traineeId the trainee ID
	 * @param blocksMetadataDetailsRelId the blocks metadata details rel ID
	 * @return the matching trainee rotation ts block details rel, or <code>null</code> if a matching trainee rotation ts block details rel could not be found
	 */
	@Override
	public TraineeRotationTsBlockDetailsRel
		fetchByTraineeIdAndBlocksMetadataDetailsRelId(
			long traineeId, long blocksMetadataDetailsRelId) {

		return fetchByTraineeIdAndBlocksMetadataDetailsRelId(
			traineeId, blocksMetadataDetailsRelId, true);
	}

	/**
	 * Returns the trainee rotation ts block details rel where traineeId = &#63; and blocksMetadataDetailsRelId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param traineeId the trainee ID
	 * @param blocksMetadataDetailsRelId the blocks metadata details rel ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching trainee rotation ts block details rel, or <code>null</code> if a matching trainee rotation ts block details rel could not be found
	 */
	@Override
	public TraineeRotationTsBlockDetailsRel
		fetchByTraineeIdAndBlocksMetadataDetailsRelId(
			long traineeId, long blocksMetadataDetailsRelId,
			boolean useFinderCache) {

		Object[] finderArgs = null;

		if (useFinderCache) {
			finderArgs = new Object[] {traineeId, blocksMetadataDetailsRelId};
		}

		Object result = null;

		if (useFinderCache) {
			result = finderCache.getResult(
				_finderPathFetchByTraineeIdAndBlocksMetadataDetailsRelId,
				finderArgs, this);
		}

		if (result instanceof TraineeRotationTsBlockDetailsRel) {
			TraineeRotationTsBlockDetailsRel traineeRotationTsBlockDetailsRel =
				(TraineeRotationTsBlockDetailsRel)result;

			if ((traineeId !=
					traineeRotationTsBlockDetailsRel.getTraineeId()) ||
				(blocksMetadataDetailsRelId !=
					traineeRotationTsBlockDetailsRel.
						getBlocksMetadataDetailsRelId())) {

				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_SQL_SELECT_TRAINEEROTATIONTSBLOCKDETAILSREL_WHERE);

			sb.append(
				_FINDER_COLUMN_TRAINEEIDANDBLOCKSMETADATADETAILSRELID_TRAINEEID_2);

			sb.append(
				_FINDER_COLUMN_TRAINEEIDANDBLOCKSMETADATADETAILSRELID_BLOCKSMETADATADETAILSRELID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(traineeId);

				queryPos.add(blocksMetadataDetailsRelId);

				List<TraineeRotationTsBlockDetailsRel> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchByTraineeIdAndBlocksMetadataDetailsRelId,
							finderArgs, list);
					}
				}
				else {
					if (list.size() > 1) {
						Collections.sort(list, Collections.reverseOrder());

						if (_log.isWarnEnabled()) {
							if (!useFinderCache) {
								finderArgs = new Object[] {
									traineeId, blocksMetadataDetailsRelId
								};
							}

							_log.warn(
								"TraineeRotationTsBlockDetailsRelPersistenceImpl.fetchByTraineeIdAndBlocksMetadataDetailsRelId(long, long, boolean) with parameters (" +
									StringUtil.merge(finderArgs) +
										") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
						}
					}

					TraineeRotationTsBlockDetailsRel
						traineeRotationTsBlockDetailsRel = list.get(0);

					result = traineeRotationTsBlockDetailsRel;

					cacheResult(traineeRotationTsBlockDetailsRel);
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
			return (TraineeRotationTsBlockDetailsRel)result;
		}
	}

	/**
	 * Removes the trainee rotation ts block details rel where traineeId = &#63; and blocksMetadataDetailsRelId = &#63; from the database.
	 *
	 * @param traineeId the trainee ID
	 * @param blocksMetadataDetailsRelId the blocks metadata details rel ID
	 * @return the trainee rotation ts block details rel that was removed
	 */
	@Override
	public TraineeRotationTsBlockDetailsRel
			removeByTraineeIdAndBlocksMetadataDetailsRelId(
				long traineeId, long blocksMetadataDetailsRelId)
		throws NoSuchTraineeRotationTsBlockDetailsRelException {

		TraineeRotationTsBlockDetailsRel traineeRotationTsBlockDetailsRel =
			findByTraineeIdAndBlocksMetadataDetailsRelId(
				traineeId, blocksMetadataDetailsRelId);

		return remove(traineeRotationTsBlockDetailsRel);
	}

	/**
	 * Returns the number of trainee rotation ts block details rels where traineeId = &#63; and blocksMetadataDetailsRelId = &#63;.
	 *
	 * @param traineeId the trainee ID
	 * @param blocksMetadataDetailsRelId the blocks metadata details rel ID
	 * @return the number of matching trainee rotation ts block details rels
	 */
	@Override
	public int countByTraineeIdAndBlocksMetadataDetailsRelId(
		long traineeId, long blocksMetadataDetailsRelId) {

		FinderPath finderPath =
			_finderPathCountByTraineeIdAndBlocksMetadataDetailsRelId;

		Object[] finderArgs = new Object[] {
			traineeId, blocksMetadataDetailsRelId
		};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_TRAINEEROTATIONTSBLOCKDETAILSREL_WHERE);

			sb.append(
				_FINDER_COLUMN_TRAINEEIDANDBLOCKSMETADATADETAILSRELID_TRAINEEID_2);

			sb.append(
				_FINDER_COLUMN_TRAINEEIDANDBLOCKSMETADATADETAILSRELID_BLOCKSMETADATADETAILSRELID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(traineeId);

				queryPos.add(blocksMetadataDetailsRelId);

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
		_FINDER_COLUMN_TRAINEEIDANDBLOCKSMETADATADETAILSRELID_TRAINEEID_2 =
			"traineeRotationTsBlockDetailsRel.traineeId = ? AND ";

	private static final String
		_FINDER_COLUMN_TRAINEEIDANDBLOCKSMETADATADETAILSRELID_BLOCKSMETADATADETAILSRELID_2 =
			"traineeRotationTsBlockDetailsRel.blocksMetadataDetailsRelId = ?";

	public TraineeRotationTsBlockDetailsRelPersistenceImpl() {
		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("uuid", "uuid_");
		dbColumnNames.put(
			"traineeRotationTsBlockDetailsRelId",
			"trainee_rotation_ts_block_details_rel_id");
		dbColumnNames.put("groupId", "group_id");
		dbColumnNames.put("companyId", "company_id");
		dbColumnNames.put("createDate", "create_date");
		dbColumnNames.put("modifiedDate", "modified_date");
		dbColumnNames.put("createdBy", "created_by");
		dbColumnNames.put("modifiedBy", "modified_by");
		dbColumnNames.put("traineeId", "trainee_id");
		dbColumnNames.put(
			"blocksMetadataDetailsRelId", "blocks_metadata_details_rel_id");
		dbColumnNames.put(
			"progDurationRotationTsRelId", "progduration_rotation_ts_rel_id");
		dbColumnNames.put(
			"traineeCohortDetailsId", "trainee_cohort_details_id");
		dbColumnNames.put("rotationStatus", "rotation_status");

		setDBColumnNames(dbColumnNames);

		setModelClass(TraineeRotationTsBlockDetailsRel.class);

		setModelImplClass(TraineeRotationTsBlockDetailsRelImpl.class);
		setModelPKClass(long.class);

		setTable(TraineeRotationTsBlockDetailsRelTable.INSTANCE);
	}

	/**
	 * Caches the trainee rotation ts block details rel in the entity cache if it is enabled.
	 *
	 * @param traineeRotationTsBlockDetailsRel the trainee rotation ts block details rel
	 */
	@Override
	public void cacheResult(
		TraineeRotationTsBlockDetailsRel traineeRotationTsBlockDetailsRel) {

		entityCache.putResult(
			TraineeRotationTsBlockDetailsRelImpl.class,
			traineeRotationTsBlockDetailsRel.getPrimaryKey(),
			traineeRotationTsBlockDetailsRel);

		finderCache.putResult(
			_finderPathFetchByUUID_G,
			new Object[] {
				traineeRotationTsBlockDetailsRel.getUuid(),
				traineeRotationTsBlockDetailsRel.getGroupId()
			},
			traineeRotationTsBlockDetailsRel);

		finderCache.putResult(
			_finderPathFetchByTraineeIdAndBlocksMetadataDetailsRelId,
			new Object[] {
				traineeRotationTsBlockDetailsRel.getTraineeId(),
				traineeRotationTsBlockDetailsRel.getBlocksMetadataDetailsRelId()
			},
			traineeRotationTsBlockDetailsRel);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the trainee rotation ts block details rels in the entity cache if it is enabled.
	 *
	 * @param traineeRotationTsBlockDetailsRels the trainee rotation ts block details rels
	 */
	@Override
	public void cacheResult(
		List<TraineeRotationTsBlockDetailsRel>
			traineeRotationTsBlockDetailsRels) {

		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (traineeRotationTsBlockDetailsRels.size() >
				 _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (TraineeRotationTsBlockDetailsRel traineeRotationTsBlockDetailsRel :
				traineeRotationTsBlockDetailsRels) {

			if (entityCache.getResult(
					TraineeRotationTsBlockDetailsRelImpl.class,
					traineeRotationTsBlockDetailsRel.getPrimaryKey()) == null) {

				cacheResult(traineeRotationTsBlockDetailsRel);
			}
		}
	}

	/**
	 * Clears the cache for all trainee rotation ts block details rels.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(TraineeRotationTsBlockDetailsRelImpl.class);

		finderCache.clearCache(TraineeRotationTsBlockDetailsRelImpl.class);
	}

	/**
	 * Clears the cache for the trainee rotation ts block details rel.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(
		TraineeRotationTsBlockDetailsRel traineeRotationTsBlockDetailsRel) {

		entityCache.removeResult(
			TraineeRotationTsBlockDetailsRelImpl.class,
			traineeRotationTsBlockDetailsRel);
	}

	@Override
	public void clearCache(
		List<TraineeRotationTsBlockDetailsRel>
			traineeRotationTsBlockDetailsRels) {

		for (TraineeRotationTsBlockDetailsRel traineeRotationTsBlockDetailsRel :
				traineeRotationTsBlockDetailsRels) {

			entityCache.removeResult(
				TraineeRotationTsBlockDetailsRelImpl.class,
				traineeRotationTsBlockDetailsRel);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(TraineeRotationTsBlockDetailsRelImpl.class);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(
				TraineeRotationTsBlockDetailsRelImpl.class, primaryKey);
		}
	}

	protected void cacheUniqueFindersCache(
		TraineeRotationTsBlockDetailsRelModelImpl
			traineeRotationTsBlockDetailsRelModelImpl) {

		Object[] args = new Object[] {
			traineeRotationTsBlockDetailsRelModelImpl.getUuid(),
			traineeRotationTsBlockDetailsRelModelImpl.getGroupId()
		};

		finderCache.putResult(_finderPathCountByUUID_G, args, Long.valueOf(1));
		finderCache.putResult(
			_finderPathFetchByUUID_G, args,
			traineeRotationTsBlockDetailsRelModelImpl);

		args = new Object[] {
			traineeRotationTsBlockDetailsRelModelImpl.getTraineeId(),
			traineeRotationTsBlockDetailsRelModelImpl.
				getBlocksMetadataDetailsRelId()
		};

		finderCache.putResult(
			_finderPathCountByTraineeIdAndBlocksMetadataDetailsRelId, args,
			Long.valueOf(1));
		finderCache.putResult(
			_finderPathFetchByTraineeIdAndBlocksMetadataDetailsRelId, args,
			traineeRotationTsBlockDetailsRelModelImpl);
	}

	/**
	 * Creates a new trainee rotation ts block details rel with the primary key. Does not add the trainee rotation ts block details rel to the database.
	 *
	 * @param traineeRotationTsBlockDetailsRelId the primary key for the new trainee rotation ts block details rel
	 * @return the new trainee rotation ts block details rel
	 */
	@Override
	public TraineeRotationTsBlockDetailsRel create(
		long traineeRotationTsBlockDetailsRelId) {

		TraineeRotationTsBlockDetailsRel traineeRotationTsBlockDetailsRel =
			new TraineeRotationTsBlockDetailsRelImpl();

		traineeRotationTsBlockDetailsRel.setNew(true);
		traineeRotationTsBlockDetailsRel.setPrimaryKey(
			traineeRotationTsBlockDetailsRelId);

		String uuid = _portalUUID.generate();

		traineeRotationTsBlockDetailsRel.setUuid(uuid);

		traineeRotationTsBlockDetailsRel.setCompanyId(
			CompanyThreadLocal.getCompanyId());

		return traineeRotationTsBlockDetailsRel;
	}

	/**
	 * Removes the trainee rotation ts block details rel with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param traineeRotationTsBlockDetailsRelId the primary key of the trainee rotation ts block details rel
	 * @return the trainee rotation ts block details rel that was removed
	 * @throws NoSuchTraineeRotationTsBlockDetailsRelException if a trainee rotation ts block details rel with the primary key could not be found
	 */
	@Override
	public TraineeRotationTsBlockDetailsRel remove(
			long traineeRotationTsBlockDetailsRelId)
		throws NoSuchTraineeRotationTsBlockDetailsRelException {

		return remove((Serializable)traineeRotationTsBlockDetailsRelId);
	}

	/**
	 * Removes the trainee rotation ts block details rel with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the trainee rotation ts block details rel
	 * @return the trainee rotation ts block details rel that was removed
	 * @throws NoSuchTraineeRotationTsBlockDetailsRelException if a trainee rotation ts block details rel with the primary key could not be found
	 */
	@Override
	public TraineeRotationTsBlockDetailsRel remove(Serializable primaryKey)
		throws NoSuchTraineeRotationTsBlockDetailsRelException {

		Session session = null;

		try {
			session = openSession();

			TraineeRotationTsBlockDetailsRel traineeRotationTsBlockDetailsRel =
				(TraineeRotationTsBlockDetailsRel)session.get(
					TraineeRotationTsBlockDetailsRelImpl.class, primaryKey);

			if (traineeRotationTsBlockDetailsRel == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchTraineeRotationTsBlockDetailsRelException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(traineeRotationTsBlockDetailsRel);
		}
		catch (NoSuchTraineeRotationTsBlockDetailsRelException
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
	protected TraineeRotationTsBlockDetailsRel removeImpl(
		TraineeRotationTsBlockDetailsRel traineeRotationTsBlockDetailsRel) {

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(traineeRotationTsBlockDetailsRel)) {
				traineeRotationTsBlockDetailsRel =
					(TraineeRotationTsBlockDetailsRel)session.get(
						TraineeRotationTsBlockDetailsRelImpl.class,
						traineeRotationTsBlockDetailsRel.getPrimaryKeyObj());
			}

			if (traineeRotationTsBlockDetailsRel != null) {
				session.delete(traineeRotationTsBlockDetailsRel);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (traineeRotationTsBlockDetailsRel != null) {
			clearCache(traineeRotationTsBlockDetailsRel);
		}

		return traineeRotationTsBlockDetailsRel;
	}

	@Override
	public TraineeRotationTsBlockDetailsRel updateImpl(
		TraineeRotationTsBlockDetailsRel traineeRotationTsBlockDetailsRel) {

		boolean isNew = traineeRotationTsBlockDetailsRel.isNew();

		if (!(traineeRotationTsBlockDetailsRel instanceof
				TraineeRotationTsBlockDetailsRelModelImpl)) {

			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(
					traineeRotationTsBlockDetailsRel.getClass())) {

				invocationHandler = ProxyUtil.getInvocationHandler(
					traineeRotationTsBlockDetailsRel);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in traineeRotationTsBlockDetailsRel proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom TraineeRotationTsBlockDetailsRel implementation " +
					traineeRotationTsBlockDetailsRel.getClass());
		}

		TraineeRotationTsBlockDetailsRelModelImpl
			traineeRotationTsBlockDetailsRelModelImpl =
				(TraineeRotationTsBlockDetailsRelModelImpl)
					traineeRotationTsBlockDetailsRel;

		if (Validator.isNull(traineeRotationTsBlockDetailsRel.getUuid())) {
			String uuid = _portalUUID.generate();

			traineeRotationTsBlockDetailsRel.setUuid(uuid);
		}

		ServiceContext serviceContext =
			ServiceContextThreadLocal.getServiceContext();

		Date date = new Date();

		if (isNew &&
			(traineeRotationTsBlockDetailsRel.getCreateDate() == null)) {

			if (serviceContext == null) {
				traineeRotationTsBlockDetailsRel.setCreateDate(date);
			}
			else {
				traineeRotationTsBlockDetailsRel.setCreateDate(
					serviceContext.getCreateDate(date));
			}
		}

		if (!traineeRotationTsBlockDetailsRelModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				traineeRotationTsBlockDetailsRel.setModifiedDate(date);
			}
			else {
				traineeRotationTsBlockDetailsRel.setModifiedDate(
					serviceContext.getModifiedDate(date));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(traineeRotationTsBlockDetailsRel);
			}
			else {
				traineeRotationTsBlockDetailsRel =
					(TraineeRotationTsBlockDetailsRel)session.merge(
						traineeRotationTsBlockDetailsRel);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(
			TraineeRotationTsBlockDetailsRelImpl.class,
			traineeRotationTsBlockDetailsRelModelImpl, false, true);

		cacheUniqueFindersCache(traineeRotationTsBlockDetailsRelModelImpl);

		if (isNew) {
			traineeRotationTsBlockDetailsRel.setNew(false);
		}

		traineeRotationTsBlockDetailsRel.resetOriginalValues();

		return traineeRotationTsBlockDetailsRel;
	}

	/**
	 * Returns the trainee rotation ts block details rel with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the trainee rotation ts block details rel
	 * @return the trainee rotation ts block details rel
	 * @throws NoSuchTraineeRotationTsBlockDetailsRelException if a trainee rotation ts block details rel with the primary key could not be found
	 */
	@Override
	public TraineeRotationTsBlockDetailsRel findByPrimaryKey(
			Serializable primaryKey)
		throws NoSuchTraineeRotationTsBlockDetailsRelException {

		TraineeRotationTsBlockDetailsRel traineeRotationTsBlockDetailsRel =
			fetchByPrimaryKey(primaryKey);

		if (traineeRotationTsBlockDetailsRel == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchTraineeRotationTsBlockDetailsRelException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return traineeRotationTsBlockDetailsRel;
	}

	/**
	 * Returns the trainee rotation ts block details rel with the primary key or throws a <code>NoSuchTraineeRotationTsBlockDetailsRelException</code> if it could not be found.
	 *
	 * @param traineeRotationTsBlockDetailsRelId the primary key of the trainee rotation ts block details rel
	 * @return the trainee rotation ts block details rel
	 * @throws NoSuchTraineeRotationTsBlockDetailsRelException if a trainee rotation ts block details rel with the primary key could not be found
	 */
	@Override
	public TraineeRotationTsBlockDetailsRel findByPrimaryKey(
			long traineeRotationTsBlockDetailsRelId)
		throws NoSuchTraineeRotationTsBlockDetailsRelException {

		return findByPrimaryKey(
			(Serializable)traineeRotationTsBlockDetailsRelId);
	}

	/**
	 * Returns the trainee rotation ts block details rel with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param traineeRotationTsBlockDetailsRelId the primary key of the trainee rotation ts block details rel
	 * @return the trainee rotation ts block details rel, or <code>null</code> if a trainee rotation ts block details rel with the primary key could not be found
	 */
	@Override
	public TraineeRotationTsBlockDetailsRel fetchByPrimaryKey(
		long traineeRotationTsBlockDetailsRelId) {

		return fetchByPrimaryKey(
			(Serializable)traineeRotationTsBlockDetailsRelId);
	}

	/**
	 * Returns all the trainee rotation ts block details rels.
	 *
	 * @return the trainee rotation ts block details rels
	 */
	@Override
	public List<TraineeRotationTsBlockDetailsRel> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the trainee rotation ts block details rels.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TraineeRotationTsBlockDetailsRelModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of trainee rotation ts block details rels
	 * @param end the upper bound of the range of trainee rotation ts block details rels (not inclusive)
	 * @return the range of trainee rotation ts block details rels
	 */
	@Override
	public List<TraineeRotationTsBlockDetailsRel> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the trainee rotation ts block details rels.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TraineeRotationTsBlockDetailsRelModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of trainee rotation ts block details rels
	 * @param end the upper bound of the range of trainee rotation ts block details rels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of trainee rotation ts block details rels
	 */
	@Override
	public List<TraineeRotationTsBlockDetailsRel> findAll(
		int start, int end,
		OrderByComparator<TraineeRotationTsBlockDetailsRel> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the trainee rotation ts block details rels.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TraineeRotationTsBlockDetailsRelModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of trainee rotation ts block details rels
	 * @param end the upper bound of the range of trainee rotation ts block details rels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of trainee rotation ts block details rels
	 */
	@Override
	public List<TraineeRotationTsBlockDetailsRel> findAll(
		int start, int end,
		OrderByComparator<TraineeRotationTsBlockDetailsRel> orderByComparator,
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

		List<TraineeRotationTsBlockDetailsRel> list = null;

		if (useFinderCache) {
			list =
				(List<TraineeRotationTsBlockDetailsRel>)finderCache.getResult(
					finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_TRAINEEROTATIONTSBLOCKDETAILSREL);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_TRAINEEROTATIONTSBLOCKDETAILSREL;

				sql = sql.concat(
					TraineeRotationTsBlockDetailsRelModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<TraineeRotationTsBlockDetailsRel>)QueryUtil.list(
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
	 * Removes all the trainee rotation ts block details rels from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (TraineeRotationTsBlockDetailsRel traineeRotationTsBlockDetailsRel :
				findAll()) {

			remove(traineeRotationTsBlockDetailsRel);
		}
	}

	/**
	 * Returns the number of trainee rotation ts block details rels.
	 *
	 * @return the number of trainee rotation ts block details rels
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
					_SQL_COUNT_TRAINEEROTATIONTSBLOCKDETAILSREL);

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
		return "trainee_rotation_ts_block_details_rel_id";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_TRAINEEROTATIONTSBLOCKDETAILSREL;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return TraineeRotationTsBlockDetailsRelModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the trainee rotation ts block details rel persistence.
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

		_finderPathWithPaginationFindByBlocksMetadataDetailsRelId =
			new FinderPath(
				FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
				"findByBlocksMetadataDetailsRelId",
				new String[] {
					Long.class.getName(), Integer.class.getName(),
					Integer.class.getName(), OrderByComparator.class.getName()
				},
				new String[] {"blocks_metadata_details_rel_id"}, true);

		_finderPathWithoutPaginationFindByBlocksMetadataDetailsRelId =
			new FinderPath(
				FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
				"findByBlocksMetadataDetailsRelId",
				new String[] {Long.class.getName()},
				new String[] {"blocks_metadata_details_rel_id"}, true);

		_finderPathCountByBlocksMetadataDetailsRelId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByBlocksMetadataDetailsRelId",
			new String[] {Long.class.getName()},
			new String[] {"blocks_metadata_details_rel_id"}, false);

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

		_finderPathWithPaginationFindByProgDurationRotationTsRelId =
			new FinderPath(
				FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
				"findByProgDurationRotationTsRelId",
				new String[] {
					Long.class.getName(), Integer.class.getName(),
					Integer.class.getName(), OrderByComparator.class.getName()
				},
				new String[] {"progduration_rotation_ts_rel_id"}, true);

		_finderPathWithoutPaginationFindByProgDurationRotationTsRelId =
			new FinderPath(
				FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
				"findByProgDurationRotationTsRelId",
				new String[] {Long.class.getName()},
				new String[] {"progduration_rotation_ts_rel_id"}, true);

		_finderPathCountByProgDurationRotationTsRelId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByProgDurationRotationTsRelId",
			new String[] {Long.class.getName()},
			new String[] {"progduration_rotation_ts_rel_id"}, false);

		_finderPathWithPaginationFindByTraineeIdAndStatus = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByTraineeIdAndStatus",
			new String[] {
				Long.class.getName(), String.class.getName(),
				Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			},
			new String[] {"trainee_id", "status"}, true);

		_finderPathWithoutPaginationFindByTraineeIdAndStatus = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByTraineeIdAndStatus",
			new String[] {Long.class.getName(), String.class.getName()},
			new String[] {"trainee_id", "status"}, true);

		_finderPathCountByTraineeIdAndStatus = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByTraineeIdAndStatus",
			new String[] {Long.class.getName(), String.class.getName()},
			new String[] {"trainee_id", "status"}, false);

		_finderPathFetchByTraineeIdAndBlocksMetadataDetailsRelId =
			new FinderPath(
				FINDER_CLASS_NAME_ENTITY,
				"fetchByTraineeIdAndBlocksMetadataDetailsRelId",
				new String[] {Long.class.getName(), Long.class.getName()},
				new String[] {"trainee_id", "blocks_metadata_details_rel_id"},
				true);

		_finderPathCountByTraineeIdAndBlocksMetadataDetailsRelId =
			new FinderPath(
				FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
				"countByTraineeIdAndBlocksMetadataDetailsRelId",
				new String[] {Long.class.getName(), Long.class.getName()},
				new String[] {"trainee_id", "blocks_metadata_details_rel_id"},
				false);

		_setTraineeRotationTsBlockDetailsRelUtilPersistence(this);
	}

	@Deactivate
	public void deactivate() {
		_setTraineeRotationTsBlockDetailsRelUtilPersistence(null);

		entityCache.removeCache(
			TraineeRotationTsBlockDetailsRelImpl.class.getName());
	}

	private void _setTraineeRotationTsBlockDetailsRelUtilPersistence(
		TraineeRotationTsBlockDetailsRelPersistence
			traineeRotationTsBlockDetailsRelPersistence) {

		try {
			Field field =
				TraineeRotationTsBlockDetailsRelUtil.class.getDeclaredField(
					"_persistence");

			field.setAccessible(true);

			field.set(null, traineeRotationTsBlockDetailsRelPersistence);
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

	private static final String _SQL_SELECT_TRAINEEROTATIONTSBLOCKDETAILSREL =
		"SELECT traineeRotationTsBlockDetailsRel FROM TraineeRotationTsBlockDetailsRel traineeRotationTsBlockDetailsRel";

	private static final String
		_SQL_SELECT_TRAINEEROTATIONTSBLOCKDETAILSREL_WHERE =
			"SELECT traineeRotationTsBlockDetailsRel FROM TraineeRotationTsBlockDetailsRel traineeRotationTsBlockDetailsRel WHERE ";

	private static final String _SQL_COUNT_TRAINEEROTATIONTSBLOCKDETAILSREL =
		"SELECT COUNT(traineeRotationTsBlockDetailsRel) FROM TraineeRotationTsBlockDetailsRel traineeRotationTsBlockDetailsRel";

	private static final String
		_SQL_COUNT_TRAINEEROTATIONTSBLOCKDETAILSREL_WHERE =
			"SELECT COUNT(traineeRotationTsBlockDetailsRel) FROM TraineeRotationTsBlockDetailsRel traineeRotationTsBlockDetailsRel WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS =
		"traineeRotationTsBlockDetailsRel.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No TraineeRotationTsBlockDetailsRel exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No TraineeRotationTsBlockDetailsRel exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		TraineeRotationTsBlockDetailsRelPersistenceImpl.class);

	private static final Set<String> _badColumnNames = SetUtil.fromArray(
		new String[] {
			"uuid", "traineeRotationTsBlockDetailsRelId", "groupId",
			"companyId", "createDate", "modifiedDate", "createdBy",
			"modifiedBy", "traineeId", "blocksMetadataDetailsRelId",
			"progDurationRotationTsRelId", "traineeCohortDetailsId",
			"rotationStatus"
		});

	@Override
	protected FinderCache getFinderCache() {
		return finderCache;
	}

	@Reference
	private PortalUUID _portalUUID;

}
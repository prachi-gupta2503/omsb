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

import gov.omsb.tms.exception.NoSuchSharedRotationRequestDetailsException;
import gov.omsb.tms.model.SharedRotationRequestDetails;
import gov.omsb.tms.model.SharedRotationRequestDetailsTable;
import gov.omsb.tms.model.impl.SharedRotationRequestDetailsImpl;
import gov.omsb.tms.model.impl.SharedRotationRequestDetailsModelImpl;
import gov.omsb.tms.service.persistence.SharedRotationRequestDetailsPersistence;
import gov.omsb.tms.service.persistence.SharedRotationRequestDetailsUtil;
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
 * The persistence implementation for the shared rotation request details service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = SharedRotationRequestDetailsPersistence.class)
public class SharedRotationRequestDetailsPersistenceImpl
	extends BasePersistenceImpl<SharedRotationRequestDetails>
	implements SharedRotationRequestDetailsPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>SharedRotationRequestDetailsUtil</code> to access the shared rotation request details persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		SharedRotationRequestDetailsImpl.class.getName();

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
	 * Returns all the shared rotation request detailses where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching shared rotation request detailses
	 */
	@Override
	public List<SharedRotationRequestDetails> findByUuid(String uuid) {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the shared rotation request detailses where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SharedRotationRequestDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of shared rotation request detailses
	 * @param end the upper bound of the range of shared rotation request detailses (not inclusive)
	 * @return the range of matching shared rotation request detailses
	 */
	@Override
	public List<SharedRotationRequestDetails> findByUuid(
		String uuid, int start, int end) {

		return findByUuid(uuid, start, end, null);
	}

	/**
	 * Returns an ordered range of all the shared rotation request detailses where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SharedRotationRequestDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of shared rotation request detailses
	 * @param end the upper bound of the range of shared rotation request detailses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching shared rotation request detailses
	 */
	@Override
	public List<SharedRotationRequestDetails> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<SharedRotationRequestDetails> orderByComparator) {

		return findByUuid(uuid, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the shared rotation request detailses where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SharedRotationRequestDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of shared rotation request detailses
	 * @param end the upper bound of the range of shared rotation request detailses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching shared rotation request detailses
	 */
	@Override
	public List<SharedRotationRequestDetails> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<SharedRotationRequestDetails> orderByComparator,
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

		List<SharedRotationRequestDetails> list = null;

		if (useFinderCache) {
			list = (List<SharedRotationRequestDetails>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (SharedRotationRequestDetails sharedRotationRequestDetails :
						list) {

					if (!uuid.equals(sharedRotationRequestDetails.getUuid())) {
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

			sb.append(_SQL_SELECT_SHAREDROTATIONREQUESTDETAILS_WHERE);

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
				sb.append(SharedRotationRequestDetailsModelImpl.ORDER_BY_JPQL);
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

				list = (List<SharedRotationRequestDetails>)QueryUtil.list(
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
	 * Returns the first shared rotation request details in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching shared rotation request details
	 * @throws NoSuchSharedRotationRequestDetailsException if a matching shared rotation request details could not be found
	 */
	@Override
	public SharedRotationRequestDetails findByUuid_First(
			String uuid,
			OrderByComparator<SharedRotationRequestDetails> orderByComparator)
		throws NoSuchSharedRotationRequestDetailsException {

		SharedRotationRequestDetails sharedRotationRequestDetails =
			fetchByUuid_First(uuid, orderByComparator);

		if (sharedRotationRequestDetails != null) {
			return sharedRotationRequestDetails;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchSharedRotationRequestDetailsException(sb.toString());
	}

	/**
	 * Returns the first shared rotation request details in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching shared rotation request details, or <code>null</code> if a matching shared rotation request details could not be found
	 */
	@Override
	public SharedRotationRequestDetails fetchByUuid_First(
		String uuid,
		OrderByComparator<SharedRotationRequestDetails> orderByComparator) {

		List<SharedRotationRequestDetails> list = findByUuid(
			uuid, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last shared rotation request details in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching shared rotation request details
	 * @throws NoSuchSharedRotationRequestDetailsException if a matching shared rotation request details could not be found
	 */
	@Override
	public SharedRotationRequestDetails findByUuid_Last(
			String uuid,
			OrderByComparator<SharedRotationRequestDetails> orderByComparator)
		throws NoSuchSharedRotationRequestDetailsException {

		SharedRotationRequestDetails sharedRotationRequestDetails =
			fetchByUuid_Last(uuid, orderByComparator);

		if (sharedRotationRequestDetails != null) {
			return sharedRotationRequestDetails;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchSharedRotationRequestDetailsException(sb.toString());
	}

	/**
	 * Returns the last shared rotation request details in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching shared rotation request details, or <code>null</code> if a matching shared rotation request details could not be found
	 */
	@Override
	public SharedRotationRequestDetails fetchByUuid_Last(
		String uuid,
		OrderByComparator<SharedRotationRequestDetails> orderByComparator) {

		int count = countByUuid(uuid);

		if (count == 0) {
			return null;
		}

		List<SharedRotationRequestDetails> list = findByUuid(
			uuid, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the shared rotation request detailses before and after the current shared rotation request details in the ordered set where uuid = &#63;.
	 *
	 * @param sharedRotationRequestDetailsId the primary key of the current shared rotation request details
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next shared rotation request details
	 * @throws NoSuchSharedRotationRequestDetailsException if a shared rotation request details with the primary key could not be found
	 */
	@Override
	public SharedRotationRequestDetails[] findByUuid_PrevAndNext(
			long sharedRotationRequestDetailsId, String uuid,
			OrderByComparator<SharedRotationRequestDetails> orderByComparator)
		throws NoSuchSharedRotationRequestDetailsException {

		uuid = Objects.toString(uuid, "");

		SharedRotationRequestDetails sharedRotationRequestDetails =
			findByPrimaryKey(sharedRotationRequestDetailsId);

		Session session = null;

		try {
			session = openSession();

			SharedRotationRequestDetails[] array =
				new SharedRotationRequestDetailsImpl[3];

			array[0] = getByUuid_PrevAndNext(
				session, sharedRotationRequestDetails, uuid, orderByComparator,
				true);

			array[1] = sharedRotationRequestDetails;

			array[2] = getByUuid_PrevAndNext(
				session, sharedRotationRequestDetails, uuid, orderByComparator,
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

	protected SharedRotationRequestDetails getByUuid_PrevAndNext(
		Session session,
		SharedRotationRequestDetails sharedRotationRequestDetails, String uuid,
		OrderByComparator<SharedRotationRequestDetails> orderByComparator,
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

		sb.append(_SQL_SELECT_SHAREDROTATIONREQUESTDETAILS_WHERE);

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
			sb.append(SharedRotationRequestDetailsModelImpl.ORDER_BY_JPQL);
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
						sharedRotationRequestDetails)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<SharedRotationRequestDetails> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the shared rotation request detailses where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	@Override
	public void removeByUuid(String uuid) {
		for (SharedRotationRequestDetails sharedRotationRequestDetails :
				findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(sharedRotationRequestDetails);
		}
	}

	/**
	 * Returns the number of shared rotation request detailses where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching shared rotation request detailses
	 */
	@Override
	public int countByUuid(String uuid) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid;

		Object[] finderArgs = new Object[] {uuid};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_SHAREDROTATIONREQUESTDETAILS_WHERE);

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
		"sharedRotationRequestDetails.uuid = ?";

	private static final String _FINDER_COLUMN_UUID_UUID_3 =
		"(sharedRotationRequestDetails.uuid IS NULL OR sharedRotationRequestDetails.uuid = '')";

	private FinderPath _finderPathFetchByUUID_G;
	private FinderPath _finderPathCountByUUID_G;

	/**
	 * Returns the shared rotation request details where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchSharedRotationRequestDetailsException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching shared rotation request details
	 * @throws NoSuchSharedRotationRequestDetailsException if a matching shared rotation request details could not be found
	 */
	@Override
	public SharedRotationRequestDetails findByUUID_G(String uuid, long groupId)
		throws NoSuchSharedRotationRequestDetailsException {

		SharedRotationRequestDetails sharedRotationRequestDetails =
			fetchByUUID_G(uuid, groupId);

		if (sharedRotationRequestDetails == null) {
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

			throw new NoSuchSharedRotationRequestDetailsException(
				sb.toString());
		}

		return sharedRotationRequestDetails;
	}

	/**
	 * Returns the shared rotation request details where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching shared rotation request details, or <code>null</code> if a matching shared rotation request details could not be found
	 */
	@Override
	public SharedRotationRequestDetails fetchByUUID_G(
		String uuid, long groupId) {

		return fetchByUUID_G(uuid, groupId, true);
	}

	/**
	 * Returns the shared rotation request details where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching shared rotation request details, or <code>null</code> if a matching shared rotation request details could not be found
	 */
	@Override
	public SharedRotationRequestDetails fetchByUUID_G(
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

		if (result instanceof SharedRotationRequestDetails) {
			SharedRotationRequestDetails sharedRotationRequestDetails =
				(SharedRotationRequestDetails)result;

			if (!Objects.equals(uuid, sharedRotationRequestDetails.getUuid()) ||
				(groupId != sharedRotationRequestDetails.getGroupId())) {

				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_SQL_SELECT_SHAREDROTATIONREQUESTDETAILS_WHERE);

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

				List<SharedRotationRequestDetails> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchByUUID_G, finderArgs, list);
					}
				}
				else {
					SharedRotationRequestDetails sharedRotationRequestDetails =
						list.get(0);

					result = sharedRotationRequestDetails;

					cacheResult(sharedRotationRequestDetails);
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
			return (SharedRotationRequestDetails)result;
		}
	}

	/**
	 * Removes the shared rotation request details where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the shared rotation request details that was removed
	 */
	@Override
	public SharedRotationRequestDetails removeByUUID_G(
			String uuid, long groupId)
		throws NoSuchSharedRotationRequestDetailsException {

		SharedRotationRequestDetails sharedRotationRequestDetails =
			findByUUID_G(uuid, groupId);

		return remove(sharedRotationRequestDetails);
	}

	/**
	 * Returns the number of shared rotation request detailses where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching shared rotation request detailses
	 */
	@Override
	public int countByUUID_G(String uuid, long groupId) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUUID_G;

		Object[] finderArgs = new Object[] {uuid, groupId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_SHAREDROTATIONREQUESTDETAILS_WHERE);

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
		"sharedRotationRequestDetails.uuid = ? AND ";

	private static final String _FINDER_COLUMN_UUID_G_UUID_3 =
		"(sharedRotationRequestDetails.uuid IS NULL OR sharedRotationRequestDetails.uuid = '') AND ";

	private static final String _FINDER_COLUMN_UUID_G_GROUPID_2 =
		"sharedRotationRequestDetails.groupId = ?";

	private FinderPath _finderPathWithPaginationFindByUuid_C;
	private FinderPath _finderPathWithoutPaginationFindByUuid_C;
	private FinderPath _finderPathCountByUuid_C;

	/**
	 * Returns all the shared rotation request detailses where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching shared rotation request detailses
	 */
	@Override
	public List<SharedRotationRequestDetails> findByUuid_C(
		String uuid, long companyId) {

		return findByUuid_C(
			uuid, companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the shared rotation request detailses where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SharedRotationRequestDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of shared rotation request detailses
	 * @param end the upper bound of the range of shared rotation request detailses (not inclusive)
	 * @return the range of matching shared rotation request detailses
	 */
	@Override
	public List<SharedRotationRequestDetails> findByUuid_C(
		String uuid, long companyId, int start, int end) {

		return findByUuid_C(uuid, companyId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the shared rotation request detailses where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SharedRotationRequestDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of shared rotation request detailses
	 * @param end the upper bound of the range of shared rotation request detailses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching shared rotation request detailses
	 */
	@Override
	public List<SharedRotationRequestDetails> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<SharedRotationRequestDetails> orderByComparator) {

		return findByUuid_C(
			uuid, companyId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the shared rotation request detailses where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SharedRotationRequestDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of shared rotation request detailses
	 * @param end the upper bound of the range of shared rotation request detailses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching shared rotation request detailses
	 */
	@Override
	public List<SharedRotationRequestDetails> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<SharedRotationRequestDetails> orderByComparator,
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

		List<SharedRotationRequestDetails> list = null;

		if (useFinderCache) {
			list = (List<SharedRotationRequestDetails>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (SharedRotationRequestDetails sharedRotationRequestDetails :
						list) {

					if (!uuid.equals(sharedRotationRequestDetails.getUuid()) ||
						(companyId !=
							sharedRotationRequestDetails.getCompanyId())) {

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

			sb.append(_SQL_SELECT_SHAREDROTATIONREQUESTDETAILS_WHERE);

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
				sb.append(SharedRotationRequestDetailsModelImpl.ORDER_BY_JPQL);
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

				list = (List<SharedRotationRequestDetails>)QueryUtil.list(
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
	 * Returns the first shared rotation request details in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching shared rotation request details
	 * @throws NoSuchSharedRotationRequestDetailsException if a matching shared rotation request details could not be found
	 */
	@Override
	public SharedRotationRequestDetails findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<SharedRotationRequestDetails> orderByComparator)
		throws NoSuchSharedRotationRequestDetailsException {

		SharedRotationRequestDetails sharedRotationRequestDetails =
			fetchByUuid_C_First(uuid, companyId, orderByComparator);

		if (sharedRotationRequestDetails != null) {
			return sharedRotationRequestDetails;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append(", companyId=");
		sb.append(companyId);

		sb.append("}");

		throw new NoSuchSharedRotationRequestDetailsException(sb.toString());
	}

	/**
	 * Returns the first shared rotation request details in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching shared rotation request details, or <code>null</code> if a matching shared rotation request details could not be found
	 */
	@Override
	public SharedRotationRequestDetails fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<SharedRotationRequestDetails> orderByComparator) {

		List<SharedRotationRequestDetails> list = findByUuid_C(
			uuid, companyId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last shared rotation request details in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching shared rotation request details
	 * @throws NoSuchSharedRotationRequestDetailsException if a matching shared rotation request details could not be found
	 */
	@Override
	public SharedRotationRequestDetails findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<SharedRotationRequestDetails> orderByComparator)
		throws NoSuchSharedRotationRequestDetailsException {

		SharedRotationRequestDetails sharedRotationRequestDetails =
			fetchByUuid_C_Last(uuid, companyId, orderByComparator);

		if (sharedRotationRequestDetails != null) {
			return sharedRotationRequestDetails;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append(", companyId=");
		sb.append(companyId);

		sb.append("}");

		throw new NoSuchSharedRotationRequestDetailsException(sb.toString());
	}

	/**
	 * Returns the last shared rotation request details in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching shared rotation request details, or <code>null</code> if a matching shared rotation request details could not be found
	 */
	@Override
	public SharedRotationRequestDetails fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<SharedRotationRequestDetails> orderByComparator) {

		int count = countByUuid_C(uuid, companyId);

		if (count == 0) {
			return null;
		}

		List<SharedRotationRequestDetails> list = findByUuid_C(
			uuid, companyId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the shared rotation request detailses before and after the current shared rotation request details in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param sharedRotationRequestDetailsId the primary key of the current shared rotation request details
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next shared rotation request details
	 * @throws NoSuchSharedRotationRequestDetailsException if a shared rotation request details with the primary key could not be found
	 */
	@Override
	public SharedRotationRequestDetails[] findByUuid_C_PrevAndNext(
			long sharedRotationRequestDetailsId, String uuid, long companyId,
			OrderByComparator<SharedRotationRequestDetails> orderByComparator)
		throws NoSuchSharedRotationRequestDetailsException {

		uuid = Objects.toString(uuid, "");

		SharedRotationRequestDetails sharedRotationRequestDetails =
			findByPrimaryKey(sharedRotationRequestDetailsId);

		Session session = null;

		try {
			session = openSession();

			SharedRotationRequestDetails[] array =
				new SharedRotationRequestDetailsImpl[3];

			array[0] = getByUuid_C_PrevAndNext(
				session, sharedRotationRequestDetails, uuid, companyId,
				orderByComparator, true);

			array[1] = sharedRotationRequestDetails;

			array[2] = getByUuid_C_PrevAndNext(
				session, sharedRotationRequestDetails, uuid, companyId,
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

	protected SharedRotationRequestDetails getByUuid_C_PrevAndNext(
		Session session,
		SharedRotationRequestDetails sharedRotationRequestDetails, String uuid,
		long companyId,
		OrderByComparator<SharedRotationRequestDetails> orderByComparator,
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

		sb.append(_SQL_SELECT_SHAREDROTATIONREQUESTDETAILS_WHERE);

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
			sb.append(SharedRotationRequestDetailsModelImpl.ORDER_BY_JPQL);
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
						sharedRotationRequestDetails)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<SharedRotationRequestDetails> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the shared rotation request detailses where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	@Override
	public void removeByUuid_C(String uuid, long companyId) {
		for (SharedRotationRequestDetails sharedRotationRequestDetails :
				findByUuid_C(
					uuid, companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(sharedRotationRequestDetails);
		}
	}

	/**
	 * Returns the number of shared rotation request detailses where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching shared rotation request detailses
	 */
	@Override
	public int countByUuid_C(String uuid, long companyId) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid_C;

		Object[] finderArgs = new Object[] {uuid, companyId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_SHAREDROTATIONREQUESTDETAILS_WHERE);

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
		"sharedRotationRequestDetails.uuid = ? AND ";

	private static final String _FINDER_COLUMN_UUID_C_UUID_3 =
		"(sharedRotationRequestDetails.uuid IS NULL OR sharedRotationRequestDetails.uuid = '') AND ";

	private static final String _FINDER_COLUMN_UUID_C_COMPANYID_2 =
		"sharedRotationRequestDetails.companyId = ?";

	private FinderPath _finderPathWithPaginationFindByRequestRaisedBy;
	private FinderPath _finderPathWithoutPaginationFindByRequestRaisedBy;
	private FinderPath _finderPathCountByRequestRaisedBy;

	/**
	 * Returns all the shared rotation request detailses where requestRaisedBy = &#63;.
	 *
	 * @param requestRaisedBy the request raised by
	 * @return the matching shared rotation request detailses
	 */
	@Override
	public List<SharedRotationRequestDetails> findByRequestRaisedBy(
		String requestRaisedBy) {

		return findByRequestRaisedBy(
			requestRaisedBy, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the shared rotation request detailses where requestRaisedBy = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SharedRotationRequestDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param requestRaisedBy the request raised by
	 * @param start the lower bound of the range of shared rotation request detailses
	 * @param end the upper bound of the range of shared rotation request detailses (not inclusive)
	 * @return the range of matching shared rotation request detailses
	 */
	@Override
	public List<SharedRotationRequestDetails> findByRequestRaisedBy(
		String requestRaisedBy, int start, int end) {

		return findByRequestRaisedBy(requestRaisedBy, start, end, null);
	}

	/**
	 * Returns an ordered range of all the shared rotation request detailses where requestRaisedBy = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SharedRotationRequestDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param requestRaisedBy the request raised by
	 * @param start the lower bound of the range of shared rotation request detailses
	 * @param end the upper bound of the range of shared rotation request detailses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching shared rotation request detailses
	 */
	@Override
	public List<SharedRotationRequestDetails> findByRequestRaisedBy(
		String requestRaisedBy, int start, int end,
		OrderByComparator<SharedRotationRequestDetails> orderByComparator) {

		return findByRequestRaisedBy(
			requestRaisedBy, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the shared rotation request detailses where requestRaisedBy = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SharedRotationRequestDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param requestRaisedBy the request raised by
	 * @param start the lower bound of the range of shared rotation request detailses
	 * @param end the upper bound of the range of shared rotation request detailses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching shared rotation request detailses
	 */
	@Override
	public List<SharedRotationRequestDetails> findByRequestRaisedBy(
		String requestRaisedBy, int start, int end,
		OrderByComparator<SharedRotationRequestDetails> orderByComparator,
		boolean useFinderCache) {

		requestRaisedBy = Objects.toString(requestRaisedBy, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByRequestRaisedBy;
				finderArgs = new Object[] {requestRaisedBy};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByRequestRaisedBy;
			finderArgs = new Object[] {
				requestRaisedBy, start, end, orderByComparator
			};
		}

		List<SharedRotationRequestDetails> list = null;

		if (useFinderCache) {
			list = (List<SharedRotationRequestDetails>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (SharedRotationRequestDetails sharedRotationRequestDetails :
						list) {

					if (!requestRaisedBy.equals(
							sharedRotationRequestDetails.
								getRequestRaisedBy())) {

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

			sb.append(_SQL_SELECT_SHAREDROTATIONREQUESTDETAILS_WHERE);

			boolean bindRequestRaisedBy = false;

			if (requestRaisedBy.isEmpty()) {
				sb.append(_FINDER_COLUMN_REQUESTRAISEDBY_REQUESTRAISEDBY_3);
			}
			else {
				bindRequestRaisedBy = true;

				sb.append(_FINDER_COLUMN_REQUESTRAISEDBY_REQUESTRAISEDBY_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(SharedRotationRequestDetailsModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindRequestRaisedBy) {
					queryPos.add(requestRaisedBy);
				}

				list = (List<SharedRotationRequestDetails>)QueryUtil.list(
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
	 * Returns the first shared rotation request details in the ordered set where requestRaisedBy = &#63;.
	 *
	 * @param requestRaisedBy the request raised by
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching shared rotation request details
	 * @throws NoSuchSharedRotationRequestDetailsException if a matching shared rotation request details could not be found
	 */
	@Override
	public SharedRotationRequestDetails findByRequestRaisedBy_First(
			String requestRaisedBy,
			OrderByComparator<SharedRotationRequestDetails> orderByComparator)
		throws NoSuchSharedRotationRequestDetailsException {

		SharedRotationRequestDetails sharedRotationRequestDetails =
			fetchByRequestRaisedBy_First(requestRaisedBy, orderByComparator);

		if (sharedRotationRequestDetails != null) {
			return sharedRotationRequestDetails;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("requestRaisedBy=");
		sb.append(requestRaisedBy);

		sb.append("}");

		throw new NoSuchSharedRotationRequestDetailsException(sb.toString());
	}

	/**
	 * Returns the first shared rotation request details in the ordered set where requestRaisedBy = &#63;.
	 *
	 * @param requestRaisedBy the request raised by
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching shared rotation request details, or <code>null</code> if a matching shared rotation request details could not be found
	 */
	@Override
	public SharedRotationRequestDetails fetchByRequestRaisedBy_First(
		String requestRaisedBy,
		OrderByComparator<SharedRotationRequestDetails> orderByComparator) {

		List<SharedRotationRequestDetails> list = findByRequestRaisedBy(
			requestRaisedBy, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last shared rotation request details in the ordered set where requestRaisedBy = &#63;.
	 *
	 * @param requestRaisedBy the request raised by
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching shared rotation request details
	 * @throws NoSuchSharedRotationRequestDetailsException if a matching shared rotation request details could not be found
	 */
	@Override
	public SharedRotationRequestDetails findByRequestRaisedBy_Last(
			String requestRaisedBy,
			OrderByComparator<SharedRotationRequestDetails> orderByComparator)
		throws NoSuchSharedRotationRequestDetailsException {

		SharedRotationRequestDetails sharedRotationRequestDetails =
			fetchByRequestRaisedBy_Last(requestRaisedBy, orderByComparator);

		if (sharedRotationRequestDetails != null) {
			return sharedRotationRequestDetails;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("requestRaisedBy=");
		sb.append(requestRaisedBy);

		sb.append("}");

		throw new NoSuchSharedRotationRequestDetailsException(sb.toString());
	}

	/**
	 * Returns the last shared rotation request details in the ordered set where requestRaisedBy = &#63;.
	 *
	 * @param requestRaisedBy the request raised by
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching shared rotation request details, or <code>null</code> if a matching shared rotation request details could not be found
	 */
	@Override
	public SharedRotationRequestDetails fetchByRequestRaisedBy_Last(
		String requestRaisedBy,
		OrderByComparator<SharedRotationRequestDetails> orderByComparator) {

		int count = countByRequestRaisedBy(requestRaisedBy);

		if (count == 0) {
			return null;
		}

		List<SharedRotationRequestDetails> list = findByRequestRaisedBy(
			requestRaisedBy, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the shared rotation request detailses before and after the current shared rotation request details in the ordered set where requestRaisedBy = &#63;.
	 *
	 * @param sharedRotationRequestDetailsId the primary key of the current shared rotation request details
	 * @param requestRaisedBy the request raised by
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next shared rotation request details
	 * @throws NoSuchSharedRotationRequestDetailsException if a shared rotation request details with the primary key could not be found
	 */
	@Override
	public SharedRotationRequestDetails[] findByRequestRaisedBy_PrevAndNext(
			long sharedRotationRequestDetailsId, String requestRaisedBy,
			OrderByComparator<SharedRotationRequestDetails> orderByComparator)
		throws NoSuchSharedRotationRequestDetailsException {

		requestRaisedBy = Objects.toString(requestRaisedBy, "");

		SharedRotationRequestDetails sharedRotationRequestDetails =
			findByPrimaryKey(sharedRotationRequestDetailsId);

		Session session = null;

		try {
			session = openSession();

			SharedRotationRequestDetails[] array =
				new SharedRotationRequestDetailsImpl[3];

			array[0] = getByRequestRaisedBy_PrevAndNext(
				session, sharedRotationRequestDetails, requestRaisedBy,
				orderByComparator, true);

			array[1] = sharedRotationRequestDetails;

			array[2] = getByRequestRaisedBy_PrevAndNext(
				session, sharedRotationRequestDetails, requestRaisedBy,
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

	protected SharedRotationRequestDetails getByRequestRaisedBy_PrevAndNext(
		Session session,
		SharedRotationRequestDetails sharedRotationRequestDetails,
		String requestRaisedBy,
		OrderByComparator<SharedRotationRequestDetails> orderByComparator,
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

		sb.append(_SQL_SELECT_SHAREDROTATIONREQUESTDETAILS_WHERE);

		boolean bindRequestRaisedBy = false;

		if (requestRaisedBy.isEmpty()) {
			sb.append(_FINDER_COLUMN_REQUESTRAISEDBY_REQUESTRAISEDBY_3);
		}
		else {
			bindRequestRaisedBy = true;

			sb.append(_FINDER_COLUMN_REQUESTRAISEDBY_REQUESTRAISEDBY_2);
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
			sb.append(SharedRotationRequestDetailsModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		if (bindRequestRaisedBy) {
			queryPos.add(requestRaisedBy);
		}

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						sharedRotationRequestDetails)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<SharedRotationRequestDetails> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the shared rotation request detailses where requestRaisedBy = &#63; from the database.
	 *
	 * @param requestRaisedBy the request raised by
	 */
	@Override
	public void removeByRequestRaisedBy(String requestRaisedBy) {
		for (SharedRotationRequestDetails sharedRotationRequestDetails :
				findByRequestRaisedBy(
					requestRaisedBy, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(sharedRotationRequestDetails);
		}
	}

	/**
	 * Returns the number of shared rotation request detailses where requestRaisedBy = &#63;.
	 *
	 * @param requestRaisedBy the request raised by
	 * @return the number of matching shared rotation request detailses
	 */
	@Override
	public int countByRequestRaisedBy(String requestRaisedBy) {
		requestRaisedBy = Objects.toString(requestRaisedBy, "");

		FinderPath finderPath = _finderPathCountByRequestRaisedBy;

		Object[] finderArgs = new Object[] {requestRaisedBy};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_SHAREDROTATIONREQUESTDETAILS_WHERE);

			boolean bindRequestRaisedBy = false;

			if (requestRaisedBy.isEmpty()) {
				sb.append(_FINDER_COLUMN_REQUESTRAISEDBY_REQUESTRAISEDBY_3);
			}
			else {
				bindRequestRaisedBy = true;

				sb.append(_FINDER_COLUMN_REQUESTRAISEDBY_REQUESTRAISEDBY_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindRequestRaisedBy) {
					queryPos.add(requestRaisedBy);
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
		_FINDER_COLUMN_REQUESTRAISEDBY_REQUESTRAISEDBY_2 =
			"sharedRotationRequestDetails.requestRaisedBy = ?";

	private static final String
		_FINDER_COLUMN_REQUESTRAISEDBY_REQUESTRAISEDBY_3 =
			"(sharedRotationRequestDetails.requestRaisedBy IS NULL OR sharedRotationRequestDetails.requestRaisedBy = '')";

	public SharedRotationRequestDetailsPersistenceImpl() {
		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("uuid", "uuid_");
		dbColumnNames.put(
			"sharedRotationRequestDetailsId",
			"shared_rotation_request_details_id");
		dbColumnNames.put("programDurationId", "program_duration_id");
		dbColumnNames.put("rotationId", "rotation_id");
		dbColumnNames.put("groupId", "group_id");
		dbColumnNames.put("companyId", "company_id");
		dbColumnNames.put("createDate", "create_date");
		dbColumnNames.put("createdBy", "created_by");
		dbColumnNames.put("modifiedDate", "modified_date");
		dbColumnNames.put("modifiedBy", "modified_by");
		dbColumnNames.put("noOfTraineesRequested", "no_of_trainees_requested");
		dbColumnNames.put("requesterComment", "requester_comment");
		dbColumnNames.put("approvedCount", "approved_count");
		dbColumnNames.put("rejectedCount", "rejected_count");
		dbColumnNames.put("requestRaisedTo", "request_raised_to");
		dbColumnNames.put("requestRaisedBy", "request_raised_by");

		setDBColumnNames(dbColumnNames);

		setModelClass(SharedRotationRequestDetails.class);

		setModelImplClass(SharedRotationRequestDetailsImpl.class);
		setModelPKClass(long.class);

		setTable(SharedRotationRequestDetailsTable.INSTANCE);
	}

	/**
	 * Caches the shared rotation request details in the entity cache if it is enabled.
	 *
	 * @param sharedRotationRequestDetails the shared rotation request details
	 */
	@Override
	public void cacheResult(
		SharedRotationRequestDetails sharedRotationRequestDetails) {

		entityCache.putResult(
			SharedRotationRequestDetailsImpl.class,
			sharedRotationRequestDetails.getPrimaryKey(),
			sharedRotationRequestDetails);

		finderCache.putResult(
			_finderPathFetchByUUID_G,
			new Object[] {
				sharedRotationRequestDetails.getUuid(),
				sharedRotationRequestDetails.getGroupId()
			},
			sharedRotationRequestDetails);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the shared rotation request detailses in the entity cache if it is enabled.
	 *
	 * @param sharedRotationRequestDetailses the shared rotation request detailses
	 */
	@Override
	public void cacheResult(
		List<SharedRotationRequestDetails> sharedRotationRequestDetailses) {

		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (sharedRotationRequestDetailses.size() >
				 _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (SharedRotationRequestDetails sharedRotationRequestDetails :
				sharedRotationRequestDetailses) {

			if (entityCache.getResult(
					SharedRotationRequestDetailsImpl.class,
					sharedRotationRequestDetails.getPrimaryKey()) == null) {

				cacheResult(sharedRotationRequestDetails);
			}
		}
	}

	/**
	 * Clears the cache for all shared rotation request detailses.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(SharedRotationRequestDetailsImpl.class);

		finderCache.clearCache(SharedRotationRequestDetailsImpl.class);
	}

	/**
	 * Clears the cache for the shared rotation request details.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(
		SharedRotationRequestDetails sharedRotationRequestDetails) {

		entityCache.removeResult(
			SharedRotationRequestDetailsImpl.class,
			sharedRotationRequestDetails);
	}

	@Override
	public void clearCache(
		List<SharedRotationRequestDetails> sharedRotationRequestDetailses) {

		for (SharedRotationRequestDetails sharedRotationRequestDetails :
				sharedRotationRequestDetailses) {

			entityCache.removeResult(
				SharedRotationRequestDetailsImpl.class,
				sharedRotationRequestDetails);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(SharedRotationRequestDetailsImpl.class);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(
				SharedRotationRequestDetailsImpl.class, primaryKey);
		}
	}

	protected void cacheUniqueFindersCache(
		SharedRotationRequestDetailsModelImpl
			sharedRotationRequestDetailsModelImpl) {

		Object[] args = new Object[] {
			sharedRotationRequestDetailsModelImpl.getUuid(),
			sharedRotationRequestDetailsModelImpl.getGroupId()
		};

		finderCache.putResult(_finderPathCountByUUID_G, args, Long.valueOf(1));
		finderCache.putResult(
			_finderPathFetchByUUID_G, args,
			sharedRotationRequestDetailsModelImpl);
	}

	/**
	 * Creates a new shared rotation request details with the primary key. Does not add the shared rotation request details to the database.
	 *
	 * @param sharedRotationRequestDetailsId the primary key for the new shared rotation request details
	 * @return the new shared rotation request details
	 */
	@Override
	public SharedRotationRequestDetails create(
		long sharedRotationRequestDetailsId) {

		SharedRotationRequestDetails sharedRotationRequestDetails =
			new SharedRotationRequestDetailsImpl();

		sharedRotationRequestDetails.setNew(true);
		sharedRotationRequestDetails.setPrimaryKey(
			sharedRotationRequestDetailsId);

		String uuid = _portalUUID.generate();

		sharedRotationRequestDetails.setUuid(uuid);

		sharedRotationRequestDetails.setCompanyId(
			CompanyThreadLocal.getCompanyId());

		return sharedRotationRequestDetails;
	}

	/**
	 * Removes the shared rotation request details with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param sharedRotationRequestDetailsId the primary key of the shared rotation request details
	 * @return the shared rotation request details that was removed
	 * @throws NoSuchSharedRotationRequestDetailsException if a shared rotation request details with the primary key could not be found
	 */
	@Override
	public SharedRotationRequestDetails remove(
			long sharedRotationRequestDetailsId)
		throws NoSuchSharedRotationRequestDetailsException {

		return remove((Serializable)sharedRotationRequestDetailsId);
	}

	/**
	 * Removes the shared rotation request details with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the shared rotation request details
	 * @return the shared rotation request details that was removed
	 * @throws NoSuchSharedRotationRequestDetailsException if a shared rotation request details with the primary key could not be found
	 */
	@Override
	public SharedRotationRequestDetails remove(Serializable primaryKey)
		throws NoSuchSharedRotationRequestDetailsException {

		Session session = null;

		try {
			session = openSession();

			SharedRotationRequestDetails sharedRotationRequestDetails =
				(SharedRotationRequestDetails)session.get(
					SharedRotationRequestDetailsImpl.class, primaryKey);

			if (sharedRotationRequestDetails == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchSharedRotationRequestDetailsException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(sharedRotationRequestDetails);
		}
		catch (NoSuchSharedRotationRequestDetailsException
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
	protected SharedRotationRequestDetails removeImpl(
		SharedRotationRequestDetails sharedRotationRequestDetails) {

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(sharedRotationRequestDetails)) {
				sharedRotationRequestDetails =
					(SharedRotationRequestDetails)session.get(
						SharedRotationRequestDetailsImpl.class,
						sharedRotationRequestDetails.getPrimaryKeyObj());
			}

			if (sharedRotationRequestDetails != null) {
				session.delete(sharedRotationRequestDetails);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (sharedRotationRequestDetails != null) {
			clearCache(sharedRotationRequestDetails);
		}

		return sharedRotationRequestDetails;
	}

	@Override
	public SharedRotationRequestDetails updateImpl(
		SharedRotationRequestDetails sharedRotationRequestDetails) {

		boolean isNew = sharedRotationRequestDetails.isNew();

		if (!(sharedRotationRequestDetails instanceof
				SharedRotationRequestDetailsModelImpl)) {

			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(
					sharedRotationRequestDetails.getClass())) {

				invocationHandler = ProxyUtil.getInvocationHandler(
					sharedRotationRequestDetails);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in sharedRotationRequestDetails proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom SharedRotationRequestDetails implementation " +
					sharedRotationRequestDetails.getClass());
		}

		SharedRotationRequestDetailsModelImpl
			sharedRotationRequestDetailsModelImpl =
				(SharedRotationRequestDetailsModelImpl)
					sharedRotationRequestDetails;

		if (Validator.isNull(sharedRotationRequestDetails.getUuid())) {
			String uuid = _portalUUID.generate();

			sharedRotationRequestDetails.setUuid(uuid);
		}

		ServiceContext serviceContext =
			ServiceContextThreadLocal.getServiceContext();

		Date date = new Date();

		if (isNew && (sharedRotationRequestDetails.getCreateDate() == null)) {
			if (serviceContext == null) {
				sharedRotationRequestDetails.setCreateDate(date);
			}
			else {
				sharedRotationRequestDetails.setCreateDate(
					serviceContext.getCreateDate(date));
			}
		}

		if (!sharedRotationRequestDetailsModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				sharedRotationRequestDetails.setModifiedDate(date);
			}
			else {
				sharedRotationRequestDetails.setModifiedDate(
					serviceContext.getModifiedDate(date));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(sharedRotationRequestDetails);
			}
			else {
				sharedRotationRequestDetails =
					(SharedRotationRequestDetails)session.merge(
						sharedRotationRequestDetails);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(
			SharedRotationRequestDetailsImpl.class,
			sharedRotationRequestDetailsModelImpl, false, true);

		cacheUniqueFindersCache(sharedRotationRequestDetailsModelImpl);

		if (isNew) {
			sharedRotationRequestDetails.setNew(false);
		}

		sharedRotationRequestDetails.resetOriginalValues();

		return sharedRotationRequestDetails;
	}

	/**
	 * Returns the shared rotation request details with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the shared rotation request details
	 * @return the shared rotation request details
	 * @throws NoSuchSharedRotationRequestDetailsException if a shared rotation request details with the primary key could not be found
	 */
	@Override
	public SharedRotationRequestDetails findByPrimaryKey(
			Serializable primaryKey)
		throws NoSuchSharedRotationRequestDetailsException {

		SharedRotationRequestDetails sharedRotationRequestDetails =
			fetchByPrimaryKey(primaryKey);

		if (sharedRotationRequestDetails == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchSharedRotationRequestDetailsException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return sharedRotationRequestDetails;
	}

	/**
	 * Returns the shared rotation request details with the primary key or throws a <code>NoSuchSharedRotationRequestDetailsException</code> if it could not be found.
	 *
	 * @param sharedRotationRequestDetailsId the primary key of the shared rotation request details
	 * @return the shared rotation request details
	 * @throws NoSuchSharedRotationRequestDetailsException if a shared rotation request details with the primary key could not be found
	 */
	@Override
	public SharedRotationRequestDetails findByPrimaryKey(
			long sharedRotationRequestDetailsId)
		throws NoSuchSharedRotationRequestDetailsException {

		return findByPrimaryKey((Serializable)sharedRotationRequestDetailsId);
	}

	/**
	 * Returns the shared rotation request details with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param sharedRotationRequestDetailsId the primary key of the shared rotation request details
	 * @return the shared rotation request details, or <code>null</code> if a shared rotation request details with the primary key could not be found
	 */
	@Override
	public SharedRotationRequestDetails fetchByPrimaryKey(
		long sharedRotationRequestDetailsId) {

		return fetchByPrimaryKey((Serializable)sharedRotationRequestDetailsId);
	}

	/**
	 * Returns all the shared rotation request detailses.
	 *
	 * @return the shared rotation request detailses
	 */
	@Override
	public List<SharedRotationRequestDetails> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the shared rotation request detailses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SharedRotationRequestDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of shared rotation request detailses
	 * @param end the upper bound of the range of shared rotation request detailses (not inclusive)
	 * @return the range of shared rotation request detailses
	 */
	@Override
	public List<SharedRotationRequestDetails> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the shared rotation request detailses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SharedRotationRequestDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of shared rotation request detailses
	 * @param end the upper bound of the range of shared rotation request detailses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of shared rotation request detailses
	 */
	@Override
	public List<SharedRotationRequestDetails> findAll(
		int start, int end,
		OrderByComparator<SharedRotationRequestDetails> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the shared rotation request detailses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SharedRotationRequestDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of shared rotation request detailses
	 * @param end the upper bound of the range of shared rotation request detailses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of shared rotation request detailses
	 */
	@Override
	public List<SharedRotationRequestDetails> findAll(
		int start, int end,
		OrderByComparator<SharedRotationRequestDetails> orderByComparator,
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

		List<SharedRotationRequestDetails> list = null;

		if (useFinderCache) {
			list = (List<SharedRotationRequestDetails>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_SHAREDROTATIONREQUESTDETAILS);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_SHAREDROTATIONREQUESTDETAILS;

				sql = sql.concat(
					SharedRotationRequestDetailsModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<SharedRotationRequestDetails>)QueryUtil.list(
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
	 * Removes all the shared rotation request detailses from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (SharedRotationRequestDetails sharedRotationRequestDetails :
				findAll()) {

			remove(sharedRotationRequestDetails);
		}
	}

	/**
	 * Returns the number of shared rotation request detailses.
	 *
	 * @return the number of shared rotation request detailses
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
					_SQL_COUNT_SHAREDROTATIONREQUESTDETAILS);

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
		return "shared_rotation_request_details_id";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_SHAREDROTATIONREQUESTDETAILS;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return SharedRotationRequestDetailsModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the shared rotation request details persistence.
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

		_finderPathWithPaginationFindByRequestRaisedBy = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByRequestRaisedBy",
			new String[] {
				String.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"request_raised_by"}, true);

		_finderPathWithoutPaginationFindByRequestRaisedBy = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByRequestRaisedBy",
			new String[] {String.class.getName()},
			new String[] {"request_raised_by"}, true);

		_finderPathCountByRequestRaisedBy = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByRequestRaisedBy",
			new String[] {String.class.getName()},
			new String[] {"request_raised_by"}, false);

		_setSharedRotationRequestDetailsUtilPersistence(this);
	}

	@Deactivate
	public void deactivate() {
		_setSharedRotationRequestDetailsUtilPersistence(null);

		entityCache.removeCache(
			SharedRotationRequestDetailsImpl.class.getName());
	}

	private void _setSharedRotationRequestDetailsUtilPersistence(
		SharedRotationRequestDetailsPersistence
			sharedRotationRequestDetailsPersistence) {

		try {
			Field field =
				SharedRotationRequestDetailsUtil.class.getDeclaredField(
					"_persistence");

			field.setAccessible(true);

			field.set(null, sharedRotationRequestDetailsPersistence);
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

	private static final String _SQL_SELECT_SHAREDROTATIONREQUESTDETAILS =
		"SELECT sharedRotationRequestDetails FROM SharedRotationRequestDetails sharedRotationRequestDetails";

	private static final String _SQL_SELECT_SHAREDROTATIONREQUESTDETAILS_WHERE =
		"SELECT sharedRotationRequestDetails FROM SharedRotationRequestDetails sharedRotationRequestDetails WHERE ";

	private static final String _SQL_COUNT_SHAREDROTATIONREQUESTDETAILS =
		"SELECT COUNT(sharedRotationRequestDetails) FROM SharedRotationRequestDetails sharedRotationRequestDetails";

	private static final String _SQL_COUNT_SHAREDROTATIONREQUESTDETAILS_WHERE =
		"SELECT COUNT(sharedRotationRequestDetails) FROM SharedRotationRequestDetails sharedRotationRequestDetails WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS =
		"sharedRotationRequestDetails.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No SharedRotationRequestDetails exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No SharedRotationRequestDetails exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		SharedRotationRequestDetailsPersistenceImpl.class);

	private static final Set<String> _badColumnNames = SetUtil.fromArray(
		new String[] {
			"uuid", "sharedRotationRequestDetailsId", "programDurationId",
			"rotationId", "groupId", "companyId", "createDate", "createdBy",
			"modifiedDate", "modifiedBy", "noOfTraineesRequested",
			"requesterComment", "approvedCount", "rejectedCount",
			"requestRaisedTo", "requestRaisedBy"
		});

	@Override
	protected FinderCache getFinderCache() {
		return finderCache;
	}

	@Reference
	private PortalUUID _portalUUID;

}
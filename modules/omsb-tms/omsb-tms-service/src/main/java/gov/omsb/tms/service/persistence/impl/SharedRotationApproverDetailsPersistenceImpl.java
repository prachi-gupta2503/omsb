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

import gov.omsb.tms.exception.NoSuchSharedRotationApproverDetailsException;
import gov.omsb.tms.model.SharedRotationApproverDetails;
import gov.omsb.tms.model.SharedRotationApproverDetailsTable;
import gov.omsb.tms.model.impl.SharedRotationApproverDetailsImpl;
import gov.omsb.tms.model.impl.SharedRotationApproverDetailsModelImpl;
import gov.omsb.tms.service.persistence.SharedRotationApproverDetailsPersistence;
import gov.omsb.tms.service.persistence.SharedRotationApproverDetailsUtil;
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
 * The persistence implementation for the shared rotation approver details service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = SharedRotationApproverDetailsPersistence.class)
public class SharedRotationApproverDetailsPersistenceImpl
	extends BasePersistenceImpl<SharedRotationApproverDetails>
	implements SharedRotationApproverDetailsPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>SharedRotationApproverDetailsUtil</code> to access the shared rotation approver details persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		SharedRotationApproverDetailsImpl.class.getName();

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
	 * Returns all the shared rotation approver detailses where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching shared rotation approver detailses
	 */
	@Override
	public List<SharedRotationApproverDetails> findByUuid(String uuid) {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the shared rotation approver detailses where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SharedRotationApproverDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of shared rotation approver detailses
	 * @param end the upper bound of the range of shared rotation approver detailses (not inclusive)
	 * @return the range of matching shared rotation approver detailses
	 */
	@Override
	public List<SharedRotationApproverDetails> findByUuid(
		String uuid, int start, int end) {

		return findByUuid(uuid, start, end, null);
	}

	/**
	 * Returns an ordered range of all the shared rotation approver detailses where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SharedRotationApproverDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of shared rotation approver detailses
	 * @param end the upper bound of the range of shared rotation approver detailses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching shared rotation approver detailses
	 */
	@Override
	public List<SharedRotationApproverDetails> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<SharedRotationApproverDetails> orderByComparator) {

		return findByUuid(uuid, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the shared rotation approver detailses where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SharedRotationApproverDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of shared rotation approver detailses
	 * @param end the upper bound of the range of shared rotation approver detailses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching shared rotation approver detailses
	 */
	@Override
	public List<SharedRotationApproverDetails> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<SharedRotationApproverDetails> orderByComparator,
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

		List<SharedRotationApproverDetails> list = null;

		if (useFinderCache) {
			list = (List<SharedRotationApproverDetails>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (SharedRotationApproverDetails
						sharedRotationApproverDetails : list) {

					if (!uuid.equals(sharedRotationApproverDetails.getUuid())) {
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

			sb.append(_SQL_SELECT_SHAREDROTATIONAPPROVERDETAILS_WHERE);

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
				sb.append(SharedRotationApproverDetailsModelImpl.ORDER_BY_JPQL);
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

				list = (List<SharedRotationApproverDetails>)QueryUtil.list(
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
	 * Returns the first shared rotation approver details in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching shared rotation approver details
	 * @throws NoSuchSharedRotationApproverDetailsException if a matching shared rotation approver details could not be found
	 */
	@Override
	public SharedRotationApproverDetails findByUuid_First(
			String uuid,
			OrderByComparator<SharedRotationApproverDetails> orderByComparator)
		throws NoSuchSharedRotationApproverDetailsException {

		SharedRotationApproverDetails sharedRotationApproverDetails =
			fetchByUuid_First(uuid, orderByComparator);

		if (sharedRotationApproverDetails != null) {
			return sharedRotationApproverDetails;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchSharedRotationApproverDetailsException(sb.toString());
	}

	/**
	 * Returns the first shared rotation approver details in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching shared rotation approver details, or <code>null</code> if a matching shared rotation approver details could not be found
	 */
	@Override
	public SharedRotationApproverDetails fetchByUuid_First(
		String uuid,
		OrderByComparator<SharedRotationApproverDetails> orderByComparator) {

		List<SharedRotationApproverDetails> list = findByUuid(
			uuid, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last shared rotation approver details in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching shared rotation approver details
	 * @throws NoSuchSharedRotationApproverDetailsException if a matching shared rotation approver details could not be found
	 */
	@Override
	public SharedRotationApproverDetails findByUuid_Last(
			String uuid,
			OrderByComparator<SharedRotationApproverDetails> orderByComparator)
		throws NoSuchSharedRotationApproverDetailsException {

		SharedRotationApproverDetails sharedRotationApproverDetails =
			fetchByUuid_Last(uuid, orderByComparator);

		if (sharedRotationApproverDetails != null) {
			return sharedRotationApproverDetails;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchSharedRotationApproverDetailsException(sb.toString());
	}

	/**
	 * Returns the last shared rotation approver details in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching shared rotation approver details, or <code>null</code> if a matching shared rotation approver details could not be found
	 */
	@Override
	public SharedRotationApproverDetails fetchByUuid_Last(
		String uuid,
		OrderByComparator<SharedRotationApproverDetails> orderByComparator) {

		int count = countByUuid(uuid);

		if (count == 0) {
			return null;
		}

		List<SharedRotationApproverDetails> list = findByUuid(
			uuid, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the shared rotation approver detailses before and after the current shared rotation approver details in the ordered set where uuid = &#63;.
	 *
	 * @param sharedRotationApproverDetailsId the primary key of the current shared rotation approver details
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next shared rotation approver details
	 * @throws NoSuchSharedRotationApproverDetailsException if a shared rotation approver details with the primary key could not be found
	 */
	@Override
	public SharedRotationApproverDetails[] findByUuid_PrevAndNext(
			long sharedRotationApproverDetailsId, String uuid,
			OrderByComparator<SharedRotationApproverDetails> orderByComparator)
		throws NoSuchSharedRotationApproverDetailsException {

		uuid = Objects.toString(uuid, "");

		SharedRotationApproverDetails sharedRotationApproverDetails =
			findByPrimaryKey(sharedRotationApproverDetailsId);

		Session session = null;

		try {
			session = openSession();

			SharedRotationApproverDetails[] array =
				new SharedRotationApproverDetailsImpl[3];

			array[0] = getByUuid_PrevAndNext(
				session, sharedRotationApproverDetails, uuid, orderByComparator,
				true);

			array[1] = sharedRotationApproverDetails;

			array[2] = getByUuid_PrevAndNext(
				session, sharedRotationApproverDetails, uuid, orderByComparator,
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

	protected SharedRotationApproverDetails getByUuid_PrevAndNext(
		Session session,
		SharedRotationApproverDetails sharedRotationApproverDetails,
		String uuid,
		OrderByComparator<SharedRotationApproverDetails> orderByComparator,
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

		sb.append(_SQL_SELECT_SHAREDROTATIONAPPROVERDETAILS_WHERE);

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
			sb.append(SharedRotationApproverDetailsModelImpl.ORDER_BY_JPQL);
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
						sharedRotationApproverDetails)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<SharedRotationApproverDetails> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the shared rotation approver detailses where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	@Override
	public void removeByUuid(String uuid) {
		for (SharedRotationApproverDetails sharedRotationApproverDetails :
				findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(sharedRotationApproverDetails);
		}
	}

	/**
	 * Returns the number of shared rotation approver detailses where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching shared rotation approver detailses
	 */
	@Override
	public int countByUuid(String uuid) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid;

		Object[] finderArgs = new Object[] {uuid};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_SHAREDROTATIONAPPROVERDETAILS_WHERE);

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
		"sharedRotationApproverDetails.uuid = ?";

	private static final String _FINDER_COLUMN_UUID_UUID_3 =
		"(sharedRotationApproverDetails.uuid IS NULL OR sharedRotationApproverDetails.uuid = '')";

	private FinderPath _finderPathFetchByUUID_G;
	private FinderPath _finderPathCountByUUID_G;

	/**
	 * Returns the shared rotation approver details where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchSharedRotationApproverDetailsException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching shared rotation approver details
	 * @throws NoSuchSharedRotationApproverDetailsException if a matching shared rotation approver details could not be found
	 */
	@Override
	public SharedRotationApproverDetails findByUUID_G(String uuid, long groupId)
		throws NoSuchSharedRotationApproverDetailsException {

		SharedRotationApproverDetails sharedRotationApproverDetails =
			fetchByUUID_G(uuid, groupId);

		if (sharedRotationApproverDetails == null) {
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

			throw new NoSuchSharedRotationApproverDetailsException(
				sb.toString());
		}

		return sharedRotationApproverDetails;
	}

	/**
	 * Returns the shared rotation approver details where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching shared rotation approver details, or <code>null</code> if a matching shared rotation approver details could not be found
	 */
	@Override
	public SharedRotationApproverDetails fetchByUUID_G(
		String uuid, long groupId) {

		return fetchByUUID_G(uuid, groupId, true);
	}

	/**
	 * Returns the shared rotation approver details where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching shared rotation approver details, or <code>null</code> if a matching shared rotation approver details could not be found
	 */
	@Override
	public SharedRotationApproverDetails fetchByUUID_G(
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

		if (result instanceof SharedRotationApproverDetails) {
			SharedRotationApproverDetails sharedRotationApproverDetails =
				(SharedRotationApproverDetails)result;

			if (!Objects.equals(
					uuid, sharedRotationApproverDetails.getUuid()) ||
				(groupId != sharedRotationApproverDetails.getGroupId())) {

				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_SQL_SELECT_SHAREDROTATIONAPPROVERDETAILS_WHERE);

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

				List<SharedRotationApproverDetails> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchByUUID_G, finderArgs, list);
					}
				}
				else {
					SharedRotationApproverDetails
						sharedRotationApproverDetails = list.get(0);

					result = sharedRotationApproverDetails;

					cacheResult(sharedRotationApproverDetails);
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
			return (SharedRotationApproverDetails)result;
		}
	}

	/**
	 * Removes the shared rotation approver details where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the shared rotation approver details that was removed
	 */
	@Override
	public SharedRotationApproverDetails removeByUUID_G(
			String uuid, long groupId)
		throws NoSuchSharedRotationApproverDetailsException {

		SharedRotationApproverDetails sharedRotationApproverDetails =
			findByUUID_G(uuid, groupId);

		return remove(sharedRotationApproverDetails);
	}

	/**
	 * Returns the number of shared rotation approver detailses where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching shared rotation approver detailses
	 */
	@Override
	public int countByUUID_G(String uuid, long groupId) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUUID_G;

		Object[] finderArgs = new Object[] {uuid, groupId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_SHAREDROTATIONAPPROVERDETAILS_WHERE);

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
		"sharedRotationApproverDetails.uuid = ? AND ";

	private static final String _FINDER_COLUMN_UUID_G_UUID_3 =
		"(sharedRotationApproverDetails.uuid IS NULL OR sharedRotationApproverDetails.uuid = '') AND ";

	private static final String _FINDER_COLUMN_UUID_G_GROUPID_2 =
		"sharedRotationApproverDetails.groupId = ?";

	private FinderPath _finderPathWithPaginationFindByUuid_C;
	private FinderPath _finderPathWithoutPaginationFindByUuid_C;
	private FinderPath _finderPathCountByUuid_C;

	/**
	 * Returns all the shared rotation approver detailses where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching shared rotation approver detailses
	 */
	@Override
	public List<SharedRotationApproverDetails> findByUuid_C(
		String uuid, long companyId) {

		return findByUuid_C(
			uuid, companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the shared rotation approver detailses where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SharedRotationApproverDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of shared rotation approver detailses
	 * @param end the upper bound of the range of shared rotation approver detailses (not inclusive)
	 * @return the range of matching shared rotation approver detailses
	 */
	@Override
	public List<SharedRotationApproverDetails> findByUuid_C(
		String uuid, long companyId, int start, int end) {

		return findByUuid_C(uuid, companyId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the shared rotation approver detailses where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SharedRotationApproverDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of shared rotation approver detailses
	 * @param end the upper bound of the range of shared rotation approver detailses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching shared rotation approver detailses
	 */
	@Override
	public List<SharedRotationApproverDetails> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<SharedRotationApproverDetails> orderByComparator) {

		return findByUuid_C(
			uuid, companyId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the shared rotation approver detailses where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SharedRotationApproverDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of shared rotation approver detailses
	 * @param end the upper bound of the range of shared rotation approver detailses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching shared rotation approver detailses
	 */
	@Override
	public List<SharedRotationApproverDetails> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<SharedRotationApproverDetails> orderByComparator,
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

		List<SharedRotationApproverDetails> list = null;

		if (useFinderCache) {
			list = (List<SharedRotationApproverDetails>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (SharedRotationApproverDetails
						sharedRotationApproverDetails : list) {

					if (!uuid.equals(sharedRotationApproverDetails.getUuid()) ||
						(companyId !=
							sharedRotationApproverDetails.getCompanyId())) {

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

			sb.append(_SQL_SELECT_SHAREDROTATIONAPPROVERDETAILS_WHERE);

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
				sb.append(SharedRotationApproverDetailsModelImpl.ORDER_BY_JPQL);
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

				list = (List<SharedRotationApproverDetails>)QueryUtil.list(
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
	 * Returns the first shared rotation approver details in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching shared rotation approver details
	 * @throws NoSuchSharedRotationApproverDetailsException if a matching shared rotation approver details could not be found
	 */
	@Override
	public SharedRotationApproverDetails findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<SharedRotationApproverDetails> orderByComparator)
		throws NoSuchSharedRotationApproverDetailsException {

		SharedRotationApproverDetails sharedRotationApproverDetails =
			fetchByUuid_C_First(uuid, companyId, orderByComparator);

		if (sharedRotationApproverDetails != null) {
			return sharedRotationApproverDetails;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append(", companyId=");
		sb.append(companyId);

		sb.append("}");

		throw new NoSuchSharedRotationApproverDetailsException(sb.toString());
	}

	/**
	 * Returns the first shared rotation approver details in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching shared rotation approver details, or <code>null</code> if a matching shared rotation approver details could not be found
	 */
	@Override
	public SharedRotationApproverDetails fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<SharedRotationApproverDetails> orderByComparator) {

		List<SharedRotationApproverDetails> list = findByUuid_C(
			uuid, companyId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last shared rotation approver details in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching shared rotation approver details
	 * @throws NoSuchSharedRotationApproverDetailsException if a matching shared rotation approver details could not be found
	 */
	@Override
	public SharedRotationApproverDetails findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<SharedRotationApproverDetails> orderByComparator)
		throws NoSuchSharedRotationApproverDetailsException {

		SharedRotationApproverDetails sharedRotationApproverDetails =
			fetchByUuid_C_Last(uuid, companyId, orderByComparator);

		if (sharedRotationApproverDetails != null) {
			return sharedRotationApproverDetails;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append(", companyId=");
		sb.append(companyId);

		sb.append("}");

		throw new NoSuchSharedRotationApproverDetailsException(sb.toString());
	}

	/**
	 * Returns the last shared rotation approver details in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching shared rotation approver details, or <code>null</code> if a matching shared rotation approver details could not be found
	 */
	@Override
	public SharedRotationApproverDetails fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<SharedRotationApproverDetails> orderByComparator) {

		int count = countByUuid_C(uuid, companyId);

		if (count == 0) {
			return null;
		}

		List<SharedRotationApproverDetails> list = findByUuid_C(
			uuid, companyId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the shared rotation approver detailses before and after the current shared rotation approver details in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param sharedRotationApproverDetailsId the primary key of the current shared rotation approver details
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next shared rotation approver details
	 * @throws NoSuchSharedRotationApproverDetailsException if a shared rotation approver details with the primary key could not be found
	 */
	@Override
	public SharedRotationApproverDetails[] findByUuid_C_PrevAndNext(
			long sharedRotationApproverDetailsId, String uuid, long companyId,
			OrderByComparator<SharedRotationApproverDetails> orderByComparator)
		throws NoSuchSharedRotationApproverDetailsException {

		uuid = Objects.toString(uuid, "");

		SharedRotationApproverDetails sharedRotationApproverDetails =
			findByPrimaryKey(sharedRotationApproverDetailsId);

		Session session = null;

		try {
			session = openSession();

			SharedRotationApproverDetails[] array =
				new SharedRotationApproverDetailsImpl[3];

			array[0] = getByUuid_C_PrevAndNext(
				session, sharedRotationApproverDetails, uuid, companyId,
				orderByComparator, true);

			array[1] = sharedRotationApproverDetails;

			array[2] = getByUuid_C_PrevAndNext(
				session, sharedRotationApproverDetails, uuid, companyId,
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

	protected SharedRotationApproverDetails getByUuid_C_PrevAndNext(
		Session session,
		SharedRotationApproverDetails sharedRotationApproverDetails,
		String uuid, long companyId,
		OrderByComparator<SharedRotationApproverDetails> orderByComparator,
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

		sb.append(_SQL_SELECT_SHAREDROTATIONAPPROVERDETAILS_WHERE);

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
			sb.append(SharedRotationApproverDetailsModelImpl.ORDER_BY_JPQL);
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
						sharedRotationApproverDetails)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<SharedRotationApproverDetails> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the shared rotation approver detailses where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	@Override
	public void removeByUuid_C(String uuid, long companyId) {
		for (SharedRotationApproverDetails sharedRotationApproverDetails :
				findByUuid_C(
					uuid, companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(sharedRotationApproverDetails);
		}
	}

	/**
	 * Returns the number of shared rotation approver detailses where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching shared rotation approver detailses
	 */
	@Override
	public int countByUuid_C(String uuid, long companyId) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid_C;

		Object[] finderArgs = new Object[] {uuid, companyId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_SHAREDROTATIONAPPROVERDETAILS_WHERE);

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
		"sharedRotationApproverDetails.uuid = ? AND ";

	private static final String _FINDER_COLUMN_UUID_C_UUID_3 =
		"(sharedRotationApproverDetails.uuid IS NULL OR sharedRotationApproverDetails.uuid = '') AND ";

	private static final String _FINDER_COLUMN_UUID_C_COMPANYID_2 =
		"sharedRotationApproverDetails.companyId = ?";

	private FinderPath _finderPathFetchBySharedRotationRequestDetailsId;
	private FinderPath _finderPathCountBySharedRotationRequestDetailsId;

	/**
	 * Returns the shared rotation approver details where sharedRotationRequestDetailsId = &#63; or throws a <code>NoSuchSharedRotationApproverDetailsException</code> if it could not be found.
	 *
	 * @param sharedRotationRequestDetailsId the shared rotation request details ID
	 * @return the matching shared rotation approver details
	 * @throws NoSuchSharedRotationApproverDetailsException if a matching shared rotation approver details could not be found
	 */
	@Override
	public SharedRotationApproverDetails findBySharedRotationRequestDetailsId(
			long sharedRotationRequestDetailsId)
		throws NoSuchSharedRotationApproverDetailsException {

		SharedRotationApproverDetails sharedRotationApproverDetails =
			fetchBySharedRotationRequestDetailsId(
				sharedRotationRequestDetailsId);

		if (sharedRotationApproverDetails == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_NO_SUCH_ENTITY_WITH_KEY);

			sb.append("sharedRotationRequestDetailsId=");
			sb.append(sharedRotationRequestDetailsId);

			sb.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(sb.toString());
			}

			throw new NoSuchSharedRotationApproverDetailsException(
				sb.toString());
		}

		return sharedRotationApproverDetails;
	}

	/**
	 * Returns the shared rotation approver details where sharedRotationRequestDetailsId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param sharedRotationRequestDetailsId the shared rotation request details ID
	 * @return the matching shared rotation approver details, or <code>null</code> if a matching shared rotation approver details could not be found
	 */
	@Override
	public SharedRotationApproverDetails fetchBySharedRotationRequestDetailsId(
		long sharedRotationRequestDetailsId) {

		return fetchBySharedRotationRequestDetailsId(
			sharedRotationRequestDetailsId, true);
	}

	/**
	 * Returns the shared rotation approver details where sharedRotationRequestDetailsId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param sharedRotationRequestDetailsId the shared rotation request details ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching shared rotation approver details, or <code>null</code> if a matching shared rotation approver details could not be found
	 */
	@Override
	public SharedRotationApproverDetails fetchBySharedRotationRequestDetailsId(
		long sharedRotationRequestDetailsId, boolean useFinderCache) {

		Object[] finderArgs = null;

		if (useFinderCache) {
			finderArgs = new Object[] {sharedRotationRequestDetailsId};
		}

		Object result = null;

		if (useFinderCache) {
			result = finderCache.getResult(
				_finderPathFetchBySharedRotationRequestDetailsId, finderArgs,
				this);
		}

		if (result instanceof SharedRotationApproverDetails) {
			SharedRotationApproverDetails sharedRotationApproverDetails =
				(SharedRotationApproverDetails)result;

			if (sharedRotationRequestDetailsId !=
					sharedRotationApproverDetails.
						getSharedRotationRequestDetailsId()) {

				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_SELECT_SHAREDROTATIONAPPROVERDETAILS_WHERE);

			sb.append(
				_FINDER_COLUMN_SHAREDROTATIONREQUESTDETAILSID_SHAREDROTATIONREQUESTDETAILSID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(sharedRotationRequestDetailsId);

				List<SharedRotationApproverDetails> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchBySharedRotationRequestDetailsId,
							finderArgs, list);
					}
				}
				else {
					if (list.size() > 1) {
						Collections.sort(list, Collections.reverseOrder());

						if (_log.isWarnEnabled()) {
							if (!useFinderCache) {
								finderArgs = new Object[] {
									sharedRotationRequestDetailsId
								};
							}

							_log.warn(
								"SharedRotationApproverDetailsPersistenceImpl.fetchBySharedRotationRequestDetailsId(long, boolean) with parameters (" +
									StringUtil.merge(finderArgs) +
										") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
						}
					}

					SharedRotationApproverDetails
						sharedRotationApproverDetails = list.get(0);

					result = sharedRotationApproverDetails;

					cacheResult(sharedRotationApproverDetails);
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
			return (SharedRotationApproverDetails)result;
		}
	}

	/**
	 * Removes the shared rotation approver details where sharedRotationRequestDetailsId = &#63; from the database.
	 *
	 * @param sharedRotationRequestDetailsId the shared rotation request details ID
	 * @return the shared rotation approver details that was removed
	 */
	@Override
	public SharedRotationApproverDetails removeBySharedRotationRequestDetailsId(
			long sharedRotationRequestDetailsId)
		throws NoSuchSharedRotationApproverDetailsException {

		SharedRotationApproverDetails sharedRotationApproverDetails =
			findBySharedRotationRequestDetailsId(
				sharedRotationRequestDetailsId);

		return remove(sharedRotationApproverDetails);
	}

	/**
	 * Returns the number of shared rotation approver detailses where sharedRotationRequestDetailsId = &#63;.
	 *
	 * @param sharedRotationRequestDetailsId the shared rotation request details ID
	 * @return the number of matching shared rotation approver detailses
	 */
	@Override
	public int countBySharedRotationRequestDetailsId(
		long sharedRotationRequestDetailsId) {

		FinderPath finderPath =
			_finderPathCountBySharedRotationRequestDetailsId;

		Object[] finderArgs = new Object[] {sharedRotationRequestDetailsId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_SHAREDROTATIONAPPROVERDETAILS_WHERE);

			sb.append(
				_FINDER_COLUMN_SHAREDROTATIONREQUESTDETAILSID_SHAREDROTATIONREQUESTDETAILSID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(sharedRotationRequestDetailsId);

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
		_FINDER_COLUMN_SHAREDROTATIONREQUESTDETAILSID_SHAREDROTATIONREQUESTDETAILSID_2 =
			"sharedRotationApproverDetails.sharedRotationRequestDetailsId = ?";

	public SharedRotationApproverDetailsPersistenceImpl() {
		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("uuid", "uuid_");
		dbColumnNames.put(
			"sharedRotationApproverDetailsId",
			"shared_rotation_approver_details_id");
		dbColumnNames.put(
			"sharedRotationRequestDetailsId",
			"shared_rotation_request_details_id");
		dbColumnNames.put("groupId", "group_id");
		dbColumnNames.put("companyId", "company_id");
		dbColumnNames.put("createDate", "create_date");
		dbColumnNames.put("createdBy", "created_by");
		dbColumnNames.put("modifiedDate", "modified_date");
		dbColumnNames.put("modifiedBy", "modified_by");
		dbColumnNames.put("approvedTrainees", "approved_trainees");
		dbColumnNames.put("rejectedTrainees", "rejected_trainees");
		dbColumnNames.put("approversComment", "approvers_comment");
		dbColumnNames.put("decisionMakingDate", "decision_making_date");

		setDBColumnNames(dbColumnNames);

		setModelClass(SharedRotationApproverDetails.class);

		setModelImplClass(SharedRotationApproverDetailsImpl.class);
		setModelPKClass(long.class);

		setTable(SharedRotationApproverDetailsTable.INSTANCE);
	}

	/**
	 * Caches the shared rotation approver details in the entity cache if it is enabled.
	 *
	 * @param sharedRotationApproverDetails the shared rotation approver details
	 */
	@Override
	public void cacheResult(
		SharedRotationApproverDetails sharedRotationApproverDetails) {

		entityCache.putResult(
			SharedRotationApproverDetailsImpl.class,
			sharedRotationApproverDetails.getPrimaryKey(),
			sharedRotationApproverDetails);

		finderCache.putResult(
			_finderPathFetchByUUID_G,
			new Object[] {
				sharedRotationApproverDetails.getUuid(),
				sharedRotationApproverDetails.getGroupId()
			},
			sharedRotationApproverDetails);

		finderCache.putResult(
			_finderPathFetchBySharedRotationRequestDetailsId,
			new Object[] {
				sharedRotationApproverDetails.
					getSharedRotationRequestDetailsId()
			},
			sharedRotationApproverDetails);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the shared rotation approver detailses in the entity cache if it is enabled.
	 *
	 * @param sharedRotationApproverDetailses the shared rotation approver detailses
	 */
	@Override
	public void cacheResult(
		List<SharedRotationApproverDetails> sharedRotationApproverDetailses) {

		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (sharedRotationApproverDetailses.size() >
				 _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (SharedRotationApproverDetails sharedRotationApproverDetails :
				sharedRotationApproverDetailses) {

			if (entityCache.getResult(
					SharedRotationApproverDetailsImpl.class,
					sharedRotationApproverDetails.getPrimaryKey()) == null) {

				cacheResult(sharedRotationApproverDetails);
			}
		}
	}

	/**
	 * Clears the cache for all shared rotation approver detailses.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(SharedRotationApproverDetailsImpl.class);

		finderCache.clearCache(SharedRotationApproverDetailsImpl.class);
	}

	/**
	 * Clears the cache for the shared rotation approver details.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(
		SharedRotationApproverDetails sharedRotationApproverDetails) {

		entityCache.removeResult(
			SharedRotationApproverDetailsImpl.class,
			sharedRotationApproverDetails);
	}

	@Override
	public void clearCache(
		List<SharedRotationApproverDetails> sharedRotationApproverDetailses) {

		for (SharedRotationApproverDetails sharedRotationApproverDetails :
				sharedRotationApproverDetailses) {

			entityCache.removeResult(
				SharedRotationApproverDetailsImpl.class,
				sharedRotationApproverDetails);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(SharedRotationApproverDetailsImpl.class);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(
				SharedRotationApproverDetailsImpl.class, primaryKey);
		}
	}

	protected void cacheUniqueFindersCache(
		SharedRotationApproverDetailsModelImpl
			sharedRotationApproverDetailsModelImpl) {

		Object[] args = new Object[] {
			sharedRotationApproverDetailsModelImpl.getUuid(),
			sharedRotationApproverDetailsModelImpl.getGroupId()
		};

		finderCache.putResult(_finderPathCountByUUID_G, args, Long.valueOf(1));
		finderCache.putResult(
			_finderPathFetchByUUID_G, args,
			sharedRotationApproverDetailsModelImpl);

		args = new Object[] {
			sharedRotationApproverDetailsModelImpl.
				getSharedRotationRequestDetailsId()
		};

		finderCache.putResult(
			_finderPathCountBySharedRotationRequestDetailsId, args,
			Long.valueOf(1));
		finderCache.putResult(
			_finderPathFetchBySharedRotationRequestDetailsId, args,
			sharedRotationApproverDetailsModelImpl);
	}

	/**
	 * Creates a new shared rotation approver details with the primary key. Does not add the shared rotation approver details to the database.
	 *
	 * @param sharedRotationApproverDetailsId the primary key for the new shared rotation approver details
	 * @return the new shared rotation approver details
	 */
	@Override
	public SharedRotationApproverDetails create(
		long sharedRotationApproverDetailsId) {

		SharedRotationApproverDetails sharedRotationApproverDetails =
			new SharedRotationApproverDetailsImpl();

		sharedRotationApproverDetails.setNew(true);
		sharedRotationApproverDetails.setPrimaryKey(
			sharedRotationApproverDetailsId);

		String uuid = _portalUUID.generate();

		sharedRotationApproverDetails.setUuid(uuid);

		sharedRotationApproverDetails.setCompanyId(
			CompanyThreadLocal.getCompanyId());

		return sharedRotationApproverDetails;
	}

	/**
	 * Removes the shared rotation approver details with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param sharedRotationApproverDetailsId the primary key of the shared rotation approver details
	 * @return the shared rotation approver details that was removed
	 * @throws NoSuchSharedRotationApproverDetailsException if a shared rotation approver details with the primary key could not be found
	 */
	@Override
	public SharedRotationApproverDetails remove(
			long sharedRotationApproverDetailsId)
		throws NoSuchSharedRotationApproverDetailsException {

		return remove((Serializable)sharedRotationApproverDetailsId);
	}

	/**
	 * Removes the shared rotation approver details with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the shared rotation approver details
	 * @return the shared rotation approver details that was removed
	 * @throws NoSuchSharedRotationApproverDetailsException if a shared rotation approver details with the primary key could not be found
	 */
	@Override
	public SharedRotationApproverDetails remove(Serializable primaryKey)
		throws NoSuchSharedRotationApproverDetailsException {

		Session session = null;

		try {
			session = openSession();

			SharedRotationApproverDetails sharedRotationApproverDetails =
				(SharedRotationApproverDetails)session.get(
					SharedRotationApproverDetailsImpl.class, primaryKey);

			if (sharedRotationApproverDetails == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchSharedRotationApproverDetailsException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(sharedRotationApproverDetails);
		}
		catch (NoSuchSharedRotationApproverDetailsException
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
	protected SharedRotationApproverDetails removeImpl(
		SharedRotationApproverDetails sharedRotationApproverDetails) {

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(sharedRotationApproverDetails)) {
				sharedRotationApproverDetails =
					(SharedRotationApproverDetails)session.get(
						SharedRotationApproverDetailsImpl.class,
						sharedRotationApproverDetails.getPrimaryKeyObj());
			}

			if (sharedRotationApproverDetails != null) {
				session.delete(sharedRotationApproverDetails);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (sharedRotationApproverDetails != null) {
			clearCache(sharedRotationApproverDetails);
		}

		return sharedRotationApproverDetails;
	}

	@Override
	public SharedRotationApproverDetails updateImpl(
		SharedRotationApproverDetails sharedRotationApproverDetails) {

		boolean isNew = sharedRotationApproverDetails.isNew();

		if (!(sharedRotationApproverDetails instanceof
				SharedRotationApproverDetailsModelImpl)) {

			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(
					sharedRotationApproverDetails.getClass())) {

				invocationHandler = ProxyUtil.getInvocationHandler(
					sharedRotationApproverDetails);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in sharedRotationApproverDetails proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom SharedRotationApproverDetails implementation " +
					sharedRotationApproverDetails.getClass());
		}

		SharedRotationApproverDetailsModelImpl
			sharedRotationApproverDetailsModelImpl =
				(SharedRotationApproverDetailsModelImpl)
					sharedRotationApproverDetails;

		if (Validator.isNull(sharedRotationApproverDetails.getUuid())) {
			String uuid = _portalUUID.generate();

			sharedRotationApproverDetails.setUuid(uuid);
		}

		ServiceContext serviceContext =
			ServiceContextThreadLocal.getServiceContext();

		Date date = new Date();

		if (isNew && (sharedRotationApproverDetails.getCreateDate() == null)) {
			if (serviceContext == null) {
				sharedRotationApproverDetails.setCreateDate(date);
			}
			else {
				sharedRotationApproverDetails.setCreateDate(
					serviceContext.getCreateDate(date));
			}
		}

		if (!sharedRotationApproverDetailsModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				sharedRotationApproverDetails.setModifiedDate(date);
			}
			else {
				sharedRotationApproverDetails.setModifiedDate(
					serviceContext.getModifiedDate(date));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(sharedRotationApproverDetails);
			}
			else {
				sharedRotationApproverDetails =
					(SharedRotationApproverDetails)session.merge(
						sharedRotationApproverDetails);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(
			SharedRotationApproverDetailsImpl.class,
			sharedRotationApproverDetailsModelImpl, false, true);

		cacheUniqueFindersCache(sharedRotationApproverDetailsModelImpl);

		if (isNew) {
			sharedRotationApproverDetails.setNew(false);
		}

		sharedRotationApproverDetails.resetOriginalValues();

		return sharedRotationApproverDetails;
	}

	/**
	 * Returns the shared rotation approver details with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the shared rotation approver details
	 * @return the shared rotation approver details
	 * @throws NoSuchSharedRotationApproverDetailsException if a shared rotation approver details with the primary key could not be found
	 */
	@Override
	public SharedRotationApproverDetails findByPrimaryKey(
			Serializable primaryKey)
		throws NoSuchSharedRotationApproverDetailsException {

		SharedRotationApproverDetails sharedRotationApproverDetails =
			fetchByPrimaryKey(primaryKey);

		if (sharedRotationApproverDetails == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchSharedRotationApproverDetailsException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return sharedRotationApproverDetails;
	}

	/**
	 * Returns the shared rotation approver details with the primary key or throws a <code>NoSuchSharedRotationApproverDetailsException</code> if it could not be found.
	 *
	 * @param sharedRotationApproverDetailsId the primary key of the shared rotation approver details
	 * @return the shared rotation approver details
	 * @throws NoSuchSharedRotationApproverDetailsException if a shared rotation approver details with the primary key could not be found
	 */
	@Override
	public SharedRotationApproverDetails findByPrimaryKey(
			long sharedRotationApproverDetailsId)
		throws NoSuchSharedRotationApproverDetailsException {

		return findByPrimaryKey((Serializable)sharedRotationApproverDetailsId);
	}

	/**
	 * Returns the shared rotation approver details with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param sharedRotationApproverDetailsId the primary key of the shared rotation approver details
	 * @return the shared rotation approver details, or <code>null</code> if a shared rotation approver details with the primary key could not be found
	 */
	@Override
	public SharedRotationApproverDetails fetchByPrimaryKey(
		long sharedRotationApproverDetailsId) {

		return fetchByPrimaryKey((Serializable)sharedRotationApproverDetailsId);
	}

	/**
	 * Returns all the shared rotation approver detailses.
	 *
	 * @return the shared rotation approver detailses
	 */
	@Override
	public List<SharedRotationApproverDetails> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the shared rotation approver detailses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SharedRotationApproverDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of shared rotation approver detailses
	 * @param end the upper bound of the range of shared rotation approver detailses (not inclusive)
	 * @return the range of shared rotation approver detailses
	 */
	@Override
	public List<SharedRotationApproverDetails> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the shared rotation approver detailses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SharedRotationApproverDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of shared rotation approver detailses
	 * @param end the upper bound of the range of shared rotation approver detailses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of shared rotation approver detailses
	 */
	@Override
	public List<SharedRotationApproverDetails> findAll(
		int start, int end,
		OrderByComparator<SharedRotationApproverDetails> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the shared rotation approver detailses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SharedRotationApproverDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of shared rotation approver detailses
	 * @param end the upper bound of the range of shared rotation approver detailses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of shared rotation approver detailses
	 */
	@Override
	public List<SharedRotationApproverDetails> findAll(
		int start, int end,
		OrderByComparator<SharedRotationApproverDetails> orderByComparator,
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

		List<SharedRotationApproverDetails> list = null;

		if (useFinderCache) {
			list = (List<SharedRotationApproverDetails>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_SHAREDROTATIONAPPROVERDETAILS);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_SHAREDROTATIONAPPROVERDETAILS;

				sql = sql.concat(
					SharedRotationApproverDetailsModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<SharedRotationApproverDetails>)QueryUtil.list(
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
	 * Removes all the shared rotation approver detailses from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (SharedRotationApproverDetails sharedRotationApproverDetails :
				findAll()) {

			remove(sharedRotationApproverDetails);
		}
	}

	/**
	 * Returns the number of shared rotation approver detailses.
	 *
	 * @return the number of shared rotation approver detailses
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
					_SQL_COUNT_SHAREDROTATIONAPPROVERDETAILS);

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
		return "shared_rotation_approver_details_id";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_SHAREDROTATIONAPPROVERDETAILS;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return SharedRotationApproverDetailsModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the shared rotation approver details persistence.
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

		_finderPathFetchBySharedRotationRequestDetailsId = new FinderPath(
			FINDER_CLASS_NAME_ENTITY, "fetchBySharedRotationRequestDetailsId",
			new String[] {Long.class.getName()},
			new String[] {"shared_rotation_request_details_id"}, true);

		_finderPathCountBySharedRotationRequestDetailsId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countBySharedRotationRequestDetailsId",
			new String[] {Long.class.getName()},
			new String[] {"shared_rotation_request_details_id"}, false);

		_setSharedRotationApproverDetailsUtilPersistence(this);
	}

	@Deactivate
	public void deactivate() {
		_setSharedRotationApproverDetailsUtilPersistence(null);

		entityCache.removeCache(
			SharedRotationApproverDetailsImpl.class.getName());
	}

	private void _setSharedRotationApproverDetailsUtilPersistence(
		SharedRotationApproverDetailsPersistence
			sharedRotationApproverDetailsPersistence) {

		try {
			Field field =
				SharedRotationApproverDetailsUtil.class.getDeclaredField(
					"_persistence");

			field.setAccessible(true);

			field.set(null, sharedRotationApproverDetailsPersistence);
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

	private static final String _SQL_SELECT_SHAREDROTATIONAPPROVERDETAILS =
		"SELECT sharedRotationApproverDetails FROM SharedRotationApproverDetails sharedRotationApproverDetails";

	private static final String
		_SQL_SELECT_SHAREDROTATIONAPPROVERDETAILS_WHERE =
			"SELECT sharedRotationApproverDetails FROM SharedRotationApproverDetails sharedRotationApproverDetails WHERE ";

	private static final String _SQL_COUNT_SHAREDROTATIONAPPROVERDETAILS =
		"SELECT COUNT(sharedRotationApproverDetails) FROM SharedRotationApproverDetails sharedRotationApproverDetails";

	private static final String _SQL_COUNT_SHAREDROTATIONAPPROVERDETAILS_WHERE =
		"SELECT COUNT(sharedRotationApproverDetails) FROM SharedRotationApproverDetails sharedRotationApproverDetails WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS =
		"sharedRotationApproverDetails.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No SharedRotationApproverDetails exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No SharedRotationApproverDetails exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		SharedRotationApproverDetailsPersistenceImpl.class);

	private static final Set<String> _badColumnNames = SetUtil.fromArray(
		new String[] {
			"uuid", "sharedRotationApproverDetailsId",
			"sharedRotationRequestDetailsId", "groupId", "companyId",
			"createDate", "createdBy", "modifiedDate", "modifiedBy",
			"approvedTrainees", "rejectedTrainees", "approversComment",
			"decisionMakingDate"
		});

	@Override
	protected FinderCache getFinderCache() {
		return finderCache;
	}

	@Reference
	private PortalUUID _portalUUID;

}
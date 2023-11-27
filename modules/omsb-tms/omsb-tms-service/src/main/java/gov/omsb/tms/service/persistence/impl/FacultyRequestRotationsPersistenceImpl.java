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

import gov.omsb.tms.exception.NoSuchFacultyRequestRotationsException;
import gov.omsb.tms.model.FacultyRequestRotations;
import gov.omsb.tms.model.FacultyRequestRotationsTable;
import gov.omsb.tms.model.impl.FacultyRequestRotationsImpl;
import gov.omsb.tms.model.impl.FacultyRequestRotationsModelImpl;
import gov.omsb.tms.service.persistence.FacultyRequestRotationsPersistence;
import gov.omsb.tms.service.persistence.FacultyRequestRotationsUtil;
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
 * The persistence implementation for the faculty request rotations service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = FacultyRequestRotationsPersistence.class)
public class FacultyRequestRotationsPersistenceImpl
	extends BasePersistenceImpl<FacultyRequestRotations>
	implements FacultyRequestRotationsPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>FacultyRequestRotationsUtil</code> to access the faculty request rotations persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		FacultyRequestRotationsImpl.class.getName();

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
	 * Returns all the faculty request rotationses where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching faculty request rotationses
	 */
	@Override
	public List<FacultyRequestRotations> findByUuid(String uuid) {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the faculty request rotationses where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FacultyRequestRotationsModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of faculty request rotationses
	 * @param end the upper bound of the range of faculty request rotationses (not inclusive)
	 * @return the range of matching faculty request rotationses
	 */
	@Override
	public List<FacultyRequestRotations> findByUuid(
		String uuid, int start, int end) {

		return findByUuid(uuid, start, end, null);
	}

	/**
	 * Returns an ordered range of all the faculty request rotationses where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FacultyRequestRotationsModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of faculty request rotationses
	 * @param end the upper bound of the range of faculty request rotationses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching faculty request rotationses
	 */
	@Override
	public List<FacultyRequestRotations> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<FacultyRequestRotations> orderByComparator) {

		return findByUuid(uuid, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the faculty request rotationses where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FacultyRequestRotationsModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of faculty request rotationses
	 * @param end the upper bound of the range of faculty request rotationses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching faculty request rotationses
	 */
	@Override
	public List<FacultyRequestRotations> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<FacultyRequestRotations> orderByComparator,
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

		List<FacultyRequestRotations> list = null;

		if (useFinderCache) {
			list = (List<FacultyRequestRotations>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (FacultyRequestRotations facultyRequestRotations : list) {
					if (!uuid.equals(facultyRequestRotations.getUuid())) {
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

			sb.append(_SQL_SELECT_FACULTYREQUESTROTATIONS_WHERE);

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
				sb.append(FacultyRequestRotationsModelImpl.ORDER_BY_JPQL);
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

				list = (List<FacultyRequestRotations>)QueryUtil.list(
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
	 * Returns the first faculty request rotations in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching faculty request rotations
	 * @throws NoSuchFacultyRequestRotationsException if a matching faculty request rotations could not be found
	 */
	@Override
	public FacultyRequestRotations findByUuid_First(
			String uuid,
			OrderByComparator<FacultyRequestRotations> orderByComparator)
		throws NoSuchFacultyRequestRotationsException {

		FacultyRequestRotations facultyRequestRotations = fetchByUuid_First(
			uuid, orderByComparator);

		if (facultyRequestRotations != null) {
			return facultyRequestRotations;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchFacultyRequestRotationsException(sb.toString());
	}

	/**
	 * Returns the first faculty request rotations in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching faculty request rotations, or <code>null</code> if a matching faculty request rotations could not be found
	 */
	@Override
	public FacultyRequestRotations fetchByUuid_First(
		String uuid,
		OrderByComparator<FacultyRequestRotations> orderByComparator) {

		List<FacultyRequestRotations> list = findByUuid(
			uuid, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last faculty request rotations in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching faculty request rotations
	 * @throws NoSuchFacultyRequestRotationsException if a matching faculty request rotations could not be found
	 */
	@Override
	public FacultyRequestRotations findByUuid_Last(
			String uuid,
			OrderByComparator<FacultyRequestRotations> orderByComparator)
		throws NoSuchFacultyRequestRotationsException {

		FacultyRequestRotations facultyRequestRotations = fetchByUuid_Last(
			uuid, orderByComparator);

		if (facultyRequestRotations != null) {
			return facultyRequestRotations;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchFacultyRequestRotationsException(sb.toString());
	}

	/**
	 * Returns the last faculty request rotations in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching faculty request rotations, or <code>null</code> if a matching faculty request rotations could not be found
	 */
	@Override
	public FacultyRequestRotations fetchByUuid_Last(
		String uuid,
		OrderByComparator<FacultyRequestRotations> orderByComparator) {

		int count = countByUuid(uuid);

		if (count == 0) {
			return null;
		}

		List<FacultyRequestRotations> list = findByUuid(
			uuid, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the faculty request rotationses before and after the current faculty request rotations in the ordered set where uuid = &#63;.
	 *
	 * @param facultyRequestRotationsId the primary key of the current faculty request rotations
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next faculty request rotations
	 * @throws NoSuchFacultyRequestRotationsException if a faculty request rotations with the primary key could not be found
	 */
	@Override
	public FacultyRequestRotations[] findByUuid_PrevAndNext(
			long facultyRequestRotationsId, String uuid,
			OrderByComparator<FacultyRequestRotations> orderByComparator)
		throws NoSuchFacultyRequestRotationsException {

		uuid = Objects.toString(uuid, "");

		FacultyRequestRotations facultyRequestRotations = findByPrimaryKey(
			facultyRequestRotationsId);

		Session session = null;

		try {
			session = openSession();

			FacultyRequestRotations[] array =
				new FacultyRequestRotationsImpl[3];

			array[0] = getByUuid_PrevAndNext(
				session, facultyRequestRotations, uuid, orderByComparator,
				true);

			array[1] = facultyRequestRotations;

			array[2] = getByUuid_PrevAndNext(
				session, facultyRequestRotations, uuid, orderByComparator,
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

	protected FacultyRequestRotations getByUuid_PrevAndNext(
		Session session, FacultyRequestRotations facultyRequestRotations,
		String uuid,
		OrderByComparator<FacultyRequestRotations> orderByComparator,
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

		sb.append(_SQL_SELECT_FACULTYREQUESTROTATIONS_WHERE);

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
			sb.append(FacultyRequestRotationsModelImpl.ORDER_BY_JPQL);
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
						facultyRequestRotations)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<FacultyRequestRotations> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the faculty request rotationses where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	@Override
	public void removeByUuid(String uuid) {
		for (FacultyRequestRotations facultyRequestRotations :
				findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(facultyRequestRotations);
		}
	}

	/**
	 * Returns the number of faculty request rotationses where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching faculty request rotationses
	 */
	@Override
	public int countByUuid(String uuid) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid;

		Object[] finderArgs = new Object[] {uuid};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_FACULTYREQUESTROTATIONS_WHERE);

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
		"facultyRequestRotations.uuid = ?";

	private static final String _FINDER_COLUMN_UUID_UUID_3 =
		"(facultyRequestRotations.uuid IS NULL OR facultyRequestRotations.uuid = '')";

	private FinderPath _finderPathFetchByUUID_G;
	private FinderPath _finderPathCountByUUID_G;

	/**
	 * Returns the faculty request rotations where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchFacultyRequestRotationsException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching faculty request rotations
	 * @throws NoSuchFacultyRequestRotationsException if a matching faculty request rotations could not be found
	 */
	@Override
	public FacultyRequestRotations findByUUID_G(String uuid, long groupId)
		throws NoSuchFacultyRequestRotationsException {

		FacultyRequestRotations facultyRequestRotations = fetchByUUID_G(
			uuid, groupId);

		if (facultyRequestRotations == null) {
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

			throw new NoSuchFacultyRequestRotationsException(sb.toString());
		}

		return facultyRequestRotations;
	}

	/**
	 * Returns the faculty request rotations where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching faculty request rotations, or <code>null</code> if a matching faculty request rotations could not be found
	 */
	@Override
	public FacultyRequestRotations fetchByUUID_G(String uuid, long groupId) {
		return fetchByUUID_G(uuid, groupId, true);
	}

	/**
	 * Returns the faculty request rotations where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching faculty request rotations, or <code>null</code> if a matching faculty request rotations could not be found
	 */
	@Override
	public FacultyRequestRotations fetchByUUID_G(
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

		if (result instanceof FacultyRequestRotations) {
			FacultyRequestRotations facultyRequestRotations =
				(FacultyRequestRotations)result;

			if (!Objects.equals(uuid, facultyRequestRotations.getUuid()) ||
				(groupId != facultyRequestRotations.getGroupId())) {

				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_SQL_SELECT_FACULTYREQUESTROTATIONS_WHERE);

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

				List<FacultyRequestRotations> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchByUUID_G, finderArgs, list);
					}
				}
				else {
					FacultyRequestRotations facultyRequestRotations = list.get(
						0);

					result = facultyRequestRotations;

					cacheResult(facultyRequestRotations);
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
			return (FacultyRequestRotations)result;
		}
	}

	/**
	 * Removes the faculty request rotations where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the faculty request rotations that was removed
	 */
	@Override
	public FacultyRequestRotations removeByUUID_G(String uuid, long groupId)
		throws NoSuchFacultyRequestRotationsException {

		FacultyRequestRotations facultyRequestRotations = findByUUID_G(
			uuid, groupId);

		return remove(facultyRequestRotations);
	}

	/**
	 * Returns the number of faculty request rotationses where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching faculty request rotationses
	 */
	@Override
	public int countByUUID_G(String uuid, long groupId) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUUID_G;

		Object[] finderArgs = new Object[] {uuid, groupId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_FACULTYREQUESTROTATIONS_WHERE);

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
		"facultyRequestRotations.uuid = ? AND ";

	private static final String _FINDER_COLUMN_UUID_G_UUID_3 =
		"(facultyRequestRotations.uuid IS NULL OR facultyRequestRotations.uuid = '') AND ";

	private static final String _FINDER_COLUMN_UUID_G_GROUPID_2 =
		"facultyRequestRotations.groupId = ?";

	private FinderPath _finderPathWithPaginationFindByUuid_C;
	private FinderPath _finderPathWithoutPaginationFindByUuid_C;
	private FinderPath _finderPathCountByUuid_C;

	/**
	 * Returns all the faculty request rotationses where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching faculty request rotationses
	 */
	@Override
	public List<FacultyRequestRotations> findByUuid_C(
		String uuid, long companyId) {

		return findByUuid_C(
			uuid, companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the faculty request rotationses where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FacultyRequestRotationsModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of faculty request rotationses
	 * @param end the upper bound of the range of faculty request rotationses (not inclusive)
	 * @return the range of matching faculty request rotationses
	 */
	@Override
	public List<FacultyRequestRotations> findByUuid_C(
		String uuid, long companyId, int start, int end) {

		return findByUuid_C(uuid, companyId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the faculty request rotationses where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FacultyRequestRotationsModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of faculty request rotationses
	 * @param end the upper bound of the range of faculty request rotationses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching faculty request rotationses
	 */
	@Override
	public List<FacultyRequestRotations> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<FacultyRequestRotations> orderByComparator) {

		return findByUuid_C(
			uuid, companyId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the faculty request rotationses where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FacultyRequestRotationsModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of faculty request rotationses
	 * @param end the upper bound of the range of faculty request rotationses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching faculty request rotationses
	 */
	@Override
	public List<FacultyRequestRotations> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<FacultyRequestRotations> orderByComparator,
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

		List<FacultyRequestRotations> list = null;

		if (useFinderCache) {
			list = (List<FacultyRequestRotations>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (FacultyRequestRotations facultyRequestRotations : list) {
					if (!uuid.equals(facultyRequestRotations.getUuid()) ||
						(companyId != facultyRequestRotations.getCompanyId())) {

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

			sb.append(_SQL_SELECT_FACULTYREQUESTROTATIONS_WHERE);

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
				sb.append(FacultyRequestRotationsModelImpl.ORDER_BY_JPQL);
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

				list = (List<FacultyRequestRotations>)QueryUtil.list(
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
	 * Returns the first faculty request rotations in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching faculty request rotations
	 * @throws NoSuchFacultyRequestRotationsException if a matching faculty request rotations could not be found
	 */
	@Override
	public FacultyRequestRotations findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<FacultyRequestRotations> orderByComparator)
		throws NoSuchFacultyRequestRotationsException {

		FacultyRequestRotations facultyRequestRotations = fetchByUuid_C_First(
			uuid, companyId, orderByComparator);

		if (facultyRequestRotations != null) {
			return facultyRequestRotations;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append(", companyId=");
		sb.append(companyId);

		sb.append("}");

		throw new NoSuchFacultyRequestRotationsException(sb.toString());
	}

	/**
	 * Returns the first faculty request rotations in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching faculty request rotations, or <code>null</code> if a matching faculty request rotations could not be found
	 */
	@Override
	public FacultyRequestRotations fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<FacultyRequestRotations> orderByComparator) {

		List<FacultyRequestRotations> list = findByUuid_C(
			uuid, companyId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last faculty request rotations in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching faculty request rotations
	 * @throws NoSuchFacultyRequestRotationsException if a matching faculty request rotations could not be found
	 */
	@Override
	public FacultyRequestRotations findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<FacultyRequestRotations> orderByComparator)
		throws NoSuchFacultyRequestRotationsException {

		FacultyRequestRotations facultyRequestRotations = fetchByUuid_C_Last(
			uuid, companyId, orderByComparator);

		if (facultyRequestRotations != null) {
			return facultyRequestRotations;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append(", companyId=");
		sb.append(companyId);

		sb.append("}");

		throw new NoSuchFacultyRequestRotationsException(sb.toString());
	}

	/**
	 * Returns the last faculty request rotations in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching faculty request rotations, or <code>null</code> if a matching faculty request rotations could not be found
	 */
	@Override
	public FacultyRequestRotations fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<FacultyRequestRotations> orderByComparator) {

		int count = countByUuid_C(uuid, companyId);

		if (count == 0) {
			return null;
		}

		List<FacultyRequestRotations> list = findByUuid_C(
			uuid, companyId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the faculty request rotationses before and after the current faculty request rotations in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param facultyRequestRotationsId the primary key of the current faculty request rotations
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next faculty request rotations
	 * @throws NoSuchFacultyRequestRotationsException if a faculty request rotations with the primary key could not be found
	 */
	@Override
	public FacultyRequestRotations[] findByUuid_C_PrevAndNext(
			long facultyRequestRotationsId, String uuid, long companyId,
			OrderByComparator<FacultyRequestRotations> orderByComparator)
		throws NoSuchFacultyRequestRotationsException {

		uuid = Objects.toString(uuid, "");

		FacultyRequestRotations facultyRequestRotations = findByPrimaryKey(
			facultyRequestRotationsId);

		Session session = null;

		try {
			session = openSession();

			FacultyRequestRotations[] array =
				new FacultyRequestRotationsImpl[3];

			array[0] = getByUuid_C_PrevAndNext(
				session, facultyRequestRotations, uuid, companyId,
				orderByComparator, true);

			array[1] = facultyRequestRotations;

			array[2] = getByUuid_C_PrevAndNext(
				session, facultyRequestRotations, uuid, companyId,
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

	protected FacultyRequestRotations getByUuid_C_PrevAndNext(
		Session session, FacultyRequestRotations facultyRequestRotations,
		String uuid, long companyId,
		OrderByComparator<FacultyRequestRotations> orderByComparator,
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

		sb.append(_SQL_SELECT_FACULTYREQUESTROTATIONS_WHERE);

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
			sb.append(FacultyRequestRotationsModelImpl.ORDER_BY_JPQL);
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
						facultyRequestRotations)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<FacultyRequestRotations> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the faculty request rotationses where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	@Override
	public void removeByUuid_C(String uuid, long companyId) {
		for (FacultyRequestRotations facultyRequestRotations :
				findByUuid_C(
					uuid, companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(facultyRequestRotations);
		}
	}

	/**
	 * Returns the number of faculty request rotationses where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching faculty request rotationses
	 */
	@Override
	public int countByUuid_C(String uuid, long companyId) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid_C;

		Object[] finderArgs = new Object[] {uuid, companyId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_FACULTYREQUESTROTATIONS_WHERE);

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
		"facultyRequestRotations.uuid = ? AND ";

	private static final String _FINDER_COLUMN_UUID_C_UUID_3 =
		"(facultyRequestRotations.uuid IS NULL OR facultyRequestRotations.uuid = '') AND ";

	private static final String _FINDER_COLUMN_UUID_C_COMPANYID_2 =
		"facultyRequestRotations.companyId = ?";

	private FinderPath _finderPathFetchByfacultyRequestIdAndIsActive;
	private FinderPath _finderPathCountByfacultyRequestIdAndIsActive;

	/**
	 * Returns the faculty request rotations where facultyRequestId = &#63; and isActive = &#63; or throws a <code>NoSuchFacultyRequestRotationsException</code> if it could not be found.
	 *
	 * @param facultyRequestId the faculty request ID
	 * @param isActive the is active
	 * @return the matching faculty request rotations
	 * @throws NoSuchFacultyRequestRotationsException if a matching faculty request rotations could not be found
	 */
	@Override
	public FacultyRequestRotations findByfacultyRequestIdAndIsActive(
			long facultyRequestId, boolean isActive)
		throws NoSuchFacultyRequestRotationsException {

		FacultyRequestRotations facultyRequestRotations =
			fetchByfacultyRequestIdAndIsActive(facultyRequestId, isActive);

		if (facultyRequestRotations == null) {
			StringBundler sb = new StringBundler(6);

			sb.append(_NO_SUCH_ENTITY_WITH_KEY);

			sb.append("facultyRequestId=");
			sb.append(facultyRequestId);

			sb.append(", isActive=");
			sb.append(isActive);

			sb.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(sb.toString());
			}

			throw new NoSuchFacultyRequestRotationsException(sb.toString());
		}

		return facultyRequestRotations;
	}

	/**
	 * Returns the faculty request rotations where facultyRequestId = &#63; and isActive = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param facultyRequestId the faculty request ID
	 * @param isActive the is active
	 * @return the matching faculty request rotations, or <code>null</code> if a matching faculty request rotations could not be found
	 */
	@Override
	public FacultyRequestRotations fetchByfacultyRequestIdAndIsActive(
		long facultyRequestId, boolean isActive) {

		return fetchByfacultyRequestIdAndIsActive(
			facultyRequestId, isActive, true);
	}

	/**
	 * Returns the faculty request rotations where facultyRequestId = &#63; and isActive = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param facultyRequestId the faculty request ID
	 * @param isActive the is active
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching faculty request rotations, or <code>null</code> if a matching faculty request rotations could not be found
	 */
	@Override
	public FacultyRequestRotations fetchByfacultyRequestIdAndIsActive(
		long facultyRequestId, boolean isActive, boolean useFinderCache) {

		Object[] finderArgs = null;

		if (useFinderCache) {
			finderArgs = new Object[] {facultyRequestId, isActive};
		}

		Object result = null;

		if (useFinderCache) {
			result = finderCache.getResult(
				_finderPathFetchByfacultyRequestIdAndIsActive, finderArgs,
				this);
		}

		if (result instanceof FacultyRequestRotations) {
			FacultyRequestRotations facultyRequestRotations =
				(FacultyRequestRotations)result;

			if ((facultyRequestId !=
					facultyRequestRotations.getFacultyRequestId()) ||
				(isActive != facultyRequestRotations.isIsActive())) {

				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_SQL_SELECT_FACULTYREQUESTROTATIONS_WHERE);

			sb.append(
				_FINDER_COLUMN_FACULTYREQUESTIDANDISACTIVE_FACULTYREQUESTID_2);

			sb.append(_FINDER_COLUMN_FACULTYREQUESTIDANDISACTIVE_ISACTIVE_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(facultyRequestId);

				queryPos.add(isActive);

				List<FacultyRequestRotations> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchByfacultyRequestIdAndIsActive,
							finderArgs, list);
					}
				}
				else {
					if (list.size() > 1) {
						Collections.sort(list, Collections.reverseOrder());

						if (_log.isWarnEnabled()) {
							if (!useFinderCache) {
								finderArgs = new Object[] {
									facultyRequestId, isActive
								};
							}

							_log.warn(
								"FacultyRequestRotationsPersistenceImpl.fetchByfacultyRequestIdAndIsActive(long, boolean, boolean) with parameters (" +
									StringUtil.merge(finderArgs) +
										") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
						}
					}

					FacultyRequestRotations facultyRequestRotations = list.get(
						0);

					result = facultyRequestRotations;

					cacheResult(facultyRequestRotations);
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
			return (FacultyRequestRotations)result;
		}
	}

	/**
	 * Removes the faculty request rotations where facultyRequestId = &#63; and isActive = &#63; from the database.
	 *
	 * @param facultyRequestId the faculty request ID
	 * @param isActive the is active
	 * @return the faculty request rotations that was removed
	 */
	@Override
	public FacultyRequestRotations removeByfacultyRequestIdAndIsActive(
			long facultyRequestId, boolean isActive)
		throws NoSuchFacultyRequestRotationsException {

		FacultyRequestRotations facultyRequestRotations =
			findByfacultyRequestIdAndIsActive(facultyRequestId, isActive);

		return remove(facultyRequestRotations);
	}

	/**
	 * Returns the number of faculty request rotationses where facultyRequestId = &#63; and isActive = &#63;.
	 *
	 * @param facultyRequestId the faculty request ID
	 * @param isActive the is active
	 * @return the number of matching faculty request rotationses
	 */
	@Override
	public int countByfacultyRequestIdAndIsActive(
		long facultyRequestId, boolean isActive) {

		FinderPath finderPath = _finderPathCountByfacultyRequestIdAndIsActive;

		Object[] finderArgs = new Object[] {facultyRequestId, isActive};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_FACULTYREQUESTROTATIONS_WHERE);

			sb.append(
				_FINDER_COLUMN_FACULTYREQUESTIDANDISACTIVE_FACULTYREQUESTID_2);

			sb.append(_FINDER_COLUMN_FACULTYREQUESTIDANDISACTIVE_ISACTIVE_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(facultyRequestId);

				queryPos.add(isActive);

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
		_FINDER_COLUMN_FACULTYREQUESTIDANDISACTIVE_FACULTYREQUESTID_2 =
			"facultyRequestRotations.facultyRequestId = ? AND ";

	private static final String
		_FINDER_COLUMN_FACULTYREQUESTIDANDISACTIVE_ISACTIVE_2 =
			"facultyRequestRotations.isActive = ?";

	public FacultyRequestRotationsPersistenceImpl() {
		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("uuid", "uuid_");
		dbColumnNames.put(
			"facultyRequestRotationsId", "faculty_request_rotations_id");
		dbColumnNames.put("groupId", "group_id");
		dbColumnNames.put("companyId", "company_id");
		dbColumnNames.put("createdBy", "created_by");
		dbColumnNames.put("createDate", "create_date");
		dbColumnNames.put("modifiedDate", "modified_date");
		dbColumnNames.put("modifiedBy", "modified_by");
		dbColumnNames.put("facultyRequestId", "faculty_request_id");
		dbColumnNames.put("trainingSiteId", "training_site_id");
		dbColumnNames.put("rotationId", "rotation_id");
		dbColumnNames.put("isActive", "is_active");

		setDBColumnNames(dbColumnNames);

		setModelClass(FacultyRequestRotations.class);

		setModelImplClass(FacultyRequestRotationsImpl.class);
		setModelPKClass(long.class);

		setTable(FacultyRequestRotationsTable.INSTANCE);
	}

	/**
	 * Caches the faculty request rotations in the entity cache if it is enabled.
	 *
	 * @param facultyRequestRotations the faculty request rotations
	 */
	@Override
	public void cacheResult(FacultyRequestRotations facultyRequestRotations) {
		entityCache.putResult(
			FacultyRequestRotationsImpl.class,
			facultyRequestRotations.getPrimaryKey(), facultyRequestRotations);

		finderCache.putResult(
			_finderPathFetchByUUID_G,
			new Object[] {
				facultyRequestRotations.getUuid(),
				facultyRequestRotations.getGroupId()
			},
			facultyRequestRotations);

		finderCache.putResult(
			_finderPathFetchByfacultyRequestIdAndIsActive,
			new Object[] {
				facultyRequestRotations.getFacultyRequestId(),
				facultyRequestRotations.isIsActive()
			},
			facultyRequestRotations);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the faculty request rotationses in the entity cache if it is enabled.
	 *
	 * @param facultyRequestRotationses the faculty request rotationses
	 */
	@Override
	public void cacheResult(
		List<FacultyRequestRotations> facultyRequestRotationses) {

		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (facultyRequestRotationses.size() >
				 _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (FacultyRequestRotations facultyRequestRotations :
				facultyRequestRotationses) {

			if (entityCache.getResult(
					FacultyRequestRotationsImpl.class,
					facultyRequestRotations.getPrimaryKey()) == null) {

				cacheResult(facultyRequestRotations);
			}
		}
	}

	/**
	 * Clears the cache for all faculty request rotationses.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(FacultyRequestRotationsImpl.class);

		finderCache.clearCache(FacultyRequestRotationsImpl.class);
	}

	/**
	 * Clears the cache for the faculty request rotations.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(FacultyRequestRotations facultyRequestRotations) {
		entityCache.removeResult(
			FacultyRequestRotationsImpl.class, facultyRequestRotations);
	}

	@Override
	public void clearCache(
		List<FacultyRequestRotations> facultyRequestRotationses) {

		for (FacultyRequestRotations facultyRequestRotations :
				facultyRequestRotationses) {

			entityCache.removeResult(
				FacultyRequestRotationsImpl.class, facultyRequestRotations);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(FacultyRequestRotationsImpl.class);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(
				FacultyRequestRotationsImpl.class, primaryKey);
		}
	}

	protected void cacheUniqueFindersCache(
		FacultyRequestRotationsModelImpl facultyRequestRotationsModelImpl) {

		Object[] args = new Object[] {
			facultyRequestRotationsModelImpl.getUuid(),
			facultyRequestRotationsModelImpl.getGroupId()
		};

		finderCache.putResult(_finderPathCountByUUID_G, args, Long.valueOf(1));
		finderCache.putResult(
			_finderPathFetchByUUID_G, args, facultyRequestRotationsModelImpl);

		args = new Object[] {
			facultyRequestRotationsModelImpl.getFacultyRequestId(),
			facultyRequestRotationsModelImpl.isIsActive()
		};

		finderCache.putResult(
			_finderPathCountByfacultyRequestIdAndIsActive, args,
			Long.valueOf(1));
		finderCache.putResult(
			_finderPathFetchByfacultyRequestIdAndIsActive, args,
			facultyRequestRotationsModelImpl);
	}

	/**
	 * Creates a new faculty request rotations with the primary key. Does not add the faculty request rotations to the database.
	 *
	 * @param facultyRequestRotationsId the primary key for the new faculty request rotations
	 * @return the new faculty request rotations
	 */
	@Override
	public FacultyRequestRotations create(long facultyRequestRotationsId) {
		FacultyRequestRotations facultyRequestRotations =
			new FacultyRequestRotationsImpl();

		facultyRequestRotations.setNew(true);
		facultyRequestRotations.setPrimaryKey(facultyRequestRotationsId);

		String uuid = _portalUUID.generate();

		facultyRequestRotations.setUuid(uuid);

		facultyRequestRotations.setCompanyId(CompanyThreadLocal.getCompanyId());

		return facultyRequestRotations;
	}

	/**
	 * Removes the faculty request rotations with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param facultyRequestRotationsId the primary key of the faculty request rotations
	 * @return the faculty request rotations that was removed
	 * @throws NoSuchFacultyRequestRotationsException if a faculty request rotations with the primary key could not be found
	 */
	@Override
	public FacultyRequestRotations remove(long facultyRequestRotationsId)
		throws NoSuchFacultyRequestRotationsException {

		return remove((Serializable)facultyRequestRotationsId);
	}

	/**
	 * Removes the faculty request rotations with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the faculty request rotations
	 * @return the faculty request rotations that was removed
	 * @throws NoSuchFacultyRequestRotationsException if a faculty request rotations with the primary key could not be found
	 */
	@Override
	public FacultyRequestRotations remove(Serializable primaryKey)
		throws NoSuchFacultyRequestRotationsException {

		Session session = null;

		try {
			session = openSession();

			FacultyRequestRotations facultyRequestRotations =
				(FacultyRequestRotations)session.get(
					FacultyRequestRotationsImpl.class, primaryKey);

			if (facultyRequestRotations == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchFacultyRequestRotationsException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(facultyRequestRotations);
		}
		catch (NoSuchFacultyRequestRotationsException noSuchEntityException) {
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
	protected FacultyRequestRotations removeImpl(
		FacultyRequestRotations facultyRequestRotations) {

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(facultyRequestRotations)) {
				facultyRequestRotations = (FacultyRequestRotations)session.get(
					FacultyRequestRotationsImpl.class,
					facultyRequestRotations.getPrimaryKeyObj());
			}

			if (facultyRequestRotations != null) {
				session.delete(facultyRequestRotations);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (facultyRequestRotations != null) {
			clearCache(facultyRequestRotations);
		}

		return facultyRequestRotations;
	}

	@Override
	public FacultyRequestRotations updateImpl(
		FacultyRequestRotations facultyRequestRotations) {

		boolean isNew = facultyRequestRotations.isNew();

		if (!(facultyRequestRotations instanceof
				FacultyRequestRotationsModelImpl)) {

			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(facultyRequestRotations.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(
					facultyRequestRotations);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in facultyRequestRotations proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom FacultyRequestRotations implementation " +
					facultyRequestRotations.getClass());
		}

		FacultyRequestRotationsModelImpl facultyRequestRotationsModelImpl =
			(FacultyRequestRotationsModelImpl)facultyRequestRotations;

		if (Validator.isNull(facultyRequestRotations.getUuid())) {
			String uuid = _portalUUID.generate();

			facultyRequestRotations.setUuid(uuid);
		}

		ServiceContext serviceContext =
			ServiceContextThreadLocal.getServiceContext();

		Date date = new Date();

		if (isNew && (facultyRequestRotations.getCreateDate() == null)) {
			if (serviceContext == null) {
				facultyRequestRotations.setCreateDate(date);
			}
			else {
				facultyRequestRotations.setCreateDate(
					serviceContext.getCreateDate(date));
			}
		}

		if (!facultyRequestRotationsModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				facultyRequestRotations.setModifiedDate(date);
			}
			else {
				facultyRequestRotations.setModifiedDate(
					serviceContext.getModifiedDate(date));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(facultyRequestRotations);
			}
			else {
				facultyRequestRotations =
					(FacultyRequestRotations)session.merge(
						facultyRequestRotations);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(
			FacultyRequestRotationsImpl.class, facultyRequestRotationsModelImpl,
			false, true);

		cacheUniqueFindersCache(facultyRequestRotationsModelImpl);

		if (isNew) {
			facultyRequestRotations.setNew(false);
		}

		facultyRequestRotations.resetOriginalValues();

		return facultyRequestRotations;
	}

	/**
	 * Returns the faculty request rotations with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the faculty request rotations
	 * @return the faculty request rotations
	 * @throws NoSuchFacultyRequestRotationsException if a faculty request rotations with the primary key could not be found
	 */
	@Override
	public FacultyRequestRotations findByPrimaryKey(Serializable primaryKey)
		throws NoSuchFacultyRequestRotationsException {

		FacultyRequestRotations facultyRequestRotations = fetchByPrimaryKey(
			primaryKey);

		if (facultyRequestRotations == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchFacultyRequestRotationsException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return facultyRequestRotations;
	}

	/**
	 * Returns the faculty request rotations with the primary key or throws a <code>NoSuchFacultyRequestRotationsException</code> if it could not be found.
	 *
	 * @param facultyRequestRotationsId the primary key of the faculty request rotations
	 * @return the faculty request rotations
	 * @throws NoSuchFacultyRequestRotationsException if a faculty request rotations with the primary key could not be found
	 */
	@Override
	public FacultyRequestRotations findByPrimaryKey(
			long facultyRequestRotationsId)
		throws NoSuchFacultyRequestRotationsException {

		return findByPrimaryKey((Serializable)facultyRequestRotationsId);
	}

	/**
	 * Returns the faculty request rotations with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param facultyRequestRotationsId the primary key of the faculty request rotations
	 * @return the faculty request rotations, or <code>null</code> if a faculty request rotations with the primary key could not be found
	 */
	@Override
	public FacultyRequestRotations fetchByPrimaryKey(
		long facultyRequestRotationsId) {

		return fetchByPrimaryKey((Serializable)facultyRequestRotationsId);
	}

	/**
	 * Returns all the faculty request rotationses.
	 *
	 * @return the faculty request rotationses
	 */
	@Override
	public List<FacultyRequestRotations> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the faculty request rotationses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FacultyRequestRotationsModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of faculty request rotationses
	 * @param end the upper bound of the range of faculty request rotationses (not inclusive)
	 * @return the range of faculty request rotationses
	 */
	@Override
	public List<FacultyRequestRotations> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the faculty request rotationses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FacultyRequestRotationsModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of faculty request rotationses
	 * @param end the upper bound of the range of faculty request rotationses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of faculty request rotationses
	 */
	@Override
	public List<FacultyRequestRotations> findAll(
		int start, int end,
		OrderByComparator<FacultyRequestRotations> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the faculty request rotationses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FacultyRequestRotationsModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of faculty request rotationses
	 * @param end the upper bound of the range of faculty request rotationses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of faculty request rotationses
	 */
	@Override
	public List<FacultyRequestRotations> findAll(
		int start, int end,
		OrderByComparator<FacultyRequestRotations> orderByComparator,
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

		List<FacultyRequestRotations> list = null;

		if (useFinderCache) {
			list = (List<FacultyRequestRotations>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_FACULTYREQUESTROTATIONS);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_FACULTYREQUESTROTATIONS;

				sql = sql.concat(
					FacultyRequestRotationsModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<FacultyRequestRotations>)QueryUtil.list(
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
	 * Removes all the faculty request rotationses from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (FacultyRequestRotations facultyRequestRotations : findAll()) {
			remove(facultyRequestRotations);
		}
	}

	/**
	 * Returns the number of faculty request rotationses.
	 *
	 * @return the number of faculty request rotationses
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
					_SQL_COUNT_FACULTYREQUESTROTATIONS);

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
		return "faculty_request_rotations_id";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_FACULTYREQUESTROTATIONS;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return FacultyRequestRotationsModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the faculty request rotations persistence.
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

		_finderPathFetchByfacultyRequestIdAndIsActive = new FinderPath(
			FINDER_CLASS_NAME_ENTITY, "fetchByfacultyRequestIdAndIsActive",
			new String[] {Long.class.getName(), Boolean.class.getName()},
			new String[] {"faculty_request_id", "is_active"}, true);

		_finderPathCountByfacultyRequestIdAndIsActive = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByfacultyRequestIdAndIsActive",
			new String[] {Long.class.getName(), Boolean.class.getName()},
			new String[] {"faculty_request_id", "is_active"}, false);

		_setFacultyRequestRotationsUtilPersistence(this);
	}

	@Deactivate
	public void deactivate() {
		_setFacultyRequestRotationsUtilPersistence(null);

		entityCache.removeCache(FacultyRequestRotationsImpl.class.getName());
	}

	private void _setFacultyRequestRotationsUtilPersistence(
		FacultyRequestRotationsPersistence facultyRequestRotationsPersistence) {

		try {
			Field field = FacultyRequestRotationsUtil.class.getDeclaredField(
				"_persistence");

			field.setAccessible(true);

			field.set(null, facultyRequestRotationsPersistence);
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

	private static final String _SQL_SELECT_FACULTYREQUESTROTATIONS =
		"SELECT facultyRequestRotations FROM FacultyRequestRotations facultyRequestRotations";

	private static final String _SQL_SELECT_FACULTYREQUESTROTATIONS_WHERE =
		"SELECT facultyRequestRotations FROM FacultyRequestRotations facultyRequestRotations WHERE ";

	private static final String _SQL_COUNT_FACULTYREQUESTROTATIONS =
		"SELECT COUNT(facultyRequestRotations) FROM FacultyRequestRotations facultyRequestRotations";

	private static final String _SQL_COUNT_FACULTYREQUESTROTATIONS_WHERE =
		"SELECT COUNT(facultyRequestRotations) FROM FacultyRequestRotations facultyRequestRotations WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS =
		"facultyRequestRotations.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No FacultyRequestRotations exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No FacultyRequestRotations exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		FacultyRequestRotationsPersistenceImpl.class);

	private static final Set<String> _badColumnNames = SetUtil.fromArray(
		new String[] {
			"uuid", "facultyRequestRotationsId", "groupId", "companyId",
			"createdBy", "createDate", "modifiedDate", "modifiedBy",
			"facultyRequestId", "trainingSiteId", "rotationId", "isActive"
		});

	@Override
	protected FinderCache getFinderCache() {
		return finderCache;
	}

	@Reference
	private PortalUUID _portalUUID;

}
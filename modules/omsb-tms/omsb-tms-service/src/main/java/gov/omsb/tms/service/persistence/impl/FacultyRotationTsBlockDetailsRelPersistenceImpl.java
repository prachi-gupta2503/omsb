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

import gov.omsb.tms.exception.NoSuchFacultyRotationTsBlockDetailsRelException;
import gov.omsb.tms.model.FacultyRotationTsBlockDetailsRel;
import gov.omsb.tms.model.FacultyRotationTsBlockDetailsRelTable;
import gov.omsb.tms.model.impl.FacultyRotationTsBlockDetailsRelImpl;
import gov.omsb.tms.model.impl.FacultyRotationTsBlockDetailsRelModelImpl;
import gov.omsb.tms.service.persistence.FacultyRotationTsBlockDetailsRelPersistence;
import gov.omsb.tms.service.persistence.FacultyRotationTsBlockDetailsRelUtil;
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
 * The persistence implementation for the faculty rotation ts block details rel service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = FacultyRotationTsBlockDetailsRelPersistence.class)
public class FacultyRotationTsBlockDetailsRelPersistenceImpl
	extends BasePersistenceImpl<FacultyRotationTsBlockDetailsRel>
	implements FacultyRotationTsBlockDetailsRelPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>FacultyRotationTsBlockDetailsRelUtil</code> to access the faculty rotation ts block details rel persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		FacultyRotationTsBlockDetailsRelImpl.class.getName();

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
	 * Returns all the faculty rotation ts block details rels where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching faculty rotation ts block details rels
	 */
	@Override
	public List<FacultyRotationTsBlockDetailsRel> findByUuid(String uuid) {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the faculty rotation ts block details rels where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FacultyRotationTsBlockDetailsRelModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of faculty rotation ts block details rels
	 * @param end the upper bound of the range of faculty rotation ts block details rels (not inclusive)
	 * @return the range of matching faculty rotation ts block details rels
	 */
	@Override
	public List<FacultyRotationTsBlockDetailsRel> findByUuid(
		String uuid, int start, int end) {

		return findByUuid(uuid, start, end, null);
	}

	/**
	 * Returns an ordered range of all the faculty rotation ts block details rels where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FacultyRotationTsBlockDetailsRelModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of faculty rotation ts block details rels
	 * @param end the upper bound of the range of faculty rotation ts block details rels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching faculty rotation ts block details rels
	 */
	@Override
	public List<FacultyRotationTsBlockDetailsRel> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<FacultyRotationTsBlockDetailsRel> orderByComparator) {

		return findByUuid(uuid, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the faculty rotation ts block details rels where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FacultyRotationTsBlockDetailsRelModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of faculty rotation ts block details rels
	 * @param end the upper bound of the range of faculty rotation ts block details rels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching faculty rotation ts block details rels
	 */
	@Override
	public List<FacultyRotationTsBlockDetailsRel> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<FacultyRotationTsBlockDetailsRel> orderByComparator,
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

		List<FacultyRotationTsBlockDetailsRel> list = null;

		if (useFinderCache) {
			list =
				(List<FacultyRotationTsBlockDetailsRel>)finderCache.getResult(
					finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (FacultyRotationTsBlockDetailsRel
						facultyRotationTsBlockDetailsRel : list) {

					if (!uuid.equals(
							facultyRotationTsBlockDetailsRel.getUuid())) {

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

			sb.append(_SQL_SELECT_FACULTYROTATIONTSBLOCKDETAILSREL_WHERE);

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
					FacultyRotationTsBlockDetailsRelModelImpl.ORDER_BY_JPQL);
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

				list = (List<FacultyRotationTsBlockDetailsRel>)QueryUtil.list(
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
	 * Returns the first faculty rotation ts block details rel in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching faculty rotation ts block details rel
	 * @throws NoSuchFacultyRotationTsBlockDetailsRelException if a matching faculty rotation ts block details rel could not be found
	 */
	@Override
	public FacultyRotationTsBlockDetailsRel findByUuid_First(
			String uuid,
			OrderByComparator<FacultyRotationTsBlockDetailsRel>
				orderByComparator)
		throws NoSuchFacultyRotationTsBlockDetailsRelException {

		FacultyRotationTsBlockDetailsRel facultyRotationTsBlockDetailsRel =
			fetchByUuid_First(uuid, orderByComparator);

		if (facultyRotationTsBlockDetailsRel != null) {
			return facultyRotationTsBlockDetailsRel;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchFacultyRotationTsBlockDetailsRelException(
			sb.toString());
	}

	/**
	 * Returns the first faculty rotation ts block details rel in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching faculty rotation ts block details rel, or <code>null</code> if a matching faculty rotation ts block details rel could not be found
	 */
	@Override
	public FacultyRotationTsBlockDetailsRel fetchByUuid_First(
		String uuid,
		OrderByComparator<FacultyRotationTsBlockDetailsRel> orderByComparator) {

		List<FacultyRotationTsBlockDetailsRel> list = findByUuid(
			uuid, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last faculty rotation ts block details rel in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching faculty rotation ts block details rel
	 * @throws NoSuchFacultyRotationTsBlockDetailsRelException if a matching faculty rotation ts block details rel could not be found
	 */
	@Override
	public FacultyRotationTsBlockDetailsRel findByUuid_Last(
			String uuid,
			OrderByComparator<FacultyRotationTsBlockDetailsRel>
				orderByComparator)
		throws NoSuchFacultyRotationTsBlockDetailsRelException {

		FacultyRotationTsBlockDetailsRel facultyRotationTsBlockDetailsRel =
			fetchByUuid_Last(uuid, orderByComparator);

		if (facultyRotationTsBlockDetailsRel != null) {
			return facultyRotationTsBlockDetailsRel;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchFacultyRotationTsBlockDetailsRelException(
			sb.toString());
	}

	/**
	 * Returns the last faculty rotation ts block details rel in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching faculty rotation ts block details rel, or <code>null</code> if a matching faculty rotation ts block details rel could not be found
	 */
	@Override
	public FacultyRotationTsBlockDetailsRel fetchByUuid_Last(
		String uuid,
		OrderByComparator<FacultyRotationTsBlockDetailsRel> orderByComparator) {

		int count = countByUuid(uuid);

		if (count == 0) {
			return null;
		}

		List<FacultyRotationTsBlockDetailsRel> list = findByUuid(
			uuid, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the faculty rotation ts block details rels before and after the current faculty rotation ts block details rel in the ordered set where uuid = &#63;.
	 *
	 * @param facultyRotationTsBlockDetailsRelId the primary key of the current faculty rotation ts block details rel
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next faculty rotation ts block details rel
	 * @throws NoSuchFacultyRotationTsBlockDetailsRelException if a faculty rotation ts block details rel with the primary key could not be found
	 */
	@Override
	public FacultyRotationTsBlockDetailsRel[] findByUuid_PrevAndNext(
			long facultyRotationTsBlockDetailsRelId, String uuid,
			OrderByComparator<FacultyRotationTsBlockDetailsRel>
				orderByComparator)
		throws NoSuchFacultyRotationTsBlockDetailsRelException {

		uuid = Objects.toString(uuid, "");

		FacultyRotationTsBlockDetailsRel facultyRotationTsBlockDetailsRel =
			findByPrimaryKey(facultyRotationTsBlockDetailsRelId);

		Session session = null;

		try {
			session = openSession();

			FacultyRotationTsBlockDetailsRel[] array =
				new FacultyRotationTsBlockDetailsRelImpl[3];

			array[0] = getByUuid_PrevAndNext(
				session, facultyRotationTsBlockDetailsRel, uuid,
				orderByComparator, true);

			array[1] = facultyRotationTsBlockDetailsRel;

			array[2] = getByUuid_PrevAndNext(
				session, facultyRotationTsBlockDetailsRel, uuid,
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

	protected FacultyRotationTsBlockDetailsRel getByUuid_PrevAndNext(
		Session session,
		FacultyRotationTsBlockDetailsRel facultyRotationTsBlockDetailsRel,
		String uuid,
		OrderByComparator<FacultyRotationTsBlockDetailsRel> orderByComparator,
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

		sb.append(_SQL_SELECT_FACULTYROTATIONTSBLOCKDETAILSREL_WHERE);

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
			sb.append(FacultyRotationTsBlockDetailsRelModelImpl.ORDER_BY_JPQL);
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
						facultyRotationTsBlockDetailsRel)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<FacultyRotationTsBlockDetailsRel> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the faculty rotation ts block details rels where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	@Override
	public void removeByUuid(String uuid) {
		for (FacultyRotationTsBlockDetailsRel facultyRotationTsBlockDetailsRel :
				findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(facultyRotationTsBlockDetailsRel);
		}
	}

	/**
	 * Returns the number of faculty rotation ts block details rels where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching faculty rotation ts block details rels
	 */
	@Override
	public int countByUuid(String uuid) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid;

		Object[] finderArgs = new Object[] {uuid};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_FACULTYROTATIONTSBLOCKDETAILSREL_WHERE);

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
		"facultyRotationTsBlockDetailsRel.uuid = ?";

	private static final String _FINDER_COLUMN_UUID_UUID_3 =
		"(facultyRotationTsBlockDetailsRel.uuid IS NULL OR facultyRotationTsBlockDetailsRel.uuid = '')";

	private FinderPath _finderPathFetchByUUID_G;
	private FinderPath _finderPathCountByUUID_G;

	/**
	 * Returns the faculty rotation ts block details rel where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchFacultyRotationTsBlockDetailsRelException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching faculty rotation ts block details rel
	 * @throws NoSuchFacultyRotationTsBlockDetailsRelException if a matching faculty rotation ts block details rel could not be found
	 */
	@Override
	public FacultyRotationTsBlockDetailsRel findByUUID_G(
			String uuid, long groupId)
		throws NoSuchFacultyRotationTsBlockDetailsRelException {

		FacultyRotationTsBlockDetailsRel facultyRotationTsBlockDetailsRel =
			fetchByUUID_G(uuid, groupId);

		if (facultyRotationTsBlockDetailsRel == null) {
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

			throw new NoSuchFacultyRotationTsBlockDetailsRelException(
				sb.toString());
		}

		return facultyRotationTsBlockDetailsRel;
	}

	/**
	 * Returns the faculty rotation ts block details rel where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching faculty rotation ts block details rel, or <code>null</code> if a matching faculty rotation ts block details rel could not be found
	 */
	@Override
	public FacultyRotationTsBlockDetailsRel fetchByUUID_G(
		String uuid, long groupId) {

		return fetchByUUID_G(uuid, groupId, true);
	}

	/**
	 * Returns the faculty rotation ts block details rel where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching faculty rotation ts block details rel, or <code>null</code> if a matching faculty rotation ts block details rel could not be found
	 */
	@Override
	public FacultyRotationTsBlockDetailsRel fetchByUUID_G(
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

		if (result instanceof FacultyRotationTsBlockDetailsRel) {
			FacultyRotationTsBlockDetailsRel facultyRotationTsBlockDetailsRel =
				(FacultyRotationTsBlockDetailsRel)result;

			if (!Objects.equals(
					uuid, facultyRotationTsBlockDetailsRel.getUuid()) ||
				(groupId != facultyRotationTsBlockDetailsRel.getGroupId())) {

				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_SQL_SELECT_FACULTYROTATIONTSBLOCKDETAILSREL_WHERE);

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

				List<FacultyRotationTsBlockDetailsRel> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchByUUID_G, finderArgs, list);
					}
				}
				else {
					FacultyRotationTsBlockDetailsRel
						facultyRotationTsBlockDetailsRel = list.get(0);

					result = facultyRotationTsBlockDetailsRel;

					cacheResult(facultyRotationTsBlockDetailsRel);
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
			return (FacultyRotationTsBlockDetailsRel)result;
		}
	}

	/**
	 * Removes the faculty rotation ts block details rel where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the faculty rotation ts block details rel that was removed
	 */
	@Override
	public FacultyRotationTsBlockDetailsRel removeByUUID_G(
			String uuid, long groupId)
		throws NoSuchFacultyRotationTsBlockDetailsRelException {

		FacultyRotationTsBlockDetailsRel facultyRotationTsBlockDetailsRel =
			findByUUID_G(uuid, groupId);

		return remove(facultyRotationTsBlockDetailsRel);
	}

	/**
	 * Returns the number of faculty rotation ts block details rels where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching faculty rotation ts block details rels
	 */
	@Override
	public int countByUUID_G(String uuid, long groupId) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUUID_G;

		Object[] finderArgs = new Object[] {uuid, groupId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_FACULTYROTATIONTSBLOCKDETAILSREL_WHERE);

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
		"facultyRotationTsBlockDetailsRel.uuid = ? AND ";

	private static final String _FINDER_COLUMN_UUID_G_UUID_3 =
		"(facultyRotationTsBlockDetailsRel.uuid IS NULL OR facultyRotationTsBlockDetailsRel.uuid = '') AND ";

	private static final String _FINDER_COLUMN_UUID_G_GROUPID_2 =
		"facultyRotationTsBlockDetailsRel.groupId = ?";

	private FinderPath _finderPathWithPaginationFindByUuid_C;
	private FinderPath _finderPathWithoutPaginationFindByUuid_C;
	private FinderPath _finderPathCountByUuid_C;

	/**
	 * Returns all the faculty rotation ts block details rels where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching faculty rotation ts block details rels
	 */
	@Override
	public List<FacultyRotationTsBlockDetailsRel> findByUuid_C(
		String uuid, long companyId) {

		return findByUuid_C(
			uuid, companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the faculty rotation ts block details rels where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FacultyRotationTsBlockDetailsRelModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of faculty rotation ts block details rels
	 * @param end the upper bound of the range of faculty rotation ts block details rels (not inclusive)
	 * @return the range of matching faculty rotation ts block details rels
	 */
	@Override
	public List<FacultyRotationTsBlockDetailsRel> findByUuid_C(
		String uuid, long companyId, int start, int end) {

		return findByUuid_C(uuid, companyId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the faculty rotation ts block details rels where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FacultyRotationTsBlockDetailsRelModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of faculty rotation ts block details rels
	 * @param end the upper bound of the range of faculty rotation ts block details rels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching faculty rotation ts block details rels
	 */
	@Override
	public List<FacultyRotationTsBlockDetailsRel> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<FacultyRotationTsBlockDetailsRel> orderByComparator) {

		return findByUuid_C(
			uuid, companyId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the faculty rotation ts block details rels where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FacultyRotationTsBlockDetailsRelModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of faculty rotation ts block details rels
	 * @param end the upper bound of the range of faculty rotation ts block details rels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching faculty rotation ts block details rels
	 */
	@Override
	public List<FacultyRotationTsBlockDetailsRel> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<FacultyRotationTsBlockDetailsRel> orderByComparator,
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

		List<FacultyRotationTsBlockDetailsRel> list = null;

		if (useFinderCache) {
			list =
				(List<FacultyRotationTsBlockDetailsRel>)finderCache.getResult(
					finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (FacultyRotationTsBlockDetailsRel
						facultyRotationTsBlockDetailsRel : list) {

					if (!uuid.equals(
							facultyRotationTsBlockDetailsRel.getUuid()) ||
						(companyId !=
							facultyRotationTsBlockDetailsRel.getCompanyId())) {

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

			sb.append(_SQL_SELECT_FACULTYROTATIONTSBLOCKDETAILSREL_WHERE);

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
					FacultyRotationTsBlockDetailsRelModelImpl.ORDER_BY_JPQL);
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

				list = (List<FacultyRotationTsBlockDetailsRel>)QueryUtil.list(
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
	 * Returns the first faculty rotation ts block details rel in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching faculty rotation ts block details rel
	 * @throws NoSuchFacultyRotationTsBlockDetailsRelException if a matching faculty rotation ts block details rel could not be found
	 */
	@Override
	public FacultyRotationTsBlockDetailsRel findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<FacultyRotationTsBlockDetailsRel>
				orderByComparator)
		throws NoSuchFacultyRotationTsBlockDetailsRelException {

		FacultyRotationTsBlockDetailsRel facultyRotationTsBlockDetailsRel =
			fetchByUuid_C_First(uuid, companyId, orderByComparator);

		if (facultyRotationTsBlockDetailsRel != null) {
			return facultyRotationTsBlockDetailsRel;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append(", companyId=");
		sb.append(companyId);

		sb.append("}");

		throw new NoSuchFacultyRotationTsBlockDetailsRelException(
			sb.toString());
	}

	/**
	 * Returns the first faculty rotation ts block details rel in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching faculty rotation ts block details rel, or <code>null</code> if a matching faculty rotation ts block details rel could not be found
	 */
	@Override
	public FacultyRotationTsBlockDetailsRel fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<FacultyRotationTsBlockDetailsRel> orderByComparator) {

		List<FacultyRotationTsBlockDetailsRel> list = findByUuid_C(
			uuid, companyId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last faculty rotation ts block details rel in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching faculty rotation ts block details rel
	 * @throws NoSuchFacultyRotationTsBlockDetailsRelException if a matching faculty rotation ts block details rel could not be found
	 */
	@Override
	public FacultyRotationTsBlockDetailsRel findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<FacultyRotationTsBlockDetailsRel>
				orderByComparator)
		throws NoSuchFacultyRotationTsBlockDetailsRelException {

		FacultyRotationTsBlockDetailsRel facultyRotationTsBlockDetailsRel =
			fetchByUuid_C_Last(uuid, companyId, orderByComparator);

		if (facultyRotationTsBlockDetailsRel != null) {
			return facultyRotationTsBlockDetailsRel;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append(", companyId=");
		sb.append(companyId);

		sb.append("}");

		throw new NoSuchFacultyRotationTsBlockDetailsRelException(
			sb.toString());
	}

	/**
	 * Returns the last faculty rotation ts block details rel in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching faculty rotation ts block details rel, or <code>null</code> if a matching faculty rotation ts block details rel could not be found
	 */
	@Override
	public FacultyRotationTsBlockDetailsRel fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<FacultyRotationTsBlockDetailsRel> orderByComparator) {

		int count = countByUuid_C(uuid, companyId);

		if (count == 0) {
			return null;
		}

		List<FacultyRotationTsBlockDetailsRel> list = findByUuid_C(
			uuid, companyId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the faculty rotation ts block details rels before and after the current faculty rotation ts block details rel in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param facultyRotationTsBlockDetailsRelId the primary key of the current faculty rotation ts block details rel
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next faculty rotation ts block details rel
	 * @throws NoSuchFacultyRotationTsBlockDetailsRelException if a faculty rotation ts block details rel with the primary key could not be found
	 */
	@Override
	public FacultyRotationTsBlockDetailsRel[] findByUuid_C_PrevAndNext(
			long facultyRotationTsBlockDetailsRelId, String uuid,
			long companyId,
			OrderByComparator<FacultyRotationTsBlockDetailsRel>
				orderByComparator)
		throws NoSuchFacultyRotationTsBlockDetailsRelException {

		uuid = Objects.toString(uuid, "");

		FacultyRotationTsBlockDetailsRel facultyRotationTsBlockDetailsRel =
			findByPrimaryKey(facultyRotationTsBlockDetailsRelId);

		Session session = null;

		try {
			session = openSession();

			FacultyRotationTsBlockDetailsRel[] array =
				new FacultyRotationTsBlockDetailsRelImpl[3];

			array[0] = getByUuid_C_PrevAndNext(
				session, facultyRotationTsBlockDetailsRel, uuid, companyId,
				orderByComparator, true);

			array[1] = facultyRotationTsBlockDetailsRel;

			array[2] = getByUuid_C_PrevAndNext(
				session, facultyRotationTsBlockDetailsRel, uuid, companyId,
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

	protected FacultyRotationTsBlockDetailsRel getByUuid_C_PrevAndNext(
		Session session,
		FacultyRotationTsBlockDetailsRel facultyRotationTsBlockDetailsRel,
		String uuid, long companyId,
		OrderByComparator<FacultyRotationTsBlockDetailsRel> orderByComparator,
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

		sb.append(_SQL_SELECT_FACULTYROTATIONTSBLOCKDETAILSREL_WHERE);

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
			sb.append(FacultyRotationTsBlockDetailsRelModelImpl.ORDER_BY_JPQL);
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
						facultyRotationTsBlockDetailsRel)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<FacultyRotationTsBlockDetailsRel> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the faculty rotation ts block details rels where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	@Override
	public void removeByUuid_C(String uuid, long companyId) {
		for (FacultyRotationTsBlockDetailsRel facultyRotationTsBlockDetailsRel :
				findByUuid_C(
					uuid, companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(facultyRotationTsBlockDetailsRel);
		}
	}

	/**
	 * Returns the number of faculty rotation ts block details rels where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching faculty rotation ts block details rels
	 */
	@Override
	public int countByUuid_C(String uuid, long companyId) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid_C;

		Object[] finderArgs = new Object[] {uuid, companyId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_FACULTYROTATIONTSBLOCKDETAILSREL_WHERE);

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
		"facultyRotationTsBlockDetailsRel.uuid = ? AND ";

	private static final String _FINDER_COLUMN_UUID_C_UUID_3 =
		"(facultyRotationTsBlockDetailsRel.uuid IS NULL OR facultyRotationTsBlockDetailsRel.uuid = '') AND ";

	private static final String _FINDER_COLUMN_UUID_C_COMPANYID_2 =
		"facultyRotationTsBlockDetailsRel.companyId = ?";

	private FinderPath _finderPathWithPaginationFindByFacultyId;
	private FinderPath _finderPathWithoutPaginationFindByFacultyId;
	private FinderPath _finderPathCountByFacultyId;

	/**
	 * Returns all the faculty rotation ts block details rels where facultyId = &#63;.
	 *
	 * @param facultyId the faculty ID
	 * @return the matching faculty rotation ts block details rels
	 */
	@Override
	public List<FacultyRotationTsBlockDetailsRel> findByFacultyId(
		long facultyId) {

		return findByFacultyId(
			facultyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the faculty rotation ts block details rels where facultyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FacultyRotationTsBlockDetailsRelModelImpl</code>.
	 * </p>
	 *
	 * @param facultyId the faculty ID
	 * @param start the lower bound of the range of faculty rotation ts block details rels
	 * @param end the upper bound of the range of faculty rotation ts block details rels (not inclusive)
	 * @return the range of matching faculty rotation ts block details rels
	 */
	@Override
	public List<FacultyRotationTsBlockDetailsRel> findByFacultyId(
		long facultyId, int start, int end) {

		return findByFacultyId(facultyId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the faculty rotation ts block details rels where facultyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FacultyRotationTsBlockDetailsRelModelImpl</code>.
	 * </p>
	 *
	 * @param facultyId the faculty ID
	 * @param start the lower bound of the range of faculty rotation ts block details rels
	 * @param end the upper bound of the range of faculty rotation ts block details rels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching faculty rotation ts block details rels
	 */
	@Override
	public List<FacultyRotationTsBlockDetailsRel> findByFacultyId(
		long facultyId, int start, int end,
		OrderByComparator<FacultyRotationTsBlockDetailsRel> orderByComparator) {

		return findByFacultyId(facultyId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the faculty rotation ts block details rels where facultyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FacultyRotationTsBlockDetailsRelModelImpl</code>.
	 * </p>
	 *
	 * @param facultyId the faculty ID
	 * @param start the lower bound of the range of faculty rotation ts block details rels
	 * @param end the upper bound of the range of faculty rotation ts block details rels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching faculty rotation ts block details rels
	 */
	@Override
	public List<FacultyRotationTsBlockDetailsRel> findByFacultyId(
		long facultyId, int start, int end,
		OrderByComparator<FacultyRotationTsBlockDetailsRel> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByFacultyId;
				finderArgs = new Object[] {facultyId};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByFacultyId;
			finderArgs = new Object[] {
				facultyId, start, end, orderByComparator
			};
		}

		List<FacultyRotationTsBlockDetailsRel> list = null;

		if (useFinderCache) {
			list =
				(List<FacultyRotationTsBlockDetailsRel>)finderCache.getResult(
					finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (FacultyRotationTsBlockDetailsRel
						facultyRotationTsBlockDetailsRel : list) {

					if (facultyId !=
							facultyRotationTsBlockDetailsRel.getFacultyId()) {

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

			sb.append(_SQL_SELECT_FACULTYROTATIONTSBLOCKDETAILSREL_WHERE);

			sb.append(_FINDER_COLUMN_FACULTYID_FACULTYID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(
					FacultyRotationTsBlockDetailsRelModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(facultyId);

				list = (List<FacultyRotationTsBlockDetailsRel>)QueryUtil.list(
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
	 * Returns the first faculty rotation ts block details rel in the ordered set where facultyId = &#63;.
	 *
	 * @param facultyId the faculty ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching faculty rotation ts block details rel
	 * @throws NoSuchFacultyRotationTsBlockDetailsRelException if a matching faculty rotation ts block details rel could not be found
	 */
	@Override
	public FacultyRotationTsBlockDetailsRel findByFacultyId_First(
			long facultyId,
			OrderByComparator<FacultyRotationTsBlockDetailsRel>
				orderByComparator)
		throws NoSuchFacultyRotationTsBlockDetailsRelException {

		FacultyRotationTsBlockDetailsRel facultyRotationTsBlockDetailsRel =
			fetchByFacultyId_First(facultyId, orderByComparator);

		if (facultyRotationTsBlockDetailsRel != null) {
			return facultyRotationTsBlockDetailsRel;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("facultyId=");
		sb.append(facultyId);

		sb.append("}");

		throw new NoSuchFacultyRotationTsBlockDetailsRelException(
			sb.toString());
	}

	/**
	 * Returns the first faculty rotation ts block details rel in the ordered set where facultyId = &#63;.
	 *
	 * @param facultyId the faculty ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching faculty rotation ts block details rel, or <code>null</code> if a matching faculty rotation ts block details rel could not be found
	 */
	@Override
	public FacultyRotationTsBlockDetailsRel fetchByFacultyId_First(
		long facultyId,
		OrderByComparator<FacultyRotationTsBlockDetailsRel> orderByComparator) {

		List<FacultyRotationTsBlockDetailsRel> list = findByFacultyId(
			facultyId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last faculty rotation ts block details rel in the ordered set where facultyId = &#63;.
	 *
	 * @param facultyId the faculty ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching faculty rotation ts block details rel
	 * @throws NoSuchFacultyRotationTsBlockDetailsRelException if a matching faculty rotation ts block details rel could not be found
	 */
	@Override
	public FacultyRotationTsBlockDetailsRel findByFacultyId_Last(
			long facultyId,
			OrderByComparator<FacultyRotationTsBlockDetailsRel>
				orderByComparator)
		throws NoSuchFacultyRotationTsBlockDetailsRelException {

		FacultyRotationTsBlockDetailsRel facultyRotationTsBlockDetailsRel =
			fetchByFacultyId_Last(facultyId, orderByComparator);

		if (facultyRotationTsBlockDetailsRel != null) {
			return facultyRotationTsBlockDetailsRel;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("facultyId=");
		sb.append(facultyId);

		sb.append("}");

		throw new NoSuchFacultyRotationTsBlockDetailsRelException(
			sb.toString());
	}

	/**
	 * Returns the last faculty rotation ts block details rel in the ordered set where facultyId = &#63;.
	 *
	 * @param facultyId the faculty ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching faculty rotation ts block details rel, or <code>null</code> if a matching faculty rotation ts block details rel could not be found
	 */
	@Override
	public FacultyRotationTsBlockDetailsRel fetchByFacultyId_Last(
		long facultyId,
		OrderByComparator<FacultyRotationTsBlockDetailsRel> orderByComparator) {

		int count = countByFacultyId(facultyId);

		if (count == 0) {
			return null;
		}

		List<FacultyRotationTsBlockDetailsRel> list = findByFacultyId(
			facultyId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the faculty rotation ts block details rels before and after the current faculty rotation ts block details rel in the ordered set where facultyId = &#63;.
	 *
	 * @param facultyRotationTsBlockDetailsRelId the primary key of the current faculty rotation ts block details rel
	 * @param facultyId the faculty ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next faculty rotation ts block details rel
	 * @throws NoSuchFacultyRotationTsBlockDetailsRelException if a faculty rotation ts block details rel with the primary key could not be found
	 */
	@Override
	public FacultyRotationTsBlockDetailsRel[] findByFacultyId_PrevAndNext(
			long facultyRotationTsBlockDetailsRelId, long facultyId,
			OrderByComparator<FacultyRotationTsBlockDetailsRel>
				orderByComparator)
		throws NoSuchFacultyRotationTsBlockDetailsRelException {

		FacultyRotationTsBlockDetailsRel facultyRotationTsBlockDetailsRel =
			findByPrimaryKey(facultyRotationTsBlockDetailsRelId);

		Session session = null;

		try {
			session = openSession();

			FacultyRotationTsBlockDetailsRel[] array =
				new FacultyRotationTsBlockDetailsRelImpl[3];

			array[0] = getByFacultyId_PrevAndNext(
				session, facultyRotationTsBlockDetailsRel, facultyId,
				orderByComparator, true);

			array[1] = facultyRotationTsBlockDetailsRel;

			array[2] = getByFacultyId_PrevAndNext(
				session, facultyRotationTsBlockDetailsRel, facultyId,
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

	protected FacultyRotationTsBlockDetailsRel getByFacultyId_PrevAndNext(
		Session session,
		FacultyRotationTsBlockDetailsRel facultyRotationTsBlockDetailsRel,
		long facultyId,
		OrderByComparator<FacultyRotationTsBlockDetailsRel> orderByComparator,
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

		sb.append(_SQL_SELECT_FACULTYROTATIONTSBLOCKDETAILSREL_WHERE);

		sb.append(_FINDER_COLUMN_FACULTYID_FACULTYID_2);

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
			sb.append(FacultyRotationTsBlockDetailsRelModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(facultyId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						facultyRotationTsBlockDetailsRel)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<FacultyRotationTsBlockDetailsRel> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the faculty rotation ts block details rels where facultyId = &#63; from the database.
	 *
	 * @param facultyId the faculty ID
	 */
	@Override
	public void removeByFacultyId(long facultyId) {
		for (FacultyRotationTsBlockDetailsRel facultyRotationTsBlockDetailsRel :
				findByFacultyId(
					facultyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(facultyRotationTsBlockDetailsRel);
		}
	}

	/**
	 * Returns the number of faculty rotation ts block details rels where facultyId = &#63;.
	 *
	 * @param facultyId the faculty ID
	 * @return the number of matching faculty rotation ts block details rels
	 */
	@Override
	public int countByFacultyId(long facultyId) {
		FinderPath finderPath = _finderPathCountByFacultyId;

		Object[] finderArgs = new Object[] {facultyId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_FACULTYROTATIONTSBLOCKDETAILSREL_WHERE);

			sb.append(_FINDER_COLUMN_FACULTYID_FACULTYID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(facultyId);

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

	private static final String _FINDER_COLUMN_FACULTYID_FACULTYID_2 =
		"facultyRotationTsBlockDetailsRel.facultyId = ?";

	private FinderPath
		_finderPathWithPaginationFindByProgDurationRotationTsRelId;
	private FinderPath
		_finderPathWithoutPaginationFindByProgDurationRotationTsRelId;
	private FinderPath _finderPathCountByProgDurationRotationTsRelId;

	/**
	 * Returns all the faculty rotation ts block details rels where progDurationRotationTsRelId = &#63;.
	 *
	 * @param progDurationRotationTsRelId the prog duration rotation ts rel ID
	 * @return the matching faculty rotation ts block details rels
	 */
	@Override
	public List<FacultyRotationTsBlockDetailsRel>
		findByProgDurationRotationTsRelId(long progDurationRotationTsRelId) {

		return findByProgDurationRotationTsRelId(
			progDurationRotationTsRelId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
	}

	/**
	 * Returns a range of all the faculty rotation ts block details rels where progDurationRotationTsRelId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FacultyRotationTsBlockDetailsRelModelImpl</code>.
	 * </p>
	 *
	 * @param progDurationRotationTsRelId the prog duration rotation ts rel ID
	 * @param start the lower bound of the range of faculty rotation ts block details rels
	 * @param end the upper bound of the range of faculty rotation ts block details rels (not inclusive)
	 * @return the range of matching faculty rotation ts block details rels
	 */
	@Override
	public List<FacultyRotationTsBlockDetailsRel>
		findByProgDurationRotationTsRelId(
			long progDurationRotationTsRelId, int start, int end) {

		return findByProgDurationRotationTsRelId(
			progDurationRotationTsRelId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the faculty rotation ts block details rels where progDurationRotationTsRelId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FacultyRotationTsBlockDetailsRelModelImpl</code>.
	 * </p>
	 *
	 * @param progDurationRotationTsRelId the prog duration rotation ts rel ID
	 * @param start the lower bound of the range of faculty rotation ts block details rels
	 * @param end the upper bound of the range of faculty rotation ts block details rels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching faculty rotation ts block details rels
	 */
	@Override
	public List<FacultyRotationTsBlockDetailsRel>
		findByProgDurationRotationTsRelId(
			long progDurationRotationTsRelId, int start, int end,
			OrderByComparator<FacultyRotationTsBlockDetailsRel>
				orderByComparator) {

		return findByProgDurationRotationTsRelId(
			progDurationRotationTsRelId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the faculty rotation ts block details rels where progDurationRotationTsRelId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FacultyRotationTsBlockDetailsRelModelImpl</code>.
	 * </p>
	 *
	 * @param progDurationRotationTsRelId the prog duration rotation ts rel ID
	 * @param start the lower bound of the range of faculty rotation ts block details rels
	 * @param end the upper bound of the range of faculty rotation ts block details rels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching faculty rotation ts block details rels
	 */
	@Override
	public List<FacultyRotationTsBlockDetailsRel>
		findByProgDurationRotationTsRelId(
			long progDurationRotationTsRelId, int start, int end,
			OrderByComparator<FacultyRotationTsBlockDetailsRel>
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

		List<FacultyRotationTsBlockDetailsRel> list = null;

		if (useFinderCache) {
			list =
				(List<FacultyRotationTsBlockDetailsRel>)finderCache.getResult(
					finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (FacultyRotationTsBlockDetailsRel
						facultyRotationTsBlockDetailsRel : list) {

					if (progDurationRotationTsRelId !=
							facultyRotationTsBlockDetailsRel.
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

			sb.append(_SQL_SELECT_FACULTYROTATIONTSBLOCKDETAILSREL_WHERE);

			sb.append(
				_FINDER_COLUMN_PROGDURATIONROTATIONTSRELID_PROGDURATIONROTATIONTSRELID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(
					FacultyRotationTsBlockDetailsRelModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(progDurationRotationTsRelId);

				list = (List<FacultyRotationTsBlockDetailsRel>)QueryUtil.list(
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
	 * Returns the first faculty rotation ts block details rel in the ordered set where progDurationRotationTsRelId = &#63;.
	 *
	 * @param progDurationRotationTsRelId the prog duration rotation ts rel ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching faculty rotation ts block details rel
	 * @throws NoSuchFacultyRotationTsBlockDetailsRelException if a matching faculty rotation ts block details rel could not be found
	 */
	@Override
	public FacultyRotationTsBlockDetailsRel
			findByProgDurationRotationTsRelId_First(
				long progDurationRotationTsRelId,
				OrderByComparator<FacultyRotationTsBlockDetailsRel>
					orderByComparator)
		throws NoSuchFacultyRotationTsBlockDetailsRelException {

		FacultyRotationTsBlockDetailsRel facultyRotationTsBlockDetailsRel =
			fetchByProgDurationRotationTsRelId_First(
				progDurationRotationTsRelId, orderByComparator);

		if (facultyRotationTsBlockDetailsRel != null) {
			return facultyRotationTsBlockDetailsRel;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("progDurationRotationTsRelId=");
		sb.append(progDurationRotationTsRelId);

		sb.append("}");

		throw new NoSuchFacultyRotationTsBlockDetailsRelException(
			sb.toString());
	}

	/**
	 * Returns the first faculty rotation ts block details rel in the ordered set where progDurationRotationTsRelId = &#63;.
	 *
	 * @param progDurationRotationTsRelId the prog duration rotation ts rel ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching faculty rotation ts block details rel, or <code>null</code> if a matching faculty rotation ts block details rel could not be found
	 */
	@Override
	public FacultyRotationTsBlockDetailsRel
		fetchByProgDurationRotationTsRelId_First(
			long progDurationRotationTsRelId,
			OrderByComparator<FacultyRotationTsBlockDetailsRel>
				orderByComparator) {

		List<FacultyRotationTsBlockDetailsRel> list =
			findByProgDurationRotationTsRelId(
				progDurationRotationTsRelId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last faculty rotation ts block details rel in the ordered set where progDurationRotationTsRelId = &#63;.
	 *
	 * @param progDurationRotationTsRelId the prog duration rotation ts rel ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching faculty rotation ts block details rel
	 * @throws NoSuchFacultyRotationTsBlockDetailsRelException if a matching faculty rotation ts block details rel could not be found
	 */
	@Override
	public FacultyRotationTsBlockDetailsRel
			findByProgDurationRotationTsRelId_Last(
				long progDurationRotationTsRelId,
				OrderByComparator<FacultyRotationTsBlockDetailsRel>
					orderByComparator)
		throws NoSuchFacultyRotationTsBlockDetailsRelException {

		FacultyRotationTsBlockDetailsRel facultyRotationTsBlockDetailsRel =
			fetchByProgDurationRotationTsRelId_Last(
				progDurationRotationTsRelId, orderByComparator);

		if (facultyRotationTsBlockDetailsRel != null) {
			return facultyRotationTsBlockDetailsRel;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("progDurationRotationTsRelId=");
		sb.append(progDurationRotationTsRelId);

		sb.append("}");

		throw new NoSuchFacultyRotationTsBlockDetailsRelException(
			sb.toString());
	}

	/**
	 * Returns the last faculty rotation ts block details rel in the ordered set where progDurationRotationTsRelId = &#63;.
	 *
	 * @param progDurationRotationTsRelId the prog duration rotation ts rel ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching faculty rotation ts block details rel, or <code>null</code> if a matching faculty rotation ts block details rel could not be found
	 */
	@Override
	public FacultyRotationTsBlockDetailsRel
		fetchByProgDurationRotationTsRelId_Last(
			long progDurationRotationTsRelId,
			OrderByComparator<FacultyRotationTsBlockDetailsRel>
				orderByComparator) {

		int count = countByProgDurationRotationTsRelId(
			progDurationRotationTsRelId);

		if (count == 0) {
			return null;
		}

		List<FacultyRotationTsBlockDetailsRel> list =
			findByProgDurationRotationTsRelId(
				progDurationRotationTsRelId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the faculty rotation ts block details rels before and after the current faculty rotation ts block details rel in the ordered set where progDurationRotationTsRelId = &#63;.
	 *
	 * @param facultyRotationTsBlockDetailsRelId the primary key of the current faculty rotation ts block details rel
	 * @param progDurationRotationTsRelId the prog duration rotation ts rel ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next faculty rotation ts block details rel
	 * @throws NoSuchFacultyRotationTsBlockDetailsRelException if a faculty rotation ts block details rel with the primary key could not be found
	 */
	@Override
	public FacultyRotationTsBlockDetailsRel[]
			findByProgDurationRotationTsRelId_PrevAndNext(
				long facultyRotationTsBlockDetailsRelId,
				long progDurationRotationTsRelId,
				OrderByComparator<FacultyRotationTsBlockDetailsRel>
					orderByComparator)
		throws NoSuchFacultyRotationTsBlockDetailsRelException {

		FacultyRotationTsBlockDetailsRel facultyRotationTsBlockDetailsRel =
			findByPrimaryKey(facultyRotationTsBlockDetailsRelId);

		Session session = null;

		try {
			session = openSession();

			FacultyRotationTsBlockDetailsRel[] array =
				new FacultyRotationTsBlockDetailsRelImpl[3];

			array[0] = getByProgDurationRotationTsRelId_PrevAndNext(
				session, facultyRotationTsBlockDetailsRel,
				progDurationRotationTsRelId, orderByComparator, true);

			array[1] = facultyRotationTsBlockDetailsRel;

			array[2] = getByProgDurationRotationTsRelId_PrevAndNext(
				session, facultyRotationTsBlockDetailsRel,
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

	protected FacultyRotationTsBlockDetailsRel
		getByProgDurationRotationTsRelId_PrevAndNext(
			Session session,
			FacultyRotationTsBlockDetailsRel facultyRotationTsBlockDetailsRel,
			long progDurationRotationTsRelId,
			OrderByComparator<FacultyRotationTsBlockDetailsRel>
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

		sb.append(_SQL_SELECT_FACULTYROTATIONTSBLOCKDETAILSREL_WHERE);

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
			sb.append(FacultyRotationTsBlockDetailsRelModelImpl.ORDER_BY_JPQL);
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
						facultyRotationTsBlockDetailsRel)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<FacultyRotationTsBlockDetailsRel> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the faculty rotation ts block details rels where progDurationRotationTsRelId = &#63; from the database.
	 *
	 * @param progDurationRotationTsRelId the prog duration rotation ts rel ID
	 */
	@Override
	public void removeByProgDurationRotationTsRelId(
		long progDurationRotationTsRelId) {

		for (FacultyRotationTsBlockDetailsRel facultyRotationTsBlockDetailsRel :
				findByProgDurationRotationTsRelId(
					progDurationRotationTsRelId, QueryUtil.ALL_POS,
					QueryUtil.ALL_POS, null)) {

			remove(facultyRotationTsBlockDetailsRel);
		}
	}

	/**
	 * Returns the number of faculty rotation ts block details rels where progDurationRotationTsRelId = &#63;.
	 *
	 * @param progDurationRotationTsRelId the prog duration rotation ts rel ID
	 * @return the number of matching faculty rotation ts block details rels
	 */
	@Override
	public int countByProgDurationRotationTsRelId(
		long progDurationRotationTsRelId) {

		FinderPath finderPath = _finderPathCountByProgDurationRotationTsRelId;

		Object[] finderArgs = new Object[] {progDurationRotationTsRelId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_FACULTYROTATIONTSBLOCKDETAILSREL_WHERE);

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
			"facultyRotationTsBlockDetailsRel.progDurationRotationTsRelId = ?";

	private FinderPath _finderPathWithPaginationFindByFacultyIdAndStatus;
	private FinderPath _finderPathWithoutPaginationFindByFacultyIdAndStatus;
	private FinderPath _finderPathCountByFacultyIdAndStatus;

	/**
	 * Returns all the faculty rotation ts block details rels where facultyId = &#63; and status = &#63;.
	 *
	 * @param facultyId the faculty ID
	 * @param status the status
	 * @return the matching faculty rotation ts block details rels
	 */
	@Override
	public List<FacultyRotationTsBlockDetailsRel> findByFacultyIdAndStatus(
		long facultyId, String status) {

		return findByFacultyIdAndStatus(
			facultyId, status, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the faculty rotation ts block details rels where facultyId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FacultyRotationTsBlockDetailsRelModelImpl</code>.
	 * </p>
	 *
	 * @param facultyId the faculty ID
	 * @param status the status
	 * @param start the lower bound of the range of faculty rotation ts block details rels
	 * @param end the upper bound of the range of faculty rotation ts block details rels (not inclusive)
	 * @return the range of matching faculty rotation ts block details rels
	 */
	@Override
	public List<FacultyRotationTsBlockDetailsRel> findByFacultyIdAndStatus(
		long facultyId, String status, int start, int end) {

		return findByFacultyIdAndStatus(facultyId, status, start, end, null);
	}

	/**
	 * Returns an ordered range of all the faculty rotation ts block details rels where facultyId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FacultyRotationTsBlockDetailsRelModelImpl</code>.
	 * </p>
	 *
	 * @param facultyId the faculty ID
	 * @param status the status
	 * @param start the lower bound of the range of faculty rotation ts block details rels
	 * @param end the upper bound of the range of faculty rotation ts block details rels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching faculty rotation ts block details rels
	 */
	@Override
	public List<FacultyRotationTsBlockDetailsRel> findByFacultyIdAndStatus(
		long facultyId, String status, int start, int end,
		OrderByComparator<FacultyRotationTsBlockDetailsRel> orderByComparator) {

		return findByFacultyIdAndStatus(
			facultyId, status, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the faculty rotation ts block details rels where facultyId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FacultyRotationTsBlockDetailsRelModelImpl</code>.
	 * </p>
	 *
	 * @param facultyId the faculty ID
	 * @param status the status
	 * @param start the lower bound of the range of faculty rotation ts block details rels
	 * @param end the upper bound of the range of faculty rotation ts block details rels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching faculty rotation ts block details rels
	 */
	@Override
	public List<FacultyRotationTsBlockDetailsRel> findByFacultyIdAndStatus(
		long facultyId, String status, int start, int end,
		OrderByComparator<FacultyRotationTsBlockDetailsRel> orderByComparator,
		boolean useFinderCache) {

		status = Objects.toString(status, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath =
					_finderPathWithoutPaginationFindByFacultyIdAndStatus;
				finderArgs = new Object[] {facultyId, status};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByFacultyIdAndStatus;
			finderArgs = new Object[] {
				facultyId, status, start, end, orderByComparator
			};
		}

		List<FacultyRotationTsBlockDetailsRel> list = null;

		if (useFinderCache) {
			list =
				(List<FacultyRotationTsBlockDetailsRel>)finderCache.getResult(
					finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (FacultyRotationTsBlockDetailsRel
						facultyRotationTsBlockDetailsRel : list) {

					if ((facultyId !=
							facultyRotationTsBlockDetailsRel.getFacultyId()) ||
						!status.equals(
							facultyRotationTsBlockDetailsRel.getStatus())) {

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

			sb.append(_SQL_SELECT_FACULTYROTATIONTSBLOCKDETAILSREL_WHERE);

			sb.append(_FINDER_COLUMN_FACULTYIDANDSTATUS_FACULTYID_2);

			boolean bindStatus = false;

			if (status.isEmpty()) {
				sb.append(_FINDER_COLUMN_FACULTYIDANDSTATUS_STATUS_3);
			}
			else {
				bindStatus = true;

				sb.append(_FINDER_COLUMN_FACULTYIDANDSTATUS_STATUS_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(
					FacultyRotationTsBlockDetailsRelModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(facultyId);

				if (bindStatus) {
					queryPos.add(status);
				}

				list = (List<FacultyRotationTsBlockDetailsRel>)QueryUtil.list(
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
	 * Returns the first faculty rotation ts block details rel in the ordered set where facultyId = &#63; and status = &#63;.
	 *
	 * @param facultyId the faculty ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching faculty rotation ts block details rel
	 * @throws NoSuchFacultyRotationTsBlockDetailsRelException if a matching faculty rotation ts block details rel could not be found
	 */
	@Override
	public FacultyRotationTsBlockDetailsRel findByFacultyIdAndStatus_First(
			long facultyId, String status,
			OrderByComparator<FacultyRotationTsBlockDetailsRel>
				orderByComparator)
		throws NoSuchFacultyRotationTsBlockDetailsRelException {

		FacultyRotationTsBlockDetailsRel facultyRotationTsBlockDetailsRel =
			fetchByFacultyIdAndStatus_First(
				facultyId, status, orderByComparator);

		if (facultyRotationTsBlockDetailsRel != null) {
			return facultyRotationTsBlockDetailsRel;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("facultyId=");
		sb.append(facultyId);

		sb.append(", status=");
		sb.append(status);

		sb.append("}");

		throw new NoSuchFacultyRotationTsBlockDetailsRelException(
			sb.toString());
	}

	/**
	 * Returns the first faculty rotation ts block details rel in the ordered set where facultyId = &#63; and status = &#63;.
	 *
	 * @param facultyId the faculty ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching faculty rotation ts block details rel, or <code>null</code> if a matching faculty rotation ts block details rel could not be found
	 */
	@Override
	public FacultyRotationTsBlockDetailsRel fetchByFacultyIdAndStatus_First(
		long facultyId, String status,
		OrderByComparator<FacultyRotationTsBlockDetailsRel> orderByComparator) {

		List<FacultyRotationTsBlockDetailsRel> list = findByFacultyIdAndStatus(
			facultyId, status, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last faculty rotation ts block details rel in the ordered set where facultyId = &#63; and status = &#63;.
	 *
	 * @param facultyId the faculty ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching faculty rotation ts block details rel
	 * @throws NoSuchFacultyRotationTsBlockDetailsRelException if a matching faculty rotation ts block details rel could not be found
	 */
	@Override
	public FacultyRotationTsBlockDetailsRel findByFacultyIdAndStatus_Last(
			long facultyId, String status,
			OrderByComparator<FacultyRotationTsBlockDetailsRel>
				orderByComparator)
		throws NoSuchFacultyRotationTsBlockDetailsRelException {

		FacultyRotationTsBlockDetailsRel facultyRotationTsBlockDetailsRel =
			fetchByFacultyIdAndStatus_Last(
				facultyId, status, orderByComparator);

		if (facultyRotationTsBlockDetailsRel != null) {
			return facultyRotationTsBlockDetailsRel;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("facultyId=");
		sb.append(facultyId);

		sb.append(", status=");
		sb.append(status);

		sb.append("}");

		throw new NoSuchFacultyRotationTsBlockDetailsRelException(
			sb.toString());
	}

	/**
	 * Returns the last faculty rotation ts block details rel in the ordered set where facultyId = &#63; and status = &#63;.
	 *
	 * @param facultyId the faculty ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching faculty rotation ts block details rel, or <code>null</code> if a matching faculty rotation ts block details rel could not be found
	 */
	@Override
	public FacultyRotationTsBlockDetailsRel fetchByFacultyIdAndStatus_Last(
		long facultyId, String status,
		OrderByComparator<FacultyRotationTsBlockDetailsRel> orderByComparator) {

		int count = countByFacultyIdAndStatus(facultyId, status);

		if (count == 0) {
			return null;
		}

		List<FacultyRotationTsBlockDetailsRel> list = findByFacultyIdAndStatus(
			facultyId, status, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the faculty rotation ts block details rels before and after the current faculty rotation ts block details rel in the ordered set where facultyId = &#63; and status = &#63;.
	 *
	 * @param facultyRotationTsBlockDetailsRelId the primary key of the current faculty rotation ts block details rel
	 * @param facultyId the faculty ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next faculty rotation ts block details rel
	 * @throws NoSuchFacultyRotationTsBlockDetailsRelException if a faculty rotation ts block details rel with the primary key could not be found
	 */
	@Override
	public FacultyRotationTsBlockDetailsRel[]
			findByFacultyIdAndStatus_PrevAndNext(
				long facultyRotationTsBlockDetailsRelId, long facultyId,
				String status,
				OrderByComparator<FacultyRotationTsBlockDetailsRel>
					orderByComparator)
		throws NoSuchFacultyRotationTsBlockDetailsRelException {

		status = Objects.toString(status, "");

		FacultyRotationTsBlockDetailsRel facultyRotationTsBlockDetailsRel =
			findByPrimaryKey(facultyRotationTsBlockDetailsRelId);

		Session session = null;

		try {
			session = openSession();

			FacultyRotationTsBlockDetailsRel[] array =
				new FacultyRotationTsBlockDetailsRelImpl[3];

			array[0] = getByFacultyIdAndStatus_PrevAndNext(
				session, facultyRotationTsBlockDetailsRel, facultyId, status,
				orderByComparator, true);

			array[1] = facultyRotationTsBlockDetailsRel;

			array[2] = getByFacultyIdAndStatus_PrevAndNext(
				session, facultyRotationTsBlockDetailsRel, facultyId, status,
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

	protected FacultyRotationTsBlockDetailsRel
		getByFacultyIdAndStatus_PrevAndNext(
			Session session,
			FacultyRotationTsBlockDetailsRel facultyRotationTsBlockDetailsRel,
			long facultyId, String status,
			OrderByComparator<FacultyRotationTsBlockDetailsRel>
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

		sb.append(_SQL_SELECT_FACULTYROTATIONTSBLOCKDETAILSREL_WHERE);

		sb.append(_FINDER_COLUMN_FACULTYIDANDSTATUS_FACULTYID_2);

		boolean bindStatus = false;

		if (status.isEmpty()) {
			sb.append(_FINDER_COLUMN_FACULTYIDANDSTATUS_STATUS_3);
		}
		else {
			bindStatus = true;

			sb.append(_FINDER_COLUMN_FACULTYIDANDSTATUS_STATUS_2);
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
			sb.append(FacultyRotationTsBlockDetailsRelModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(facultyId);

		if (bindStatus) {
			queryPos.add(status);
		}

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						facultyRotationTsBlockDetailsRel)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<FacultyRotationTsBlockDetailsRel> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the faculty rotation ts block details rels where facultyId = &#63; and status = &#63; from the database.
	 *
	 * @param facultyId the faculty ID
	 * @param status the status
	 */
	@Override
	public void removeByFacultyIdAndStatus(long facultyId, String status) {
		for (FacultyRotationTsBlockDetailsRel facultyRotationTsBlockDetailsRel :
				findByFacultyIdAndStatus(
					facultyId, status, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(facultyRotationTsBlockDetailsRel);
		}
	}

	/**
	 * Returns the number of faculty rotation ts block details rels where facultyId = &#63; and status = &#63;.
	 *
	 * @param facultyId the faculty ID
	 * @param status the status
	 * @return the number of matching faculty rotation ts block details rels
	 */
	@Override
	public int countByFacultyIdAndStatus(long facultyId, String status) {
		status = Objects.toString(status, "");

		FinderPath finderPath = _finderPathCountByFacultyIdAndStatus;

		Object[] finderArgs = new Object[] {facultyId, status};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_FACULTYROTATIONTSBLOCKDETAILSREL_WHERE);

			sb.append(_FINDER_COLUMN_FACULTYIDANDSTATUS_FACULTYID_2);

			boolean bindStatus = false;

			if (status.isEmpty()) {
				sb.append(_FINDER_COLUMN_FACULTYIDANDSTATUS_STATUS_3);
			}
			else {
				bindStatus = true;

				sb.append(_FINDER_COLUMN_FACULTYIDANDSTATUS_STATUS_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(facultyId);

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

	private static final String _FINDER_COLUMN_FACULTYIDANDSTATUS_FACULTYID_2 =
		"facultyRotationTsBlockDetailsRel.facultyId = ? AND ";

	private static final String _FINDER_COLUMN_FACULTYIDANDSTATUS_STATUS_2 =
		"facultyRotationTsBlockDetailsRel.status = ?";

	private static final String _FINDER_COLUMN_FACULTYIDANDSTATUS_STATUS_3 =
		"(facultyRotationTsBlockDetailsRel.status IS NULL OR facultyRotationTsBlockDetailsRel.status = '')";

	private FinderPath
		_finderPathWithPaginationFindByBlocksMetadataDetailsRelIdAndProgDurationRotationTsRelId;
	private FinderPath
		_finderPathWithoutPaginationFindByBlocksMetadataDetailsRelIdAndProgDurationRotationTsRelId;
	private FinderPath
		_finderPathCountByBlocksMetadataDetailsRelIdAndProgDurationRotationTsRelId;

	/**
	 * Returns all the faculty rotation ts block details rels where blocksMetadataDetailsRelId = &#63; and progDurationRotationTsRelId = &#63;.
	 *
	 * @param blocksMetadataDetailsRelId the blocks metadata details rel ID
	 * @param progDurationRotationTsRelId the prog duration rotation ts rel ID
	 * @return the matching faculty rotation ts block details rels
	 */
	@Override
	public List<FacultyRotationTsBlockDetailsRel>
		findByBlocksMetadataDetailsRelIdAndProgDurationRotationTsRelId(
			long blocksMetadataDetailsRelId, long progDurationRotationTsRelId) {

		return findByBlocksMetadataDetailsRelIdAndProgDurationRotationTsRelId(
			blocksMetadataDetailsRelId, progDurationRotationTsRelId,
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the faculty rotation ts block details rels where blocksMetadataDetailsRelId = &#63; and progDurationRotationTsRelId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FacultyRotationTsBlockDetailsRelModelImpl</code>.
	 * </p>
	 *
	 * @param blocksMetadataDetailsRelId the blocks metadata details rel ID
	 * @param progDurationRotationTsRelId the prog duration rotation ts rel ID
	 * @param start the lower bound of the range of faculty rotation ts block details rels
	 * @param end the upper bound of the range of faculty rotation ts block details rels (not inclusive)
	 * @return the range of matching faculty rotation ts block details rels
	 */
	@Override
	public List<FacultyRotationTsBlockDetailsRel>
		findByBlocksMetadataDetailsRelIdAndProgDurationRotationTsRelId(
			long blocksMetadataDetailsRelId, long progDurationRotationTsRelId,
			int start, int end) {

		return findByBlocksMetadataDetailsRelIdAndProgDurationRotationTsRelId(
			blocksMetadataDetailsRelId, progDurationRotationTsRelId, start, end,
			null);
	}

	/**
	 * Returns an ordered range of all the faculty rotation ts block details rels where blocksMetadataDetailsRelId = &#63; and progDurationRotationTsRelId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FacultyRotationTsBlockDetailsRelModelImpl</code>.
	 * </p>
	 *
	 * @param blocksMetadataDetailsRelId the blocks metadata details rel ID
	 * @param progDurationRotationTsRelId the prog duration rotation ts rel ID
	 * @param start the lower bound of the range of faculty rotation ts block details rels
	 * @param end the upper bound of the range of faculty rotation ts block details rels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching faculty rotation ts block details rels
	 */
	@Override
	public List<FacultyRotationTsBlockDetailsRel>
		findByBlocksMetadataDetailsRelIdAndProgDurationRotationTsRelId(
			long blocksMetadataDetailsRelId, long progDurationRotationTsRelId,
			int start, int end,
			OrderByComparator<FacultyRotationTsBlockDetailsRel>
				orderByComparator) {

		return findByBlocksMetadataDetailsRelIdAndProgDurationRotationTsRelId(
			blocksMetadataDetailsRelId, progDurationRotationTsRelId, start, end,
			orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the faculty rotation ts block details rels where blocksMetadataDetailsRelId = &#63; and progDurationRotationTsRelId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FacultyRotationTsBlockDetailsRelModelImpl</code>.
	 * </p>
	 *
	 * @param blocksMetadataDetailsRelId the blocks metadata details rel ID
	 * @param progDurationRotationTsRelId the prog duration rotation ts rel ID
	 * @param start the lower bound of the range of faculty rotation ts block details rels
	 * @param end the upper bound of the range of faculty rotation ts block details rels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching faculty rotation ts block details rels
	 */
	@Override
	public List<FacultyRotationTsBlockDetailsRel>
		findByBlocksMetadataDetailsRelIdAndProgDurationRotationTsRelId(
			long blocksMetadataDetailsRelId, long progDurationRotationTsRelId,
			int start, int end,
			OrderByComparator<FacultyRotationTsBlockDetailsRel>
				orderByComparator,
			boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath =
					_finderPathWithoutPaginationFindByBlocksMetadataDetailsRelIdAndProgDurationRotationTsRelId;
				finderArgs = new Object[] {
					blocksMetadataDetailsRelId, progDurationRotationTsRelId
				};
			}
		}
		else if (useFinderCache) {
			finderPath =
				_finderPathWithPaginationFindByBlocksMetadataDetailsRelIdAndProgDurationRotationTsRelId;
			finderArgs = new Object[] {
				blocksMetadataDetailsRelId, progDurationRotationTsRelId, start,
				end, orderByComparator
			};
		}

		List<FacultyRotationTsBlockDetailsRel> list = null;

		if (useFinderCache) {
			list =
				(List<FacultyRotationTsBlockDetailsRel>)finderCache.getResult(
					finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (FacultyRotationTsBlockDetailsRel
						facultyRotationTsBlockDetailsRel : list) {

					if ((blocksMetadataDetailsRelId !=
							facultyRotationTsBlockDetailsRel.
								getBlocksMetadataDetailsRelId()) ||
						(progDurationRotationTsRelId !=
							facultyRotationTsBlockDetailsRel.
								getProgDurationRotationTsRelId())) {

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

			sb.append(_SQL_SELECT_FACULTYROTATIONTSBLOCKDETAILSREL_WHERE);

			sb.append(
				_FINDER_COLUMN_BLOCKSMETADATADETAILSRELIDANDPROGDURATIONROTATIONTSRELID_BLOCKSMETADATADETAILSRELID_2);

			sb.append(
				_FINDER_COLUMN_BLOCKSMETADATADETAILSRELIDANDPROGDURATIONROTATIONTSRELID_PROGDURATIONROTATIONTSRELID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(
					FacultyRotationTsBlockDetailsRelModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(blocksMetadataDetailsRelId);

				queryPos.add(progDurationRotationTsRelId);

				list = (List<FacultyRotationTsBlockDetailsRel>)QueryUtil.list(
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
	 * Returns the first faculty rotation ts block details rel in the ordered set where blocksMetadataDetailsRelId = &#63; and progDurationRotationTsRelId = &#63;.
	 *
	 * @param blocksMetadataDetailsRelId the blocks metadata details rel ID
	 * @param progDurationRotationTsRelId the prog duration rotation ts rel ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching faculty rotation ts block details rel
	 * @throws NoSuchFacultyRotationTsBlockDetailsRelException if a matching faculty rotation ts block details rel could not be found
	 */
	@Override
	public FacultyRotationTsBlockDetailsRel
			findByBlocksMetadataDetailsRelIdAndProgDurationRotationTsRelId_First(
				long blocksMetadataDetailsRelId,
				long progDurationRotationTsRelId,
				OrderByComparator<FacultyRotationTsBlockDetailsRel>
					orderByComparator)
		throws NoSuchFacultyRotationTsBlockDetailsRelException {

		FacultyRotationTsBlockDetailsRel facultyRotationTsBlockDetailsRel =
			fetchByBlocksMetadataDetailsRelIdAndProgDurationRotationTsRelId_First(
				blocksMetadataDetailsRelId, progDurationRotationTsRelId,
				orderByComparator);

		if (facultyRotationTsBlockDetailsRel != null) {
			return facultyRotationTsBlockDetailsRel;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("blocksMetadataDetailsRelId=");
		sb.append(blocksMetadataDetailsRelId);

		sb.append(", progDurationRotationTsRelId=");
		sb.append(progDurationRotationTsRelId);

		sb.append("}");

		throw new NoSuchFacultyRotationTsBlockDetailsRelException(
			sb.toString());
	}

	/**
	 * Returns the first faculty rotation ts block details rel in the ordered set where blocksMetadataDetailsRelId = &#63; and progDurationRotationTsRelId = &#63;.
	 *
	 * @param blocksMetadataDetailsRelId the blocks metadata details rel ID
	 * @param progDurationRotationTsRelId the prog duration rotation ts rel ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching faculty rotation ts block details rel, or <code>null</code> if a matching faculty rotation ts block details rel could not be found
	 */
	@Override
	public FacultyRotationTsBlockDetailsRel
		fetchByBlocksMetadataDetailsRelIdAndProgDurationRotationTsRelId_First(
			long blocksMetadataDetailsRelId, long progDurationRotationTsRelId,
			OrderByComparator<FacultyRotationTsBlockDetailsRel>
				orderByComparator) {

		List<FacultyRotationTsBlockDetailsRel> list =
			findByBlocksMetadataDetailsRelIdAndProgDurationRotationTsRelId(
				blocksMetadataDetailsRelId, progDurationRotationTsRelId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last faculty rotation ts block details rel in the ordered set where blocksMetadataDetailsRelId = &#63; and progDurationRotationTsRelId = &#63;.
	 *
	 * @param blocksMetadataDetailsRelId the blocks metadata details rel ID
	 * @param progDurationRotationTsRelId the prog duration rotation ts rel ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching faculty rotation ts block details rel
	 * @throws NoSuchFacultyRotationTsBlockDetailsRelException if a matching faculty rotation ts block details rel could not be found
	 */
	@Override
	public FacultyRotationTsBlockDetailsRel
			findByBlocksMetadataDetailsRelIdAndProgDurationRotationTsRelId_Last(
				long blocksMetadataDetailsRelId,
				long progDurationRotationTsRelId,
				OrderByComparator<FacultyRotationTsBlockDetailsRel>
					orderByComparator)
		throws NoSuchFacultyRotationTsBlockDetailsRelException {

		FacultyRotationTsBlockDetailsRel facultyRotationTsBlockDetailsRel =
			fetchByBlocksMetadataDetailsRelIdAndProgDurationRotationTsRelId_Last(
				blocksMetadataDetailsRelId, progDurationRotationTsRelId,
				orderByComparator);

		if (facultyRotationTsBlockDetailsRel != null) {
			return facultyRotationTsBlockDetailsRel;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("blocksMetadataDetailsRelId=");
		sb.append(blocksMetadataDetailsRelId);

		sb.append(", progDurationRotationTsRelId=");
		sb.append(progDurationRotationTsRelId);

		sb.append("}");

		throw new NoSuchFacultyRotationTsBlockDetailsRelException(
			sb.toString());
	}

	/**
	 * Returns the last faculty rotation ts block details rel in the ordered set where blocksMetadataDetailsRelId = &#63; and progDurationRotationTsRelId = &#63;.
	 *
	 * @param blocksMetadataDetailsRelId the blocks metadata details rel ID
	 * @param progDurationRotationTsRelId the prog duration rotation ts rel ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching faculty rotation ts block details rel, or <code>null</code> if a matching faculty rotation ts block details rel could not be found
	 */
	@Override
	public FacultyRotationTsBlockDetailsRel
		fetchByBlocksMetadataDetailsRelIdAndProgDurationRotationTsRelId_Last(
			long blocksMetadataDetailsRelId, long progDurationRotationTsRelId,
			OrderByComparator<FacultyRotationTsBlockDetailsRel>
				orderByComparator) {

		int count =
			countByBlocksMetadataDetailsRelIdAndProgDurationRotationTsRelId(
				blocksMetadataDetailsRelId, progDurationRotationTsRelId);

		if (count == 0) {
			return null;
		}

		List<FacultyRotationTsBlockDetailsRel> list =
			findByBlocksMetadataDetailsRelIdAndProgDurationRotationTsRelId(
				blocksMetadataDetailsRelId, progDurationRotationTsRelId,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the faculty rotation ts block details rels before and after the current faculty rotation ts block details rel in the ordered set where blocksMetadataDetailsRelId = &#63; and progDurationRotationTsRelId = &#63;.
	 *
	 * @param facultyRotationTsBlockDetailsRelId the primary key of the current faculty rotation ts block details rel
	 * @param blocksMetadataDetailsRelId the blocks metadata details rel ID
	 * @param progDurationRotationTsRelId the prog duration rotation ts rel ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next faculty rotation ts block details rel
	 * @throws NoSuchFacultyRotationTsBlockDetailsRelException if a faculty rotation ts block details rel with the primary key could not be found
	 */
	@Override
	public FacultyRotationTsBlockDetailsRel[]
			findByBlocksMetadataDetailsRelIdAndProgDurationRotationTsRelId_PrevAndNext(
				long facultyRotationTsBlockDetailsRelId,
				long blocksMetadataDetailsRelId,
				long progDurationRotationTsRelId,
				OrderByComparator<FacultyRotationTsBlockDetailsRel>
					orderByComparator)
		throws NoSuchFacultyRotationTsBlockDetailsRelException {

		FacultyRotationTsBlockDetailsRel facultyRotationTsBlockDetailsRel =
			findByPrimaryKey(facultyRotationTsBlockDetailsRelId);

		Session session = null;

		try {
			session = openSession();

			FacultyRotationTsBlockDetailsRel[] array =
				new FacultyRotationTsBlockDetailsRelImpl[3];

			array[0] =
				getByBlocksMetadataDetailsRelIdAndProgDurationRotationTsRelId_PrevAndNext(
					session, facultyRotationTsBlockDetailsRel,
					blocksMetadataDetailsRelId, progDurationRotationTsRelId,
					orderByComparator, true);

			array[1] = facultyRotationTsBlockDetailsRel;

			array[2] =
				getByBlocksMetadataDetailsRelIdAndProgDurationRotationTsRelId_PrevAndNext(
					session, facultyRotationTsBlockDetailsRel,
					blocksMetadataDetailsRelId, progDurationRotationTsRelId,
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

	protected FacultyRotationTsBlockDetailsRel
		getByBlocksMetadataDetailsRelIdAndProgDurationRotationTsRelId_PrevAndNext(
			Session session,
			FacultyRotationTsBlockDetailsRel facultyRotationTsBlockDetailsRel,
			long blocksMetadataDetailsRelId, long progDurationRotationTsRelId,
			OrderByComparator<FacultyRotationTsBlockDetailsRel>
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

		sb.append(_SQL_SELECT_FACULTYROTATIONTSBLOCKDETAILSREL_WHERE);

		sb.append(
			_FINDER_COLUMN_BLOCKSMETADATADETAILSRELIDANDPROGDURATIONROTATIONTSRELID_BLOCKSMETADATADETAILSRELID_2);

		sb.append(
			_FINDER_COLUMN_BLOCKSMETADATADETAILSRELIDANDPROGDURATIONROTATIONTSRELID_PROGDURATIONROTATIONTSRELID_2);

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
			sb.append(FacultyRotationTsBlockDetailsRelModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(blocksMetadataDetailsRelId);

		queryPos.add(progDurationRotationTsRelId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						facultyRotationTsBlockDetailsRel)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<FacultyRotationTsBlockDetailsRel> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the faculty rotation ts block details rels where blocksMetadataDetailsRelId = &#63; and progDurationRotationTsRelId = &#63; from the database.
	 *
	 * @param blocksMetadataDetailsRelId the blocks metadata details rel ID
	 * @param progDurationRotationTsRelId the prog duration rotation ts rel ID
	 */
	@Override
	public void
		removeByBlocksMetadataDetailsRelIdAndProgDurationRotationTsRelId(
			long blocksMetadataDetailsRelId, long progDurationRotationTsRelId) {

		for (FacultyRotationTsBlockDetailsRel facultyRotationTsBlockDetailsRel :
				findByBlocksMetadataDetailsRelIdAndProgDurationRotationTsRelId(
					blocksMetadataDetailsRelId, progDurationRotationTsRelId,
					QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(facultyRotationTsBlockDetailsRel);
		}
	}

	/**
	 * Returns the number of faculty rotation ts block details rels where blocksMetadataDetailsRelId = &#63; and progDurationRotationTsRelId = &#63;.
	 *
	 * @param blocksMetadataDetailsRelId the blocks metadata details rel ID
	 * @param progDurationRotationTsRelId the prog duration rotation ts rel ID
	 * @return the number of matching faculty rotation ts block details rels
	 */
	@Override
	public int countByBlocksMetadataDetailsRelIdAndProgDurationRotationTsRelId(
		long blocksMetadataDetailsRelId, long progDurationRotationTsRelId) {

		FinderPath finderPath =
			_finderPathCountByBlocksMetadataDetailsRelIdAndProgDurationRotationTsRelId;

		Object[] finderArgs = new Object[] {
			blocksMetadataDetailsRelId, progDurationRotationTsRelId
		};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_FACULTYROTATIONTSBLOCKDETAILSREL_WHERE);

			sb.append(
				_FINDER_COLUMN_BLOCKSMETADATADETAILSRELIDANDPROGDURATIONROTATIONTSRELID_BLOCKSMETADATADETAILSRELID_2);

			sb.append(
				_FINDER_COLUMN_BLOCKSMETADATADETAILSRELIDANDPROGDURATIONROTATIONTSRELID_PROGDURATIONROTATIONTSRELID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(blocksMetadataDetailsRelId);

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
		_FINDER_COLUMN_BLOCKSMETADATADETAILSRELIDANDPROGDURATIONROTATIONTSRELID_BLOCKSMETADATADETAILSRELID_2 =
			"facultyRotationTsBlockDetailsRel.blocksMetadataDetailsRelId = ? AND ";

	private static final String
		_FINDER_COLUMN_BLOCKSMETADATADETAILSRELIDANDPROGDURATIONROTATIONTSRELID_PROGDURATIONROTATIONTSRELID_2 =
			"facultyRotationTsBlockDetailsRel.progDurationRotationTsRelId = ?";

	public FacultyRotationTsBlockDetailsRelPersistenceImpl() {
		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("uuid", "uuid_");
		dbColumnNames.put(
			"facultyRotationTsBlockDetailsRelId",
			"faculty_rotation_ts_block_details_rel_id");
		dbColumnNames.put("groupId", "group_id");
		dbColumnNames.put("companyId", "company_id");
		dbColumnNames.put("createDate", "create_date");
		dbColumnNames.put("modifiedDate", "modified_date");
		dbColumnNames.put("createdBy", "created_by");
		dbColumnNames.put("modifiedBy", "modified_by");
		dbColumnNames.put("facultyId", "faculty_id");
		dbColumnNames.put(
			"blocksMetadataDetailsRelId", "blocks_metadata_details_rel_id");
		dbColumnNames.put(
			"progDurationRotationTsRelId", "progduration_rotation_ts_rel_id");

		setDBColumnNames(dbColumnNames);

		setModelClass(FacultyRotationTsBlockDetailsRel.class);

		setModelImplClass(FacultyRotationTsBlockDetailsRelImpl.class);
		setModelPKClass(long.class);

		setTable(FacultyRotationTsBlockDetailsRelTable.INSTANCE);
	}

	/**
	 * Caches the faculty rotation ts block details rel in the entity cache if it is enabled.
	 *
	 * @param facultyRotationTsBlockDetailsRel the faculty rotation ts block details rel
	 */
	@Override
	public void cacheResult(
		FacultyRotationTsBlockDetailsRel facultyRotationTsBlockDetailsRel) {

		entityCache.putResult(
			FacultyRotationTsBlockDetailsRelImpl.class,
			facultyRotationTsBlockDetailsRel.getPrimaryKey(),
			facultyRotationTsBlockDetailsRel);

		finderCache.putResult(
			_finderPathFetchByUUID_G,
			new Object[] {
				facultyRotationTsBlockDetailsRel.getUuid(),
				facultyRotationTsBlockDetailsRel.getGroupId()
			},
			facultyRotationTsBlockDetailsRel);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the faculty rotation ts block details rels in the entity cache if it is enabled.
	 *
	 * @param facultyRotationTsBlockDetailsRels the faculty rotation ts block details rels
	 */
	@Override
	public void cacheResult(
		List<FacultyRotationTsBlockDetailsRel>
			facultyRotationTsBlockDetailsRels) {

		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (facultyRotationTsBlockDetailsRels.size() >
				 _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (FacultyRotationTsBlockDetailsRel facultyRotationTsBlockDetailsRel :
				facultyRotationTsBlockDetailsRels) {

			if (entityCache.getResult(
					FacultyRotationTsBlockDetailsRelImpl.class,
					facultyRotationTsBlockDetailsRel.getPrimaryKey()) == null) {

				cacheResult(facultyRotationTsBlockDetailsRel);
			}
		}
	}

	/**
	 * Clears the cache for all faculty rotation ts block details rels.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(FacultyRotationTsBlockDetailsRelImpl.class);

		finderCache.clearCache(FacultyRotationTsBlockDetailsRelImpl.class);
	}

	/**
	 * Clears the cache for the faculty rotation ts block details rel.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(
		FacultyRotationTsBlockDetailsRel facultyRotationTsBlockDetailsRel) {

		entityCache.removeResult(
			FacultyRotationTsBlockDetailsRelImpl.class,
			facultyRotationTsBlockDetailsRel);
	}

	@Override
	public void clearCache(
		List<FacultyRotationTsBlockDetailsRel>
			facultyRotationTsBlockDetailsRels) {

		for (FacultyRotationTsBlockDetailsRel facultyRotationTsBlockDetailsRel :
				facultyRotationTsBlockDetailsRels) {

			entityCache.removeResult(
				FacultyRotationTsBlockDetailsRelImpl.class,
				facultyRotationTsBlockDetailsRel);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(FacultyRotationTsBlockDetailsRelImpl.class);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(
				FacultyRotationTsBlockDetailsRelImpl.class, primaryKey);
		}
	}

	protected void cacheUniqueFindersCache(
		FacultyRotationTsBlockDetailsRelModelImpl
			facultyRotationTsBlockDetailsRelModelImpl) {

		Object[] args = new Object[] {
			facultyRotationTsBlockDetailsRelModelImpl.getUuid(),
			facultyRotationTsBlockDetailsRelModelImpl.getGroupId()
		};

		finderCache.putResult(_finderPathCountByUUID_G, args, Long.valueOf(1));
		finderCache.putResult(
			_finderPathFetchByUUID_G, args,
			facultyRotationTsBlockDetailsRelModelImpl);
	}

	/**
	 * Creates a new faculty rotation ts block details rel with the primary key. Does not add the faculty rotation ts block details rel to the database.
	 *
	 * @param facultyRotationTsBlockDetailsRelId the primary key for the new faculty rotation ts block details rel
	 * @return the new faculty rotation ts block details rel
	 */
	@Override
	public FacultyRotationTsBlockDetailsRel create(
		long facultyRotationTsBlockDetailsRelId) {

		FacultyRotationTsBlockDetailsRel facultyRotationTsBlockDetailsRel =
			new FacultyRotationTsBlockDetailsRelImpl();

		facultyRotationTsBlockDetailsRel.setNew(true);
		facultyRotationTsBlockDetailsRel.setPrimaryKey(
			facultyRotationTsBlockDetailsRelId);

		String uuid = _portalUUID.generate();

		facultyRotationTsBlockDetailsRel.setUuid(uuid);

		facultyRotationTsBlockDetailsRel.setCompanyId(
			CompanyThreadLocal.getCompanyId());

		return facultyRotationTsBlockDetailsRel;
	}

	/**
	 * Removes the faculty rotation ts block details rel with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param facultyRotationTsBlockDetailsRelId the primary key of the faculty rotation ts block details rel
	 * @return the faculty rotation ts block details rel that was removed
	 * @throws NoSuchFacultyRotationTsBlockDetailsRelException if a faculty rotation ts block details rel with the primary key could not be found
	 */
	@Override
	public FacultyRotationTsBlockDetailsRel remove(
			long facultyRotationTsBlockDetailsRelId)
		throws NoSuchFacultyRotationTsBlockDetailsRelException {

		return remove((Serializable)facultyRotationTsBlockDetailsRelId);
	}

	/**
	 * Removes the faculty rotation ts block details rel with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the faculty rotation ts block details rel
	 * @return the faculty rotation ts block details rel that was removed
	 * @throws NoSuchFacultyRotationTsBlockDetailsRelException if a faculty rotation ts block details rel with the primary key could not be found
	 */
	@Override
	public FacultyRotationTsBlockDetailsRel remove(Serializable primaryKey)
		throws NoSuchFacultyRotationTsBlockDetailsRelException {

		Session session = null;

		try {
			session = openSession();

			FacultyRotationTsBlockDetailsRel facultyRotationTsBlockDetailsRel =
				(FacultyRotationTsBlockDetailsRel)session.get(
					FacultyRotationTsBlockDetailsRelImpl.class, primaryKey);

			if (facultyRotationTsBlockDetailsRel == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchFacultyRotationTsBlockDetailsRelException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(facultyRotationTsBlockDetailsRel);
		}
		catch (NoSuchFacultyRotationTsBlockDetailsRelException
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
	protected FacultyRotationTsBlockDetailsRel removeImpl(
		FacultyRotationTsBlockDetailsRel facultyRotationTsBlockDetailsRel) {

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(facultyRotationTsBlockDetailsRel)) {
				facultyRotationTsBlockDetailsRel =
					(FacultyRotationTsBlockDetailsRel)session.get(
						FacultyRotationTsBlockDetailsRelImpl.class,
						facultyRotationTsBlockDetailsRel.getPrimaryKeyObj());
			}

			if (facultyRotationTsBlockDetailsRel != null) {
				session.delete(facultyRotationTsBlockDetailsRel);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (facultyRotationTsBlockDetailsRel != null) {
			clearCache(facultyRotationTsBlockDetailsRel);
		}

		return facultyRotationTsBlockDetailsRel;
	}

	@Override
	public FacultyRotationTsBlockDetailsRel updateImpl(
		FacultyRotationTsBlockDetailsRel facultyRotationTsBlockDetailsRel) {

		boolean isNew = facultyRotationTsBlockDetailsRel.isNew();

		if (!(facultyRotationTsBlockDetailsRel instanceof
				FacultyRotationTsBlockDetailsRelModelImpl)) {

			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(
					facultyRotationTsBlockDetailsRel.getClass())) {

				invocationHandler = ProxyUtil.getInvocationHandler(
					facultyRotationTsBlockDetailsRel);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in facultyRotationTsBlockDetailsRel proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom FacultyRotationTsBlockDetailsRel implementation " +
					facultyRotationTsBlockDetailsRel.getClass());
		}

		FacultyRotationTsBlockDetailsRelModelImpl
			facultyRotationTsBlockDetailsRelModelImpl =
				(FacultyRotationTsBlockDetailsRelModelImpl)
					facultyRotationTsBlockDetailsRel;

		if (Validator.isNull(facultyRotationTsBlockDetailsRel.getUuid())) {
			String uuid = _portalUUID.generate();

			facultyRotationTsBlockDetailsRel.setUuid(uuid);
		}

		ServiceContext serviceContext =
			ServiceContextThreadLocal.getServiceContext();

		Date date = new Date();

		if (isNew &&
			(facultyRotationTsBlockDetailsRel.getCreateDate() == null)) {

			if (serviceContext == null) {
				facultyRotationTsBlockDetailsRel.setCreateDate(date);
			}
			else {
				facultyRotationTsBlockDetailsRel.setCreateDate(
					serviceContext.getCreateDate(date));
			}
		}

		if (!facultyRotationTsBlockDetailsRelModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				facultyRotationTsBlockDetailsRel.setModifiedDate(date);
			}
			else {
				facultyRotationTsBlockDetailsRel.setModifiedDate(
					serviceContext.getModifiedDate(date));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(facultyRotationTsBlockDetailsRel);
			}
			else {
				facultyRotationTsBlockDetailsRel =
					(FacultyRotationTsBlockDetailsRel)session.merge(
						facultyRotationTsBlockDetailsRel);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(
			FacultyRotationTsBlockDetailsRelImpl.class,
			facultyRotationTsBlockDetailsRelModelImpl, false, true);

		cacheUniqueFindersCache(facultyRotationTsBlockDetailsRelModelImpl);

		if (isNew) {
			facultyRotationTsBlockDetailsRel.setNew(false);
		}

		facultyRotationTsBlockDetailsRel.resetOriginalValues();

		return facultyRotationTsBlockDetailsRel;
	}

	/**
	 * Returns the faculty rotation ts block details rel with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the faculty rotation ts block details rel
	 * @return the faculty rotation ts block details rel
	 * @throws NoSuchFacultyRotationTsBlockDetailsRelException if a faculty rotation ts block details rel with the primary key could not be found
	 */
	@Override
	public FacultyRotationTsBlockDetailsRel findByPrimaryKey(
			Serializable primaryKey)
		throws NoSuchFacultyRotationTsBlockDetailsRelException {

		FacultyRotationTsBlockDetailsRel facultyRotationTsBlockDetailsRel =
			fetchByPrimaryKey(primaryKey);

		if (facultyRotationTsBlockDetailsRel == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchFacultyRotationTsBlockDetailsRelException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return facultyRotationTsBlockDetailsRel;
	}

	/**
	 * Returns the faculty rotation ts block details rel with the primary key or throws a <code>NoSuchFacultyRotationTsBlockDetailsRelException</code> if it could not be found.
	 *
	 * @param facultyRotationTsBlockDetailsRelId the primary key of the faculty rotation ts block details rel
	 * @return the faculty rotation ts block details rel
	 * @throws NoSuchFacultyRotationTsBlockDetailsRelException if a faculty rotation ts block details rel with the primary key could not be found
	 */
	@Override
	public FacultyRotationTsBlockDetailsRel findByPrimaryKey(
			long facultyRotationTsBlockDetailsRelId)
		throws NoSuchFacultyRotationTsBlockDetailsRelException {

		return findByPrimaryKey(
			(Serializable)facultyRotationTsBlockDetailsRelId);
	}

	/**
	 * Returns the faculty rotation ts block details rel with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param facultyRotationTsBlockDetailsRelId the primary key of the faculty rotation ts block details rel
	 * @return the faculty rotation ts block details rel, or <code>null</code> if a faculty rotation ts block details rel with the primary key could not be found
	 */
	@Override
	public FacultyRotationTsBlockDetailsRel fetchByPrimaryKey(
		long facultyRotationTsBlockDetailsRelId) {

		return fetchByPrimaryKey(
			(Serializable)facultyRotationTsBlockDetailsRelId);
	}

	/**
	 * Returns all the faculty rotation ts block details rels.
	 *
	 * @return the faculty rotation ts block details rels
	 */
	@Override
	public List<FacultyRotationTsBlockDetailsRel> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the faculty rotation ts block details rels.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FacultyRotationTsBlockDetailsRelModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of faculty rotation ts block details rels
	 * @param end the upper bound of the range of faculty rotation ts block details rels (not inclusive)
	 * @return the range of faculty rotation ts block details rels
	 */
	@Override
	public List<FacultyRotationTsBlockDetailsRel> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the faculty rotation ts block details rels.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FacultyRotationTsBlockDetailsRelModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of faculty rotation ts block details rels
	 * @param end the upper bound of the range of faculty rotation ts block details rels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of faculty rotation ts block details rels
	 */
	@Override
	public List<FacultyRotationTsBlockDetailsRel> findAll(
		int start, int end,
		OrderByComparator<FacultyRotationTsBlockDetailsRel> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the faculty rotation ts block details rels.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FacultyRotationTsBlockDetailsRelModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of faculty rotation ts block details rels
	 * @param end the upper bound of the range of faculty rotation ts block details rels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of faculty rotation ts block details rels
	 */
	@Override
	public List<FacultyRotationTsBlockDetailsRel> findAll(
		int start, int end,
		OrderByComparator<FacultyRotationTsBlockDetailsRel> orderByComparator,
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

		List<FacultyRotationTsBlockDetailsRel> list = null;

		if (useFinderCache) {
			list =
				(List<FacultyRotationTsBlockDetailsRel>)finderCache.getResult(
					finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_FACULTYROTATIONTSBLOCKDETAILSREL);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_FACULTYROTATIONTSBLOCKDETAILSREL;

				sql = sql.concat(
					FacultyRotationTsBlockDetailsRelModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<FacultyRotationTsBlockDetailsRel>)QueryUtil.list(
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
	 * Removes all the faculty rotation ts block details rels from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (FacultyRotationTsBlockDetailsRel facultyRotationTsBlockDetailsRel :
				findAll()) {

			remove(facultyRotationTsBlockDetailsRel);
		}
	}

	/**
	 * Returns the number of faculty rotation ts block details rels.
	 *
	 * @return the number of faculty rotation ts block details rels
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
					_SQL_COUNT_FACULTYROTATIONTSBLOCKDETAILSREL);

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
		return "faculty_rotation_ts_block_details_rel_id";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_FACULTYROTATIONTSBLOCKDETAILSREL;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return FacultyRotationTsBlockDetailsRelModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the faculty rotation ts block details rel persistence.
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

		_finderPathWithPaginationFindByFacultyId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByFacultyId",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"faculty_id"}, true);

		_finderPathWithoutPaginationFindByFacultyId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByFacultyId",
			new String[] {Long.class.getName()}, new String[] {"faculty_id"},
			true);

		_finderPathCountByFacultyId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByFacultyId",
			new String[] {Long.class.getName()}, new String[] {"faculty_id"},
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

		_finderPathWithPaginationFindByFacultyIdAndStatus = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByFacultyIdAndStatus",
			new String[] {
				Long.class.getName(), String.class.getName(),
				Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			},
			new String[] {"faculty_id", "status"}, true);

		_finderPathWithoutPaginationFindByFacultyIdAndStatus = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByFacultyIdAndStatus",
			new String[] {Long.class.getName(), String.class.getName()},
			new String[] {"faculty_id", "status"}, true);

		_finderPathCountByFacultyIdAndStatus = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByFacultyIdAndStatus",
			new String[] {Long.class.getName(), String.class.getName()},
			new String[] {"faculty_id", "status"}, false);

		_finderPathWithPaginationFindByBlocksMetadataDetailsRelIdAndProgDurationRotationTsRelId =
			new FinderPath(
				FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
				"findByBlocksMetadataDetailsRelIdAndProgDurationRotationTsRelId",
				new String[] {
					Long.class.getName(), Long.class.getName(),
					Integer.class.getName(), Integer.class.getName(),
					OrderByComparator.class.getName()
				},
				new String[] {
					"blocks_metadata_details_rel_id",
					"progduration_rotation_ts_rel_id"
				},
				true);

		_finderPathWithoutPaginationFindByBlocksMetadataDetailsRelIdAndProgDurationRotationTsRelId =
			new FinderPath(
				FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
				"findByBlocksMetadataDetailsRelIdAndProgDurationRotationTsRelId",
				new String[] {Long.class.getName(), Long.class.getName()},
				new String[] {
					"blocks_metadata_details_rel_id",
					"progduration_rotation_ts_rel_id"
				},
				true);

		_finderPathCountByBlocksMetadataDetailsRelIdAndProgDurationRotationTsRelId =
			new FinderPath(
				FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
				"countByBlocksMetadataDetailsRelIdAndProgDurationRotationTsRelId",
				new String[] {Long.class.getName(), Long.class.getName()},
				new String[] {
					"blocks_metadata_details_rel_id",
					"progduration_rotation_ts_rel_id"
				},
				false);

		_setFacultyRotationTsBlockDetailsRelUtilPersistence(this);
	}

	@Deactivate
	public void deactivate() {
		_setFacultyRotationTsBlockDetailsRelUtilPersistence(null);

		entityCache.removeCache(
			FacultyRotationTsBlockDetailsRelImpl.class.getName());
	}

	private void _setFacultyRotationTsBlockDetailsRelUtilPersistence(
		FacultyRotationTsBlockDetailsRelPersistence
			facultyRotationTsBlockDetailsRelPersistence) {

		try {
			Field field =
				FacultyRotationTsBlockDetailsRelUtil.class.getDeclaredField(
					"_persistence");

			field.setAccessible(true);

			field.set(null, facultyRotationTsBlockDetailsRelPersistence);
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

	private static final String _SQL_SELECT_FACULTYROTATIONTSBLOCKDETAILSREL =
		"SELECT facultyRotationTsBlockDetailsRel FROM FacultyRotationTsBlockDetailsRel facultyRotationTsBlockDetailsRel";

	private static final String
		_SQL_SELECT_FACULTYROTATIONTSBLOCKDETAILSREL_WHERE =
			"SELECT facultyRotationTsBlockDetailsRel FROM FacultyRotationTsBlockDetailsRel facultyRotationTsBlockDetailsRel WHERE ";

	private static final String _SQL_COUNT_FACULTYROTATIONTSBLOCKDETAILSREL =
		"SELECT COUNT(facultyRotationTsBlockDetailsRel) FROM FacultyRotationTsBlockDetailsRel facultyRotationTsBlockDetailsRel";

	private static final String
		_SQL_COUNT_FACULTYROTATIONTSBLOCKDETAILSREL_WHERE =
			"SELECT COUNT(facultyRotationTsBlockDetailsRel) FROM FacultyRotationTsBlockDetailsRel facultyRotationTsBlockDetailsRel WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS =
		"facultyRotationTsBlockDetailsRel.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No FacultyRotationTsBlockDetailsRel exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No FacultyRotationTsBlockDetailsRel exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		FacultyRotationTsBlockDetailsRelPersistenceImpl.class);

	private static final Set<String> _badColumnNames = SetUtil.fromArray(
		new String[] {
			"uuid", "facultyRotationTsBlockDetailsRelId", "groupId",
			"companyId", "createDate", "modifiedDate", "createdBy",
			"modifiedBy", "facultyId", "blocksMetadataDetailsRelId",
			"progDurationRotationTsRelId"
		});

	@Override
	protected FinderCache getFinderCache() {
		return finderCache;
	}

	@Reference
	private PortalUUID _portalUUID;

}
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

import gov.omsb.tms.exception.NoSuchRotationCompetenciesRequirementsRelException;
import gov.omsb.tms.model.RotationCompetenciesRequirementsRel;
import gov.omsb.tms.model.RotationCompetenciesRequirementsRelTable;
import gov.omsb.tms.model.impl.RotationCompetenciesRequirementsRelImpl;
import gov.omsb.tms.model.impl.RotationCompetenciesRequirementsRelModelImpl;
import gov.omsb.tms.service.persistence.RotationCompetenciesRequirementsRelPersistence;
import gov.omsb.tms.service.persistence.RotationCompetenciesRequirementsRelUtil;
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
 * The persistence implementation for the rotation competencies requirements rel service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = RotationCompetenciesRequirementsRelPersistence.class)
public class RotationCompetenciesRequirementsRelPersistenceImpl
	extends BasePersistenceImpl<RotationCompetenciesRequirementsRel>
	implements RotationCompetenciesRequirementsRelPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>RotationCompetenciesRequirementsRelUtil</code> to access the rotation competencies requirements rel persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		RotationCompetenciesRequirementsRelImpl.class.getName();

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
	 * Returns all the rotation competencies requirements rels where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching rotation competencies requirements rels
	 */
	@Override
	public List<RotationCompetenciesRequirementsRel> findByUuid(String uuid) {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the rotation competencies requirements rels where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RotationCompetenciesRequirementsRelModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of rotation competencies requirements rels
	 * @param end the upper bound of the range of rotation competencies requirements rels (not inclusive)
	 * @return the range of matching rotation competencies requirements rels
	 */
	@Override
	public List<RotationCompetenciesRequirementsRel> findByUuid(
		String uuid, int start, int end) {

		return findByUuid(uuid, start, end, null);
	}

	/**
	 * Returns an ordered range of all the rotation competencies requirements rels where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RotationCompetenciesRequirementsRelModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of rotation competencies requirements rels
	 * @param end the upper bound of the range of rotation competencies requirements rels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching rotation competencies requirements rels
	 */
	@Override
	public List<RotationCompetenciesRequirementsRel> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<RotationCompetenciesRequirementsRel>
			orderByComparator) {

		return findByUuid(uuid, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the rotation competencies requirements rels where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RotationCompetenciesRequirementsRelModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of rotation competencies requirements rels
	 * @param end the upper bound of the range of rotation competencies requirements rels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching rotation competencies requirements rels
	 */
	@Override
	public List<RotationCompetenciesRequirementsRel> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<RotationCompetenciesRequirementsRel>
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

		List<RotationCompetenciesRequirementsRel> list = null;

		if (useFinderCache) {
			list =
				(List<RotationCompetenciesRequirementsRel>)
					finderCache.getResult(finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (RotationCompetenciesRequirementsRel
						rotationCompetenciesRequirementsRel : list) {

					if (!uuid.equals(
							rotationCompetenciesRequirementsRel.getUuid())) {

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

			sb.append(_SQL_SELECT_ROTATIONCOMPETENCIESREQUIREMENTSREL_WHERE);

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
					RotationCompetenciesRequirementsRelModelImpl.ORDER_BY_JPQL);
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
					(List<RotationCompetenciesRequirementsRel>)QueryUtil.list(
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
	 * Returns the first rotation competencies requirements rel in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching rotation competencies requirements rel
	 * @throws NoSuchRotationCompetenciesRequirementsRelException if a matching rotation competencies requirements rel could not be found
	 */
	@Override
	public RotationCompetenciesRequirementsRel findByUuid_First(
			String uuid,
			OrderByComparator<RotationCompetenciesRequirementsRel>
				orderByComparator)
		throws NoSuchRotationCompetenciesRequirementsRelException {

		RotationCompetenciesRequirementsRel
			rotationCompetenciesRequirementsRel = fetchByUuid_First(
				uuid, orderByComparator);

		if (rotationCompetenciesRequirementsRel != null) {
			return rotationCompetenciesRequirementsRel;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchRotationCompetenciesRequirementsRelException(
			sb.toString());
	}

	/**
	 * Returns the first rotation competencies requirements rel in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching rotation competencies requirements rel, or <code>null</code> if a matching rotation competencies requirements rel could not be found
	 */
	@Override
	public RotationCompetenciesRequirementsRel fetchByUuid_First(
		String uuid,
		OrderByComparator<RotationCompetenciesRequirementsRel>
			orderByComparator) {

		List<RotationCompetenciesRequirementsRel> list = findByUuid(
			uuid, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last rotation competencies requirements rel in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching rotation competencies requirements rel
	 * @throws NoSuchRotationCompetenciesRequirementsRelException if a matching rotation competencies requirements rel could not be found
	 */
	@Override
	public RotationCompetenciesRequirementsRel findByUuid_Last(
			String uuid,
			OrderByComparator<RotationCompetenciesRequirementsRel>
				orderByComparator)
		throws NoSuchRotationCompetenciesRequirementsRelException {

		RotationCompetenciesRequirementsRel
			rotationCompetenciesRequirementsRel = fetchByUuid_Last(
				uuid, orderByComparator);

		if (rotationCompetenciesRequirementsRel != null) {
			return rotationCompetenciesRequirementsRel;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchRotationCompetenciesRequirementsRelException(
			sb.toString());
	}

	/**
	 * Returns the last rotation competencies requirements rel in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching rotation competencies requirements rel, or <code>null</code> if a matching rotation competencies requirements rel could not be found
	 */
	@Override
	public RotationCompetenciesRequirementsRel fetchByUuid_Last(
		String uuid,
		OrderByComparator<RotationCompetenciesRequirementsRel>
			orderByComparator) {

		int count = countByUuid(uuid);

		if (count == 0) {
			return null;
		}

		List<RotationCompetenciesRequirementsRel> list = findByUuid(
			uuid, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the rotation competencies requirements rels before and after the current rotation competencies requirements rel in the ordered set where uuid = &#63;.
	 *
	 * @param rotationCompetenciesRelId the primary key of the current rotation competencies requirements rel
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next rotation competencies requirements rel
	 * @throws NoSuchRotationCompetenciesRequirementsRelException if a rotation competencies requirements rel with the primary key could not be found
	 */
	@Override
	public RotationCompetenciesRequirementsRel[] findByUuid_PrevAndNext(
			long rotationCompetenciesRelId, String uuid,
			OrderByComparator<RotationCompetenciesRequirementsRel>
				orderByComparator)
		throws NoSuchRotationCompetenciesRequirementsRelException {

		uuid = Objects.toString(uuid, "");

		RotationCompetenciesRequirementsRel
			rotationCompetenciesRequirementsRel = findByPrimaryKey(
				rotationCompetenciesRelId);

		Session session = null;

		try {
			session = openSession();

			RotationCompetenciesRequirementsRel[] array =
				new RotationCompetenciesRequirementsRelImpl[3];

			array[0] = getByUuid_PrevAndNext(
				session, rotationCompetenciesRequirementsRel, uuid,
				orderByComparator, true);

			array[1] = rotationCompetenciesRequirementsRel;

			array[2] = getByUuid_PrevAndNext(
				session, rotationCompetenciesRequirementsRel, uuid,
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

	protected RotationCompetenciesRequirementsRel getByUuid_PrevAndNext(
		Session session,
		RotationCompetenciesRequirementsRel rotationCompetenciesRequirementsRel,
		String uuid,
		OrderByComparator<RotationCompetenciesRequirementsRel>
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

		sb.append(_SQL_SELECT_ROTATIONCOMPETENCIESREQUIREMENTSREL_WHERE);

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
				RotationCompetenciesRequirementsRelModelImpl.ORDER_BY_JPQL);
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
						rotationCompetenciesRequirementsRel)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<RotationCompetenciesRequirementsRel> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the rotation competencies requirements rels where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	@Override
	public void removeByUuid(String uuid) {
		for (RotationCompetenciesRequirementsRel
				rotationCompetenciesRequirementsRel :
					findByUuid(
						uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(rotationCompetenciesRequirementsRel);
		}
	}

	/**
	 * Returns the number of rotation competencies requirements rels where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching rotation competencies requirements rels
	 */
	@Override
	public int countByUuid(String uuid) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid;

		Object[] finderArgs = new Object[] {uuid};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_ROTATIONCOMPETENCIESREQUIREMENTSREL_WHERE);

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
		"rotationCompetenciesRequirementsRel.uuid = ?";

	private static final String _FINDER_COLUMN_UUID_UUID_3 =
		"(rotationCompetenciesRequirementsRel.uuid IS NULL OR rotationCompetenciesRequirementsRel.uuid = '')";

	private FinderPath _finderPathFetchByUUID_G;
	private FinderPath _finderPathCountByUUID_G;

	/**
	 * Returns the rotation competencies requirements rel where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchRotationCompetenciesRequirementsRelException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching rotation competencies requirements rel
	 * @throws NoSuchRotationCompetenciesRequirementsRelException if a matching rotation competencies requirements rel could not be found
	 */
	@Override
	public RotationCompetenciesRequirementsRel findByUUID_G(
			String uuid, long groupId)
		throws NoSuchRotationCompetenciesRequirementsRelException {

		RotationCompetenciesRequirementsRel
			rotationCompetenciesRequirementsRel = fetchByUUID_G(uuid, groupId);

		if (rotationCompetenciesRequirementsRel == null) {
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

			throw new NoSuchRotationCompetenciesRequirementsRelException(
				sb.toString());
		}

		return rotationCompetenciesRequirementsRel;
	}

	/**
	 * Returns the rotation competencies requirements rel where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching rotation competencies requirements rel, or <code>null</code> if a matching rotation competencies requirements rel could not be found
	 */
	@Override
	public RotationCompetenciesRequirementsRel fetchByUUID_G(
		String uuid, long groupId) {

		return fetchByUUID_G(uuid, groupId, true);
	}

	/**
	 * Returns the rotation competencies requirements rel where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching rotation competencies requirements rel, or <code>null</code> if a matching rotation competencies requirements rel could not be found
	 */
	@Override
	public RotationCompetenciesRequirementsRel fetchByUUID_G(
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

		if (result instanceof RotationCompetenciesRequirementsRel) {
			RotationCompetenciesRequirementsRel
				rotationCompetenciesRequirementsRel =
					(RotationCompetenciesRequirementsRel)result;

			if (!Objects.equals(
					uuid, rotationCompetenciesRequirementsRel.getUuid()) ||
				(groupId != rotationCompetenciesRequirementsRel.getGroupId())) {

				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_SQL_SELECT_ROTATIONCOMPETENCIESREQUIREMENTSREL_WHERE);

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

				List<RotationCompetenciesRequirementsRel> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchByUUID_G, finderArgs, list);
					}
				}
				else {
					RotationCompetenciesRequirementsRel
						rotationCompetenciesRequirementsRel = list.get(0);

					result = rotationCompetenciesRequirementsRel;

					cacheResult(rotationCompetenciesRequirementsRel);
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
			return (RotationCompetenciesRequirementsRel)result;
		}
	}

	/**
	 * Removes the rotation competencies requirements rel where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the rotation competencies requirements rel that was removed
	 */
	@Override
	public RotationCompetenciesRequirementsRel removeByUUID_G(
			String uuid, long groupId)
		throws NoSuchRotationCompetenciesRequirementsRelException {

		RotationCompetenciesRequirementsRel
			rotationCompetenciesRequirementsRel = findByUUID_G(uuid, groupId);

		return remove(rotationCompetenciesRequirementsRel);
	}

	/**
	 * Returns the number of rotation competencies requirements rels where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching rotation competencies requirements rels
	 */
	@Override
	public int countByUUID_G(String uuid, long groupId) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUUID_G;

		Object[] finderArgs = new Object[] {uuid, groupId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_ROTATIONCOMPETENCIESREQUIREMENTSREL_WHERE);

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
		"rotationCompetenciesRequirementsRel.uuid = ? AND ";

	private static final String _FINDER_COLUMN_UUID_G_UUID_3 =
		"(rotationCompetenciesRequirementsRel.uuid IS NULL OR rotationCompetenciesRequirementsRel.uuid = '') AND ";

	private static final String _FINDER_COLUMN_UUID_G_GROUPID_2 =
		"rotationCompetenciesRequirementsRel.groupId = ?";

	private FinderPath _finderPathWithPaginationFindByUuid_C;
	private FinderPath _finderPathWithoutPaginationFindByUuid_C;
	private FinderPath _finderPathCountByUuid_C;

	/**
	 * Returns all the rotation competencies requirements rels where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching rotation competencies requirements rels
	 */
	@Override
	public List<RotationCompetenciesRequirementsRel> findByUuid_C(
		String uuid, long companyId) {

		return findByUuid_C(
			uuid, companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the rotation competencies requirements rels where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RotationCompetenciesRequirementsRelModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of rotation competencies requirements rels
	 * @param end the upper bound of the range of rotation competencies requirements rels (not inclusive)
	 * @return the range of matching rotation competencies requirements rels
	 */
	@Override
	public List<RotationCompetenciesRequirementsRel> findByUuid_C(
		String uuid, long companyId, int start, int end) {

		return findByUuid_C(uuid, companyId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the rotation competencies requirements rels where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RotationCompetenciesRequirementsRelModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of rotation competencies requirements rels
	 * @param end the upper bound of the range of rotation competencies requirements rels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching rotation competencies requirements rels
	 */
	@Override
	public List<RotationCompetenciesRequirementsRel> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<RotationCompetenciesRequirementsRel>
			orderByComparator) {

		return findByUuid_C(
			uuid, companyId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the rotation competencies requirements rels where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RotationCompetenciesRequirementsRelModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of rotation competencies requirements rels
	 * @param end the upper bound of the range of rotation competencies requirements rels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching rotation competencies requirements rels
	 */
	@Override
	public List<RotationCompetenciesRequirementsRel> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<RotationCompetenciesRequirementsRel>
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

		List<RotationCompetenciesRequirementsRel> list = null;

		if (useFinderCache) {
			list =
				(List<RotationCompetenciesRequirementsRel>)
					finderCache.getResult(finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (RotationCompetenciesRequirementsRel
						rotationCompetenciesRequirementsRel : list) {

					if (!uuid.equals(
							rotationCompetenciesRequirementsRel.getUuid()) ||
						(companyId !=
							rotationCompetenciesRequirementsRel.
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

			sb.append(_SQL_SELECT_ROTATIONCOMPETENCIESREQUIREMENTSREL_WHERE);

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
					RotationCompetenciesRequirementsRelModelImpl.ORDER_BY_JPQL);
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
					(List<RotationCompetenciesRequirementsRel>)QueryUtil.list(
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
	 * Returns the first rotation competencies requirements rel in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching rotation competencies requirements rel
	 * @throws NoSuchRotationCompetenciesRequirementsRelException if a matching rotation competencies requirements rel could not be found
	 */
	@Override
	public RotationCompetenciesRequirementsRel findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<RotationCompetenciesRequirementsRel>
				orderByComparator)
		throws NoSuchRotationCompetenciesRequirementsRelException {

		RotationCompetenciesRequirementsRel
			rotationCompetenciesRequirementsRel = fetchByUuid_C_First(
				uuid, companyId, orderByComparator);

		if (rotationCompetenciesRequirementsRel != null) {
			return rotationCompetenciesRequirementsRel;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append(", companyId=");
		sb.append(companyId);

		sb.append("}");

		throw new NoSuchRotationCompetenciesRequirementsRelException(
			sb.toString());
	}

	/**
	 * Returns the first rotation competencies requirements rel in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching rotation competencies requirements rel, or <code>null</code> if a matching rotation competencies requirements rel could not be found
	 */
	@Override
	public RotationCompetenciesRequirementsRel fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<RotationCompetenciesRequirementsRel>
			orderByComparator) {

		List<RotationCompetenciesRequirementsRel> list = findByUuid_C(
			uuid, companyId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last rotation competencies requirements rel in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching rotation competencies requirements rel
	 * @throws NoSuchRotationCompetenciesRequirementsRelException if a matching rotation competencies requirements rel could not be found
	 */
	@Override
	public RotationCompetenciesRequirementsRel findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<RotationCompetenciesRequirementsRel>
				orderByComparator)
		throws NoSuchRotationCompetenciesRequirementsRelException {

		RotationCompetenciesRequirementsRel
			rotationCompetenciesRequirementsRel = fetchByUuid_C_Last(
				uuid, companyId, orderByComparator);

		if (rotationCompetenciesRequirementsRel != null) {
			return rotationCompetenciesRequirementsRel;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append(", companyId=");
		sb.append(companyId);

		sb.append("}");

		throw new NoSuchRotationCompetenciesRequirementsRelException(
			sb.toString());
	}

	/**
	 * Returns the last rotation competencies requirements rel in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching rotation competencies requirements rel, or <code>null</code> if a matching rotation competencies requirements rel could not be found
	 */
	@Override
	public RotationCompetenciesRequirementsRel fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<RotationCompetenciesRequirementsRel>
			orderByComparator) {

		int count = countByUuid_C(uuid, companyId);

		if (count == 0) {
			return null;
		}

		List<RotationCompetenciesRequirementsRel> list = findByUuid_C(
			uuid, companyId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the rotation competencies requirements rels before and after the current rotation competencies requirements rel in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param rotationCompetenciesRelId the primary key of the current rotation competencies requirements rel
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next rotation competencies requirements rel
	 * @throws NoSuchRotationCompetenciesRequirementsRelException if a rotation competencies requirements rel with the primary key could not be found
	 */
	@Override
	public RotationCompetenciesRequirementsRel[] findByUuid_C_PrevAndNext(
			long rotationCompetenciesRelId, String uuid, long companyId,
			OrderByComparator<RotationCompetenciesRequirementsRel>
				orderByComparator)
		throws NoSuchRotationCompetenciesRequirementsRelException {

		uuid = Objects.toString(uuid, "");

		RotationCompetenciesRequirementsRel
			rotationCompetenciesRequirementsRel = findByPrimaryKey(
				rotationCompetenciesRelId);

		Session session = null;

		try {
			session = openSession();

			RotationCompetenciesRequirementsRel[] array =
				new RotationCompetenciesRequirementsRelImpl[3];

			array[0] = getByUuid_C_PrevAndNext(
				session, rotationCompetenciesRequirementsRel, uuid, companyId,
				orderByComparator, true);

			array[1] = rotationCompetenciesRequirementsRel;

			array[2] = getByUuid_C_PrevAndNext(
				session, rotationCompetenciesRequirementsRel, uuid, companyId,
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

	protected RotationCompetenciesRequirementsRel getByUuid_C_PrevAndNext(
		Session session,
		RotationCompetenciesRequirementsRel rotationCompetenciesRequirementsRel,
		String uuid, long companyId,
		OrderByComparator<RotationCompetenciesRequirementsRel>
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

		sb.append(_SQL_SELECT_ROTATIONCOMPETENCIESREQUIREMENTSREL_WHERE);

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
				RotationCompetenciesRequirementsRelModelImpl.ORDER_BY_JPQL);
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
						rotationCompetenciesRequirementsRel)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<RotationCompetenciesRequirementsRel> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the rotation competencies requirements rels where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	@Override
	public void removeByUuid_C(String uuid, long companyId) {
		for (RotationCompetenciesRequirementsRel
				rotationCompetenciesRequirementsRel :
					findByUuid_C(
						uuid, companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
						null)) {

			remove(rotationCompetenciesRequirementsRel);
		}
	}

	/**
	 * Returns the number of rotation competencies requirements rels where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching rotation competencies requirements rels
	 */
	@Override
	public int countByUuid_C(String uuid, long companyId) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid_C;

		Object[] finderArgs = new Object[] {uuid, companyId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_ROTATIONCOMPETENCIESREQUIREMENTSREL_WHERE);

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
		"rotationCompetenciesRequirementsRel.uuid = ? AND ";

	private static final String _FINDER_COLUMN_UUID_C_UUID_3 =
		"(rotationCompetenciesRequirementsRel.uuid IS NULL OR rotationCompetenciesRequirementsRel.uuid = '') AND ";

	private static final String _FINDER_COLUMN_UUID_C_COMPANYID_2 =
		"rotationCompetenciesRequirementsRel.companyId = ?";

	private FinderPath
		_finderPathWithPaginationFindByRotationIdAndProgramDurationId;
	private FinderPath
		_finderPathWithoutPaginationFindByRotationIdAndProgramDurationId;
	private FinderPath _finderPathCountByRotationIdAndProgramDurationId;

	/**
	 * Returns all the rotation competencies requirements rels where rotationId = &#63; and progDurationId = &#63;.
	 *
	 * @param rotationId the rotation ID
	 * @param progDurationId the prog duration ID
	 * @return the matching rotation competencies requirements rels
	 */
	@Override
	public List<RotationCompetenciesRequirementsRel>
		findByRotationIdAndProgramDurationId(
			long rotationId, long progDurationId) {

		return findByRotationIdAndProgramDurationId(
			rotationId, progDurationId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
	}

	/**
	 * Returns a range of all the rotation competencies requirements rels where rotationId = &#63; and progDurationId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RotationCompetenciesRequirementsRelModelImpl</code>.
	 * </p>
	 *
	 * @param rotationId the rotation ID
	 * @param progDurationId the prog duration ID
	 * @param start the lower bound of the range of rotation competencies requirements rels
	 * @param end the upper bound of the range of rotation competencies requirements rels (not inclusive)
	 * @return the range of matching rotation competencies requirements rels
	 */
	@Override
	public List<RotationCompetenciesRequirementsRel>
		findByRotationIdAndProgramDurationId(
			long rotationId, long progDurationId, int start, int end) {

		return findByRotationIdAndProgramDurationId(
			rotationId, progDurationId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the rotation competencies requirements rels where rotationId = &#63; and progDurationId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RotationCompetenciesRequirementsRelModelImpl</code>.
	 * </p>
	 *
	 * @param rotationId the rotation ID
	 * @param progDurationId the prog duration ID
	 * @param start the lower bound of the range of rotation competencies requirements rels
	 * @param end the upper bound of the range of rotation competencies requirements rels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching rotation competencies requirements rels
	 */
	@Override
	public List<RotationCompetenciesRequirementsRel>
		findByRotationIdAndProgramDurationId(
			long rotationId, long progDurationId, int start, int end,
			OrderByComparator<RotationCompetenciesRequirementsRel>
				orderByComparator) {

		return findByRotationIdAndProgramDurationId(
			rotationId, progDurationId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the rotation competencies requirements rels where rotationId = &#63; and progDurationId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RotationCompetenciesRequirementsRelModelImpl</code>.
	 * </p>
	 *
	 * @param rotationId the rotation ID
	 * @param progDurationId the prog duration ID
	 * @param start the lower bound of the range of rotation competencies requirements rels
	 * @param end the upper bound of the range of rotation competencies requirements rels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching rotation competencies requirements rels
	 */
	@Override
	public List<RotationCompetenciesRequirementsRel>
		findByRotationIdAndProgramDurationId(
			long rotationId, long progDurationId, int start, int end,
			OrderByComparator<RotationCompetenciesRequirementsRel>
				orderByComparator,
			boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath =
					_finderPathWithoutPaginationFindByRotationIdAndProgramDurationId;
				finderArgs = new Object[] {rotationId, progDurationId};
			}
		}
		else if (useFinderCache) {
			finderPath =
				_finderPathWithPaginationFindByRotationIdAndProgramDurationId;
			finderArgs = new Object[] {
				rotationId, progDurationId, start, end, orderByComparator
			};
		}

		List<RotationCompetenciesRequirementsRel> list = null;

		if (useFinderCache) {
			list =
				(List<RotationCompetenciesRequirementsRel>)
					finderCache.getResult(finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (RotationCompetenciesRequirementsRel
						rotationCompetenciesRequirementsRel : list) {

					if ((rotationId !=
							rotationCompetenciesRequirementsRel.
								getRotationId()) ||
						(progDurationId !=
							rotationCompetenciesRequirementsRel.
								getProgDurationId())) {

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

			sb.append(_SQL_SELECT_ROTATIONCOMPETENCIESREQUIREMENTSREL_WHERE);

			sb.append(
				_FINDER_COLUMN_ROTATIONIDANDPROGRAMDURATIONID_ROTATIONID_2);

			sb.append(
				_FINDER_COLUMN_ROTATIONIDANDPROGRAMDURATIONID_PROGDURATIONID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(
					RotationCompetenciesRequirementsRelModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(rotationId);

				queryPos.add(progDurationId);

				list =
					(List<RotationCompetenciesRequirementsRel>)QueryUtil.list(
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
	 * Returns the first rotation competencies requirements rel in the ordered set where rotationId = &#63; and progDurationId = &#63;.
	 *
	 * @param rotationId the rotation ID
	 * @param progDurationId the prog duration ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching rotation competencies requirements rel
	 * @throws NoSuchRotationCompetenciesRequirementsRelException if a matching rotation competencies requirements rel could not be found
	 */
	@Override
	public RotationCompetenciesRequirementsRel
			findByRotationIdAndProgramDurationId_First(
				long rotationId, long progDurationId,
				OrderByComparator<RotationCompetenciesRequirementsRel>
					orderByComparator)
		throws NoSuchRotationCompetenciesRequirementsRelException {

		RotationCompetenciesRequirementsRel
			rotationCompetenciesRequirementsRel =
				fetchByRotationIdAndProgramDurationId_First(
					rotationId, progDurationId, orderByComparator);

		if (rotationCompetenciesRequirementsRel != null) {
			return rotationCompetenciesRequirementsRel;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("rotationId=");
		sb.append(rotationId);

		sb.append(", progDurationId=");
		sb.append(progDurationId);

		sb.append("}");

		throw new NoSuchRotationCompetenciesRequirementsRelException(
			sb.toString());
	}

	/**
	 * Returns the first rotation competencies requirements rel in the ordered set where rotationId = &#63; and progDurationId = &#63;.
	 *
	 * @param rotationId the rotation ID
	 * @param progDurationId the prog duration ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching rotation competencies requirements rel, or <code>null</code> if a matching rotation competencies requirements rel could not be found
	 */
	@Override
	public RotationCompetenciesRequirementsRel
		fetchByRotationIdAndProgramDurationId_First(
			long rotationId, long progDurationId,
			OrderByComparator<RotationCompetenciesRequirementsRel>
				orderByComparator) {

		List<RotationCompetenciesRequirementsRel> list =
			findByRotationIdAndProgramDurationId(
				rotationId, progDurationId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last rotation competencies requirements rel in the ordered set where rotationId = &#63; and progDurationId = &#63;.
	 *
	 * @param rotationId the rotation ID
	 * @param progDurationId the prog duration ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching rotation competencies requirements rel
	 * @throws NoSuchRotationCompetenciesRequirementsRelException if a matching rotation competencies requirements rel could not be found
	 */
	@Override
	public RotationCompetenciesRequirementsRel
			findByRotationIdAndProgramDurationId_Last(
				long rotationId, long progDurationId,
				OrderByComparator<RotationCompetenciesRequirementsRel>
					orderByComparator)
		throws NoSuchRotationCompetenciesRequirementsRelException {

		RotationCompetenciesRequirementsRel
			rotationCompetenciesRequirementsRel =
				fetchByRotationIdAndProgramDurationId_Last(
					rotationId, progDurationId, orderByComparator);

		if (rotationCompetenciesRequirementsRel != null) {
			return rotationCompetenciesRequirementsRel;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("rotationId=");
		sb.append(rotationId);

		sb.append(", progDurationId=");
		sb.append(progDurationId);

		sb.append("}");

		throw new NoSuchRotationCompetenciesRequirementsRelException(
			sb.toString());
	}

	/**
	 * Returns the last rotation competencies requirements rel in the ordered set where rotationId = &#63; and progDurationId = &#63;.
	 *
	 * @param rotationId the rotation ID
	 * @param progDurationId the prog duration ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching rotation competencies requirements rel, or <code>null</code> if a matching rotation competencies requirements rel could not be found
	 */
	@Override
	public RotationCompetenciesRequirementsRel
		fetchByRotationIdAndProgramDurationId_Last(
			long rotationId, long progDurationId,
			OrderByComparator<RotationCompetenciesRequirementsRel>
				orderByComparator) {

		int count = countByRotationIdAndProgramDurationId(
			rotationId, progDurationId);

		if (count == 0) {
			return null;
		}

		List<RotationCompetenciesRequirementsRel> list =
			findByRotationIdAndProgramDurationId(
				rotationId, progDurationId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the rotation competencies requirements rels before and after the current rotation competencies requirements rel in the ordered set where rotationId = &#63; and progDurationId = &#63;.
	 *
	 * @param rotationCompetenciesRelId the primary key of the current rotation competencies requirements rel
	 * @param rotationId the rotation ID
	 * @param progDurationId the prog duration ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next rotation competencies requirements rel
	 * @throws NoSuchRotationCompetenciesRequirementsRelException if a rotation competencies requirements rel with the primary key could not be found
	 */
	@Override
	public RotationCompetenciesRequirementsRel[]
			findByRotationIdAndProgramDurationId_PrevAndNext(
				long rotationCompetenciesRelId, long rotationId,
				long progDurationId,
				OrderByComparator<RotationCompetenciesRequirementsRel>
					orderByComparator)
		throws NoSuchRotationCompetenciesRequirementsRelException {

		RotationCompetenciesRequirementsRel
			rotationCompetenciesRequirementsRel = findByPrimaryKey(
				rotationCompetenciesRelId);

		Session session = null;

		try {
			session = openSession();

			RotationCompetenciesRequirementsRel[] array =
				new RotationCompetenciesRequirementsRelImpl[3];

			array[0] = getByRotationIdAndProgramDurationId_PrevAndNext(
				session, rotationCompetenciesRequirementsRel, rotationId,
				progDurationId, orderByComparator, true);

			array[1] = rotationCompetenciesRequirementsRel;

			array[2] = getByRotationIdAndProgramDurationId_PrevAndNext(
				session, rotationCompetenciesRequirementsRel, rotationId,
				progDurationId, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected RotationCompetenciesRequirementsRel
		getByRotationIdAndProgramDurationId_PrevAndNext(
			Session session,
			RotationCompetenciesRequirementsRel
				rotationCompetenciesRequirementsRel,
			long rotationId, long progDurationId,
			OrderByComparator<RotationCompetenciesRequirementsRel>
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

		sb.append(_SQL_SELECT_ROTATIONCOMPETENCIESREQUIREMENTSREL_WHERE);

		sb.append(_FINDER_COLUMN_ROTATIONIDANDPROGRAMDURATIONID_ROTATIONID_2);

		sb.append(
			_FINDER_COLUMN_ROTATIONIDANDPROGRAMDURATIONID_PROGDURATIONID_2);

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
				RotationCompetenciesRequirementsRelModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(rotationId);

		queryPos.add(progDurationId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						rotationCompetenciesRequirementsRel)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<RotationCompetenciesRequirementsRel> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the rotation competencies requirements rels where rotationId = &#63; and progDurationId = &#63; from the database.
	 *
	 * @param rotationId the rotation ID
	 * @param progDurationId the prog duration ID
	 */
	@Override
	public void removeByRotationIdAndProgramDurationId(
		long rotationId, long progDurationId) {

		for (RotationCompetenciesRequirementsRel
				rotationCompetenciesRequirementsRel :
					findByRotationIdAndProgramDurationId(
						rotationId, progDurationId, QueryUtil.ALL_POS,
						QueryUtil.ALL_POS, null)) {

			remove(rotationCompetenciesRequirementsRel);
		}
	}

	/**
	 * Returns the number of rotation competencies requirements rels where rotationId = &#63; and progDurationId = &#63;.
	 *
	 * @param rotationId the rotation ID
	 * @param progDurationId the prog duration ID
	 * @return the number of matching rotation competencies requirements rels
	 */
	@Override
	public int countByRotationIdAndProgramDurationId(
		long rotationId, long progDurationId) {

		FinderPath finderPath =
			_finderPathCountByRotationIdAndProgramDurationId;

		Object[] finderArgs = new Object[] {rotationId, progDurationId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_ROTATIONCOMPETENCIESREQUIREMENTSREL_WHERE);

			sb.append(
				_FINDER_COLUMN_ROTATIONIDANDPROGRAMDURATIONID_ROTATIONID_2);

			sb.append(
				_FINDER_COLUMN_ROTATIONIDANDPROGRAMDURATIONID_PROGDURATIONID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(rotationId);

				queryPos.add(progDurationId);

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
		_FINDER_COLUMN_ROTATIONIDANDPROGRAMDURATIONID_ROTATIONID_2 =
			"rotationCompetenciesRequirementsRel.rotationId = ? AND ";

	private static final String
		_FINDER_COLUMN_ROTATIONIDANDPROGRAMDURATIONID_PROGDURATIONID_2 =
			"rotationCompetenciesRequirementsRel.progDurationId = ?";

	public RotationCompetenciesRequirementsRelPersistenceImpl() {
		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("uuid", "uuid_");
		dbColumnNames.put(
			"rotationCompetenciesRelId", "rotation_competencies_rel_id");
		dbColumnNames.put("progDurationId", "prog_duration_id");
		dbColumnNames.put("rotationId", "rotation_id");
		dbColumnNames.put("competenciesMasterId", "competencies_master_id");
		dbColumnNames.put("groupId", "group_id");
		dbColumnNames.put("companyId", "company_id");
		dbColumnNames.put("createDate", "create_date");
		dbColumnNames.put("modifiedDate", "modified_date");

		setDBColumnNames(dbColumnNames);

		setModelClass(RotationCompetenciesRequirementsRel.class);

		setModelImplClass(RotationCompetenciesRequirementsRelImpl.class);
		setModelPKClass(long.class);

		setTable(RotationCompetenciesRequirementsRelTable.INSTANCE);
	}

	/**
	 * Caches the rotation competencies requirements rel in the entity cache if it is enabled.
	 *
	 * @param rotationCompetenciesRequirementsRel the rotation competencies requirements rel
	 */
	@Override
	public void cacheResult(
		RotationCompetenciesRequirementsRel
			rotationCompetenciesRequirementsRel) {

		entityCache.putResult(
			RotationCompetenciesRequirementsRelImpl.class,
			rotationCompetenciesRequirementsRel.getPrimaryKey(),
			rotationCompetenciesRequirementsRel);

		finderCache.putResult(
			_finderPathFetchByUUID_G,
			new Object[] {
				rotationCompetenciesRequirementsRel.getUuid(),
				rotationCompetenciesRequirementsRel.getGroupId()
			},
			rotationCompetenciesRequirementsRel);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the rotation competencies requirements rels in the entity cache if it is enabled.
	 *
	 * @param rotationCompetenciesRequirementsRels the rotation competencies requirements rels
	 */
	@Override
	public void cacheResult(
		List<RotationCompetenciesRequirementsRel>
			rotationCompetenciesRequirementsRels) {

		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (rotationCompetenciesRequirementsRels.size() >
				 _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (RotationCompetenciesRequirementsRel
				rotationCompetenciesRequirementsRel :
					rotationCompetenciesRequirementsRels) {

			if (entityCache.getResult(
					RotationCompetenciesRequirementsRelImpl.class,
					rotationCompetenciesRequirementsRel.getPrimaryKey()) ==
						null) {

				cacheResult(rotationCompetenciesRequirementsRel);
			}
		}
	}

	/**
	 * Clears the cache for all rotation competencies requirements rels.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(RotationCompetenciesRequirementsRelImpl.class);

		finderCache.clearCache(RotationCompetenciesRequirementsRelImpl.class);
	}

	/**
	 * Clears the cache for the rotation competencies requirements rel.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(
		RotationCompetenciesRequirementsRel
			rotationCompetenciesRequirementsRel) {

		entityCache.removeResult(
			RotationCompetenciesRequirementsRelImpl.class,
			rotationCompetenciesRequirementsRel);
	}

	@Override
	public void clearCache(
		List<RotationCompetenciesRequirementsRel>
			rotationCompetenciesRequirementsRels) {

		for (RotationCompetenciesRequirementsRel
				rotationCompetenciesRequirementsRel :
					rotationCompetenciesRequirementsRels) {

			entityCache.removeResult(
				RotationCompetenciesRequirementsRelImpl.class,
				rotationCompetenciesRequirementsRel);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(RotationCompetenciesRequirementsRelImpl.class);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(
				RotationCompetenciesRequirementsRelImpl.class, primaryKey);
		}
	}

	protected void cacheUniqueFindersCache(
		RotationCompetenciesRequirementsRelModelImpl
			rotationCompetenciesRequirementsRelModelImpl) {

		Object[] args = new Object[] {
			rotationCompetenciesRequirementsRelModelImpl.getUuid(),
			rotationCompetenciesRequirementsRelModelImpl.getGroupId()
		};

		finderCache.putResult(_finderPathCountByUUID_G, args, Long.valueOf(1));
		finderCache.putResult(
			_finderPathFetchByUUID_G, args,
			rotationCompetenciesRequirementsRelModelImpl);
	}

	/**
	 * Creates a new rotation competencies requirements rel with the primary key. Does not add the rotation competencies requirements rel to the database.
	 *
	 * @param rotationCompetenciesRelId the primary key for the new rotation competencies requirements rel
	 * @return the new rotation competencies requirements rel
	 */
	@Override
	public RotationCompetenciesRequirementsRel create(
		long rotationCompetenciesRelId) {

		RotationCompetenciesRequirementsRel
			rotationCompetenciesRequirementsRel =
				new RotationCompetenciesRequirementsRelImpl();

		rotationCompetenciesRequirementsRel.setNew(true);
		rotationCompetenciesRequirementsRel.setPrimaryKey(
			rotationCompetenciesRelId);

		String uuid = _portalUUID.generate();

		rotationCompetenciesRequirementsRel.setUuid(uuid);

		rotationCompetenciesRequirementsRel.setCompanyId(
			CompanyThreadLocal.getCompanyId());

		return rotationCompetenciesRequirementsRel;
	}

	/**
	 * Removes the rotation competencies requirements rel with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param rotationCompetenciesRelId the primary key of the rotation competencies requirements rel
	 * @return the rotation competencies requirements rel that was removed
	 * @throws NoSuchRotationCompetenciesRequirementsRelException if a rotation competencies requirements rel with the primary key could not be found
	 */
	@Override
	public RotationCompetenciesRequirementsRel remove(
			long rotationCompetenciesRelId)
		throws NoSuchRotationCompetenciesRequirementsRelException {

		return remove((Serializable)rotationCompetenciesRelId);
	}

	/**
	 * Removes the rotation competencies requirements rel with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the rotation competencies requirements rel
	 * @return the rotation competencies requirements rel that was removed
	 * @throws NoSuchRotationCompetenciesRequirementsRelException if a rotation competencies requirements rel with the primary key could not be found
	 */
	@Override
	public RotationCompetenciesRequirementsRel remove(Serializable primaryKey)
		throws NoSuchRotationCompetenciesRequirementsRelException {

		Session session = null;

		try {
			session = openSession();

			RotationCompetenciesRequirementsRel
				rotationCompetenciesRequirementsRel =
					(RotationCompetenciesRequirementsRel)session.get(
						RotationCompetenciesRequirementsRelImpl.class,
						primaryKey);

			if (rotationCompetenciesRequirementsRel == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchRotationCompetenciesRequirementsRelException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(rotationCompetenciesRequirementsRel);
		}
		catch (NoSuchRotationCompetenciesRequirementsRelException
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
	protected RotationCompetenciesRequirementsRel removeImpl(
		RotationCompetenciesRequirementsRel
			rotationCompetenciesRequirementsRel) {

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(rotationCompetenciesRequirementsRel)) {
				rotationCompetenciesRequirementsRel =
					(RotationCompetenciesRequirementsRel)session.get(
						RotationCompetenciesRequirementsRelImpl.class,
						rotationCompetenciesRequirementsRel.getPrimaryKeyObj());
			}

			if (rotationCompetenciesRequirementsRel != null) {
				session.delete(rotationCompetenciesRequirementsRel);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (rotationCompetenciesRequirementsRel != null) {
			clearCache(rotationCompetenciesRequirementsRel);
		}

		return rotationCompetenciesRequirementsRel;
	}

	@Override
	public RotationCompetenciesRequirementsRel updateImpl(
		RotationCompetenciesRequirementsRel
			rotationCompetenciesRequirementsRel) {

		boolean isNew = rotationCompetenciesRequirementsRel.isNew();

		if (!(rotationCompetenciesRequirementsRel instanceof
				RotationCompetenciesRequirementsRelModelImpl)) {

			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(
					rotationCompetenciesRequirementsRel.getClass())) {

				invocationHandler = ProxyUtil.getInvocationHandler(
					rotationCompetenciesRequirementsRel);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in rotationCompetenciesRequirementsRel proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom RotationCompetenciesRequirementsRel implementation " +
					rotationCompetenciesRequirementsRel.getClass());
		}

		RotationCompetenciesRequirementsRelModelImpl
			rotationCompetenciesRequirementsRelModelImpl =
				(RotationCompetenciesRequirementsRelModelImpl)
					rotationCompetenciesRequirementsRel;

		if (Validator.isNull(rotationCompetenciesRequirementsRel.getUuid())) {
			String uuid = _portalUUID.generate();

			rotationCompetenciesRequirementsRel.setUuid(uuid);
		}

		ServiceContext serviceContext =
			ServiceContextThreadLocal.getServiceContext();

		Date date = new Date();

		if (isNew &&
			(rotationCompetenciesRequirementsRel.getCreateDate() == null)) {

			if (serviceContext == null) {
				rotationCompetenciesRequirementsRel.setCreateDate(date);
			}
			else {
				rotationCompetenciesRequirementsRel.setCreateDate(
					serviceContext.getCreateDate(date));
			}
		}

		if (!rotationCompetenciesRequirementsRelModelImpl.
				hasSetModifiedDate()) {

			if (serviceContext == null) {
				rotationCompetenciesRequirementsRel.setModifiedDate(date);
			}
			else {
				rotationCompetenciesRequirementsRel.setModifiedDate(
					serviceContext.getModifiedDate(date));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(rotationCompetenciesRequirementsRel);
			}
			else {
				rotationCompetenciesRequirementsRel =
					(RotationCompetenciesRequirementsRel)session.merge(
						rotationCompetenciesRequirementsRel);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(
			RotationCompetenciesRequirementsRelImpl.class,
			rotationCompetenciesRequirementsRelModelImpl, false, true);

		cacheUniqueFindersCache(rotationCompetenciesRequirementsRelModelImpl);

		if (isNew) {
			rotationCompetenciesRequirementsRel.setNew(false);
		}

		rotationCompetenciesRequirementsRel.resetOriginalValues();

		return rotationCompetenciesRequirementsRel;
	}

	/**
	 * Returns the rotation competencies requirements rel with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the rotation competencies requirements rel
	 * @return the rotation competencies requirements rel
	 * @throws NoSuchRotationCompetenciesRequirementsRelException if a rotation competencies requirements rel with the primary key could not be found
	 */
	@Override
	public RotationCompetenciesRequirementsRel findByPrimaryKey(
			Serializable primaryKey)
		throws NoSuchRotationCompetenciesRequirementsRelException {

		RotationCompetenciesRequirementsRel
			rotationCompetenciesRequirementsRel = fetchByPrimaryKey(primaryKey);

		if (rotationCompetenciesRequirementsRel == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchRotationCompetenciesRequirementsRelException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return rotationCompetenciesRequirementsRel;
	}

	/**
	 * Returns the rotation competencies requirements rel with the primary key or throws a <code>NoSuchRotationCompetenciesRequirementsRelException</code> if it could not be found.
	 *
	 * @param rotationCompetenciesRelId the primary key of the rotation competencies requirements rel
	 * @return the rotation competencies requirements rel
	 * @throws NoSuchRotationCompetenciesRequirementsRelException if a rotation competencies requirements rel with the primary key could not be found
	 */
	@Override
	public RotationCompetenciesRequirementsRel findByPrimaryKey(
			long rotationCompetenciesRelId)
		throws NoSuchRotationCompetenciesRequirementsRelException {

		return findByPrimaryKey((Serializable)rotationCompetenciesRelId);
	}

	/**
	 * Returns the rotation competencies requirements rel with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param rotationCompetenciesRelId the primary key of the rotation competencies requirements rel
	 * @return the rotation competencies requirements rel, or <code>null</code> if a rotation competencies requirements rel with the primary key could not be found
	 */
	@Override
	public RotationCompetenciesRequirementsRel fetchByPrimaryKey(
		long rotationCompetenciesRelId) {

		return fetchByPrimaryKey((Serializable)rotationCompetenciesRelId);
	}

	/**
	 * Returns all the rotation competencies requirements rels.
	 *
	 * @return the rotation competencies requirements rels
	 */
	@Override
	public List<RotationCompetenciesRequirementsRel> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the rotation competencies requirements rels.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RotationCompetenciesRequirementsRelModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of rotation competencies requirements rels
	 * @param end the upper bound of the range of rotation competencies requirements rels (not inclusive)
	 * @return the range of rotation competencies requirements rels
	 */
	@Override
	public List<RotationCompetenciesRequirementsRel> findAll(
		int start, int end) {

		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the rotation competencies requirements rels.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RotationCompetenciesRequirementsRelModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of rotation competencies requirements rels
	 * @param end the upper bound of the range of rotation competencies requirements rels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of rotation competencies requirements rels
	 */
	@Override
	public List<RotationCompetenciesRequirementsRel> findAll(
		int start, int end,
		OrderByComparator<RotationCompetenciesRequirementsRel>
			orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the rotation competencies requirements rels.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RotationCompetenciesRequirementsRelModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of rotation competencies requirements rels
	 * @param end the upper bound of the range of rotation competencies requirements rels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of rotation competencies requirements rels
	 */
	@Override
	public List<RotationCompetenciesRequirementsRel> findAll(
		int start, int end,
		OrderByComparator<RotationCompetenciesRequirementsRel>
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

		List<RotationCompetenciesRequirementsRel> list = null;

		if (useFinderCache) {
			list =
				(List<RotationCompetenciesRequirementsRel>)
					finderCache.getResult(finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_ROTATIONCOMPETENCIESREQUIREMENTSREL);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_ROTATIONCOMPETENCIESREQUIREMENTSREL;

				sql = sql.concat(
					RotationCompetenciesRequirementsRelModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list =
					(List<RotationCompetenciesRequirementsRel>)QueryUtil.list(
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
	 * Removes all the rotation competencies requirements rels from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (RotationCompetenciesRequirementsRel
				rotationCompetenciesRequirementsRel : findAll()) {

			remove(rotationCompetenciesRequirementsRel);
		}
	}

	/**
	 * Returns the number of rotation competencies requirements rels.
	 *
	 * @return the number of rotation competencies requirements rels
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
					_SQL_COUNT_ROTATIONCOMPETENCIESREQUIREMENTSREL);

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
		return "rotation_competencies_rel_id";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_ROTATIONCOMPETENCIESREQUIREMENTSREL;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return RotationCompetenciesRequirementsRelModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the rotation competencies requirements rel persistence.
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

		_finderPathWithPaginationFindByRotationIdAndProgramDurationId =
			new FinderPath(
				FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
				"findByRotationIdAndProgramDurationId",
				new String[] {
					Long.class.getName(), Long.class.getName(),
					Integer.class.getName(), Integer.class.getName(),
					OrderByComparator.class.getName()
				},
				new String[] {"rotation_id", "prog_duration_id"}, true);

		_finderPathWithoutPaginationFindByRotationIdAndProgramDurationId =
			new FinderPath(
				FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
				"findByRotationIdAndProgramDurationId",
				new String[] {Long.class.getName(), Long.class.getName()},
				new String[] {"rotation_id", "prog_duration_id"}, true);

		_finderPathCountByRotationIdAndProgramDurationId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByRotationIdAndProgramDurationId",
			new String[] {Long.class.getName(), Long.class.getName()},
			new String[] {"rotation_id", "prog_duration_id"}, false);

		_setRotationCompetenciesRequirementsRelUtilPersistence(this);
	}

	@Deactivate
	public void deactivate() {
		_setRotationCompetenciesRequirementsRelUtilPersistence(null);

		entityCache.removeCache(
			RotationCompetenciesRequirementsRelImpl.class.getName());
	}

	private void _setRotationCompetenciesRequirementsRelUtilPersistence(
		RotationCompetenciesRequirementsRelPersistence
			rotationCompetenciesRequirementsRelPersistence) {

		try {
			Field field =
				RotationCompetenciesRequirementsRelUtil.class.getDeclaredField(
					"_persistence");

			field.setAccessible(true);

			field.set(null, rotationCompetenciesRequirementsRelPersistence);
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
		_SQL_SELECT_ROTATIONCOMPETENCIESREQUIREMENTSREL =
			"SELECT rotationCompetenciesRequirementsRel FROM RotationCompetenciesRequirementsRel rotationCompetenciesRequirementsRel";

	private static final String
		_SQL_SELECT_ROTATIONCOMPETENCIESREQUIREMENTSREL_WHERE =
			"SELECT rotationCompetenciesRequirementsRel FROM RotationCompetenciesRequirementsRel rotationCompetenciesRequirementsRel WHERE ";

	private static final String _SQL_COUNT_ROTATIONCOMPETENCIESREQUIREMENTSREL =
		"SELECT COUNT(rotationCompetenciesRequirementsRel) FROM RotationCompetenciesRequirementsRel rotationCompetenciesRequirementsRel";

	private static final String
		_SQL_COUNT_ROTATIONCOMPETENCIESREQUIREMENTSREL_WHERE =
			"SELECT COUNT(rotationCompetenciesRequirementsRel) FROM RotationCompetenciesRequirementsRel rotationCompetenciesRequirementsRel WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS =
		"rotationCompetenciesRequirementsRel.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No RotationCompetenciesRequirementsRel exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No RotationCompetenciesRequirementsRel exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		RotationCompetenciesRequirementsRelPersistenceImpl.class);

	private static final Set<String> _badColumnNames = SetUtil.fromArray(
		new String[] {
			"uuid", "rotationCompetenciesRelId", "progDurationId", "rotationId",
			"competenciesMasterId", "groupId", "companyId", "createDate",
			"modifiedDate"
		});

	@Override
	protected FinderCache getFinderCache() {
		return finderCache;
	}

	@Reference
	private PortalUUID _portalUUID;

}
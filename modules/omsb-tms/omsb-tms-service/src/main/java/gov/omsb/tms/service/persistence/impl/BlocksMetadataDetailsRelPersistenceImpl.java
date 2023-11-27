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

import gov.omsb.tms.exception.NoSuchBlocksMetadataDetailsRelException;
import gov.omsb.tms.model.BlocksMetadataDetailsRel;
import gov.omsb.tms.model.BlocksMetadataDetailsRelTable;
import gov.omsb.tms.model.impl.BlocksMetadataDetailsRelImpl;
import gov.omsb.tms.model.impl.BlocksMetadataDetailsRelModelImpl;
import gov.omsb.tms.service.persistence.BlocksMetadataDetailsRelPersistence;
import gov.omsb.tms.service.persistence.BlocksMetadataDetailsRelUtil;
import gov.omsb.tms.service.persistence.impl.constants.OMSBTMSPersistenceConstants;

import java.io.Serializable;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;

import java.sql.Timestamp;

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
 * The persistence implementation for the blocks metadata details rel service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = BlocksMetadataDetailsRelPersistence.class)
public class BlocksMetadataDetailsRelPersistenceImpl
	extends BasePersistenceImpl<BlocksMetadataDetailsRel>
	implements BlocksMetadataDetailsRelPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>BlocksMetadataDetailsRelUtil</code> to access the blocks metadata details rel persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		BlocksMetadataDetailsRelImpl.class.getName();

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
	 * Returns all the blocks metadata details rels where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching blocks metadata details rels
	 */
	@Override
	public List<BlocksMetadataDetailsRel> findByUuid(String uuid) {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the blocks metadata details rels where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>BlocksMetadataDetailsRelModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of blocks metadata details rels
	 * @param end the upper bound of the range of blocks metadata details rels (not inclusive)
	 * @return the range of matching blocks metadata details rels
	 */
	@Override
	public List<BlocksMetadataDetailsRel> findByUuid(
		String uuid, int start, int end) {

		return findByUuid(uuid, start, end, null);
	}

	/**
	 * Returns an ordered range of all the blocks metadata details rels where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>BlocksMetadataDetailsRelModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of blocks metadata details rels
	 * @param end the upper bound of the range of blocks metadata details rels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching blocks metadata details rels
	 */
	@Override
	public List<BlocksMetadataDetailsRel> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<BlocksMetadataDetailsRel> orderByComparator) {

		return findByUuid(uuid, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the blocks metadata details rels where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>BlocksMetadataDetailsRelModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of blocks metadata details rels
	 * @param end the upper bound of the range of blocks metadata details rels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching blocks metadata details rels
	 */
	@Override
	public List<BlocksMetadataDetailsRel> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<BlocksMetadataDetailsRel> orderByComparator,
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

		List<BlocksMetadataDetailsRel> list = null;

		if (useFinderCache) {
			list = (List<BlocksMetadataDetailsRel>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (BlocksMetadataDetailsRel blocksMetadataDetailsRel : list) {
					if (!uuid.equals(blocksMetadataDetailsRel.getUuid())) {
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

			sb.append(_SQL_SELECT_BLOCKSMETADATADETAILSREL_WHERE);

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
				sb.append(BlocksMetadataDetailsRelModelImpl.ORDER_BY_JPQL);
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

				list = (List<BlocksMetadataDetailsRel>)QueryUtil.list(
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
	 * Returns the first blocks metadata details rel in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching blocks metadata details rel
	 * @throws NoSuchBlocksMetadataDetailsRelException if a matching blocks metadata details rel could not be found
	 */
	@Override
	public BlocksMetadataDetailsRel findByUuid_First(
			String uuid,
			OrderByComparator<BlocksMetadataDetailsRel> orderByComparator)
		throws NoSuchBlocksMetadataDetailsRelException {

		BlocksMetadataDetailsRel blocksMetadataDetailsRel = fetchByUuid_First(
			uuid, orderByComparator);

		if (blocksMetadataDetailsRel != null) {
			return blocksMetadataDetailsRel;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchBlocksMetadataDetailsRelException(sb.toString());
	}

	/**
	 * Returns the first blocks metadata details rel in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching blocks metadata details rel, or <code>null</code> if a matching blocks metadata details rel could not be found
	 */
	@Override
	public BlocksMetadataDetailsRel fetchByUuid_First(
		String uuid,
		OrderByComparator<BlocksMetadataDetailsRel> orderByComparator) {

		List<BlocksMetadataDetailsRel> list = findByUuid(
			uuid, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last blocks metadata details rel in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching blocks metadata details rel
	 * @throws NoSuchBlocksMetadataDetailsRelException if a matching blocks metadata details rel could not be found
	 */
	@Override
	public BlocksMetadataDetailsRel findByUuid_Last(
			String uuid,
			OrderByComparator<BlocksMetadataDetailsRel> orderByComparator)
		throws NoSuchBlocksMetadataDetailsRelException {

		BlocksMetadataDetailsRel blocksMetadataDetailsRel = fetchByUuid_Last(
			uuid, orderByComparator);

		if (blocksMetadataDetailsRel != null) {
			return blocksMetadataDetailsRel;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchBlocksMetadataDetailsRelException(sb.toString());
	}

	/**
	 * Returns the last blocks metadata details rel in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching blocks metadata details rel, or <code>null</code> if a matching blocks metadata details rel could not be found
	 */
	@Override
	public BlocksMetadataDetailsRel fetchByUuid_Last(
		String uuid,
		OrderByComparator<BlocksMetadataDetailsRel> orderByComparator) {

		int count = countByUuid(uuid);

		if (count == 0) {
			return null;
		}

		List<BlocksMetadataDetailsRel> list = findByUuid(
			uuid, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the blocks metadata details rels before and after the current blocks metadata details rel in the ordered set where uuid = &#63;.
	 *
	 * @param blocksMetadataDetailsRelId the primary key of the current blocks metadata details rel
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next blocks metadata details rel
	 * @throws NoSuchBlocksMetadataDetailsRelException if a blocks metadata details rel with the primary key could not be found
	 */
	@Override
	public BlocksMetadataDetailsRel[] findByUuid_PrevAndNext(
			long blocksMetadataDetailsRelId, String uuid,
			OrderByComparator<BlocksMetadataDetailsRel> orderByComparator)
		throws NoSuchBlocksMetadataDetailsRelException {

		uuid = Objects.toString(uuid, "");

		BlocksMetadataDetailsRel blocksMetadataDetailsRel = findByPrimaryKey(
			blocksMetadataDetailsRelId);

		Session session = null;

		try {
			session = openSession();

			BlocksMetadataDetailsRel[] array =
				new BlocksMetadataDetailsRelImpl[3];

			array[0] = getByUuid_PrevAndNext(
				session, blocksMetadataDetailsRel, uuid, orderByComparator,
				true);

			array[1] = blocksMetadataDetailsRel;

			array[2] = getByUuid_PrevAndNext(
				session, blocksMetadataDetailsRel, uuid, orderByComparator,
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

	protected BlocksMetadataDetailsRel getByUuid_PrevAndNext(
		Session session, BlocksMetadataDetailsRel blocksMetadataDetailsRel,
		String uuid,
		OrderByComparator<BlocksMetadataDetailsRel> orderByComparator,
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

		sb.append(_SQL_SELECT_BLOCKSMETADATADETAILSREL_WHERE);

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
			sb.append(BlocksMetadataDetailsRelModelImpl.ORDER_BY_JPQL);
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
						blocksMetadataDetailsRel)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<BlocksMetadataDetailsRel> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the blocks metadata details rels where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	@Override
	public void removeByUuid(String uuid) {
		for (BlocksMetadataDetailsRel blocksMetadataDetailsRel :
				findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(blocksMetadataDetailsRel);
		}
	}

	/**
	 * Returns the number of blocks metadata details rels where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching blocks metadata details rels
	 */
	@Override
	public int countByUuid(String uuid) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid;

		Object[] finderArgs = new Object[] {uuid};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_BLOCKSMETADATADETAILSREL_WHERE);

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
		"blocksMetadataDetailsRel.uuid = ?";

	private static final String _FINDER_COLUMN_UUID_UUID_3 =
		"(blocksMetadataDetailsRel.uuid IS NULL OR blocksMetadataDetailsRel.uuid = '')";

	private FinderPath _finderPathFetchByUUID_G;
	private FinderPath _finderPathCountByUUID_G;

	/**
	 * Returns the blocks metadata details rel where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchBlocksMetadataDetailsRelException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching blocks metadata details rel
	 * @throws NoSuchBlocksMetadataDetailsRelException if a matching blocks metadata details rel could not be found
	 */
	@Override
	public BlocksMetadataDetailsRel findByUUID_G(String uuid, long groupId)
		throws NoSuchBlocksMetadataDetailsRelException {

		BlocksMetadataDetailsRel blocksMetadataDetailsRel = fetchByUUID_G(
			uuid, groupId);

		if (blocksMetadataDetailsRel == null) {
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

			throw new NoSuchBlocksMetadataDetailsRelException(sb.toString());
		}

		return blocksMetadataDetailsRel;
	}

	/**
	 * Returns the blocks metadata details rel where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching blocks metadata details rel, or <code>null</code> if a matching blocks metadata details rel could not be found
	 */
	@Override
	public BlocksMetadataDetailsRel fetchByUUID_G(String uuid, long groupId) {
		return fetchByUUID_G(uuid, groupId, true);
	}

	/**
	 * Returns the blocks metadata details rel where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching blocks metadata details rel, or <code>null</code> if a matching blocks metadata details rel could not be found
	 */
	@Override
	public BlocksMetadataDetailsRel fetchByUUID_G(
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

		if (result instanceof BlocksMetadataDetailsRel) {
			BlocksMetadataDetailsRel blocksMetadataDetailsRel =
				(BlocksMetadataDetailsRel)result;

			if (!Objects.equals(uuid, blocksMetadataDetailsRel.getUuid()) ||
				(groupId != blocksMetadataDetailsRel.getGroupId())) {

				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_SQL_SELECT_BLOCKSMETADATADETAILSREL_WHERE);

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

				List<BlocksMetadataDetailsRel> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchByUUID_G, finderArgs, list);
					}
				}
				else {
					BlocksMetadataDetailsRel blocksMetadataDetailsRel =
						list.get(0);

					result = blocksMetadataDetailsRel;

					cacheResult(blocksMetadataDetailsRel);
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
			return (BlocksMetadataDetailsRel)result;
		}
	}

	/**
	 * Removes the blocks metadata details rel where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the blocks metadata details rel that was removed
	 */
	@Override
	public BlocksMetadataDetailsRel removeByUUID_G(String uuid, long groupId)
		throws NoSuchBlocksMetadataDetailsRelException {

		BlocksMetadataDetailsRel blocksMetadataDetailsRel = findByUUID_G(
			uuid, groupId);

		return remove(blocksMetadataDetailsRel);
	}

	/**
	 * Returns the number of blocks metadata details rels where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching blocks metadata details rels
	 */
	@Override
	public int countByUUID_G(String uuid, long groupId) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUUID_G;

		Object[] finderArgs = new Object[] {uuid, groupId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_BLOCKSMETADATADETAILSREL_WHERE);

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
		"blocksMetadataDetailsRel.uuid = ? AND ";

	private static final String _FINDER_COLUMN_UUID_G_UUID_3 =
		"(blocksMetadataDetailsRel.uuid IS NULL OR blocksMetadataDetailsRel.uuid = '') AND ";

	private static final String _FINDER_COLUMN_UUID_G_GROUPID_2 =
		"blocksMetadataDetailsRel.groupId = ?";

	private FinderPath _finderPathWithPaginationFindByUuid_C;
	private FinderPath _finderPathWithoutPaginationFindByUuid_C;
	private FinderPath _finderPathCountByUuid_C;

	/**
	 * Returns all the blocks metadata details rels where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching blocks metadata details rels
	 */
	@Override
	public List<BlocksMetadataDetailsRel> findByUuid_C(
		String uuid, long companyId) {

		return findByUuid_C(
			uuid, companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the blocks metadata details rels where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>BlocksMetadataDetailsRelModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of blocks metadata details rels
	 * @param end the upper bound of the range of blocks metadata details rels (not inclusive)
	 * @return the range of matching blocks metadata details rels
	 */
	@Override
	public List<BlocksMetadataDetailsRel> findByUuid_C(
		String uuid, long companyId, int start, int end) {

		return findByUuid_C(uuid, companyId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the blocks metadata details rels where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>BlocksMetadataDetailsRelModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of blocks metadata details rels
	 * @param end the upper bound of the range of blocks metadata details rels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching blocks metadata details rels
	 */
	@Override
	public List<BlocksMetadataDetailsRel> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<BlocksMetadataDetailsRel> orderByComparator) {

		return findByUuid_C(
			uuid, companyId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the blocks metadata details rels where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>BlocksMetadataDetailsRelModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of blocks metadata details rels
	 * @param end the upper bound of the range of blocks metadata details rels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching blocks metadata details rels
	 */
	@Override
	public List<BlocksMetadataDetailsRel> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<BlocksMetadataDetailsRel> orderByComparator,
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

		List<BlocksMetadataDetailsRel> list = null;

		if (useFinderCache) {
			list = (List<BlocksMetadataDetailsRel>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (BlocksMetadataDetailsRel blocksMetadataDetailsRel : list) {
					if (!uuid.equals(blocksMetadataDetailsRel.getUuid()) ||
						(companyId !=
							blocksMetadataDetailsRel.getCompanyId())) {

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

			sb.append(_SQL_SELECT_BLOCKSMETADATADETAILSREL_WHERE);

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
				sb.append(BlocksMetadataDetailsRelModelImpl.ORDER_BY_JPQL);
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

				list = (List<BlocksMetadataDetailsRel>)QueryUtil.list(
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
	 * Returns the first blocks metadata details rel in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching blocks metadata details rel
	 * @throws NoSuchBlocksMetadataDetailsRelException if a matching blocks metadata details rel could not be found
	 */
	@Override
	public BlocksMetadataDetailsRel findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<BlocksMetadataDetailsRel> orderByComparator)
		throws NoSuchBlocksMetadataDetailsRelException {

		BlocksMetadataDetailsRel blocksMetadataDetailsRel = fetchByUuid_C_First(
			uuid, companyId, orderByComparator);

		if (blocksMetadataDetailsRel != null) {
			return blocksMetadataDetailsRel;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append(", companyId=");
		sb.append(companyId);

		sb.append("}");

		throw new NoSuchBlocksMetadataDetailsRelException(sb.toString());
	}

	/**
	 * Returns the first blocks metadata details rel in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching blocks metadata details rel, or <code>null</code> if a matching blocks metadata details rel could not be found
	 */
	@Override
	public BlocksMetadataDetailsRel fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<BlocksMetadataDetailsRel> orderByComparator) {

		List<BlocksMetadataDetailsRel> list = findByUuid_C(
			uuid, companyId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last blocks metadata details rel in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching blocks metadata details rel
	 * @throws NoSuchBlocksMetadataDetailsRelException if a matching blocks metadata details rel could not be found
	 */
	@Override
	public BlocksMetadataDetailsRel findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<BlocksMetadataDetailsRel> orderByComparator)
		throws NoSuchBlocksMetadataDetailsRelException {

		BlocksMetadataDetailsRel blocksMetadataDetailsRel = fetchByUuid_C_Last(
			uuid, companyId, orderByComparator);

		if (blocksMetadataDetailsRel != null) {
			return blocksMetadataDetailsRel;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append(", companyId=");
		sb.append(companyId);

		sb.append("}");

		throw new NoSuchBlocksMetadataDetailsRelException(sb.toString());
	}

	/**
	 * Returns the last blocks metadata details rel in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching blocks metadata details rel, or <code>null</code> if a matching blocks metadata details rel could not be found
	 */
	@Override
	public BlocksMetadataDetailsRel fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<BlocksMetadataDetailsRel> orderByComparator) {

		int count = countByUuid_C(uuid, companyId);

		if (count == 0) {
			return null;
		}

		List<BlocksMetadataDetailsRel> list = findByUuid_C(
			uuid, companyId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the blocks metadata details rels before and after the current blocks metadata details rel in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param blocksMetadataDetailsRelId the primary key of the current blocks metadata details rel
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next blocks metadata details rel
	 * @throws NoSuchBlocksMetadataDetailsRelException if a blocks metadata details rel with the primary key could not be found
	 */
	@Override
	public BlocksMetadataDetailsRel[] findByUuid_C_PrevAndNext(
			long blocksMetadataDetailsRelId, String uuid, long companyId,
			OrderByComparator<BlocksMetadataDetailsRel> orderByComparator)
		throws NoSuchBlocksMetadataDetailsRelException {

		uuid = Objects.toString(uuid, "");

		BlocksMetadataDetailsRel blocksMetadataDetailsRel = findByPrimaryKey(
			blocksMetadataDetailsRelId);

		Session session = null;

		try {
			session = openSession();

			BlocksMetadataDetailsRel[] array =
				new BlocksMetadataDetailsRelImpl[3];

			array[0] = getByUuid_C_PrevAndNext(
				session, blocksMetadataDetailsRel, uuid, companyId,
				orderByComparator, true);

			array[1] = blocksMetadataDetailsRel;

			array[2] = getByUuid_C_PrevAndNext(
				session, blocksMetadataDetailsRel, uuid, companyId,
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

	protected BlocksMetadataDetailsRel getByUuid_C_PrevAndNext(
		Session session, BlocksMetadataDetailsRel blocksMetadataDetailsRel,
		String uuid, long companyId,
		OrderByComparator<BlocksMetadataDetailsRel> orderByComparator,
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

		sb.append(_SQL_SELECT_BLOCKSMETADATADETAILSREL_WHERE);

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
			sb.append(BlocksMetadataDetailsRelModelImpl.ORDER_BY_JPQL);
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
						blocksMetadataDetailsRel)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<BlocksMetadataDetailsRel> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the blocks metadata details rels where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	@Override
	public void removeByUuid_C(String uuid, long companyId) {
		for (BlocksMetadataDetailsRel blocksMetadataDetailsRel :
				findByUuid_C(
					uuid, companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(blocksMetadataDetailsRel);
		}
	}

	/**
	 * Returns the number of blocks metadata details rels where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching blocks metadata details rels
	 */
	@Override
	public int countByUuid_C(String uuid, long companyId) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid_C;

		Object[] finderArgs = new Object[] {uuid, companyId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_BLOCKSMETADATADETAILSREL_WHERE);

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
		"blocksMetadataDetailsRel.uuid = ? AND ";

	private static final String _FINDER_COLUMN_UUID_C_UUID_3 =
		"(blocksMetadataDetailsRel.uuid IS NULL OR blocksMetadataDetailsRel.uuid = '') AND ";

	private static final String _FINDER_COLUMN_UUID_C_COMPANYID_2 =
		"blocksMetadataDetailsRel.companyId = ?";

	private FinderPath _finderPathWithPaginationFindByProgDurationTlBlocksLtId;
	private FinderPath
		_finderPathWithoutPaginationFindByProgDurationTlBlocksLtId;
	private FinderPath _finderPathCountByProgDurationTlBlocksLtId;

	/**
	 * Returns all the blocks metadata details rels where progDurationTlBlocksLtId = &#63;.
	 *
	 * @param progDurationTlBlocksLtId the prog duration tl blocks lt ID
	 * @return the matching blocks metadata details rels
	 */
	@Override
	public List<BlocksMetadataDetailsRel> findByProgDurationTlBlocksLtId(
		long progDurationTlBlocksLtId) {

		return findByProgDurationTlBlocksLtId(
			progDurationTlBlocksLtId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
	}

	/**
	 * Returns a range of all the blocks metadata details rels where progDurationTlBlocksLtId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>BlocksMetadataDetailsRelModelImpl</code>.
	 * </p>
	 *
	 * @param progDurationTlBlocksLtId the prog duration tl blocks lt ID
	 * @param start the lower bound of the range of blocks metadata details rels
	 * @param end the upper bound of the range of blocks metadata details rels (not inclusive)
	 * @return the range of matching blocks metadata details rels
	 */
	@Override
	public List<BlocksMetadataDetailsRel> findByProgDurationTlBlocksLtId(
		long progDurationTlBlocksLtId, int start, int end) {

		return findByProgDurationTlBlocksLtId(
			progDurationTlBlocksLtId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the blocks metadata details rels where progDurationTlBlocksLtId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>BlocksMetadataDetailsRelModelImpl</code>.
	 * </p>
	 *
	 * @param progDurationTlBlocksLtId the prog duration tl blocks lt ID
	 * @param start the lower bound of the range of blocks metadata details rels
	 * @param end the upper bound of the range of blocks metadata details rels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching blocks metadata details rels
	 */
	@Override
	public List<BlocksMetadataDetailsRel> findByProgDurationTlBlocksLtId(
		long progDurationTlBlocksLtId, int start, int end,
		OrderByComparator<BlocksMetadataDetailsRel> orderByComparator) {

		return findByProgDurationTlBlocksLtId(
			progDurationTlBlocksLtId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the blocks metadata details rels where progDurationTlBlocksLtId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>BlocksMetadataDetailsRelModelImpl</code>.
	 * </p>
	 *
	 * @param progDurationTlBlocksLtId the prog duration tl blocks lt ID
	 * @param start the lower bound of the range of blocks metadata details rels
	 * @param end the upper bound of the range of blocks metadata details rels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching blocks metadata details rels
	 */
	@Override
	public List<BlocksMetadataDetailsRel> findByProgDurationTlBlocksLtId(
		long progDurationTlBlocksLtId, int start, int end,
		OrderByComparator<BlocksMetadataDetailsRel> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath =
					_finderPathWithoutPaginationFindByProgDurationTlBlocksLtId;
				finderArgs = new Object[] {progDurationTlBlocksLtId};
			}
		}
		else if (useFinderCache) {
			finderPath =
				_finderPathWithPaginationFindByProgDurationTlBlocksLtId;
			finderArgs = new Object[] {
				progDurationTlBlocksLtId, start, end, orderByComparator
			};
		}

		List<BlocksMetadataDetailsRel> list = null;

		if (useFinderCache) {
			list = (List<BlocksMetadataDetailsRel>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (BlocksMetadataDetailsRel blocksMetadataDetailsRel : list) {
					if (progDurationTlBlocksLtId !=
							blocksMetadataDetailsRel.
								getProgDurationTlBlocksLtId()) {

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

			sb.append(_SQL_SELECT_BLOCKSMETADATADETAILSREL_WHERE);

			sb.append(
				_FINDER_COLUMN_PROGDURATIONTLBLOCKSLTID_PROGDURATIONTLBLOCKSLTID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(BlocksMetadataDetailsRelModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(progDurationTlBlocksLtId);

				list = (List<BlocksMetadataDetailsRel>)QueryUtil.list(
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
	 * Returns the first blocks metadata details rel in the ordered set where progDurationTlBlocksLtId = &#63;.
	 *
	 * @param progDurationTlBlocksLtId the prog duration tl blocks lt ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching blocks metadata details rel
	 * @throws NoSuchBlocksMetadataDetailsRelException if a matching blocks metadata details rel could not be found
	 */
	@Override
	public BlocksMetadataDetailsRel findByProgDurationTlBlocksLtId_First(
			long progDurationTlBlocksLtId,
			OrderByComparator<BlocksMetadataDetailsRel> orderByComparator)
		throws NoSuchBlocksMetadataDetailsRelException {

		BlocksMetadataDetailsRel blocksMetadataDetailsRel =
			fetchByProgDurationTlBlocksLtId_First(
				progDurationTlBlocksLtId, orderByComparator);

		if (blocksMetadataDetailsRel != null) {
			return blocksMetadataDetailsRel;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("progDurationTlBlocksLtId=");
		sb.append(progDurationTlBlocksLtId);

		sb.append("}");

		throw new NoSuchBlocksMetadataDetailsRelException(sb.toString());
	}

	/**
	 * Returns the first blocks metadata details rel in the ordered set where progDurationTlBlocksLtId = &#63;.
	 *
	 * @param progDurationTlBlocksLtId the prog duration tl blocks lt ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching blocks metadata details rel, or <code>null</code> if a matching blocks metadata details rel could not be found
	 */
	@Override
	public BlocksMetadataDetailsRel fetchByProgDurationTlBlocksLtId_First(
		long progDurationTlBlocksLtId,
		OrderByComparator<BlocksMetadataDetailsRel> orderByComparator) {

		List<BlocksMetadataDetailsRel> list = findByProgDurationTlBlocksLtId(
			progDurationTlBlocksLtId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last blocks metadata details rel in the ordered set where progDurationTlBlocksLtId = &#63;.
	 *
	 * @param progDurationTlBlocksLtId the prog duration tl blocks lt ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching blocks metadata details rel
	 * @throws NoSuchBlocksMetadataDetailsRelException if a matching blocks metadata details rel could not be found
	 */
	@Override
	public BlocksMetadataDetailsRel findByProgDurationTlBlocksLtId_Last(
			long progDurationTlBlocksLtId,
			OrderByComparator<BlocksMetadataDetailsRel> orderByComparator)
		throws NoSuchBlocksMetadataDetailsRelException {

		BlocksMetadataDetailsRel blocksMetadataDetailsRel =
			fetchByProgDurationTlBlocksLtId_Last(
				progDurationTlBlocksLtId, orderByComparator);

		if (blocksMetadataDetailsRel != null) {
			return blocksMetadataDetailsRel;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("progDurationTlBlocksLtId=");
		sb.append(progDurationTlBlocksLtId);

		sb.append("}");

		throw new NoSuchBlocksMetadataDetailsRelException(sb.toString());
	}

	/**
	 * Returns the last blocks metadata details rel in the ordered set where progDurationTlBlocksLtId = &#63;.
	 *
	 * @param progDurationTlBlocksLtId the prog duration tl blocks lt ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching blocks metadata details rel, or <code>null</code> if a matching blocks metadata details rel could not be found
	 */
	@Override
	public BlocksMetadataDetailsRel fetchByProgDurationTlBlocksLtId_Last(
		long progDurationTlBlocksLtId,
		OrderByComparator<BlocksMetadataDetailsRel> orderByComparator) {

		int count = countByProgDurationTlBlocksLtId(progDurationTlBlocksLtId);

		if (count == 0) {
			return null;
		}

		List<BlocksMetadataDetailsRel> list = findByProgDurationTlBlocksLtId(
			progDurationTlBlocksLtId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the blocks metadata details rels before and after the current blocks metadata details rel in the ordered set where progDurationTlBlocksLtId = &#63;.
	 *
	 * @param blocksMetadataDetailsRelId the primary key of the current blocks metadata details rel
	 * @param progDurationTlBlocksLtId the prog duration tl blocks lt ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next blocks metadata details rel
	 * @throws NoSuchBlocksMetadataDetailsRelException if a blocks metadata details rel with the primary key could not be found
	 */
	@Override
	public BlocksMetadataDetailsRel[]
			findByProgDurationTlBlocksLtId_PrevAndNext(
				long blocksMetadataDetailsRelId, long progDurationTlBlocksLtId,
				OrderByComparator<BlocksMetadataDetailsRel> orderByComparator)
		throws NoSuchBlocksMetadataDetailsRelException {

		BlocksMetadataDetailsRel blocksMetadataDetailsRel = findByPrimaryKey(
			blocksMetadataDetailsRelId);

		Session session = null;

		try {
			session = openSession();

			BlocksMetadataDetailsRel[] array =
				new BlocksMetadataDetailsRelImpl[3];

			array[0] = getByProgDurationTlBlocksLtId_PrevAndNext(
				session, blocksMetadataDetailsRel, progDurationTlBlocksLtId,
				orderByComparator, true);

			array[1] = blocksMetadataDetailsRel;

			array[2] = getByProgDurationTlBlocksLtId_PrevAndNext(
				session, blocksMetadataDetailsRel, progDurationTlBlocksLtId,
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

	protected BlocksMetadataDetailsRel
		getByProgDurationTlBlocksLtId_PrevAndNext(
			Session session, BlocksMetadataDetailsRel blocksMetadataDetailsRel,
			long progDurationTlBlocksLtId,
			OrderByComparator<BlocksMetadataDetailsRel> orderByComparator,
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

		sb.append(_SQL_SELECT_BLOCKSMETADATADETAILSREL_WHERE);

		sb.append(
			_FINDER_COLUMN_PROGDURATIONTLBLOCKSLTID_PROGDURATIONTLBLOCKSLTID_2);

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
			sb.append(BlocksMetadataDetailsRelModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(progDurationTlBlocksLtId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						blocksMetadataDetailsRel)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<BlocksMetadataDetailsRel> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the blocks metadata details rels where progDurationTlBlocksLtId = &#63; from the database.
	 *
	 * @param progDurationTlBlocksLtId the prog duration tl blocks lt ID
	 */
	@Override
	public void removeByProgDurationTlBlocksLtId(
		long progDurationTlBlocksLtId) {

		for (BlocksMetadataDetailsRel blocksMetadataDetailsRel :
				findByProgDurationTlBlocksLtId(
					progDurationTlBlocksLtId, QueryUtil.ALL_POS,
					QueryUtil.ALL_POS, null)) {

			remove(blocksMetadataDetailsRel);
		}
	}

	/**
	 * Returns the number of blocks metadata details rels where progDurationTlBlocksLtId = &#63;.
	 *
	 * @param progDurationTlBlocksLtId the prog duration tl blocks lt ID
	 * @return the number of matching blocks metadata details rels
	 */
	@Override
	public int countByProgDurationTlBlocksLtId(long progDurationTlBlocksLtId) {
		FinderPath finderPath = _finderPathCountByProgDurationTlBlocksLtId;

		Object[] finderArgs = new Object[] {progDurationTlBlocksLtId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_BLOCKSMETADATADETAILSREL_WHERE);

			sb.append(
				_FINDER_COLUMN_PROGDURATIONTLBLOCKSLTID_PROGDURATIONTLBLOCKSLTID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(progDurationTlBlocksLtId);

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
		_FINDER_COLUMN_PROGDURATIONTLBLOCKSLTID_PROGDURATIONTLBLOCKSLTID_2 =
			"blocksMetadataDetailsRel.progDurationTlBlocksLtId = ?";

	private FinderPath
		_finderPathFetchByProgDurationTlBlocksLtIdAndBlockStartDate;
	private FinderPath
		_finderPathCountByProgDurationTlBlocksLtIdAndBlockStartDate;

	/**
	 * Returns the blocks metadata details rel where progDurationTlBlocksLtId = &#63; and blockStartDate = &#63; or throws a <code>NoSuchBlocksMetadataDetailsRelException</code> if it could not be found.
	 *
	 * @param progDurationTlBlocksLtId the prog duration tl blocks lt ID
	 * @param blockStartDate the block start date
	 * @return the matching blocks metadata details rel
	 * @throws NoSuchBlocksMetadataDetailsRelException if a matching blocks metadata details rel could not be found
	 */
	@Override
	public BlocksMetadataDetailsRel
			findByProgDurationTlBlocksLtIdAndBlockStartDate(
				long progDurationTlBlocksLtId, Date blockStartDate)
		throws NoSuchBlocksMetadataDetailsRelException {

		BlocksMetadataDetailsRel blocksMetadataDetailsRel =
			fetchByProgDurationTlBlocksLtIdAndBlockStartDate(
				progDurationTlBlocksLtId, blockStartDate);

		if (blocksMetadataDetailsRel == null) {
			StringBundler sb = new StringBundler(6);

			sb.append(_NO_SUCH_ENTITY_WITH_KEY);

			sb.append("progDurationTlBlocksLtId=");
			sb.append(progDurationTlBlocksLtId);

			sb.append(", blockStartDate=");
			sb.append(blockStartDate);

			sb.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(sb.toString());
			}

			throw new NoSuchBlocksMetadataDetailsRelException(sb.toString());
		}

		return blocksMetadataDetailsRel;
	}

	/**
	 * Returns the blocks metadata details rel where progDurationTlBlocksLtId = &#63; and blockStartDate = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param progDurationTlBlocksLtId the prog duration tl blocks lt ID
	 * @param blockStartDate the block start date
	 * @return the matching blocks metadata details rel, or <code>null</code> if a matching blocks metadata details rel could not be found
	 */
	@Override
	public BlocksMetadataDetailsRel
		fetchByProgDurationTlBlocksLtIdAndBlockStartDate(
			long progDurationTlBlocksLtId, Date blockStartDate) {

		return fetchByProgDurationTlBlocksLtIdAndBlockStartDate(
			progDurationTlBlocksLtId, blockStartDate, true);
	}

	/**
	 * Returns the blocks metadata details rel where progDurationTlBlocksLtId = &#63; and blockStartDate = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param progDurationTlBlocksLtId the prog duration tl blocks lt ID
	 * @param blockStartDate the block start date
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching blocks metadata details rel, or <code>null</code> if a matching blocks metadata details rel could not be found
	 */
	@Override
	public BlocksMetadataDetailsRel
		fetchByProgDurationTlBlocksLtIdAndBlockStartDate(
			long progDurationTlBlocksLtId, Date blockStartDate,
			boolean useFinderCache) {

		Object[] finderArgs = null;

		if (useFinderCache) {
			finderArgs = new Object[] {
				progDurationTlBlocksLtId, _getTime(blockStartDate)
			};
		}

		Object result = null;

		if (useFinderCache) {
			result = finderCache.getResult(
				_finderPathFetchByProgDurationTlBlocksLtIdAndBlockStartDate,
				finderArgs, this);
		}

		if (result instanceof BlocksMetadataDetailsRel) {
			BlocksMetadataDetailsRel blocksMetadataDetailsRel =
				(BlocksMetadataDetailsRel)result;

			if ((progDurationTlBlocksLtId !=
					blocksMetadataDetailsRel.getProgDurationTlBlocksLtId()) ||
				!Objects.equals(
					blockStartDate,
					blocksMetadataDetailsRel.getBlockStartDate())) {

				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_SQL_SELECT_BLOCKSMETADATADETAILSREL_WHERE);

			sb.append(
				_FINDER_COLUMN_PROGDURATIONTLBLOCKSLTIDANDBLOCKSTARTDATE_PROGDURATIONTLBLOCKSLTID_2);

			boolean bindBlockStartDate = false;

			if (blockStartDate == null) {
				sb.append(
					_FINDER_COLUMN_PROGDURATIONTLBLOCKSLTIDANDBLOCKSTARTDATE_BLOCKSTARTDATE_1);
			}
			else {
				bindBlockStartDate = true;

				sb.append(
					_FINDER_COLUMN_PROGDURATIONTLBLOCKSLTIDANDBLOCKSTARTDATE_BLOCKSTARTDATE_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(progDurationTlBlocksLtId);

				if (bindBlockStartDate) {
					queryPos.add(new Timestamp(blockStartDate.getTime()));
				}

				List<BlocksMetadataDetailsRel> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchByProgDurationTlBlocksLtIdAndBlockStartDate,
							finderArgs, list);
					}
				}
				else {
					if (list.size() > 1) {
						Collections.sort(list, Collections.reverseOrder());

						if (_log.isWarnEnabled()) {
							if (!useFinderCache) {
								finderArgs = new Object[] {
									progDurationTlBlocksLtId,
									_getTime(blockStartDate)
								};
							}

							_log.warn(
								"BlocksMetadataDetailsRelPersistenceImpl.fetchByProgDurationTlBlocksLtIdAndBlockStartDate(long, Date, boolean) with parameters (" +
									StringUtil.merge(finderArgs) +
										") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
						}
					}

					BlocksMetadataDetailsRel blocksMetadataDetailsRel =
						list.get(0);

					result = blocksMetadataDetailsRel;

					cacheResult(blocksMetadataDetailsRel);
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
			return (BlocksMetadataDetailsRel)result;
		}
	}

	/**
	 * Removes the blocks metadata details rel where progDurationTlBlocksLtId = &#63; and blockStartDate = &#63; from the database.
	 *
	 * @param progDurationTlBlocksLtId the prog duration tl blocks lt ID
	 * @param blockStartDate the block start date
	 * @return the blocks metadata details rel that was removed
	 */
	@Override
	public BlocksMetadataDetailsRel
			removeByProgDurationTlBlocksLtIdAndBlockStartDate(
				long progDurationTlBlocksLtId, Date blockStartDate)
		throws NoSuchBlocksMetadataDetailsRelException {

		BlocksMetadataDetailsRel blocksMetadataDetailsRel =
			findByProgDurationTlBlocksLtIdAndBlockStartDate(
				progDurationTlBlocksLtId, blockStartDate);

		return remove(blocksMetadataDetailsRel);
	}

	/**
	 * Returns the number of blocks metadata details rels where progDurationTlBlocksLtId = &#63; and blockStartDate = &#63;.
	 *
	 * @param progDurationTlBlocksLtId the prog duration tl blocks lt ID
	 * @param blockStartDate the block start date
	 * @return the number of matching blocks metadata details rels
	 */
	@Override
	public int countByProgDurationTlBlocksLtIdAndBlockStartDate(
		long progDurationTlBlocksLtId, Date blockStartDate) {

		FinderPath finderPath =
			_finderPathCountByProgDurationTlBlocksLtIdAndBlockStartDate;

		Object[] finderArgs = new Object[] {
			progDurationTlBlocksLtId, _getTime(blockStartDate)
		};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_BLOCKSMETADATADETAILSREL_WHERE);

			sb.append(
				_FINDER_COLUMN_PROGDURATIONTLBLOCKSLTIDANDBLOCKSTARTDATE_PROGDURATIONTLBLOCKSLTID_2);

			boolean bindBlockStartDate = false;

			if (blockStartDate == null) {
				sb.append(
					_FINDER_COLUMN_PROGDURATIONTLBLOCKSLTIDANDBLOCKSTARTDATE_BLOCKSTARTDATE_1);
			}
			else {
				bindBlockStartDate = true;

				sb.append(
					_FINDER_COLUMN_PROGDURATIONTLBLOCKSLTIDANDBLOCKSTARTDATE_BLOCKSTARTDATE_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(progDurationTlBlocksLtId);

				if (bindBlockStartDate) {
					queryPos.add(new Timestamp(blockStartDate.getTime()));
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
		_FINDER_COLUMN_PROGDURATIONTLBLOCKSLTIDANDBLOCKSTARTDATE_PROGDURATIONTLBLOCKSLTID_2 =
			"blocksMetadataDetailsRel.progDurationTlBlocksLtId = ? AND ";

	private static final String
		_FINDER_COLUMN_PROGDURATIONTLBLOCKSLTIDANDBLOCKSTARTDATE_BLOCKSTARTDATE_1 =
			"blocksMetadataDetailsRel.blockStartDate IS NULL";

	private static final String
		_FINDER_COLUMN_PROGDURATIONTLBLOCKSLTIDANDBLOCKSTARTDATE_BLOCKSTARTDATE_2 =
			"blocksMetadataDetailsRel.blockStartDate = ?";

	public BlocksMetadataDetailsRelPersistenceImpl() {
		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("uuid", "uuid_");
		dbColumnNames.put(
			"blocksMetadataDetailsRelId", "blocks_metadata_details_rel_id");
		dbColumnNames.put("groupId", "group_id");
		dbColumnNames.put("companyId", "company_id");
		dbColumnNames.put("createDate", "create_date");
		dbColumnNames.put("modifiedDate", "modified_date");
		dbColumnNames.put("createdBy", "created_by");
		dbColumnNames.put("modifiedBy", "modified_by");
		dbColumnNames.put(
			"progDurationTlBlocksLtId", "progduration_tl_blocks_lt_id");
		dbColumnNames.put("blockNo", "block_no");
		dbColumnNames.put("blockStartDate", "block_start_date");
		dbColumnNames.put("blockEndDate", "block_end_date");

		setDBColumnNames(dbColumnNames);

		setModelClass(BlocksMetadataDetailsRel.class);

		setModelImplClass(BlocksMetadataDetailsRelImpl.class);
		setModelPKClass(long.class);

		setTable(BlocksMetadataDetailsRelTable.INSTANCE);
	}

	/**
	 * Caches the blocks metadata details rel in the entity cache if it is enabled.
	 *
	 * @param blocksMetadataDetailsRel the blocks metadata details rel
	 */
	@Override
	public void cacheResult(BlocksMetadataDetailsRel blocksMetadataDetailsRel) {
		entityCache.putResult(
			BlocksMetadataDetailsRelImpl.class,
			blocksMetadataDetailsRel.getPrimaryKey(), blocksMetadataDetailsRel);

		finderCache.putResult(
			_finderPathFetchByUUID_G,
			new Object[] {
				blocksMetadataDetailsRel.getUuid(),
				blocksMetadataDetailsRel.getGroupId()
			},
			blocksMetadataDetailsRel);

		finderCache.putResult(
			_finderPathFetchByProgDurationTlBlocksLtIdAndBlockStartDate,
			new Object[] {
				blocksMetadataDetailsRel.getProgDurationTlBlocksLtId(),
				blocksMetadataDetailsRel.getBlockStartDate()
			},
			blocksMetadataDetailsRel);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the blocks metadata details rels in the entity cache if it is enabled.
	 *
	 * @param blocksMetadataDetailsRels the blocks metadata details rels
	 */
	@Override
	public void cacheResult(
		List<BlocksMetadataDetailsRel> blocksMetadataDetailsRels) {

		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (blocksMetadataDetailsRels.size() >
				 _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (BlocksMetadataDetailsRel blocksMetadataDetailsRel :
				blocksMetadataDetailsRels) {

			if (entityCache.getResult(
					BlocksMetadataDetailsRelImpl.class,
					blocksMetadataDetailsRel.getPrimaryKey()) == null) {

				cacheResult(blocksMetadataDetailsRel);
			}
		}
	}

	/**
	 * Clears the cache for all blocks metadata details rels.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(BlocksMetadataDetailsRelImpl.class);

		finderCache.clearCache(BlocksMetadataDetailsRelImpl.class);
	}

	/**
	 * Clears the cache for the blocks metadata details rel.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(BlocksMetadataDetailsRel blocksMetadataDetailsRel) {
		entityCache.removeResult(
			BlocksMetadataDetailsRelImpl.class, blocksMetadataDetailsRel);
	}

	@Override
	public void clearCache(
		List<BlocksMetadataDetailsRel> blocksMetadataDetailsRels) {

		for (BlocksMetadataDetailsRel blocksMetadataDetailsRel :
				blocksMetadataDetailsRels) {

			entityCache.removeResult(
				BlocksMetadataDetailsRelImpl.class, blocksMetadataDetailsRel);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(BlocksMetadataDetailsRelImpl.class);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(
				BlocksMetadataDetailsRelImpl.class, primaryKey);
		}
	}

	protected void cacheUniqueFindersCache(
		BlocksMetadataDetailsRelModelImpl blocksMetadataDetailsRelModelImpl) {

		Object[] args = new Object[] {
			blocksMetadataDetailsRelModelImpl.getUuid(),
			blocksMetadataDetailsRelModelImpl.getGroupId()
		};

		finderCache.putResult(_finderPathCountByUUID_G, args, Long.valueOf(1));
		finderCache.putResult(
			_finderPathFetchByUUID_G, args, blocksMetadataDetailsRelModelImpl);

		args = new Object[] {
			blocksMetadataDetailsRelModelImpl.getProgDurationTlBlocksLtId(),
			_getTime(blocksMetadataDetailsRelModelImpl.getBlockStartDate())
		};

		finderCache.putResult(
			_finderPathCountByProgDurationTlBlocksLtIdAndBlockStartDate, args,
			Long.valueOf(1));
		finderCache.putResult(
			_finderPathFetchByProgDurationTlBlocksLtIdAndBlockStartDate, args,
			blocksMetadataDetailsRelModelImpl);
	}

	/**
	 * Creates a new blocks metadata details rel with the primary key. Does not add the blocks metadata details rel to the database.
	 *
	 * @param blocksMetadataDetailsRelId the primary key for the new blocks metadata details rel
	 * @return the new blocks metadata details rel
	 */
	@Override
	public BlocksMetadataDetailsRel create(long blocksMetadataDetailsRelId) {
		BlocksMetadataDetailsRel blocksMetadataDetailsRel =
			new BlocksMetadataDetailsRelImpl();

		blocksMetadataDetailsRel.setNew(true);
		blocksMetadataDetailsRel.setPrimaryKey(blocksMetadataDetailsRelId);

		String uuid = _portalUUID.generate();

		blocksMetadataDetailsRel.setUuid(uuid);

		blocksMetadataDetailsRel.setCompanyId(
			CompanyThreadLocal.getCompanyId());

		return blocksMetadataDetailsRel;
	}

	/**
	 * Removes the blocks metadata details rel with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param blocksMetadataDetailsRelId the primary key of the blocks metadata details rel
	 * @return the blocks metadata details rel that was removed
	 * @throws NoSuchBlocksMetadataDetailsRelException if a blocks metadata details rel with the primary key could not be found
	 */
	@Override
	public BlocksMetadataDetailsRel remove(long blocksMetadataDetailsRelId)
		throws NoSuchBlocksMetadataDetailsRelException {

		return remove((Serializable)blocksMetadataDetailsRelId);
	}

	/**
	 * Removes the blocks metadata details rel with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the blocks metadata details rel
	 * @return the blocks metadata details rel that was removed
	 * @throws NoSuchBlocksMetadataDetailsRelException if a blocks metadata details rel with the primary key could not be found
	 */
	@Override
	public BlocksMetadataDetailsRel remove(Serializable primaryKey)
		throws NoSuchBlocksMetadataDetailsRelException {

		Session session = null;

		try {
			session = openSession();

			BlocksMetadataDetailsRel blocksMetadataDetailsRel =
				(BlocksMetadataDetailsRel)session.get(
					BlocksMetadataDetailsRelImpl.class, primaryKey);

			if (blocksMetadataDetailsRel == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchBlocksMetadataDetailsRelException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(blocksMetadataDetailsRel);
		}
		catch (NoSuchBlocksMetadataDetailsRelException noSuchEntityException) {
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
	protected BlocksMetadataDetailsRel removeImpl(
		BlocksMetadataDetailsRel blocksMetadataDetailsRel) {

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(blocksMetadataDetailsRel)) {
				blocksMetadataDetailsRel =
					(BlocksMetadataDetailsRel)session.get(
						BlocksMetadataDetailsRelImpl.class,
						blocksMetadataDetailsRel.getPrimaryKeyObj());
			}

			if (blocksMetadataDetailsRel != null) {
				session.delete(blocksMetadataDetailsRel);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (blocksMetadataDetailsRel != null) {
			clearCache(blocksMetadataDetailsRel);
		}

		return blocksMetadataDetailsRel;
	}

	@Override
	public BlocksMetadataDetailsRel updateImpl(
		BlocksMetadataDetailsRel blocksMetadataDetailsRel) {

		boolean isNew = blocksMetadataDetailsRel.isNew();

		if (!(blocksMetadataDetailsRel instanceof
				BlocksMetadataDetailsRelModelImpl)) {

			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(blocksMetadataDetailsRel.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(
					blocksMetadataDetailsRel);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in blocksMetadataDetailsRel proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom BlocksMetadataDetailsRel implementation " +
					blocksMetadataDetailsRel.getClass());
		}

		BlocksMetadataDetailsRelModelImpl blocksMetadataDetailsRelModelImpl =
			(BlocksMetadataDetailsRelModelImpl)blocksMetadataDetailsRel;

		if (Validator.isNull(blocksMetadataDetailsRel.getUuid())) {
			String uuid = _portalUUID.generate();

			blocksMetadataDetailsRel.setUuid(uuid);
		}

		ServiceContext serviceContext =
			ServiceContextThreadLocal.getServiceContext();

		Date date = new Date();

		if (isNew && (blocksMetadataDetailsRel.getCreateDate() == null)) {
			if (serviceContext == null) {
				blocksMetadataDetailsRel.setCreateDate(date);
			}
			else {
				blocksMetadataDetailsRel.setCreateDate(
					serviceContext.getCreateDate(date));
			}
		}

		if (!blocksMetadataDetailsRelModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				blocksMetadataDetailsRel.setModifiedDate(date);
			}
			else {
				blocksMetadataDetailsRel.setModifiedDate(
					serviceContext.getModifiedDate(date));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(blocksMetadataDetailsRel);
			}
			else {
				blocksMetadataDetailsRel =
					(BlocksMetadataDetailsRel)session.merge(
						blocksMetadataDetailsRel);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(
			BlocksMetadataDetailsRelImpl.class,
			blocksMetadataDetailsRelModelImpl, false, true);

		cacheUniqueFindersCache(blocksMetadataDetailsRelModelImpl);

		if (isNew) {
			blocksMetadataDetailsRel.setNew(false);
		}

		blocksMetadataDetailsRel.resetOriginalValues();

		return blocksMetadataDetailsRel;
	}

	/**
	 * Returns the blocks metadata details rel with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the blocks metadata details rel
	 * @return the blocks metadata details rel
	 * @throws NoSuchBlocksMetadataDetailsRelException if a blocks metadata details rel with the primary key could not be found
	 */
	@Override
	public BlocksMetadataDetailsRel findByPrimaryKey(Serializable primaryKey)
		throws NoSuchBlocksMetadataDetailsRelException {

		BlocksMetadataDetailsRel blocksMetadataDetailsRel = fetchByPrimaryKey(
			primaryKey);

		if (blocksMetadataDetailsRel == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchBlocksMetadataDetailsRelException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return blocksMetadataDetailsRel;
	}

	/**
	 * Returns the blocks metadata details rel with the primary key or throws a <code>NoSuchBlocksMetadataDetailsRelException</code> if it could not be found.
	 *
	 * @param blocksMetadataDetailsRelId the primary key of the blocks metadata details rel
	 * @return the blocks metadata details rel
	 * @throws NoSuchBlocksMetadataDetailsRelException if a blocks metadata details rel with the primary key could not be found
	 */
	@Override
	public BlocksMetadataDetailsRel findByPrimaryKey(
			long blocksMetadataDetailsRelId)
		throws NoSuchBlocksMetadataDetailsRelException {

		return findByPrimaryKey((Serializable)blocksMetadataDetailsRelId);
	}

	/**
	 * Returns the blocks metadata details rel with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param blocksMetadataDetailsRelId the primary key of the blocks metadata details rel
	 * @return the blocks metadata details rel, or <code>null</code> if a blocks metadata details rel with the primary key could not be found
	 */
	@Override
	public BlocksMetadataDetailsRel fetchByPrimaryKey(
		long blocksMetadataDetailsRelId) {

		return fetchByPrimaryKey((Serializable)blocksMetadataDetailsRelId);
	}

	/**
	 * Returns all the blocks metadata details rels.
	 *
	 * @return the blocks metadata details rels
	 */
	@Override
	public List<BlocksMetadataDetailsRel> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the blocks metadata details rels.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>BlocksMetadataDetailsRelModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of blocks metadata details rels
	 * @param end the upper bound of the range of blocks metadata details rels (not inclusive)
	 * @return the range of blocks metadata details rels
	 */
	@Override
	public List<BlocksMetadataDetailsRel> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the blocks metadata details rels.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>BlocksMetadataDetailsRelModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of blocks metadata details rels
	 * @param end the upper bound of the range of blocks metadata details rels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of blocks metadata details rels
	 */
	@Override
	public List<BlocksMetadataDetailsRel> findAll(
		int start, int end,
		OrderByComparator<BlocksMetadataDetailsRel> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the blocks metadata details rels.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>BlocksMetadataDetailsRelModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of blocks metadata details rels
	 * @param end the upper bound of the range of blocks metadata details rels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of blocks metadata details rels
	 */
	@Override
	public List<BlocksMetadataDetailsRel> findAll(
		int start, int end,
		OrderByComparator<BlocksMetadataDetailsRel> orderByComparator,
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

		List<BlocksMetadataDetailsRel> list = null;

		if (useFinderCache) {
			list = (List<BlocksMetadataDetailsRel>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_BLOCKSMETADATADETAILSREL);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_BLOCKSMETADATADETAILSREL;

				sql = sql.concat(
					BlocksMetadataDetailsRelModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<BlocksMetadataDetailsRel>)QueryUtil.list(
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
	 * Removes all the blocks metadata details rels from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (BlocksMetadataDetailsRel blocksMetadataDetailsRel : findAll()) {
			remove(blocksMetadataDetailsRel);
		}
	}

	/**
	 * Returns the number of blocks metadata details rels.
	 *
	 * @return the number of blocks metadata details rels
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
					_SQL_COUNT_BLOCKSMETADATADETAILSREL);

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
		return "blocks_metadata_details_rel_id";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_BLOCKSMETADATADETAILSREL;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return BlocksMetadataDetailsRelModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the blocks metadata details rel persistence.
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

		_finderPathWithPaginationFindByProgDurationTlBlocksLtId =
			new FinderPath(
				FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
				"findByProgDurationTlBlocksLtId",
				new String[] {
					Long.class.getName(), Integer.class.getName(),
					Integer.class.getName(), OrderByComparator.class.getName()
				},
				new String[] {"progduration_tl_blocks_lt_id"}, true);

		_finderPathWithoutPaginationFindByProgDurationTlBlocksLtId =
			new FinderPath(
				FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
				"findByProgDurationTlBlocksLtId",
				new String[] {Long.class.getName()},
				new String[] {"progduration_tl_blocks_lt_id"}, true);

		_finderPathCountByProgDurationTlBlocksLtId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByProgDurationTlBlocksLtId",
			new String[] {Long.class.getName()},
			new String[] {"progduration_tl_blocks_lt_id"}, false);

		_finderPathFetchByProgDurationTlBlocksLtIdAndBlockStartDate =
			new FinderPath(
				FINDER_CLASS_NAME_ENTITY,
				"fetchByProgDurationTlBlocksLtIdAndBlockStartDate",
				new String[] {Long.class.getName(), Date.class.getName()},
				new String[] {
					"progduration_tl_blocks_lt_id", "block_start_date"
				},
				true);

		_finderPathCountByProgDurationTlBlocksLtIdAndBlockStartDate =
			new FinderPath(
				FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
				"countByProgDurationTlBlocksLtIdAndBlockStartDate",
				new String[] {Long.class.getName(), Date.class.getName()},
				new String[] {
					"progduration_tl_blocks_lt_id", "block_start_date"
				},
				false);

		_setBlocksMetadataDetailsRelUtilPersistence(this);
	}

	@Deactivate
	public void deactivate() {
		_setBlocksMetadataDetailsRelUtilPersistence(null);

		entityCache.removeCache(BlocksMetadataDetailsRelImpl.class.getName());
	}

	private void _setBlocksMetadataDetailsRelUtilPersistence(
		BlocksMetadataDetailsRelPersistence
			blocksMetadataDetailsRelPersistence) {

		try {
			Field field = BlocksMetadataDetailsRelUtil.class.getDeclaredField(
				"_persistence");

			field.setAccessible(true);

			field.set(null, blocksMetadataDetailsRelPersistence);
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

	private static Long _getTime(Date date) {
		if (date == null) {
			return null;
		}

		return date.getTime();
	}

	private static final String _SQL_SELECT_BLOCKSMETADATADETAILSREL =
		"SELECT blocksMetadataDetailsRel FROM BlocksMetadataDetailsRel blocksMetadataDetailsRel";

	private static final String _SQL_SELECT_BLOCKSMETADATADETAILSREL_WHERE =
		"SELECT blocksMetadataDetailsRel FROM BlocksMetadataDetailsRel blocksMetadataDetailsRel WHERE ";

	private static final String _SQL_COUNT_BLOCKSMETADATADETAILSREL =
		"SELECT COUNT(blocksMetadataDetailsRel) FROM BlocksMetadataDetailsRel blocksMetadataDetailsRel";

	private static final String _SQL_COUNT_BLOCKSMETADATADETAILSREL_WHERE =
		"SELECT COUNT(blocksMetadataDetailsRel) FROM BlocksMetadataDetailsRel blocksMetadataDetailsRel WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS =
		"blocksMetadataDetailsRel.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No BlocksMetadataDetailsRel exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No BlocksMetadataDetailsRel exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		BlocksMetadataDetailsRelPersistenceImpl.class);

	private static final Set<String> _badColumnNames = SetUtil.fromArray(
		new String[] {
			"uuid", "blocksMetadataDetailsRelId", "groupId", "companyId",
			"createDate", "modifiedDate", "createdBy", "modifiedBy",
			"progDurationTlBlocksLtId", "blockNo", "blockStartDate",
			"blockEndDate"
		});

	@Override
	protected FinderCache getFinderCache() {
		return finderCache;
	}

	@Reference
	private PortalUUID _portalUUID;

}
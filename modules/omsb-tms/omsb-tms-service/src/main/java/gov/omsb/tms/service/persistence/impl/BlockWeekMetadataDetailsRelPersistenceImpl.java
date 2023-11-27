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

import gov.omsb.tms.exception.NoSuchBlockWeekMetadataDetailsRelException;
import gov.omsb.tms.model.BlockWeekMetadataDetailsRel;
import gov.omsb.tms.model.BlockWeekMetadataDetailsRelTable;
import gov.omsb.tms.model.impl.BlockWeekMetadataDetailsRelImpl;
import gov.omsb.tms.model.impl.BlockWeekMetadataDetailsRelModelImpl;
import gov.omsb.tms.service.persistence.BlockWeekMetadataDetailsRelPersistence;
import gov.omsb.tms.service.persistence.BlockWeekMetadataDetailsRelUtil;
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
 * The persistence implementation for the block week metadata details rel service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = BlockWeekMetadataDetailsRelPersistence.class)
public class BlockWeekMetadataDetailsRelPersistenceImpl
	extends BasePersistenceImpl<BlockWeekMetadataDetailsRel>
	implements BlockWeekMetadataDetailsRelPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>BlockWeekMetadataDetailsRelUtil</code> to access the block week metadata details rel persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		BlockWeekMetadataDetailsRelImpl.class.getName();

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
	 * Returns all the block week metadata details rels where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching block week metadata details rels
	 */
	@Override
	public List<BlockWeekMetadataDetailsRel> findByUuid(String uuid) {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the block week metadata details rels where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>BlockWeekMetadataDetailsRelModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of block week metadata details rels
	 * @param end the upper bound of the range of block week metadata details rels (not inclusive)
	 * @return the range of matching block week metadata details rels
	 */
	@Override
	public List<BlockWeekMetadataDetailsRel> findByUuid(
		String uuid, int start, int end) {

		return findByUuid(uuid, start, end, null);
	}

	/**
	 * Returns an ordered range of all the block week metadata details rels where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>BlockWeekMetadataDetailsRelModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of block week metadata details rels
	 * @param end the upper bound of the range of block week metadata details rels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching block week metadata details rels
	 */
	@Override
	public List<BlockWeekMetadataDetailsRel> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<BlockWeekMetadataDetailsRel> orderByComparator) {

		return findByUuid(uuid, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the block week metadata details rels where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>BlockWeekMetadataDetailsRelModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of block week metadata details rels
	 * @param end the upper bound of the range of block week metadata details rels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching block week metadata details rels
	 */
	@Override
	public List<BlockWeekMetadataDetailsRel> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<BlockWeekMetadataDetailsRel> orderByComparator,
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

		List<BlockWeekMetadataDetailsRel> list = null;

		if (useFinderCache) {
			list = (List<BlockWeekMetadataDetailsRel>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (BlockWeekMetadataDetailsRel blockWeekMetadataDetailsRel :
						list) {

					if (!uuid.equals(blockWeekMetadataDetailsRel.getUuid())) {
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

			sb.append(_SQL_SELECT_BLOCKWEEKMETADATADETAILSREL_WHERE);

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
				sb.append(BlockWeekMetadataDetailsRelModelImpl.ORDER_BY_JPQL);
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

				list = (List<BlockWeekMetadataDetailsRel>)QueryUtil.list(
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
	 * Returns the first block week metadata details rel in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching block week metadata details rel
	 * @throws NoSuchBlockWeekMetadataDetailsRelException if a matching block week metadata details rel could not be found
	 */
	@Override
	public BlockWeekMetadataDetailsRel findByUuid_First(
			String uuid,
			OrderByComparator<BlockWeekMetadataDetailsRel> orderByComparator)
		throws NoSuchBlockWeekMetadataDetailsRelException {

		BlockWeekMetadataDetailsRel blockWeekMetadataDetailsRel =
			fetchByUuid_First(uuid, orderByComparator);

		if (blockWeekMetadataDetailsRel != null) {
			return blockWeekMetadataDetailsRel;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchBlockWeekMetadataDetailsRelException(sb.toString());
	}

	/**
	 * Returns the first block week metadata details rel in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching block week metadata details rel, or <code>null</code> if a matching block week metadata details rel could not be found
	 */
	@Override
	public BlockWeekMetadataDetailsRel fetchByUuid_First(
		String uuid,
		OrderByComparator<BlockWeekMetadataDetailsRel> orderByComparator) {

		List<BlockWeekMetadataDetailsRel> list = findByUuid(
			uuid, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last block week metadata details rel in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching block week metadata details rel
	 * @throws NoSuchBlockWeekMetadataDetailsRelException if a matching block week metadata details rel could not be found
	 */
	@Override
	public BlockWeekMetadataDetailsRel findByUuid_Last(
			String uuid,
			OrderByComparator<BlockWeekMetadataDetailsRel> orderByComparator)
		throws NoSuchBlockWeekMetadataDetailsRelException {

		BlockWeekMetadataDetailsRel blockWeekMetadataDetailsRel =
			fetchByUuid_Last(uuid, orderByComparator);

		if (blockWeekMetadataDetailsRel != null) {
			return blockWeekMetadataDetailsRel;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchBlockWeekMetadataDetailsRelException(sb.toString());
	}

	/**
	 * Returns the last block week metadata details rel in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching block week metadata details rel, or <code>null</code> if a matching block week metadata details rel could not be found
	 */
	@Override
	public BlockWeekMetadataDetailsRel fetchByUuid_Last(
		String uuid,
		OrderByComparator<BlockWeekMetadataDetailsRel> orderByComparator) {

		int count = countByUuid(uuid);

		if (count == 0) {
			return null;
		}

		List<BlockWeekMetadataDetailsRel> list = findByUuid(
			uuid, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the block week metadata details rels before and after the current block week metadata details rel in the ordered set where uuid = &#63;.
	 *
	 * @param blockWeekMetadataDetailsRelId the primary key of the current block week metadata details rel
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next block week metadata details rel
	 * @throws NoSuchBlockWeekMetadataDetailsRelException if a block week metadata details rel with the primary key could not be found
	 */
	@Override
	public BlockWeekMetadataDetailsRel[] findByUuid_PrevAndNext(
			long blockWeekMetadataDetailsRelId, String uuid,
			OrderByComparator<BlockWeekMetadataDetailsRel> orderByComparator)
		throws NoSuchBlockWeekMetadataDetailsRelException {

		uuid = Objects.toString(uuid, "");

		BlockWeekMetadataDetailsRel blockWeekMetadataDetailsRel =
			findByPrimaryKey(blockWeekMetadataDetailsRelId);

		Session session = null;

		try {
			session = openSession();

			BlockWeekMetadataDetailsRel[] array =
				new BlockWeekMetadataDetailsRelImpl[3];

			array[0] = getByUuid_PrevAndNext(
				session, blockWeekMetadataDetailsRel, uuid, orderByComparator,
				true);

			array[1] = blockWeekMetadataDetailsRel;

			array[2] = getByUuid_PrevAndNext(
				session, blockWeekMetadataDetailsRel, uuid, orderByComparator,
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

	protected BlockWeekMetadataDetailsRel getByUuid_PrevAndNext(
		Session session,
		BlockWeekMetadataDetailsRel blockWeekMetadataDetailsRel, String uuid,
		OrderByComparator<BlockWeekMetadataDetailsRel> orderByComparator,
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

		sb.append(_SQL_SELECT_BLOCKWEEKMETADATADETAILSREL_WHERE);

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
			sb.append(BlockWeekMetadataDetailsRelModelImpl.ORDER_BY_JPQL);
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
						blockWeekMetadataDetailsRel)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<BlockWeekMetadataDetailsRel> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the block week metadata details rels where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	@Override
	public void removeByUuid(String uuid) {
		for (BlockWeekMetadataDetailsRel blockWeekMetadataDetailsRel :
				findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(blockWeekMetadataDetailsRel);
		}
	}

	/**
	 * Returns the number of block week metadata details rels where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching block week metadata details rels
	 */
	@Override
	public int countByUuid(String uuid) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid;

		Object[] finderArgs = new Object[] {uuid};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_BLOCKWEEKMETADATADETAILSREL_WHERE);

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
		"blockWeekMetadataDetailsRel.uuid = ?";

	private static final String _FINDER_COLUMN_UUID_UUID_3 =
		"(blockWeekMetadataDetailsRel.uuid IS NULL OR blockWeekMetadataDetailsRel.uuid = '')";

	private FinderPath _finderPathFetchByUUID_G;
	private FinderPath _finderPathCountByUUID_G;

	/**
	 * Returns the block week metadata details rel where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchBlockWeekMetadataDetailsRelException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching block week metadata details rel
	 * @throws NoSuchBlockWeekMetadataDetailsRelException if a matching block week metadata details rel could not be found
	 */
	@Override
	public BlockWeekMetadataDetailsRel findByUUID_G(String uuid, long groupId)
		throws NoSuchBlockWeekMetadataDetailsRelException {

		BlockWeekMetadataDetailsRel blockWeekMetadataDetailsRel = fetchByUUID_G(
			uuid, groupId);

		if (blockWeekMetadataDetailsRel == null) {
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

			throw new NoSuchBlockWeekMetadataDetailsRelException(sb.toString());
		}

		return blockWeekMetadataDetailsRel;
	}

	/**
	 * Returns the block week metadata details rel where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching block week metadata details rel, or <code>null</code> if a matching block week metadata details rel could not be found
	 */
	@Override
	public BlockWeekMetadataDetailsRel fetchByUUID_G(
		String uuid, long groupId) {

		return fetchByUUID_G(uuid, groupId, true);
	}

	/**
	 * Returns the block week metadata details rel where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching block week metadata details rel, or <code>null</code> if a matching block week metadata details rel could not be found
	 */
	@Override
	public BlockWeekMetadataDetailsRel fetchByUUID_G(
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

		if (result instanceof BlockWeekMetadataDetailsRel) {
			BlockWeekMetadataDetailsRel blockWeekMetadataDetailsRel =
				(BlockWeekMetadataDetailsRel)result;

			if (!Objects.equals(uuid, blockWeekMetadataDetailsRel.getUuid()) ||
				(groupId != blockWeekMetadataDetailsRel.getGroupId())) {

				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_SQL_SELECT_BLOCKWEEKMETADATADETAILSREL_WHERE);

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

				List<BlockWeekMetadataDetailsRel> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchByUUID_G, finderArgs, list);
					}
				}
				else {
					BlockWeekMetadataDetailsRel blockWeekMetadataDetailsRel =
						list.get(0);

					result = blockWeekMetadataDetailsRel;

					cacheResult(blockWeekMetadataDetailsRel);
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
			return (BlockWeekMetadataDetailsRel)result;
		}
	}

	/**
	 * Removes the block week metadata details rel where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the block week metadata details rel that was removed
	 */
	@Override
	public BlockWeekMetadataDetailsRel removeByUUID_G(String uuid, long groupId)
		throws NoSuchBlockWeekMetadataDetailsRelException {

		BlockWeekMetadataDetailsRel blockWeekMetadataDetailsRel = findByUUID_G(
			uuid, groupId);

		return remove(blockWeekMetadataDetailsRel);
	}

	/**
	 * Returns the number of block week metadata details rels where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching block week metadata details rels
	 */
	@Override
	public int countByUUID_G(String uuid, long groupId) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUUID_G;

		Object[] finderArgs = new Object[] {uuid, groupId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_BLOCKWEEKMETADATADETAILSREL_WHERE);

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
		"blockWeekMetadataDetailsRel.uuid = ? AND ";

	private static final String _FINDER_COLUMN_UUID_G_UUID_3 =
		"(blockWeekMetadataDetailsRel.uuid IS NULL OR blockWeekMetadataDetailsRel.uuid = '') AND ";

	private static final String _FINDER_COLUMN_UUID_G_GROUPID_2 =
		"blockWeekMetadataDetailsRel.groupId = ?";

	private FinderPath _finderPathWithPaginationFindByUuid_C;
	private FinderPath _finderPathWithoutPaginationFindByUuid_C;
	private FinderPath _finderPathCountByUuid_C;

	/**
	 * Returns all the block week metadata details rels where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching block week metadata details rels
	 */
	@Override
	public List<BlockWeekMetadataDetailsRel> findByUuid_C(
		String uuid, long companyId) {

		return findByUuid_C(
			uuid, companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the block week metadata details rels where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>BlockWeekMetadataDetailsRelModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of block week metadata details rels
	 * @param end the upper bound of the range of block week metadata details rels (not inclusive)
	 * @return the range of matching block week metadata details rels
	 */
	@Override
	public List<BlockWeekMetadataDetailsRel> findByUuid_C(
		String uuid, long companyId, int start, int end) {

		return findByUuid_C(uuid, companyId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the block week metadata details rels where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>BlockWeekMetadataDetailsRelModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of block week metadata details rels
	 * @param end the upper bound of the range of block week metadata details rels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching block week metadata details rels
	 */
	@Override
	public List<BlockWeekMetadataDetailsRel> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<BlockWeekMetadataDetailsRel> orderByComparator) {

		return findByUuid_C(
			uuid, companyId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the block week metadata details rels where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>BlockWeekMetadataDetailsRelModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of block week metadata details rels
	 * @param end the upper bound of the range of block week metadata details rels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching block week metadata details rels
	 */
	@Override
	public List<BlockWeekMetadataDetailsRel> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<BlockWeekMetadataDetailsRel> orderByComparator,
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

		List<BlockWeekMetadataDetailsRel> list = null;

		if (useFinderCache) {
			list = (List<BlockWeekMetadataDetailsRel>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (BlockWeekMetadataDetailsRel blockWeekMetadataDetailsRel :
						list) {

					if (!uuid.equals(blockWeekMetadataDetailsRel.getUuid()) ||
						(companyId !=
							blockWeekMetadataDetailsRel.getCompanyId())) {

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

			sb.append(_SQL_SELECT_BLOCKWEEKMETADATADETAILSREL_WHERE);

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
				sb.append(BlockWeekMetadataDetailsRelModelImpl.ORDER_BY_JPQL);
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

				list = (List<BlockWeekMetadataDetailsRel>)QueryUtil.list(
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
	 * Returns the first block week metadata details rel in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching block week metadata details rel
	 * @throws NoSuchBlockWeekMetadataDetailsRelException if a matching block week metadata details rel could not be found
	 */
	@Override
	public BlockWeekMetadataDetailsRel findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<BlockWeekMetadataDetailsRel> orderByComparator)
		throws NoSuchBlockWeekMetadataDetailsRelException {

		BlockWeekMetadataDetailsRel blockWeekMetadataDetailsRel =
			fetchByUuid_C_First(uuid, companyId, orderByComparator);

		if (blockWeekMetadataDetailsRel != null) {
			return blockWeekMetadataDetailsRel;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append(", companyId=");
		sb.append(companyId);

		sb.append("}");

		throw new NoSuchBlockWeekMetadataDetailsRelException(sb.toString());
	}

	/**
	 * Returns the first block week metadata details rel in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching block week metadata details rel, or <code>null</code> if a matching block week metadata details rel could not be found
	 */
	@Override
	public BlockWeekMetadataDetailsRel fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<BlockWeekMetadataDetailsRel> orderByComparator) {

		List<BlockWeekMetadataDetailsRel> list = findByUuid_C(
			uuid, companyId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last block week metadata details rel in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching block week metadata details rel
	 * @throws NoSuchBlockWeekMetadataDetailsRelException if a matching block week metadata details rel could not be found
	 */
	@Override
	public BlockWeekMetadataDetailsRel findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<BlockWeekMetadataDetailsRel> orderByComparator)
		throws NoSuchBlockWeekMetadataDetailsRelException {

		BlockWeekMetadataDetailsRel blockWeekMetadataDetailsRel =
			fetchByUuid_C_Last(uuid, companyId, orderByComparator);

		if (blockWeekMetadataDetailsRel != null) {
			return blockWeekMetadataDetailsRel;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append(", companyId=");
		sb.append(companyId);

		sb.append("}");

		throw new NoSuchBlockWeekMetadataDetailsRelException(sb.toString());
	}

	/**
	 * Returns the last block week metadata details rel in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching block week metadata details rel, or <code>null</code> if a matching block week metadata details rel could not be found
	 */
	@Override
	public BlockWeekMetadataDetailsRel fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<BlockWeekMetadataDetailsRel> orderByComparator) {

		int count = countByUuid_C(uuid, companyId);

		if (count == 0) {
			return null;
		}

		List<BlockWeekMetadataDetailsRel> list = findByUuid_C(
			uuid, companyId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the block week metadata details rels before and after the current block week metadata details rel in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param blockWeekMetadataDetailsRelId the primary key of the current block week metadata details rel
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next block week metadata details rel
	 * @throws NoSuchBlockWeekMetadataDetailsRelException if a block week metadata details rel with the primary key could not be found
	 */
	@Override
	public BlockWeekMetadataDetailsRel[] findByUuid_C_PrevAndNext(
			long blockWeekMetadataDetailsRelId, String uuid, long companyId,
			OrderByComparator<BlockWeekMetadataDetailsRel> orderByComparator)
		throws NoSuchBlockWeekMetadataDetailsRelException {

		uuid = Objects.toString(uuid, "");

		BlockWeekMetadataDetailsRel blockWeekMetadataDetailsRel =
			findByPrimaryKey(blockWeekMetadataDetailsRelId);

		Session session = null;

		try {
			session = openSession();

			BlockWeekMetadataDetailsRel[] array =
				new BlockWeekMetadataDetailsRelImpl[3];

			array[0] = getByUuid_C_PrevAndNext(
				session, blockWeekMetadataDetailsRel, uuid, companyId,
				orderByComparator, true);

			array[1] = blockWeekMetadataDetailsRel;

			array[2] = getByUuid_C_PrevAndNext(
				session, blockWeekMetadataDetailsRel, uuid, companyId,
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

	protected BlockWeekMetadataDetailsRel getByUuid_C_PrevAndNext(
		Session session,
		BlockWeekMetadataDetailsRel blockWeekMetadataDetailsRel, String uuid,
		long companyId,
		OrderByComparator<BlockWeekMetadataDetailsRel> orderByComparator,
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

		sb.append(_SQL_SELECT_BLOCKWEEKMETADATADETAILSREL_WHERE);

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
			sb.append(BlockWeekMetadataDetailsRelModelImpl.ORDER_BY_JPQL);
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
						blockWeekMetadataDetailsRel)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<BlockWeekMetadataDetailsRel> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the block week metadata details rels where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	@Override
	public void removeByUuid_C(String uuid, long companyId) {
		for (BlockWeekMetadataDetailsRel blockWeekMetadataDetailsRel :
				findByUuid_C(
					uuid, companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(blockWeekMetadataDetailsRel);
		}
	}

	/**
	 * Returns the number of block week metadata details rels where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching block week metadata details rels
	 */
	@Override
	public int countByUuid_C(String uuid, long companyId) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid_C;

		Object[] finderArgs = new Object[] {uuid, companyId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_BLOCKWEEKMETADATADETAILSREL_WHERE);

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
		"blockWeekMetadataDetailsRel.uuid = ? AND ";

	private static final String _FINDER_COLUMN_UUID_C_UUID_3 =
		"(blockWeekMetadataDetailsRel.uuid IS NULL OR blockWeekMetadataDetailsRel.uuid = '') AND ";

	private static final String _FINDER_COLUMN_UUID_C_COMPANYID_2 =
		"blockWeekMetadataDetailsRel.companyId = ?";

	private FinderPath _finderPathWithPaginationFindByBlocksMetadataDetailRelId;
	private FinderPath
		_finderPathWithoutPaginationFindByBlocksMetadataDetailRelId;
	private FinderPath _finderPathCountByBlocksMetadataDetailRelId;

	/**
	 * Returns all the block week metadata details rels where blocksMetadataDetailRelId = &#63;.
	 *
	 * @param blocksMetadataDetailRelId the blocks metadata detail rel ID
	 * @return the matching block week metadata details rels
	 */
	@Override
	public List<BlockWeekMetadataDetailsRel> findByBlocksMetadataDetailRelId(
		long blocksMetadataDetailRelId) {

		return findByBlocksMetadataDetailRelId(
			blocksMetadataDetailRelId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
	}

	/**
	 * Returns a range of all the block week metadata details rels where blocksMetadataDetailRelId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>BlockWeekMetadataDetailsRelModelImpl</code>.
	 * </p>
	 *
	 * @param blocksMetadataDetailRelId the blocks metadata detail rel ID
	 * @param start the lower bound of the range of block week metadata details rels
	 * @param end the upper bound of the range of block week metadata details rels (not inclusive)
	 * @return the range of matching block week metadata details rels
	 */
	@Override
	public List<BlockWeekMetadataDetailsRel> findByBlocksMetadataDetailRelId(
		long blocksMetadataDetailRelId, int start, int end) {

		return findByBlocksMetadataDetailRelId(
			blocksMetadataDetailRelId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the block week metadata details rels where blocksMetadataDetailRelId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>BlockWeekMetadataDetailsRelModelImpl</code>.
	 * </p>
	 *
	 * @param blocksMetadataDetailRelId the blocks metadata detail rel ID
	 * @param start the lower bound of the range of block week metadata details rels
	 * @param end the upper bound of the range of block week metadata details rels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching block week metadata details rels
	 */
	@Override
	public List<BlockWeekMetadataDetailsRel> findByBlocksMetadataDetailRelId(
		long blocksMetadataDetailRelId, int start, int end,
		OrderByComparator<BlockWeekMetadataDetailsRel> orderByComparator) {

		return findByBlocksMetadataDetailRelId(
			blocksMetadataDetailRelId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the block week metadata details rels where blocksMetadataDetailRelId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>BlockWeekMetadataDetailsRelModelImpl</code>.
	 * </p>
	 *
	 * @param blocksMetadataDetailRelId the blocks metadata detail rel ID
	 * @param start the lower bound of the range of block week metadata details rels
	 * @param end the upper bound of the range of block week metadata details rels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching block week metadata details rels
	 */
	@Override
	public List<BlockWeekMetadataDetailsRel> findByBlocksMetadataDetailRelId(
		long blocksMetadataDetailRelId, int start, int end,
		OrderByComparator<BlockWeekMetadataDetailsRel> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath =
					_finderPathWithoutPaginationFindByBlocksMetadataDetailRelId;
				finderArgs = new Object[] {blocksMetadataDetailRelId};
			}
		}
		else if (useFinderCache) {
			finderPath =
				_finderPathWithPaginationFindByBlocksMetadataDetailRelId;
			finderArgs = new Object[] {
				blocksMetadataDetailRelId, start, end, orderByComparator
			};
		}

		List<BlockWeekMetadataDetailsRel> list = null;

		if (useFinderCache) {
			list = (List<BlockWeekMetadataDetailsRel>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (BlockWeekMetadataDetailsRel blockWeekMetadataDetailsRel :
						list) {

					if (blocksMetadataDetailRelId !=
							blockWeekMetadataDetailsRel.
								getBlocksMetadataDetailRelId()) {

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

			sb.append(_SQL_SELECT_BLOCKWEEKMETADATADETAILSREL_WHERE);

			sb.append(
				_FINDER_COLUMN_BLOCKSMETADATADETAILRELID_BLOCKSMETADATADETAILRELID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(BlockWeekMetadataDetailsRelModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(blocksMetadataDetailRelId);

				list = (List<BlockWeekMetadataDetailsRel>)QueryUtil.list(
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
	 * Returns the first block week metadata details rel in the ordered set where blocksMetadataDetailRelId = &#63;.
	 *
	 * @param blocksMetadataDetailRelId the blocks metadata detail rel ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching block week metadata details rel
	 * @throws NoSuchBlockWeekMetadataDetailsRelException if a matching block week metadata details rel could not be found
	 */
	@Override
	public BlockWeekMetadataDetailsRel findByBlocksMetadataDetailRelId_First(
			long blocksMetadataDetailRelId,
			OrderByComparator<BlockWeekMetadataDetailsRel> orderByComparator)
		throws NoSuchBlockWeekMetadataDetailsRelException {

		BlockWeekMetadataDetailsRel blockWeekMetadataDetailsRel =
			fetchByBlocksMetadataDetailRelId_First(
				blocksMetadataDetailRelId, orderByComparator);

		if (blockWeekMetadataDetailsRel != null) {
			return blockWeekMetadataDetailsRel;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("blocksMetadataDetailRelId=");
		sb.append(blocksMetadataDetailRelId);

		sb.append("}");

		throw new NoSuchBlockWeekMetadataDetailsRelException(sb.toString());
	}

	/**
	 * Returns the first block week metadata details rel in the ordered set where blocksMetadataDetailRelId = &#63;.
	 *
	 * @param blocksMetadataDetailRelId the blocks metadata detail rel ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching block week metadata details rel, or <code>null</code> if a matching block week metadata details rel could not be found
	 */
	@Override
	public BlockWeekMetadataDetailsRel fetchByBlocksMetadataDetailRelId_First(
		long blocksMetadataDetailRelId,
		OrderByComparator<BlockWeekMetadataDetailsRel> orderByComparator) {

		List<BlockWeekMetadataDetailsRel> list =
			findByBlocksMetadataDetailRelId(
				blocksMetadataDetailRelId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last block week metadata details rel in the ordered set where blocksMetadataDetailRelId = &#63;.
	 *
	 * @param blocksMetadataDetailRelId the blocks metadata detail rel ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching block week metadata details rel
	 * @throws NoSuchBlockWeekMetadataDetailsRelException if a matching block week metadata details rel could not be found
	 */
	@Override
	public BlockWeekMetadataDetailsRel findByBlocksMetadataDetailRelId_Last(
			long blocksMetadataDetailRelId,
			OrderByComparator<BlockWeekMetadataDetailsRel> orderByComparator)
		throws NoSuchBlockWeekMetadataDetailsRelException {

		BlockWeekMetadataDetailsRel blockWeekMetadataDetailsRel =
			fetchByBlocksMetadataDetailRelId_Last(
				blocksMetadataDetailRelId, orderByComparator);

		if (blockWeekMetadataDetailsRel != null) {
			return blockWeekMetadataDetailsRel;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("blocksMetadataDetailRelId=");
		sb.append(blocksMetadataDetailRelId);

		sb.append("}");

		throw new NoSuchBlockWeekMetadataDetailsRelException(sb.toString());
	}

	/**
	 * Returns the last block week metadata details rel in the ordered set where blocksMetadataDetailRelId = &#63;.
	 *
	 * @param blocksMetadataDetailRelId the blocks metadata detail rel ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching block week metadata details rel, or <code>null</code> if a matching block week metadata details rel could not be found
	 */
	@Override
	public BlockWeekMetadataDetailsRel fetchByBlocksMetadataDetailRelId_Last(
		long blocksMetadataDetailRelId,
		OrderByComparator<BlockWeekMetadataDetailsRel> orderByComparator) {

		int count = countByBlocksMetadataDetailRelId(blocksMetadataDetailRelId);

		if (count == 0) {
			return null;
		}

		List<BlockWeekMetadataDetailsRel> list =
			findByBlocksMetadataDetailRelId(
				blocksMetadataDetailRelId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the block week metadata details rels before and after the current block week metadata details rel in the ordered set where blocksMetadataDetailRelId = &#63;.
	 *
	 * @param blockWeekMetadataDetailsRelId the primary key of the current block week metadata details rel
	 * @param blocksMetadataDetailRelId the blocks metadata detail rel ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next block week metadata details rel
	 * @throws NoSuchBlockWeekMetadataDetailsRelException if a block week metadata details rel with the primary key could not be found
	 */
	@Override
	public BlockWeekMetadataDetailsRel[]
			findByBlocksMetadataDetailRelId_PrevAndNext(
				long blockWeekMetadataDetailsRelId,
				long blocksMetadataDetailRelId,
				OrderByComparator<BlockWeekMetadataDetailsRel>
					orderByComparator)
		throws NoSuchBlockWeekMetadataDetailsRelException {

		BlockWeekMetadataDetailsRel blockWeekMetadataDetailsRel =
			findByPrimaryKey(blockWeekMetadataDetailsRelId);

		Session session = null;

		try {
			session = openSession();

			BlockWeekMetadataDetailsRel[] array =
				new BlockWeekMetadataDetailsRelImpl[3];

			array[0] = getByBlocksMetadataDetailRelId_PrevAndNext(
				session, blockWeekMetadataDetailsRel, blocksMetadataDetailRelId,
				orderByComparator, true);

			array[1] = blockWeekMetadataDetailsRel;

			array[2] = getByBlocksMetadataDetailRelId_PrevAndNext(
				session, blockWeekMetadataDetailsRel, blocksMetadataDetailRelId,
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

	protected BlockWeekMetadataDetailsRel
		getByBlocksMetadataDetailRelId_PrevAndNext(
			Session session,
			BlockWeekMetadataDetailsRel blockWeekMetadataDetailsRel,
			long blocksMetadataDetailRelId,
			OrderByComparator<BlockWeekMetadataDetailsRel> orderByComparator,
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

		sb.append(_SQL_SELECT_BLOCKWEEKMETADATADETAILSREL_WHERE);

		sb.append(
			_FINDER_COLUMN_BLOCKSMETADATADETAILRELID_BLOCKSMETADATADETAILRELID_2);

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
			sb.append(BlockWeekMetadataDetailsRelModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(blocksMetadataDetailRelId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						blockWeekMetadataDetailsRel)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<BlockWeekMetadataDetailsRel> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the block week metadata details rels where blocksMetadataDetailRelId = &#63; from the database.
	 *
	 * @param blocksMetadataDetailRelId the blocks metadata detail rel ID
	 */
	@Override
	public void removeByBlocksMetadataDetailRelId(
		long blocksMetadataDetailRelId) {

		for (BlockWeekMetadataDetailsRel blockWeekMetadataDetailsRel :
				findByBlocksMetadataDetailRelId(
					blocksMetadataDetailRelId, QueryUtil.ALL_POS,
					QueryUtil.ALL_POS, null)) {

			remove(blockWeekMetadataDetailsRel);
		}
	}

	/**
	 * Returns the number of block week metadata details rels where blocksMetadataDetailRelId = &#63;.
	 *
	 * @param blocksMetadataDetailRelId the blocks metadata detail rel ID
	 * @return the number of matching block week metadata details rels
	 */
	@Override
	public int countByBlocksMetadataDetailRelId(
		long blocksMetadataDetailRelId) {

		FinderPath finderPath = _finderPathCountByBlocksMetadataDetailRelId;

		Object[] finderArgs = new Object[] {blocksMetadataDetailRelId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_BLOCKWEEKMETADATADETAILSREL_WHERE);

			sb.append(
				_FINDER_COLUMN_BLOCKSMETADATADETAILRELID_BLOCKSMETADATADETAILRELID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(blocksMetadataDetailRelId);

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
		_FINDER_COLUMN_BLOCKSMETADATADETAILRELID_BLOCKSMETADATADETAILRELID_2 =
			"blockWeekMetadataDetailsRel.blocksMetadataDetailRelId = ?";

	public BlockWeekMetadataDetailsRelPersistenceImpl() {
		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("uuid", "uuid_");
		dbColumnNames.put(
			"blockWeekMetadataDetailsRelId",
			"block_week_metadata_details_rel_id");
		dbColumnNames.put(
			"blocksMetadataDetailRelId", "blocks_metadata_details_rel_id");
		dbColumnNames.put("weekNo", "week_no");
		dbColumnNames.put("weekStartDate", "week_start_date");
		dbColumnNames.put("weekEndDate", "week_end_date");
		dbColumnNames.put("groupId", "group_id");
		dbColumnNames.put("companyId", "company_id");
		dbColumnNames.put("createdDate", "created_date");
		dbColumnNames.put("createdBy", "created_by");
		dbColumnNames.put("modifiedDate", "modified_date");
		dbColumnNames.put("modifiedBy", "modified_by");

		setDBColumnNames(dbColumnNames);

		setModelClass(BlockWeekMetadataDetailsRel.class);

		setModelImplClass(BlockWeekMetadataDetailsRelImpl.class);
		setModelPKClass(long.class);

		setTable(BlockWeekMetadataDetailsRelTable.INSTANCE);
	}

	/**
	 * Caches the block week metadata details rel in the entity cache if it is enabled.
	 *
	 * @param blockWeekMetadataDetailsRel the block week metadata details rel
	 */
	@Override
	public void cacheResult(
		BlockWeekMetadataDetailsRel blockWeekMetadataDetailsRel) {

		entityCache.putResult(
			BlockWeekMetadataDetailsRelImpl.class,
			blockWeekMetadataDetailsRel.getPrimaryKey(),
			blockWeekMetadataDetailsRel);

		finderCache.putResult(
			_finderPathFetchByUUID_G,
			new Object[] {
				blockWeekMetadataDetailsRel.getUuid(),
				blockWeekMetadataDetailsRel.getGroupId()
			},
			blockWeekMetadataDetailsRel);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the block week metadata details rels in the entity cache if it is enabled.
	 *
	 * @param blockWeekMetadataDetailsRels the block week metadata details rels
	 */
	@Override
	public void cacheResult(
		List<BlockWeekMetadataDetailsRel> blockWeekMetadataDetailsRels) {

		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (blockWeekMetadataDetailsRels.size() >
				 _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (BlockWeekMetadataDetailsRel blockWeekMetadataDetailsRel :
				blockWeekMetadataDetailsRels) {

			if (entityCache.getResult(
					BlockWeekMetadataDetailsRelImpl.class,
					blockWeekMetadataDetailsRel.getPrimaryKey()) == null) {

				cacheResult(blockWeekMetadataDetailsRel);
			}
		}
	}

	/**
	 * Clears the cache for all block week metadata details rels.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(BlockWeekMetadataDetailsRelImpl.class);

		finderCache.clearCache(BlockWeekMetadataDetailsRelImpl.class);
	}

	/**
	 * Clears the cache for the block week metadata details rel.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(
		BlockWeekMetadataDetailsRel blockWeekMetadataDetailsRel) {

		entityCache.removeResult(
			BlockWeekMetadataDetailsRelImpl.class, blockWeekMetadataDetailsRel);
	}

	@Override
	public void clearCache(
		List<BlockWeekMetadataDetailsRel> blockWeekMetadataDetailsRels) {

		for (BlockWeekMetadataDetailsRel blockWeekMetadataDetailsRel :
				blockWeekMetadataDetailsRels) {

			entityCache.removeResult(
				BlockWeekMetadataDetailsRelImpl.class,
				blockWeekMetadataDetailsRel);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(BlockWeekMetadataDetailsRelImpl.class);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(
				BlockWeekMetadataDetailsRelImpl.class, primaryKey);
		}
	}

	protected void cacheUniqueFindersCache(
		BlockWeekMetadataDetailsRelModelImpl
			blockWeekMetadataDetailsRelModelImpl) {

		Object[] args = new Object[] {
			blockWeekMetadataDetailsRelModelImpl.getUuid(),
			blockWeekMetadataDetailsRelModelImpl.getGroupId()
		};

		finderCache.putResult(_finderPathCountByUUID_G, args, Long.valueOf(1));
		finderCache.putResult(
			_finderPathFetchByUUID_G, args,
			blockWeekMetadataDetailsRelModelImpl);
	}

	/**
	 * Creates a new block week metadata details rel with the primary key. Does not add the block week metadata details rel to the database.
	 *
	 * @param blockWeekMetadataDetailsRelId the primary key for the new block week metadata details rel
	 * @return the new block week metadata details rel
	 */
	@Override
	public BlockWeekMetadataDetailsRel create(
		long blockWeekMetadataDetailsRelId) {

		BlockWeekMetadataDetailsRel blockWeekMetadataDetailsRel =
			new BlockWeekMetadataDetailsRelImpl();

		blockWeekMetadataDetailsRel.setNew(true);
		blockWeekMetadataDetailsRel.setPrimaryKey(
			blockWeekMetadataDetailsRelId);

		String uuid = _portalUUID.generate();

		blockWeekMetadataDetailsRel.setUuid(uuid);

		blockWeekMetadataDetailsRel.setCompanyId(
			CompanyThreadLocal.getCompanyId());

		return blockWeekMetadataDetailsRel;
	}

	/**
	 * Removes the block week metadata details rel with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param blockWeekMetadataDetailsRelId the primary key of the block week metadata details rel
	 * @return the block week metadata details rel that was removed
	 * @throws NoSuchBlockWeekMetadataDetailsRelException if a block week metadata details rel with the primary key could not be found
	 */
	@Override
	public BlockWeekMetadataDetailsRel remove(
			long blockWeekMetadataDetailsRelId)
		throws NoSuchBlockWeekMetadataDetailsRelException {

		return remove((Serializable)blockWeekMetadataDetailsRelId);
	}

	/**
	 * Removes the block week metadata details rel with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the block week metadata details rel
	 * @return the block week metadata details rel that was removed
	 * @throws NoSuchBlockWeekMetadataDetailsRelException if a block week metadata details rel with the primary key could not be found
	 */
	@Override
	public BlockWeekMetadataDetailsRel remove(Serializable primaryKey)
		throws NoSuchBlockWeekMetadataDetailsRelException {

		Session session = null;

		try {
			session = openSession();

			BlockWeekMetadataDetailsRel blockWeekMetadataDetailsRel =
				(BlockWeekMetadataDetailsRel)session.get(
					BlockWeekMetadataDetailsRelImpl.class, primaryKey);

			if (blockWeekMetadataDetailsRel == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchBlockWeekMetadataDetailsRelException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(blockWeekMetadataDetailsRel);
		}
		catch (NoSuchBlockWeekMetadataDetailsRelException
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
	protected BlockWeekMetadataDetailsRel removeImpl(
		BlockWeekMetadataDetailsRel blockWeekMetadataDetailsRel) {

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(blockWeekMetadataDetailsRel)) {
				blockWeekMetadataDetailsRel =
					(BlockWeekMetadataDetailsRel)session.get(
						BlockWeekMetadataDetailsRelImpl.class,
						blockWeekMetadataDetailsRel.getPrimaryKeyObj());
			}

			if (blockWeekMetadataDetailsRel != null) {
				session.delete(blockWeekMetadataDetailsRel);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (blockWeekMetadataDetailsRel != null) {
			clearCache(blockWeekMetadataDetailsRel);
		}

		return blockWeekMetadataDetailsRel;
	}

	@Override
	public BlockWeekMetadataDetailsRel updateImpl(
		BlockWeekMetadataDetailsRel blockWeekMetadataDetailsRel) {

		boolean isNew = blockWeekMetadataDetailsRel.isNew();

		if (!(blockWeekMetadataDetailsRel instanceof
				BlockWeekMetadataDetailsRelModelImpl)) {

			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(
					blockWeekMetadataDetailsRel.getClass())) {

				invocationHandler = ProxyUtil.getInvocationHandler(
					blockWeekMetadataDetailsRel);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in blockWeekMetadataDetailsRel proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom BlockWeekMetadataDetailsRel implementation " +
					blockWeekMetadataDetailsRel.getClass());
		}

		BlockWeekMetadataDetailsRelModelImpl
			blockWeekMetadataDetailsRelModelImpl =
				(BlockWeekMetadataDetailsRelModelImpl)
					blockWeekMetadataDetailsRel;

		if (Validator.isNull(blockWeekMetadataDetailsRel.getUuid())) {
			String uuid = _portalUUID.generate();

			blockWeekMetadataDetailsRel.setUuid(uuid);
		}

		if (!blockWeekMetadataDetailsRelModelImpl.hasSetModifiedDate()) {
			ServiceContext serviceContext =
				ServiceContextThreadLocal.getServiceContext();

			Date date = new Date();

			if (serviceContext == null) {
				blockWeekMetadataDetailsRel.setModifiedDate(date);
			}
			else {
				blockWeekMetadataDetailsRel.setModifiedDate(
					serviceContext.getModifiedDate(date));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(blockWeekMetadataDetailsRel);
			}
			else {
				blockWeekMetadataDetailsRel =
					(BlockWeekMetadataDetailsRel)session.merge(
						blockWeekMetadataDetailsRel);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(
			BlockWeekMetadataDetailsRelImpl.class,
			blockWeekMetadataDetailsRelModelImpl, false, true);

		cacheUniqueFindersCache(blockWeekMetadataDetailsRelModelImpl);

		if (isNew) {
			blockWeekMetadataDetailsRel.setNew(false);
		}

		blockWeekMetadataDetailsRel.resetOriginalValues();

		return blockWeekMetadataDetailsRel;
	}

	/**
	 * Returns the block week metadata details rel with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the block week metadata details rel
	 * @return the block week metadata details rel
	 * @throws NoSuchBlockWeekMetadataDetailsRelException if a block week metadata details rel with the primary key could not be found
	 */
	@Override
	public BlockWeekMetadataDetailsRel findByPrimaryKey(Serializable primaryKey)
		throws NoSuchBlockWeekMetadataDetailsRelException {

		BlockWeekMetadataDetailsRel blockWeekMetadataDetailsRel =
			fetchByPrimaryKey(primaryKey);

		if (blockWeekMetadataDetailsRel == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchBlockWeekMetadataDetailsRelException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return blockWeekMetadataDetailsRel;
	}

	/**
	 * Returns the block week metadata details rel with the primary key or throws a <code>NoSuchBlockWeekMetadataDetailsRelException</code> if it could not be found.
	 *
	 * @param blockWeekMetadataDetailsRelId the primary key of the block week metadata details rel
	 * @return the block week metadata details rel
	 * @throws NoSuchBlockWeekMetadataDetailsRelException if a block week metadata details rel with the primary key could not be found
	 */
	@Override
	public BlockWeekMetadataDetailsRel findByPrimaryKey(
			long blockWeekMetadataDetailsRelId)
		throws NoSuchBlockWeekMetadataDetailsRelException {

		return findByPrimaryKey((Serializable)blockWeekMetadataDetailsRelId);
	}

	/**
	 * Returns the block week metadata details rel with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param blockWeekMetadataDetailsRelId the primary key of the block week metadata details rel
	 * @return the block week metadata details rel, or <code>null</code> if a block week metadata details rel with the primary key could not be found
	 */
	@Override
	public BlockWeekMetadataDetailsRel fetchByPrimaryKey(
		long blockWeekMetadataDetailsRelId) {

		return fetchByPrimaryKey((Serializable)blockWeekMetadataDetailsRelId);
	}

	/**
	 * Returns all the block week metadata details rels.
	 *
	 * @return the block week metadata details rels
	 */
	@Override
	public List<BlockWeekMetadataDetailsRel> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the block week metadata details rels.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>BlockWeekMetadataDetailsRelModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of block week metadata details rels
	 * @param end the upper bound of the range of block week metadata details rels (not inclusive)
	 * @return the range of block week metadata details rels
	 */
	@Override
	public List<BlockWeekMetadataDetailsRel> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the block week metadata details rels.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>BlockWeekMetadataDetailsRelModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of block week metadata details rels
	 * @param end the upper bound of the range of block week metadata details rels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of block week metadata details rels
	 */
	@Override
	public List<BlockWeekMetadataDetailsRel> findAll(
		int start, int end,
		OrderByComparator<BlockWeekMetadataDetailsRel> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the block week metadata details rels.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>BlockWeekMetadataDetailsRelModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of block week metadata details rels
	 * @param end the upper bound of the range of block week metadata details rels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of block week metadata details rels
	 */
	@Override
	public List<BlockWeekMetadataDetailsRel> findAll(
		int start, int end,
		OrderByComparator<BlockWeekMetadataDetailsRel> orderByComparator,
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

		List<BlockWeekMetadataDetailsRel> list = null;

		if (useFinderCache) {
			list = (List<BlockWeekMetadataDetailsRel>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_BLOCKWEEKMETADATADETAILSREL);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_BLOCKWEEKMETADATADETAILSREL;

				sql = sql.concat(
					BlockWeekMetadataDetailsRelModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<BlockWeekMetadataDetailsRel>)QueryUtil.list(
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
	 * Removes all the block week metadata details rels from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (BlockWeekMetadataDetailsRel blockWeekMetadataDetailsRel :
				findAll()) {

			remove(blockWeekMetadataDetailsRel);
		}
	}

	/**
	 * Returns the number of block week metadata details rels.
	 *
	 * @return the number of block week metadata details rels
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
					_SQL_COUNT_BLOCKWEEKMETADATADETAILSREL);

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
		return "block_week_metadata_details_rel_id";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_BLOCKWEEKMETADATADETAILSREL;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return BlockWeekMetadataDetailsRelModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the block week metadata details rel persistence.
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

		_finderPathWithPaginationFindByBlocksMetadataDetailRelId =
			new FinderPath(
				FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
				"findByBlocksMetadataDetailRelId",
				new String[] {
					Long.class.getName(), Integer.class.getName(),
					Integer.class.getName(), OrderByComparator.class.getName()
				},
				new String[] {"blocks_metadata_details_rel_id"}, true);

		_finderPathWithoutPaginationFindByBlocksMetadataDetailRelId =
			new FinderPath(
				FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
				"findByBlocksMetadataDetailRelId",
				new String[] {Long.class.getName()},
				new String[] {"blocks_metadata_details_rel_id"}, true);

		_finderPathCountByBlocksMetadataDetailRelId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByBlocksMetadataDetailRelId",
			new String[] {Long.class.getName()},
			new String[] {"blocks_metadata_details_rel_id"}, false);

		_setBlockWeekMetadataDetailsRelUtilPersistence(this);
	}

	@Deactivate
	public void deactivate() {
		_setBlockWeekMetadataDetailsRelUtilPersistence(null);

		entityCache.removeCache(
			BlockWeekMetadataDetailsRelImpl.class.getName());
	}

	private void _setBlockWeekMetadataDetailsRelUtilPersistence(
		BlockWeekMetadataDetailsRelPersistence
			blockWeekMetadataDetailsRelPersistence) {

		try {
			Field field =
				BlockWeekMetadataDetailsRelUtil.class.getDeclaredField(
					"_persistence");

			field.setAccessible(true);

			field.set(null, blockWeekMetadataDetailsRelPersistence);
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

	private static final String _SQL_SELECT_BLOCKWEEKMETADATADETAILSREL =
		"SELECT blockWeekMetadataDetailsRel FROM BlockWeekMetadataDetailsRel blockWeekMetadataDetailsRel";

	private static final String _SQL_SELECT_BLOCKWEEKMETADATADETAILSREL_WHERE =
		"SELECT blockWeekMetadataDetailsRel FROM BlockWeekMetadataDetailsRel blockWeekMetadataDetailsRel WHERE ";

	private static final String _SQL_COUNT_BLOCKWEEKMETADATADETAILSREL =
		"SELECT COUNT(blockWeekMetadataDetailsRel) FROM BlockWeekMetadataDetailsRel blockWeekMetadataDetailsRel";

	private static final String _SQL_COUNT_BLOCKWEEKMETADATADETAILSREL_WHERE =
		"SELECT COUNT(blockWeekMetadataDetailsRel) FROM BlockWeekMetadataDetailsRel blockWeekMetadataDetailsRel WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS =
		"blockWeekMetadataDetailsRel.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No BlockWeekMetadataDetailsRel exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No BlockWeekMetadataDetailsRel exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		BlockWeekMetadataDetailsRelPersistenceImpl.class);

	private static final Set<String> _badColumnNames = SetUtil.fromArray(
		new String[] {
			"uuid", "blockWeekMetadataDetailsRelId",
			"blocksMetadataDetailRelId", "weekNo", "weekStartDate",
			"weekEndDate", "groupId", "companyId", "createdDate", "createdBy",
			"modifiedDate", "modifiedBy"
		});

	@Override
	protected FinderCache getFinderCache() {
		return finderCache;
	}

	@Reference
	private PortalUUID _portalUUID;

}
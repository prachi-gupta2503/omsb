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

package gov.omsb.tms.service.impl;

import com.liferay.portal.aop.AopService;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

import java.util.Date;
import java.util.List;

import org.osgi.service.component.annotations.Component;

import gov.omsb.tms.model.BlockWeekMetadataDetailsRel;
import gov.omsb.tms.service.base.BlockWeekMetadataDetailsRelLocalServiceBaseImpl;

/**
 * @author Brian Wing Shun Chan
 */
@Component(
	property = "model.class.name=gov.omsb.tms.model.BlockWeekMetadataDetailsRel",
	service = AopService.class
)
public class BlockWeekMetadataDetailsRelLocalServiceImpl
	extends BlockWeekMetadataDetailsRelLocalServiceBaseImpl {
	
	public List<BlockWeekMetadataDetailsRel> findByBlocksMetadataDetailRelId(long blocksMetadataDetailRelId) {
		return blockWeekMetadataDetailsRelPersistence.findByBlocksMetadataDetailRelId(blocksMetadataDetailRelId);
	}

	public BlockWeekMetadataDetailsRel createBlockWeekMetadataDetailsRel(long blocksMetadataDetailRelId, Date weekStartDate, Date weekEndDate, String weekNo ,long userId, long groupId) {
        long id = counterLocalService.increment(getClass().getName(), 1);
        BlockWeekMetadataDetailsRel blockWeekMetadataDetailsRel = createBlockWeekMetadataDetailsRel(id);
        blockWeekMetadataDetailsRel.setBlocksMetadataDetailRelId(blocksMetadataDetailRelId);
        blockWeekMetadataDetailsRel.setWeekStartDate(weekStartDate);
        blockWeekMetadataDetailsRel.setWeekEndDate(weekEndDate);
        blockWeekMetadataDetailsRel.setWeekNo(weekNo);
        blockWeekMetadataDetailsRel.setGroupId(groupId);
        blockWeekMetadataDetailsRel.setCreatedBy(userId);
        blockWeekMetadataDetailsRel.setModifiedBy(userId);
        blockWeekMetadataDetailsRel.setCreatedDate(new Date());
        return addBlockWeekMetadataDetailsRel(blockWeekMetadataDetailsRel);
	}
	
	private static final Log _logger = LogFactoryUtil.getLog(BlockWeekMetadataDetailsRelLocalServiceImpl.class)		;
}
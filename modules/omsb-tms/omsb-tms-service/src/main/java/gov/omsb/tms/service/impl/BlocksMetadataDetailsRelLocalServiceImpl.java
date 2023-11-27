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
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.theme.ThemeDisplay;

import java.util.Date;
import java.util.List;

import org.osgi.service.component.annotations.Component;

import gov.omsb.tms.exception.NoSuchBlocksMetadataDetailsRelException;
import gov.omsb.tms.model.BlocksMetadataDetailsRel;
import gov.omsb.tms.service.base.BlocksMetadataDetailsRelLocalServiceBaseImpl;

/**
 * @author Brian Wing Shun Chan
 */
@Component(
	property = "model.class.name=gov.omsb.tms.model.BlocksMetadataDetailsRel",
	service = AopService.class
)
public class BlocksMetadataDetailsRelLocalServiceImpl
	extends BlocksMetadataDetailsRelLocalServiceBaseImpl {
	
	public List<BlocksMetadataDetailsRel> findByProgDurationTlBlocksLtId(long progDurationTlBlocksLtId) {
		return this.blocksMetadataDetailsRelPersistence.findByProgDurationTlBlocksLtId(progDurationTlBlocksLtId);
	}
	
	public BlocksMetadataDetailsRel findByProgDurationTlBlocksLtIdAndBlockStartDate(long progDurationTlBlocksLtId, Date blockStartDate) {
		BlocksMetadataDetailsRel detailsRel = null;
		_logger.error("findByProgDurationTlBlocksLtIdAndBlockStartDate Invoked ::: ");
		try {
			detailsRel = this.blocksMetadataDetailsRelPersistence.findByProgDurationTlBlocksLtIdAndBlockStartDate(progDurationTlBlocksLtId, blockStartDate);
		} catch (NoSuchBlocksMetadataDetailsRelException e) {
			_logger.error("findByProgDurationTlBlocksLtIdAndBlockStartDate ::: " + e);
		}
		_logger.error("findByProgDurationTlBlocksLtIdAndBlockStartDate Exit ::: ");
		return detailsRel;
	}
	
	public BlocksMetadataDetailsRel createBlockMetadataDetailsRel(String blockNo, Date blockStartDate, Date blockEndDate, long progDurationTlBlocksLtId, ThemeDisplay themeDisplay) {
        long id = counterLocalService.increment(getClass().getName(), 1);
        BlocksMetadataDetailsRel blocksMetadataDetailsRel = createBlocksMetadataDetailsRel(id);
        blocksMetadataDetailsRel.setBlockNo(blockNo);
        blocksMetadataDetailsRel.setBlockStartDate(blockStartDate);
        blocksMetadataDetailsRel.setBlockEndDate(blockEndDate);
        blocksMetadataDetailsRel.setProgDurationTlBlocksLtId(progDurationTlBlocksLtId);
        blocksMetadataDetailsRel.setGroupId(themeDisplay.getScopeGroupId());
        blocksMetadataDetailsRel.setCreateDate(new Date());
        blocksMetadataDetailsRel.setCreatedBy(themeDisplay.getUserId());
        blocksMetadataDetailsRel.setModifiedDate(new Date());
        blocksMetadataDetailsRel.setModifiedBy(themeDisplay.getUserId());
        
        return addBlocksMetadataDetailsRel(blocksMetadataDetailsRel);
    }
    
    public BlocksMetadataDetailsRel updateBlockMetadataDetailsRel(long blocksMetadataDetailsRelId, String blockNo, Date blockStartDate, Date blockEndDate, long progDurationTlBlocksLtId,ThemeDisplay themeDisplay) throws PortalException {
        BlocksMetadataDetailsRel blocksMetadataDetailsRel = getBlocksMetadataDetailsRel(blocksMetadataDetailsRelId);
        blocksMetadataDetailsRel.setBlockNo(blockNo);
        blocksMetadataDetailsRel.setBlockStartDate(blockStartDate);
        blocksMetadataDetailsRel.setBlockEndDate(blockEndDate);
        blocksMetadataDetailsRel.setProgDurationTlBlocksLtId(progDurationTlBlocksLtId);
        blocksMetadataDetailsRel.setModifiedDate(new Date());
        blocksMetadataDetailsRel.setModifiedBy(themeDisplay.getUserId());
        return updateBlocksMetadataDetailsRel(blocksMetadataDetailsRel);
    }
    
    private static final Log _logger = LogFactoryUtil.getLog(BlocksMetadataDetailsRelLocalServiceImpl.class.getName());
}
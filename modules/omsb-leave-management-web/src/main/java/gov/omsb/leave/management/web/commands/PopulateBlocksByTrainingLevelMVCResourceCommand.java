package gov.omsb.leave.management.web.commands;

import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCResourceCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCResourceCommand;
import com.liferay.portal.kernel.util.ParamUtil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import gov.omsb.leave.management.web.constants.OmsbLeaveManagementWebConstants;
import gov.omsb.leave.management.web.constants.OmsbLeaveManagementWebPortletKeys;
import gov.omsb.tms.model.BlockWeekMetadataDetailsRel;
import gov.omsb.tms.model.BlocksMetadataDetailsRel;
import gov.omsb.tms.model.ProgdurationTraineelevelBlocksLevelTypeRel;
import gov.omsb.tms.service.BlockWeekMetadataDetailsRelLocalService;
import gov.omsb.tms.service.BlocksMetadataDetailsRelLocalService;
import gov.omsb.tms.service.ProgdurationTraineelevelBlocksLevelTypeRelLocalService;
import gov.omsb.tms.service.ProgramDurationDetailsLocalService;
import gov.omsb.tms.service.TraineeLevelMasterLocalService;

@Component(
		immediate=true,
	    property = { 
	    	"javax.portlet.name=" + OmsbLeaveManagementWebPortletKeys.OMSBLEAVEMANAGEMENTWEB,
	        "mvc.command.name="+ OmsbLeaveManagementWebConstants.POPULATE_BLOCKS_DD
	    }, 
	    service = MVCResourceCommand.class
)
public class PopulateBlocksByTrainingLevelMVCResourceCommand extends BaseMVCResourceCommand{

	@Override
	protected void doServeResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse)
			throws Exception {
		
		long programId = ParamUtil.getLong(resourceRequest, OmsbLeaveManagementWebConstants.PROGRAM_ID);
		
		long traineeLevelId = ParamUtil.getLong(resourceRequest, OmsbLeaveManagementWebConstants.TRAINEE_LEVEL_ID);
		
		String availableAt = ParamUtil.getString(resourceRequest, OmsbLeaveManagementWebConstants.AVAILABLE_AT);
		
		//get trainee levels for that particular program
		List<Long> programDurationIdList = programDurationDetailsLocalService.getProgramDurationIdFromProgramIds(Arrays.asList(programId)); 
		long programDurationId = 0;
		long programDurationTLBlocksLTId = 0;
		List<BlocksMetadataDetailsRel> blocks = new ArrayList<>();
		List<BlockWeekMetadataDetailsRel> blockWeekList = new ArrayList<>();
		
		if(!programDurationIdList.isEmpty()) {
			programDurationId = programDurationIdList.get(0);
			
			log.info("Inside PopulateBlocksByTrainingLevelMVCResourceCommand :::::::::");
			log.info("programId::" + programId);
			log.info("traineeLevelId::" + traineeLevelId);
			DynamicQuery dqForTraineeLevels = progdurationTraineelevelBlocksLevelTypeRelLocalService.dynamicQuery();
			dqForTraineeLevels.add(RestrictionsFactoryUtil.eq("programDurationId", programDurationId));
			dqForTraineeLevels.add(RestrictionsFactoryUtil.eq("traineeLevelId", traineeLevelId));
			List<ProgdurationTraineelevelBlocksLevelTypeRel> programDurationMappingList = progdurationTraineelevelBlocksLevelTypeRelLocalService.dynamicQuery(dqForTraineeLevels);
			if(!programDurationMappingList.isEmpty()) {
				programDurationTLBlocksLTId = programDurationMappingList.get(0).getProgdurationTlBlocksLtId();
				
				log.info("programDurationTLBlocksLTId:::::::::::"+programDurationTLBlocksLTId);
				blocks = blocksMetadataDetailsRelLocalService.findByProgDurationTlBlocksLtId(programDurationTLBlocksLTId);
				
				if(OmsbLeaveManagementWebConstants.BLOCK_WEEK.equalsIgnoreCase(availableAt) && !blocks.isEmpty()) {
					//prepare for Block-week
					List<Long> blocksMetadataDetailRelIdList = blocks.stream().map(b -> b.getBlocksMetadataDetailsRelId()).collect(Collectors.toList());
					
					
					DynamicQuery dqForBlockWeek = blockWeekMetadataDetailsRelLocalService.dynamicQuery();
					dqForBlockWeek.add(RestrictionsFactoryUtil.in("blocksMetadataDetailRelId",blocksMetadataDetailRelIdList));
					blockWeekList = blockWeekMetadataDetailsRelLocalService.dynamicQuery(dqForBlockWeek);
					
				}
			}
		}
		
		JSONArray jsonArr = JSONFactoryUtil.createJSONArray();
		
		if(!blocks.isEmpty()) {
			if(!blockWeekList.isEmpty()) {
				
				String blockWeekStr;
				for(BlocksMetadataDetailsRel block : blocks) {
					blockWeekStr = block.getBlockNo();
					List<BlockWeekMetadataDetailsRel> blockWeek = blockWeekList.stream().filter(bw -> bw.getBlocksMetadataDetailRelId() == block.getBlocksMetadataDetailsRelId()).collect(Collectors.toList());
					for(BlockWeekMetadataDetailsRel bw : blockWeek) {
						JSONObject jsonObj = JSONFactoryUtil.createJSONObject();
						jsonObj.put("blockId", bw.getBlockWeekMetadataDetailsRelId());
						jsonObj.put("blockName",String.valueOf(blockWeekStr + StringPool.SPACE + bw.getWeekNo()));
						
						jsonArr.put(jsonObj);
					}
				}
			}
			else {
				for (BlocksMetadataDetailsRel blocksMetadataDetailsRel : blocks) {
					JSONObject jsonObj = JSONFactoryUtil.createJSONObject();
					jsonObj.put("blockId", blocksMetadataDetailsRel.getBlocksMetadataDetailsRelId());
					jsonObj.put("blockName", blocksMetadataDetailsRel.getBlockNo());
					
					jsonArr.put(jsonObj);
				}
			}
		}
		
		log.info(jsonArr.toString());
		resourceResponse.getWriter().write(jsonArr.toString());
	}
	
	@Reference
	private TraineeLevelMasterLocalService traineeLevelMasterLocalService;
	
	@Reference
	private ProgramDurationDetailsLocalService programDurationDetailsLocalService;
	
	@Reference
	private ProgdurationTraineelevelBlocksLevelTypeRelLocalService progdurationTraineelevelBlocksLevelTypeRelLocalService;
	
	@Reference
	private BlocksMetadataDetailsRelLocalService blocksMetadataDetailsRelLocalService;
	
	@Reference
	private BlockWeekMetadataDetailsRelLocalService blockWeekMetadataDetailsRelLocalService;
	
	private Log log = LogFactoryUtil.getLog(PopulateBlocksByTrainingLevelMVCResourceCommand.class.getName());

}

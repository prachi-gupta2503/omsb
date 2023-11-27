package gov.omsb.master.web.action;

import com.liferay.object.model.ObjectEntry;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.WebKeys;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import gov.omsb.common.api.OMSBCommonApi;
import gov.omsb.http.connector.api.OMSBHttpConnector;
import gov.omsb.master.web.constants.MVCCommandNames;
import gov.omsb.master.web.constants.OmsbExamMasterConstants;
import gov.omsb.master.web.constants.OmsbMasterPortletKeys;

@Component(immediate = true, property = { "javax.portlet.name=" + OmsbMasterPortletKeys.OMSBMASTER,
		"mvc.command.name=" + MVCCommandNames.SAVE_WORK_SECTOR_MASTER_MVC_ACTION_COMMAND, }, service = MVCActionCommand.class)
public class SaveWorkSectorMasterMVCActionCommad implements MVCActionCommand{

	@Override
	public boolean processAction(ActionRequest actionRequest, ActionResponse actionResponse) throws PortletException {
		logger.info("SaveWorkSectorMasterMVCActionCommad Started ()");
		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
		long workSectorType = ParamUtil.getLong(actionRequest, "workSectorType");
		long workSectorTypeName = ParamUtil.getLong(actionRequest, "workSectorTypeNameId");
		long workSectorTypeNameParent = ParamUtil.getLong(actionRequest, "workSectorTypeParentId");
		long workSectorTypeParentChild = ParamUtil.getLong(actionRequest, "workSectorTypeParentId_1");
		String value = ParamUtil.getString(actionRequest, "workSectorValue","Test Value");
		logger.info("workSectorType "+workSectorType);
		logger.info("workSectorTypeName "+workSectorTypeName);
		logger.info("workSectorTypeNameParent "+workSectorTypeNameParent);
		logger.info("workSectorTypeParentChild "+workSectorTypeParentChild);
		long id = 0;
		if(workSectorTypeParentChild > 0 ) {
			id = workSectorTypeParentChild;
		} else if (workSectorTypeNameParent > 0) {
			id = workSectorTypeNameParent;
		}  else if (workSectorTypeName > 0) {
			id = workSectorTypeName;
		}
		try {
		Map<String, Serializable> values = new HashMap<>();
		values.put("workSectorType", workSectorType);
		values.put("workSectorParentId", id);
		values.put("workSector", value);
		ObjectEntry objectEntry = commonApi.addObjectEntryByERC(
				OmsbExamMasterConstants.OB_WORK_SECTOR_MASTER_ERC, values, actionRequest, themeDisplay);
		}catch(Exception e) {
			logger.error("error in saving "+e.getMessage(),e);
		}
		
		logger.info("SaveWorkSectorMasterMVCActionCommad Ended ()");
		return false;
	}
	
	@Reference
	private OMSBCommonApi commonApi;
	@Reference
	private OMSBHttpConnector omsbHttpConnector;
	
	private static final Log logger = LogFactoryUtil.getLog(SaveWorkSectorMasterMVCActionCommad.class);
	
}

package omsb.vehpc.equivalency.mvc.commands.web;

import com.liferay.list.type.model.ListTypeEntry;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.service.RoleLocalService;
import com.liferay.portal.kernel.service.UserLocalService;
import com.liferay.portal.kernel.service.UserNotificationEventLocalService;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;

import java.util.Map;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import gov.omsb.common.api.OMSBCommonApi;
import gov.omsb.common.object.url.LRObjectURL;
import gov.omsb.common.picklist.constants.LRPicklistConstants;
import gov.omsb.http.connector.api.OMSBHttpConnector;
import omsb.vehpc.equivalency.dto.web.EquivalencyRequest;
import omsb.vehpc.equivalency.dto.web.EquivalencyRequestStatus;
import omsb.vehpc.equivalency.dto.web.EquivalencyStatus;
import omsb.vehpc.equivalency.util.EquivalencyUtil;
import omsb.vehpc.equivalency.web.constants.EquivalencyWFConstants;
import omsb.vehpc.equivalency.web.constants.MVCCommandNames;
import omsb.vehpc.equivalency.web.constants.OmsbVehpcEquivalencyWebPortletKeys;

@Component(
		immediate=true,
	    property = { 
	    	"javax.portlet.name=" + OmsbVehpcEquivalencyWebPortletKeys.OMSBVEHPCEQUIVALENCYWEB,
	        "mvc.command.name="+MVCCommandNames.ADMIN_INPROGRESS_ACTION
	    }, 
	    service = MVCActionCommand.class
)
public class AdminInProgressMVCActionCommand extends BaseMVCActionCommand {

	@Override
	protected void doProcessAction(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {
		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
		String comments = ParamUtil.getString(actionRequest, "comments");
		long equivalencyRequestId = ParamUtil.getLong(actionRequest, "equivalencyRequestId");
		EquivalencyRequest eqRequest = equivalencyUtil.getEquivalencyRequestById(equivalencyRequestId);
		long personId = 0;
		long equivalencyStatusId = 0;
		if (Validator.isNotNull(eqRequest)) {
			personId = eqRequest.getPersonId();
		}
		logger.info("equivalencyRequestId ?? " + equivalencyRequestId + "  ::: personId ?? " + personId);
		logger.info("comments ?? " + comments);
		EquivalencyStatus equivalencyStatus = new EquivalencyStatus();
		ListTypeEntry listTypeEntry = commonApi.getListTypeEntryByListTypeItemKey(LRPicklistConstants.PL_EQUIVALENCY_STATUS, 
				EquivalencyWFConstants.INPROGRESS_ADMIN_KEY, themeDisplay.getCompanyId());
		if (Validator.isNotNull(listTypeEntry)) {
			equivalencyStatus.setKey(EquivalencyWFConstants.INPROGRESS_ADMIN_KEY);
			equivalencyStatus.setName(listTypeEntry.getName(themeDisplay.getLocale()));
			equivalencyStatusId = listTypeEntry.getListTypeEntryId();
		}
		
		EquivalencyRequestStatus equivalencyRequestStatus = new EquivalencyRequestStatus();
		equivalencyRequestStatus.setComments(comments);
		equivalencyRequestStatus.setCommenterUserId(themeDisplay.getUserId());
		equivalencyRequestStatus.setEquivalencyRequestId(equivalencyRequestId);
		equivalencyRequestStatus.setEquivalencyStatusId(equivalencyStatus);

		EquivalencyRequestStatus status = equivalencyUtil.updateEqStatusToEqRequestStatus(equivalencyRequestStatus, themeDisplay.getScopeGroupId(), commonApi.getHttpHeaderInfoAndBasicAuth());
		long equivalencyRequestStatusId = 0;
		if (Validator.isNotNull(status)) {
			equivalencyRequestStatusId = status.getId();
		}
		updateEqRequest(eqRequest, equivalencyStatusId, commonApi.getHttpHeaderInfoAndBasicAuth());
		equivalencyUtil.uploadDocuments(equivalencyRequestId, 0, themeDisplay,  actionRequest, personId, equivalencyRequestStatusId,
				"adminInProgressAttachment", OmsbVehpcEquivalencyWebPortletKeys.IN_PROGRESS_DOCUMENTS_TYPE);
	}
	
	
	private void updateEqRequest(EquivalencyRequest eqRequest, long equivalencyStatusId, Map<String, String> headersInfo) {
		JSONObject object = JSONFactoryUtil.createJSONObject();
		object.put("equivalencyStatusId", equivalencyStatusId);
		String url = commonApi.getBaseURL() + LRObjectURL.GET_EQUIVALENCY_REQUEST_BY_ID_URL + eqRequest.getId();
		logger.info("updateEqRequest url ?? " + url);
		httpConnector.executePut(url, object.toString(), headersInfo);
	}
	
	private static final Log logger = LogFactoryUtil.getLog(AdminInProgressMVCActionCommand.class);

	@Reference(unbind = "-")
	private OMSBCommonApi commonApi;

	@Reference(unbind = "-")
	private OMSBHttpConnector httpConnector;
	
	@Reference(unbind = "-")
	private EquivalencyUtil equivalencyUtil;
	
	@Reference
	private RoleLocalService roleLocalService;

	@Reference
	private UserLocalService userLocalService;
	
	@Reference
	private UserNotificationEventLocalService eventLocalService;

}

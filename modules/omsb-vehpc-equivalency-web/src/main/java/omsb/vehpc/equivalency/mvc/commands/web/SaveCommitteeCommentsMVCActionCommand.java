package omsb.vehpc.equivalency.mvc.commands.web;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.LiferayWindowState;
import com.liferay.portal.kernel.portlet.PortletURLFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;

import java.util.Map;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletRequest;
import javax.portlet.PortletURL;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import gov.omsb.common.api.OMSBCommonApi;
import gov.omsb.http.connector.api.OMSBHttpConnector;
import omsb.vehpc.equivalency.dto.web.EquivalencyRequestStatus;
import omsb.vehpc.equivalency.dto.web.EquivalencyStatus;
import omsb.vehpc.equivalency.util.EquivalencyUtil;
import omsb.vehpc.equivalency.web.constants.MVCCommandNames;
import omsb.vehpc.equivalency.web.constants.OmsbVehpcEquivalencyWebPortletKeys;

@Component(immediate = true, property = {
		"javax.portlet.name=" + OmsbVehpcEquivalencyWebPortletKeys.OMSBVEHPCEQUIVALENCYWEB,
		"mvc.command.name=" + MVCCommandNames.SAVE_COMMITTEE_COMMENTS }, service = MVCActionCommand.class

)
public class SaveCommitteeCommentsMVCActionCommand extends BaseMVCActionCommand {

	private static final Log _log = LogFactoryUtil.getLog(SaveCommitteeCommentsMVCActionCommand.class);

	@Override
	protected void doProcessAction(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {

		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
		/** ===== Add New Record === **/
		String comments = ParamUtil.getString(actionRequest, "committeeComments");
		Map<String, String> headersInfo = commonApi.getHttpHeaderInfoAndBasicAuth();

		long classPK = ParamUtil.getLong(actionRequest, "classPK");
		long personId = ParamUtil.getLong(actionRequest, "personId");
		String equivalencyLevel = ParamUtil.getString(actionRequest, "equivalencyLevel");
		String equivalencyLevelReason = ParamUtil.getString(actionRequest, "equivalencyLevelReason");
		String equivalencyCertificate = ParamUtil.getString(actionRequest, "equivalencyCertificate");

		ObjectMapper objectMapper = new ObjectMapper();
		objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

		EquivalencyStatus equivalencyStatus = new EquivalencyStatus();
		equivalencyStatus.setKey(ParamUtil.getString(actionRequest, "eqStatusKey"));
		equivalencyStatus.setName(ParamUtil.getString(actionRequest, "eqStatusName"));
		EquivalencyRequestStatus equivalencyRequestStatus = new EquivalencyRequestStatus();
		equivalencyRequestStatus.setComments(comments);
		equivalencyRequestStatus.setCommenterUserId(themeDisplay.getUserId());
		equivalencyRequestStatus.setEquivalencyRequestId(classPK);
		equivalencyRequestStatus.setEquivalencyStatusId(equivalencyStatus);
		equivalencyRequestStatus.setEquivalencyLevel(equivalencyLevel);
		equivalencyRequestStatus.setEquivalencyLevelReason(equivalencyLevelReason);
		equivalencyRequestStatus.setEquivalencyCertificate(equivalencyCertificate);
		EquivalencyRequestStatus status = equivalencyUtil.updateEqStatusToEqRequestStatus(equivalencyRequestStatus,
				themeDisplay.getScopeGroupId(), headersInfo);
		long equivalencyRequestStatusId = 0;
		if (Validator.isNotNull(status)) {
			equivalencyRequestStatusId = status.getId();
		}
		equivalencyUtil.uploadDocuments(classPK, 0, themeDisplay, actionRequest, personId, equivalencyRequestStatusId,
				"additionalCommentsFile", OmsbVehpcEquivalencyWebPortletKeys.COMMITTEE_COMMENTS_DOCUMENTS_TYPE);

		PortletURL renderUrl = PortletURLFactoryUtil.create(actionRequest, themeDisplay.getPortletDisplay().getId(),
				themeDisplay.getPlid(), PortletRequest.RENDER_PHASE);
		renderUrl.setWindowState(LiferayWindowState.NORMAL);
		renderUrl.setParameter("mvcRenderCommandName", MVCCommandNames.EQUIVALENCY_VIEW);
		renderUrl.setParameter("equivalencyRequestId", String.valueOf(classPK));
		actionResponse.sendRedirect(renderUrl.toString());
	}

	@Reference(unbind = "_")
	private OMSBCommonApi commonApi;

	@Reference(unbind = "_")
	private OMSBHttpConnector httpConnector;

	@Reference
	private EquivalencyUtil equivalencyUtil;
}

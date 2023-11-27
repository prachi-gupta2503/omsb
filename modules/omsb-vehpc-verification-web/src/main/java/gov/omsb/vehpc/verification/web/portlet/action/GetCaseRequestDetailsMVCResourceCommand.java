package gov.omsb.vehpc.verification.web.portlet.action;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCResourceCommand;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;

import java.io.IOException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

import javax.portlet.PortletException;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import gov.omsb.common.api.OMSBCommonApi;
import gov.omsb.common.constants.DataflowConstants;
import gov.omsb.common.object.url.LRObjectURL;
import gov.omsb.common.util.CustomObjectMapperUtil;
import gov.omsb.verification.dto.CaseRequest;
import gov.omsb.verification.dto.CaseRequestItem;
import gov.omsb.verification.dto.CaseStatus;
import gov.omsb.verification.dto.LoggedUserDetails;
import gov.omsb.verification.dto.PersonalDetail;
import gov.omsb.verification.dto.PersonalDetailItem;
import omsb.vehpc.verification.web.constants.MVCCommands;
import omsb.vehpc.verification.web.constants.OmsbVehpcVerificationWebPortletKeys;
import omsb.vehpc.verification.web.portlet.OmsbVehpcVerificationWebPortlet;

@Component(
		immediate=true,
	    property = { 
	    	"javax.portlet.name=" + OmsbVehpcVerificationWebPortletKeys.OMSBVEHPCVERIFICATIONWEB,
	        "mvc.command.name="+MVCCommands.GET_CASE_REQUEST_DETAILS
	    }, 
	    service = MVCResourceCommand.class
	    
)
public class GetCaseRequestDetailsMVCResourceCommand implements MVCResourceCommand {
	@Override
	public boolean serveResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse)
			throws PortletException {
		ThemeDisplay themeDisplay = (ThemeDisplay) resourceRequest.getAttribute(WebKeys.THEME_DISPLAY);
		try {
			List<LoggedUserDetails> itemList = new ArrayList<>();
			String CaseRequestUrlByPersonId = themeDisplay.getPortalURL() + LRObjectURL.CASE_REQUEST_URL.replace("{scope-id}", String.valueOf(themeDisplay.getScopeGroupId())) + StringPool.QUESTION + "filter=personId" + URLEncoder.encode(" eq " + String.valueOf(ParamUtil.getString(resourceRequest,"personId")), DataflowConstants.UTF_8)+OmsbVehpcVerificationWebPortletKeys.PAGE_SIZE_WITH_FILTER;
			CaseRequest caseRequest = CustomObjectMapperUtil.readValue(omsbCommonApi.getData(CaseRequestUrlByPersonId), CaseRequest.class);
			if(Validator.isNotNull(caseRequest)) {
				List<CaseRequestItem> caseRequestItems = caseRequest.getItems();
				if(caseRequestItems.size()>0) {
					String personalDetailsByPersonId = themeDisplay.getPortalURL() + LRObjectURL.PERSONAL_DETAIL_URL.replace("{scope-id}", String.valueOf(themeDisplay.getScopeGroupId())) + StringPool.QUESTION + "filter=personId" + URLEncoder.encode(" eq " + String.valueOf(ParamUtil.getString(resourceRequest,"personId")), DataflowConstants.UTF_8)+OmsbVehpcVerificationWebPortletKeys.PAGE_SIZE_WITH_FILTER;
					PersonalDetail personalDetail = CustomObjectMapperUtil.readValue(omsbCommonApi.getData(personalDetailsByPersonId), PersonalDetail.class);
					List<PersonalDetailItem> personalDetailItems = personalDetail.getItems();
					for(CaseRequestItem caseRequestItem : caseRequestItems) {
						String caseStatusUrl = themeDisplay.getPortalURL() + LRObjectURL.CASE_STATUS_URL.replace("{scope-id}", String.valueOf(themeDisplay.getScopeGroupId())) + StringPool.QUESTION + "filter=id" + URLEncoder.encode(" eq " + "'" + String.valueOf(caseRequestItem.getCaseStatusId()) + "'", "UTF-8")+OmsbVehpcVerificationWebPortletKeys.PAGE_SIZE_WITH_FILTER;
						CaseStatus caseStatus = CustomObjectMapperUtil.readValue(omsbCommonApi.getData(caseStatusUrl), CaseStatus.class);
						LoggedUserDetails item = new LoggedUserDetails();
						if(personalDetailItems.size()>0) {
							item.setName(personalDetailItems.get(0).getGivenNameAsPassport());
						} 
						item.setDfrn(caseRequestItem.getCaseNumber());
						item.setVerificationDate(caseRequestItem.getVerificationDate().toString());
						item.setCaseRequestId(String.valueOf(caseRequestItem.getId()));
						if(caseStatus.getItems() != null && !caseStatus.getItems().isEmpty()) {
							item.setStatus(caseStatus.getItems().get(0).getCaseStatus().getName());
						}
						itemList.add(item);
					}
				}
			}
			resourceResponse.getWriter().print(new ObjectMapper().writeValueAsString(itemList));
			//resourceResponse.getWriter().print(new ObjectMapper().writeValueAsString(omsbCommonApi.getCaseRequest(ParamUtil.getString(resourceRequest,"personId"), String.valueOf(PortalUtil.getScopeGroupId(resourceRequest)))));
			return Boolean.FALSE;
		} catch (IOException e) {	
			_log.error("Error while fetching caseRequestDetails, "+e.getMessage());
			return Boolean.FALSE;
		}
	}
	private static final Log _log = LogFactoryUtil.getLog(OmsbVehpcVerificationWebPortlet.class);
	@Reference 
	private OMSBCommonApi omsbCommonApi;		
}

package gov.omsb.vehpc.verification.web.portlet.action;

import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import gov.omsb.common.api.OMSBCommonApi;
import gov.omsb.common.constants.DataflowConstants;
import gov.omsb.common.object.url.LRObjectURL;
import gov.omsb.common.util.CustomObjectMapperUtil;
import gov.omsb.vehpc.verification.util.VerificationUtil;
import gov.omsb.verification.dto.CaseRequest;
import gov.omsb.verification.dto.CaseRequestItem;
import gov.omsb.verification.dto.CaseStatusItem;
import gov.omsb.verification.dto.Person;
import gov.omsb.verification.dto.PersonalDetail;
import omsb.vehpc.verification.web.constants.MVCCommands;
import omsb.vehpc.verification.web.constants.OmsbVehpcVerificationWebPortletKeys;
import omsb.vehpc.verification.web.constants.VerificationJSPPath;
import omsb.vehpc.verification.web.portlet.OmsbVehpcVerificationWebPortlet;

@Component(
		immediate=true,
	    property = { 
	    	"javax.portlet.name=" + OmsbVehpcVerificationWebPortletKeys.OMSBVEHPCVERIFICATIONWEB,
	        "mvc.command.name=" + MVCCommands.SEARCH_VERIFICATION
	    }, 
	    service = MVCRenderCommand.class
	    
)
public class SearchVerificationMVCRenderCommand implements MVCRenderCommand{

	@Override
	public String render(RenderRequest renderRequest, RenderResponse renderResponse) {
		ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);
		Person person=null;
		String status="";
		List<Person> persons = new ArrayList<>();
			try {
				person=verificationUtil.fetchPersonByPassport(themeDisplay);
			} catch (UnsupportedEncodingException e) {
				_log.error(e.getMessage());
				_log.trace(e);
			}
			if(Validator.isNotNull(person) && Validator.isNotNull(person.getItems()) && !person.getItems().isEmpty()) {
			long personId = person.getItems().get(0).getId();
				String caseRequestUrl;
				CaseRequest caseRequest=null;
				try {
					caseRequestUrl = themeDisplay.getPortalURL() + LRObjectURL.CASE_REQUEST_URL.replace("{scope-id}", String.valueOf(themeDisplay.getScopeGroupId()))+StringPool.QUESTION + "filter=personId"+URLEncoder.encode(" eq " +  personId  , DataflowConstants.UTF_8)+OmsbVehpcVerificationWebPortletKeys.PAGE_SIZE_WITH_FILTER;
					String caseRequestResponse = omsbCommonApi.getData(caseRequestUrl);
					_log.info(caseRequestUrl+"caseRequestResponse:::::::::::"+caseRequestResponse);
					caseRequest =  CustomObjectMapperUtil.readValue(caseRequestResponse, CaseRequest.class);
				} catch (UnsupportedEncodingException e) {
					_log.error(e.getMessage());
					_log.trace(e);
				}
				PersonalDetail personalDetails = verificationUtil.fetchPersonalDetailsByPersonId(personId, themeDisplay);
				_log.info("personalDetails:::::::::::"+personalDetails);
				if(Validator.isNotNull(caseRequest) && Validator.isNotNull(caseRequest.getItems()) && !caseRequest.getItems().isEmpty()) {
					long caseStatusId = caseRequest.getItems().get(0).getCaseStatusId();
					CaseStatusItem caseStatusItem=null;
					try {
						caseStatusItem= verificationUtil.fetchCaseStatusByCaseStatusId(caseStatusId,themeDisplay);
					} catch (UnsupportedEncodingException e) {
						_log.error(e.getMessage());
						_log.trace(e);
					}
					
					if(Validator.isNotNull(caseStatusItem) && Validator.isNotNull(caseStatusItem.getCaseStatus()) && !(caseStatusItem.getCaseStatus().getName().isEmpty())){
						status = caseStatusItem.getCaseStatus().getName();
					}
					_log.info("finnnnnnnnn caseStatusItem::"+caseStatusItem);
					
				}
				Date verificationDate = null;
				long caseRequestId = 0; 
				String name = null; String dfrn= null;
				if(Validator.isNotNull(caseRequest) && caseRequest.getItems().size()>0) {
					for(CaseRequestItem caseRequestObj : caseRequest.getItems()) {
						if(Validator.isNotNull(personalDetails) && personalDetails.getItems().size()>0) {
							name = personalDetails.getItems().get(0).getGivenNameAsPassport();
						}
						Person personObj = verificationUtil.addPersonDeatails(name,caseRequestObj.getCaseNumber(),status,caseRequestObj.getId(),omsbCommonApi.convertObjectDateToDDMMYYYYDate(caseRequestObj.getVerificationDate()));
						_log.info("personObj:::::ddddddddddddd:::::"+personObj);
						personObj.setPersonId(personId);
						personObj.setRedirect(true);
						
						persons.add(personObj);
					}
				}
				
				
			}
			_log.info("persons::::::::::"+persons.size());
			renderRequest.setAttribute("persons", persons);
			
		return VerificationJSPPath.SEARCH_VERIFICATION_JSP;
	}
	
	
	@Reference(unbind = "_")
	private OMSBCommonApi omsbCommonApi;
	
	@Reference(unbind = "_")
	private VerificationUtil verificationUtil;
	
	private static final Log _log = LogFactoryUtil.getLog(OmsbVehpcVerificationWebPortlet.class);
}

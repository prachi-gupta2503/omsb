package gov.omsb.tms.ecm.web.commands;

import static gov.omsb.tms.ecm.web.constants.ECMembershipRequestPortletKeys.EQ;
import static gov.omsb.tms.ecm.web.constants.ECMembershipRequestPortletKeys.UNICODE_TRANSFORMATION_FORMAT;

import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCResourceCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCResourceCommand;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.io.Writer;
import java.net.URLEncoder;
import java.util.List;

import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import gov.omsb.common.api.OMSBCommonApi;
import gov.omsb.common.constants.DataflowConstants;
import gov.omsb.common.dto.Person;
import gov.omsb.common.dto.PersonItem;
import gov.omsb.common.object.url.LRObjectURL;
import gov.omsb.common.util.CustomObjectMapperUtil;
import gov.omsb.tms.ecm.web.constants.ECMembershipRequestPortletKeys;
import gov.omsb.tms.ecm.web.dto.PotentialMemberAffiliationDTO;
import gov.omsb.tms.ecm.web.dto.ViewEcMemberRequestDTO;
import gov.omsb.tms.ecm.web.util.MembershipUtil;

@Component(immediate = true, property = {
		"javax.portlet.name=" + ECMembershipRequestPortletKeys.ECMEMBERSHIPREQUEST,
		"mvc.command.name=getAffiliationData" }, service = MVCResourceCommand.class)
public class GetPersonRelatedDataResourceCommand extends BaseMVCResourceCommand {

	@Override
	protected void doServeResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse)
			throws Exception {
		ThemeDisplay themeDisplay = (ThemeDisplay) resourceRequest.getAttribute(WebKeys.THEME_DISPLAY);

		log.info("called GetPersonRelatedDataResourceCommand resouce command");
		long personId = ParamUtil.getLong(resourceRequest, "personId");
		Person person = fetchPersonByPersonId(personId,themeDisplay);
		
		ViewEcMemberRequestDTO viewEcMemberRequestDTO = new ViewEcMemberRequestDTO();
		List<PotentialMemberAffiliationDTO> potentialMemberAffiliationDTOList = getAffiliations(person,viewEcMemberRequestDTO,themeDisplay);
		
		Writer wtr = null;
		try {
			String request = JSONFactoryUtil.looseSerializeDeep(potentialMemberAffiliationDTOList);
			wtr = resourceResponse.getWriter();
			wtr.write(request);
		} catch (IOException e) {
			e.printStackTrace();
		}
		log.info("GetPotentialMemberAffiliationData " +potentialMemberAffiliationDTOList.toString());
	}
	
	private Person fetchPersonByPersonId(long personId, ThemeDisplay themeDisplay) throws UnsupportedEncodingException {
		String personDetailsUrl = generateScopeListURL(LRObjectURL.GET_PERSON_BY_ID_URL,themeDisplay.getScopeGroupId()) + StringPool.QUESTION + "filter=id" + URLEncoder.encode(EQ + "'"+ personId + "'" , UNICODE_TRANSFORMATION_FORMAT);
		String personDetailsResponse = omsbCommonApi.getData(personDetailsUrl);
		PersonItem personItems = CustomObjectMapperUtil.readValue(personDetailsResponse, PersonItem.class);
		Person person = null;
		if(Validator.isNotNull(personItems) && Validator.isNotNull(personItems.getItems()) && personItems.getItems().size()>0) {
			person = personItems.getItems().get(0);
		}
		return person;
	}
	
	private String generateScopeListURL(String personRequestsUrl, long siteId) {
		return omsbCommonApi.getBaseURL() + personRequestsUrl.replace(DataflowConstants.SCOPE_ID_VAR, String.valueOf(siteId));
	}
		
	
	public List<PotentialMemberAffiliationDTO> getAffiliations(Person person ,ViewEcMemberRequestDTO viewEcMemberRequestDTO,ThemeDisplay themeDisplay) throws UnsupportedEncodingException {
		List<PotentialMemberAffiliationDTO> potentialMemberAffiliationDTO  = membershipUtil.getPotentialMemberAffiliationData(person, themeDisplay);
		return potentialMemberAffiliationDTO;
	}
		
	
	


@Reference(unbind = "-")
private OMSBCommonApi omsbCommonApi;


@Reference(unbind = "-")
private MembershipUtil membershipUtil;

private static final Log log = LogFactoryUtil.getLog(GetPersonRelatedDataResourceCommand.class);


}

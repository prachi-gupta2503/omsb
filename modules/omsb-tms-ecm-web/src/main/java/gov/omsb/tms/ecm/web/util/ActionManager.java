package gov.omsb.tms.ecm.web.util;

import com.liferay.portal.kernel.language.LanguageUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import gov.omsb.tms.ecm.web.constants.WorkflowConstants;
import gov.omsb.tms.ecm.web.dto.ActionDetail;

public class ActionManager implements Serializable{

	private static final long serialVersionUID = 6178461805816348707L;
	
	private static Map<String, List<ActionDetail>> statusActionMap= new HashMap<String, List<ActionDetail>>();
	private static Map<String, String> transitionLevels= new HashMap<String, String>();
	private static final Log LOGGER = LogFactoryUtil.getLog(ActionManager.class);
	
	
	static {
		initRoleActionMap();
		initTransitionLevels();
	}
	//map initialization
	private static void initRoleActionMap(){
		List<ActionDetail> actions = new ArrayList<>();
		actions.add(new ActionDetail(WorkflowConstants.ACTION_ADJUDICATE_REQUEST, "reviewMemberDetails", "Adjudicate EC Membership request"));
		actions.add(new ActionDetail(WorkflowConstants.ACTION_DISTRIBUTION_REPORT, "viewDistributionReport", "Report of site/rotation/faculty/trainee distribution"));
		actions.add(new ActionDetail(WorkflowConstants.ACTION_VIEW_INCENTIVE_REPORT, "viewIncentiveReport", "Report of faculty/site/compensation"));
		statusActionMap.put("EC_SECTION_STAFF",actions);
		
		//REJECTED
		actions = new ArrayList<>();
		actions.add(new ActionDetail(WorkflowConstants.ACTION_EDIT_MEMBERSHIP_REQUEST, "viewEditDetails", "Edit EC Membership request details"));
		statusActionMap.put("REJECTED",actions);
		
		actions = new ArrayList<>();
		actions.add(new ActionDetail(WorkflowConstants.ACTION_ADJUDICATE_REQUEST, "reviewMemberDetails", "Adjudicate EC Membership request"));
		statusActionMap.put("EC_SECTION_HEAD",actions);
		
		actions = new ArrayList<>();
		actions.add(new ActionDetail(WorkflowConstants.ACTION_ADJUDICATE_REQUEST, "gmeDirectorsReview", "Adjudicate EC Membership request: GME Director"));
		statusActionMap.put("GME_DIRECTOR",actions);
		
		actions = new ArrayList<>();
		actions.add(new ActionDetail(WorkflowConstants.ACTION_ADJUDICATE_REQUEST, "reviewMemberDetails", "Adjudicate EC Membership request"));
		statusActionMap.put("VPAA",actions);
		
		actions = new ArrayList<>();
		actions.add(new ActionDetail(WorkflowConstants.ACTION_ADJUDICATE_REQUEST, "reviewMemberDetails", "Adjudicate EC Membership request"));
		statusActionMap.put("PRESIDENT",actions);
		
		actions = new ArrayList<>();
		actions.add(new ActionDetail(WorkflowConstants.ACTION_UPLOAD_NOC, "uploadNOCView", "Add No Objection Letter"));
		statusActionMap.put("NOC",actions);
		
		actions = new ArrayList<>();
		actions.add(new ActionDetail(WorkflowConstants.ACTION_GENERATE_QARAR, "generateQararView", "Generate Qarar"));
		statusActionMap.put("GENERATE_QARAR",actions);
		
		actions = new ArrayList<>();
		statusActionMap.put("QARAR_REQUESTED",actions);
		
		actions = new ArrayList<>();
		actions.add(new ActionDetail(WorkflowConstants.ACTION_MEMBER_DETAILS_REQUEST, "requestMemberDetails", "Request member details"));
		statusActionMap.put("QARAR_GENERATED",actions);
		
		actions = new ArrayList<>();
		actions.add(new ActionDetail(WorkflowConstants.ACTION_ENTER_MEMBERSHIP_DETAILS, "addMembershipDetailsView", "Add/Edit member details"));
		statusActionMap.put("MEMBER_DETAILS_ENTRY",actions);
		
		actions = new ArrayList<>();
		actions.add(new ActionDetail(WorkflowConstants.ACTION_ENTER_MEMBERSHIP_DETAILS, "addMembershipDetailsView", "Add/Edit member details"));
		statusActionMap.put("MEMBER_DETAILS_ENTRY:EDIT",actions);
		
		actions = new ArrayList<>();
		actions.add(new ActionDetail(WorkflowConstants.ACTION_VIEW_MEMBER_DETAILS, "viewMemberDetails", "View Member Details"));
		actions.add(new ActionDetail("ec-member-request-review-member-details", "reviewMemberDetails", "Adjudicate EC Membership request"));
		
		statusActionMap.put("MEMBER_DETAILS_REVIEW",actions);
	}

    private static void initTransitionLevels() {
    	transitionLevels.put("EDIT_REQUEST", WorkflowConstants.TRASITION_EDIT_REQUEST);
    	transitionLevels.put("EC_SECTION_STAFF_APPROVE", WorkflowConstants.TRASITION_APPROVE_EC_MEMBER_REQUEST);
    	transitionLevels.put("EC_SECTION_STAFF_REJECT", WorkflowConstants.TRASITION_REJECT__EC_MEMBER_REQUEST);
    	transitionLevels.put("EC_SECTION_HEAD_APPROVE", WorkflowConstants.TRASITION_APPROVE_EC_MEMBER_REQUEST);
    	transitionLevels.put("EC_SECTION_HEAD_REJECT", WorkflowConstants.TRASITION_REJECT__EC_MEMBER_REQUEST);
    	transitionLevels.put("GME_DIRECTOR_SEND_TO_PRESIDENT", WorkflowConstants.TRASITION_APPROVE_AND_SEND_TO_PRESIDENT);
    	transitionLevels.put("GME_DIRECTOR_SEND_TO_VPAA", WorkflowConstants.TRASITION_APPROVE_AND_SEND_TO_VPAA);
    	transitionLevels.put("GME_DIRECTOR_SENND_TO_VPAA", WorkflowConstants.TRASITION_APPROVE_AND_SEND_TO_VPAA);
    	transitionLevels.put("GME_DIRECTOR_REJECT", WorkflowConstants.TRASITION_REJECT__EC_MEMBER_REQUEST);
    		
    	transitionLevels.put("VPAA_APPROVE", WorkflowConstants.TRASITION_APPROVE_EC_MEMBER_REQUEST);
    	transitionLevels.put("VPAA_REJECT", WorkflowConstants.TRASITION_REJECT__EC_MEMBER_REQUEST);
    		
    	transitionLevels.put("PRESIDENT_APPROVE", WorkflowConstants.TRASITION_APPROVE_EC_MEMBER_REQUEST);
    	transitionLevels.put("PRESIDENT_REJECT", WorkflowConstants.TRASITION_REJECT__EC_MEMBER_REQUEST);
    	transitionLevels.put("NOC_UPLOAD", WorkflowConstants.TRASITION_UPLOAD_NOC_AND_APPROVE);
    	transitionLevels.put("SEND_TO_AU_FOR_NOC", WorkflowConstants.TRASITION_AU_NOC_UPLOAD);
    	transitionLevels.put("AU_NOC_UPLOAD", WorkflowConstants.TRASITION_UPLOAD_NOC_AND_APPROVE);
    	
    		
    	transitionLevels.put("MEMBER_DETAILS_REQUEST", WorkflowConstants.TRASITION_MEMBER_DETAILS_REQUEST);
    	transitionLevels.put("ADD_MEMBER_DETAILS", WorkflowConstants.TRASITION_ADD_MEMBER_DETAILS);
    	transitionLevels.put("EDIT_MEMBER_DETAILS", WorkflowConstants.TRASITION_EDIT_MEMBER_DETAILS);
    	transitionLevels.put("MEMBER_DETAILS_ENTRY", WorkflowConstants.TRASITION_ADD_MEMBER_DETAILS);
    	transitionLevels.put("MEMBER_DETAILS_APPROVE", WorkflowConstants.TRASITION_APPROVE_MEMBER_DETAILS);
    	transitionLevels.put("MEMBER_DETAILS_REVIEW", WorkflowConstants.TRASITION_MEMBER_DETAILS);
    	transitionLevels.put("MEMBER_DETAILS_REJECT", WorkflowConstants.TRASITION_MEMBER_DETAILS_REJECT);
    	transitionLevels.put("GENERATE_QARAR", WorkflowConstants.TRASITION_GENERATE_QARAR);
    	transitionLevels.put("REQUEST_QARAR", WorkflowConstants.TRASITION_REQUEST_QARAR);
    	transitionLevels.put("COMPLETE", WorkflowConstants.TRASITION_APPROVE_EC_MEMBER_REQUEST);
	}

	public static List<ActionDetail> getActions(String status) {
        List<ActionDetail> actions = statusActionMap.get(status);
        if (actions != null) {
            return actions;
        } else {
            return new ArrayList<>();
        }
    }
    
    public static String getTransitionLevel(String transitionName, HttpServletRequest httpRequest) {
	    String transitionLevelKey = transitionLevels.get(transitionName);
        String transitionLevel = LanguageUtil.get(httpRequest, transitionLevelKey);
          if (transitionLevel != null) {
            return transitionLevel;
        } else {
            return transitionName;
        }
    }
    
}

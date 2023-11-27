package gov.omsb.oct.rest.api;

import java.util.Locale;

import gov.omsb.common.api.OMSBCommonApi;
import gov.omsb.http.connector.api.OMSBHttpConnector;
import gov.omsb.oct.exam.web.portlet.util.OCTExamUtil;

public interface OmsbOctRestService {
	public String getExamList(String portalURL, long groupId, Locale locale, OMSBCommonApi omsbCommonApi, OMSBHttpConnector omsbHttpConnector);
	public void rescheduleForWholeDay(long ocExamScheduleId, String portalURL, long groupId, long companyId,OMSBCommonApi omsbCommonApi, OMSBHttpConnector omsbHttpConnector,OCTExamUtil octExamUtil);	

}

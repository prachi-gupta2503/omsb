package gov.omsb.common.api;

public interface DataflowService {

	String getAuthToken();

	String getCaseDetail(String caseNumber);

	String getDocRespone(String caseNumber, String docId);

	String getCaseReport(String caseNumber);
	
}

package gov.omsb.http.connector.api;

import java.util.Map;

/**
 * @author AftabA
 */

public interface OMSBHttpConnector {
	
	/**
	 * @author AftabA
	 * @param url
	 * @param payload
	 * @return The below method will return the Authentication Token as a part of the response body.
	 * The token will be utilized to make subsequent calls to other API's.
	 */
	 String getDataFlowAuthToken(String url, String payload);
	 
	 /**
	  * @author AftabA
	  * @param url
	  * @param parts
	  * @param headers
	  * @return The below method is used to get the headless webservice data and return complete json response of object.
	  */
	 String executeGet(String url, String payload,  Map<String, String> headers);
	 
	 /**
	  * @author SachinG
	  * @param url
	  * @param parts
	  * @return  The below method is used to save the data using headless api and it will return the String.
	  */
	 String executePost(String url, String payload, Map<String, String> headers);
	 
	 /**
	  * @author SachinG
	  * @param url
	  * @param parts
	  * @return The below method used to update the data using headless api and it will return String.
	  */
	 String executePut(String url, String payload, Map<String, String> headers);
	 
	 /**
	  * @author SachinG
	  * @param url
	  * @return The below method used to delete the data using headless api and it will return String.
	  */
	String executeDelete(String url, Map<String, String> headers);

	String tokenExecutePost(String url, String payload, Map<String, String> headers);

	 /**
	  * @author himanshu.nimavat
	  * @param url
	  * @return The below method is used to get the headless webservice data with specific timeout and return complete json response of object.
	  */
	String executeGetWithTimeout(String url, String payload, int milliSeconds, Map<String, String> headers);

	/**
	 * @param url
	 * @param payload
	 * @param milliSeconds
	 * @param headers
	 * @return
	 */
	String executePostWithTimeout(String url, String payload, int milliSeconds, Map<String, String> headers);
		
}
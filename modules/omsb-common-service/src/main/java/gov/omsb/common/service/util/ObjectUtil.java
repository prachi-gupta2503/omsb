package gov.omsb.common.service.util;

import com.fasterxml.jackson.databind.ObjectMapper;

public class ObjectUtil {
	
	private static ObjectUtil object = null;

	private ObjectUtil()
	{

	}

	/**
	 * @author TusharT
	 * @return This method returns the singleton instance of the class.
	 */
	public static ObjectUtil getInstance()
	{
		if (object == null) {
			object = new ObjectUtil();
			return object;
		} else {
			return object;
		}
	}

	/**
	 * @author TusharT
	 * @return this method return the instance of the object mapper.
	 */
	public ObjectMapper getObjectMapper()
	{
		ObjectMapper objectMapper = new ObjectMapper();
	
		return objectMapper;
	}
	
}

package gov.omsb.common.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.Validator;

import java.text.DateFormat;
/**
 * @author AftabA
 */
public class CustomObjectMapperUtil {
	private CustomObjectMapperUtil() {}
	/**
	 * @author AftabA
	 * @return this method return the instance of the object mapper.
	 */
	private static final ObjectMapper _objectMapper;
	
	/**
	 * @author AftabA
	 * @return this method return the instance of the object mapper.
	 */
	static {
		_objectMapper = new ObjectMapper();
		_objectMapper.configure(
				DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		/*
		 * _objectMapper.configure(
		 * DeserializationFeature.USE_JAVA_ARRAY_FOR_JSON_ARRAY, true);
		 * 
		 * _objectMapper.configure( SerializationFeature.WRITE_ENUMS_USING_TO_STRING,
		 * true); _objectMapper.enable(SerializationFeature.INDENT_OUTPUT);
		 * _objectMapper.setSerializationInclusion(JsonInclude.Include.NON_EMPTY);
		 * _objectMapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
		 * _objectMapper.setVisibility( PropertyAccessor.FIELD,
		 * JsonAutoDetect.Visibility.ANY); _objectMapper.setVisibility(
		 * PropertyAccessor.GETTER, JsonAutoDetect.Visibility.NONE);
		 */
	}
	
	/**
	 * @author AftabA
	 * @return this method return the instance of the object mapper.
	 */
	public static final ObjectMapper getObjectMapper() {
		return _objectMapper;
	}
	
	/**
	 * @author AftabA
	 * @return this method read the response and set the objects value and returns the DTO.
	 */
	@SuppressWarnings("unchecked")
	public static <T> T readValue(String response, Class<?> clazz){
		try {
			_log.info("inside the readValue");
			return (T) _objectMapper.readValue(response, clazz);
		} catch (JsonProcessingException e) {
			_log.error("Exception while processing the Json ::: " + e);
		}
		return null;
	}
	
	@SuppressWarnings("unchecked")
	public static <T> T writeValueAsString(Object object, DateFormat dateFormat){
		try {
			if (Validator.isNotNull(dateFormat)) {
				_objectMapper.setDateFormat(dateFormat);
			}
			_log.info("inside the readValue");
			return (T) _objectMapper.writeValueAsString(object);
		} catch (JsonProcessingException e) {
			_log.error("Exception while processing the Json ::: " + e);
		}
		return null;
	}
	
	@SuppressWarnings("unchecked")
	public static <T> T readValue(String response, Class<?> clazz, DateFormat dateFormat){
		try {
			if (Validator.isNotNull(dateFormat)) {
				_objectMapper.setDateFormat(dateFormat);
			}
			_log.info("inside the readValue");
			return (T) _objectMapper.readValue(response, clazz);
		} catch (JsonProcessingException e) {
			_log.error("Exception while processing the Json ::: " + e);
		}
		return null;
	}
	
	private static final Log _log = LogFactoryUtil.getLog(CustomObjectMapperUtil.class);
}
package gov.omsb.form.builder.portlet.util;

import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.util.Validator;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

/**
 * 
 * The purpose of this class is class is for date operations
 *
 *@author Jinal Patel
 *
 */
public class DateUtil {
	
	public static final String LONG_DATE_FORMAT = "yyyy-MM-dd HH:mm:ss.SSS";
	private static final String ALT_LONG_DATE_FORMAT = "dd/MM/yyyy HH:mm:ss";
	public static final String SHORT_DATE_FORMAT = "dd-MM-yyyy";
	public static final String REV_SHORT_DATE_FORMAT="yyyy-MM-dd";
	public static final String ZONE = "Asia/Calcutta";
	
	/**
	 * 
	 * This method is used to long formatted date
	 *
	 * @param dateStr
	 * @return : long format date
	 */
	public static String getLongFormatDate(Date dateStr) {
		try {
			DateFormat format = new SimpleDateFormat(LONG_DATE_FORMAT);
			format.setTimeZone(TimeZone.getTimeZone(ZONE));
			return format.format(dateStr);
		}catch (Exception e) {
			return StringPool.BLANK;
		}
	}
	
	
	/**
	 * 
	 * This method is used to long formatted date
	 *
	 * @param dateStr
	 * @return : long format date
	 */
	public static String getShortFormatDate(Date dateStr) {
		try {
			DateFormat format = new SimpleDateFormat(SHORT_DATE_FORMAT);
			format.setTimeZone(TimeZone.getTimeZone(ZONE));
			return format.format(dateStr);
		}catch (Exception e) {
			return StringPool.BLANK;
		}
	}
	
	/**
	 * 
	 * This method is used to check long  date format
	 *
	 * @param dateStr
	 * @return : true if valid else false
	 */
	public static boolean isValidLongFormat(String dateStr) {
        DateFormat sdf = new SimpleDateFormat(LONG_DATE_FORMAT);
        sdf.setLenient(false);
        try {
            sdf.parse(dateStr);
        } catch (ParseException e) {
            return false;
        }
        return true;
    }
	
	
	/**
	 * 
	 * This method is used to check short  date format
	 *
	 * @param dateStr
	 * @return : true if valid else false
	 */
	public static boolean isValidShortFormat(String dateStr) {
        DateFormat sdf = new SimpleDateFormat(SHORT_DATE_FORMAT);
        sdf.setLenient(false);
        try {
            sdf.parse(dateStr);
        } catch (ParseException e) {
            return false;
        }
        return true;
    }
	
	/**
	 * 
	 * This method is used to date in long format
	 *
	 * @param dateStr
	 * @return : date
	 */
	public static Date getLongFormattedDateObj(String dateStr) {
		try {
			 DateFormat sdf = new SimpleDateFormat(LONG_DATE_FORMAT);
			 sdf.setTimeZone(TimeZone.getTimeZone(ZONE));
		     sdf.setLenient(false);
			return sdf.parse(dateStr);
		}catch (Exception e) {
			return getDate(dateStr);
		}
	}

	private static Date getDate(String dateStr) {
		try {
			DateFormat sdf = new SimpleDateFormat(ALT_LONG_DATE_FORMAT);
			sdf.setTimeZone(TimeZone.getTimeZone(ZONE));
			sdf.setLenient(false);
			return sdf.parse(dateStr);
		}catch(Exception ex){
			return new Date();
		}
	}


	/**
	 * 
	 * This method is used to date in long format
	 *
	 * @param dateStr
	 * @return : date
	 */
	public static Date getShortFormattedDateObj(String dateStr) {
		try {
			 DateFormat sdf = new SimpleDateFormat(SHORT_DATE_FORMAT);
			 sdf.setTimeZone(TimeZone.getTimeZone(ZONE));
		     sdf.setLenient(false);
			return sdf.parse(dateStr);
		}catch (Exception e) {
			return null;
		}
	}
	
	public static String formatDate(Date date, String pattern) {
		String formattedDate = StringPool.BLANK;
		if(Validator.isNotNull(date) && Validator.isNotNull(pattern)) {
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
			formattedDate = simpleDateFormat.format(date);
		}
		return formattedDate;
	}
}

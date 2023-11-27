package gov.omsb.form.builder.headless.internal.resource.v1_0;

import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.util.Validator;

import java.util.LinkedHashSet;
import java.util.Set;

/**
 * @author Jinal Patel
 *
 */
public class FormDataUtil {

	private FormDataUtil() {
		
	}
	
	public static String formatFormName(String formName) {
		String formattedFormName = StringPool.BLANK;
		if(Validator.isNotNull(formName)) {
			formattedFormName = "df_"+formName.replaceAll("\\s+", "_").toLowerCase();
		}
		return formattedFormName ;
	}
	
	// Function to remove duplicate from array
	public static Set<Long> removeDuplicates(Long[] a) {
		LinkedHashSet<Long> set = new LinkedHashSet<>();
		for (int i = 0; i < a.length; i++)
			set.add(a[i]);
		return set;
	}
	
	public static String toCommaSeperatedRecordIds(Set<Long> recordsSet) {
        String result = "";
        if (Validator.isNotNull(recordsSet) && recordsSet.size() > 0 && !recordsSet.isEmpty()) {
            StringBuilder recordStr = new StringBuilder();
            for (long recordId : recordsSet) {
            	recordStr.append(recordId).append(",");
            }
            result = recordStr.deleteCharAt(recordStr.length() - 1).toString();
        }
        return result;
	}
}

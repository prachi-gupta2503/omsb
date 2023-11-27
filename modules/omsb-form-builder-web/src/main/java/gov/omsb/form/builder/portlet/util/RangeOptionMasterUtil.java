package gov.omsb.form.builder.portlet.util;

import com.liferay.counter.kernel.service.CounterLocalServiceUtil;
import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONException;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.Validator;

import java.util.Date;
import java.util.List;

import gov.omsb.form.builder.constants.FormBuilderConstants;
import gov.omsb.form.builder.model.RangeOptionMaster;
import gov.omsb.form.builder.service.RangeOptionMasterLocalService;

public class RangeOptionMasterUtil {
	
	private static RangeOptionMasterLocalService _rangeOptionMasterLocalService;	

	private static final Log log = LogFactoryUtil.getLog(RangeOptionMasterUtil.class);
	
	public RangeOptionMasterUtil(RangeOptionMasterLocalService rangeOptionMasterLocalService) {
		_rangeOptionMasterLocalService = rangeOptionMasterLocalService;
	}
	
	public static RangeOptionMaster saveRangeOption(ThemeDisplay themeDisplay, long rangeOptionId, String rangeOptionName, String rangeOptions) {
		RangeOptionMaster rangeOptionMaster = null;
		Date date = new Date();
		try {
			if(rangeOptionId > 0) {
				rangeOptionMaster = _rangeOptionMasterLocalService.getRangeOptionMaster(rangeOptionId);
				rangeOptionMaster.setModifiedBy(themeDisplay.getUserId());
			} else {
				rangeOptionMaster = _rangeOptionMasterLocalService.createRangeOptionMaster(CounterLocalServiceUtil.increment());
				rangeOptionMaster.setCreatedDate(date);
				rangeOptionMaster.setCreatedBy(themeDisplay.getUserId());
			}
			rangeOptionMaster.setCompanyId(themeDisplay.getCompanyId());
			rangeOptionMaster.setGroupId(themeDisplay.getScopeGroupId());
			rangeOptionMaster.setModifiedDate(date);
			rangeOptionMaster.setRangeOptionName(rangeOptionName);
			rangeOptionMaster.setRangeOptions(rangeOptions);
			if(Validator.isNotNull(rangeOptionName)) {
				rangeOptionMaster = _rangeOptionMasterLocalService.updateRangeOptionMaster(rangeOptionMaster);
			}
		} catch (PortalException | SystemException e) {
			log.error("Error occured while adding/editing range option");
		}
		return rangeOptionMaster;
	}
	
	public static JSONArray getRangeOptionMasterArr() {
		JSONArray  rangeOptionMasterArr = JSONFactoryUtil.createJSONArray();
		JSONObject rangeOptionMasterObj = null;
		List<RangeOptionMaster> rangeOptionMasterList= _rangeOptionMasterLocalService.getRangeOptionMasters(QueryUtil.ALL_POS, QueryUtil.ALL_POS);
		if(Validator.isNotNull(rangeOptionMasterList) && rangeOptionMasterList.size() > 0) {
			JSONArray jsonArray = null;
			for(RangeOptionMaster rangeOption: rangeOptionMasterList) {
				rangeOptionMasterObj = JSONFactoryUtil.createJSONObject();
				rangeOptionMasterObj.put(FormBuilderConstants.VALUE, rangeOption.getRangeOptionId());
				rangeOptionMasterObj.put(FormBuilderConstants.LABEL, rangeOption.getRangeOptionName());
				try {
					jsonArray = JSONFactoryUtil.createJSONArray(rangeOption.getRangeOptions());
					rangeOptionMasterObj.put(FormBuilderConstants.RANGE_OPTIONS, jsonArray.toString());
				} catch (JSONException e) {
					log.error("Error while creating the json array " + e.getMessage(), e);
				}
				rangeOptionMasterArr.put(rangeOptionMasterObj);
			}
		}
		return rangeOptionMasterArr;
	}
	
	public static String getUserName(long userId) {
		if (userId > 0) {
			try {
				User user = UserLocalServiceUtil.getUser(userId);
				return user.getFullName();
			} catch (PortalException e) {
				log.error("Error while fetching user name with user id :" + userId);
			}
		}
		return StringPool.BLANK;
	}
}

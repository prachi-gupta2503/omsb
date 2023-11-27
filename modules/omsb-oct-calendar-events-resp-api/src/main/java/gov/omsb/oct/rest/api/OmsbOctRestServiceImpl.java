package gov.omsb.oct.rest.api;

import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.Validator;

import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import gov.omsb.common.api.OMSBCommonApi;
import gov.omsb.common.constants.CommonConstants;
import gov.omsb.common.object.url.LRObjectURL;
import gov.omsb.common.util.CustomObjectMapperUtil;
import gov.omsb.http.connector.api.OMSBHttpConnector;
import gov.omsb.oct.exam.web.constants.OCTExamConstants;
import gov.omsb.oct.exam.web.portlet.dto.OCTExamSchedule;
import gov.omsb.oct.exam.web.portlet.dto.OCTExamScheduleItems;
import gov.omsb.oct.exam.web.portlet.util.OCTExamUtil;
import gov.omsb.oct.rest.utills.OmsbRestUtill;

public class OmsbOctRestServiceImpl implements OmsbOctRestService{

	private Log logger = LogFactoryUtil.getLog(OmsbOctRestServiceImpl.class);
	
	/**
	 *@param String portalURL, 
	 *@param long groupId, 
	 *@param Locale locale, 
	 *@param OMSBCommonApi omsbCommonApi, 
	 *@param OMSBHttpConnector omsbHttpConnector,
	 *Response String,
	 *It will give the No of exams list on list screen.
	 *
	 */
	public String getExamList(String portalURL, long groupId, Locale locale, OMSBCommonApi omsbCommonApi, OMSBHttpConnector omsbHttpConnector) {
		
		try {
			
			
			String url = portalURL + LRObjectURL.OC_EXAM + CommonConstants.SCOPES + StringPool.SLASH + groupId
					+ StringPool.QUESTION + OCTExamConstants.SORT_BY_ID_DESC;
			String response = omsbHttpConnector.executeGet(url, "", omsbCommonApi.getHttpHeaderInfoAndBasicAuth());
			
			JSONObject jsonObject = JSONFactoryUtil.createJSONObject(response);
			logger.debug("Response ... " + jsonObject);

			JSONArray itemArray = JSONFactoryUtil.createJSONArray(jsonObject.getString("items"));

			
			JSONObject listObject=JSONFactoryUtil.createJSONObject();
			JSONArray responseArray=JSONFactoryUtil.createJSONArray();
			for (int i = 0; i < itemArray.length(); i++) {

				listObject=itemArray.getJSONObject(i);
				 JSONObject rsponseObject = JSONFactoryUtil.createJSONObject();
				if(Validator.isNotNull(listObject) && Validator.isNotNull(listObject.getString("oCExamTitleId"))) {
					rsponseObject.put("ocExamTitleId", listObject.getString("oCExamTitleId"));
					String ocExamTitle = omsbCommonApi.getListTypeEntryNameBylistTypeEntryId(
							Long.parseLong(listObject.getString("oCExamTitleId")), Locale.getDefault());
					rsponseObject.put("id", listObject.getString("id"));
					rsponseObject.put("ocExamTitleName", ocExamTitle);
					responseArray.put(rsponseObject);
				}
				
			}
			
			
			return responseArray.toJSONString();
			// logger.info("Response array-- "+array);
		} catch (Exception e) {
			logger.info(e);
		}
		return null;
		
	};
	
	
	public void rescheduleForWholeDay(long ocExamScheduleId, String portalURL, long groupId, long companyId,
			OMSBCommonApi omsbCommonApi, OMSBHttpConnector omsbHttpConnector,OCTExamUtil octExamUtil) {
		
		OmsbRestUtill omsbRestUtill= new OmsbRestUtill();
		
		String examScheduleURL = portalURL + LRObjectURL.OC_EXAM_SCHEDULE + CommonConstants.SCOPES
				+ StringPool.SLASH + groupId+ StringPool.QUESTION + "filter=id"
				+ URLEncoder.encode(" eq " + "'" + ocExamScheduleId + "'", StandardCharsets.UTF_8);
		String examScheduleResponse = omsbHttpConnector.executeGet(examScheduleURL, "",
				omsbCommonApi.getHttpHeaderInfoAndBasicAuth());
		
		if (Validator.isNotNull(examScheduleResponse)) {
			OCTExamScheduleItems scheduleItems = CustomObjectMapperUtil.readValue(examScheduleResponse,
					OCTExamScheduleItems.class);

			if (Validator.isNotNull(scheduleItems)) {

				OCTExamSchedule examSchedule = new OCTExamSchedule();
				examSchedule.setDepartmentId(scheduleItems.getItems().get(0).getDepartmentId());
				String date= scheduleItems.getItems().get(0).getExamDate();
				Date dateFormat=new Date();
				try {
					dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'").parse(date);
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

				examScheduleURL = portalURL + LRObjectURL.OC_EXAM_SCHEDULE + CommonConstants.SCOPES
						+ StringPool.SLASH + groupId;

				examScheduleResponse = omsbHttpConnector.executeGet(examScheduleURL, "",
						omsbCommonApi.getHttpHeaderInfoAndBasicAuth());


				if (Validator.isNotNull(examScheduleResponse)) {

					scheduleItems = CustomObjectMapperUtil.readValue(examScheduleResponse,
							OCTExamScheduleItems.class);

					if (Validator.isNotNull(scheduleItems)) {
						List<OCTExamSchedule> items = scheduleItems.getItems();
						for(OCTExamSchedule octExamSchedule:items) {
							Date oCTExamDate;
							try {
								oCTExamDate = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'").parse(octExamSchedule.getExamDate());
								if(dateFormat.equals(oCTExamDate))
									
								omsbRestUtill.rescheduleExam(octExamSchedule.getId(), portalURL, groupId, companyId,omsbCommonApi,omsbHttpConnector,octExamUtil);
							} catch (ParseException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}

						}
					}
				}

			}
		}
		
	}
	
}

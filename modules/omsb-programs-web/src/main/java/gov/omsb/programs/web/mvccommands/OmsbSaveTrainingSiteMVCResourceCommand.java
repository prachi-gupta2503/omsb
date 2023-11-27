package gov.omsb.programs.web.mvccommands;

import com.liferay.counter.kernel.service.CounterLocalService;
import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.JSONPortletResponseUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCResourceCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCResourceCommand;
import com.liferay.portal.kernel.util.LocaleUtil;
import com.liferay.portal.kernel.util.ParamUtil;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import gov.omsb.common.constants.CommonConstants;
import gov.omsb.programs.web.constants.OmsbProgramsWebPortletKeys;
import gov.omsb.tms.model.TrainingSitesMaster;
import gov.omsb.tms.service.TrainingSitesMasterLocalService;

/**
 * @author Jayesh Goswami
 */
@Component(immediate = true, property = { "javax.portlet.name=" + OmsbProgramsWebPortletKeys.OMSBPROGRAMSWEB,
"mvc.command.name=/save/training-site"}, service = MVCResourceCommand.class)
public class OmsbSaveTrainingSiteMVCResourceCommand extends BaseMVCResourceCommand {

	@Override
	public void doServeResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse) throws Exception {
		_logger.info("ProcessAction Invoked ::: ");
		boolean isSuccess = createTrainingSiteData(resourceRequest);
		
		JSONObject resultJson = prepareJsonResponse(isSuccess);
		JSONPortletResponseUtil.writeJSON(resourceRequest, resourceResponse, resultJson);
		_logger.info("ProcessAction Exit ::: ");
	}
	
	public boolean createTrainingSiteData(ResourceRequest resourceRequest) {
		_logger.info("prepareTrainingSiteData Invoked ::: ");
		boolean isSuccess = true;
		Locale enLocal = LocaleUtil.fromLanguageId(CommonConstants.LANGUAGE_CODE_ENGLISH);
		Locale arLocal = LocaleUtil.fromLanguageId(CommonConstants.LANGUAGE_CODE_ARABIC);
		Map<Locale, String> trainingSiteName = getTraininigSiteName(resourceRequest, enLocal, arLocal);
		Map<Locale, String> trainingSiteCode = getTraininigSiteCode(resourceRequest, enLocal, arLocal);
		Map<Locale, String> trainingSiteAddress = getTraininigSiteAddress(resourceRequest, enLocal, arLocal);
		Map<Locale, String> trainingSiteDescription = getTraininigSiteDescription(resourceRequest, enLocal, arLocal);
		
		boolean trainingSiteStatus = ParamUtil.getBoolean( resourceRequest, "trainingSiteStatus", Boolean.TRUE);
		
		long trainingSiteMasterId = counterLocalService.increment(TrainingSitesMaster.class.getName());
		try {
			TrainingSitesMaster trainingSitesMaster = trainingSitesMasterLocalService.createTrainingSitesMaster(trainingSiteMasterId);
			trainingSitesMaster.setTrainingSiteCodeMap(trainingSiteCode);
			trainingSitesMaster.setTrainingSiteNameMap(trainingSiteName);
			trainingSitesMaster.setTrainingSiteAddressMap(trainingSiteAddress);
			trainingSitesMaster.setTrainingSiteDescriptionMap(trainingSiteDescription);
			trainingSitesMaster.setTrainingSiteStatus(trainingSiteStatus);
			trainingSitesMasterLocalService.addTrainingSitesMaster(trainingSitesMaster);
			_logger.debug("createTrainingSiteMaster ::: Training Site Master Record Created");
		} catch (Exception e) {
			_logger.error(e);
			isSuccess = false;
		}
		_logger.info("prepareTrainingSiteData Exit ::: ");
		return isSuccess;
	}
	
	public Map<Locale, String> getTraininigSiteName(ResourceRequest resourceRequest, Locale enLocal, Locale arLocal) {
		Map<Locale, String> trainingSiteName = new HashMap<>();
		
		String trainingSiteNameEn = ParamUtil.getString(resourceRequest, "trainingSiteNameEn", StringPool.BLANK);
		String trainingSiteNameAr = ParamUtil.getString(resourceRequest, "trainingSiteNameAr", StringPool.BLANK);
		
		trainingSiteName.put(enLocal, trainingSiteNameEn);
		trainingSiteName.put(arLocal, trainingSiteNameAr);
		
		return trainingSiteName;
		
	}
	
	public Map<Locale, String> getTraininigSiteCode(ResourceRequest resourceRequest, Locale enLocal, Locale arLocal) {
		Map<Locale, String> trainingSiteCode = new HashMap<>();
		
		String trainingSiteCodeEn = ParamUtil.getString(resourceRequest, "trainingSiteCodeEn", StringPool.BLANK);
		String trainingSiteCodeAr = ParamUtil.getString(resourceRequest, "trainingSiteCodeAr", StringPool.BLANK);
		
		trainingSiteCode.put(enLocal, trainingSiteCodeEn);
		trainingSiteCode.put(arLocal, trainingSiteCodeAr);
		
		return trainingSiteCode;
		
	}
	
	public Map<Locale, String> getTraininigSiteAddress(ResourceRequest resourceRequest, Locale enLocal, Locale arLocal) {
		Map<Locale, String> trainingSiteAddress = new HashMap<>();
		
		String trainingSiteAddressEn = ParamUtil.getString(resourceRequest, "trainingSiteAddressEn", StringPool.BLANK);
		String trainingSiteAddressAr = ParamUtil.getString(resourceRequest, "trainingSiteAddressAr", StringPool.BLANK);
		
		trainingSiteAddress.put(enLocal, trainingSiteAddressEn);
		trainingSiteAddress.put(arLocal, trainingSiteAddressAr);
		
		return trainingSiteAddress;
		
	}
	
	public Map<Locale, String> getTraininigSiteDescription(ResourceRequest resourceRequest, Locale enLocal, Locale arLocal) {
		Map<Locale, String> trainingSiteDescription = new HashMap<>();
		
		String trainingSiteDescriptionEn = ParamUtil.getString(resourceRequest, "trainingSiteDescriptionEn", StringPool.BLANK);
		String trainingSiteDescriptionAr = ParamUtil.getString(resourceRequest, "trainingSiteDescriptionAr", StringPool.BLANK);
		
		trainingSiteDescription.put(enLocal, trainingSiteDescriptionEn);
		trainingSiteDescription.put(arLocal, trainingSiteDescriptionAr);
		
		return trainingSiteDescription;
		
	}
	
	private JSONObject prepareJsonResponse(boolean isSuccess) {
		_logger.info("prepareJsonResponse Invoked ::: ");
		
		JSONObject resultJson = JSONFactoryUtil.createJSONObject();
		resultJson.put(CommonConstants.SUCCESS, isSuccess);
		
		_logger.info("prepareJsonResponse Exit ::: ");
		return resultJson;
	}

	@Reference
	private TrainingSitesMasterLocalService trainingSitesMasterLocalService;
	
	@Reference
	private CounterLocalService counterLocalService;
	
	private static final Log _logger = LogFactoryUtil.getLog(OmsbSaveTrainingSiteMVCResourceCommand.class.getName());

}

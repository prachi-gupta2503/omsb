package gov.omsb.notify.sau.web.portlet;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;

import java.io.IOException;
import java.time.Year;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import gov.omsb.common.dto.SauTrainingSites;
import gov.omsb.common.dto.SauTrainingSitesItem;
import gov.omsb.common.dto.UserMetadata;
import gov.omsb.common.dto.UserMetadataItem;
import gov.omsb.common.service.util.UserMetadataUtil;
import gov.omsb.notify.sau.web.constants.OmsbNotifySauWebPortletKeys;
import gov.omsb.tms.custom.dto.SauUserTrainingSiteCapacityDTO;
import gov.omsb.tms.custom.dto.TrainingSiteByPdDTO;
import gov.omsb.tms.custom.dto.TrainingSiteListDTO;
import gov.omsb.tms.custom.dto.TrainingSitesCapacityDTO;
import gov.omsb.tms.model.ProgramMaster;
import gov.omsb.tms.service.ProgdurationRotationTrainingsitesRelLocalService;
import gov.omsb.tms.service.ProgramMasterLocalService;

/**
 * @author Aditya Meghnathi
 */
@Component(immediate = true, property = { "com.liferay.portlet.display-category=category.sample",
		"com.liferay.portlet.header-portlet-css=/css/main.css", "com.liferay.portlet.instanceable=false",
		"javax.portlet.display-name=OmsbNotifySauWeb", "javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=" + OmsbNotifySauWebPortletKeys.NOTIFY_ADD_CAPACITY_JSP,
		"javax.portlet.name=" + OmsbNotifySauWebPortletKeys.OMSBNOTIFYSAUWEB,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user" }, service = Portlet.class)
public class OmsbNotifySauWebPortlet extends MVCPortlet {

	@Override
	public void render(RenderRequest renderRequest, RenderResponse renderResponse)
			throws IOException, PortletException {
		_logger.debug("OmsbNotifySauWebPortlet render Invoked ::: ");
		ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);
		Year currentYear = Year.now();
		String programDuration = currentYear.toString() + "-" + currentYear.plusYears(1).toString();

		UserMetadataItem userMetadataItem = userMetadataUtil.getUserMetadataItemsByLrUserId(themeDisplay.getPortalURL(),
				themeDisplay.getScopeGroupId(), themeDisplay.getUserId());
		List<Long> programMasterIds = new ArrayList<>();
		if (Validator.isNotNull(userMetadataItem) && Validator.isNotNull(userMetadataItem.getItems())) {
			programMasterIds = (userMetadataItem.getItems()).stream().map(UserMetadata::getProgramId)
					.collect(Collectors.toList());
		}

		List<ProgramMaster> programMasterList = programMasterLocalService.findByProgramMasterId(programMasterIds);
		try {
			List<TrainingSiteListDTO> trainingSiteListDTOs = new ArrayList<>();
			for (ProgramMaster pMaster : programMasterList) {
				List<TrainingSiteByPdDTO> trainingSiteByPdDTOs = progdurationRotationTrainingsitesRelLocalService
						.getTrainingSitesByProgramDuration(pMaster.getProgramMasterId(), programDuration,
								themeDisplay.getLocale().toString());
				for (TrainingSiteByPdDTO trainingSiteByPdDTO : trainingSiteByPdDTOs) {
					TrainingSiteListDTO trainingSiteListDTO = new TrainingSiteListDTO();
					trainingSiteListDTO.setTrainingSiteMasterId(trainingSiteByPdDTO.getTrainingSiteId());
					trainingSiteListDTO.setTrainingSiteName(trainingSiteByPdDTO.getTrainingSiteName());
					trainingSiteListDTOs.add(trainingSiteListDTO);
				}
			}
			renderRequest.setAttribute(OmsbNotifySauWebPortletKeys.RENDER_ADD_TRAINING_SITE_LIST, trainingSiteListDTOs.stream()
				    .filter(distinctByKey(TrainingSiteListDTO::getTrainingSiteMasterId))
				    .collect(Collectors.toList()));

			List<TrainingSitesCapacityDTO> trainingSitesCapacityDTOs = progdurationRotationTrainingsitesRelLocalService
					.getProgramTrainingSitesCapacityDetails(themeDisplay.getLocale().toString());
			List<SauUserTrainingSiteCapacityDTO> sauUserTrainingSiteCapacityDTOs = new ArrayList<>();
			for (TrainingSitesCapacityDTO sitesCapacityDTO : trainingSitesCapacityDTOs) {
				SauTrainingSitesItem sauTrainingSitesItem = userMetadataUtil.getSauUserListByTrainingSite(
						themeDisplay.getPortalURL(), themeDisplay.getScopeGroupId(),
						sitesCapacityDTO.getTrainingSiteId());

				List<Long> sauUsers = new ArrayList<>();
				List<String> sauUserNames = new ArrayList<>();
				String sauUserList = null;
				if (Validator.isNotNull(sauTrainingSitesItem) && sauTrainingSitesItem.getItems() != null) {
					sauUsers = (sauTrainingSitesItem.getItems()).stream().map(SauTrainingSites::getSauUserId)
							.collect(Collectors.toList());
				}
				if (!sauUsers.isEmpty()) {
					for (int i = 0; i < sauUsers.size(); i++) {
						User user = UserLocalServiceUtil.getUser(sauUsers.get(i));
						sauUserNames.add(user.getFullName());
					}
					sauUserList = String.join(", ", sauUserNames);
				}
				SauUserTrainingSiteCapacityDTO sauUserTrainingSiteCapacityDTO = new SauUserTrainingSiteCapacityDTO();
				sauUserTrainingSiteCapacityDTO
						.setProgdurationRotationTsRelId(sitesCapacityDTO.getProgdurationRotationTsRelId());
				sauUserTrainingSiteCapacityDTO.setNoOfSlots(sitesCapacityDTO.getNoOfSlots());
				sauUserTrainingSiteCapacityDTO.setRotationName(sitesCapacityDTO.getRotationName());
				sauUserTrainingSiteCapacityDTO.setSauUsers(sauUserList);
				sauUserTrainingSiteCapacityDTO.setTrainingSiteName(sitesCapacityDTO.getTrainingSiteName());
				sauUserTrainingSiteCapacityDTO.setTrainingSiteId(sitesCapacityDTO.getTrainingSiteId());
				sauUserTrainingSiteCapacityDTOs.add(sauUserTrainingSiteCapacityDTO);
			}
			renderRequest.setAttribute("trainingSitesCapacityList", sauUserTrainingSiteCapacityDTOs);
		} catch (Exception e) {
			_logger.error(e);
		}
		super.render(renderRequest, renderResponse);
		_logger.debug("OmsbNotifySauWebPortlet render Exit ::: ");

	}

	private static <T> Predicate<T> distinctByKey(Function<? super T, ?> keyExtractor) {
	    Map<Object, Boolean> seen = new ConcurrentHashMap<>();
	    return t -> seen.putIfAbsent(keyExtractor.apply(t), Boolean.TRUE) == null;
	}

	@Reference
	private ProgramMasterLocalService programMasterLocalService;

	@Reference
	private UserMetadataUtil userMetadataUtil;

	@Reference
	private ProgdurationRotationTrainingsitesRelLocalService progdurationRotationTrainingsitesRelLocalService;

	private static final Log _logger = LogFactoryUtil.getLog(OmsbNotifySauWebPortlet.class.getName());
}
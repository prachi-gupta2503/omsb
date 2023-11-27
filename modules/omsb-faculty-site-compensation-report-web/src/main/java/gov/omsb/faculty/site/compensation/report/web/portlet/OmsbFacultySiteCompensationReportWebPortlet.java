package gov.omsb.faculty.site.compensation.report.web.portlet;

import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.WebKeys;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.servlet.http.HttpServletRequest;

import org.osgi.service.component.annotations.Component;

import gov.omsb.faculty.site.compensation.report.web.constants.OmsbFacultySiteCompensationReportWebPortletKeys;
import gov.omsb.faculty.site.compensation.report.web.dto.FacultySiteCompensationListDTO;
import gov.omsb.tms.common.constants.OmsbTmsCommonConstants;
import gov.omsb.tms.common.util.OmsbTmsCommonUtil;
import gov.omsb.tms.custom.dto.FacultySiteCompensationDTO;
import gov.omsb.tms.custom.dto.TrainingSiteNameWithRotationDTO;
import gov.omsb.tms.model.EcMemberRequest;
import gov.omsb.tms.model.ProgramMaster;
import gov.omsb.tms.service.EcMemberRequestLocalServiceUtil;
import gov.omsb.tms.service.ProgramMasterLocalServiceUtil;
import gov.omsb.tms.service.TrainingSitesMasterLocalServiceUtil;

/**
 * @author Dell
 */
@Component(immediate = true, property = { "com.liferay.portlet.display-category=OMSB",
		"com.liferay.portlet.header-portlet-css=/css/main.css", "com.liferay.portlet.instanceable=true",
		"javax.portlet.display-name=OmsbFacultySiteCompensationReportWeb", "javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/view.jsp",
		"javax.portlet.name=" + OmsbFacultySiteCompensationReportWebPortletKeys.OMSBFACULTYSITECOMPENSATIONREPORTWEB,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user" }, service = Portlet.class)
public class OmsbFacultySiteCompensationReportWebPortlet extends MVCPortlet {

	@Override
	public void render(RenderRequest renderRequest, RenderResponse renderResponse)
			throws IOException, PortletException {
		Map<String, List<String>> trainingSiteAndRotationmap = new HashMap<>();
		Map<String, List<FacultySiteCompensationListDTO>> facultySiteCompensationListDTOMap = new HashMap<>();

		LOGGER.info("Render ....");
		ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);
		HttpServletRequest httpRequest = PortalUtil
				.getOriginalServletRequest(PortalUtil.getHttpServletRequest(renderRequest));
		long requestId = 0;
		try {
			requestId = Long.parseLong(httpRequest.getParameter("requestId"));
		} catch (Exception e) {
			LOGGER.error(e.getMessage());
		}
		LOGGER.info("requestId  " + requestId);
		EcMemberRequest ecMemberRequest = null;
		ProgramMaster programMaster = null;
		String programName = StringPool.BLANK;
		try {

			LOGGER.info("requestId  " + requestId);
			ecMemberRequest = EcMemberRequestLocalServiceUtil.getEcMemberRequest(requestId);
			LOGGER.info("programId  " + ecMemberRequest.getProgramId());
			programMaster = ProgramMasterLocalServiceUtil.getProgramMaster(ecMemberRequest.getProgramId());
			trainingSiteAndRotationmap = addTOTrainingSiteNameWithRotationMap(themeDisplay,
					ecMemberRequest.getProgramId(), trainingSiteAndRotationmap);
			facultySiteCompensationListDTOMap = addToFacultySiteCompensationListDTOMap(themeDisplay,
					ecMemberRequest.getProgramId(), facultySiteCompensationListDTOMap);
			programName = OmsbTmsCommonUtil.getValueByLanguage(programMaster.getProgramName(),
					OmsbTmsCommonConstants.PROGRAM_NAME, themeDisplay.getLocale().toString());
		} catch (PortalException e) {
			LOGGER.error(e.getMessage());
		}
		LOGGER.info("TrainingSiteAndRotationmap : " + trainingSiteAndRotationmap);
		LOGGER.info("FacultySiteCompensationListDTOMap : " + facultySiteCompensationListDTOMap);
		renderRequest.setAttribute("TrainingSiteAndRotationmap", trainingSiteAndRotationmap);
		renderRequest.setAttribute("FacultySiteCompensationListDTOMap", facultySiteCompensationListDTOMap);
		renderRequest.setAttribute("ProgramName", programName);
		super.render(renderRequest, renderResponse);
	}

	private FacultySiteCompensationListDTO addFacultyDetails(FacultySiteCompensationDTO facultySiteCompensationDTO) {
		FacultySiteCompensationListDTO facultySiteCompensationListDTO = new FacultySiteCompensationListDTO();
		User user = null;
		try {
			user = UserLocalServiceUtil.getUser(facultySiteCompensationDTO.getUserId());
			facultySiteCompensationListDTO.setUserId(facultySiteCompensationDTO.getUserId());
			facultySiteCompensationListDTO.setFullName(user.getFullName());
			facultySiteCompensationListDTO.setAmountInOmr(facultySiteCompensationDTO.getAmountInOmr());
			facultySiteCompensationListDTO.setNameAr(facultySiteCompensationDTO.getNameAr());
			facultySiteCompensationListDTO.setNameEn(facultySiteCompensationDTO.getNameEn());
			facultySiteCompensationListDTO.setTrainingSiteCode(facultySiteCompensationDTO.getTrainingSiteCode());
			facultySiteCompensationListDTO.setTrainingSiteName(facultySiteCompensationDTO.getTrainingSiteName());
			facultySiteCompensationListDTO.setRoleName(facultySiteCompensationDTO.getRoleName());
			List<String> listOfRotation = new ArrayList<String>();
			listOfRotation.add(facultySiteCompensationDTO.getRotationName());
			facultySiteCompensationListDTO.setRotationName(listOfRotation);

		} catch (PortalException e) {
			e.printStackTrace();
		}

		return facultySiteCompensationListDTO;
	}

	private Map<String, List<String>> addTOTrainingSiteNameWithRotationMap(ThemeDisplay themeDisplay, long programId,
			Map<String, List<String>> trainingSiteAndRotationmap) {
		List<TrainingSiteNameWithRotationDTO> trainingSiteNameWithRotations = TrainingSitesMasterLocalServiceUtil
				.getTrainingSiteNameWithRotation(themeDisplay.getLocale().toString(), programId);
		LOGGER.info("trainingSiteNameWithRotations  : " + trainingSiteNameWithRotations);
		for (TrainingSiteNameWithRotationDTO trainingSiteNameWithRotation : trainingSiteNameWithRotations) {

			if (!trainingSiteAndRotationmap.containsKey(trainingSiteNameWithRotation.getTraining_site_name())) {
				trainingSiteAndRotationmap.put(trainingSiteNameWithRotation.getTraining_site_name(), new ArrayList<>());
				trainingSiteAndRotationmap.get(trainingSiteNameWithRotation.getTraining_site_name())
						.add(trainingSiteNameWithRotation.getRotation_name());
			} else {
				trainingSiteAndRotationmap.get(trainingSiteNameWithRotation.getTraining_site_name())
						.add(trainingSiteNameWithRotation.getRotation_name());
			}

		}
		return trainingSiteAndRotationmap;
	}

	private Map<String, List<FacultySiteCompensationListDTO>> addToFacultySiteCompensationListDTOMap(
			ThemeDisplay themeDisplay, long programId,
			Map<String, List<FacultySiteCompensationListDTO>> facultySiteCompensationListDTOMap) {
		List<FacultySiteCompensationDTO> facultySiteCompensationReportDetailsOfEcMembers = EcMemberRequestLocalServiceUtil
				.getFacultySiteCompensationReportDetailsOfEcMember(themeDisplay.getLocale().toString(), programId);
		LOGGER.info("facultySiteCompensationReportDetailsOfEcMembers  : "
				+ facultySiteCompensationReportDetailsOfEcMembers);
		for (FacultySiteCompensationDTO facultySiteCompensationDTO : facultySiteCompensationReportDetailsOfEcMembers) {

			if (!facultySiteCompensationListDTOMap.containsKey(facultySiteCompensationDTO.getTrainingSiteName())) {
				facultySiteCompensationListDTOMap.put(facultySiteCompensationDTO.getTrainingSiteName(),
						new ArrayList<>());
				FacultySiteCompensationListDTO addFacultyDetails = addFacultyDetails(facultySiteCompensationDTO);
				facultySiteCompensationListDTOMap.get(facultySiteCompensationDTO.getTrainingSiteName())
						.add(addFacultyDetails);
			} else {
				List<FacultySiteCompensationListDTO> listOfFaculty = facultySiteCompensationListDTOMap
						.get(facultySiteCompensationDTO.getTrainingSiteName());
				for (FacultySiteCompensationListDTO list : listOfFaculty) {
					List<FacultySiteCompensationListDTO> facultySiteList = new ArrayList<>();
					facultySiteList.addAll(listOfFaculty);
					if (!(list.getUserId() == facultySiteCompensationDTO.getUserId())) {
						FacultySiteCompensationListDTO addFacultyDetails = addFacultyDetails(
								facultySiteCompensationDTO);
						facultySiteList.add(addFacultyDetails);
						facultySiteCompensationListDTOMap.put(facultySiteCompensationDTO.getTrainingSiteName(),
								facultySiteList);

					} else if (list.getUserId() == facultySiteCompensationDTO.getUserId()) {
						List<String> rotation_name = list.getRotationName();
						rotation_name.add(facultySiteCompensationDTO.getRotationName());
					}
				}
			}

		}
		return facultySiteCompensationListDTOMap;

	}

	private static final Log LOGGER = LogFactoryUtil
			.getLog(OmsbFacultySiteCompensationReportWebPortlet.class.getName());

}
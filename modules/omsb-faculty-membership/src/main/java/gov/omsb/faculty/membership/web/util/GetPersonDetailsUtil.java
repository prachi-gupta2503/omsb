package gov.omsb.faculty.membership.web.util;

import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.Validator;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import gov.omsb.common.constants.DataflowConstants;
import gov.omsb.common.dto.Person;
import gov.omsb.common.dto.PersonItem;
import gov.omsb.common.dto.PersonalDetail;
import gov.omsb.common.dto.PersonalDetailItem;
import gov.omsb.common.object.url.LRObjectURL;
import gov.omsb.common.util.CustomObjectMapperUtil;
import gov.omsb.faculty.membership.web.constants.FacultyMembershipConstants;
import gov.omsb.faculty.membership.web.constants.FacultyRequestConstants;
import gov.omsb.faculty.membership.web.dto.PersonalDetailsDTO;

@Component(immediate = true, service = GetPersonDetailsUtil.class)
public class GetPersonDetailsUtil {

	public PersonalDetailsDTO getPersonalDetails(ThemeDisplay themeDisplay,long userId) {
		try {
			String personResponse = facultyMemebershipUtil.generateObjectResponse(LRObjectURL.PERSONAL_DETAIL_URL,
					themeDisplay.getScopeGroupId() + StringPool.QUESTION + FacultyRequestConstants.FILTER_EQ
							+ "lrUserId"
							+ URLEncoder.encode(" " + FacultyRequestConstants.EQ + " " + userId,
									FacultyRequestConstants.UNICODE_TRANSFORMATION_FORMAT));
			log.info("personResponse  ");
			PersonalDetailItem personalDetailItem = CustomObjectMapperUtil.readValue(personResponse,
					PersonalDetailItem.class);
			if (Validator.isNotNull(personalDetailItem) && Validator.isNotNull(personalDetailItem.getItems())
					&& personalDetailItem.getItems().size() > 0) {
				for (PersonalDetail personalDetail : personalDetailItem.getItems()) {
					PersonalDetailsDTO personDetails = new PersonalDetailsDTO();
					User user = UserLocalServiceUtil.getUser(userId);
					Person person = fetchPersonDetailsByPersonId(personalDetail.getPersonId(), themeDisplay);
					personDetails.setId(person.getId());
					personDetails.setEmail(personalDetail.getEmail());
					personDetails.setMobile(personalDetail.getMobileNumber());
					personDetails.setPersonName(user.getFullName());
					personDetails.setCivilId(person.getCivilId());
					personDetails.setPassportNumber(person.getPassportNumber());
					personDetails.setLrUserId(person.getLrUserId());
					personDetails.setPersonId(person.getId());
					Date dob = new SimpleDateFormat(DataflowConstants.OBJECT_DATE_FORMAT)
							.parse(person.getDateOfBirth());
					SimpleDateFormat sdf = new SimpleDateFormat(FacultyMembershipConstants.DD_MM_YYYY);
					String dateOfBirth = sdf.format(dob);
					personDetails.setDateOfBirth(dateOfBirth);
					return personDetails;
				}
			}
		} catch (ParseException e) {
			log.info(e.getMessage());
		} catch (UnsupportedEncodingException e) {
			log.info(e.getMessage());
		} catch (PortalException e) {
			log.info(e.getMessage());
		}
		return null;
	}

	private Person fetchPersonDetailsByPersonId(long personId, ThemeDisplay themeDisplay) {
		Person person = null;
		String personDetailsResponse = StringPool.BLANK;
		try {
			personDetailsResponse = facultyMemebershipUtil.generateObjectResponse(LRObjectURL.GET_PERSON_BY_ID_URL,
					themeDisplay.getScopeGroupId() + StringPool.QUESTION + FacultyRequestConstants.FILTER_EQ + "id"
							+ URLEncoder.encode(" " + FacultyRequestConstants.EQ + " '" + personId + "'",
									FacultyRequestConstants.UNICODE_TRANSFORMATION_FORMAT));
			log.info("personDetailsResponse " + personDetailsResponse);
			PersonItem personItems = CustomObjectMapperUtil.readValue(personDetailsResponse, PersonItem.class);
			if (Validator.isNotNull(personItems) && Validator.isNotNull(personItems.getItems())
					&& personItems.getItems().size() > 0) {
				person = personItems.getItems().get(0);
			}
		} catch (UnsupportedEncodingException e) {
			log.info(e.getMessage());
		}
		return person;
	}

	private final Log log = LogFactoryUtil.getLog(GetPersonDetailsUtil.class);

	@Reference
	private FacultyMemebershipUtil facultyMemebershipUtil;
}

package gov.omsb.registration.web.render;

import com.liferay.document.library.kernel.model.DLFileEntry;
import com.liferay.document.library.kernel.service.DLAppLocalServiceUtil;
import com.liferay.document.library.kernel.service.DLFileEntryLocalServiceUtil;
import com.liferay.document.library.util.DLURLHelperUtil;
import com.liferay.list.type.model.ListTypeEntry;
import com.liferay.list.type.service.ListTypeEntryLocalServiceUtil;
import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.exception.NoSuchUserException;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.portal.kernel.repository.model.FileEntry;
import com.liferay.portal.kernel.service.CountryLocalServiceUtil;
import com.liferay.portal.kernel.service.RoleLocalServiceUtil;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.HtmlUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.servlet.http.HttpServletRequest;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import gov.omsb.common.api.OMSBCommonApi;
import gov.omsb.common.constants.RoleNameConstants;
import gov.omsb.common.dto.Country;
import gov.omsb.common.dto.CountryItem;
import gov.omsb.common.dto.EducationDetail;
import gov.omsb.common.dto.EducationDetailItem;
import gov.omsb.common.dto.Person;
import gov.omsb.common.dto.PersonItem;
import gov.omsb.common.dto.PersonalDetail;
import gov.omsb.common.dto.PersonalDetailItem;
import gov.omsb.common.object.url.LRObjectURL;
import gov.omsb.common.picklist.constants.LRPicklistConstants;
import gov.omsb.common.util.CommonUtil;
import gov.omsb.http.connector.api.OMSBHttpConnector;
import gov.omsb.registration.web.constants.OmsbRegistrationWebPortletKeys;
import gov.omsb.registration.web.dto.EmploymentDetail;
import gov.omsb.registration.web.dto.EmploymentDetailItem;
import gov.omsb.registration.web.dto.Registration;
import gov.omsb.registration.web.dto.RoleMappingItems;
import gov.omsb.registration.web.dto.Services;
import gov.omsb.registration.web.dto.ServicesItem;
import gov.omsb.registration.web.dto.UserMetadata;
import gov.omsb.registration.web.dto.UserMetatdataItems;
import gov.omsb.registration.web.dto.UserRegistrationStatus;
import gov.omsb.registration.web.dto.UserRegistrationStatusItems;
import gov.omsb.registration.web.dto.WorkSector;
import gov.omsb.registration.web.dto.WorkSectorItems;
import gov.omsb.registration.web.util.RegistrationUtil;
import gov.omsb.tms.model.GenderMaster;
import gov.omsb.tms.model.ProgramMaster;
import gov.omsb.tms.model.ProgramTypeMaster;
import gov.omsb.tms.service.ProgramMasterLocalServiceUtil;
import gov.omsb.tms.service.ProgramTypeMasterLocalServiceUtil;

@Component(immediate = true, 
			property = {
					"javax.portlet.name=" + OmsbRegistrationWebPortletKeys.OMSBREGISTRATIONWEB,
					"mvc.command.name=/", 
					//"mvc.command.name="+ MVCCommands.VIEW_REGISTRATION_DETAILS 
					},
			service = MVCRenderCommand.class)
public class ViewMVCRenderCommand implements MVCRenderCommand {

	@Override
	public String render(RenderRequest renderRequest, RenderResponse renderResponse) throws PortletException {
		ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);
		if(themeDisplay.isSignedIn()) {
			
			CountryItem customCountryItems = registrationUtil.getCustomCountryItems(themeDisplay.getPortalURL(), themeDisplay.getScopeGroupId());
			if(Validator.isNotNull(customCountryItems) && Validator.isNotNull(customCountryItems.getItems()) && customCountryItems.getItems().size()>0) {
				renderRequest.setAttribute("customCountries", customCountryItems.getItems().stream().sorted((o1, o2)->o1.getNationality().
		                compareTo(o2.getNationality())).collect(Collectors.toList()));
			}
			List<com.liferay.portal.kernel.model.Country> countries = CountryLocalServiceUtil.getCountries(QueryUtil.ALL_POS, QueryUtil.ALL_POS);
			if(Validator.isNotNull(countries) && countries.size()>0) {
				renderRequest.setAttribute("countries", countries);
			}
			List<GenderMaster> genderMasterList = registrationUtil.getGenderMasterList(themeDisplay);
			renderRequest.setAttribute("genderList", genderMasterList.stream().sorted((o1, o2)->o1.getGenderName(themeDisplay.getLocale()).
	                compareTo(o2.getGenderName(themeDisplay.getLocale()))).collect(Collectors.toList()));
			
			List<ListTypeEntry> professionList = registrationUtil.getPickListEntries(LRPicklistConstants.PROFESSION, themeDisplay.getCompanyId());
			renderRequest.setAttribute("professionList", professionList.stream().sorted((o1, o2)->o1.getName(themeDisplay.getLocale()).
	                compareTo(o2.getName(themeDisplay.getLocale()))).collect(Collectors.toList()));
			
			List<ListTypeEntry> specialityList = registrationUtil.getPickListEntries(LRPicklistConstants.SPECIALIY, themeDisplay.getCompanyId());
			renderRequest.setAttribute("specialityList", specialityList.stream().sorted((o1, o2)->o1.getName(themeDisplay.getLocale()).
	                compareTo(o2.getName(themeDisplay.getLocale()))).collect(Collectors.toList()));
			
			List<ListTypeEntry> qualificationList = registrationUtil.getPickListEntries(LRPicklistConstants.QUALIFICATION, themeDisplay.getCompanyId());
			renderRequest.setAttribute("qualificationList", qualificationList.stream().sorted((o1, o2)->o1.getName(themeDisplay.getLocale()).
	                compareTo(o2.getName(themeDisplay.getLocale()))).collect(Collectors.toList()));
			
			List<ListTypeEntry> institutionList = registrationUtil.getPickListEntries(LRPicklistConstants.INSTITUTION, themeDisplay.getCompanyId());
			renderRequest.setAttribute("institutionList", institutionList.stream().sorted((o1, o2)->o1.getName(themeDisplay.getLocale()).
	                compareTo(o2.getName(themeDisplay.getLocale()))).collect(Collectors.toList()));
			
			if(Validator.isNotNull(qualificationList) && qualificationList.size()>0) {
				JSONArray qualificationArray=JSONFactoryUtil.createJSONArray();
				for(ListTypeEntry lt:qualificationList) {
					JSONObject qualificationObject=JSONFactoryUtil.createJSONObject();
					qualificationObject.put("key", lt.getKey());
					qualificationObject.put("name", lt.getName(themeDisplay.getLocale()));
					qualificationArray.put(qualificationObject);
				}
				renderRequest.setAttribute("qualificationArray", qualificationArray);
			}
			
			if(Validator.isNotNull(customCountryItems) && Validator.isNotNull(customCountryItems.getItems()) && customCountryItems.getItems().size()>0) {
				List<Country> countryList=customCountryItems.getItems();
				JSONArray countryArray=JSONFactoryUtil.createJSONArray();
				if(Validator.isNotNull(countryList) && countryList.size()>0) {
					for(Country country :countryList) {
						JSONObject countryObject=JSONFactoryUtil.createJSONObject();
						countryObject.put("id", country.getId());
						countryObject.put("nationality", country.getNationality());
						countryArray.put(countryObject);
					}
				}
				renderRequest.setAttribute("countryArray", countryArray);
			}
			try {
			List<ListTypeEntry> workSectorTypes = registrationUtil.getPickListEntries(LRPicklistConstants.WORK_SECTOR_TYPE, themeDisplay.getCompanyId());
			renderRequest.setAttribute("workSectorTypeList", workSectorTypes.stream().sorted((o1, o2)->o1.getName(themeDisplay.getLocale()).
	                compareTo(o2.getName(themeDisplay.getLocale()))).collect(Collectors.toList()));
			}
			catch(Exception e) {
				LOGGER.info("unable to get the workSectorTypes : "+e.getMessage());
			}
			//	List<ListTypeEntry> wilayats = registrationUtil.getPickListEntries(LRPicklistConstants.WILAYAT, themeDisplay.getCompanyId());
			try {
			List<ListTypeEntry> governorate=registrationUtil.getPickListEntries(LRPicklistConstants.GOVERNORATE, themeDisplay.getCompanyId());
			renderRequest.setAttribute("wilayats", governorate.stream().sorted((o1, o2)->o1.getName(themeDisplay.getLocale()).
	                compareTo(o2.getName(themeDisplay.getLocale()))).collect(Collectors.toList()));
			}
			catch(Exception e) {
				LOGGER.info("unable to get the governorate : "+e.getMessage());
			}
			try {
			List<ListTypeEntry> designations = registrationUtil.getPickListEntries(LRPicklistConstants.DESIGNATION, themeDisplay.getCompanyId());
			renderRequest.setAttribute("designations", designations.stream().sorted((o1, o2)->o1.getName(themeDisplay.getLocale()).
	                compareTo(o2.getName(themeDisplay.getLocale()))).collect(Collectors.toList()));
			}
			catch(Exception e) {
				LOGGER.info("unable to get the designations : "+e.getMessage());
			}
			if(themeDisplay.getLayout().getName(themeDisplay.getLocale()).equalsIgnoreCase(OmsbRegistrationWebPortletKeys.MY_PROFILE_PAGE_NAME)) {
				try {
				List<ProgramTypeMaster> programTypeMasterList=registrationUtil.getProgramType(themeDisplay);	
				renderRequest.setAttribute("programTypeMasterList", programTypeMasterList.stream().sorted((o1, o2)->o1.getProgramTypeName(themeDisplay.getLocale()).
		                compareTo(o2.getProgramTypeName(themeDisplay.getLocale()))).collect(Collectors.toList()));				
				}
				catch(Exception e) {
					LOGGER.info("unable to get the programTypeMasterList : "+e.getMessage());
				}
				try {
				List<ProgramMaster> programList=registrationUtil.getProgram(themeDisplay);
				renderRequest.setAttribute("programList", programList.stream().sorted((o1, o2)->o1.getProgramName(themeDisplay.getLocale()).
		                compareTo(o2.getProgramName(themeDisplay.getLocale()))).collect(Collectors.toList()));
				}
				catch(Exception e) {
					LOGGER.info("unable to get the programList : "+e.getMessage());
				}
				try {
				List<ListTypeEntry> programPositionList = registrationUtil.getPickListEntries(LRPicklistConstants.PROGRAM_POSITION, themeDisplay.getCompanyId());
				renderRequest.setAttribute("programPositionList", programPositionList.stream().sorted((o1, o2)->o1.getName(themeDisplay.getLocale()).
		                compareTo(o2.getName(themeDisplay.getLocale()))).collect(Collectors.toList()));
				}
				catch(Exception e) {
					LOGGER.info("unable to get the programPositionList : "+e.getMessage());
				}
				try {
				List<ListTypeEntry> purposeList = registrationUtil.getPickListEntries(LRPicklistConstants.PURPOSE, themeDisplay.getCompanyId());
				renderRequest.setAttribute("purposeList", purposeList.stream().sorted((o1, o2)->o1.getName(themeDisplay.getLocale()).
		                compareTo(o2.getName(themeDisplay.getLocale()))).collect(Collectors.toList()));
				}
				catch(Exception e) {
					LOGGER.info("unable to get the purposeList : "+e.getMessage());
				}
				
				try {
				RoleMappingItems roleMappingItems=registrationUtil.fetchRoleMapping(themeDisplay, RoleNameConstants.ROLE_TYPE_REGISTRATION);
				if(Validator.isNotNull(roleMappingItems)) {
					renderRequest.setAttribute("omsbRoleList", registrationUtil.getOMSBRoles(roleMappingItems));
				}
				}
				catch(Exception e) {
					LOGGER.info("unable to get the roleMappingItems : "+e.getMessage());
				}
				
				try {
				List<ListTypeEntry> departmentList = registrationUtil.getPickListEntries(LRPicklistConstants.DEPARTMENT, themeDisplay.getCompanyId());
				renderRequest.setAttribute("departmentList", departmentList.stream().sorted((o1, o2)->o1.getName(themeDisplay.getLocale()).
		                compareTo(o2.getName(themeDisplay.getLocale()))).collect(Collectors.toList()));
				}catch(Exception e) {
					LOGGER.info("unable to get the departmentList : "+e.getMessage());
				}
				try {
				List<ListTypeEntry> sectionList = registrationUtil.getPickListEntries(LRPicklistConstants.SECTION, themeDisplay.getCompanyId());
				renderRequest.setAttribute("sectionList", sectionList.stream().sorted((o1, o2)->o1.getName(themeDisplay.getLocale()).
		                compareTo(o2.getName(themeDisplay.getLocale()))).collect(Collectors.toList()));
				}
				catch(Exception e) {
					LOGGER.info("unable to get the sectionList : "+e.getMessage());
				}
				try {
				List<ListTypeEntry> functionList = registrationUtil.getPickListEntries(LRPicklistConstants.FUNCTION, themeDisplay.getCompanyId());
				renderRequest.setAttribute("functionList", functionList.stream().sorted((o1, o2)->o1.getName(themeDisplay.getLocale()).
		                compareTo(o2.getName(themeDisplay.getLocale()))).collect(Collectors.toList()));
				}
				catch(Exception e) {
					LOGGER.info("unable to get the functionList : "+e.getMessage());
				}
				try {
				List<ListTypeEntry> committeList = registrationUtil.getPickListEntries(LRPicklistConstants.COMMITTEE, themeDisplay.getCompanyId());
				renderRequest.setAttribute("committeList", committeList.stream().sorted((o1, o2)->o1.getName(themeDisplay.getLocale()).
		                compareTo(o2.getName(themeDisplay.getLocale()))).collect(Collectors.toList()));
				}catch(Exception e) {
					LOGGER.info("unable to get the committeList : "+e.getMessage());
				}
				
				
				/*
				 * try { List<ListTypeEntry> serviceList =
				 * registrationUtil.getPickListEntries(LRPicklistConstants.SERVICE,
				 * themeDisplay.getCompanyId()); renderRequest.setAttribute("serviceList",
				 * serviceList.stream().sorted((o1, o2)->o1.getName(themeDisplay.getLocale()).
				 * compareTo(o2.getName(themeDisplay.getLocale()))).collect(Collectors.toList())
				 * ); } catch(Exception e) {
				 * LOGGER.info("unable to get the committeList : "+e.getMessage()); }
				 */
				
				
				ServicesItem services=null;
				try {
					services = registrationUtil.getServices(themeDisplay.getPortalURL(),themeDisplay.getScopeGroupId());
				} catch (Exception e2) {
					LOGGER.error("unable to get the services : "+e2.getMessage());
				}
				LOGGER.info("services :: "+services);
				List<Services> serviceList1=new ArrayList<Services>();
				if(Validator.isNotNull(services) && Validator.isNotNull(services.getItems())) {
					for(Services service:services.getItems()) {
						try {
							service.setServiceId(omsbCommonApi.getListTypeEntryByListTypeItemKey(LRPicklistConstants.SERVICE, service.getServiceId(), themeDisplay.getCompanyId()).getName(themeDisplay.getLocale()));
							serviceList1.add(service);
							LOGGER.info(service);
						} catch(Exception e) {
							LOGGER.error("unable to get the list type with key : "+service.getServiceId()+"  ::: "+e.getMessage());
						}
					}
				}
				renderRequest.setAttribute("serviceList",serviceList1);
				
				
				try {
					PersonItem personItem = registrationUtil.fetchPersonByLrUserId(themeDisplay, themeDisplay.getUserId());
					LOGGER.info("personItem :: "+personItem);
					if(Validator.isNotNull(personItem) && Validator.isNotNull(personItem.getItems()) && personItem.getItems().size()>0) {
						Person person=personItem.getItems().get(0);
						if(Validator.isNotNull(person) && person.getId() > 0) {
							person.setDateOfBirth(omsbCommonApi.convertObjectDateToNewDDMMYYYYDate(person.getDateOfBirth()));
							renderRequest.setAttribute("person", person);
							try {
								User user = UserLocalServiceUtil.getUser(person.getLrUserId());
								LOGGER.info(user.getPortraitId());
								if(Validator.isNotNull(user.getPortraitId())) {
									//DLFileEntry dlFileEntry = DLFileEntryLocalServiceUtil.getDLFileEntry(user.getPortraitId());
									try {
										FileEntry entry = DLAppLocalServiceUtil.getFileEntry(user.getPortraitId());
										renderRequest.setAttribute("photo", entry.getDescription());
										String documentViewURL = DLURLHelperUtil.getPreviewURL(entry, entry.getFileVersion(), themeDisplay, "");
										LOGGER.info("documentViewURL :::::"+documentViewURL);
										renderRequest.setAttribute("photoURL",documentViewURL);
									}catch(PortalException e) {
										LOGGER.error("unable to get the file entry having id "+user.getPortraitId());
									}
								} 
								LOGGER.info("userid "+user.getUserId() );
								renderRequest.setAttribute("user_", user);
							} catch (PortalException e) {
								LOGGER.error("Error while getting user info, "+e.getMessage());
							}
							PersonalDetail personalDetail = getPersonalDetailByLrUserId(themeDisplay, person.getId());
							if(Validator.isNotNull(personalDetail)) {
								try {
									long professionId=omsbCommonApi.getListTypeEntryByListTypeItemKey(LRPicklistConstants.PROFESSION, personalDetail.getProfession(), themeDisplay.getCompanyId()).getListTypeEntryId();
									personalDetail.setProfession(String.valueOf(professionId));
								} catch(Exception e) {
									e.getMessage();
								}
								renderRequest.setAttribute("personalDetails", personalDetail);
								
								try {
									FileEntry entry = DLAppLocalServiceUtil.getFileEntry(personalDetail.getCivilCardFrontPhotoId());
									renderRequest.setAttribute("civilCardFrontPhoto", entry.getDescription());
									renderRequest.setAttribute("civilCardFrontPhotoURL",DLURLHelperUtil.getPreviewURL(entry, entry.getFileVersion(), themeDisplay, ""));
								}catch(PortalException e) {
									LOGGER.error("unable to get the file entry having id  "+personalDetail.getCivilCardFrontPhotoId());
								}
								
								try {
									FileEntry entry = DLAppLocalServiceUtil.getFileEntry(personalDetail.getCivilCardBackPhotoId());
									renderRequest.setAttribute("civilCardBackPhoto", entry.getDescription());
									renderRequest.setAttribute("civilCardBackPhotoURL",DLURLHelperUtil.getPreviewURL(entry, entry.getFileVersion(), themeDisplay, ""));
								}catch(PortalException e) {
									LOGGER.error("unable to get the file entry having id  "+personalDetail.getCivilCardBackPhotoId());
								}
								
								try {
									FileEntry entry = DLAppLocalServiceUtil.getFileEntry(personalDetail.getPassportPhotoId());
									LOGGER.info("entry.getDescription() ::::" +entry.getDescription());
									LOGGER.info("Preview URL  ::::" +DLURLHelperUtil.getPreviewURL(entry, entry.getFileVersion(), themeDisplay, ""));
									
									renderRequest.setAttribute("passportPhoto", entry.getDescription());
									renderRequest.setAttribute("passportPhotoURL",DLURLHelperUtil.getPreviewURL(entry, entry.getFileVersion(), themeDisplay, ""));
								}catch(PortalException e) {
									LOGGER.error("unable to get the file entry having id  "+personalDetail.getPassportPhotoId());
								}
								try {
									FileEntry entry = DLAppLocalServiceUtil.getFileEntry(personalDetail.getCvDocumentId());
									LOGGER.info("entry : "+entry);
									LOGGER.info("entry.getDescription(): "+entry.getDescription());
									renderRequest.setAttribute("cvDocument", entry.getDescription());
									renderRequest.setAttribute("cvDocumentURL",DLURLHelperUtil.getPreviewURL(entry, entry.getFileVersion(), themeDisplay, ""));
								}catch(PortalException e) {
									LOGGER.error("unable to get the file entry having id  "+personalDetail.getCvDocumentId());
								}
								
								if(Validator.isNotNull(personalDetail.getLrUserId()) && personalDetail.getLrUserId() > 0) {
									UserMetatdataItems  userMetadataItem =registrationUtil.getUserMetadataItems(themeDisplay.getPortalURL(), themeDisplay.getScopeGroupId(), person.getLrUserId());
									boolean hasPendingRole=false;
									boolean hasServicePending=true;
									if(Validator.isNotNull(userMetadataItem) && userMetadataItem.getItems().size()>0) {
										List<UserMetadata>  userMetadataList1 =new ArrayList<>();
										for(UserMetadata userMetadata : userMetadataItem.getItems()) {
											//UserMetadata userMetadata=userMetadataItem.getItems().get(0);
											try {
												userMetadata.setRoleName(RoleLocalServiceUtil.getRole(userMetadata.getRoleId()).getName());
											} catch (PortalException e) {
												LOGGER.error(e.getMessage());
											}
										
											long programTypeId=0;	
											LOGGER.info("userMetadata.getProgramId() :::::"+userMetadata.getProgramId());
											if(Validator.isNotNull(userMetadata.getProgramId())) {
												try {
													 ProgramMaster programMaster=ProgramMasterLocalServiceUtil.getProgramMaster(userMetadata.getProgramId());
													 programTypeId= ProgramMasterLocalServiceUtil.getProgramMaster(userMetadata.getProgramId()).getProgramTypeId();
													 userMetadata.setProgramName(CommonUtil.getValueByLanguage(programMaster.getProgramName(),"ProgramName",
																themeDisplay.getLocale().toString())      );
												} catch (Exception e) {
													LOGGER.error(e.getMessage());
												}
												userMetadata.setProgramTypeId(programTypeId);
												if(programTypeId>0) {
													try {
														LOGGER.info("ProgramTypeMasterLocalServiceUtil.getProgramTypeMaster(programTypeId).getProgramTypeName() :::"+ProgramTypeMasterLocalServiceUtil.getProgramTypeMaster(programTypeId).getProgramTypeName());
														userMetadata.setProgramTypeName(CommonUtil.getValueByLanguage(ProgramTypeMasterLocalServiceUtil.getProgramTypeMaster(programTypeId).getProgramTypeName(), OmsbRegistrationWebPortletKeys.PROGRAM_TYPE_NAME,
																themeDisplay.getLocale().toString()));
													} catch (PortalException e) {
														LOGGER.error(e.getMessage());
													}
												}
											}
											if(Validator.isNotNull(userMetadata.getDepartmentId())){
												userMetadata.setDepartmentId(omsbCommonApi.getListTypeEntryByListTypeItemKey(LRPicklistConstants.DEPARTMENT, userMetadata.getDepartmentId(), themeDisplay.getCompanyId()).getName(themeDisplay.getLocale()));
											}
											if(Validator.isNotNull(userMetadata.getSectionId())){
												userMetadata.setSectionId(omsbCommonApi.getListTypeEntryByListTypeItemKey(LRPicklistConstants.SECTION, userMetadata.getSectionId(), themeDisplay.getCompanyId()).getName(themeDisplay.getLocale()));
											}
											//Get Role verfied status
											if(Validator.isNotNull(userMetadata) && userMetadata.getId()>0 && userMetadata.getRoleId()>0){
												hasServicePending=false;
												try {
													LOGGER.info("userMetadata.getId() ::::" +userMetadata.getId());
													UserRegistrationStatusItems userRoleStatusItems = registrationUtil.getRoleStatusByUserMetadataId(themeDisplay.getPortalURL(), themeDisplay.getScopeGroupId(), userMetadata.getId());
													LOGGER.info("userRoleStatusItems ::::" +userRoleStatusItems.getItems().size());
													if (Validator.isNotNull(userRoleStatusItems)&& Validator.isNotNull(userRoleStatusItems.getItems())&& userRoleStatusItems.getItems().size() > 0) {
														UserRegistrationStatus userRegistrationStatus = userRoleStatusItems.getItems().get(0);
														LOGGER.info("userRegistrationStatus.userRegistrationStatus()e:::"+ userRegistrationStatus.getUserStatus());
														LOGGER.info("userRegistrationStatus.userRegistrationStatus.getId() :::"+ userRegistrationStatus.getId());
														LOGGER.info("userRegistrationStatus.getComment()e:::"+ userRegistrationStatus.getComment());
														
														if(!hasPendingRole) {
															if(userRegistrationStatus.getUserStatus().equalsIgnoreCase(OmsbRegistrationWebPortletKeys.PENDING_WF_STATUS)) {
																hasPendingRole=true;
															}
														}
														userMetadata.setRoleVerifiedStatus(Validator.isNotNull(userRegistrationStatus.getUserStatus())? userRegistrationStatus.getUserStatus():"NA");
														userMetadata.setRoleVerifiedComments(Validator.isNotNull(userRegistrationStatus.getComment())? HtmlUtil.escape(userRegistrationStatus.getComment()):"NA");
														userMetadata.setUserRoleStatusId(Validator.isNotNull(userRegistrationStatus.getId())?userRegistrationStatus.getId():0);
													}else{
														hasPendingRole=true;
													}
												} catch (Exception e) {
													LOGGER.error("Exception ::"+e.getMessage());
												}
											}else if (Validator.isNotNull(userMetadata) && userMetadata.getId()>0 && userMetadata.getRoleId()==0) {
												if(!hasServicePending) {
													hasServicePending=true;
												}
											}
											LOGGER.info("User Meta data Items :::::"+userMetadataItem.getItems());
											
											if (Validator.isNotNull(userMetadata) && userMetadata.getId()>0 && userMetadata.getRoleId()>0) {
												userMetadataList1.add(userMetadata);
											}
											
											renderRequest.setAttribute("userMetadata", userMetadata);
											
										}
										userMetadataItem.setItems(userMetadataList1);
										LOGGER.info("hasPendingRole ::::::"+hasPendingRole);
										LOGGER.info("hasServicePending ::::::"+hasServicePending);
										renderRequest.setAttribute("hasServicePending", hasServicePending);
										renderRequest.setAttribute("userMetadataItem", userMetadataItem);
										renderRequest.setAttribute("hasPendingRole", hasPendingRole);
										renderRequest.setAttribute("hasServicePending", hasServicePending);
									}
								}
							}
														
							//Get verification  status
							try {
								UserRegistrationStatusItems userRegistrationStatusItems = registrationUtil.getRegistrationStatusByPersonId(themeDisplay.getPortalURL(), themeDisplay.getScopeGroupId(), person.getId());
								LOGGER.info("userRegistrationStatusItems ::::" +userRegistrationStatusItems.getItems().size());
								
								if(Validator.isNotNull(userRegistrationStatusItems) && Validator.isNotNull(userRegistrationStatusItems.getItems()) && userRegistrationStatusItems.getItems().size()>0) {
									UserRegistrationStatus userRegistrationStatus =	userRegistrationStatusItems.getItems().get(0);
									LOGGER.info("userRegistrationStatus.getUserStatus()e:::"+userRegistrationStatus.getUserStatus());
									renderRequest.setAttribute("userVerificationProfileStatus",Validator.isNotNull(userRegistrationStatus)?userRegistrationStatus.getUserStatus():"NA");
									renderRequest.setAttribute("userVerificationProfileComments",Validator.isNotNull(userRegistrationStatus)?userRegistrationStatus.getComment():"NA");
								}
							} catch (Exception e) {
								LOGGER.error("Exception ::"+e.getMessage());
							}
							
							//Get Role Status Items
							try {
								UserRegistrationStatusItems userRegistrationRoleStatusItems = registrationUtil.getRoleStatusByUserId(themeDisplay.getPortalURL(), themeDisplay.getScopeGroupId(), person.getId());
								LOGGER.info("userRegistrationRoleStatusItems ::::" +userRegistrationRoleStatusItems.getItems().size());
								if(Validator.isNotNull(userRegistrationRoleStatusItems) && Validator.isNotNull(userRegistrationRoleStatusItems.getItems()) && userRegistrationRoleStatusItems.getItems().size()>0) {
									UserRegistrationStatus userRegistrationRoleStatus =	userRegistrationRoleStatusItems.getItems().get(0);
									LOGGER.info("userVerificationRoleStatus.getUserStatus()e:>>>>>>::"+userRegistrationRoleStatus.getUserStatus());
									LOGGER.info("userVerificationRoleComments.getUserStatus()e:>>>>>::"+userRegistrationRoleStatus.getComment());
									
									renderRequest.setAttribute("userVerificationRoleStatus",Validator.isNotNull(userRegistrationRoleStatus)?userRegistrationRoleStatus.getUserStatus():"NA");
									renderRequest.setAttribute("userVerificationRoleComments",Validator.isNotNull(userRegistrationRoleStatus)?userRegistrationRoleStatus.getComment():"NA");
								}
							} catch (Exception e) {
								LOGGER.error("Exception ::"+e.getMessage());
							}
							
							//LOGGER.info("userRegistrationStatusItems :::"+userRegistrationStatusItems);
							//LOGGER.info("userRegistrationStatusItems size:::"+userRegistrationStatusItems.getItems().size());
							LOGGER.info("person.getLrUserId() ::::::::::---------->>>>>>>>>>>>>"+person.getLrUserId());
				            LOGGER.info("themeDisplay.getUserId() : "+themeDisplay.getUserId());
						//	renderRequest.setAttribute("lrUserId", person.getLrUserId());
							
							renderRequest.setAttribute("personId", person.getId());
						}
					} else {
						try {
							User user = UserLocalServiceUtil.getUser(themeDisplay.getUserId());
							if(Validator.isNotNull(user.getPortraitId())) {
								FileEntry entry = DLAppLocalServiceUtil.getFileEntry(user.getPortraitId());
								renderRequest.setAttribute("photo", entry.getDescription());
								String documentViewURL = DLURLHelperUtil.getPreviewURL(entry, entry.getFileVersion(), themeDisplay, "");
								renderRequest.setAttribute("photoURL",documentViewURL );
							} 
							renderRequest.setAttribute("user_", user);
						} catch (PortalException e) {
							LOGGER.error("Error while getting user info, "+e.getMessage());
						}
						renderRequest.setAttribute("userVerificationProfileStatus","NA");
						renderRequest.setAttribute("userVerificationProfileComments","NA");
					}
					renderRequest.setAttribute("lrUserId", themeDisplay.getUserId());
					LOGGER.info("user id : "+themeDisplay.getUserId());
					List<EducationDetail> educationDetailList=null;
					EmploymentDetailItem workDetailItems = null;
					EmploymentDetailItem secondaryWorkDetailItems = null;
					LOGGER.info("inside view get work details ");
					EmploymentDetailItem employmentDetailItem=null;					
					if(Validator.isNotNull(personItem) && Validator.isNotNull(personItem.getItems()) && personItem.getItems().size()>0) {
						LOGGER.info("user id : inside if");
						educationDetailList = getEducationDetailList(themeDisplay, personItem.getItems().get(0).getId());
						try {
							workDetailItems = registrationUtil.getWorkDetailsByPersonIdAndWorkDetailType(themeDisplay.getPortalURL(),
									themeDisplay.getScopeGroupId(), personItem.getItems().get(0).getId(),"1");
						} catch (Exception e) {
							LOGGER.error("workDetailItems exception:" + e.getMessage());
						}
						try {
							secondaryWorkDetailItems = registrationUtil.getWorkDetailsByPersonIdAndWorkDetailType(themeDisplay.getPortalURL(),
									themeDisplay.getScopeGroupId(), personItem.getItems().get(0).getId(),"2");
						} catch (Exception e) {
							LOGGER.error("secondaryWorkDetailItems exception:" + e.getMessage());
						}
						try {
							employmentDetailItem=registrationUtil.getWorkDetailsByPersonIdAndWorkDetailType(themeDisplay.getPortalURL(),
									themeDisplay.getScopeGroupId(),  personItem.getItems().get(0).getId(),"0");
						} catch (Exception e) {
							LOGGER.error("Exception in code :::"+e.getMessage());
						}
					}
					else {
						LOGGER.info("user id : inside else");
					educationDetailList = getEducationDetailListByLrUserId(themeDisplay,themeDisplay.getUserId());
					workDetailItems=registrationUtil.getWorkDetailsByLrUserIdAndWorkDetailType(themeDisplay.getPortalURL(), themeDisplay.getScopeGroupId(), themeDisplay.getUserId(), "1");
					secondaryWorkDetailItems=registrationUtil.getWorkDetailsByLrUserIdAndWorkDetailType(themeDisplay.getPortalURL(), themeDisplay.getScopeGroupId(), themeDisplay.getUserId(), "2");
					employmentDetailItem=registrationUtil.getWorkDetailsByLrUserIdAndWorkDetailType(themeDisplay.getPortalURL(), themeDisplay.getScopeGroupId(), themeDisplay.getUserId(), "0");
					LOGGER.info("educationDetailList "+educationDetailList);
					//if(Validator.isNotNull(educationDetailList)) {
					//}
					}
					renderRequest.setAttribute("educationalDetailItemList", educationDetailList);
					
					//Changes
					//Get Primary Work Detail 
					
				
					if(Validator.isNotNull(workDetailItems) && Validator.isNotNull(workDetailItems.getItems()) && workDetailItems.getItems().size()>0) {
						EmploymentDetail workDetail=workDetailItems.getItems().get(0);
						FileEntry entry=null;
							try {
								ListTypeEntry listTypeEntry =null;
								
								//Get Work sector Type 
								if(Validator.isNotNull(workDetail.getWorkSectorType())) {
									long workSectorTypeID=Long.parseLong(workDetail.getWorkSectorType());
									listTypeEntry = ListTypeEntryLocalServiceUtil.getListTypeEntry(workSectorTypeID);
								}
								
								//Get Work sector  
								if(Validator.isNotNull(listTypeEntry)&&	!listTypeEntry.getKey().equalsIgnoreCase("others")) {
										
										WorkSectorItems workSectorItems = registrationUtil.getWorkSectorsByWorkSectorType(themeDisplay.getPortalURL(), themeDisplay.getScopeGroupId(), workDetail.getWorkSectorType());
										LOGGER.info("workSectorItems in other than other :: "+workSectorItems.getItems().size());
										workDetail.setWorkSectorItems(workSectorItems);
										LOGGER.info("Worke sector items ::::"+workDetail.getWorkSectorItems().getItems().get(0).getWorkSector());
									}
								
								
								if(Validator.isNotNull(workDetail.getWorkSectorId()) && workDetail.getWorkSectorId()>0) {
									WorkSectorItems workSectorItems=registrationUtil.getWorkSectorByParentId(themeDisplay.getPortalURL(), themeDisplay.getScopeGroupId(), workDetail.getWorkSectorId());
									workDetail.setWorkSubSectorItems(workSectorItems);
								}
								
								
								
								//Get Work Sub Sector 
								if(Validator.isNotNull(workDetail.getWorkSectorId2()) && workDetail.getWorkSectorId2()>0) {
									WorkSectorItems workSectorItems=registrationUtil.getWorkSectorByParentId(themeDisplay.getPortalURL(), themeDisplay.getScopeGroupId(), workDetail.getWorkSectorId());
									workDetail.setWorkSubSectorItems(workSectorItems);
								}
								
								
								//Get work second sub sectors 
								if(Validator.isNotNull(workDetail.getWorkSectorId2()) && workDetail.getWorkSectorId2()>0) {
									WorkSectorItems workSectorItems=registrationUtil.getWorkSectorByParentId(themeDisplay.getPortalURL(), themeDisplay.getScopeGroupId(), workDetail.getWorkSectorId2());
									workDetail.setWorkSecondSubSectorItems(workSectorItems);
								}
								
								
									
								if(Validator.isNotNull(workDetail.getStaffIdCard()) && Long.valueOf(workDetail.getStaffIdCard()) > 0) {
									workDetail.setUploadFileName(DLFileEntryLocalServiceUtil.getDLFileEntry(Long.valueOf(workDetail.getStaffIdCard())).getFileName());
									try {
										 entry = DLAppLocalServiceUtil.getFileEntry( Long.valueOf(workDetail.getStaffIdCard()));
										workDetail.setDocumentUrl(DLURLHelperUtil.getPreviewURL(entry, entry.getFileVersion(), themeDisplay, StringPool.BLANK));
									} catch (PortalException e) {
										LOGGER.error("Error in  code :::" + e.getMessage());
									}
								}
								
								
								if(Validator.isNotNull( workDetail.getWorkSector())) {
									WorkSectorItems workSectorsItems = registrationUtil.getWorkSectorDetailByWorkSector(themeDisplay, workDetail.getWorkSector());
									if(Validator.isNotNull(workSectorsItems.getItems()) && workSectorsItems.getItems().size()>0)
										workDetail.setWorkSector(workSectorsItems.getItems().get(0).getWorkSector());
			                    }
								LOGGER.debug("workDetail :: " + workDetail);
						} catch (Exception e) {
							LOGGER.error("Error :::::"+e.getMessage());
						}
							LOGGER.info("workDetailItems Size :::::"+ workDetailItems.getItems().size());
						renderRequest.setAttribute("primaryworkDetail", workDetail);
					}
					//Secondary
					if(Validator.isNotNull(secondaryWorkDetailItems) &&	Validator.isNotNull(secondaryWorkDetailItems.getItems()) && secondaryWorkDetailItems.getItems().size()>0) {
						EmploymentDetail secondaryWorkDetail=secondaryWorkDetailItems.getItems().get(0);
						FileEntry entry=null;
							try {
								ListTypeEntry listTypeEntry =null;
								//Get Work sector Type 
								if(Validator.isNotNull(secondaryWorkDetail.getWorkSectorType())) {
									long workSectorTypeID=Long.parseLong(secondaryWorkDetail.getWorkSectorType());
									listTypeEntry = ListTypeEntryLocalServiceUtil.getListTypeEntry(workSectorTypeID);
								}
								//Get Work sector  
								if(Validator.isNotNull(listTypeEntry)&&	!listTypeEntry.getKey().equalsIgnoreCase("others")) {
										WorkSectorItems workSectorItems = registrationUtil.getWorkSectorsByWorkSectorType(themeDisplay.getPortalURL(), themeDisplay.getScopeGroupId(), secondaryWorkDetail.getWorkSectorType());
										LOGGER.info("workSectorItems in other than other :: "+workSectorItems.getItems().size());
										secondaryWorkDetail.setWorkSectorItems(workSectorItems);
										LOGGER.info("Worke sector items ::::"+secondaryWorkDetail.getWorkSectorItems().getItems().get(0).getWorkSector());
								}
								
								
								
								if(Validator.isNotNull(secondaryWorkDetail.getWorkSectorId()) && secondaryWorkDetail.getWorkSectorId()>0) {
									WorkSectorItems workSectorItems=registrationUtil.getWorkSectorByParentId(themeDisplay.getPortalURL(), themeDisplay.getScopeGroupId(), secondaryWorkDetail.getWorkSectorId());
									secondaryWorkDetail.setWorkSubSectorItems(workSectorItems);
								}
								
								
								//Get Work Sub Sector 
								if(Validator.isNotNull(secondaryWorkDetail.getWorkSectorId2()) && secondaryWorkDetail.getWorkSectorId2()>0) {
									WorkSectorItems workSectorItems=registrationUtil.getWorkSectorByParentId(themeDisplay.getPortalURL(), themeDisplay.getScopeGroupId(), secondaryWorkDetail.getWorkSectorId());
									
									LOGGER.info("workSectorItems ::::"+workSectorItems);
									secondaryWorkDetail.setWorkSubSectorItems(workSectorItems);
								}
								
								
								//Get work second sub sectors 
								/*if(Validator.isNotNull(secondaryWorkDetail.getWorkSectorId3()) && secondaryWorkDetail.getWorkSectorId3()>0) {
									WorkSectorItems workSectorItems=registrationUtil.getWorkSectorByParentId(themeDisplay.getPortalURL(), themeDisplay.getScopeGroupId(), secondaryWorkDetail.getWorkSectorId2());
									secondaryWorkDetail.setWorkSecondSubSectorItems(workSectorItems);
								}*/
								
								//Get work second sub sectors 
								if(Validator.isNotNull(secondaryWorkDetail.getWorkSectorId2()) && secondaryWorkDetail.getWorkSectorId2()>0) {
									WorkSectorItems workSectorItems=registrationUtil.getWorkSectorByParentId(themeDisplay.getPortalURL(), themeDisplay.getScopeGroupId(), secondaryWorkDetail.getWorkSectorId2());
									secondaryWorkDetail.setWorkSecondSubSectorItems(workSectorItems);
								}
								
								
								LOGGER.info("secondaryWorkDetail.getStaffIdCard() ::::" +secondaryWorkDetail.getStaffIdCard());
								if(Validator.isNotNull(secondaryWorkDetail.getStaffIdCard()) && Long.valueOf(secondaryWorkDetail.getStaffIdCard()) > 0) {
									secondaryWorkDetail.setUploadFileName(DLFileEntryLocalServiceUtil.getDLFileEntry(Long.valueOf(secondaryWorkDetail.getStaffIdCard())).getFileName());
									try {
										 entry = DLAppLocalServiceUtil.getFileEntry( Long.valueOf(secondaryWorkDetail.getStaffIdCard()));
										 LOGGER.info("entry :::::"+entry);
										 secondaryWorkDetail.setDocumentUrl(DLURLHelperUtil.getPreviewURL(entry, entry.getFileVersion(), themeDisplay, StringPool.BLANK));
									} catch (PortalException e) {
										LOGGER.error("Error in  code :::" + e.getMessage());
									}
								}
								if(Validator.isNotNull( secondaryWorkDetail.getWorkSector())) {
									WorkSectorItems workSectorsItems = registrationUtil.getWorkSectorDetailByWorkSector(themeDisplay, secondaryWorkDetail.getWorkSector());
									if(Validator.isNotNull(workSectorsItems.getItems()) && workSectorsItems.getItems().size()>0)
										secondaryWorkDetail.setWorkSector(workSectorsItems.getItems().get(0).getWorkSector());
			                    }
								
								LOGGER.info(""+secondaryWorkDetail.getWorkSectorOther());
								LOGGER.debug("workDetail :: " + secondaryWorkDetail);
						} catch (Exception e) {
							LOGGER.error("Error :::::"+e.getMessage());
						}
							LOGGER.info("secondaryWorkDetailItems Size :::::"+ secondaryWorkDetailItems.getItems().size());
						renderRequest.setAttribute("secondaryWorkDetail", secondaryWorkDetail);
					}
					
					
					//Getting past work details
					if(Validator.isNotNull(employmentDetailItem) && Validator.isNotNull(employmentDetailItem.getItems()) && employmentDetailItem.getItems().size()>0) {
						
						List<EmploymentDetail> 	employmentDetailList=employmentDetailItem.getItems();	
						
						
						if(Validator.isNotNull(employmentDetailList) && employmentDetailList.size()>0) {
							
							for(EmploymentDetail employmentDetail :employmentDetailList) {
								
								LOGGER.info("employmentDetail 1::: " +employmentDetail.getWorkSectorType());
								ListTypeEntry listTypeEntry = null;
								long workSectorTypeID = Long.parseLong(employmentDetail.getWorkSectorType());
								try {
									listTypeEntry = ListTypeEntryLocalServiceUtil.getListTypeEntry(workSectorTypeID);
								} catch (PortalException e) {
									LOGGER.error("Exception in code :::" + e.getMessage());
								}
								
								if(Validator.isNotNull(employmentDetail.getWorkSectorTypeOther())) {
									employmentDetail.setWorkSectorType(employmentDetail.getWorkSectorTypeOther());
								}else {
									employmentDetail.setWorkSectorType(Validator.isNotNull(listTypeEntry)?listTypeEntry.getName(themeDisplay.getLocale()):StringPool.BLANK);
								}
								
								WorkSector workSector=null;
								try {
									workSector=registrationUtil.getWorkSectorById(themeDisplay.getPortalURL(), employmentDetail.getWorkSectorId());
								} catch (Exception e) {
									LOGGER.error("Exception in code :::" + e.getMessage());
								}
								
								if(Validator.isNotNull(employmentDetail.getWorkSectorOther())) {
									employmentDetail.setWorkSector(employmentDetail.getWorkSectorOther());
								}else {
									employmentDetail.setWorkSector(Validator.isNotNull(workSector)?workSector.getWorkSector():StringPool.BLANK );
								}
								WorkSector workSector2=null;
								if(Validator.isNotNull(employmentDetail.getWorkSectorId2())) {
									
									try {
										workSector2=registrationUtil.getWorkSectorById(themeDisplay.getPortalURL(), employmentDetail.getWorkSectorId2());
									} catch (Exception e) {
										LOGGER.error("Exception in code :::" + e.getMessage());
									}
								}
								
								if(Validator.isNotNull(employmentDetail.getWorkSectorOther2())) {
									employmentDetail.setWorkSector2(employmentDetail.getWorkSectorOther2());
								}else {
									employmentDetail.setWorkSector2(Validator.isNotNull(workSector2)?workSector2.getWorkSector():StringPool.BLANK );
								}
								
								
								WorkSector workSector3=null;
								if(Validator.isNotNull(employmentDetail.getWorkSectorId3())) {
									try {
										workSector3=registrationUtil.getWorkSectorById(themeDisplay.getPortalURL(), employmentDetail.getWorkSectorId3());
									} catch (Exception e) {
										LOGGER.error("Exception in code :::" + e.getMessage());
									}
								}
								
								if(Validator.isNotNull(employmentDetail.getWorkSectorOther3())) {
									employmentDetail.setWorkSector3(employmentDetail.getWorkSectorOther3());
								}else {
									employmentDetail.setWorkSector3(Validator.isNotNull(workSector3)?workSector3.getWorkSector():StringPool.BLANK );
								}

								if(Validator.isNotNull(employmentDetail.getDesignationOther())) {
									employmentDetail.setDesignationId(employmentDetail.getDesignationOther());
								}else {
										try {
											employmentDetail.setDesignationId(omsbCommonApi.getListTypeEntryByListTypeItemKey(LRPicklistConstants.DESIGNATION, employmentDetail.getDesignationId(), themeDisplay.getCompanyId()).getName(themeDisplay.getLocale()));
										} catch (Exception e) {
										LOGGER.error("Exception ::"+e.getMessage());
										}
								}
								try {
									employmentDetail.setWorkSectorLocation(omsbCommonApi.getListTypeEntryByListTypeItemKey(LRPicklistConstants.GOVERNORATE, employmentDetail.getWorkSectorLocation(), themeDisplay.getCompanyId()).getName(themeDisplay.getLocale()));
								} catch (Exception e) {
									LOGGER.error("Exception ::"+e.getMessage());
								}
								//employmentDetail.setDesignationId(omsbCommonApi.getListTypeEntryByListTypeItemKey(LRPicklistConstants.DESIGNATION, employmentDetail.getDesignationId(), themeDisplay.getCompanyId()).getName(themeDisplay.getLocale()))										
							}
						}
						renderRequest.setAttribute("pastWorkDetails", employmentDetailList);
					}

					
					
					
				} catch (UnsupportedEncodingException e1) {
					LOGGER.info("unable to fetch Person by lrUrser id "+themeDisplay.getUserId());
				}
				return OmsbRegistrationWebPortletKeys.EDIT_REGISTRATION_DETAILS_JSP;
			} else {
				try {
					boolean isProfileApprover = RoleLocalServiceUtil.hasUserRole(themeDisplay.getUserId(), themeDisplay.getCompanyId(), RoleNameConstants.PROFILE_APPROVER_ADMIN, Boolean.FALSE);
					boolean isRoleApprover = RoleLocalServiceUtil.hasUserRole(themeDisplay.getUserId(), themeDisplay.getCompanyId(), RoleNameConstants.ROLE_APPROVER_ADMIN, Boolean.FALSE);
					boolean isServiceApprover = RoleLocalServiceUtil.hasUserRole(themeDisplay.getUserId(), themeDisplay.getCompanyId(), RoleNameConstants.SERVICE_APPROVER_ADMIN, Boolean.FALSE);
					//boolean isEmployer = RoleLocalServiceUtil.hasUserRole(themeDisplay.getUserId(), themeDisplay.getCompanyId(), RoleNameConstants.EMPLOYER, Boolean.FALSE);
					
					boolean isAdmin = registrationUtil.getAdmin(themeDisplay.getCompanyId()).getUserId()==themeDisplay.getUserId()?true :false;
					
					renderRequest.setAttribute("isProfileApprover", isProfileApprover);
					renderRequest.setAttribute("isRoleApprover", isRoleApprover);
					renderRequest.setAttribute("isServiceApprover", isServiceApprover);
					LOGGER.info("isProfileApprover :::"+isProfileApprover);
					LOGGER.info("isRoleApprover :::"+isRoleApprover);
					LOGGER.info("isServiceApprover :::"+isServiceApprover);
			
					List<Registration> registrationList = new ArrayList<>();
					if(isProfileApprover) {
						UserRegistrationStatusItems userProfileStatusItems = registrationUtil.getRegistrationWorkflowStatus(themeDisplay.getPortalURL(), themeDisplay.getScopeGroupId(), LRObjectURL.REG_USER_PROFILE_STATUS, 0, 0, 0, UserRegistrationStatusItems.class);
						if (Validator.isNotNull(userProfileStatusItems) && Validator.isNotNull(userProfileStatusItems.getItems()) && userProfileStatusItems.getItems().size()>0) {
							for (UserRegistrationStatus userProfileStatus : userProfileStatusItems.getItems()) {
								
								Registration registration = new Registration();
								Person person = registrationUtil.getPersonById(themeDisplay.getPortalURL(), themeDisplay.getScopeGroupId(), userProfileStatus.getPersonId());
								if (Validator.isNotNull(person) && person.getId()>0) {
										
									registration.setDateOfBirth(omsbCommonApi.convertObjectDateToNewDDMMYYYYDate(person.getDateOfBirth()));
									
									LOGGER.info("registration DOB::::" +registration.getDateOfBirth());
									
									PersonalDetailItem personalDetailItem = registrationUtil.getPersonalDetailsItems(themeDisplay.getPortalURL(), themeDisplay.getScopeGroupId(), person.getId(), null);
									if (Validator.isNotNull(personalDetailItem) && personalDetailItem.getItems().size()>0) {
										LOGGER.info("personalDetailItem.getItems().get(0).getRegistrationStatus() :::" +personalDetailItem.getItems().get(0).getRegistrationStatus());
										LOGGER.info("userProfileStatus.getDateModified() :::" +userProfileStatus.getDateModified());

										try {
											registration.setDateModified(omsbCommonApi.convertObjectDateToNewDDMMYYYYDate(userProfileStatus.getDateModified()));
										} catch (Exception e1) {
											LOGGER.error(e1.getMessage());
										}
										
										try {
											if(Validator.isNotNull(userProfileStatus.getUserStatus())) {
												if(userProfileStatus.getUserStatus().equalsIgnoreCase("approve")){
													registration.setRegistrationStatus("Approved");
													registration.setRegistrationStatusColor(registrationUtil.getRegistrationStatusColor(OmsbRegistrationWebPortletKeys.COMPLETED));
												}else if(userProfileStatus.getUserStatus().equalsIgnoreCase("Pending")) {
													registration.setRegistrationStatus(OmsbRegistrationWebPortletKeys.UNVERIFIED);
													registration.setRegistrationStatusColor(registrationUtil.getRegistrationStatusColor(OmsbRegistrationWebPortletKeys.ROLE_TYPE_2));
												}else if(userProfileStatus.getUserStatus().equalsIgnoreCase(OmsbRegistrationWebPortletKeys.REJECTED_WF_STATUS)) {
													registration.setRegistrationStatus(OmsbRegistrationWebPortletKeys.REJECTED);
													registration.setRegistrationStatusColor(registrationUtil.getRegistrationStatusColor(OmsbRegistrationWebPortletKeys.NOT_STARTED));
												}
											}
										} catch (Exception e) {
											LOGGER.error(e.getMessage());
										}
										try {
											UserRegistrationStatusItems userRegistrationStatusItems=registrationUtil.getRegistrationStatusByPersonId(themeDisplay.getPortalURL(), themeDisplay.getScopeGroupId(), person.getId());
											if(Validator.isNotNull(userRegistrationStatusItems) && Validator.isNotNull(userRegistrationStatusItems.getItems()) && userRegistrationStatusItems.getItems().size()>2) {
												UserRegistrationStatus	userRegistrationStatus=	userRegistrationStatusItems.getItems().get(1);
											
												if(Validator.isNotNull(userRegistrationStatus)) {
													if(userRegistrationStatus.getUserStatus().equalsIgnoreCase("approve")){
														registration.setLastVerified("Approved");
														registration.setLastVerifiedStatusColor(registrationUtil.getRegistrationStatusColor(OmsbRegistrationWebPortletKeys.COMPLETED));
													}else if(userRegistrationStatus.getUserStatus().equalsIgnoreCase("Pending")) {
														registration.setLastVerified(OmsbRegistrationWebPortletKeys.UNVERIFIED);
														registration.setLastVerifiedStatusColor(registrationUtil.getRegistrationStatusColor(OmsbRegistrationWebPortletKeys.ROLE_TYPE_2));
													}else if(userRegistrationStatus.getUserStatus().equalsIgnoreCase(OmsbRegistrationWebPortletKeys.REJECTED_WF_STATUS)) {
														registration.setLastVerified(OmsbRegistrationWebPortletKeys.REJECTED);
														registration.setLastVerifiedStatusColor(registrationUtil.getRegistrationStatusColor(OmsbRegistrationWebPortletKeys.NOT_STARTED));
													}
												}
											}
										} catch (Exception e) {
											LOGGER.error(e.getMessage());
										}
										
										
									
										try {
											User user = UserLocalServiceUtil.getUser(person.getLrUserId());
											if(Validator.isNotNull(user.getUserId()) && user.getUserId() > 0) {
												registration.setPersonName(user.getFullName());
											}
										} catch (NoSuchUserException e) {
											LOGGER.error(e.getMessage(), e);
										}
									
										registration.setDateCreated(Validator.isNotNull(person.getDateCreated())? omsbCommonApi.convertObjectDateToNewDDMMYYYYDate(person.getDateCreated()):null);
										if (Validator.isNotNull(person.getCivilId())) {
											registration.setCivilId(person.getCivilId());
										}
										if (Validator.isNotNull(person.getPassportNumber())) {
											registration.setPassportNo(person.getPassportNumber());
										}
									
										registration.setPersonId(person.getId());
										if(Validator.isNotNull(userProfileStatusItems) && Validator.isNotNull(userProfileStatusItems.getItems()) && userProfileStatusItems.getItems().size()>0) {
											registration.setWorkflowStatus(userProfileStatusItems.getItems().get(0).getUserStatus());
											registration.setWorkflowId(userProfileStatusItems.getItems().get(0).getId());
											registrationUtil.getWorkflowData(themeDisplay, registration, LRObjectURL.USER_PROFILE_STATUS_OBJ_ERC);
										}
										registrationList.add(registration);
									
									
									} else {								
										registration.setRegistrationStatus(omsbCommonApi.getListTypeEntryByListTypeItemKey(LRPicklistConstants.REGISTRATION_STAGE, OmsbRegistrationWebPortletKeys.NOT_STARTED, themeDisplay.getCompanyId()).getName());
										registration.setRegistrationStatusColor(registrationUtil.getRegistrationStatusColor(OmsbRegistrationWebPortletKeys.NOT_STARTED));
									}
									
									
								}
							}
							renderRequest.setAttribute("registrationList", registrationList);
						}
					} else if(isRoleApprover) {
						LOGGER.info("Inside role approver ::::");
						UserRegistrationStatusItems userProfileStatusItems = registrationUtil.getRegistrationWorkflowStatus(themeDisplay.getPortalURL(), themeDisplay.getScopeGroupId(), LRObjectURL.REG_USER_ROLE_STATUS, 0, 0, 0, UserRegistrationStatusItems.class);
						if (Validator.isNotNull(userProfileStatusItems) && Validator.isNotNull(userProfileStatusItems.getItems()) && userProfileStatusItems.getItems().size()>0) {
							for (UserRegistrationStatus userProfileStatus : userProfileStatusItems.getItems()) {
								
								Registration registration = new Registration();
								Person person = registrationUtil.getPersonById(themeDisplay.getPortalURL(), themeDisplay.getScopeGroupId(), userProfileStatus.getPersonId());
								if (Validator.isNotNull(person) && person.getId()>0) {
									registration.setDateOfBirth(omsbCommonApi.convertObjectDateToNewDDMMYYYYDate(person.getDateOfBirth()));
									
									LOGGER.info("isRoleApprover registration DOB ::::" +registration.getDateOfBirth());
									
									PersonalDetailItem personalDetailItem = registrationUtil.getPersonalDetailsItems(themeDisplay.getPortalURL(), themeDisplay.getScopeGroupId(), person.getId(), null);
									if (Validator.isNotNull(personalDetailItem) && personalDetailItem.getItems().size()>0) {
										LOGGER.info("personalDetailItem.getItems().get(0).getRegistrationStatus() :::" +personalDetailItem.getItems().get(0).getRegistrationStatus());
										LOGGER.info("userProfileStatus.getDateModified() :::" +userProfileStatus.getDateModified());
										try {
											registration.setDateModified(omsbCommonApi.convertObjectDateToNewDDMMYYYYDate(userProfileStatus.getDateModified()));
										} catch (Exception e1) {
											LOGGER.error(e1.getMessage());
										}
										try {
											if(Validator.isNotNull(userProfileStatus.getUserStatus())) {
												if(userProfileStatus.getUserStatus().equalsIgnoreCase("approve")){
													registration.setRegistrationStatus("Approved");
													registration.setRegistrationStatusColor(registrationUtil.getRegistrationStatusColor(OmsbRegistrationWebPortletKeys.COMPLETED));
												}else if(userProfileStatus.getUserStatus().equalsIgnoreCase("Pending")) {
													registration.setRegistrationStatus(OmsbRegistrationWebPortletKeys.UNVERIFIED);
													registration.setRegistrationStatusColor(registrationUtil.getRegistrationStatusColor(OmsbRegistrationWebPortletKeys.ROLE_TYPE_2));
												}else if(userProfileStatus.getUserStatus().equalsIgnoreCase("reject")) {
													registration.setRegistrationStatus(OmsbRegistrationWebPortletKeys.REJECTED);
													registration.setRegistrationStatusColor(registrationUtil.getRegistrationStatusColor(OmsbRegistrationWebPortletKeys.NOT_STARTED));
												}
											}
											
										} catch (Exception e) {
											LOGGER.error(e.getMessage());
										}
										
										try {
											UserRegistrationStatusItems userRegistrationStatusItems=registrationUtil.getRegistrationStatusByPersonId(themeDisplay.getPortalURL(), themeDisplay.getScopeGroupId(), person.getId());
											if(Validator.isNotNull(userRegistrationStatusItems) && Validator.isNotNull(userRegistrationStatusItems.getItems()) && userRegistrationStatusItems.getItems().size()>1) {
												UserRegistrationStatus	userRegistrationStatus=	userRegistrationStatusItems.getItems().get(1);
											
												if(Validator.isNotNull(userRegistrationStatus)) {
													if(userRegistrationStatus.getUserStatus().equalsIgnoreCase("approve")){
														registration.setLastVerified("Approved");
														registration.setLastVerifiedStatusColor(registrationUtil.getRegistrationStatusColor(OmsbRegistrationWebPortletKeys.COMPLETED));
													}else if(userRegistrationStatus.getUserStatus().equalsIgnoreCase("Pending")) {
														registration.setLastVerified(OmsbRegistrationWebPortletKeys.UNVERIFIED);
														registration.setLastVerifiedStatusColor(registrationUtil.getRegistrationStatusColor(OmsbRegistrationWebPortletKeys.ROLE_TYPE_2));
													}else if(userRegistrationStatus.getUserStatus().equalsIgnoreCase(OmsbRegistrationWebPortletKeys.REJECTED_WF_STATUS)) {
														registration.setLastVerified(OmsbRegistrationWebPortletKeys.REJECTED);
														registration.setLastVerifiedStatusColor(registrationUtil.getRegistrationStatusColor(OmsbRegistrationWebPortletKeys.NOT_STARTED));
													}
												}
											}
										} catch (Exception e) {
											LOGGER.error(e.getMessage());
										}
										
									
										//registration.setRegistrationStatusColor(registrationUtil.getRegistrationStatusColor(Validator.isNotNull(personalDetailItem.getItems().get(0).getRegistrationStatus())?personalDetailItem.getItems().get(0).getRegistrationStatus():OmsbRegistrationWebPortletKeys.NOT_STARTED));
										//
										long userMetaDataId=userProfileStatus.getUserMetaDataId();
										
										if(userMetaDataId >0) {
											UserMetadata userMetaData=null;
											try {
												 userMetaData=registrationUtil.getUserMetadataById(themeDisplay.getPortalURL(), userMetaDataId);
											} catch (Exception e) {
												LOGGER.error("Exception ::::"+e.getMessage());
											}
											if(Validator.isNotNull(userMetaData)) {
												if(userMetaData.isAssociated()) {
													registration.setOmsbAssociated("Associated");
												}else {
													registration.setOmsbAssociated("Not Associated");
												}
											}	
										}else {
											registration.setOmsbAssociated(StringPool.BLANK);
											
										}
										
										try {
											User user = UserLocalServiceUtil.getUser(person.getLrUserId());
											if(Validator.isNotNull(user.getUserId()) && user.getUserId() > 0) {
												registration.setPersonName(user.getFirstName()+" "+ user.getLastName());
											}
										} catch (NoSuchUserException e) {
											LOGGER.error(e.getMessage(), e);
										}
									
										registration.setDateCreated(Validator.isNotNull(person.getDateCreated())? omsbCommonApi.convertObjectDateToNewDDMMYYYYDate(person.getDateCreated()):null);
										if (Validator.isNotNull(person.getCivilId())) {
											registration.setCivilId(person.getCivilId());
										}
										if (Validator.isNotNull(person.getPassportNumber())) {
											registration.setPassportNo(person.getPassportNumber());
										}
									
										registration.setPersonId(person.getId());
										if(Validator.isNotNull(userProfileStatus)) {
											registration.setWorkflowStatus(userProfileStatus.getUserStatus());
											registration.setWorkflowId(userProfileStatus.getId());
											registrationUtil.getWorkflowData(themeDisplay, registration, LRObjectURL.USER_ROLE_STATUS_OBJ_ERC);
										}
										registrationList.add(registration);
									} else {								
										registration.setRegistrationStatus(omsbCommonApi.getListTypeEntryByListTypeItemKey(LRPicklistConstants.REGISTRATION_STAGE, OmsbRegistrationWebPortletKeys.NOT_STARTED, themeDisplay.getCompanyId()).getName());
										registration.setRegistrationStatusColor(registrationUtil.getRegistrationStatusColor(OmsbRegistrationWebPortletKeys.NOT_STARTED));
									}
									
									
								}
							}
							renderRequest.setAttribute("registrationList", registrationList);
						}
					} else if(isServiceApprover) {
						UserRegistrationStatusItems userProfileStatusItems = registrationUtil.getRegistrationWorkflowStatus(themeDisplay.getPortalURL(), themeDisplay.getScopeGroupId(), LRObjectURL.REG_USER_SERVICE_STATUS, 0, 0, 0, UserRegistrationStatusItems.class);
						if (Validator.isNotNull(userProfileStatusItems) && Validator.isNotNull(userProfileStatusItems.getItems()) && userProfileStatusItems.getItems().size()>0) {
							for (UserRegistrationStatus userProfileStatus : userProfileStatusItems.getItems()) {
								
								Registration registration = new Registration();
								Person person = registrationUtil.getPersonById(themeDisplay.getPortalURL(), themeDisplay.getScopeGroupId(), userProfileStatus.getPersonId());
								if (Validator.isNotNull(person) && person.getId()>0) {
									registration.setDateOfBirth(omsbCommonApi.convertObjectDateToNewDDMMYYYYDate(person.getDateOfBirth()));
									
									LOGGER.info("isRoleApprover registration DOB ::::" +registration.getDateOfBirth());
									
									PersonalDetailItem personalDetailItem = registrationUtil.getPersonalDetailsItems(themeDisplay.getPortalURL(), themeDisplay.getScopeGroupId(), person.getId(), null);
									if (Validator.isNotNull(personalDetailItem) && personalDetailItem.getItems().size()>0) {
										LOGGER.info("personalDetailItem.getItems().get(0).getRegistrationStatus() :::" +personalDetailItem.getItems().get(0).getRegistrationStatus());
									
										try {
											registration.setRegistrationStatus(Validator.isNotNull(personalDetailItem.getItems().get(0).getRegistrationStatus())?
													omsbCommonApi.getListTypeEntryByListTypeItemKey(LRPicklistConstants.REGISTRATION_STAGE, personalDetailItem.getItems().get(0).getRegistrationStatus(), themeDisplay.getCompanyId()).getName(): 
													omsbCommonApi.getListTypeEntryByListTypeItemKey(LRPicklistConstants.REGISTRATION_STAGE, OmsbRegistrationWebPortletKeys.NOT_STARTED, themeDisplay.getCompanyId()).getName());
										} catch (Exception e) {
											LOGGER.error(e.getMessage());
										}
									
										registration.setRegistrationStatusColor(registrationUtil.getRegistrationStatusColor(Validator.isNotNull(personalDetailItem.getItems().get(0).getRegistrationStatus())?personalDetailItem.getItems().get(0).getRegistrationStatus():OmsbRegistrationWebPortletKeys.NOT_STARTED));
									} else {								
										registration.setRegistrationStatus(omsbCommonApi.getListTypeEntryByListTypeItemKey(LRPicklistConstants.REGISTRATION_STAGE, OmsbRegistrationWebPortletKeys.NOT_STARTED, themeDisplay.getCompanyId()).getName());
										registration.setRegistrationStatusColor(registrationUtil.getRegistrationStatusColor(OmsbRegistrationWebPortletKeys.NOT_STARTED));
									}
									
									try {
										User user = UserLocalServiceUtil.getUser(person.getLrUserId());
										if(Validator.isNotNull(user.getUserId()) && user.getUserId() > 0) {
											registration.setPersonName(user.getFirstName()+" "+ user.getLastName());
										}
									} catch (NoSuchUserException e) {
										LOGGER.error(e.getMessage(), e);
									}
								
									registration.setDateCreated(Validator.isNotNull(person.getDateCreated())? omsbCommonApi.convertObjectDateToNewDDMMYYYYDate(person.getDateCreated()):null);
									if (Validator.isNotNull(person.getCivilId())) {
										registration.setCivilId(person.getCivilId());
									}
									if (Validator.isNotNull(person.getPassportNumber())) {
										registration.setPassportNo(person.getPassportNumber());
									}
								
									registration.setPersonId(person.getId());
									if(Validator.isNotNull(userProfileStatusItems) && Validator.isNotNull(userProfileStatusItems.getItems()) && userProfileStatusItems.getItems().size()>0) {
										registration.setWorkflowStatus(userProfileStatusItems.getItems().get(0).getUserStatus());
										registration.setWorkflowId(userProfileStatusItems.getItems().get(0).getId());
										registrationUtil.getWorkflowData(themeDisplay, registration, LRObjectURL.USER_SERVICE_STATUS_OBJ_ERC);
									}
									registrationList.add(registration);
								}
							}
							renderRequest.setAttribute("registrationList", registrationList);
						}
					} else if (!isProfileApprover && !isAdmin && !isRoleApprover && !isServiceApprover) {
						try {
							PersonItem personItem = registrationUtil.fetchPersonByLrUserId(themeDisplay, themeDisplay.getUserId());
							if(Validator.isNotNull(personItem) && Validator.isNotNull(personItem.getItems()) && personItem.getItems().size()>0) {
								Person person=personItem.getItems().get(0);
								LOGGER.info("person : "+person);
								if(Validator.isNotNull(person) && person.getId() > 0) {
									person.setDateOfBirth(omsbCommonApi.convertObjectDateToNewDDMMYYYYDate(person.getDateOfBirth()));
									renderRequest.setAttribute("person", person);
									try {
										User user = UserLocalServiceUtil.getUser(person.getLrUserId());
										LOGGER.info("========================== " +user);
										LOGGER.info(user.getPortraitId());
										if(Validator.isNotNull(user.getPortraitId())) {
											FileEntry entry = DLAppLocalServiceUtil.getFileEntry(user.getPortraitId());
											renderRequest.setAttribute("photo", entry.getDescription());
											String documentViewURL = DLURLHelperUtil.getPreviewURL(entry, entry.getFileVersion(), themeDisplay, "");
											LOGGER.info("documentViewURL :::::"+documentViewURL);
											renderRequest.setAttribute("photoURL",documentViewURL );
										} 
										renderRequest.setAttribute("user_", user);
									} catch (PortalException e) {
										LOGGER.error("Error while getting user info, "+e.getMessage());
									}
									PersonalDetail personalDetail = getPersonalDetailByLrUserId(themeDisplay, person.getId());
									LOGGER.info("personalDetail :: "+personalDetail);
									if(Validator.isNotNull(personalDetail)) {
										try {
											long professionId=omsbCommonApi.getListTypeEntryByListTypeItemKey(LRPicklistConstants.PROFESSION, personalDetail.getProfession(), themeDisplay.getCompanyId()).getListTypeEntryId();
											personalDetail.setProfession(String.valueOf(professionId));
										} catch(Exception e) {
											LOGGER.error("Error while getting profession : "+e.getMessage());
										}
										renderRequest.setAttribute("personalDetails", personalDetail);
										
										try {
											FileEntry entry = DLAppLocalServiceUtil.getFileEntry(personalDetail.getCivilCardFrontPhotoId());
											renderRequest.setAttribute("civilCardFrontPhoto", entry.getDescription());
											renderRequest.setAttribute("civilCardFrontPhotoURL",DLURLHelperUtil.getPreviewURL(entry, entry.getFileVersion(), themeDisplay, ""));
										}catch(PortalException e) {
											LOGGER.error("unable to get the file entry having id  "+personalDetail.getCivilCardFrontPhotoId());
										}
										
										try {
											FileEntry entry = DLAppLocalServiceUtil.getFileEntry(personalDetail.getCivilCardBackPhotoId());
											renderRequest.setAttribute("civilCardBackPhoto", entry.getDescription());
											renderRequest.setAttribute("civilCardBackPhotoURL",DLURLHelperUtil.getPreviewURL(entry, entry.getFileVersion(), themeDisplay, ""));
										}catch(PortalException e) {
											LOGGER.error("unable to get the file entry having id  "+personalDetail.getCivilCardBackPhotoId());
										}
										
										try {
											FileEntry entry = DLAppLocalServiceUtil.getFileEntry(personalDetail.getPassportPhotoId());
											renderRequest.setAttribute("passportPhoto", entry.getDescription());
											renderRequest.setAttribute("passportPhotoURL",DLURLHelperUtil.getPreviewURL(entry, entry.getFileVersion(), themeDisplay, ""));
										}catch(PortalException e) {
											LOGGER.error("unable to get the file entry having id  "+personalDetail.getPassportPhotoId());
										}
										
										if(Validator.isNotNull(personalDetail.getLrUserId()) && personalDetail.getLrUserId() > 0) {
											UserMetatdataItems  userMetadataItem =registrationUtil.getUserMetadataItems(themeDisplay.getPortalURL(), themeDisplay.getScopeGroupId(), person.getLrUserId());
											if(Validator.isNotNull(userMetadataItem) && userMetadataItem.getItems().size()>0) {
												UserMetadata userMetadata=userMetadataItem.getItems().get(0);
												try {
													userMetadata.setRoleName(RoleLocalServiceUtil.getRole(userMetadata.getRoleId()).getName());
												} catch (PortalException e) {
													LOGGER.error(e.getMessage());
												}
											
												long programTypeId=0;	
												LOGGER.info("userMetadata.getProgramId() :::::"+userMetadata.getProgramId());
												if(Validator.isNotNull(userMetadata.getProgramId())) {
												try {
													 ProgramMaster programMaster=ProgramMasterLocalServiceUtil.getProgramMaster(userMetadata.getProgramId());
													 programTypeId= ProgramMasterLocalServiceUtil.getProgramMaster(userMetadata.getProgramId()).getProgramTypeId();
													 userMetadata.setProgramName(CommonUtil.getValueByLanguage(programMaster.getProgramName(),"ProgramName",
																themeDisplay.getLocale().toString())      );
												} catch (Exception e) {
													LOGGER.error(e.getMessage());
												}
												userMetadata.setProgramTypeId(programTypeId);
												if(programTypeId>0) {
													try {
														LOGGER.info("ProgramTypeMasterLocalServiceUtil.getProgramTypeMaster(programTypeId).getProgramTypeName() :::"+ProgramTypeMasterLocalServiceUtil.getProgramTypeMaster(programTypeId).getProgramTypeName());
														userMetadata.setProgramTypeName(CommonUtil.getValueByLanguage(ProgramTypeMasterLocalServiceUtil.getProgramTypeMaster(programTypeId).getProgramTypeName(), OmsbRegistrationWebPortletKeys.PROGRAM_TYPE_NAME,
																themeDisplay.getLocale().toString()));
													} catch (PortalException e) {
														LOGGER.error(e.getMessage());
													}
												}
											}
											renderRequest.setAttribute("userMetadata", userMetadata);
										}
									}
									}
									List<EducationDetail> educationDetailList = getEducationDetailList(themeDisplay, person.getId());
									if(Validator.isNotNull(educationDetailList)) {
										renderRequest.setAttribute("educationalDetailItemList", educationDetailList);
									}
									
									
									List<ProgramTypeMaster> programTypeMasterList=registrationUtil.getProgramType(themeDisplay);	
									LOGGER.info("programTypeMasterList :::::"+programTypeMasterList);
									List<ProgramMaster> programList=registrationUtil.getProgram(themeDisplay);
									LOGGER.info("programList :::::"+programList);
									List<ListTypeEntry> programPositionList = registrationUtil.getPickListEntries(LRPicklistConstants.PROGRAM_POSITION, themeDisplay.getCompanyId());
									LOGGER.info("programPositionList :::::"+programPositionList.size());
									List<ListTypeEntry> purposeList = registrationUtil.getPickListEntries(LRPicklistConstants.PURPOSE, themeDisplay.getCompanyId());
									LOGGER.info("purposeList :::::"+purposeList.size());
									RoleMappingItems roleMappingItems=registrationUtil.fetchRoleMapping(themeDisplay, RoleNameConstants.ROLE_TYPE_REGISTRATION);
									List<ListTypeEntry> departmentList = registrationUtil.getPickListEntries(LRPicklistConstants.DEPARTMENT, themeDisplay.getCompanyId());
									List<ListTypeEntry> sectionList = registrationUtil.getPickListEntries(LRPicklistConstants.SECTION, themeDisplay.getCompanyId());
									List<ListTypeEntry> functionList = registrationUtil.getPickListEntries(LRPicklistConstants.FUNCTION, themeDisplay.getCompanyId());
									List<ListTypeEntry> committeList = registrationUtil.getPickListEntries(LRPicklistConstants.COMMITTEE, themeDisplay.getCompanyId());
									List<ListTypeEntry> serviceList = registrationUtil.getPickListEntries(LRPicklistConstants.SERVICE, themeDisplay.getCompanyId());
									renderRequest.setAttribute("sectionList", sectionList.stream().sorted((o1, o2)->o1.getName(themeDisplay.getLocale()).
							                compareTo(o2.getName(themeDisplay.getLocale()))).collect(Collectors.toList()));
									renderRequest.setAttribute("departmentList", departmentList.stream().sorted((o1, o2)->o1.getName(themeDisplay.getLocale()).
							                compareTo(o2.getName(themeDisplay.getLocale()))).collect(Collectors.toList()));
									renderRequest.setAttribute("functionList", functionList.stream().sorted((o1, o2)->o1.getName(themeDisplay.getLocale()).
							                compareTo(o2.getName(themeDisplay.getLocale()))).collect(Collectors.toList()));
									renderRequest.setAttribute("programTypeMasterList", programTypeMasterList.stream().sorted((o1, o2)->o1.getProgramTypeName(themeDisplay.getLocale()).
							                compareTo(o2.getProgramTypeName(themeDisplay.getLocale()))).collect(Collectors.toList()));
									renderRequest.setAttribute("programList", programList.stream().sorted((o1, o2)->o1.getProgramName(themeDisplay.getLocale()).
							                compareTo(o2.getProgramName(themeDisplay.getLocale()))).collect(Collectors.toList()));
									renderRequest.setAttribute("programPositionList", programPositionList.stream().sorted((o1, o2)->o1.getName(themeDisplay.getLocale()).
							                compareTo(o2.getName(themeDisplay.getLocale()))).collect(Collectors.toList()));
									renderRequest.setAttribute("purposeList", purposeList.stream().sorted((o1, o2)->o1.getName(themeDisplay.getLocale()).
							                compareTo(o2.getName(themeDisplay.getLocale()))).collect(Collectors.toList()));
									renderRequest.setAttribute("committeList", committeList.stream().sorted((o1, o2)->o1.getName(themeDisplay.getLocale()).
							                compareTo(o2.getName(themeDisplay.getLocale()))).collect(Collectors.toList()));
									renderRequest.setAttribute("serviceList", serviceList.stream().sorted((o1, o2)->o1.getName(themeDisplay.getLocale()).
							                compareTo(o2.getName(themeDisplay.getLocale()))).collect(Collectors.toList()));
									if(Validator.isNotNull(roleMappingItems)) {
										//LOGGER.info("Role Mapping  :::" +roleMappingItems.getItems().get(0).getRoleType());
										renderRequest.setAttribute("omsbRoleList", registrationUtil.getOMSBRoles(roleMappingItems));
									}
//									CountryItem customCountryItems = registrationUtil.getCustomCountryItems(themeDisplay.getPortalURL(), themeDisplay.getScopeGroupId());
//									if(Validator.isNotNull(customCountryItems) && Validator.isNotNull(customCountryItems.getItems()) && customCountryItems.getItems().size()>0) {
//										renderRequest.setAttribute("customCountries", customCountryItems.getItems());
//									}
//									List<com.liferay.portal.kernel.model.Country> countries = CountryLocalServiceUtil.getCountries(QueryUtil.ALL_POS, QueryUtil.ALL_POS);
//									LOGGER.info("countries:::  "+countries);
//									if(Validator.isNotNull(countries) && countries.size()>0) {
//										renderRequest.setAttribute("countries", countries);
//									}
								//	List<GenderMaster> genderMasterList = registrationUtil.getGenderMasterList(themeDisplay);
								//	renderRequest.setAttribute("genderList", genderMasterList.stream().sorted((o1, o2)->o1.getGenderName(themeDisplay.getLocale()).
					             //   compareTo(o2.getGenderName(themeDisplay.getLocale()))).
					              //  collect(Collectors.toList()));
									
									
								//	List<ListTypeEntry> professionList = registrationUtil.getPickListEntries(LRPicklistConstants.PROFESSION, themeDisplay.getCompanyId());
								//	renderRequest.setAttribute("professionList", professionList);
									
								//	List<ListTypeEntry> specialityList = registrationUtil.getPickListEntries(LRPicklistConstants.SPECIALIY, themeDisplay.getCompanyId());
								//	renderRequest.setAttribute("specialityList", specialityList);
									
									//Educational Details Related values  starts 
								//	List<ListTypeEntry> qualificationList = registrationUtil.getPickListEntries(LRPicklistConstants.QUALIFICATION, themeDisplay.getCompanyId());
								//	renderRequest.setAttribute("qualificationList", qualificationList);
									
								//	List<ListTypeEntry> institutionList = registrationUtil.getPickListEntries(LRPicklistConstants.INSTITUTION, themeDisplay.getCompanyId());
								//	renderRequest.setAttribute("institutionList", institutionList);
									
									if(Validator.isNotNull(qualificationList) && qualificationList.size()>0) {
										JSONArray qualificationArray=JSONFactoryUtil.createJSONArray();
										for(ListTypeEntry lt:qualificationList) {
											JSONObject qualificationObject=JSONFactoryUtil.createJSONObject();
											qualificationObject.put("key", lt.getKey());
											qualificationObject.put("name", lt.getName(themeDisplay.getLocale()));
											qualificationArray.put(qualificationObject);
										}
										renderRequest.setAttribute("qualificationArray", qualificationArray);
									}
									
									if(Validator.isNotNull(customCountryItems) && Validator.isNotNull(customCountryItems.getItems()) && customCountryItems.getItems().size()>0) {
										List<Country> countryList=customCountryItems.getItems();
										JSONArray countryArray=JSONFactoryUtil.createJSONArray();
										if(Validator.isNotNull(countryList) && countryList.size()>0) {
											for(Country country :countryList) {
												JSONObject countryObject=JSONFactoryUtil.createJSONObject();
												countryObject.put("id", country.getId());
												countryObject.put("nationality", country.getNationality());
												countryArray.put(countryObject);
											}
										}
										renderRequest.setAttribute("countryArray", countryArray);
									}
									
								//	List<ListTypeEntry> workSectorTypes = registrationUtil.getPickListEntries(LRPicklistConstants.WORK_SECTOR_TYPE, themeDisplay.getCompanyId());
								//	List<ListTypeEntry> wilayats = registrationUtil.getPickListEntries(LRPicklistConstants.WILAYAT, themeDisplay.getCompanyId());
								//	List<ListTypeEntry> governorate=registrationUtil.getPickListEntries(LRPicklistConstants.GOVERNORATE, themeDisplay.getCompanyId());
								//	List<ListTypeEntry> designations = registrationUtil.getPickListEntries(LRPicklistConstants.DESIGNATION, themeDisplay.getCompanyId());
								//	JSONArray workSectorJsonArray=JSONFactoryUtil.createJSONArray();
									//JSONArray workSectorJsonArray = registrationUtil.getJsonArray(themeDisplay.getPortalURL(), themeDisplay.getScopeGroupId(),0);
									//JSONArray workSectorJsonArray = registrationUtil.getJsonArrayTest(themeDisplay.getPortalURL(), themeDisplay.getScopeGroupId());
									//LOGGER.info("workSector Json Array :"+workSectorJsonArray);
									//Get Primary Work Detail 
									EmploymentDetailItem workDetailItems = null;
									
									try {
										workDetailItems = registrationUtil.getWorkDetailsByPersonIdAndWorkDetailType(themeDisplay.getPortalURL(),
												themeDisplay.getScopeGroupId(), person.getId(),"1");
									} catch (Exception e) {
										LOGGER.error("workDetailItems exception:" + e.getMessage());
									}
									
									EmploymentDetailItem secondaryWorkDetailItems = null;
									
									try {
										secondaryWorkDetailItems = registrationUtil.getWorkDetailsByPersonIdAndWorkDetailType(themeDisplay.getPortalURL(),
												themeDisplay.getScopeGroupId(), person.getId(),"2");
									} catch (Exception e) {
										LOGGER.error("secondaryWorkDetailItems exception:" + e.getMessage());
									}
									if(Validator.isNotNull(workDetailItems) && Validator.isNotNull(workDetailItems.getItems()) && workDetailItems.getItems().size()>0) {
										EmploymentDetail workDetail=workDetailItems.getItems().get(0);
										FileEntry entry=null;
											try {
												LOGGER.info("workDetail getWorkSectorType:::"+workDetail.getWorkSectorType());
												ListTypeEntry listTypeEntry =null;
												
												//Get Work sector Type 
												if(Validator.isNotNull(workDetail.getWorkSectorType())) {
													long workSectorTypeID=Long.parseLong(workDetail.getWorkSectorType());
													listTypeEntry	 =ListTypeEntryLocalServiceUtil.getListTypeEntry(workSectorTypeID);
													LOGGER.info("listTypeEntry ::: " +listTypeEntry);
													LOGGER.info("listTypeEntry key ::: " +listTypeEntry.getKey());
													LOGGER.info("listTypeEntry  Name ::: " +listTypeEntry.getName(themeDisplay.getLocale()));
												}
												
												//Get Work sector  
												if(Validator.isNotNull(listTypeEntry)&&	!listTypeEntry.getKey().equalsIgnoreCase("others")) {
														
														WorkSectorItems workSectorItems = registrationUtil.getWorkSectorsByWorkSectorType(themeDisplay.getPortalURL(), themeDisplay.getScopeGroupId(), workDetail.getWorkSectorType());
														LOGGER.info("workSectorItems in other than other :: "+workSectorItems.getItems().size());
														workDetail.setWorkSectorItems(workSectorItems);
														LOGGER.info("Worke sector items ::::"+workDetail.getWorkSectorItems().getItems().get(0).getWorkSector());
													}
												
												
												//Get Work Sub Sector 
												if(Validator.isNotNull(workDetail.getWorkSectorId2()) && workDetail.getWorkSectorId2()>0) {
													WorkSectorItems workSectorItems=registrationUtil.getWorkSectorByParentId(themeDisplay.getPortalURL(), themeDisplay.getScopeGroupId(), workDetail.getWorkSectorId());
													workDetail.setWorkSubSectorItems(workSectorItems);
												}
												
												//Get work second sub sectors 
												if(Validator.isNotNull(workDetail.getWorkSectorId3()) && workDetail.getWorkSectorId3()>0) {
													WorkSectorItems workSectorItems=registrationUtil.getWorkSectorByParentId(themeDisplay.getPortalURL(), themeDisplay.getScopeGroupId(), workDetail.getWorkSectorId2());
													workDetail.setWorkSecondSubSectorItems(workSectorItems);
												}
													
												if(Validator.isNotNull(workDetail.getStaffIdCard()) && Long.valueOf(workDetail.getStaffIdCard()) > 0) {
													workDetail.setUploadFileName(DLFileEntryLocalServiceUtil.getDLFileEntry(Long.valueOf(workDetail.getStaffIdCard())).getFileName());
													try {
														 entry = DLAppLocalServiceUtil.getFileEntry( Long.valueOf(workDetail.getStaffIdCard()));
														workDetail.setDocumentUrl(DLURLHelperUtil.getPreviewURL(entry, entry.getFileVersion(), themeDisplay, StringPool.BLANK));
													} catch (PortalException e) {
														LOGGER.error("Error in  code :::" + e.getMessage());
													}
												}
												if(Validator.isNotNull( workDetail.getWorkSector())) {
													WorkSectorItems workSectorsItems = registrationUtil.getWorkSectorDetailByWorkSector(themeDisplay, workDetail.getWorkSector());
													if(Validator.isNotNull(workSectorsItems.getItems()) && workSectorsItems.getItems().size()>0)
														workDetail.setWorkSector(workSectorsItems.getItems().get(0).getWorkSector());
							                    }
												LOGGER.debug("workDetail :: " + workDetail);
										} catch (Exception e) {
											LOGGER.error("Error :::::"+e.getMessage());
										}
											LOGGER.info("workDetailItems Size :::::"+ workDetailItems.getItems().size());
										renderRequest.setAttribute("primaryworkDetail", workDetail);
									}
									//Secondary
									if(Validator.isNotNull(secondaryWorkDetailItems.getItems()) && secondaryWorkDetailItems.getItems().size()>0) {
										EmploymentDetail secondaryWorkDetail=secondaryWorkDetailItems.getItems().get(0);
										FileEntry entry=null;
											try {
										//		LOGGER.info("workDetail getWorkSectorType:::"+secondaryWorkDetail.getWorkSectorType());
										//		LOGGER.info("secondaryWorkDetail getStaffIdCard:::"+secondaryWorkDetail.getStaffIdCard());
												ListTypeEntry listTypeEntry =null;
												
												//Get Work sector Type 
												if(Validator.isNotNull(secondaryWorkDetail.getWorkSectorType())) {
													long workSectorTypeID=Long.parseLong(secondaryWorkDetail.getWorkSectorType());
													listTypeEntry = ListTypeEntryLocalServiceUtil.getListTypeEntry(workSectorTypeID);
											//		LOGGER.info("listTypeEntry ::: " +listTypeEntry);
													LOGGER.info("listTypeEntry key ::: " +listTypeEntry.getKey());
													LOGGER.info("listTypeEntry  Name ::: " +listTypeEntry.getName(themeDisplay.getLocale()));
												}
												//Get Work sector  
												if(Validator.isNotNull(listTypeEntry)&&	!listTypeEntry.getKey().equalsIgnoreCase("others")) {
														WorkSectorItems workSectorItems = registrationUtil.getWorkSectorsByWorkSectorType(themeDisplay.getPortalURL(), themeDisplay.getScopeGroupId(), secondaryWorkDetail.getWorkSectorType());	
														secondaryWorkDetail.setWorkSectorItems(workSectorItems);
												}
												
												//Get Work Sub Sector 
												if(Validator.isNotNull(secondaryWorkDetail.getWorkSectorId2()) && secondaryWorkDetail.getWorkSectorId2()>0) {
													WorkSectorItems workSectorItems=registrationUtil.getWorkSectorByParentId(themeDisplay.getPortalURL(), themeDisplay.getScopeGroupId(), secondaryWorkDetail.getWorkSectorId());
													
													//LOGGER.info("workSectorItems ::::"+workSectorItems);
													secondaryWorkDetail.setWorkSubSectorItems(workSectorItems);
												}
												
												
												//Get work second sub sectors 
												if(Validator.isNotNull(secondaryWorkDetail.getWorkSectorId3()) && secondaryWorkDetail.getWorkSectorId3()>0) {
													WorkSectorItems workSectorItems=registrationUtil.getWorkSectorByParentId(themeDisplay.getPortalURL(), themeDisplay.getScopeGroupId(), secondaryWorkDetail.getWorkSectorId2());
													secondaryWorkDetail.setWorkSecondSubSectorItems(workSectorItems);
												}
												
												LOGGER.info("secondaryWorkDetail.getStaffIdCard() ::::" +secondaryWorkDetail.getStaffIdCard());
												
												
												if(Validator.isNotNull(secondaryWorkDetail.getStaffIdCard()) && Long.valueOf(secondaryWorkDetail.getStaffIdCard()) > 0) {
													secondaryWorkDetail.setUploadFileName(DLFileEntryLocalServiceUtil.getDLFileEntry(Long.valueOf(secondaryWorkDetail.getStaffIdCard())).getFileName());
													try {
														 entry = DLAppLocalServiceUtil.getFileEntry( Long.valueOf(secondaryWorkDetail.getStaffIdCard()));
														 
														 LOGGER.info("entry :::::"+entry);
														 
														 
														 secondaryWorkDetail.setDocumentUrl(DLURLHelperUtil.getPreviewURL(entry, entry.getFileVersion(), themeDisplay, StringPool.BLANK));
													} catch (PortalException e) {
														LOGGER.error("Error in  code :::" + e.getMessage());
													}
												}
												if(Validator.isNotNull( secondaryWorkDetail.getWorkSector())) {
													WorkSectorItems workSectorsItems = registrationUtil.getWorkSectorDetailByWorkSector(themeDisplay, secondaryWorkDetail.getWorkSector());
													if(Validator.isNotNull(workSectorsItems.getItems()) && workSectorsItems.getItems().size()>0)
														secondaryWorkDetail.setWorkSector(workSectorsItems.getItems().get(0).getWorkSector());
							                    }
												LOGGER.debug("workDetail :: " + secondaryWorkDetail);
										} catch (Exception e) {
											LOGGER.error("Error :::::"+e.getMessage());
										}
											LOGGER.info("secondaryWorkDetailItems Size :::::"+ secondaryWorkDetailItems.getItems().size());
										renderRequest.setAttribute("secondaryWorkDetail", secondaryWorkDetail);
									}
									
									
									//Getting past work details
										LOGGER.info("inside view get work details ");
										EmploymentDetailItem employmentDetailItem=null;
										
										try {
											employmentDetailItem=registrationUtil.getWorkDetailsByPersonIdAndWorkDetailType(themeDisplay.getPortalURL(),
													themeDisplay.getScopeGroupId(), person.getId(),"0");
										} catch (Exception e) {
											LOGGER.error("Exception in code :::"+e.getMessage());
										}
									if(Validator.isNotNull(employmentDetailItem) && Validator.isNotNull(employmentDetailItem.getItems()) && employmentDetailItem.getItems().size()>0) {
										
										List<EmploymentDetail> 	employmentDetailList=employmentDetailItem.getItems();	
										
										
										if(Validator.isNotNull(employmentDetailList) && employmentDetailList.size()>0) {
											
											for(EmploymentDetail employmentDetail :employmentDetailList) {
												
												LOGGER.info("employmentDetail 1::: " +employmentDetail.getWorkSectorType());
												ListTypeEntry listTypeEntry = null;
												long workSectorTypeID = Long.parseLong(employmentDetail.getWorkSectorType());
												try {
													listTypeEntry = ListTypeEntryLocalServiceUtil.getListTypeEntry(workSectorTypeID);
												} catch (PortalException e) {
													LOGGER.error("Exception in code :::" + e.getMessage());
												}
												
												if(Validator.isNotNull(employmentDetail.getWorkSectorTypeOther())) {
													employmentDetail.setWorkSectorType(employmentDetail.getWorkSectorTypeOther());
												}else {
													employmentDetail.setWorkSectorType(Validator.isNotNull(listTypeEntry)?listTypeEntry.getName(themeDisplay.getLocale()):StringPool.BLANK);
												}
												
												LOGGER.info("employmentDetail 2::: " + employmentDetail.getWorkSectorType());
												LOGGER.info("employmentDetail getWorkSectorTypeOther::: " + employmentDetail.getWorkSectorTypeOther());
												LOGGER.info("employmentDetail getWorkSectorId::: " + employmentDetail.getWorkSectorId());
												LOGGER.info("employmentDetail getWorkSectorId::: " + employmentDetail.getWorkSector());
												LOGGER.info("employmentDetail getWorkSectorId::: " + employmentDetail.getWorkSectorOther());
												LOGGER.info("employmentDetail getWorkSectorId2::: " + employmentDetail.getWorkSectorId2());
												LOGGER.info("employmentDetail getWorkSectorOther2::: " + employmentDetail.getWorkSectorOther2());
												LOGGER.info("employmentDetail getWorkSectorOther2::: " + employmentDetail.getWorkSector2());
												LOGGER.info("employmentDetail getWorkSectorLocation::: " + employmentDetail.getWorkSectorLocation());
												LOGGER.info("employmentDetail getDesignationId::: " + employmentDetail.getDesignationId());
												LOGGER.info("employmentDetail getId::: " + employmentDetail.getId());
												LOGGER.info("employmentDetail getId::: " + employmentDetail.getFileUploadDetails());		
												WorkSector workSector=null;
												try {
													workSector=registrationUtil.getWorkSectorById(themeDisplay.getPortalURL(), employmentDetail.getWorkSectorId());
												} catch (Exception e) {
													LOGGER.error("Exception in code :::" + e.getMessage());
												}
												
												if(Validator.isNotNull(employmentDetail.getWorkSectorOther())) {
													employmentDetail.setWorkSector(employmentDetail.getWorkSectorOther());
												}else {
													employmentDetail.setWorkSector(Validator.isNotNull(workSector)?workSector.getWorkSector():StringPool.BLANK );
												}
												WorkSector workSector2=null;
												if(Validator.isNotNull(employmentDetail.getWorkSectorId2())) {
													
													try {
														workSector2=registrationUtil.getWorkSectorById(themeDisplay.getPortalURL(), employmentDetail.getWorkSectorId2());
													} catch (Exception e) {
														LOGGER.error("Exception in code :::" + e.getMessage());
													}
													
													
												}
												
												if(Validator.isNotNull(employmentDetail.getWorkSectorOther2())) {
													employmentDetail.setWorkSector2(employmentDetail.getWorkSectorOther2());
												}else {
													employmentDetail.setWorkSector2(Validator.isNotNull(workSector2)?workSector2.getWorkSector():StringPool.BLANK );
												}
												if(Validator.isNotNull(employmentDetail.getDesignationOther())) {
													employmentDetail.setDesignationId(employmentDetail.getDesignationOther());
												}else {
														try {
															employmentDetail.setDesignationId(omsbCommonApi.getListTypeEntryByListTypeItemKey(LRPicklistConstants.DESIGNATION, employmentDetail.getDesignationId(), themeDisplay.getCompanyId()).getName(themeDisplay.getLocale()));
														} catch (Exception e) {
														LOGGER.error("Exception ::"+e.getMessage());
														}
												}
												try {
													employmentDetail.setWorkSectorLocation(omsbCommonApi.getListTypeEntryByListTypeItemKey(LRPicklistConstants.GOVERNORATE, employmentDetail.getWorkSectorLocation(), themeDisplay.getCompanyId()).getName(themeDisplay.getLocale()));
												} catch (Exception e) {
													LOGGER.error("Exception ::"+e.getMessage());
												}
												
												//employmentDetail.setDesignationId(omsbCommonApi.getListTypeEntryByListTypeItemKey(LRPicklistConstants.DESIGNATION, employmentDetail.getDesignationId(), themeDisplay.getCompanyId()).getName(themeDisplay.getLocale()));
												
											}
											
										}
										renderRequest.setAttribute("pastWorkDetails", employmentDetailList);
									}
									
//									renderRequest.setAttribute("workSectorTypeList", workSectorTypes.stream().sorted((o1, o2)->o1.getName(themeDisplay.getLocale()).
//							                compareTo(o2.getName(themeDisplay.getLocale()))).collect(Collectors.toList()));
//									renderRequest.setAttribute("wilayats", governorate.stream().sorted((o1, o2)->o1.getName(themeDisplay.getLocale()).
//							                compareTo(o2.getName(themeDisplay.getLocale()))).collect(Collectors.toList()));
//									renderRequest.setAttribute("designations", designations.stream().sorted((o1, o2)->o1.getName(themeDisplay.getLocale()).
//							                compareTo(o2.getName(themeDisplay.getLocale()))).collect(Collectors.toList()));
									
									renderRequest.setAttribute("personId", person.getId());
									//renderRequest.setAttribute("workSectors", workSectorJsonArray);
//									LOGGER.info(" workSectorTypes :: "+workSectorTypes.stream().sorted((o1, o2)->o1.getName(themeDisplay.getLocale()).
//							                compareTo(o2.getName(themeDisplay.getLocale()))).collect(Collectors.toList()));
								}
								return OmsbRegistrationWebPortletKeys.EDIT_REGISTRATION_DETAILS_JSP;
							}
						} catch (UnsupportedEncodingException e1) {
							LOGGER.info("unable to fetch Person by lrUrser id "+themeDisplay.getUserId());
						}
					}
				} catch (PortalException e) {
					LOGGER.error(e.getMessage(), e);
				}
				return OmsbRegistrationWebPortletKeys.ADMIN_REGISTRATION_LIST_JSP;
			}
		} else {
			HttpServletRequest httpReq = PortalUtil.getOriginalServletRequest(PortalUtil.getHttpServletRequest(renderRequest));
			String fullNameEn = httpReq.getParameter("omancardTitleFullNameEn");
			String fullNameAr = httpReq.getParameter("omancardTitleFullNameAr");
			String civilNumber = httpReq.getParameter("omanIDCivilNumber");
			String gender = httpReq.getParameter("sex_EN");
			String dob = httpReq.getParameter("omancardDateBirth");
			String countryCode = httpReq.getParameter("omancardNationalityCountryCode");
            boolean isActiveUser=false;
			if(Validator.isNotNull(fullNameEn) && Validator.isNotNull(civilNumber)) {
				String viewJSP = null;
				if(Validator.isNotNull(dob)) {
					dob = omsbCommonApi.convertDateToNewDDMMYYYYString(omsbCommonApi.convertStringYYYYMMDDToDate(dob));
					PersonItem personItems = registrationUtil.getPersonItems(themeDisplay.getPortalURL(), themeDisplay.getScopeGroupId(), civilNumber, null, omsbCommonApi.convertNewDDMMYYYYStringToYYYYDDMMString(dob));
					if (Validator.isNotNull(personItems) && Validator.isNotNull(personItems.getItems()) && personItems.getItems().size() > 0) {
						Person person = personItems.getItems().get(0);
						if(Validator.isNotNull(person) && person.getId() > 0) {
							person.setDateOfBirth(omsbCommonApi.convertObjectDateToNewDDMMYYYYDate(person.getDateOfBirth()));
							renderRequest.setAttribute("person", person);
							if(person.getLrUserId() > 0) {
								try {
									User user = UserLocalServiceUtil.getUser(person.getLrUserId());
									if(user.isActive()) {
										isActiveUser=user.isActive();
									} else {
										if(Validator.isNotNull(user.getPortraitId())) {
											DLFileEntry dlFileEntry = DLFileEntryLocalServiceUtil.getDLFileEntry(user.getPortraitId());
											renderRequest.setAttribute("photo", dlFileEntry.getDescription());
											FileEntry entry = DLAppLocalServiceUtil.getFileEntry(user.getPortraitId());
											renderRequest.setAttribute("photoURL", DLURLHelperUtil.getPreviewURL(entry, entry.getFileVersion(), themeDisplay, ""));
										} 
										renderRequest.setAttribute("lrUser", user);
									}
								} catch (PortalException e) {
									LOGGER.error("Error while getting user info, "+e.getMessage());
								}
							}
							if(!isActiveUser) {
							PersonalDetailItem personalDetailsItems = registrationUtil.getPersonalDetailsItems(themeDisplay.getPortalURL(), themeDisplay.getScopeGroupId(), person.getId(), null);
							if(Validator.isNotNull(personalDetailsItems) && Validator.isNotNull(personalDetailsItems.getItems()) && personalDetailsItems.getItems().size()>0) {
								PersonalDetail personalDetail = personalDetailsItems.getItems().get(0);
								personalDetail.setPassportExpiryDate(Validator.isNotNull(personalDetail.getPassportExpiryDate())? omsbCommonApi.convertObjectDateToNewDDMMYYYYDate(personalDetail.getPassportExpiryDate()):null);
								try {
									long professionId=omsbCommonApi.getListTypeEntryByListTypeItemKey(LRPicklistConstants.PROFESSION, personalDetail.getProfession(), themeDisplay.getCompanyId()).getListTypeEntryId();
									personalDetail.setProfession(String.valueOf(professionId));
								} catch(Exception e) {
									LOGGER.error("Error while getting profession : "+e.getMessage());
								}
								renderRequest.setAttribute("personalDetails", personalDetail);
								
								try {
									FileEntry entry = DLAppLocalServiceUtil.getFileEntry(personalDetail.getCivilCardFrontPhotoId());
									renderRequest.setAttribute("civilCardFrontPhoto", entry.getDescription());
									renderRequest.setAttribute("civilCardFrontPhotoURL",DLURLHelperUtil.getPreviewURL(entry, entry.getFileVersion(), themeDisplay, ""));
								}catch(PortalException e) {
									LOGGER.error("unable to get the file entry having id  "+personalDetail.getCivilCardFrontPhotoId());
								}
								
								try {
									FileEntry entry = DLAppLocalServiceUtil.getFileEntry(personalDetail.getCivilCardBackPhotoId());
									renderRequest.setAttribute("civilCardBackPhoto", entry.getDescription());
									renderRequest.setAttribute("civilCardBackPhotoURL",DLURLHelperUtil.getPreviewURL(entry, entry.getFileVersion(), themeDisplay, ""));
								}catch(PortalException e) {
									LOGGER.error("unable to get the file entry having id  "+personalDetail.getCivilCardBackPhotoId());
								}
								
								try {
									FileEntry entry = DLAppLocalServiceUtil.getFileEntry(personalDetail.getPassportPhotoId());
									renderRequest.setAttribute("passportPhoto", entry.getDescription());
									renderRequest.setAttribute("passportPhotoURL",DLURLHelperUtil.getPreviewURL(entry, entry.getFileVersion(), themeDisplay, ""));
								}catch(PortalException e) {
									LOGGER.error("unable to get the file entry having id  "+personalDetail.getPassportPhotoId());
								}
							}
						}
						}
						if(!isActiveUser) {
								List<ListTypeEntry> professionList = registrationUtil.getPickListEntries(LRPicklistConstants.PROFESSION, themeDisplay.getCompanyId());
								renderRequest.setAttribute("professionList", professionList.stream().sorted((o1, o2)->o1.getName(themeDisplay.getLocale()).
						                compareTo(o2.getName(themeDisplay.getLocale()))).collect(Collectors.toList()));
								
								List<ListTypeEntry> specialityList = registrationUtil.getPickListEntries(LRPicklistConstants.SPECIALIY, themeDisplay.getCompanyId());
								renderRequest.setAttribute("specialityList", specialityList.stream().sorted((o1, o2)->o1.getName(themeDisplay.getLocale()).
						                compareTo(o2.getName(themeDisplay.getLocale()))).collect(Collectors.toList()));
								
								List<com.liferay.portal.kernel.model.Country> countries = CountryLocalServiceUtil.getCountries(QueryUtil.ALL_POS, QueryUtil.ALL_POS);
								if(Validator.isNotNull(countries) && countries.size()>0) {
									renderRequest.setAttribute("countries", countries);
								}
//								viewJSP = OmsbRegistrationWebPortletKeys.REGISTRATION_PERSONAL_DETAILS_JSP;
								
								
								viewJSP = OmsbRegistrationWebPortletKeys.REGISTRATION_JSP;
								LOGGER.info(viewJSP);
						} else {
							renderRequest.setAttribute("userAlreadyExist", true);
							viewJSP = OmsbRegistrationWebPortletKeys.REGISTRATION_THANK_YOU_JSP;
						}
					} else {
						renderRequest.setAttribute("civilId", civilNumber);
						renderRequest.setAttribute("dateOfBirth", dob);
						viewJSP = OmsbRegistrationWebPortletKeys.IDENTIFICATION_CONFIRMATION_JSP;
					}
					
					if(Validator.isNotNull(countryCode)) {
						try {
							com.liferay.portal.kernel.model.Country country = CountryLocalServiceUtil.getCountryByNumber(PortalUtil.getDefaultCompanyId(), countryCode);
							CountryItem customCountryItems = registrationUtil.getCustomCountryItems(themeDisplay.getPortalURL(), themeDisplay.getScopeGroupId());
							if(Validator.isNotNull(customCountryItems) && Validator.isNotNull(customCountryItems.getItems()) && customCountryItems.getItems().size()>0) {
								renderRequest.setAttribute("customCountries", customCountryItems.getItems());
								for(Country cCountry : customCountryItems.getItems()) {
									if(cCountry.getNationality().equalsIgnoreCase(country.getName())) {
										renderRequest.setAttribute("countryId", cCountry.getId());
										break;
									}
								}
							}
						} catch (PortalException e) {
							LOGGER.error(e.getMessage(), e);
						}
					}
					
					List<GenderMaster> genderMasterList = registrationUtil.getGenderMasterList(themeDisplay);
					renderRequest.setAttribute("genderList", genderMasterList.stream().sorted((o1, o2)->o1.getGenderName(themeDisplay.getLocale()).
							compareTo(o2.getGenderName(themeDisplay.getLocale()))).collect(Collectors.toList()));
					if(Validator.isNotNull(gender)) {								
						for(GenderMaster genderMaster : genderMasterList) {
							if(genderMaster.getGenderName().equalsIgnoreCase(gender)) {
								renderRequest.setAttribute("genderId", genderMaster.getGenderMasterId());
								break;
							}
						}
					}
					
					renderRequest.setAttribute("fullNameAr", fullNameAr);
					renderRequest.setAttribute("fullName", fullNameEn);
				}
				return viewJSP;
			} else {
				return OmsbRegistrationWebPortletKeys.IDENTIFICATION_PERSONAL_ID_JSP;
			}
		}
	}
	
	private PersonalDetail getPersonalDetailByLrUserId(ThemeDisplay themeDisplay,long personId) {
		PersonalDetailItem personalDetailsItems = registrationUtil.getPersonalDetailsItems(themeDisplay.getPortalURL(), themeDisplay.getScopeGroupId(), personId, null);
		if(Validator.isNotNull(personalDetailsItems) && Validator.isNotNull(personalDetailsItems.getItems()) && personalDetailsItems.getItems().size()>0) {
			personalDetailsItems.getItems().get(0).setPassportExpiryDate(Validator.isNotNull(personalDetailsItems.getItems().get(0).getPassportExpiryDate())?omsbCommonApi.convertObjectDateToNewDDMMYYYYDate(personalDetailsItems.getItems().get(0).getPassportExpiryDate()):null);
			return personalDetailsItems.getItems().get(0);
		}
		return null;
	}
	
	private List<EducationDetail> getEducationDetailList(ThemeDisplay themeDisplay,long personId){
		List<EducationDetail> educationDetails =null;
		try {
			EducationDetailItem educationalDetailItem = registrationUtil.fetchEducationDetailByPersonId(themeDisplay, personId);
			LOGGER.info("educationalDetailItem : "+educationalDetailItem.getItems().size());
			educationDetails = getEducationDetailList(themeDisplay, educationalDetailItem);
		} catch (UnsupportedEncodingException e) {
			LOGGER.error(e.getMessage());
		}
		return educationDetails;
	}

	private List<EducationDetail> getEducationDetailList(ThemeDisplay themeDisplay, EducationDetailItem educationalDetailItem) {
		 List<EducationDetail>  educationalDetailItemList=null;
		if(Validator.isNotNull(educationalDetailItem) && educationalDetailItem.getItems().size()>0) {
			LOGGER.info("educationalDetail ::::::::::::::::::"+educationalDetailItem.getItems().get(0).getPersonId());
		   educationalDetailItemList =educationalDetailItem.getItems();
		    for(EducationDetail detail : educationalDetailItemList) {
		    	
		    	
		    	LOGGER.info("detail.getIssuingAuthorityName() ::::"+detail.getIssuingAuthorityName());
		    	
		    	if(Validator.isNotNull( detail.getQualificationAttained())) {
		    		try {
		    		detail.setQualificationAttained(omsbCommonApi.getListTypeEntryByListTypeItemKey(LRPicklistConstants.QUALIFICATION, detail.getQualificationAttained(), themeDisplay.getCompanyId()).getName(themeDisplay.getLocale()));
		    		}
		    		catch(Exception e) {
		    			LOGGER.error("unable to get the List type entry "+e.getMessage());
		    		}
		    		}
		        if(Validator.isNotNull( detail.getIssuingAuthorityName())) {
		        	ListTypeEntry listTypeEntry =null;
		        	try {
		        		listTypeEntry=ListTypeEntryLocalServiceUtil.getListTypeEntry(Long.parseLong(detail.getIssuingAuthorityName()));
		        	detail.setIssuingAuthorityName(listTypeEntry.getName(themeDisplay.getLocale()));
		        	}catch(Exception e) {
		        		LOGGER.error("unable to get the List type entry "+e.getMessage());
		        	}
		        	}
		        if(Validator.isNotNull( detail.getIssuingAuthorityCountryId())) {
		        	 com.liferay.portal.kernel.model.Country issuingCountry=null;
					try {
						issuingCountry = CountryLocalServiceUtil.getCountry(detail.getIssuingAuthorityCountryId());
						detail.setIssuingAuthorityCountry(issuingCountry.getName(themeDisplay.getLocale()));
					} catch (PortalException e1) {
						LOGGER.info("unable to get the country by country id :"+detail.getIssuingAuthorityCountry());
					}
		        }
		    }
		    LOGGER.info("educationalDetailItemList ::::" +educationalDetailItemList.size());
		    LOGGER.info("educationalDetailItemList ::::" +educationalDetailItemList.get(0).getIssuingAuthorityCountryId());
		}
		 return educationalDetailItemList;
	}
	private List<EducationDetail> getEducationDetailListByLrUserId(ThemeDisplay themeDisplay,long lrUserId){
		List<EducationDetail> educationDetails =null;
		EducationDetailItem educationalDetailItem = registrationUtil.fetchEducationDetailByLrUserId(themeDisplay, lrUserId);
		educationDetails = getEducationDetailList(themeDisplay, educationalDetailItem);
		return educationDetails;
	}

	
	@Reference(unbind = "_")
	private OMSBCommonApi omsbCommonApi;

	@Reference(unbind = "-")
	private OMSBHttpConnector oMSBHttpConnector;

	@Reference(unbind = "_")
	private RegistrationUtil registrationUtil;

	private static final Log LOGGER = LogFactoryUtil.getLog(ViewMVCRenderCommand.class);
}
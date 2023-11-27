package gov.omsb.registration.web.resource;

import com.liferay.document.library.kernel.model.DLFileEntry;
import com.liferay.document.library.kernel.model.DLFolderConstants;
import com.liferay.document.library.kernel.service.DLAppServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.Role;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCResourceCommand;
import com.liferay.portal.kernel.repository.model.FileEntry;
import com.liferay.portal.kernel.repository.model.Folder;
import com.liferay.portal.kernel.security.auth.CompanyThreadLocal;
import com.liferay.portal.kernel.security.permission.PermissionChecker;
import com.liferay.portal.kernel.security.permission.PermissionCheckerFactoryUtil;
import com.liferay.portal.kernel.security.permission.PermissionThreadLocal;
import com.liferay.portal.kernel.service.RoleLocalServiceUtil;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextFactory;
import com.liferay.portal.kernel.service.UserLocalService;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.upload.UploadPortletRequest;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.List;

import javax.portlet.PortletException;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import gov.omsb.registration.web.constants.MVCCommands;
import gov.omsb.registration.web.constants.OmsbRegistrationWebPortletKeys;
import gov.omsb.registration.web.util.RegistrationUtil;

@Component(
		immediate=true,
	    property = { 
	    	"javax.portlet.name=" + OmsbRegistrationWebPortletKeys.OMSBREGISTRATIONWEB,
	        "mvc.command.name="+MVCCommands.UPLOAD_USER_PHOTO
	    }, 
	    service = MVCResourceCommand.class
)
public class UploadUserImageMVCResourceCommand implements MVCResourceCommand{

	private static final Log LOGGER = LogFactoryUtil.getLog(UploadUserImageMVCResourceCommand.class);

	@Override
	public boolean serveResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse)
			throws PortletException {
     LOGGER.info("inside servce REsource command");
     long userId=ParamUtil.getLong(resourceRequest, "userId");
     ThemeDisplay themeDisplay = (ThemeDisplay) resourceRequest.getAttribute(WebKeys.THEME_DISPLAY);
     LOGGER.info("userId : "+userId);
    User user=null;
    try {
	user=userService.getUser(userId);
	} catch (PortalException e) {
		LOGGER.error("unable to get the user having user id "+userId +"   ::: "+e.getMessage());
	}
    if(Validator.isNotNull(user)) {
    	Role adminRole;
		try {
			adminRole = RoleLocalServiceUtil.getRole(CompanyThreadLocal.getCompanyId(), "Administrator");
			List<User> adminUsers = UserLocalServiceUtil.getRoleUsers(adminRole.getRoleId());
			long adminUserId =registrationUtil.getAdmin(themeDisplay.getCompanyId()).getUserId();
			if (adminUsers != null && !adminUsers.isEmpty()) {
				adminUserId = adminUsers.get(0).getUserId();
			}
			User user1 = UserLocalServiceUtil.getUser(adminUserId);
			PermissionChecker checker = PermissionCheckerFactoryUtil.create(user1);
			PermissionThreadLocal.setPermissionChecker(checker);
			FileEntry uploadFile=null;
			if(user.getPortraitId()!=0) {
				try {
					DLAppServiceUtil.deleteFileEntry(user.getPortraitId());
					uploadFile = uploadFile(resourceRequest, "photo", themeDisplay, OmsbRegistrationWebPortletKeys.PHOTO_FOLDERNAME);
				} catch (PortalException e) {
	              LOGGER.info("unable to delete the file entry having file EntryId "+user.getPortraitId()+" --- "+e.getCause());
				}
			}
			if(Validator.isNotNull(uploadFile)) {
				user.setPortraitId(uploadFile.getFileEntryId());
			    UserLocalServiceUtil.updateUser(user);
			}
	    	
		} catch (PortalException e1) {
			e1.printStackTrace();
		}
		
    	
    }
   
     
  
		return false;
	}
	
	private FileEntry uploadFile(ResourceRequest resourceRequest,String fileName,ThemeDisplay themeDisplay, String folderName) {
		LOGGER.info("inside upload file method");
		Role adminRole;
		try {
			adminRole = RoleLocalServiceUtil.getRole(CompanyThreadLocal.getCompanyId(), "Administrator");
			List<User> adminUsers = UserLocalServiceUtil.getRoleUsers(adminRole.getRoleId());
			long adminUserId =registrationUtil.getAdmin(themeDisplay.getCompanyId()).getUserId();
			if (adminUsers != null && !adminUsers.isEmpty()) {
				adminUserId = adminUsers.get(0).getUserId();
			}
			User user1 = UserLocalServiceUtil.getUser(adminUserId);
			PermissionChecker checker = PermissionCheckerFactoryUtil.create(user1);
			PermissionThreadLocal.setPermissionChecker(checker);
		UploadPortletRequest uploadPortletRequest = PortalUtil.getUploadPortletRequest(resourceRequest);
		try {
			ServiceContext serviceContext = ServiceContextFactory.getInstance(DLFileEntry.class.getName(),
					resourceRequest);
		     File file = uploadPortletRequest.getFile("uploadFile");			
			LOGGER.info("fileName :::" +fileName);
			
			
			Folder folder = null;
			try {
				folder = DLAppServiceUtil.getFolder(themeDisplay.getScopeGroupId(),
						DLFolderConstants.DEFAULT_PARENT_FOLDER_ID, folderName);
			} catch (Exception e) {
				folder = DLAppServiceUtil.addFolder(null, themeDisplay.getScopeGroupId(),
						DLFolderConstants.DEFAULT_PARENT_FOLDER_ID, folderName,
						folderName, serviceContext);
			}
			return DLAppServiceUtil.addFileEntry(null, themeDisplay.getScopeGroupId(), folder.getFolderId(),
					StringUtil.randomString()+uploadPortletRequest.getFileName(fileName) ,
					uploadPortletRequest.getContentType(fileName),
					StringUtil.randomString() + fileName ,
					StringUtil.randomString() +uploadPortletRequest.getFileName(fileName),
					uploadPortletRequest.getFileName(fileName), "", new FileInputStream(file), file.length(), null, null,
					serviceContext);
		} catch (PortalException | FileNotFoundException e) {
			LOGGER.error(e.getMessage());
		}
		} catch (PortalException e1) {
			e1.printStackTrace();
		}
		
		return null;
	}
	@Reference(unbind = "_")
	private UserLocalService userService;
	
	@Reference(unbind = "_")
	private RegistrationUtil registrationUtil;
}

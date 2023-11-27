package gov.omsb.email.template.master.portlet.action;

import com.liferay.asset.kernel.model.AssetCategory;
import com.liferay.asset.kernel.model.AssetVocabulary;
import com.liferay.asset.kernel.service.AssetCategoryLocalService;
import com.liferay.asset.kernel.service.AssetVocabularyLocalService;
import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.json.JSONException;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;

import java.util.List;
import java.util.Map;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import gov.omsb.email.template.master.common.api.OMSBEmailTemplateMasterCommonApi;
import gov.omsb.email.template.master.common.constants.OMSBEmailTemplateMasterCommonConstants;
import gov.omsb.email.template.master.constants.EmailTemplateMasterConstants;
import gov.omsb.email.template.master.constants.EmailTemplateMasterPortletKeys;
import gov.omsb.email.template.master.model.EmailTemplateMaster;
import gov.omsb.email.template.master.portlet.util.EmailTemplateMasterUtil;
import gov.omsb.email.template.master.service.EmailTemplateMasterLocalService;

/**
 * @author Niddhi Thacker
 *
 */
@Component(
		immediate=true,
	    property = { 
	    	"javax.portlet.name=" + EmailTemplateMasterPortletKeys.OMSB_EMAIL_TEMPLATE_MASTER_PORTLET,
	        "mvc.command.name=/",
	    }, 
	    service = MVCRenderCommand.class
)
public class ViewEmailTemplateMVCRenderCommand implements MVCRenderCommand{

	private static final Log log = LogFactoryUtil.getLog(ViewEmailTemplateMVCRenderCommand.class);
	
	@Override
	public String render(RenderRequest renderRequest, RenderResponse renderResponse) throws PortletException {
		log.info("View Render Command");
		ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);
		long groupId = themeDisplay.getScopeGroupId();
		String redirectURL = ParamUtil.getString(renderRequest, OMSBEmailTemplateMasterCommonConstants.REDIRECT_URL,StringPool.BLANK);	
		String action = ParamUtil.getString(renderRequest, OMSBEmailTemplateMasterCommonConstants.ACTION, StringPool.BLANK);
		if(Validator.isNotNull(action) && (action.equals(OMSBEmailTemplateMasterCommonConstants.ADD) || action.equals(OMSBEmailTemplateMasterCommonConstants.EDIT))) {
			long emailTemplateId = ParamUtil.getLong(renderRequest, EmailTemplateMasterConstants.TEMPLATE_IDX, 0);
			new EmailTemplateMasterUtil(emailTemplateMasterLocalService, omsbEmailTemplateMasterCommonApi);
			if(emailTemplateId > 0) {
				EmailTemplateMaster emailTemplateMaster = EmailTemplateMasterUtil.getEmailTemplate(emailTemplateId);
				List<Map<String, Object>> attachmentFileEntriesMap = omsbEmailTemplateMasterCommonApi.getEmailTemplateAttachmentFiles(renderRequest, themeDisplay, groupId, emailTemplateId);
				String dynamicBody = emailTemplateMaster.getDynamicBody();
				String staticBody = emailTemplateMaster.getStaticBody();
				String signature = emailTemplateMaster.getSignature();
				String userNotification = emailTemplateMaster.getUserNotification();
				JSONObject dynamicBodyJSON, staticBodyJSON, signatureJSON, userNotificationJSON;
				String enUSDynamicBodyVal = StringPool.BLANK, arSADynamicBodyVal = StringPool.BLANK, enUSStaticBodyVal = StringPool.BLANK;
				String arSAStaticBodyVal = StringPool.BLANK, enUSSignatureVal = StringPool.BLANK, arSASignatureVal = StringPool.BLANK;
				String enUSUserNotificationVal = StringPool.BLANK, arSAUserNotificationVal = StringPool.BLANK;
				try {
					dynamicBodyJSON = JSONFactoryUtil.createJSONObject(dynamicBody);
					staticBodyJSON = JSONFactoryUtil.createJSONObject(staticBody);
					signatureJSON = JSONFactoryUtil.createJSONObject(signature);
					userNotificationJSON = JSONFactoryUtil.createJSONObject(userNotification);
					
					enUSDynamicBodyVal = new String(java.util.Base64.getDecoder().decode(dynamicBodyJSON.getString(EmailTemplateMasterConstants.EN_US_LANGUAGEID)));
					arSADynamicBodyVal = new String(java.util.Base64.getDecoder().decode(dynamicBodyJSON.getString(EmailTemplateMasterConstants.AR_SA_LANGUAGEID)));
					
					enUSStaticBodyVal = new String(java.util.Base64.getDecoder().decode(staticBodyJSON.getString(EmailTemplateMasterConstants.EN_US_LANGUAGEID)));
					arSAStaticBodyVal = new String(java.util.Base64.getDecoder().decode(staticBodyJSON.getString(EmailTemplateMasterConstants.AR_SA_LANGUAGEID)));
					
					enUSSignatureVal = new String(java.util.Base64.getDecoder().decode(signatureJSON.getString(EmailTemplateMasterConstants.EN_US_LANGUAGEID)));
					arSASignatureVal = new String(java.util.Base64.getDecoder().decode(signatureJSON.getString(EmailTemplateMasterConstants.AR_SA_LANGUAGEID)));
					
					enUSUserNotificationVal = new String(java.util.Base64.getDecoder().decode(userNotificationJSON.getString(EmailTemplateMasterConstants.EN_US_LANGUAGEID)));
					arSAUserNotificationVal = new String(java.util.Base64.getDecoder().decode(userNotificationJSON.getString(EmailTemplateMasterConstants.AR_SA_LANGUAGEID)));
					
					log.info("dynamicBody ::::: " +dynamicBody);
					log.info("enUSDecodedVal ::::: " +enUSDynamicBodyVal);
				} catch (JSONException e) {
					log.error(e);
				}
				
				
				renderRequest.setAttribute(EmailTemplateMasterConstants.EMAIL_TEMPLATE_MASTER, emailTemplateMaster);
				renderRequest.setAttribute(EmailTemplateMasterConstants.EN_US_DYNAMIC_BODY_VAL, enUSDynamicBodyVal);
				renderRequest.setAttribute(EmailTemplateMasterConstants.AR_SA_DYNAMIC_BODY_VAL, arSADynamicBodyVal);
				renderRequest.setAttribute(EmailTemplateMasterConstants.EN_US_STATIC_BODY_VAL, enUSStaticBodyVal);
				renderRequest.setAttribute(EmailTemplateMasterConstants.AR_SA_STATIC_BODY_VAL, arSAStaticBodyVal);
				renderRequest.setAttribute(EmailTemplateMasterConstants.EN_US_SIGNATURE_VAL, enUSSignatureVal);
				renderRequest.setAttribute(EmailTemplateMasterConstants.AR_SA_SIGNATURE_VAL, arSASignatureVal);
				renderRequest.setAttribute(EmailTemplateMasterConstants.EN_US_USER_NOTIFICATION_VAL, enUSUserNotificationVal);
				renderRequest.setAttribute(EmailTemplateMasterConstants.AR_SA_USER_NOTIFICATION_VAL, arSAUserNotificationVal);
				renderRequest.setAttribute(EmailTemplateMasterConstants.IS_EDIT, true);
				renderRequest.setAttribute(EmailTemplateMasterConstants.ATTACHMENT_FILE_ENTRIES_MAP, attachmentFileEntriesMap);
			}
			List<AssetCategory> categoryTags = null;
			AssetVocabulary assetVocabulary;
			try {
				assetVocabulary = omsbEmailTemplateMasterCommonApi.getAssetVocabulary(renderRequest, themeDisplay, EmailTemplateMasterConstants.EMAIL_TEMPLATE);
				if(Validator.isNotNull(assetVocabulary)) {
					AssetCategory assetCategory = omsbEmailTemplateMasterCommonApi.getAssetCategory(renderRequest, themeDisplay, EmailTemplateMasterConstants.FORM_BUILDER, assetVocabulary.getVocabularyId(), 0L);
					if(Validator.isNotNull(assetCategory)) {
						categoryTags = assetCategoryLocalService.getChildCategories(assetCategory.getCategoryId());
						log.info("Category Tags: " + categoryTags);
					}
				}
			} catch (PortalException e) {
				log.error("error occured while fetching tags: " + e.getMessage());
			}
			
			renderRequest.setAttribute(EmailTemplateMasterConstants.CATEGORY_TAGS, categoryTags);
			renderRequest.setAttribute(EmailTemplateMasterConstants.ATTACHMENT_FILE_UPLOAD_LIMIT, OMSBEmailTemplateMasterCommonConstants.DEFAULT_EMAIL_TEMPLATE_ATTACHMENT_UPLOAD_LIMIT);
			renderRequest.setAttribute(EmailTemplateMasterConstants.ALLOWED_FILE_EXTENSIONS, OMSBEmailTemplateMasterCommonConstants.ALLOWED_FILE_EXTENSIONS);
			renderRequest.setAttribute(OMSBEmailTemplateMasterCommonConstants.ACTION, action);
			renderRequest.setAttribute(EmailTemplateMasterConstants.REDIRECT_URL, redirectURL);
			return EmailTemplateMasterConstants.ADD_EDIT_EMAIL_TEMPLATE_JSP;
		}else {
			return EmailTemplateMasterConstants.VIEW_EMAIL_TEMPLATE_JSP;
		}
	}
	
	@Reference
	private volatile EmailTemplateMasterLocalService emailTemplateMasterLocalService;
	
	@Reference
	private AssetCategoryLocalService assetCategoryLocalService;
	
	@Reference
	private AssetVocabularyLocalService assetVocabularyLocalService;
	
	@Reference
	private OMSBEmailTemplateMasterCommonApi omsbEmailTemplateMasterCommonApi;

}

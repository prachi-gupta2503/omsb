package gov.omsb.leave.status.web.asset;

import com.liferay.asset.kernel.model.BaseJSPAssetRenderer;
import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;

import java.util.Locale;

import javax.portlet.PortletRequest;
import javax.portlet.PortletResponse;
import javax.servlet.http.HttpServletRequest;

import gov.omsb.tms.model.LeaveMaster;

public class OmsbLeaveMasterAssetRenderer extends BaseJSPAssetRenderer<LeaveMaster> {

	private final LeaveMaster leaveMaster;

	public OmsbLeaveMasterAssetRenderer(LeaveMaster leaveMaster) {
		this.leaveMaster = leaveMaster;
	}

	@Override
	public LeaveMaster getAssetObject() {
		return leaveMaster;
	}

	@Override
	public long getGroupId() {
		return leaveMaster.getGroupId();
	}

	@Override
	public long getUserId() {
		return leaveMaster.getCreatedBy();
	}

	@Override
	public String getUserName() {
		String userName = StringPool.BLANK;
		try {
			userName = UserLocalServiceUtil.getUser(leaveMaster.getCreatedBy()).getFullName();
		} catch (PortalException e) {
			e.printStackTrace();
		}
		return userName;
	}

	@Override
	public String getUuid() {
		return leaveMaster.getUuid();
	}

	@Override
	public String getClassName() {
		return LeaveMaster.class.getName();
	}

	@Override
	public long getClassPK() {
		return leaveMaster.getLeaveMasterId();
	}

	@Override
	public String getSummary(PortletRequest portletRequest, PortletResponse portletResponse) {
		return "Trainee has applied for the leave";
	}

	@Override
	public String getTitle(Locale locale) {
		return "Trainee has applied for the leave";
	}

	@Override
	public String getJspPath(HttpServletRequest httpServletRequest, String template) {
		return StringPool.BLANK;
	}

}

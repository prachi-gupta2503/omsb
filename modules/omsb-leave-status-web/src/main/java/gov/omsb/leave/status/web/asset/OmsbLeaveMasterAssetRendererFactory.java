package gov.omsb.leave.status.web.asset;

import com.liferay.asset.kernel.model.AssetRenderer;
import com.liferay.asset.kernel.model.AssetRendererFactory;
import com.liferay.asset.kernel.model.BaseAssetRendererFactory;
import com.liferay.portal.kernel.exception.PortalException;

import javax.servlet.ServletContext;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import gov.omsb.leave.status.web.constants.OmsbLeaveStatusWebPortletKeys;
import gov.omsb.tms.model.LeaveMaster;
import gov.omsb.tms.service.LeaveMasterLocalService;

@Component(immediate = true, property = { "javax.portlet.name="
		+ OmsbLeaveStatusWebPortletKeys.OMSBLEAVESTATUSWEB }, service = AssetRendererFactory.class)
public class OmsbLeaveMasterAssetRendererFactory extends BaseAssetRendererFactory<LeaveMaster> {

	private LeaveMasterLocalService leaveMasterLocalService;
	private ServletContext servletContext;

	@Reference(unbind = "-")
	protected void setLeaveService(LeaveMasterLocalService leaveMasterLocalService) {
		this.leaveMasterLocalService = leaveMasterLocalService;
	}

	@Reference(unbind = "-")
	public void setServletContext(ServletContext servletContext) {
		this.servletContext = servletContext;
	}

	public OmsbLeaveMasterAssetRendererFactory() {
		setClassName(LeaveMaster.class.getName());
		setCategorizable(true);
		setLinkable(true);
		setPortletId(OmsbLeaveStatusWebPortletKeys.OMSBLEAVESTATUSWEB);
		setSearchable(true);
		setSelectable(true);
	}

	@Override
	public AssetRenderer<LeaveMaster> getAssetRenderer(long classPK, int type) throws PortalException {

		LeaveMaster leaveMaster = leaveMasterLocalService.getLeaveMaster(classPK);
		OmsbLeaveMasterAssetRenderer omsbLeaveMasterAssetRenderer = new OmsbLeaveMasterAssetRenderer(leaveMaster);
		omsbLeaveMasterAssetRenderer.setAssetRendererType(type);
		omsbLeaveMasterAssetRenderer.setServletContext(servletContext);

		return omsbLeaveMasterAssetRenderer;
	}

	@Override
	public String getType() {
		return "leaveMaster";
	}

	@Override
	public String getClassName() {
		return LeaveMaster.class.getName();
	}

}
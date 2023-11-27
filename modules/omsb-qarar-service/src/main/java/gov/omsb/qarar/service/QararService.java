package gov.omsb.qarar.service;

import com.liferay.portal.kernel.exception.PortalException;

public interface QararService {
	
	public long createECMembershipQarar(String programName, String doctorName, long referenceId, String referenceClass,
			long userId, long companyId, long groupId) throws PortalException;

}
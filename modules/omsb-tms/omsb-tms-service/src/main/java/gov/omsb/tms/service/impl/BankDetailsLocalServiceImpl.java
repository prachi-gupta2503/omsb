/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package gov.omsb.tms.service.impl;

import com.liferay.portal.aop.AopService;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

import gov.omsb.tms.exception.NoSuchBankDetailsException;
import gov.omsb.tms.model.BankDetails;
import gov.omsb.tms.service.base.BankDetailsLocalServiceBaseImpl;

import org.osgi.service.component.annotations.Component;

/**
 * @author Brian Wing Shun Chan
 */
@Component(
	property = "model.class.name=gov.omsb.tms.model.BankDetails",
	service = AopService.class
)
public class BankDetailsLocalServiceImpl extends BankDetailsLocalServiceBaseImpl {
	
	public BankDetails addBankDetails(String bankName, String bankBranch, String accountNumber,long ecMemberRequestId) {
		long bankDetailsId= counterLocalService.increment(BankDetails.class.getName());
		BankDetails bankDetails = bankDetailsLocalService.createBankDetails(bankDetailsId);
		bankDetails.setBankName(bankName);
		bankDetails.setBankBranch(bankBranch);
		bankDetails.setAccountNumber(accountNumber);
		bankDetails.setEcMemberRequestId(ecMemberRequestId);
		return bankDetailsLocalService.addBankDetails(bankDetails);
	}
	
	public BankDetails findByEcMemberRequestId(long ecMemberRequestId) {
		BankDetails bankDetails = null;
		try {
			bankDetails = this.bankDetailsPersistence.findByEcMemberRequestId(ecMemberRequestId);
		} catch (NoSuchBankDetailsException e) {
			log.error("Error while fetching bank details");
		}
		return bankDetails;
	}
	
	public BankDetails editBankDetails(long bankDetailsId,String bankName, String bankBranch, String accountNumber,long ecMemberRequestId) {
		BankDetails bankDetails=null;
		System.out.println("bank edit----"+bankDetailsId);
		try {
			 bankDetails = bankDetailsLocalService.getBankDetails(bankDetailsId);
			 if(bankDetails!=null) {
			 bankDetails.setBankBranch(bankBranch);
			 bankDetails.setAccountNumber(accountNumber);
			 bankDetails.setBankName(bankName);
			 bankDetails.setEcMemberRequestId(ecMemberRequestId);
			 bankDetailsLocalService.updateBankDetails(bankDetails);
			 }
		} catch (PortalException e) {
			log.error("Error while getting bank details by bankDetailsId");
		}
		return null;
		
	}
	
	private static final Log log = LogFactoryUtil.getLog(BankDetailsLocalServiceImpl.class);
}
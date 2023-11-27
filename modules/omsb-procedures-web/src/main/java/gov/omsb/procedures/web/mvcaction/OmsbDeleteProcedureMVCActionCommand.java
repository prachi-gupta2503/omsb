/**
 * Copyright 2000-present Liferay, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package gov.omsb.procedures.web.mvcaction;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.util.ParamUtil;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import gov.omsb.procedures.web.constants.OmsbProceduresConstants;
import gov.omsb.procedures.web.constants.OmsbProceduresWebPortletKeys;
import gov.omsb.tms.service.ProcedureMasterLocalService;

@Component(immediate = true, property = { "javax.portlet.name=" + OmsbProceduresWebPortletKeys.OMSBPROCEDURESWEB,
		"mvc.command.name="
				+ OmsbProceduresConstants.DELETE_PROCEDURE_MASTER_MVC_COMMAND_NAME }, service = MVCActionCommand.class)
public class OmsbDeleteProcedureMVCActionCommand extends BaseMVCActionCommand {

	@Override
	protected void doProcessAction(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {

		long procedureMasterId = ParamUtil.getLong(actionRequest, OmsbProceduresConstants.PROCEDURE_ID);

		procedureMasterLocalService.deleteProcedureMaster(procedureMasterId);

		log.debug("------PROCEDURE DELETED SUCCESSFULLY------");

	}

	@Reference
	private ProcedureMasterLocalService procedureMasterLocalService;

	private Log log = LogFactoryUtil.getLog(OmsbDeleteProcedureMVCActionCommand.class.getName());

}
package gov.omsb.qarar.service;

import com.liferay.portal.kernel.backgroundtask.BackgroundTask;
import com.liferay.portal.kernel.backgroundtask.BackgroundTaskExecutor;
import com.liferay.portal.kernel.backgroundtask.BackgroundTaskResult;
import com.liferay.portal.kernel.backgroundtask.BaseBackgroundTaskExecutor;
import com.liferay.portal.kernel.backgroundtask.display.BackgroundTaskDisplay;
import com.liferay.portal.kernel.backgroundtask.display.BackgroundTaskDisplayFactoryUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

import java.util.Date;

import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.PathParam;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import gov.omsb.tms.model.QararRequest;
import gov.omsb.tms.service.QararRequestLocalServiceUtil;


@Component(immediate = true, property = "background.task.executor.class.name=gov.omsb.qarar.service.QararUpdateServiceExecutor", 
service = BackgroundTaskExecutor.class)
public class QararUpdateServiceExecutor extends BaseBackgroundTaskExecutor {
	final static Log LOGGER = LogFactoryUtil.getLog(QararUpdateServiceExecutor.class.getName());
	@Override
	public BackgroundTaskResult execute(BackgroundTask backgroundTask) throws Exception {
		LOGGER.info("QararUpdateServiceExecutor Called");
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
		}

		long docTreeId = 0;
		try {
			docTreeId=((Long) backgroundTask.getTaskContextMap().get("docTreeId")).longValue();
		}catch(Exception e) {
			LOGGER.info("Failed to read docTreeId as long value. Reason : "+e.getMessage());
		}
		
		if(docTreeId<=0) {
			try {
				docTreeId=((Integer) backgroundTask.getTaskContextMap().get("docTreeId")).longValue();
			}catch(Exception e) {
				LOGGER.info("Failed to read docTreeId as Integer value. Reason : "+e.getMessage());
			}
		}
		LOGGER.info("docTreeId value : "+docTreeId);
		
		try {
			String previewLink = (String) backgroundTask.getTaskContextMap().get("previewLink");
			boolean status = updateStatus( docTreeId, previewLink);
			
		}catch(Exception ex) {
			LOGGER.info(ex.getMessage());
		}
		
		
		return BackgroundTaskResult.SUCCESS;
	}

	public boolean updateStatus( long docTreeId, String previewLink) {
		try {
			LOGGER.info("updateStatus docTreeId > "+docTreeId);
			LOGGER.info("updateStatus previewLink > "+previewLink);
			QararRequest qararRequest = QararRequestLocalServiceUtil.findByDocTreeId(docTreeId);
			
			long qararDocId = qararServiceUtil.saveQararDoc(qararRequest, previewLink,docTreeId);
			if(qararDocId <= 0 || previewLink == null || previewLink.isBlank()) {
				return false;
			}else {
				qararRequest.setDocURL(previewLink);
				qararRequest.setQararDocId(qararDocId);
				qararRequest.setModifiedDate(new Date());
				QararRequestLocalServiceUtil.updateQararRequest(qararRequest);
	
				qararServiceUtil.updateEntityStatus(qararRequest);
			}
		} catch (Exception ex ) {
			return false;
		}

		return true;
	}
	
	@Override
	public BackgroundTaskDisplay getBackgroundTaskDisplay(BackgroundTask backgroundTask) {
		return BackgroundTaskDisplayFactoryUtil.getBackgroundTaskDisplay(backgroundTask);
	}

	@Override
	public BackgroundTaskExecutor clone() {
		return this;
	}
	
	@Reference(unbind = "-")
	private QararServiceUtil qararServiceUtil;
	
}

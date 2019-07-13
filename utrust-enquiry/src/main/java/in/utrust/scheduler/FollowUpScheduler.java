package in.utrust.scheduler;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import in.utrust.constants.Constants;
import in.utrust.model.Enquiry;
import in.utrust.model.UserDevice;
import in.utrust.notification.NotificationUtil;
import in.utrust.repository.ChecklistMappingRepository;
import in.utrust.repository.FollowUpRepository;
import in.utrust.repository.UserDeviceRepository;
 
@Service
@EnableScheduling
public class FollowUpScheduler {

	@Autowired 
	FollowUpRepository followUpRepository;
	
	@Autowired 
	UserDeviceRepository deviceRepository; 
	
	@Autowired 
	ChecklistMappingRepository checklistMappingRepository; 
	
	@Autowired
	private NotificationUtil notificationUtil;
	
//	@Scheduled(cron  = "*/30 * * * * *")
	
	private void sendFollowUpReminders(){ 
		
		try {
			List<Enquiry> enquiries=followUpRepository.getFollowUpReminders();
			for (Enquiry enquiry : enquiries) {
				UserDevice userDevice=deviceRepository.getUserDevice(enquiry.getAssignTo());
				// Send push notification to PO
				notificationUtil.sendNotification(null,enquiry.getAssignTo(),Constants.EVENT_ENQUIRY_FOLLOWUP_REMAINDER,userDevice,enquiry,null, null);
				
				// send notification here to Assigned user. FRS page number 364
 			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}
	
//	@Scheduled(cron  = "0 41 11 * * * ")
	public void sendTargetDateReminders() {

		try {
			List<Enquiry> enquiries = (List<Enquiry>)checklistMappingRepository.getFollowUpReminders();
			for (Enquiry enquiry : enquiries) {
				UserDevice userDevice = deviceRepository.getUserDevice(enquiry.getAssignTo());
				// Send push notification to PO
				notificationUtil.sendNotification(null, enquiry.getAssignTo(), Constants.EVENT_TARGET_DATE_REMAINDER,
						userDevice, enquiry, null, null);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}

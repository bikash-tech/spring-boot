package in.utrust.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.utrust.constants.Constants;
import in.utrust.model.Customer;
import in.utrust.model.Enquiry;
import in.utrust.model.NotificationMaster;
import in.utrust.model.User;
import in.utrust.model.Vehicle;
import in.utrust.notification.NotificationUtil;
import in.utrust.notification.NotificationsRequest;
import in.utrust.repository.EnquiryRepository;
import in.utrust.repository.NotificationMasterRepository;
import in.utrust.repository.UserRepository;
import in.utrust.request.NewEnquiry;

/**
 * @author RamPrasad
 *
 */
@Service("UCTDMSEnquiriesService")
public class UCTDMSEnquiriesServiceImpl {

	@Autowired
	EnquiryRepository enquiryRepository;
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	NotificationMasterRepository notificationMasterRepository;
	
	@Autowired
	NotificationUtil notificationUtil;
	
	@Autowired
	UserRepository userRepository;
	
	public void getNewEnquiriesFromUCTDMS(){
		
		try {
			NewEnquiry enquiry1 = new NewEnquiry("RG1", "90123", "Mr", "RAM", "Prasad", new Date());
			NewEnquiry enquiry2 = new NewEnquiry("RG1", "90123", "Mr", "RAM", "Prasad", new Date());
			NewEnquiry enquiry3 = new NewEnquiry("RG3", "90123", "Mr", "RAM", "Prasad", new Date());
			NewEnquiry enquiry4 = new NewEnquiry("RG4", "90123", "Mr", "RAM", "Prasad", new Date());
			NewEnquiry enquiry5 = new NewEnquiry("RG5", "90123", "Mr", "RAM", "Prasad", new Date());
			NewEnquiry enquiry6 = new NewEnquiry("RG6", "90123", "Mr", "RAM", "Prasad", new Date());
			NewEnquiry enquiry7 = new NewEnquiry("RG8", "90123", "Mr", "RAM", "Prasad", new Date());
			NewEnquiry enquiry8 = new NewEnquiry("RG8", "98123", "Mr", "RAM", "Prasad", new Date());
			
			
			List<NewEnquiry> newEnquiryList= new ArrayList<>();
			newEnquiryList.add(enquiry1);
			newEnquiryList.add(enquiry2);
			newEnquiryList.add(enquiry3);
			newEnquiryList.add(enquiry4);
			newEnquiryList.add(enquiry5);
			newEnquiryList.add(enquiry6);
			newEnquiryList.add(enquiry7);
			newEnquiryList.add(enquiry8);
			
			
			Map<String, List<NewEnquiry>> enqMap= new HashMap<>(); 
			
			for (NewEnquiry newEnquiry : newEnquiryList) {
				List<NewEnquiry> enquiryList= new LinkedList<>();
				String regNumber=newEnquiry.getRegistrationNumber();
				if (enqMap.containsKey(regNumber)) {
					List<NewEnquiry> existedEnqs=enqMap.get(regNumber);
					existedEnqs.add(newEnquiry);
					enqMap.put(regNumber, existedEnqs);
					existedEnqs=null;

				}
				else {
					enquiryList.add(newEnquiry);
					enqMap.put(regNumber, enquiryList);
				}
			}
			
			int enqMapLength=enqMap.size();
			int enqCount =0;
			List<User>  poList=userRepository.getPoList(Constants.PTL_ROLE);
			int numberOfPos=poList.size();
			
 			for (String regNo : enqMap.keySet()) {
 				 enqCount++;
				 List<NewEnquiry> enquiries=enqMap.get(regNo);
				 Collections.sort(enquiries);
				 int cnt=0;
				 for (NewEnquiry newEnquiry : enquiries) {
					 if (cnt==0) { // Enquires are sorted by time desc order.
						Enquiry enquiry = new Enquiry();
							//set status Created
						BeanUtils.copyProperties(newEnquiry, enquiry);
						Vehicle vehicle = enquiryRepository.getEnquiryByRegNumber(regNo);
						if (vehicle==null) {
							vehicle=new Vehicle();
						}
						Customer customer=enquiryRepository.getEnquiryByMobile(newEnquiry.getMobileNumber());
						if (customer==null) {
							customer= new Customer();
						}
						enquiry.setVehicle(vehicle); // set all params of vehicle from uctdms
						enquiry.setCustomer(customer);//set all params of customer from uctdms
						enquiry.setEnquiryStatus(Constants.CREATED);
						
						// assign enquiry to PTL
 						if (enqCount>numberOfPos) {
							enqCount=0;
						}
						enquiry.setAssignTo(poList.get(enqCount).getUctdmsId());
						enquiry.setAssigenedby(Constants.ASSIGNED_BY_UCTDMS); // Fixed number for enquires outside Utrust.
						enquiryRepository.save(enquiry);
					} 
					 else {
						 // set status as Dropped
						Enquiry enquiry = new Enquiry();
							//set status Created
						BeanUtils.copyProperties(newEnquiry, enquiry);
						enquiry.setEnquiryStatus(Constants.DROPPED);
						enquiryRepository.save(enquiry);
					 }
				cnt++;
				}
			}
            //send notification 
			
			NotificationsRequest notificationsRequest = new NotificationsRequest();
			NotificationMaster notificationMaster =notificationMasterRepository.getNotificationByEvent(Constants.PARALLEL_ENQUIRY); 
			BeanUtils.copyProperties(notificationMaster, notificationsRequest);
			notificationUtil.sendNotificationToDevice(notificationsRequest);
		} catch (Exception e) {
			logger.error(Constants.EXCEPTION);
		}
	}
}

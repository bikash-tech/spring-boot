package in.utrust.notification;

import static com.jayway.restassured.RestAssured.given;

import java.util.Arrays;
import java.util.Date;

import javax.transaction.Transactional;

import org.json.simple.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import com.jayway.restassured.http.ContentType;
import com.jayway.restassured.response.Response;

import in.utrust.constants.Constants;
import in.utrust.model.Customer;
import in.utrust.model.Enquiry;
import in.utrust.model.Make;
import in.utrust.model.Model;
import in.utrust.model.NotificationList;
import in.utrust.model.NotificationMaster;
import in.utrust.model.User;
import in.utrust.model.UserDevice;
import in.utrust.model.Vehicle;
import in.utrust.repository.NotificationListRepository;
import in.utrust.repository.NotificationMasterRepository;
import in.utrust.repository.UserRepository;
import in.utrust.request.NegotiationRequest;

@Component
public class NotificationUtil {
	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Value("${fcm_auth_key}")
	private String fcmAuthKey;

	@Value("${fcm_api_url}")
	private String fcmApiUrl;

	@Autowired
	private NotificationListRepository notificationListRepository;
	
	@Autowired
	private NotificationMasterRepository notificationMasterRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	@SuppressWarnings("unchecked")
	public void sendNotificationToDevice(NotificationsRequest notificationsRequest) {
		JSONObject data = null, requestJson = null;
		try {
			
			logger.info("notificationsRequest  :" +notificationsRequest);
			if (notificationsRequest != null) {
				data = new JSONObject();
				data.put("title", notificationsRequest.getTitle());
				data.put("body", notificationsRequest.getBody());
				data.put("notificationType", notificationsRequest.getType());
				data.put("actionItems", notificationsRequest.getActionItems());
				requestJson = new JSONObject();
				requestJson.put("to", notificationsRequest.getDeviceToken().trim());
				requestJson.put("data", data);
				// requestJson.put("notification", data);
			}

			Response response = given().headers("Authorization", "key=" + fcmAuthKey).contentType(ContentType.JSON).body(requestJson).when().post(fcmApiUrl);
			logger.info("SEND NOTIFICATION TO DEVICE.!!!!!!!!!!!!!!!!!!!!!!!!!!  Response from  FCM  :"  +response.asString());

		} catch (Exception e) {
			logger.error(Constants.EXCEPTION,e);
			throw e;
 		}
	}

	/**
	 * Send push notification to respected user based on uctdmsId.
	 * 
	 * @author BIKASH
	 * 
	 * @param uctdmsId
	 * @param eventName
	 * @param deviceToken
	 * @param enquiry
	 * @param negotiationRequest
	 */
	@Transactional
	public void sendNotification(Integer fromUser, Integer toUser, String eventName, UserDevice userDevice,
			Enquiry enquiry, NegotiationRequest negotiationRequest, String status) {
		NotificationMaster notificationMaster = notificationMasterRepository.getNotificationByEvent(eventName);
		if (notificationMaster != null && userDevice != null) {
			String notificationBody = notificationMaster.getBody();
			String updatedNotificationBody = getNotificationBody(toUser, notificationBody, enquiry, negotiationRequest);

			NotificationsRequest notificationsRequest = new NotificationsRequest();
			notificationsRequest.setBody(updatedNotificationBody);

			// To do once device token setup is ready remove below if condition
			notificationsRequest.setDeviceToken(userDevice.getDeviceToken());
			notificationsRequest.setEventName(notificationMaster.getEventName());
			notificationsRequest.setTitle(notificationMaster.getTitle());
			notificationsRequest.setType(notificationMaster.getType());

			if (notificationMaster.getActionItems() != null)
				notificationsRequest.setActionItems(Arrays.asList(notificationMaster.getActionItems().split(",")));

			// to do for WEB
			if (!(Constants.WEB.equals(userDevice.getPlatform()))) {
				sendNotificationToDevice(notificationsRequest);
			}

			// save to notification-list table
			NotificationList notificationList = new NotificationList();
			notificationList.setCreatedAt(new Date());
			notificationList.setNotificationMaster(notificationMaster);
			notificationList.setNotificationMsg(updatedNotificationBody);
			notificationList.setFromUser(fromUser);
			notificationList.setToUser(toUser);
			notificationList.setStatus(status);
			if (enquiry != null)
				notificationList.setEnquiryNumber(enquiry.getEnquiryNumber());
			notificationListRepository.save(notificationList);
			logger.info("ResponseNotification saved into NotificationList table successfully");
		} else {
			logger.info("ResponseNotification not saved ");
		}
	}

	
	/**
	 * replacing enquiry_number,make.model,offer price etc to it's original value
	 * @param notificationBody
	 * @param object
	 * @return updatedString
	 */
	private String getNotificationBody(Integer uctdmsId, String notificationBody, Enquiry enquiry, NegotiationRequest negotiationRequest) {
		String regNumber=null;
		Vehicle vehicle=null;
		Make make=null;
		Model model=null;
		Customer customer = null;
		Integer year=null;
		User user = null;
		try {
			if(enquiry!=null) {
				vehicle=enquiry.getVehicle();
				customer = enquiry.getCustomer();
				if(vehicle!=null) {
					make=vehicle.getMake();
					model=vehicle.getModel();
					year=vehicle.getYear();
					regNumber=vehicle.getRegistrationNumber();
				}
				//User list by uctdmsId
				user= userRepository.getUserDetails(uctdmsId);
				
				if (notificationBody.contains(Constants.MAKE) && notificationBody.contains(Constants.MODEL) && notificationBody.contains(Constants.YEAR) && notificationBody.contains(Constants.CUSTOMER_NAME) && notificationBody.contains(Constants.MOBILE_NUMBER)) {
					notificationBody = notificationBody.replace(Constants.MAKE,make.getName());
					notificationBody = notificationBody.replace(Constants.MODEL,model.getName());
					notificationBody = notificationBody.replace(Constants.YEAR,year.toString());
					notificationBody = notificationBody.replace(Constants.CUSTOMER_NAME,customer.getFirstName()+" "+customer.getLastName());
					notificationBody = notificationBody.replace(Constants.MOBILE_NUMBER,customer.getMobileNumber());
					return notificationBody;
				}
				else if (notificationBody.contains(Constants.ENQUIRY_NUMBER)) {
					notificationBody = notificationBody.replace(Constants.ENQUIRY_NUMBER, enquiry.getEnquiryNumber());
					if (notificationBody.contains(Constants.MAKE) && notificationBody.contains(Constants.MODEL)
							&& notificationBody.contains(Constants.YEAR) && notificationBody.contains(Constants.REG_NUMBER)) {

						notificationBody = notificationBody.replace(Constants.MAKE, make.getName());
						notificationBody = notificationBody.replace(Constants.MODEL, model.getName());
						notificationBody = notificationBody.replace(Constants.YEAR, year.toString());
						notificationBody = notificationBody.replace(Constants.REG_NUMBER, regNumber);

						if (notificationBody.contains(Constants.DROP_REASON) && notificationBody.contains(Constants.DROP_REMARK)) {
							notificationBody = notificationBody.replace(Constants.DROP_REASON, enquiry.getDropReason());
							notificationBody = notificationBody.replace(Constants.DROP_REMARK, enquiry.getDropRemark());
							return notificationBody;
						}
						else if (notificationBody.contains(Constants.OFFER_PRICE) && notificationBody.contains(Constants.ACTUAL_PRICE)) {
							notificationBody = notificationBody.replace(Constants.OFFER_PRICE, negotiationRequest.getLatestOfferPrice().toString());
							notificationBody = notificationBody.replace(Constants.ACTUAL_PRICE,negotiationRequest.getLatestExpectedPrice().toString());
							return notificationBody;
						}
						else if (user !=null && notificationBody.contains(Constants.PO_NAME) && notificationBody.contains(Constants.INITIAL_OFFER_PRICE)) {
							notificationBody = notificationBody.replace(Constants.PO_NAME, user.getFirstName()+" "+user.getLastName());
							notificationBody = notificationBody.replace(Constants.INITIAL_OFFER_PRICE, enquiry.getActualPrice().toString());
							return notificationBody;
						}
						else if (user !=null && notificationBody.contains(Constants.PO_NAME) && notificationBody.contains(Constants.PREVIOUS_OFFER_PRICE)  && notificationBody.contains(Constants.OFFER_PRICE)) {
							notificationBody = notificationBody.replace(Constants.PO_NAME, user.getFirstName()+" "+user.getLastName());
							notificationBody = notificationBody.replace(Constants.PREVIOUS_OFFER_PRICE, enquiry.getActualPrice().toString());
							notificationBody = notificationBody.replace(Constants.OFFER_PRICE, negotiationRequest.getLatestOfferPrice().toString());
							return notificationBody;
						}
						else if (user !=null && notificationBody.contains(Constants.PO_NAME) && notificationBody.contains(Constants.EXPECTED_PRICE) && notificationBody.contains(Constants.PRICE_DIFFERENCE) && notificationBody.contains(Constants.OFFER_PRICE)) {
							Double priceDiff=negotiationRequest.getLatestExpectedPrice()-negotiationRequest.getLatestOfferPrice(); //to do
							notificationBody = notificationBody.replace(Constants.PO_NAME, user.getFirstName()+" "+user.getLastName());
							notificationBody = notificationBody.replace(Constants.PRICE_DIFFERENCE, String.format("%.2f", priceDiff).toString()+" Lakhs");
							notificationBody = notificationBody.replace(Constants.OFFER_PRICE, negotiationRequest.getLatestOfferPrice().toString());
							notificationBody = notificationBody.replace(Constants.EXPECTED_PRICE,negotiationRequest.getLatestExpectedPrice().toString());
							return notificationBody;
						}
						else if (notificationBody.contains(Constants.OFFER_PRICE)){
							notificationBody = notificationBody.replace(Constants.OFFER_PRICE, negotiationRequest.getLatestOfferPrice().toString());
							return notificationBody;
						}
						return notificationBody;
					}
					return notificationBody;
				}
				else if(notificationBody.contains( Constants.MOBILE_NUMBER) && notificationBody.contains(Constants.ALTERNATE_NUMBER) && notificationBody.contains(Constants.CUSTOMER_NAME) ) {
					notificationBody = notificationBody.replace(Constants.MOBILE_NUMBER,customer.getMobileNumber());
					notificationBody = notificationBody.replace(Constants.ALTERNATE_NUMBER,customer.getAlternateMobileNumber()); 
					notificationBody = notificationBody.replace(Constants.CUSTOMER_NAME,customer.getFirstName()+" "+customer.getLastName()); 
					return notificationBody;
				}
				else if(notificationBody.contains(Constants.CUSTOMER_NAME) && notificationBody.contains(Constants.REG_NUMBER)) {
					notificationBody = notificationBody.replace(Constants.CUSTOMER_NAME,customer.getFirstName()+" "+customer.getLastName());
					notificationBody = notificationBody.replace(Constants.REG_NUMBER, regNumber);
					return notificationBody;
				}
				return notificationBody;
			}
			return notificationBody;
		}
		catch(Exception e) {
			logger.error(Constants.EXCEPTION);
			return null;
		}
	}

}

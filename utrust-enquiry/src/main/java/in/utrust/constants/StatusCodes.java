package in.utrust.constants;

/**
 * @author RamPrasad
 *
 */
public enum StatusCodes {
	ENQUIRY_SAVE_SUCCESS(2000, "Enquiry #enqNum generated successfully"), 
	ENQUIRY_UPDATE_SUCCESS(2000, "Enquiry #enqNum updated successfully"), 
	ENQUIRY_SAVE_FAIL(-2000, "Couldn't save enquiry"),

	GET_ENQUIRY_DATA_SUCCESS(2001, "Enquiry data retrieved successfully"),
	GET_ENQUIRY_DATA_FAIL(-2001, "Enquiry data not found"),

	MODEL_DATA_SUCCESS(2002, "Model data retrieved successfully"), MODEL_DATA_FAIL(-2002, "Model data not found"),

	VARIANT_DATA_SUCCESS(2004, "Variant data retrieved successfully"),
	VARIANT_DATA_FAIL(-2004, "Variant data not found"),

	ENQUIRY_DROP_REQUEST_SUCCESS(2005, "Enquiry drop request added successfully"),
	ENQUIRY_DROP_REQUEST_FAIL(-2005, "Couldn't drop enquiry request"),

	ENQUIRY_DROP_SUCCESS(2005, "Enquiry dropped successfully"), 
	ENQUIRY_DROP_REJECT(2005, "Enquiry drop request rejected"), 
	ENQUIRY_DROP_FAIL(-2005, "Couldn't drop enquiry"),

	ENQUIRY_ASSIGN_SUCCESS(2007, "Assign enquiry successfully"),
	ENQUIRY_ASSIGN_NOTFOUND(-2007, "EnquiryNumber not found"), ENQUIRY_ASSIGN_FAIL(-2008, "Couldn't Assign enquiry"),

	FOLLOW_UP_RETRIEVE_SUCCESS(2008, "Followup data retrieved successfully"),
	FOLLOW_UP_RETRIEVE_FAIL(-2008, "Couldn't retrieve followup"),

	TEMPORARY_REGISTRATION_NUMBER_SUCCESS(2009, "temporary registration number created successfully"),
	TEMPORARY_REGISTRATION_NUMBER_FAIL(-2009, "Couldn't create temporary registration number"),

	USER_FOLLOW_UP_RETRIEVE_SUCCESS(2010, "Followup data retrieved successfully"),
	USER_FOLLOW_UP_RETRIEVE_FAIL(-2010, "Couldn't retrieve followup"),

	ENQUIRY_SEARCH_SUCCESS(2011, "Search results fetched succesfully"),
	ENQUIRY_SEARCH_FAIL(-2011, "Couldn't fetch search results"),

	UPDATE_NEW_ENQUIRY_NUMBER_SUCCESS(2012, "new car enquiry number updated successfully"),
	UPDATE_NEW_ENQUIRY_NUMBER_FAIL(-2012, "Couldn't update new car enquiry number"),

	STOCK_ENQUIRY_DATA_SUCCESS(2013, "Stock data retrieved successfully"),
	STOCK_ENQUIRY_DATA_FAIL(-2013, "Stock data not found"),

	ENQUIRY_LIST_RETRIEVE_SUCCESS(2014, "EnquiryList data retrieved successfully"),
	ENQUIRY_LIST_RETRIEVE_FAIL(-2014, "Couldn't retrieve EnquiryList"),

	PRICING_DATA_RETRIEVE_SUCCESS(2015, "Pricing data retrieved successfully"),
	PRICING_DATA_RETRIEVE_FAIL(-2015, "Couldn't retrieve pricing data"),

	NEW_CAR_ENQUIRY_SUCCESS(2016, "New Car data retrived succesfully"),
	NEW_CAR_ENQUIRY_FAIL(-2016, "Couldn't retrieve New Car data"),

	BUYER_ENQUIRY_LINKED_SUCCESS(2017, "Buyer enquiry linked successfully"),
	BUYER_ENQUIRY_LINKED_FAIL(-2017, "Couldn't link buyer enquiry"),

	NEGOTIATION_HISTORY_RETRIEVE_SUCCESS(2018, "Negotiation history data retrieved successfully"),
	NEGOTIATION_HISTORY_RETRIEVE_FAIL(-2018, "Couldn't retrieve Negotiation history"),
	NEGOTIATION_HISTORY_ROLE_FAIL(-2018, "User should be PO or PTL"),

	ENQUIRY_TIMELINE_DATA_RETRIEVE_SUCCESS(2019, "Enquiry timeline data retrieved successfully"),
	ENQUIRY_TIMELINE_DATA_RETRIEVE_FAIL(-2019, "Enquiry timeline data not found"),

	CHART_DATA_RETRIEVE_SUCCESS(2019, "Chart data retrieved successfully"),
	CHART_DATA_RETRIEVE_FAIL(-2019, "Couldn't retrieve Chart data"),
	CHART_DATA_NOT_AVAILABLE(-2019, "chart data not found"),

	PROCUREMENT_CHECKLIST_SUCCESS(2020, "Procurement checklist data retrieved successfully"),
	PROCUREMENT_CHECKLIST_FAIL(-2020, "Couldn't retrieve procurement checklist data"),

	PARALLEL_ENQUIRY_DATA_RETRIEVE_SUCCESS(2021, "Parallel enquiry retrieved successfully"),
	PARALLEL_ENQUIRY_DATA_RETRIEVE_FAIL(-2021, "Couldn't retrieve parallel enquiry"),
	
	PROCUREMENT_CHECKLIST_SAVE_SUCCESS(2022, "Procurement checklist saved successfully"),
	PROCUREMENT_CHECKLIST_SAVE_FAIL(-2022, "Couldn't save procurement checklist data"),

	IMAGE_UPLOAD_SUCCUESS(2023,"Document uploaded succesfsully"), 
	IMAGE_UPLOAD_FAIL(-2023,"Couldn't upload document"),
	
	PROCUREMENT_CHECKLIST_MAP_SUCCESS(2024,"Procurement document mapped succesfsully"), 
	PROCUREMENT_CHECKLIST_MAP_FAIL(-2024,"Couldn't map procurement document"),
	
	NOTIFICATION_LIST_SUCCESS(2025,"Notification list retrieved successfully"), 
	NOTIFICATION_LIST_FAIL(-2025,"Couldn't retrieve notification list"),
	
	OFFER_PRICE_APPROVED(2026,"Offer price approved"), 
	OFFER_PRICE_SUGGESTED_BY_PTL(2027,"Offer price suggested by PTL"), 
	OFFER_PRICE_REJECTED(-2026,"Offer price rejected"),
	
	INITIAL_OFFER_APPROVED(2028,"Initial Offer price Request Approved"),
	INITIAL_OFFER_REJECTED(2028,"Initial Offer price Request Rejected"),
	
	NEW_CAR_SELLEER_ENQ_ACCEPTED(2028,"New car Trade_in Seller Enquiry Request Accepted"),
	NEW_CAR_SELLEER_ENQ_REJECTED(-2028,"New car Trade_in Seller Enquiry Request Rejected"),
	
	NEW_CAR_SELLER_ENQ_ALLOCATION_ACCEPTED(2035,"New car Trade_in Allotion to  PO Accepted"),
	NEW_CAR_SELLER_ENQ_ALLOCATION_REJECTED(-2035,"New car Trade_in Allotion to  PO Rejected"),
	
	APPROVAL_REQUEST_FAIL(-3007,"No action performed"),

	SEEN_NOTIFICATION_SUCCESS(2030,"notification seen successfully"),
	SEEN_NOTIFICATION_FAIL(-2031,"Couldn't see notification"),
	
	UCTDMS_ID_NOT_FOUND(-2029,"uctdmsId not found"), 
	
	COLLECETD_VEHICLE_SUCCESS(2028,"Collected vehicles retrieved successfully"), 
	COLLECETD_VEHICLE_FAIL(-2028,"Couldn't retrieve collected vehicles"),
	
	PURCHASED_VEHICLE_SUCCESS(2029,"Purchased vehicles retrieved successfully"), 
	PURCHASED_VEHICLE_FAIL(-2029,"Couldn't retrieve purchased vehicles"),
	
	PENDING_DOCUMENTS_SUCCESS(2029,"Pending documents retrieved successfully"), 
	PENDING_DOCUMENTS_FAIL(-2029,"Couldn't retrieve pending documents"),
	
	SIGNOFF_SUCCESS(2040, "Enquiry Signed off successfully"),
	SIGNOFF_SAVE_FAIL(-2040, "Couldn't sign off enquiry"),
	UCTDMS_ID_NOT_EXISTS(-2041,"uctdmsId does not exist"), 
	

	FETCH_SUBORDINATES_SUCCESS(2042,"Subordinate details fecthing successfully"),
	FETCH_SUBORDINATES_FAIL(-2042,"Couldn't fetch subordinate details"),
	
	OTP_SENT_SUCCESS(2043,"Otp sent successfully"),
	OTP_SENT_FAIL(-2043,"Couldn't send otp"),

	NO_MOBILE_NUMBER_EXISTS(-2044,"Mobile number doesn't exists"),
 	
	OTP_VERIFY_SUCCESS(2045,"Otp verified successfully"),
	OTP_VERIFY_FAIL(-2045,"Couldn't verify otp"),

	ALTERNATE_NUMBER_APPROVE_SUCCESS(2048,"Alternate number approved successfully"),
	ALTERNATE_NUMBER_APPROVE_REJECT(-2048,"Alternate number approval rejected"),

	ALTERNATE_NUMBER_OTP_REQUEST_SUCCESS(2049,"Alternate number request raised successfully"),
	ALTERNATE_NUMBER_NOT_PRESENT(-2049,"Please enter alternate number and mobile number"),
	ALTERNATE_NUMBER_OTP_REQUEST_FAIL(-2050,"Couldn't request raised for alternate number"),

	CUSTOMER_NOT_EXIST(-2051,"Customer does't exist"),

	OTP_DOES_NOT_MATCH(-2046,"Otp does not match"),
	OTP_EXPIRED(-2057,"OTP expired"),
	NO_OTP_ACTION(-2058,"No OTP action performed"),
	USEROTP_RECORD_NOT_FOUND(-2059,"UserOTP record not found"),
	
	INVALID_ENQUIRY_STATUS(-2047,"Invalid input for enquiryStatus, please enter either Hot or Prospect"),

	VALUATION_MASTER_SUCCESS(2052,"Valuation master data fetching successfully"),
	VALUATION_MASTER_FAIL(-2052,"Couldn't fetch valuation master data"),

	NOTOFICATION_NOT_FOUND(-2053,"Couldn't fetch notificationList data"),
	
	NO_ENQUIRY_EDIT_ACCESS(-2054,"You do not have edit permission"),
	NO_ACTION_AVAILABLE(-2055,"No action request available"),

	ALTERNATE_MOBILE_APPROVAL(2055,"Notification sent to PTL for alternate mobile approval"),
	MISMATCH_ENQURY_AND_MOBILE(-2056,"There is a mismatch in enquiry and mobileNumber"),

	
	ENQUIRY_NOT_FOUND(-3006, "Enquiry not found");

	private final int statusCode;
	private final String message;
	private String enqString;

	public String getEnqString() {
		return enqString;
	}

	public void setEnqString(String enqString) {
		this.enqString = enqString;
	}

	private StatusCodes(int statusCode, String message) {
		this.statusCode = statusCode;
		this.message = message;
	}

	public int getStatusCode() {
		return statusCode;
	}

	public String getMessage() {
		return message;
	}

}

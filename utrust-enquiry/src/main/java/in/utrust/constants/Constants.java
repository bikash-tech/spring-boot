package in.utrust.constants;

public class Constants {
	public final static String EXCEPTION = "Exception :";

	public final static String UCTDMS_ID = "uctdmsId";
	public final static String ENQUIRY = "ENQ_";
	public final static String PURCHASE = "PR_";
	public final static String PURCHASE_NUMBER = "purchaseNumber";
	public final static String ALTERNATE_MOBILE_NUMBER = "alternateMobileNumber";
	public final static String TEMPORARY_REG_NUMBER = "temp_reg_number";
	public final static String CREATED = "Created";
	public final static String DROPPED = "Dropped";
	public final static String FOLLOW_UP = "FollowUp";
	public final static String DONE = "Done";
	public final static String MISSED = "Missed";
	public final static String PLAN = "Plan";
	public final static String TKM = "TKM";
	public final static String INITIAL_NUMBER = "0001";
	public final static String PURCHASE_INITIAL_NUMBER = "2000";
	public final static String SELLER_ENQUIRY_CATEGORY = "Seller";
	public final static String IOS = "IOS";
	public final static String ANDROID = "Android";
	public final static String WEB = "WEB";
	public final static String TIMELINE_ENQUIRY_CREATED = "Enquiry Created";
	public final static String TIMELINE_ENQUIRY_UPDATED = "Enquiry Updated";
	public final static String TIMELINE_ENQUIRY_DROPPED = "Enquiry Dropped";
	public final static String TIMELINE_FOLLOWUP_CREATED = "Follow Up Created";
	public final static String GOOGLE_IMAGE_URL = "https://blog.toyota.co.uk/wp-content/uploads/2014/02/general-feature.jpg";
	public final static String PARALLEL_ENQUIRY="PARALLEL_ENQUIRY";
	public final static String NEW_CAR_TRADE_IN="New Car Trade In";

	public final static String EVENT_DROP_ENQUIRY="Seller Enquiry Drop Request";
	public final static String EVENT_NEW_SELLER_ENQUIRY="New Seller Enquiry Created";
	public final static String EVENT_NEW_SELLER_ENQUIRY_ACCEPTED="New Seller Enquiry Accepted";
	public final static String EVENT_NEW_SELLER_ENQUIRY_REJECTED="New Seller Enquiry Rejected";
	public final static String EVENT_ALLOCATION_PO="Seller Enquiry Allocation to PO";
	public final static String EVENT_ALLOCATION_PO_ACCEPTED="Seller Enquiry Allocation to PO Accepted";
	public final static String EVENT_ALLOCATION_PO_REJECTED="Seller Enquiry Allocation to PO Rejected";
	public final static String EVENT_SELLER_ENQ_ALLOCATION_PO="Seller Enquiry Allocation";
	public final static String EVENT_ENQUIRY_DROP_APPROVED="Seller Enquiry Drop Approved";
	public final static String EVENT_ENQUIRY_DROP_REJECTED="Seller Enquiry Drop Rejected";
	public final static String EVENT_INITIAL_OFFER_PRICE_APPROVAL_FROM_PO="Initial Offer price Approval – From PO";
	public final static String EVENT_INITIAL_OFFER_PRICE_APPROVED="Initial Offer price Approved";
	public final static String EVENT_INITIAL_OFFER_PRICE_REJECTED="Initial Offer price Rejected";
	public final static String EVENT_OFFER_PRICE_APPROVAL_FROM_PO="Offer price Approval –From PO";
	public final static String EVENT_DUPLICATE_PARALLEL_ENQUIRY="Duplicate – Parallel Enquiry in system";
	public final static String EVENT_OFFER_PRICE_APPROVED="Offer Price Approved by PTL";
	public final static String EVENT_OFFER_PRICE_REJECTED="Offer Price Rejected by PTL";
	public final static String EVENT_OFFER_PRICE_SUGGESTED="Offer Price Suggested by PTL";
	public final static String EVENT_ENQUIRY_FOLLOWUP_PTL_REMARK="Seller Enquiry Follow-up – PTL Remark added.";
	public final static String EVENT_PRICE_DIFFERENCE="Price difference is less or equal to 50,000";
	public final static String EVENT_VEHICLE_COLLECTION_CONFIRMED="Vehicle Collection Confirmed";
	public final static String EVENT_ALTERNATE_NUMBER_APPROVAL_REQUEST="Alternate Number Approval Request";
	public final static String EVENT_ALTERNATE_NUMBER_APPROVED="Alternate Number Approved";
	public final static String EVENT_ALTERNATE_NUMBER_REJECTED="Alternate Number Rejected";
	public final static String EVENT_TARGET_DATE_REMAINDER="Target Date reminders (1 day before target date – 4:00 P.M.)";
	public final static String EVENT_ENQUIRY_FOLLOWUP_REMAINDER="Seller Enquiry Follow-Up Schedule";
	public final static String EVENT_DUPLICATE_ENQUIRY_SYSTEM="Duplicate – Parallel Enquiry in system";
	
	public final static String SUCCESS="Success";
	public final static Integer TWO_DAYS_DIFFERENCE=2880;
	public final static String DOCUMENT_CATEGORY_PROCUREMENT="Procurement";
	
	public final static String ENQUIRY_NUMBER="#enq_number";
	public final static String MAKE="#make";
	public final static String MODEL="#model";
	public final static String YEAR="#year";
	public final static String REG_NUMBER="#reg_number";
	public final static String PO_NAME="#po_name";
	public final static String OFFER_PRICE="#offer_price";
	public final static String ACTUAL_PRICE="#actual_price";
	public final static String EXPECTED_PRICE="#expected_price";
	public final static String PREVIOUS_OFFER_PRICE="#previous_offer_price";
	public final static String INITIAL_OFFER_PRICE="#initial_offer_price";
	public final static String PRICE_DIFFERENCE="#price_difference";
	public final static String DROP_REMARK="#drop_remarks";
	public final static String DROP_REASON="#drop_reason";
	public final static String MOBILE_NUMBER="#mobile_number";
	public final static String ALTERNATE_NUMBER="#alternate_number";
	public final static String CUSTOMER_NAME="#customer_name";

	public final static String LOG_IN_PROCEDURE="utrust_log_in_pro";
	public static final int PO_ROLE = 1;
	public static final int PTL_ROLE = 2;
	public static final int UCM_ROLE = 3;
	public static final int SO_ROLE = 4;
	public static final int STL_ROLE = 5;
	
	public static final String ACTION_DONE = "Action Done";
	public static final String ACCEPTED = "Accepted";
	public static final String REJECTED = "Rejected";
	public static final String APPROVED = "Approved";
	public static final String APPROVE_ACTION = "Approve";
	public static final String SUGGESTED = "Suggested";
	public static final int SIGNOFF_DOC_ID = 22;
	public static final int PURCHASED_ID = 1;
	public static final int COLLECTED_ID = 2;
	public static final int VEHICLE_SOLD = 6;
	public static final int VEHICLE_PURCHASED = 1;

	public static final String OTP = "#otp_code";
	public static final String DEALER_NAME = "#dealer_name";
	public static final String DEALER_LOCATION = "#dealer_location";
	
	public static final int OTP_CONFIRM_PURCHASE = 1;
	public static final int OTP_VERIFY_MOBILE_NUMBER = 10;
	public static final int OTP_COMPLETE_VALUATION = 3;
	
	
	public static final int SMS_CONTENT_VALUATION = 5;

	public static final Integer INSURANCE_THIRD_PARTY = 2;
	public static final Integer INSURANCE_COMPREHENSIVE= 3;

	public static final int ASSIGNED_BY_UCTDMS  =  3;

	public static final String BUYER = "Buyer";
	
	public static final int CREATED_ID = 0;
	public static final int FOLLOWUP_ID = 1;
	public static final int DROP_ID = 2;
	public static final int SUCCESS_ID = 3;
	
	public static final String SELLER_BASE_URL = "/api/v1/seller";




}
package in.utrust.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import in.utrust.constants.Constants;
import in.utrust.request.ApprovedRequest;
import in.utrust.request.BasicDetailsRequest;
import in.utrust.request.ChartDataRequest;
import in.utrust.request.CollectedVehiclesRequest;
import in.utrust.request.DropEnquiryRequest;
import in.utrust.request.EnquiryAssignRequest;
import in.utrust.request.EnquiryRequest;
import in.utrust.request.MapCheckListRequest;
import in.utrust.request.NewCarLinkRequest;
import in.utrust.request.OtpRequest;
import in.utrust.request.PricingChartDataRequest;
import in.utrust.request.ProcurementChecklistAllRequests;
import in.utrust.request.ProcurementSignOffRequest;
import in.utrust.request.SearchEnquiryRequest;
import in.utrust.request.SeenNotificationRequest;
import in.utrust.request.VehicleRequest;
import in.utrust.response.UtrustResponse;
import in.utrust.service.EnquiryService;

/**
 * @author RamPrasad
 *
 */
@RestController
@RequestMapping(Constants.SELLER_BASE_URL)
public class SellerEnquiryController { 

	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	EnquiryService enquiryService;
	
	@Value("${fcm_auth_key}")
	private String fcmAuthKey;

	@Value("${fcm_api_url}")
	private String fcmApiUrl;


	@PostMapping("/enquiry")
	public UtrustResponse saveEnquiry(@RequestBody EnquiryRequest enquiryRequest, HttpServletRequest request) throws JsonProcessingException {
		logger.info("Inside saveEnquiry :" + enquiryRequest);
		
        ObjectMapper Obj = new ObjectMapper(); 
        
        String jsonStr = Obj.writeValueAsString(enquiryRequest); 
        
        System.out.println(jsonStr);

 		return enquiryService.saveEnquiryDetals(enquiryRequest, request);
	}

	@PostMapping("/drop-request")
	public UtrustResponse dropEnquiry(@RequestBody DropEnquiryRequest dropEnquiryRequest,HttpServletRequest request) {
		logger.info("Inside dropEnquiry :" + dropEnquiryRequest);
		return enquiryService.dropEnquiry(dropEnquiryRequest, request);
	}

	@PostMapping("/drop-enquiry")
	public UtrustResponse acceptDropRequest(@RequestBody DropEnquiryRequest dropEnquiryRequest, HttpServletRequest request) {
		logger.info("Inside dropEnquiry :" + dropEnquiryRequest);
		return enquiryService.acceptDropRequest_backedUp(dropEnquiryRequest,request);
	}

	@GetMapping("/enquiry/{enquiryNumber}")
	public UtrustResponse getEnquiry(@PathVariable("enquiryNumber") String enquiryNumber, HttpServletRequest request) {
		logger.info("Inside getEnquiry with enquiryNumber: " + enquiryNumber);
		return enquiryService.getEnquiryDetails(enquiryNumber,request);
	}

	@PostMapping("/assign-enquery")
	public UtrustResponse assignEnquiery(HttpServletRequest request,
			@RequestBody EnquiryAssignRequest enquiryAssignRequest) {
		logger.info("Enter into  EnquiryAssignController with value uctdmsId:" + request + ":enquiryAssignRequest:"
				+ enquiryAssignRequest);

		return enquiryService.assignEnquiry(enquiryAssignRequest, request);
	}

	@GetMapping("/follow-up/{enquiryNumber}")
	public UtrustResponse getFollowUp(@PathVariable("enquiryNumber") String enquiryNumber, HttpServletRequest request) {
		logger.info("Inside getFollowUp with enquiryNumber: " + enquiryNumber);
		return enquiryService.getFollowUpDetailsByEnquiryNumber(enquiryNumber,request);
	}

	@PostMapping("/search-enquiry")
	public UtrustResponse searchEnquiry(@RequestBody SearchEnquiryRequest enquiryRequest, HttpServletRequest request) {
		logger.info("Inside getFollowUp with enquiryNumber: " + enquiryRequest);
		return enquiryService.searchEnquiry(enquiryRequest,request);
	}

	@GetMapping("/temp-registration-number")
	public UtrustResponse getTemporaryRegistrationNumber(HttpServletRequest request) {
		logger.info("Inside getTemporaryRegistrationNumber");
		return enquiryService.getTemporaryRegistrationNumber(request);
	}

	@GetMapping("/user-followup/{poId}")
	public UtrustResponse getUserFollowUp(@PathVariable("poId") Integer poId, HttpServletRequest request) {
		logger.info("Inside getUserFollowUp with poId: " + poId);
		return enquiryService.getUserFollowUpDetailsByPO(poId,request);
	}

	@PutMapping("/new-car-link")
	public UtrustResponse saveNewCarLink(@RequestBody NewCarLinkRequest newCarRequest, HttpServletRequest request) {
		logger.info("Inside saveNewCarLink with new enquiry number : " + newCarRequest.getNewCarEnquiryNumber());
		return enquiryService.saveNewCarLink(newCarRequest,request);
	}

	@GetMapping("/enquiry-list")
	public UtrustResponse getEnquiryListByPoId(HttpServletRequest request) {
		logger.info("Logged In user :"+request);
		return enquiryService.getEnquiryListByUser(request);

	}
	
	@PostMapping("/chart-data")
	public UtrustResponse getChartData(@RequestBody ChartDataRequest chartDataRequest, HttpServletRequest request) {
		logger.info("Inside parallelEnquiry with chartDataRequest: " + chartDataRequest);
		return enquiryService.getChartData(chartDataRequest, request);
	}
	
	@PostMapping("/pricingData")
	public UtrustResponse pricingData(HttpServletRequest request,
			@RequestBody VehicleRequest vehicleRequest) {
		logger.info("Enter into  pricingData with value uctdmsId:" + request + ":pricingData:" + vehicleRequest);
		return enquiryService.pricingData(vehicleRequest, request);

	}

	@PostMapping("/pricing-chart-Data")
	public UtrustResponse pricingAndChartData(HttpServletRequest request,
			@RequestBody PricingChartDataRequest pricingChartDataRequest) {
		logger.info("Inside pricingData with pricingChartDataRequest: " + pricingChartDataRequest);
		return enquiryService.getPricingChartData(pricingChartDataRequest, request);
		
	}

	@GetMapping("/negotiation-history/{enquiryNumber}")
	public UtrustResponse getNegotionHistory(@PathVariable("enquiryNumber") String enquiryNumber, HttpServletRequest request) {
		logger.info("Inside getNegotionHistory with enquiryNumber: " + enquiryNumber);
		return enquiryService.getNegotionHistory(enquiryNumber,request);
	}

	@GetMapping("/enquiry-timeline/{enquiryNumber}")
	public UtrustResponse getEnquiryTimeline(@PathVariable("enquiryNumber") String enquiryNumber,
			HttpServletRequest request) {
		logger.info("Inside getEnquiryTimeline with enquiry: " + enquiryNumber);
		return enquiryService.getEnquiryTimelineDetails(enquiryNumber, request);
	}

	@GetMapping("/procurement-checklist/{enquiryNumber}")
	public UtrustResponse getProcurementChecklistByEnqNo(@PathVariable("enquiryNumber") String enquiryNumber,
			HttpServletRequest request) {
		logger.info(
				"Inside SellerEnquiryController getProcurementChecklistByEnqNo with enquiry number: " + enquiryNumber);
		return enquiryService.getCheckListDataByEnqNo(enquiryNumber, request);
	}
	
	@PostMapping("/save-procurement-checklist")
	public UtrustResponse saveProcurementChecklistData(
			@RequestBody ProcurementChecklistAllRequests procurementChecklistMappingRequest,
			HttpServletRequest request) {
		logger.info("Inside saveProcurementChecklistData with ProcurementChecklistMappingRequest: "
				+ procurementChecklistMappingRequest);
		return enquiryService.saveProcurementChecklistDetails(procurementChecklistMappingRequest, request);
	}
    
    @GetMapping("/parallel-enquiry/{registrationNumber}")
	public UtrustResponse getParallelEnquiry(@PathVariable("registrationNumber") String registrationNumber, HttpServletRequest request) {
		logger.info("Inside SellerEnquiryController getParallelEnquiry with registrationNumber: " + registrationNumber);
		return enquiryService.getParallelEnquiry(registrationNumber,request);
	}
    
    @PostMapping("document")
	public @ResponseBody UtrustResponse uploadImage(@RequestParam("file") MultipartFile file,HttpServletRequest request) throws IOException {
			return enquiryService.uploadImage(file,request);
	}
    
    @PostMapping("/map-checklist-document")
   	public @ResponseBody UtrustResponse mapChecklistDocument(@RequestBody MapCheckListRequest checkListRequest, HttpServletRequest request) throws IOException {
   			return enquiryService.mapChecklistDocument(checkListRequest, request);
   	}
    
    @PostMapping({ "/new-car-enquiry" })
	public UtrustResponse getNewCarEnquiryDetails(@RequestBody BasicDetailsRequest basicDetailsRequest,
			HttpServletRequest request) {
		logger.info("get New Car Enquiry Details By Enquiry Data");
		return enquiryService.getNewCarEnquiryDetails(basicDetailsRequest, request);
	}
    

	@GetMapping("/notification-list")
	public UtrustResponse notificationList(HttpServletRequest request) {
		logger.info(
				"Inside SellerEnquiryController notificationList");
		return enquiryService.getNotificationList(request);
	}
   
	@PostMapping("/user-response")
	public UtrustResponse responseFromUser(@RequestBody ApprovedRequest approvedRequest, HttpServletRequest request) {
		logger.info("Inside SellerEnquiryController responseFromUser ");
		return enquiryService.getResponseFromUser(approvedRequest, request);
	}

	@PostMapping("/seen-notification")
	public UtrustResponse seenNotification(@RequestBody SeenNotificationRequest seenRequest, HttpServletRequest request) {
		logger.info("Inside SellerEnquiryController seenNotification ");
		return enquiryService.seenNotification(seenRequest, request);
	}
	
	@PostMapping("/confirm-signoff")
	public UtrustResponse confirmSignoff(
			@RequestBody ProcurementSignOffRequest procurementSignOffRequest,
			HttpServletRequest request) {
		logger.info("Inside confirmSignoff with procurementSignOffRequest: "
				+ procurementSignOffRequest);
		return enquiryService.confirmSignoff(procurementSignOffRequest, request);
	}
	
	@PostMapping("/collected-vehicle")
	public UtrustResponse collectedVehicles(@RequestBody CollectedVehiclesRequest collectedVehiclesRequest,
			HttpServletRequest request) {
		logger.info("Inside SellerEnquiryController collectedVehicles with enquiry number: " + collectedVehiclesRequest);
		return enquiryService.collectedVehicles(collectedVehiclesRequest,request);
	}
	
	@PostMapping("/purchased-vehicle")
	public UtrustResponse purchasedVehicles(@RequestBody CollectedVehiclesRequest collectedVehiclesRequest,
			HttpServletRequest request) {
		logger.info("Inside SellerEnquiryController purchasedVehicles with enquiry number: " + collectedVehiclesRequest);
		return enquiryService.purchasedVehicles(collectedVehiclesRequest,request);
	}

	@GetMapping("/silent-notification")
	public UtrustResponse silentNotification(@RequestBody SeenNotificationRequest silenteenNotificationRequest,HttpServletRequest request) {
		logger.info("Inside SellerEnquiryController silentNotification with enquiry number: " + silenteenNotificationRequest);
		return enquiryService.getSilentNotification(silenteenNotificationRequest,request);
	}
	
	@PostMapping("/pending-documents")
	public UtrustResponse pendingDocumentds(@RequestBody CollectedVehiclesRequest collectedVehiclesRequest,
			HttpServletRequest request) {
		logger.info("Inside SellerEnquiryController pendingDocumentds with enquiry number: " + collectedVehiclesRequest);
		return enquiryService.pendingDocumentds(collectedVehiclesRequest,request);
	}
	@GetMapping("/subordinates")
	public UtrustResponse getSubordinates(HttpServletRequest request) {
 		return enquiryService.getSubordinates(request);
	}
	
	@PostMapping("/send-otp")
	public UtrustResponse sendOtp(@RequestBody OtpRequest otpRequest, HttpServletRequest request) {
 		return enquiryService.sendOtp(otpRequest,request);
	}
	
	@PostMapping("/verify-otp")
	public UtrustResponse verifyOtp(@RequestBody OtpRequest otpRequest, HttpServletRequest request) {
 		return enquiryService.verifyOtp(otpRequest,request);
	}
	
	
}
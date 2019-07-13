package in.utrust.service;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.multipart.MultipartFile;

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

public interface EnquiryService {
	UtrustResponse saveEnquiryDetals(EnquiryRequest enquiryRequest, HttpServletRequest request);

	UtrustResponse dropEnquiry(DropEnquiryRequest enquiryRequest, HttpServletRequest request);

	UtrustResponse getEnquiryDetails(String enquiryNumber, HttpServletRequest request);

	UtrustResponse acceptDropRequest_backedUp(DropEnquiryRequest enquiryRequest, HttpServletRequest request);

	UtrustResponse assignEnquiry(EnquiryAssignRequest enquiryAssignRequest, HttpServletRequest request);

	UtrustResponse getFollowUpDetailsByEnquiryNumber(String enquiryNumber, HttpServletRequest request);

	UtrustResponse searchEnquiry(SearchEnquiryRequest enquiryRequest, HttpServletRequest request);

	UtrustResponse getTemporaryRegistrationNumber(HttpServletRequest request);

	UtrustResponse getUserFollowUpDetailsByPO(Integer poId, HttpServletRequest request);

	UtrustResponse saveNewCarLink(NewCarLinkRequest newCarRequest, HttpServletRequest request);

	UtrustResponse getEnquiryListByUser(HttpServletRequest request);

	UtrustResponse pricingData(VehicleRequest vehicleRequest, HttpServletRequest request);

	UtrustResponse getEnquiryTimelineDetails(String enquiryNumber, HttpServletRequest request);

	UtrustResponse getNegotionHistory(String enquiryNumber, HttpServletRequest request);

	UtrustResponse getChartData(ChartDataRequest chartDataRequest, HttpServletRequest request);

	UtrustResponse getCheckListDataByEnqNo(String enquiryNumber, HttpServletRequest request);

	UtrustResponse getParallelEnquiry(String registrationNumber, HttpServletRequest request);
	
	UtrustResponse saveProcurementChecklistDetails(ProcurementChecklistAllRequests procurementChecklistMappingRequest,
			HttpServletRequest request);
	
	UtrustResponse uploadImage(MultipartFile file, HttpServletRequest request);

	UtrustResponse mapChecklistDocument(MapCheckListRequest checkListRequest, HttpServletRequest request);

	UtrustResponse getNewCarEnquiryDetails(BasicDetailsRequest BasicDetailsRequest, HttpServletRequest request);

	UtrustResponse getNotificationList(HttpServletRequest request);

	UtrustResponse getResponseFromUser(ApprovedRequest approvedRequest, HttpServletRequest request);

	UtrustResponse seenNotification(SeenNotificationRequest seenRequest, HttpServletRequest request);
	
	UtrustResponse confirmSignoff(ProcurementSignOffRequest procurementSignOffRequest,
			HttpServletRequest request);
			
	UtrustResponse collectedVehicles(CollectedVehiclesRequest collVehReq, HttpServletRequest request);

	UtrustResponse purchasedVehicles(CollectedVehiclesRequest collectedVehiclesRequest, HttpServletRequest request);

	UtrustResponse getSilentNotification(SeenNotificationRequest silenteenNotificationRequest, HttpServletRequest request);
	UtrustResponse pendingDocumentds(CollectedVehiclesRequest collectedVehiclesRequest, HttpServletRequest request);

	UtrustResponse getSubordinates(HttpServletRequest request);

	UtrustResponse sendOtp(OtpRequest otpRequest, HttpServletRequest request);

	UtrustResponse verifyOtp(OtpRequest otpRequest, HttpServletRequest request);

	UtrustResponse getPricingChartData(PricingChartDataRequest pricingChartDataRequest, HttpServletRequest request);

}

package in.utrust.service;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.math.BigInteger;
import java.net.URI;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import javax.servlet.http.HttpServletRequest;
import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.microsoft.azure.storage.CloudStorageAccount;
import com.microsoft.azure.storage.blob.CloudBlobClient;
import com.microsoft.azure.storage.blob.CloudBlobContainer;
import com.microsoft.azure.storage.blob.CloudBlockBlob;

import in.utrust.constants.Constants;
import in.utrust.constants.EnquiryStatus;
import in.utrust.constants.StatusCodes;
import in.utrust.model.CarVolume;
import in.utrust.model.CarVolume_copy;
import in.utrust.model.Channel;
import in.utrust.model.Checklist;
import in.utrust.model.ChecklistMapping;
import in.utrust.model.Customer;
import in.utrust.model.CustomerAddress;
import in.utrust.model.Dealer;
import in.utrust.model.DemandStructure;
import in.utrust.model.Enquiry;
import in.utrust.model.EnquiryTimeline;
import in.utrust.model.EnquiryType;
import in.utrust.model.ExteriorColor;
import in.utrust.model.FollowUp;
import in.utrust.model.InsuranceType;
import in.utrust.model.Make;
import in.utrust.model.Model;
import in.utrust.model.NegotiationHistory;
import in.utrust.model.NotificationList;
import in.utrust.model.PricingChartDataInfo;
import in.utrust.model.PricingData;
import in.utrust.model.PricingDataInfo;
import in.utrust.model.SellingReason;
import in.utrust.model.SimilarTransaction;
import in.utrust.model.SimilarTransaction_copy;
import in.utrust.model.SourceName;
import in.utrust.model.SourceType;
import in.utrust.model.StatusReasoning;
import in.utrust.model.TemporaryVehicle;
import in.utrust.model.User;
import in.utrust.model.UserDevice;
import in.utrust.model.UserOtp;
import in.utrust.model.Variant;
import in.utrust.model.Vehicle;
import in.utrust.model.VehicleStage;
import in.utrust.notification.NotificationUtil;
import in.utrust.repository.ChecklistMappingRepository;
import in.utrust.repository.ChecklistRepository;
import in.utrust.repository.CustomerRepository;
import in.utrust.repository.EnquiryEntityManager;
import in.utrust.repository.EnquiryRepository;
import in.utrust.repository.EnquiryTimelineRepository;
import in.utrust.repository.FollowUpRepository;
import in.utrust.repository.MasterRepository;
import in.utrust.repository.NegotiationHistoryRepository;
import in.utrust.repository.NotificationListRepository;
import in.utrust.repository.PricingDataRepository;
import in.utrust.repository.UserDeviceRepository;
import in.utrust.repository.UserEntityManager;
import in.utrust.repository.UserOtpRepository;
import in.utrust.repository.UserRepository;
import in.utrust.repository.VehicleRepository;
import in.utrust.request.ActualFollowUpRequest;
import in.utrust.request.ApprovedRequest;
import in.utrust.request.BasicDetailsRequest;
import in.utrust.request.ChartDataRequest;
import in.utrust.request.CollectedVehiclesRequest;
import in.utrust.request.CustomerAddressRequest;
import in.utrust.request.CustomerRequest;
import in.utrust.request.DropEnquiryRequest;
import in.utrust.request.EnquiryAssignRequest;
import in.utrust.request.EnquiryRequest;
import in.utrust.request.FollowUpRequest;
import in.utrust.request.MapCheckListRequest;
import in.utrust.request.NegotiationRequest;
import in.utrust.request.NewCarLinkRequest;
import in.utrust.request.NextFollowUpRequest;
import in.utrust.request.OtpRequest;
import in.utrust.request.PricingChartDataRequest;
import in.utrust.request.ProcurementChecklistAllRequests;
import in.utrust.request.ProcurementChecklistMappingRequest;
import in.utrust.request.ProcurementRequest;
import in.utrust.request.ProcurementSignOffRequest;
import in.utrust.request.SearchEnquiryRequest;
import in.utrust.request.SeenNotificationRequest;
import in.utrust.request.VehicleRequest;
import in.utrust.response.ActualFollowUpResponse;
import in.utrust.response.BasicDetailsResponse;
import in.utrust.response.CarVolumeResponse;
import in.utrust.response.ChannelResponse;
import in.utrust.response.ChartDataResponse;
import in.utrust.response.ChartDataResponse_copy;
import in.utrust.response.ChecklistMappingResponse;
import in.utrust.response.ChecklistMappingResponses;
import in.utrust.response.ChecklistResponse;
import in.utrust.response.CollectedVehicleResponse;
import in.utrust.response.CustomerAddressResponse;
import in.utrust.response.CustomerResponse;
import in.utrust.response.DemandStructureResponse;
import in.utrust.response.EnquiryDetails;
import in.utrust.response.EnquiryResponse;
import in.utrust.response.EnquiryTimelineResponse;
import in.utrust.response.EnquiryTypeResponse;
import in.utrust.response.ExteriorColorResponse;
import in.utrust.response.FollowUpEntityResponse;
import in.utrust.response.FollowUpResponse;
import in.utrust.response.InsuranceTypeResponse;
import in.utrust.response.MakeResponse;
import in.utrust.response.ModelResponse;
import in.utrust.response.NegotiationHistResponse;
import in.utrust.response.NegotiationResponse;
import in.utrust.response.NextFollowUpResponse;
import in.utrust.response.NotificationListResponse;
import in.utrust.response.PTLUserResponse;
import in.utrust.response.ParallelEnqPairResponse;
import in.utrust.response.ParallelEnquiryResponse;
import in.utrust.response.PendingDocCustResponse;
import in.utrust.response.PendingDocumentResponse;
import in.utrust.response.PriceRangeResponse;
import in.utrust.response.PricingDataResponse;
import in.utrust.response.ProcurementResponse;
import in.utrust.response.SellingReasonResponse;
import in.utrust.response.SimilarTransactionResponse;
import in.utrust.response.SourceNameResponse;
import in.utrust.response.SourceTypeResponse;
import in.utrust.response.StatusReasoningResponse;
import in.utrust.response.UserResponse;
import in.utrust.response.UtrustResponse;
import in.utrust.response.VariantResponse;
import in.utrust.response.VehicleResponse;
import in.utrust.sms.SMSUtil;

/**
 * @author RamPrasad
 *
 */
@Service("UserService")
public class EnquiryServiceImpl implements EnquiryService {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private EnquiryRepository enquiryRepository;

	@Autowired
	private MasterRepository masterRepository;

	@Autowired
	private FollowUpRepository followUpRepository;

	@Autowired
	private PricingDataRepository pricingDataRepository;

	@Autowired
	private EnquiryTimelineRepository enquiryFollowupRepository;

	@Autowired
	private	ChecklistRepository checklistRepository;

	@Autowired
	private ChecklistMappingRepository checklistMappingRepository;
 
	@Autowired 
	private NotificationUtil notificationUtil;
	
	@Autowired 
	private UserDeviceRepository deviceRepository;
	
	@Autowired
	private CustomerRepository customerRepository;
	
	@Autowired
	private NegotiationHistoryRepository negotiationHistoryRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	@Value("${storage_connection}")
	private String storageConnection;
	
	@Value("${container_name}")
	private String containerName;
	
	@Autowired
	private NotificationListRepository notificationListRepository;
	
	@Autowired
	private VehicleRepository vehicleRepository;
	
	@Autowired
	private UserEntityManager entityManager;
	
	@Autowired
	private EnquiryEntityManager enquiryEntityManager;
	
	@Autowired 
	private SMSUtil smsUtil;
	
	@Autowired 
	private UserOtpRepository userOtpRepository;

	@Override
	@Transactional
	public UtrustResponse saveEnquiryDetals(EnquiryRequest enquiryRequest, HttpServletRequest request) {

		List<CustomerAddress> custAddrList = new ArrayList<>();
		Customer customer = null;
		Vehicle vehicle = null;
		Enquiry enquiry = null;
		Integer uctdmsId = null;
		User user =null;
		// enquiry number is null if request is for createEnquiry
		try {
			if (request.getHeader(Constants.UCTDMS_ID) != null) {
				uctdmsId = Integer.parseInt(request.getHeader(Constants.UCTDMS_ID));
			    user=userRepository.getUserDetails(uctdmsId);

				if (user==null) {
					return new UtrustResponse(StatusCodes.UCTDMS_ID_NOT_FOUND.getStatusCode(),
							StatusCodes.UCTDMS_ID_NOT_FOUND.getMessage(), null);
				}
			}
			else {
				return new UtrustResponse(StatusCodes.UCTDMS_ID_NOT_EXISTS.getStatusCode(),
						StatusCodes.UCTDMS_ID_NOT_EXISTS.getMessage(), null);
			}
			
			BasicDetailsRequest basicDetailsRequest = enquiryRequest.getBasicDetails();
			NegotiationRequest negotiationRequest = enquiryRequest.getNegotiation();
			CustomerRequest customerRequest = basicDetailsRequest.getCustomer();
			VehicleRequest vehicleRequest = enquiryRequest.getVehicle();
			CustomerAddressRequest custAddrRequest = customerRequest.getCustomerAddress();
			ProcurementRequest procurementRequest=enquiryRequest.getProcurement();
			CustomerAddress cAddress =null;
			if (basicDetailsRequest.getEnquiryNumber() == null) {
				enquiry = new Enquiry();
				vehicle = new Vehicle();
				logger.info("Inside New Enquiry Creation ...");
				
				BeanUtils.copyProperties(basicDetailsRequest, enquiry);
				
				//set enquiry status to Hot/Prospect
				if (EnquiryStatus.Prospect.toString().equals(basicDetailsRequest.getEnquiryStatus())
						|| EnquiryStatus.Hot.toString().equals(basicDetailsRequest.getEnquiryStatus())) {
					enquiry.setEnquiryStatus(basicDetailsRequest.getEnquiryStatus());
				} else {
					return new UtrustResponse(StatusCodes.INVALID_ENQUIRY_STATUS.getStatusCode(),
							StatusCodes.INVALID_ENQUIRY_STATUS.getMessage());
				}
				
				customer = enquiryRepository.getEnquiryByMobile(customerRequest.getMobileNumber());
				if (customer == null) {
					customer = new Customer();
					BeanUtils.copyProperties(customerRequest, customer);
					cAddress = new CustomerAddress();
					BeanUtils.copyProperties(custAddrRequest, cAddress,"customerAddressId");
					cAddress.setCustomer(customer);
					custAddrList.add(cAddress);
				} else {
					BeanUtils.copyProperties(customerRequest, customer, "customerId");

					//address update 
					 // Integer customerAddressId =custAddrRequest.getCustomerAddressId();
					  List<CustomerAddress> addressList = customer.getCustomerAddrList();
					  
					if (addressList != null) {
						Map<String, CustomerAddress> map = new HashMap<>();

						for (CustomerAddress customAddress : addressList) {
							map.put(customAddress.getAddressType(), customAddress);
						}

						CustomerAddressRequest customerAddrRequest = customerRequest.getCustomerAddress();
				        cAddress = map.get(customerAddrRequest.getAddressType());

						if (cAddress == null) {
							// address type already exists 
							cAddress = new CustomerAddress();
							BeanUtils.copyProperties(custAddrRequest, cAddress, "customerAddressId");
							cAddress.setCustomer(customer);
							custAddrList.add(cAddress);
						}
						else {
							// address type already exists 
							BeanUtils.copyProperties(custAddrRequest, cAddress, "customerAddressId");
							custAddrList.add(cAddress);
						}
					}
				}

				vehicle = enquiryRepository.getEnquiryByRegNumber(vehicleRequest.getRegistrationNumber());
				if (vehicle == null) {
					vehicle = new Vehicle();
					BeanUtils.copyProperties(vehicleRequest, vehicle);
				} else {
					BeanUtils.copyProperties(vehicleRequest, vehicle, "vehicleId");
				}

				customer.setCustomerAddrList(custAddrList);
				vehicle.setCustomer(customer);
				enquiry.setCustomer(customer);
				enquiry.setVehicle(vehicle);
				
				DemandStructure demandStructure = masterRepository
						.getDemandStructure(basicDetailsRequest.getDemandStructureId());
				enquiry.setDemandStructure(demandStructure);

				SourceName sourceName = masterRepository.getSourceName(basicDetailsRequest.getSourceNameId());
				enquiry.setSourceName(sourceName);

				SourceType sourceType = masterRepository.getSourceType(basicDetailsRequest.getSourceTypeId());
				enquiry.setSourceType(sourceType);

				SellingReason sellingReasoning = masterRepository
						.getSellingReason(basicDetailsRequest.getSellingReasonId());
				enquiry.setSellingReasoning(sellingReasoning);

				Channel channel = masterRepository.getChannel(basicDetailsRequest.getChannelId());
				enquiry.setChannel(channel);

				StatusReasoning statusReasoning = masterRepository
						.getStatusReasoning(basicDetailsRequest.getStatusReasoningId());
				enquiry.setStatusReasoning(statusReasoning);

				EnquiryType enquiryType = masterRepository.getEnquiryType(basicDetailsRequest.getEnquiryTypeId());
				enquiry.setEnquiryType(enquiryType);
				
				Variant variant = masterRepository.getVariant(vehicleRequest.getVariantId());
				vehicle.setVariant(variant);

				Make make = masterRepository.getMake(vehicleRequest.getMakeId());
				vehicle.setMake(make);

				Model model = masterRepository.getModel(vehicleRequest.getModelId());
				vehicle.setModel(model);

				ExteriorColor exteriorColor = masterRepository.getExteriorColor(vehicleRequest.getExteriorColourId());
				vehicle.setExteriorColor(exteriorColor);
				
				InsuranceType insuranceType = masterRepository.getInsuranceType(vehicleRequest.getInsuranceTypeId());
				vehicle.setInsuranceType(insuranceType);
				
				String enqNumber= enquiryRepository.getLatestEnquiry(); 
 				if (enqNumber==null) {
					  enqNumber = Constants.ENQUIRY + Constants.INITIAL_NUMBER;
				}
				else {
					enqNumber=enqNumber.replace(Constants.ENQUIRY, "");
					Integer enqNo =Integer.parseInt(enqNumber);
					enqNo++;
					enqNumber=Constants.ENQUIRY +enqNo;
				}
				
 				enquiry.setSellingRemark(basicDetailsRequest.getSellingRemark());
				enquiry.setEnquiryNumber(enqNumber);
				enquiry.setActualPrice(negotiationRequest.getActualPrice());
				enquiry.setExpectedOffer(negotiationRequest.getExpectedOffer());
				enquiry.setSuggestedPrice(negotiationRequest.getSuggestedPrice());
				enquiry.setCreatedAt(new Date());
				enquiry.setCreatedBy(uctdmsId);
				enquiry.setAssigenedby(uctdmsId);
				
 				enquiry.setAssignTo(uctdmsId);//By default logged in user(PO/PTL is the assigned to user ,
 				                                                                   //this user will change with assignEnquiry api)
				enquiry.setModifiedat(new Date());
				enquiry.setModifiedby(uctdmsId);
				enquiry.setBookingDate(new Date());
				
				//To Do : Insert this data as null here and after valuation is done make this as 0 (After valuation is done)
				// False stands for procurement data is not saved
				enquiry.setIsProcurementSaved(false);
				enquiry.setEnquiryCategory(Constants.SELLER_ENQUIRY_CATEGORY);
				
				// follow-up
				FollowUpRequest followUpRequest = enquiryRequest.getFollowUp();
				ActualFollowUpRequest actualFollowUpRequest = followUpRequest.getActualFollowUp();
				NextFollowUpRequest nextFollowUpRequest = followUpRequest.getNextFollowUp();
				FollowUp followUp = new FollowUp();
				followUp.setActualRemark(null);
				followUp.setActualDetailRemark(null);
				followUp.setActualDate(null);
				followUp.setNextRemark(nextFollowUpRequest.getFollowUpRemark());
				followUp.setNextDetailRemark(nextFollowUpRequest.getDetailFollowUpRemark());
				followUp.setNextDate(nextFollowUpRequest.getFollowUpDate());
				followUp.setEnquiryNumber(enqNumber);
				followUp=followUpRepository.save(followUp);
				
				// saving ENQUIRY
				enquiryRepository.save(enquiry);
				
				// when source type is new car trade_in, send notification
				if(Constants.PO_ROLE == user.getUserRoleId() && sourceType.getName().equals(Constants.NEW_CAR_TRADE_IN)) {
					// deviceToken is decided based on uctdmsId weather it is PO/PTL 
					UserDevice userDevice=deviceRepository.getUserDevice(user.getReportingTo());
					// Send push notification to PTL
					notificationUtil.sendNotification(uctdmsId,user.getReportingTo(),Constants.EVENT_NEW_SELLER_ENQUIRY,userDevice,enquiry,null, null);
				}
				// initial offer price
				if(Constants.PO_ROLE == user.getUserRoleId() && enquiry.getActualPrice()!=null) { 
					// deviceToken is decided based on uctdmsId weather it is PO/PTL 
					UserDevice userDevice=deviceRepository.getUserDevice(user.getReportingTo());
					// Send push notification to PTL 
					notificationUtil.sendNotification(uctdmsId,user.getReportingTo(),Constants.EVENT_INITIAL_OFFER_PRICE_APPROVAL_FROM_PO,userDevice,enquiry,negotiationRequest, null);
				}
				// fetch duplicate ENQUIRY from system
				Enquiry enqLocal = enquiryRepository.getDuplicateEnquiry(vehicleRequest.getRegistrationNumber(),customerRequest.getMobileNumber());
				// If duplicate ENQUIRY available , Send notification to PTL 
				if(enqLocal!=null) { 
					User ptlUser = null, ucmUser = null, groupHeadUser = null;
					UserDevice userDevice = null;
					if(Constants.PO_ROLE == user.getUserRoleId()) {
						ptlUser = userRepository.getUserDetails(user.getReportingTo());
						ucmUser = userRepository.getUserDetails(ptlUser.getReportingTo());
					}
					else if(Constants.PTL_ROLE == user.getUserRoleId()) {
						ucmUser = userRepository.getUserDetails(user.getReportingTo());
					}
					if(ucmUser != null) {
						// deviceToken of UCM
						userDevice = deviceRepository.getUserDevice(ucmUser.getUctdmsId());
						// Send push notification to UCM
						notificationUtil.sendNotification(uctdmsId,ucmUser.getUctdmsId(), Constants.EVENT_DUPLICATE_ENQUIRY_SYSTEM, userDevice, enquiry, negotiationRequest,null);
						groupHeadUser = userRepository.getUserDetails(ucmUser.getReportingTo());
						if(groupHeadUser != null) {
							// deviceToken of GH
							userDevice = deviceRepository.getUserDevice(groupHeadUser.getUctdmsId());
							// Send push notification to GH
							notificationUtil.sendNotification(uctdmsId,groupHeadUser.getUctdmsId(), Constants.EVENT_DUPLICATE_ENQUIRY_SYSTEM, userDevice, enquiry, negotiationRequest,null);
						}else {
							logger.info("Group Head not found...");
						}
					}else {
						logger.info("UCM not found...");
					}
				}
				// save EnquiryTimeline Details
				saveEnquiryTimeline(followUp, enquiry);
				
				//calling save saveNegotiationHistory method to save PO related data , when PO will initiate initial offer price and customer expected price
				saveNegotiationHistory(enquiry,user, negotiationRequest);
				
				return new UtrustResponse(StatusCodes.ENQUIRY_SAVE_SUCCESS.getStatusCode(),
						StatusCodes.ENQUIRY_SAVE_SUCCESS.getMessage().replace("#enqNum", enquiry.getEnquiryNumber()), enqNumber);
			}

			else {
				logger.info("Inside Edit Enquiry... ");
				enquiry = enquiryRepository.getEnquiry(basicDetailsRequest.getEnquiryNumber());

				if (enquiry == null) {
					return new UtrustResponse(StatusCodes.ENQUIRY_NOT_FOUND.getStatusCode(),
							StatusCodes.ENQUIRY_NOT_FOUND.getMessage(), null);
				}
				// checking whether user is having the edit permission or not
				//1.PO only can edit the enquiry
				Dealer dealer = user.getDealer();
			    User  enqAssignedUser=userRepository.getUserDetails(enquiry.getAssignTo());
			    Dealer enqDealer = enqAssignedUser.getDealer();
				
			    User  enqCreatedUser=userRepository.getUserDetails(enquiry.getCreatedBy());

			    if ((enqCreatedUser.getUctdmsId() == user.getUctdmsId() ||enqAssignedUser.getReportingTo()==user.getUctdmsId())&&user.getUserRoleId()==Constants.PTL_ROLE) {
					logger.info("PTL is tryting edit the enquiry :"+user.getUserRoleId());
				} 
			    
			    /*if (enquiry.getCreatedBy()==user.getUctdmsId()&& enqCreatedUser.getUserRoleId()==Constants.PTL_ROLE) {
					logger.info("PTL is tryting edit the enquiry created by himself:"+enquiry.getCreatedBy());
				}
			    */
			    else if (user.getUctdmsId()!=enqAssignedUser.getUctdmsId()||user.getUserRoleId()!=Constants.PO_ROLE || dealer.getDealerCode()!=enqDealer.getDealerCode()
						|| dealer.getBranchCode()!=enqDealer.getBranchCode()  ) {
					
					return new UtrustResponse(StatusCodes.NO_ENQUIRY_EDIT_ACCESS.getStatusCode(),
							StatusCodes.NO_ENQUIRY_EDIT_ACCESS.getMessage(), null);
				}
				
				//update aadhaar if vehicle stage is not purchased.
				if (procurementRequest!=null&&procurementRequest.getAadhaarNumber()!=null) {
					VehicleStage vehicleStage =enquiry.getVehicle().getVehicleStage();
					if (vehicleStage==null) {
						// Adhaar number  can  be updated before vehicle move to any stages like Purchased,Collected .. etc)
						enquiry.setAadhaarNumber(procurementRequest.getAadhaarNumber());
					}
				}
				// update basicDetails
				if (basicDetailsRequest.getIsUpdate()) {
					BeanUtils.copyProperties(basicDetailsRequest, enquiry, "id");
					
					//setting ENQUIRY status as Hot or prospects
					if (EnquiryStatus.Prospect.toString().equals(basicDetailsRequest.getEnquiryStatus())
							|| EnquiryStatus.Hot.toString().equals(basicDetailsRequest.getEnquiryStatus())) {
						enquiry.setEnquiryStatus(basicDetailsRequest.getEnquiryStatus());
					} else {
						return new UtrustResponse(StatusCodes.INVALID_ENQUIRY_STATUS.getStatusCode(),
								StatusCodes.INVALID_ENQUIRY_STATUS.getMessage());
					}
					
					DemandStructure demandStructure = masterRepository
							.getDemandStructure(basicDetailsRequest.getDemandStructureId());
					
					enquiry.setDemandStructure(demandStructure);

					SourceName sourceName = masterRepository.getSourceName(basicDetailsRequest.getSourceNameId());
					enquiry.setSourceName(sourceName);

					SourceType sourceType = masterRepository.getSourceType(basicDetailsRequest.getSourceTypeId());
					enquiry.setSourceType(sourceType);

					SellingReason sellingReasoning = masterRepository
							.getSellingReason(basicDetailsRequest.getSellingReasonId());
					enquiry.setSellingReasoning(sellingReasoning);

					Channel channel = masterRepository.getChannel(basicDetailsRequest.getChannelId());
					enquiry.setChannel(channel);

					StatusReasoning statusReasoning = masterRepository
							.getStatusReasoning(basicDetailsRequest.getStatusReasoningId());
					enquiry.setStatusReasoning(statusReasoning);
					
					EnquiryType enquiryType = masterRepository.getEnquiryType(basicDetailsRequest.getEnquiryTypeId());
					enquiry.setEnquiryType(enquiryType);
				}
				
				enquiry.setExpectedOffer(negotiationRequest.getExpectedOffer());
				vehicle = enquiry.getVehicle();
				customer = enquiry.getCustomer();

				
				if (vehicleRequest.getIsUpdate()) {
					vehicle = enquiry.getVehicle();
					BeanUtils.copyProperties(vehicleRequest, vehicle, "vehicleId");
					Variant variant = masterRepository.getVariant(vehicleRequest.getVariantId());
					vehicle.setVariant(variant);

					Make make = masterRepository.getMake(vehicleRequest.getMakeId());
					vehicle.setMake(make);

					Model model = masterRepository.getModel(vehicleRequest.getModelId());
					vehicle.setModel(model);
					
					// Vehicle insurance date update
					vehicle.setInsuranceValidityDate(vehicleRequest.getInsuranceValidityDate());
					
					ExteriorColor exteriorColor = masterRepository.getExteriorColor(vehicleRequest.getExteriorColourId());
					vehicle.setExteriorColor(exteriorColor);
					enquiry.setVehicle(vehicle);
				}
				
				if (customerRequest.getIsUpdate()) {
					customer = enquiry.getCustomer();
					BeanUtils.copyProperties(customerRequest, customer, "customerId");
					
					if (custAddrRequest.getIsUpdate()) {
						List<CustomerAddress> addressList = customer.getCustomerAddrList();
						Map<Integer, CustomerAddress> map = new HashMap<>();
						for (CustomerAddress customAddress : addressList) {
							map.put(customAddress.getCustomerAddressId(), customAddress);
						}
 						 cAddress = map.get(custAddrRequest.getCustomerAddressId());
						if (custAddrRequest.getCustomerAddressId() != null && map.get(custAddrRequest.getCustomerAddressId()) != null) {
							BeanUtils.copyProperties(custAddrRequest, cAddress,"customerAddressId");
							custAddrList.add(cAddress);
						}
						customer.setCustomerAddrList(custAddrList);
					}
				}

				enquiry.setCustomer(customer);
				vehicle.setCustomer(customer);
				enquiry.setVehicle(vehicle);
				enquiry.setModifiedat(new Date());
				enquiry.setModifiedby(uctdmsId);
				BeanUtils.copyProperties(enquiryRequest, enquiry);
				
				// Save Follow up details
				FollowUp followUp = null;
				FollowUpRequest followUpRequest = enquiryRequest.getFollowUp();
				ActualFollowUpRequest actualFollowUpRequest = followUpRequest.getActualFollowUp();
				NextFollowUpRequest nextFollowUpRequest = followUpRequest.getNextFollowUp();

				followUp = new FollowUp();
				// set actual follow up
				if(actualFollowUpRequest != null) {
					followUp.setActualDate(actualFollowUpRequest.getFollowUpDate());
					followUp.setActualRemark(actualFollowUpRequest.getFollowUpRemark());
					followUp.setActualDetailRemark(actualFollowUpRequest.getDetailFollowUpRemark());
				}
				// set next follow up
				if(nextFollowUpRequest != null) {
					followUp.setNextDate(nextFollowUpRequest.getFollowUpDate());
					followUp.setNextRemark(nextFollowUpRequest.getFollowUpRemark());
					followUp.setNextDetailRemark(nextFollowUpRequest.getDetailFollowUpRemark());
				}
				followUp.setEnquiryNumber(enquiry.getEnquiryNumber());
				followUp = followUpRepository.save(followUp);
				
				// save ENQUIRY data
				enquiryRepository.save(enquiry);
				
 				// save Edited EnquiryTimeline
				saveEditedEnquiryFollowUpTimeline(followUp, enquiry, uctdmsId);
				
			    NegotiationHistory negotiationHistory = negotiationHistoryRepository.findByEnqNumber(enquiry.getEnquiryNumber());
			    // Offer price approval request
				if (Constants.PO_ROLE == user.getUserRoleId() && negotiationHistory != null
						&& negotiationRequest.getLatestOfferPrice() != null
						&& !(negotiationRequest.getLatestOfferPrice().equals(negotiationHistory.getLatestOfferPrice()))
						|| (negotiationRequest.getLatestExpectedPrice() != null && !(negotiationRequest
								.getLatestExpectedPrice().equals(negotiationHistory.getLatestExpectedPrice())))) {
					// deviceToken is decided based on uctdmsId weather it is PO/PTL 
					UserDevice userDevice=deviceRepository.getUserDevice(user.getReportingTo());
					// Send push notification to PO 
					notificationUtil.sendNotification(uctdmsId,user.getReportingTo(),Constants.EVENT_OFFER_PRICE_APPROVAL_FROM_PO,userDevice,enquiry,negotiationRequest, null);
				}
				
				// when PTL giving any remarks, send notification to PO
				if(Constants.PTL_ROLE == user.getUserRoleId() && negotiationRequest.getPtlRemarks()!=null) {
					// deviceToken is decided based on uctdmsId weather it is PO/PTL 
					UserDevice userDevice=deviceRepository.getUserDevice(user.getReportingTo());
					// Send push notification to PO 
					notificationUtil.sendNotification(uctdmsId,enquiry.getAssignTo(),Constants.EVENT_ENQUIRY_FOLLOWUP_PTL_REMARK,userDevice,enquiry,null, null);
				}
				
				//calculating price difference is less or equal to 50,000.
				Double priceDiff = negotiationRequest.getLatestExpectedPrice() - negotiationRequest.getLatestOfferPrice();
				if (priceDiff <= 0.5) {
					User ptlUser = null, ucmUser = null, groupHeadUser = null;
					UserDevice userDevice = null;
					ptlUser = userRepository.getUserDetails(user.getReportingTo());
					ucmUser = userRepository.getUserDetails(ptlUser.getReportingTo());
					// deviceToken of UCM
					userDevice = deviceRepository.getUserDevice(ucmUser.getUctdmsId());
					// Send push notification to UCM
					notificationUtil.sendNotification(uctdmsId, ucmUser.getUctdmsId(), Constants.EVENT_PRICE_DIFFERENCE,
							userDevice, enquiry, negotiationRequest, null);
					groupHeadUser = userRepository.getUserDetails(ucmUser.getReportingTo());
					if (groupHeadUser != null) {
						// deviceToken of GH
						userDevice = deviceRepository.getUserDevice(groupHeadUser.getUctdmsId());
						// Send push notification to GH
						notificationUtil.sendNotification(uctdmsId, groupHeadUser.getUctdmsId(),
								Constants.EVENT_PRICE_DIFFERENCE, userDevice, enquiry, negotiationRequest, null);
					}else {
						logger.debug("Group Head not found..");
					}
				}
				//calling save saveNegotiationHistory method to save PO related data , when PO will initiate initial offer price and customer expected price
				  saveNegotiationHistory(enquiry,user, negotiationRequest);
			}
			return new UtrustResponse(StatusCodes.ENQUIRY_UPDATE_SUCCESS.getStatusCode(),
					StatusCodes.ENQUIRY_UPDATE_SUCCESS.getMessage().replace("#enqNum", enquiry.getEnquiryNumber()), null);
		} catch (Exception e) {
			logger.error("EnquiryRequest"+enquiryRequest+"\n"+Constants.EXCEPTION, e);
			return new UtrustResponse(StatusCodes.ENQUIRY_SAVE_FAIL.getStatusCode(),
					StatusCodes.ENQUIRY_SAVE_FAIL.getMessage(), null);
		}
	}

	@Transactional
	public void saveEnquiryTimeline(FollowUp followUp, Enquiry enquiry) {
		try {
			// save new follow up to EnquiryTimeline
			EnquiryTimeline enquiryTimeline = new EnquiryTimeline();
			enquiryTimeline.setEnquiryNumber(followUp.getEnquiryNumber());
			enquiryTimeline.setAction(Constants.TIMELINE_FOLLOWUP_CREATED);
			enquiryTimeline.setUpdatedBy(enquiry.getCreatedBy());
			enquiryTimeline.setUpdatedDate(enquiry.getCreatedAt());
			enquiryTimeline.setRemarks(followUp.getNextRemark());
			enquiryTimeline.setFollowupId(followUp.getFollowUpId());
			enquiryTimeline.setIsFollowup(1);
			enquiryFollowupRepository.save(enquiryTimeline);

			// save new ENQUIRY to EnquiryTimeline
			enquiryTimeline = new EnquiryTimeline();
			enquiryTimeline.setEnquiryNumber(followUp.getEnquiryNumber());
			enquiryTimeline.setAction(Constants.TIMELINE_ENQUIRY_CREATED);
			enquiryTimeline.setUpdatedBy(enquiry.getCreatedBy());
			enquiryTimeline.setUpdatedDate(enquiry.getCreatedAt());
			enquiryTimeline.setRemarks(enquiry.getSellingRemark());
			enquiryTimeline.setFollowupId(0);
			enquiryTimeline.setIsFollowup(0);
			enquiryFollowupRepository.save(enquiryTimeline);

		} catch (Exception e) {
			logger.error("followUP request : "+followUp +"\n enquiry request : "+enquiry+"\n"+Constants.EXCEPTION, e);
			throw e;
		}
	}

	@Transactional
	public void saveEditedEnquiryFollowUpTimeline(FollowUp followUp, Enquiry enquiry, int uctdmsId) {
		try {
			// save newly created follow up details to EnquiryTimeline
			EnquiryTimeline enquiryTimeline = new EnquiryTimeline();
			enquiryTimeline.setEnquiryNumber(followUp.getEnquiryNumber());
			enquiryTimeline.setAction(Constants.TIMELINE_FOLLOWUP_CREATED);
			enquiryTimeline.setRemarks(followUp.getNextRemark());
			enquiryTimeline.setFollowupId(followUp.getFollowUpId());
			enquiryTimeline.setIsFollowup(1);
			enquiryTimeline.setUpdatedBy(enquiry.getModifiedby());
			enquiryTimeline.setUpdatedDate(enquiry.getModifiedat());
			enquiryFollowupRepository.save(enquiryTimeline);

			// save updated ENQUIRY details to EnquiryTimeline
			enquiryTimeline = new EnquiryTimeline();
			enquiryTimeline.setEnquiryNumber(followUp.getEnquiryNumber());
			enquiryTimeline.setAction(Constants.TIMELINE_ENQUIRY_UPDATED);
			enquiryTimeline.setRemarks(enquiry.getSellingRemark());
			enquiryTimeline.setFollowupId(followUp.getFollowUpId());
			enquiryTimeline.setIsFollowup(0);
			enquiryTimeline.setUpdatedBy(enquiry.getModifiedby());
			enquiryTimeline.setUpdatedDate(enquiry.getModifiedat());
			enquiryFollowupRepository.save(enquiryTimeline);
		} catch (Exception e) {
			logger.error(" followUP request : "+followUp +" enquiry request : "+enquiry + " uctdmsid : " +uctdmsId+"\n"+Constants.EXCEPTION, e);
			throw e;
		}
	}

	@Transactional
	private NegotiationHistory saveNegotiationHistory(Enquiry enquiry,User user, NegotiationRequest negotiationRequest) {
		try {
			NegotiationHistory negotiationHistory = new NegotiationHistory();
			negotiationHistory.setEnqNumber(enquiry.getEnquiryNumber());
			negotiationHistory.setOfferPrice(enquiry.getExpectedOffer());
			negotiationHistory.setDate(enquiry.getCreatedAt());
			if (user.getUserRoleId() == Constants.PO_ROLE) {
				negotiationHistory.setPoId(user.getUctdmsId());
			}else if(user.getUserRoleId() == Constants.PTL_ROLE) {
				negotiationHistory.setPtlId(user.getUctdmsId());
			}
			negotiationHistory.setLatestExpectedPrice(negotiationRequest.getLatestExpectedPrice());
			negotiationHistory.setLatestOfferPrice(negotiationRequest.getLatestOfferPrice());
			negotiationHistory.setPtlRemark(negotiationRequest.getPtlRemarks());
			return negotiationHistoryRepository.save(negotiationHistory);
		}catch(Exception e) {
			logger.error("Enquiry request ::"+enquiry+"\n User request ::"+user+"\n Negotiation request ::"+negotiationRequest);
			throw e;
		}
	}
	
	@Override
	@Transactional
	public UtrustResponse dropEnquiry(DropEnquiryRequest enquiryRequest,HttpServletRequest request) {
		Integer uctdmsId=null;
		User user = null;
		try {
			if (request.getHeader(Constants.UCTDMS_ID) != null) {
				uctdmsId = Integer.parseInt(request.getHeader(Constants.UCTDMS_ID));
			    user=userRepository.getUserDetails(uctdmsId);

				if (user==null) {
					return new UtrustResponse(StatusCodes.UCTDMS_ID_NOT_FOUND.getStatusCode(),
							StatusCodes.UCTDMS_ID_NOT_FOUND.getMessage(), null);
				}
			}
			else {
				return new UtrustResponse(StatusCodes.UCTDMS_ID_NOT_EXISTS.getStatusCode(),
						StatusCodes.UCTDMS_ID_NOT_EXISTS.getMessage(), null);
			}
			Enquiry enquiry = enquiryRepository.getEnquiry(enquiryRequest.getEnquiryNumber());
			if (enquiry != null) {
				enquiry.setDropReason(enquiryRequest.getDropReason());
				enquiry.setDropRemark(enquiryRequest.getDropRemarks());
				enquiry.setDropDetailedRemark(enquiryRequest.getDropDetailedRemark());
				enquiryRepository.save(enquiry);

				// Send push notification to PTL 
				UserDevice userDevice=deviceRepository.getUserDevice(user.getReportingTo());
				notificationUtil.sendNotification(uctdmsId,user.getReportingTo(),Constants.EVENT_DROP_ENQUIRY,userDevice,enquiry,null, null);
				return new UtrustResponse(StatusCodes.ENQUIRY_DROP_REQUEST_SUCCESS.getStatusCode(),
						StatusCodes.ENQUIRY_DROP_REQUEST_SUCCESS.getMessage(), null);
			} else {
				return new UtrustResponse(StatusCodes.ENQUIRY_NOT_FOUND.getStatusCode(),
						StatusCodes.ENQUIRY_NOT_FOUND.getMessage(), null);
			}

		} catch (Exception e) {
			logger.error("DropEnquiryRequest request body ::"+enquiryRequest+"\n"+Constants.EXCEPTION, e);
			return new UtrustResponse(StatusCodes.ENQUIRY_DROP_REQUEST_FAIL.getStatusCode(),
					StatusCodes.ENQUIRY_DROP_REQUEST_FAIL.getMessage(), null);
		}
	}

	@Override
	@Transactional
	public UtrustResponse acceptDropRequest_backedUp(DropEnquiryRequest enquiryRequest, HttpServletRequest request) {
		Integer uctdmsId=null;
		User user = null;
		try {
			if (request.getHeader(Constants.UCTDMS_ID) != null) {
				uctdmsId = Integer.parseInt(request.getHeader(Constants.UCTDMS_ID));
				user=userRepository.getUserDetails(uctdmsId);

				if (user==null) {
					return new UtrustResponse(StatusCodes.UCTDMS_ID_NOT_FOUND.getStatusCode(),
							StatusCodes.UCTDMS_ID_NOT_FOUND.getMessage(), null);
				}
			}
			else {
				return new UtrustResponse(StatusCodes.UCTDMS_ID_NOT_EXISTS.getStatusCode(),
						StatusCodes.UCTDMS_ID_NOT_EXISTS.getMessage(), null);
			}
			// deviceToken is decided based on uctdmsId weather it is PO/PTL 
			UserDevice userDevice=deviceRepository.getUserDevice(user.getReportingTo());

			/*
			 * FireBasePushNotifications fns = new FireBasePushNotifications(); 
			 * Firebase Registration Token from auth service here.
			 * fns.sendPushNotifications(""); enquiry.setEnquiryStatus("dropped");
			 */

			Enquiry enquiry = enquiryRepository.getEnquiry(enquiryRequest.getEnquiryNumber());
			if (enquiry != null) {
				if (enquiryRequest.getIsDrop()) {
					logger.info("Enquiry request accepted: " + enquiryRequest.getEnquiryNumber());
					enquiry.setEnquiryStatus(Constants.DROPPED);
					enquiryRepository.save(enquiry);

					EnquiryTimeline enquiryTimeline = new EnquiryTimeline();
					enquiryTimeline.setEnquiryNumber(enquiry.getEnquiryNumber());
					enquiryTimeline.setAction(Constants.TIMELINE_ENQUIRY_DROPPED);
					enquiryTimeline.setRemarks(enquiry.getDropRemark());
					enquiryTimeline.setFollowupId(0);
					enquiryTimeline.setIsFollowup(0);
					enquiryTimeline.setUpdatedBy(0);
					enquiryTimeline.setUpdatedDate(new Date());
					enquiryFollowupRepository.save(enquiryTimeline);

					// Send push notification to PO here
					notificationUtil.sendNotification(uctdmsId,user.getReportingTo(),Constants.EVENT_ENQUIRY_DROP_APPROVED,userDevice,enquiry,null, Constants.APPROVED);
				} else {
					logger.info("Enquiry request rejected: " + enquiryRequest.getEnquiryNumber());
					// Send push notification to PO here
					notificationUtil.sendNotification(uctdmsId,user.getReportingTo(),Constants.EVENT_ENQUIRY_DROP_REJECTED,userDevice,enquiry,null, Constants.REJECTED);
				}
				return new UtrustResponse(StatusCodes.ENQUIRY_DROP_SUCCESS.getStatusCode(),
						StatusCodes.ENQUIRY_DROP_SUCCESS.getMessage(), null);
			} else {
				logger.info(StatusCodes.ENQUIRY_NOT_FOUND + enquiryRequest.getEnquiryNumber());
				return new UtrustResponse(StatusCodes.ENQUIRY_NOT_FOUND.getStatusCode(),
						StatusCodes.ENQUIRY_NOT_FOUND.getMessage(), null);
			}
		} catch (Exception e) {
			logger.error(Constants.EXCEPTION,e);
			return new UtrustResponse(StatusCodes.ENQUIRY_DROP_FAIL.getStatusCode(),
					StatusCodes.ENQUIRY_DROP_FAIL.getMessage(), null);
		}
	} 

	
	
	/**
	 * Get response from the user like PO/PTL/UCM
	 * 
	 * @author BIKASH
	 * @param approvedRequest
	 * @param request
	 */
	@Override
	@Transactional
	public UtrustResponse getResponseFromUser(ApprovedRequest approvedRequest, HttpServletRequest request) {

		UserDevice userDevice = null;
		NegotiationRequest negotiationRequest = null;
		Enquiry enquiry = null;
		Customer customer = null;
		NotificationList notificationList = null;
		Integer notificationFrom = null, notificationTo = null;
		User user = null;
		Integer uctdmsId=null;
		NegotiationHistory negotiationHistory = null;
		NotificationListResponse notificationListResponse = null;
		
		try {
			logger.info("Inside getResponseFromUser : "+approvedRequest);
			if (request.getHeader(Constants.UCTDMS_ID) != null) {
				uctdmsId = Integer.parseInt(request.getHeader(Constants.UCTDMS_ID));
			    user = userRepository.getUserDetails(uctdmsId);

				if (user==null) {
					return new UtrustResponse(StatusCodes.UCTDMS_ID_NOT_FOUND.getStatusCode(),
							StatusCodes.UCTDMS_ID_NOT_FOUND.getMessage(), null);
				}
			}
			else {
				return new UtrustResponse(StatusCodes.UCTDMS_ID_NOT_EXISTS.getStatusCode(),
						StatusCodes.UCTDMS_ID_NOT_EXISTS.getMessage(), null);
			}
			notificationFrom = approvedRequest.getNotificationFromUser();
			notificationTo = approvedRequest.getNotificationToUser();

			//get device token for a user device
			userDevice = deviceRepository.getUserDevice(notificationFrom);
			enquiry = enquiryRepository.getEnquiry(approvedRequest.getEnquiryNumber());
			notificationList = notificationListRepository.getNotificationListById(approvedRequest.getNotificationId());
		
			if (enquiry != null && notificationList != null) {
				negotiationRequest = new NegotiationRequest();
				negotiationHistory = negotiationHistoryRepository.findByEnqNumber(enquiry.getEnquiryNumber());
				String eventName = notificationList.getNotificationMaster().getEventName();
				customer = enquiry.getCustomer();
				
				// Alternate number approval
				if(customer != null && Constants.EVENT_ALTERNATE_NUMBER_APPROVAL_REQUEST.equals(eventName)) {
					OtpRequest otpRequest = new OtpRequest();
					otpRequest.setType(Constants.OTP_CONFIRM_PURCHASE);
					otpRequest.setAlternateMobile(customer.getAlternateMobileNumber());
					otpRequest.setMobileNumber(customer.getMobileNumber());
					otpRequest.setFromPTL(true);
					otpRequest.setEnquiryNumber(enquiry.getEnquiryNumber());
					
					notificationList.setStatus(Constants.ACTION_DONE);
					notificationListRepository.save(notificationList);
					
					if(approvedRequest.getIsApproved()) {
						customer.setIsApproved(true);
						customerRepository.save(customer);
						
						// Send push notification to PTL for approval
						notificationUtil.sendNotification(notificationTo,notificationFrom,Constants.EVENT_ALTERNATE_NUMBER_APPROVED,userDevice,enquiry,null, Constants.APPROVED);
						// sending OTP
						sendOtp(otpRequest, request);
						
						notificationList = notificationListRepository.getLatestEnquiry(enquiry.getEnquiryNumber());
						notificationListResponse = createNotificationListResponse(notificationList);
						return new UtrustResponse(StatusCodes.ALTERNATE_NUMBER_APPROVE_SUCCESS.getStatusCode(),
								StatusCodes.ALTERNATE_NUMBER_APPROVE_SUCCESS.getMessage(), notificationListResponse);
					}else {
						// Send push notification to PTL for approval
						notificationUtil.sendNotification(notificationTo,notificationFrom,Constants.EVENT_ALTERNATE_NUMBER_REJECTED,userDevice,enquiry,null, Constants.REJECTED);
						
						customer.setIsApproved(false);
						customerRepository.save(customer);
						
						notificationList = notificationListRepository.getLatestEnquiry(enquiry.getEnquiryNumber());
						notificationListResponse = createNotificationListResponse(notificationList);
						return new UtrustResponse(StatusCodes.ALTERNATE_NUMBER_APPROVE_REJECT.getStatusCode(),
								StatusCodes.ALTERNATE_NUMBER_APPROVE_REJECT.getMessage(), notificationListResponse);
					}
				}
				
				// Drop request approval
				else if (Constants.EVENT_DROP_ENQUIRY.equals(eventName)) {
					notificationList.setStatus(Constants.ACTION_DONE);
					notificationListRepository.save(notificationList);
					if (approvedRequest.getIsApproved()) {
						enquiry.setEnquiryStatus(Constants.DROPPED);
						enquiryRepository.save(enquiry);
						
						// save next follow up details as NULL when ENQUIRY to be dropped 
						FollowUp latestFollowUp = followUpRepository.getLatestFollowUp(enquiry.getEnquiryNumber());
						if(latestFollowUp != null) {
							FollowUp followUp = new FollowUp();
							BeanUtils.copyProperties(latestFollowUp, followUp, "nextDate", "nextRemark", "nextDetailRemark");
							followUpRepository.save(followUp);
						}
						
						// save EnquiryTimeline
						EnquiryTimeline enquiryTimeline = new EnquiryTimeline();
						enquiryTimeline.setEnquiryNumber(enquiry.getEnquiryNumber());
						enquiryTimeline.setAction(Constants.TIMELINE_ENQUIRY_DROPPED);
						enquiryTimeline.setRemarks(enquiry.getDropRemark());
						enquiryTimeline.setFollowupId(0);
						enquiryTimeline.setIsFollowup(2);
						enquiryTimeline.setUpdatedBy(uctdmsId);
						enquiryTimeline.setUpdatedDate(new Date());
						enquiryFollowupRepository.save(enquiryTimeline);
						
						// Send push notification to PO
						notificationUtil.sendNotification(notificationTo,notificationFrom,Constants.EVENT_ENQUIRY_DROP_APPROVED,userDevice,enquiry,null, Constants.APPROVED);
						
						// get latest ENQUIRY details
						notificationList = notificationListRepository.getLatestEnquiry(approvedRequest.getEnquiryNumber());
						notificationListResponse = createNotificationListResponse(notificationList);
						return new UtrustResponse(StatusCodes.ENQUIRY_DROP_SUCCESS.getStatusCode(),
								StatusCodes.ENQUIRY_DROP_SUCCESS.getMessage(), notificationListResponse);
					} else {
						// Send push notification to PO here
						notificationUtil.sendNotification(notificationTo,notificationFrom,Constants.EVENT_ENQUIRY_DROP_REJECTED,userDevice,enquiry,null, Constants.REJECTED);
						
						//get latest ENQUIRY
						notificationList = notificationListRepository.getLatestEnquiry(approvedRequest.getEnquiryNumber());
						notificationListResponse = createNotificationListResponse(notificationList);
						return new UtrustResponse(StatusCodes.ENQUIRY_DROP_REJECT.getStatusCode(),
								StatusCodes.ENQUIRY_DROP_REJECT.getMessage(), notificationListResponse);
					}
				}
				
				// Offer price approval
				else if (negotiationHistory != null && Constants.EVENT_OFFER_PRICE_APPROVAL_FROM_PO.equals(eventName)) {
					notificationList.setStatus(Constants.ACTION_DONE);
					notificationListRepository.save(notificationList);
					negotiationRequest.setLatestOfferPrice(negotiationHistory.getLatestOfferPrice());
					if (approvedRequest.getIsApproved()) {
						// send to PO
						notificationUtil.sendNotification(notificationTo,notificationFrom, Constants.EVENT_OFFER_PRICE_APPROVED, userDevice, enquiry,
								negotiationRequest, Constants.APPROVED);
						notificationList = notificationListRepository.getLatestEnquiry(approvedRequest.getEnquiryNumber());
						notificationListResponse = createNotificationListResponse(notificationList);
						return new UtrustResponse(StatusCodes.OFFER_PRICE_APPROVED.getStatusCode(),
								StatusCodes.OFFER_PRICE_APPROVED.getMessage(), notificationListResponse);
					}
					// if PTL suggested something
					else if(approvedRequest.getIsSuggested()) {
						negotiationRequest.setLatestOfferPrice(negotiationHistory.getLatestOfferPrice());
						negotiationRequest.setLatestExpectedPrice(negotiationHistory.getLatestExpectedPrice());
						// send to PO
						notificationUtil.sendNotification(notificationTo,notificationFrom, Constants.EVENT_OFFER_PRICE_SUGGESTED, userDevice, enquiry,
								negotiationRequest, Constants.SUGGESTED);
						notificationList = notificationListRepository.getLatestEnquiry(approvedRequest.getEnquiryNumber());
						notificationListResponse = createNotificationListResponse(notificationList);
						return new UtrustResponse(StatusCodes.OFFER_PRICE_SUGGESTED_BY_PTL.getStatusCode(),
								StatusCodes.OFFER_PRICE_SUGGESTED_BY_PTL.getMessage(), notificationListResponse);
					} 
					else {
						// send to PO
						notificationUtil.sendNotification(notificationTo,notificationFrom, Constants.EVENT_OFFER_PRICE_REJECTED, userDevice, enquiry,
								negotiationRequest, Constants.REJECTED);
						notificationList = notificationListRepository.getLatestEnquiry(approvedRequest.getEnquiryNumber());
						notificationListResponse = createNotificationListResponse(notificationList);
						return new UtrustResponse(StatusCodes.OFFER_PRICE_REJECTED.getStatusCode(),
								StatusCodes.OFFER_PRICE_REJECTED.getMessage(), notificationListResponse);
					}
				}
				// New car trade_in ENQUIRY created 
				else if (Constants.EVENT_NEW_SELLER_ENQUIRY.equals(eventName)) {
					notificationList.setStatus(Constants.ACTION_DONE);
					notificationListRepository.save(notificationList);
					if (approvedRequest.getIsAccepted()) {
						// saving notification list 
						notificationUtil.sendNotification(notificationTo,notificationFrom, Constants.EVENT_NEW_SELLER_ENQUIRY_ACCEPTED, userDevice, enquiry,
								negotiationRequest, Constants.ACCEPTED);
						
						notificationList = notificationListRepository.getLatestEnquiry(approvedRequest.getEnquiryNumber());
						notificationListResponse = createNotificationListResponse(notificationList);
						return new UtrustResponse(StatusCodes.NEW_CAR_SELLEER_ENQ_ACCEPTED.getStatusCode(),
								StatusCodes.NEW_CAR_SELLEER_ENQ_ACCEPTED.getMessage(), notificationListResponse);
					} else {
						// saving notification list 
						notificationUtil.sendNotification(notificationTo,notificationFrom, Constants.EVENT_NEW_SELLER_ENQUIRY_REJECTED, userDevice, enquiry,
								negotiationRequest, Constants.REJECTED);
						
						notificationList = notificationListRepository.getLatestEnquiry(approvedRequest.getEnquiryNumber());
						notificationListResponse = createNotificationListResponse(notificationList);
						return new UtrustResponse(StatusCodes.NEW_CAR_SELLEER_ENQ_REJECTED.getStatusCode(),
								StatusCodes.NEW_CAR_SELLEER_ENQ_REJECTED.getMessage(), notificationListResponse);
					}
				}
				// New car trade in allocation to PO
				if (Constants.EVENT_ALLOCATION_PO.equals(eventName)) {
					notificationList.setStatus(Constants.ACTION_DONE);
					notificationListRepository.save(notificationList);
					if (approvedRequest.getIsAccepted()) {
						// send notification to PO
						notificationUtil.sendNotification(notificationTo,notificationFrom, Constants.EVENT_ALLOCATION_PO_ACCEPTED, userDevice, enquiry,
								negotiationRequest, Constants.ACCEPTED);
						
						notificationList = notificationListRepository.getLatestEnquiry(approvedRequest.getEnquiryNumber());
						notificationListResponse = createNotificationListResponse(notificationList);
						return new UtrustResponse(StatusCodes.NEW_CAR_SELLER_ENQ_ALLOCATION_ACCEPTED.getStatusCode(),
								StatusCodes.NEW_CAR_SELLER_ENQ_ALLOCATION_ACCEPTED.getMessage(), notificationListResponse);
					} else {
						// send notification to PO
						notificationUtil.sendNotification(notificationTo,notificationFrom, Constants.EVENT_ALLOCATION_PO_REJECTED, userDevice, enquiry,
								negotiationRequest, Constants.REJECTED);
						
						notificationList = notificationListRepository.getLatestEnquiry(approvedRequest.getEnquiryNumber());
						notificationListResponse = createNotificationListResponse(notificationList);
						return new UtrustResponse(StatusCodes.NEW_CAR_SELLER_ENQ_ALLOCATION_REJECTED.getStatusCode(),
								StatusCodes.NEW_CAR_SELLER_ENQ_ALLOCATION_REJECTED.getMessage(), notificationListResponse);
					}
				}
				// Initial Offer price approval
				if (Constants.EVENT_INITIAL_OFFER_PRICE_APPROVAL_FROM_PO.equals(eventName)) {
					notificationList.setStatus(Constants.ACTION_DONE);
					notificationListRepository.save(notificationList);
					if (approvedRequest.getIsApproved()) {
						// send notification to PO
						notificationUtil.sendNotification(notificationTo,notificationFrom, Constants.EVENT_INITIAL_OFFER_PRICE_APPROVED, userDevice, enquiry,
								negotiationRequest, Constants.APPROVED);
						
						notificationList = notificationListRepository.getLatestEnquiry(approvedRequest.getEnquiryNumber());
						notificationListResponse = createNotificationListResponse(notificationList);
						return new UtrustResponse(StatusCodes.INITIAL_OFFER_APPROVED.getStatusCode(),
								StatusCodes.INITIAL_OFFER_APPROVED.getMessage(), notificationListResponse);
					} else {
						// saving notification list 
						notificationUtil.sendNotification(notificationTo,notificationFrom, Constants.EVENT_INITIAL_OFFER_PRICE_REJECTED, userDevice, enquiry,
								negotiationRequest, Constants.REJECTED);
						
						notificationList = notificationListRepository.getLatestEnquiry(approvedRequest.getEnquiryNumber());
						notificationListResponse = createNotificationListResponse(notificationList);
						return new UtrustResponse(StatusCodes.INITIAL_OFFER_REJECTED.getStatusCode(),
								StatusCodes.INITIAL_OFFER_REJECTED.getMessage(), notificationListResponse);
					}
				}
				return new UtrustResponse(StatusCodes.NO_ACTION_AVAILABLE.getStatusCode(),
						StatusCodes.NO_ACTION_AVAILABLE.getMessage());
			}else {
				return new UtrustResponse(StatusCodes.ENQUIRY_NOT_FOUND.getStatusCode(),
						StatusCodes.ENQUIRY_NOT_FOUND.getMessage());
			}
		}catch(Exception e) {
			logger.error("ApprovedRequest request body ::"+approvedRequest+"\n"+Constants.EXCEPTION,e);
			return new UtrustResponse(StatusCodes.APPROVAL_REQUEST_FAIL.getStatusCode(),
					StatusCodes.APPROVAL_REQUEST_FAIL.getMessage());
		}
	}
	

	/**
	 * creating one NotificationListResponse object by accepting NotificationList object
	 * 
	 * @author BIKASH
	 * @param notificationList
	 * @return notificationListResponse
	 */
	private NotificationListResponse createNotificationListResponse(NotificationList notificationList) {
		NotificationListResponse notificationListResponse = null;
		int actionFlag = 0;
		try {
			if(notificationList != null) {
				notificationListResponse = new NotificationListResponse();
				
				actionFlag = getActionFlag(notificationList.getStatus(), notificationList);
				notificationListResponse.setAction(actionFlag);
				notificationListResponse.setNotificationId(notificationList.getId());
				notificationListResponse.setActionType(notificationList.getNotificationMaster().getAction());
				notificationListResponse.setCreatedAt(notificationList.getCreatedAt());
				notificationListResponse.setNotificationMasterId(notificationList.getNotificationMaster().getNotificationMasterId());
				notificationListResponse.setNotificationMsg(notificationList.getNotificationMsg());
				notificationListResponse.setSeen(notificationList.getSeen());
				notificationListResponse.setEnquiryNumber(notificationList.getEnquiryNumber());
				notificationListResponse.setNotificationFromUser(notificationList.getFromUser());
				notificationListResponse.setNotificationToUser(notificationList.getToUser());
				
				return notificationListResponse;
			}
			return null;
		}catch(Exception e) {
			logger.error("NotificationList ::"+notificationList+"\n"+Constants.EXCEPTION,e);
			throw e;
		}
	}

	/**
	 * Reusable method for getting ResponseEntity of Enquiry Object
	 * 
	 * @param enquiry
	 * @return EnquiryResponse
	 */
	private EnquiryResponse createEnquiryResponse(Enquiry enquiry,User loggedInUser) {
		BasicDetailsResponse basicResponse = null;
		List<CustomerAddressResponse> customerAddressResponseList = new ArrayList<>();
		CustomerAddressResponse customerAddressResponse = null;
		CustomerResponse customerResponse = null;
		VehicleResponse vehicleResponse = null;
		EnquiryResponse enquiryResponse = null;
		EnquiryDetails enquiryDetails = null;
		NegotiationResponse negotiationResponse = null;
		FollowUpResponse followUpResponse = null;
		ProcurementResponse procurementResponse = null;
		
		Vehicle vehicle = null;
		Customer customer = null;
		List<CustomerAddress> customerAddrList = null;
		Variant variant = null;
		Model model = null;
		Make make = null;
		ExteriorColor color = null;
		StatusReasoning statusReason = null;
		SourceName sourceName = null;
		DemandStructure demandStructure = null;
		Channel channel = null;
		SourceType sourceType = null;
		SellingReason sellingReason = null;
		FollowUp followUp = null;
		EnquiryType enquiryType = null;
		InsuranceType insuranceType = null;

		boolean isNew = false;

		if (enquiry != null) {
			basicResponse = new BasicDetailsResponse();
			BeanUtils.copyProperties(enquiry, basicResponse);
			
			basicResponse.setEnquiryDate(enquiry.getCreatedAt());
			procurementResponse = new ProcurementResponse();
			procurementResponse.setAadhaarNumber(enquiry.getAadhaarNumber());
			customer = enquiry.getCustomer();
			if (customer != null) {
				customerAddrList = customer.getCustomerAddrList();
				if (customerAddrList != null) {
					for (CustomerAddress custAddr : customerAddrList) {
						customerAddressResponse = new CustomerAddressResponse();
						BeanUtils.copyProperties(custAddr, customerAddressResponse);
						customerAddressResponseList.add(customerAddressResponse);
					}
				}
			}
			customerResponse = new CustomerResponse();
			customerResponse.setCustomerAddressList(customerAddressResponseList);
			BeanUtils.copyProperties(customer, customerResponse);
			basicResponse.setCustomer(customerResponse);

			vehicle = enquiry.getVehicle();
			if (vehicle != null) {
				vehicleResponse = new VehicleResponse();
				BeanUtils.copyProperties(vehicle, vehicleResponse);
				variant = vehicle.getVariant();
				model = vehicle.getModel();
				make = vehicle.getMake();
				color = vehicle.getExteriorColor();
				insuranceType = vehicle.getInsuranceType();
				if (variant != null) {
					VariantResponse variantResponse = new VariantResponse();
					BeanUtils.copyProperties(variant, variantResponse);
					vehicleResponse.setVariantResponse(variantResponse);
				}
				if (model != null) {
					ModelResponse modelResponse = new ModelResponse();
					BeanUtils.copyProperties(model, modelResponse);
					vehicleResponse.setModelResponse(modelResponse);
				}
				if (make != null) {
					MakeResponse makeResponse = new MakeResponse();
					BeanUtils.copyProperties(make, makeResponse);
					vehicleResponse.setMakeResponse(makeResponse);
				}
				if (color != null) {
					ExteriorColorResponse colorResponse = new ExteriorColorResponse();
					BeanUtils.copyProperties(color, colorResponse);
					vehicleResponse.setExteriorColorResponse(colorResponse);
				}
				if (insuranceType != null) {
					InsuranceTypeResponse insuranceTypeResponse = new InsuranceTypeResponse();
					BeanUtils.copyProperties(insuranceType, insuranceTypeResponse);
					vehicleResponse.setInsuranceTypeResponse(insuranceTypeResponse);
				}
			}
			// setting basic details for ENQUIRY
			statusReason = enquiry.getStatusReasoning();
			sourceName = enquiry.getSourceName();
			demandStructure = enquiry.getDemandStructure();
			channel = enquiry.getChannel();
			sourceType = enquiry.getSourceType();
			sellingReason = enquiry.getSellingReasoning();
			enquiryType = enquiry.getEnquiryType();
			boolean isFollowUpFlag = false;

			if (statusReason != null) {
				StatusReasoningResponse statusReasoningResponse = new StatusReasoningResponse();
				BeanUtils.copyProperties(statusReason, statusReasoningResponse);
				basicResponse.setStatusReasoning(statusReasoningResponse);
			}
			if (sourceName != null) {
				SourceNameResponse sourceNameResponse = new SourceNameResponse();
				BeanUtils.copyProperties(sourceName, sourceNameResponse);
				basicResponse.setSourceName(sourceNameResponse);
			}
			if (demandStructure != null) {
				DemandStructureResponse demandStructureResponse = new DemandStructureResponse();
				BeanUtils.copyProperties(demandStructure, demandStructureResponse);
				basicResponse.setDemandStructure(demandStructureResponse);
			}
			if (channel != null) {
				ChannelResponse channelResponse = new ChannelResponse();
				BeanUtils.copyProperties(channel, channelResponse);
				basicResponse.setChannel(channelResponse);
			}
			if (sourceType != null) {
				SourceTypeResponse sourceTypeResponse = new SourceTypeResponse();
				BeanUtils.copyProperties(sourceType, sourceTypeResponse);
				basicResponse.setSourceType(sourceTypeResponse);
			}
			if (sellingReason != null) {
				SellingReasonResponse sellingReasonResponse = new SellingReasonResponse();
				BeanUtils.copyProperties(sellingReason, sellingReasonResponse);
				basicResponse.setSellingReason(sellingReasonResponse);
			}
			if (enquiryType != null) {
				EnquiryTypeResponse enquiryTypeResponse = new EnquiryTypeResponse();
				BeanUtils.copyProperties(enquiryType, enquiryTypeResponse);
				basicResponse.setEnquiryType(enquiryTypeResponse);
			}

			// setting weather follow up is new or not
			List<Object[]> objectList=followUpRepository.getLatestFollowUpByEnquiry(enquiry.getEnquiryNumber());
			
			followUpResponse = new FollowUpResponse();
			if (!objectList.isEmpty()) {
				for (Object[] object : objectList) {
					followUp = new FollowUp();
					followUp.setFollowUpId((int) object[1]);
					followUp.setEnquiryNumber(object[2].toString());

					if (object[3] != null) {
						followUp.setActualRemark(object[3].toString());
					}
					if (object[4] != null) {
						followUp.setActualDetailRemark(object[4].toString());
					}
					followUp.setActualDate((Date) (object[5]));

					if (object[6] != null) {
						followUp.setNextRemark(object[6].toString());
					}
					if (object[7] != null) {
						followUp.setNextDetailRemark(object[7].toString());
					}
					followUp.setNextDate((Date) object[8]);
					if (!(Constants.DROPPED.equals(object[0].toString())
							|| Constants.SUCCESS.equals(object[0].toString()))) {
						isFollowUpFlag = true;
					}
				}
				followUpResponse = createFollowUpResponse(followUp);
				followUpResponse.setFollowUp(isFollowUpFlag);
			}else {
				isNew = true;
			}
			basicResponse.setNewFollowup(isNew);
			enquiryResponse = new EnquiryResponse();
			enquiryDetails = new EnquiryDetails();

			User assignedUser=userRepository.getUserDetails(enquiry.getAssignTo());
			boolean isPo=false;
			boolean isPtl=false;
			//find the logged in user role
			if (Constants.PO_ROLE == assignedUser.getUserRoleId()) {
				isPo=true;
			} 
			else if (Constants.PTL_ROLE == assignedUser.getUserRoleId()) {
				isPtl=true;
			 }
			    Dealer assignedDealer = assignedUser.getDealer();
				enquiryDetails.setDealerCode(assignedDealer.getDealerCode());
				enquiryDetails.setDealerName(assignedDealer.getDealerName());
				enquiryDetails.setDealerLocation(assignedDealer.getDealerLocation());
				enquiryDetails.setBranchCode(assignedDealer.getBranchCode());
			
			if (isPo) {
				enquiryDetails.setPoId(assignedUser.getUctdmsId());
				enquiryDetails.setPoName(assignedUser.getFirstName());
				User ptlUser=userRepository.getUserDetails(assignedUser.getReportingTo());// fetch PTL
				
				if (ptlUser!=null) {
					enquiryDetails.setPtlId(ptlUser.getUctdmsId());
					enquiryDetails.setPtlName(ptlUser.getFirstName());
				}
				User ucmUser=userRepository.getUserDetails(ptlUser.getReportingTo());// fetch UCM 
				
				if (ucmUser!=null) {
					enquiryDetails.setUcmId(ucmUser.getUctdmsId());
					enquiryDetails.setUcmName(ucmUser.getFirstName());
				}

			}
			else if (isPtl) {
				enquiryDetails.setPtlId(assignedUser.getUctdmsId());
				enquiryDetails.setPtlName(assignedUser.getFirstName());
				User ucmUser = userRepository.getUserDetails(assignedUser.getReportingTo());// fetch UCM
				if (ucmUser != null) {
					enquiryDetails.setUcmId(ucmUser.getUctdmsId());
					enquiryDetails.setUcmName(ucmUser.getFirstName());
				}
			}
		
			enquiryResponse.setEnquiryDetails(enquiryDetails);
			enquiryResponse.setBasicDetails(basicResponse);
			enquiryResponse.setVehicle(vehicleResponse);
			enquiryResponse.setFollowUp(followUpResponse);
			enquiryResponse.setProcurement(procurementResponse); 
			
		 	Dealer loggedIndealer = loggedInUser.getDealer();
 			
			if (loggedIndealer.getDealerCode()==assignedDealer.getDealerCode()) {
				NegotiationHistory negotiationHistory = negotiationHistoryRepository.findByEnqNumber(enquiry.getEnquiryNumber());
				negotiationResponse = new NegotiationResponse();
				negotiationResponse.setExpectedOffer(enquiry.getExpectedOffer());
				negotiationResponse.setActualPrice(enquiry.getActualPrice());
				negotiationResponse.setSuggestedPrice(enquiry.getSuggestedPrice());
				if (negotiationHistory != null) {
					negotiationResponse.setLatestExpectedPrice(negotiationHistory.getLatestExpectedPrice());
					negotiationResponse.setLatestOfferPrice(negotiationHistory.getLatestOfferPrice());
					negotiationResponse.setPtlRemarks(negotiationHistory.getPtlRemark());
				}
			}
			enquiryResponse.setNegotiation(negotiationResponse);

		}
		return enquiryResponse;
	}

	/**
	 * Reusable method for creating FollowUp response object
	 * 
	 * @param followUp object
	 * @return FollowUpResponse
	 */
	private FollowUpResponse createFollowUpResponse(FollowUp followUp) {
		FollowUpResponse followUpResponse = null;
		ActualFollowUpResponse actualFollowUpResponse = null;
		NextFollowUpResponse nextFollowUpResponse = null;

		if(followUp!=null) {
			followUpResponse = new FollowUpResponse();
			actualFollowUpResponse = new ActualFollowUpResponse();
			actualFollowUpResponse.setDetailFollowUpRemark(followUp.getActualDetailRemark());
			actualFollowUpResponse.setFollowUpDate(followUp.getActualDate());
			actualFollowUpResponse.setFollowUpRemark(followUp.getActualRemark());

			nextFollowUpResponse = new NextFollowUpResponse();
			nextFollowUpResponse.setDetailFollowUpRemark(followUp.getNextDetailRemark());
			nextFollowUpResponse.setFollowUpDate(followUp.getNextDate());
			nextFollowUpResponse.setFollowUpRemark(followUp.getNextRemark());

			followUpResponse.setActualFollowUp(actualFollowUpResponse);
			followUpResponse.setNextFollowUp(nextFollowUpResponse);
			followUpResponse.setFollowUpId(followUp.getFollowUpId());
			followUpResponse.setEnquiryNumber(followUp.getEnquiryNumber());
		}

		return followUpResponse;
	}

	@Override
	@Transactional
	public UtrustResponse getEnquiryDetails(String enquiryNumber,  HttpServletRequest request) {
		Enquiry enquiry = null;
		EnquiryResponse enquiryResponse = null;
		Integer uctdmsId =null;
		User user = null;
		try {
			logger.info("Inside getEnquiryDetails service");
			if (request.getHeader(Constants.UCTDMS_ID) != null) {
				uctdmsId = Integer.parseInt(request.getHeader(Constants.UCTDMS_ID));
			    user = userRepository.getUserDetails(uctdmsId);

				if (user==null) {
					return new UtrustResponse(StatusCodes.UCTDMS_ID_NOT_FOUND.getStatusCode(),
							StatusCodes.UCTDMS_ID_NOT_FOUND.getMessage(), null);
				}
			}
			else {
				return new UtrustResponse(StatusCodes.UCTDMS_ID_NOT_EXISTS.getStatusCode(),
						StatusCodes.UCTDMS_ID_NOT_EXISTS.getMessage(), null);
			}
			enquiry = enquiryRepository.getEnquiry(enquiryNumber);
			// getting one EnquiryResponse object
			enquiryResponse = createEnquiryResponse(enquiry,user);
			logger.info("Enquiry Response :" + enquiryResponse);
			if (enquiryResponse != null) {
				return new UtrustResponse(StatusCodes.GET_ENQUIRY_DATA_SUCCESS.getStatusCode(),
						StatusCodes.GET_ENQUIRY_DATA_SUCCESS.getMessage(), enquiryResponse);
			} else {
				return new UtrustResponse(StatusCodes.GET_ENQUIRY_DATA_FAIL.getStatusCode(),
						StatusCodes.GET_ENQUIRY_DATA_FAIL.getMessage(), null);
			}
		} catch (Exception e) {
			logger.error(Constants.EXCEPTION + " enquiryNumber ::"+ enquiryNumber , e);
			return new UtrustResponse(StatusCodes.ENQUIRY_NOT_FOUND.getStatusCode(),
					StatusCodes.ENQUIRY_NOT_FOUND.getMessage(), null);
		}
	}
	
	@Override
	@Transactional
	public UtrustResponse assignEnquiry(EnquiryAssignRequest enquiryAssignRequest, HttpServletRequest request) {

		Enquiry enquiryVal = null;
		Integer uctdmsId = null;
		User user = null;
		try {
			logger.info("Inside assignEnquiery service");
			if (request.getHeader(Constants.UCTDMS_ID) != null) {
				uctdmsId = Integer.parseInt(request.getHeader(Constants.UCTDMS_ID));
			    user = userRepository.getUserDetails(uctdmsId);

				if (user==null) {
					return new UtrustResponse(StatusCodes.UCTDMS_ID_NOT_FOUND.getStatusCode(),
							StatusCodes.UCTDMS_ID_NOT_FOUND.getMessage(), null);
				}
			}
			else {
				return new UtrustResponse(StatusCodes.UCTDMS_ID_NOT_EXISTS.getStatusCode(),
						StatusCodes.UCTDMS_ID_NOT_EXISTS.getMessage(), null);
			}
			if (enquiryAssignRequest != null) {
				enquiryVal = enquiryRepository.getEnquiry(enquiryAssignRequest.getEnquiryNumber());
			}
			if (enquiryVal != null) {
				enquiryVal.setAssignTo(enquiryAssignRequest.getAssigenedTo());
				enquiryVal.setAssigenedby(uctdmsId);
				enquiryVal.setModifiedat(new Date());
				enquiryVal.setModifiedby(uctdmsId);
				enquiryRepository.save(enquiryVal);

				// Send push notification to assigned PO 
				UserDevice userDevice=deviceRepository.getUserDevice(uctdmsId);
				if(Constants.NEW_CAR_TRADE_IN.equals(enquiryVal.getSourceType().getName())) {
					notificationUtil.sendNotification(uctdmsId,enquiryAssignRequest.getAssigenedTo(),Constants.EVENT_ALLOCATION_PO,userDevice,enquiryVal,null,null);
				}else {
					//alert to PO
					notificationUtil.sendNotification(uctdmsId,enquiryAssignRequest.getAssigenedTo(),Constants.EVENT_SELLER_ENQ_ALLOCATION_PO,userDevice,enquiryVal,null,null);
				}
				return new UtrustResponse(StatusCodes.ENQUIRY_ASSIGN_SUCCESS.getStatusCode(),
						StatusCodes.ENQUIRY_ASSIGN_SUCCESS.getMessage(), null);
			} else {
				return new UtrustResponse(StatusCodes.ENQUIRY_NOT_FOUND.getStatusCode(),
						StatusCodes.ENQUIRY_NOT_FOUND.getMessage(), null);
			}

		} catch (Exception e) {
			logger.error(Constants.EXCEPTION + " enquiryAssignRequest : "+enquiryAssignRequest +" uctdmsId : "+uctdmsId , e);
			return new UtrustResponse(StatusCodes.ENQUIRY_ASSIGN_FAIL.getStatusCode(),
					StatusCodes.ENQUIRY_ASSIGN_FAIL.getMessage(), null);
		}

	}

	@Override
	@Transactional
	public UtrustResponse searchEnquiry(SearchEnquiryRequest enquiryRequest, HttpServletRequest request) {
		Integer uctdmsId = null;
		User user = null;
		try {
			logger.info("Inside searchEnquiry service");
			if (request.getHeader(Constants.UCTDMS_ID) != null) {
				uctdmsId = Integer.parseInt(request.getHeader(Constants.UCTDMS_ID));
			    user = userRepository.getUserDetails(uctdmsId);

				if (user==null) {
					return new UtrustResponse(StatusCodes.UCTDMS_ID_NOT_FOUND.getStatusCode(),
							StatusCodes.UCTDMS_ID_NOT_FOUND.getMessage(), null);
				}
			}
			else {
				return new UtrustResponse(StatusCodes.UCTDMS_ID_NOT_EXISTS.getStatusCode(),
						StatusCodes.UCTDMS_ID_NOT_EXISTS.getMessage(), null);
			}
			List<EnquiryResponse> enquiryResponse = null;
			List<Vehicle> vehicleList = null;
			List<Enquiry> enquiryList = new ArrayList<>();
			// search for mobile number and registration number both
			if(enquiryRequest.getMobileNumber() != null && enquiryRequest.getRegistrationNumber() != null) {
				List<List<Enquiry>> listOfEnquiries = new ArrayList<>();
				List<Enquiry> enqList = enquiryRepository.getEnquiryListByMobileAndRegistrationNumber(enquiryRequest.getMobileNumber(),enquiryRequest.getRegistrationNumber());
				listOfEnquiries.add(enqList);
				for (List<Enquiry> enquiries : listOfEnquiries) {
					enquiryList.addAll(enquiries);
				}
			}
			// search by mobile number
			else if (enquiryRequest.getMobileNumber() != null) {
				List<List<Enquiry>> listOfEnquiries = new ArrayList<>();
				List<Customer> customerList = enquiryRepository.getEnquiryListByMobile(enquiryRequest.getMobileNumber());
				for (Customer customer : customerList) {
					listOfEnquiries.add(customer.getListEnquiry());
				}
				for (List<Enquiry> enquiries : listOfEnquiries) {
					enquiryList.addAll(enquiries);
				}
			}
			// search by registration number
			else if (enquiryRequest.getRegistrationNumber() != null) {
				List<List<Enquiry>> listOfEnquiries = new ArrayList<>();
				vehicleList = enquiryRepository.getEnquiryListByRegNumber(enquiryRequest.getRegistrationNumber());
				for (Vehicle vehicle : vehicleList) {
					listOfEnquiries.add(vehicle.getEnquiryList());
				}
				for (List<Enquiry> enquiries : listOfEnquiries) {
					enquiryList.addAll(enquiries);
				}
			}
			// search any name
			else if (enquiryRequest.getName() != null && !enquiryRequest.getName().trim().equals("")) {
				List<List<Enquiry>> listOfEnquiries = new ArrayList<>();
				String str[] =enquiryRequest.getName().split(" ");
				List<Customer> customerList = null;
				if(str.length>1) {
					// combination of first name and last name or corporateName
					customerList = enquiryRepository.getEnquiryListByFirstAndLastName(str[0],str[1],enquiryRequest.getName());
				}else {
					// only by first name or last name or corporate name 
					customerList = enquiryRepository.getEnquiryListByAnyName(str[0]);
				}
				for (Customer customer : customerList) {
					listOfEnquiries.add(customer.getListEnquiry());
				}
				for (List<Enquiry> enquirys : listOfEnquiries) {
					enquiryList.addAll(enquirys);
				}
			}
			// show all collected data 
			enquiryResponse = new ArrayList<>();
			for (Enquiry enquiry : enquiryList) {
				enquiryResponse.add(createEnquiryResponse(enquiry,user));
			}
			
			if(enquiryResponse.isEmpty()) {
				return new UtrustResponse(StatusCodes.CUSTOMER_NOT_EXIST.getStatusCode(),
						StatusCodes.CUSTOMER_NOT_EXIST.getMessage());
			}
			
			Map<String, List<EnquiryResponse>> map = new HashMap<>();
			map.put("searchList", enquiryResponse);
			return new UtrustResponse(StatusCodes.ENQUIRY_SEARCH_SUCCESS.getStatusCode(),
					StatusCodes.ENQUIRY_SEARCH_SUCCESS.getMessage(), map);

		} catch (Exception e) {
			logger.error(Constants.EXCEPTION + " SearchEnquiryRequest : "+enquiryRequest, e);
			return new UtrustResponse(StatusCodes.ENQUIRY_SEARCH_FAIL.getStatusCode(),
					StatusCodes.ENQUIRY_SEARCH_FAIL.getMessage(), null);
		}
	}

	@Override
	@Transactional
	public UtrustResponse getTemporaryRegistrationNumber(HttpServletRequest request) {
		String tempRegNumber = null, finalTemporaryRegNumber = null;
		TemporaryVehicle temporaryVehicle = new TemporaryVehicle();
		int systemYear = 0;
		Integer uctdmsId = null;
		User user = null;
		try {
			logger.info("Inside getTemporaryRegistrationNumber service");
			if (request.getHeader(Constants.UCTDMS_ID) != null) {
				uctdmsId = Integer.parseInt(request.getHeader(Constants.UCTDMS_ID));
			    user = userRepository.getUserDetails(uctdmsId);

				if (user==null) {
					return new UtrustResponse(StatusCodes.UCTDMS_ID_NOT_FOUND.getStatusCode(),
							StatusCodes.UCTDMS_ID_NOT_FOUND.getMessage(), null);
				}
			}
			else {
				return new UtrustResponse(StatusCodes.UCTDMS_ID_NOT_EXISTS.getStatusCode(),
						StatusCodes.UCTDMS_ID_NOT_EXISTS.getMessage(), null);
			}
			tempRegNumber = enquiryEntityManager.getTemporaryRegNumber();
			logger.info("temporary reg number from db :" + tempRegNumber);
			Calendar now = Calendar.getInstance();
			systemYear = now.get(Calendar.YEAR);
			temporaryVehicle.setCreatedAt(new Date());
			temporaryVehicle.setCreatedBy(uctdmsId);
			Map<String,String> map = new HashMap<>();
			
			if (tempRegNumber == null) {
				tempRegNumber = Constants.TKM + systemYear + Constants.INITIAL_NUMBER;
				temporaryVehicle.setTempRegistraionNumber(tempRegNumber);
				enquiryEntityManager.saveTemporaryRegNumber(temporaryVehicle);
				map.put(Constants.TEMPORARY_REG_NUMBER, tempRegNumber);
				
				return new UtrustResponse(StatusCodes.TEMPORARY_REGISTRATION_NUMBER_SUCCESS.getStatusCode(),
						StatusCodes.TEMPORARY_REGISTRATION_NUMBER_SUCCESS.getMessage(), map);
			} else {
				int year = 0, counter = 0;
				String newCounter = null;

				year = Integer.parseInt(tempRegNumber.substring(3, 7));
				counter = Integer.parseInt(tempRegNumber.substring(7));
				counter++;
				newCounter = String.format("%04d", counter);

				if (year != systemYear) {
					newCounter = Constants.INITIAL_NUMBER;
					year = systemYear;
				}

				finalTemporaryRegNumber = Constants.TKM + year + newCounter;
				logger.info("new temporary reg number :" + finalTemporaryRegNumber);
				temporaryVehicle.setTempRegistraionNumber(finalTemporaryRegNumber);
				enquiryEntityManager.saveTemporaryRegNumber(temporaryVehicle);
				map.put(Constants.TEMPORARY_REG_NUMBER, finalTemporaryRegNumber);
				
				return new UtrustResponse(StatusCodes.TEMPORARY_REGISTRATION_NUMBER_SUCCESS.getStatusCode(),
						StatusCodes.TEMPORARY_REGISTRATION_NUMBER_SUCCESS.getMessage(), map);
			}

		} catch (Exception e) {
			logger.error(Constants.EXCEPTION , e);
			return new UtrustResponse(StatusCodes.TEMPORARY_REGISTRATION_NUMBER_FAIL.getStatusCode(),
					StatusCodes.TEMPORARY_REGISTRATION_NUMBER_FAIL.getMessage(), null);
		}
	}

	@Override
	@Transactional
	public UtrustResponse getFollowUpDetailsByEnquiryNumber(String enquiryNumber, HttpServletRequest request) {
		List<FollowUp> followUpList = null;

		List<FollowUpResponse> followUpResponseList = new ArrayList<>();
		FollowUpEntityResponse followUpEntityResponse = null;
		FollowUpResponse followUpResponse = null;
		Integer uctdmsId = null;
		User user = null;

		try {
			logger.info("Inside getFollowUpDetailsByEnquiryNumber service");
			if (request.getHeader(Constants.UCTDMS_ID) != null) {
				uctdmsId = Integer.parseInt(request.getHeader(Constants.UCTDMS_ID));
			    user = userRepository.getUserDetails(uctdmsId);

				if (user==null) {
					return new UtrustResponse(StatusCodes.UCTDMS_ID_NOT_FOUND.getStatusCode(),
							StatusCodes.UCTDMS_ID_NOT_FOUND.getMessage(), null);
				}
			}
			else {
				return new UtrustResponse(StatusCodes.UCTDMS_ID_NOT_EXISTS.getStatusCode(),
						StatusCodes.UCTDMS_ID_NOT_EXISTS.getMessage(), null);
			}
			followUpList = followUpRepository.getFollowUp(enquiryNumber);
			if (followUpList != null && !(followUpList.isEmpty())) {
				for (FollowUp followUp : followUpList) {
					followUpResponse = createFollowUpResponse(followUp);
					followUpResponseList.add(followUpResponse);
				}
				followUpEntityResponse = new FollowUpEntityResponse();
				followUpEntityResponse.setFollowUpList(followUpResponseList);

				logger.info("End of followup.." + followUpResponse);
				return new UtrustResponse(StatusCodes.FOLLOW_UP_RETRIEVE_SUCCESS.getStatusCode(),
						StatusCodes.FOLLOW_UP_RETRIEVE_SUCCESS.getMessage(), followUpEntityResponse);
			}
			return new UtrustResponse(StatusCodes.FOLLOW_UP_RETRIEVE_FAIL.getStatusCode(),
					StatusCodes.FOLLOW_UP_RETRIEVE_FAIL.getMessage(), null);
		} catch (Exception e) {
			logger.error(Constants.EXCEPTION + " enquiryNumber : "+enquiryNumber , e);
			return new UtrustResponse(StatusCodes.ENQUIRY_NOT_FOUND.getStatusCode(),
					StatusCodes.ENQUIRY_NOT_FOUND.getMessage(), null);
		}
	}

	@Override
	@Transactional
	public UtrustResponse getUserFollowUpDetailsByPO(Integer poId, HttpServletRequest request) {

		List<Enquiry> enquiryList = null;
		FollowUp followUp = null;

		List<FollowUpResponse> followUpResponseList = new ArrayList<>();
		FollowUpEntityResponse followUpEntityResponse = null;
		FollowUpResponse followUpResponse = null;
		Integer uctdmsId = null;
		User user = null;

		try {
			logger.info("Inside getUserFollowUpDetailsByPO service");
			if (request.getHeader(Constants.UCTDMS_ID) != null) {
				uctdmsId = Integer.parseInt(request.getHeader(Constants.UCTDMS_ID));
			    user = userRepository.getUserDetails(uctdmsId);

				if (user==null) {
					return new UtrustResponse(StatusCodes.UCTDMS_ID_NOT_FOUND.getStatusCode(),
							StatusCodes.UCTDMS_ID_NOT_FOUND.getMessage(), null);
				}
			}
			else {
				return new UtrustResponse(StatusCodes.UCTDMS_ID_NOT_EXISTS.getStatusCode(),
						StatusCodes.UCTDMS_ID_NOT_EXISTS.getMessage(), null);
			}
			enquiryList = enquiryRepository.getFollowUpByPO(poId);
			if (enquiryList != null && !(enquiryList.isEmpty())) {
				for (Enquiry enquiry : enquiryList) {
					followUp = followUpRepository.getLatestFollowUp(enquiry.getEnquiryNumber());
					followUpResponse = createFollowUpResponse(followUp);
					followUpResponseList.add(followUpResponse);
				}
				followUpEntityResponse = new FollowUpEntityResponse();
				followUpEntityResponse.setFollowUpList(followUpResponseList);

				logger.info("user followup response :" + followUpResponse);
				return new UtrustResponse(StatusCodes.USER_FOLLOW_UP_RETRIEVE_SUCCESS.getStatusCode(),
						StatusCodes.USER_FOLLOW_UP_RETRIEVE_SUCCESS.getMessage(), followUpEntityResponse);
			}
			return new UtrustResponse(StatusCodes.USER_FOLLOW_UP_RETRIEVE_FAIL.getStatusCode(),
					StatusCodes.USER_FOLLOW_UP_RETRIEVE_FAIL.getMessage(), null);
		} catch (Exception e) {
			logger.error(Constants.EXCEPTION + " poId :" + poId, e);
			return new UtrustResponse(StatusCodes.ENQUIRY_NOT_FOUND.getStatusCode(),
					StatusCodes.ENQUIRY_NOT_FOUND.getMessage(), null);
		}
	}

	@Override
	@Transactional
	public UtrustResponse saveNewCarLink(NewCarLinkRequest newCarRequest, HttpServletRequest request) {
		Integer uctdmsId = null;
		User user = null;
		try {
			logger.info("from saveNewCarLink :" + newCarRequest);
			if (request.getHeader(Constants.UCTDMS_ID) != null) {
				uctdmsId = Integer.parseInt(request.getHeader(Constants.UCTDMS_ID));
			    user = userRepository.getUserDetails(uctdmsId);

				if (user==null) {
					return new UtrustResponse(StatusCodes.UCTDMS_ID_NOT_FOUND.getStatusCode(),
							StatusCodes.UCTDMS_ID_NOT_FOUND.getMessage(), null);
				}
			}
			else {
				return new UtrustResponse(StatusCodes.UCTDMS_ID_NOT_EXISTS.getStatusCode(),
						StatusCodes.UCTDMS_ID_NOT_EXISTS.getMessage(), null);
			}
			if (newCarRequest != null) {
				if (enquiryRepository.updateNewCarEnquiryNumber(newCarRequest.getSellerEnquiryNumber(),
						newCarRequest.getNewCarEnquiryNumber()) > 0) {
					return new UtrustResponse(StatusCodes.UPDATE_NEW_ENQUIRY_NUMBER_SUCCESS.getStatusCode(),
							StatusCodes.UPDATE_NEW_ENQUIRY_NUMBER_SUCCESS.getMessage(), null);
				}
			}
			return new UtrustResponse(StatusCodes.UPDATE_NEW_ENQUIRY_NUMBER_FAIL.getStatusCode(),
					StatusCodes.UPDATE_NEW_ENQUIRY_NUMBER_FAIL.getMessage(), null);
		} catch (Exception e) {
			logger.error(Constants.EXCEPTION + e);
			return new UtrustResponse(StatusCodes.ENQUIRY_NOT_FOUND.getStatusCode(),
					StatusCodes.ENQUIRY_NOT_FOUND.getMessage(), null);
		}

	}

	@Override
	@Transactional
	public UtrustResponse getEnquiryListByUser(HttpServletRequest request) {
		List<EnquiryResponse> enquiryResponseList = new ArrayList<>();
		EnquiryResponse enquiryResponse = null;
		List<Enquiry> enquiryDetails = new ArrayList<>();
		Integer uctdmsId = null;
		User user = null;
		try {
			if (request.getHeader(Constants.UCTDMS_ID) != null) {
				uctdmsId = Integer.parseInt(request.getHeader(Constants.UCTDMS_ID));
			    user = userRepository.getUserDetails(uctdmsId);

				if (user==null) {
					return new UtrustResponse(StatusCodes.UCTDMS_ID_NOT_FOUND.getStatusCode(),
							StatusCodes.UCTDMS_ID_NOT_FOUND.getMessage(), null);
				}
			}
			else {
				return new UtrustResponse(StatusCodes.UCTDMS_ID_NOT_EXISTS.getStatusCode(),
						StatusCodes.UCTDMS_ID_NOT_EXISTS.getMessage(), null);
			}
			logger.info("Inside EnquiryServiceImpl getEnquiryList with poId: " + uctdmsId);

			if (user.getUserRoleId()==Constants.UCM_ROLE) {
				logger.info("uctdmsId " +uctdmsId+"UCM_ROLE:" +Constants.UCM_ROLE);
				enquiryDetails= enquiryRepository.getEnquiryListByUCM(uctdmsId,Constants.PTL_ROLE);
			}
			else if (user.getUserRoleId()==Constants.PTL_ROLE) {
				logger.info("uctdmsId " +uctdmsId+"PTL_ROLE:" +Constants.PTL_ROLE);
				enquiryDetails= enquiryRepository.getEnquiryListByPTL(uctdmsId,Constants.PO_ROLE);
			}
			else if (user.getUserRoleId()==Constants.PO_ROLE) {
				logger.info("uctdmsId " +uctdmsId+"PO_ROLE:" +Constants.PO_ROLE);
				enquiryDetails=	enquiryRepository.getEnquiryListByPO(uctdmsId);
			}
			/*enquiryDetails = enquiryRepository.getEnquiryListByPoId(uctdmsId,
					new PageRequest(0, 5, Direction.DESC, "created_by"));*/
			if ((enquiryDetails != null) && !(enquiryDetails.isEmpty())) {
				for (Enquiry enq : enquiryDetails) {
					enquiryResponse = new EnquiryResponse();
					enquiryResponse = createEnquiryResponse(enq,user);
					enquiryResponseList.add(enquiryResponse);
				}
			} 
			return new UtrustResponse(StatusCodes.ENQUIRY_LIST_RETRIEVE_SUCCESS.getStatusCode(),
					StatusCodes.ENQUIRY_LIST_RETRIEVE_SUCCESS.getMessage(), enquiryResponseList);
				
		} catch (Exception e) {
			logger.error(Constants.EXCEPTION+"uctdmsId :"+uctdmsId , e);
			return new UtrustResponse(StatusCodes.ENQUIRY_LIST_RETRIEVE_FAIL.getStatusCode(),
					StatusCodes.ENQUIRY_LIST_RETRIEVE_FAIL.getMessage(), null);
		}

	}

	@Override
	public UtrustResponse pricingData(VehicleRequest vehicleRequest, HttpServletRequest request) {
		Integer uctdmsId = null;
		User user = null;
		try {
			logger.info("Inside pricingData service");
			if (request.getHeader(Constants.UCTDMS_ID) != null) {
				uctdmsId = Integer.parseInt(request.getHeader(Constants.UCTDMS_ID));
				user = userRepository.getUserDetails(uctdmsId);

				if (user==null) {
					return new UtrustResponse(StatusCodes.UCTDMS_ID_NOT_FOUND.getStatusCode(),
							StatusCodes.UCTDMS_ID_NOT_FOUND.getMessage(), null);
				}
			}
			else {
				return new UtrustResponse(StatusCodes.UCTDMS_ID_NOT_EXISTS.getStatusCode(),
						StatusCodes.UCTDMS_ID_NOT_EXISTS.getMessage(), null);
			}
			
			boolean isInsurance=false;
			if (vehicleRequest.getInsuranceTypeId()==Constants.INSURANCE_THIRD_PARTY || vehicleRequest.getInsuranceTypeId()==Constants.INSURANCE_COMPREHENSIVE) {
				isInsurance=true;
			}
			
			PricingData pricingData = pricingDataRepository.getPricingData(vehicleRequest.getMakeId(),
					vehicleRequest.getModelId(), null, vehicleRequest.getFuelType(),
					vehicleRequest.getTransmissionType(), vehicleRequest.getYear(), vehicleRequest.isAccidental(),
					vehicleRequest.getExteriorColourId(), isInsurance, vehicleRequest.getPreviousOwners(),
					vehicleRequest.getVariantId());

			PricingDataResponse pricingDataResponse = new PricingDataResponse();
			if (pricingData != null) {
				pricingDataResponse.setFinalPriceRangeMin(pricingData.getFinalPriceRangeMin());
				pricingDataResponse.setFinalPriceRangeMax(pricingData.getFinalPriceRangeMax());
				pricingDataResponse.setFinalPriceRangeBestBuyMin(pricingData.getFinalPriceRangeBestBuyMin());
				pricingDataResponse.setFinalPriceRangeBestBuyMax(pricingData.getFinalPriceRangeBestBuyMax());
				pricingDataResponse.setTypicalInventoryDays(pricingData.getTypicalInventoryDays());
				pricingDataResponse.setSourcingPriceToyotaMin(pricingData.getSourcingPriceToyotaMin());
				pricingDataResponse.setSourcingPriceToyotaMax(pricingData.getSourcingPriceToyotaMax());
				pricingDataResponse.setRetailPriceToyotaMin(pricingData.getRetailPriceToyotaMin());
				pricingDataResponse.setRetailPriceToyotaMax(pricingData.getRetailPriceToyotaMax());
				pricingDataResponse.setMarketPriceC2CMin(pricingData.getMarketPriceC2CMin());
				pricingDataResponse.setMarketPriceC2CMax(pricingData.getMarketPriceC2CMax());
				pricingDataResponse.setMarketPriceB2CMin(pricingData.getMarketPriceB2CMin());
				pricingDataResponse.setMarketPriceB2BMax(pricingData.getMarketPriceB2CMax());
				return new UtrustResponse(StatusCodes.PRICING_DATA_RETRIEVE_SUCCESS.getStatusCode(),
						StatusCodes.PRICING_DATA_RETRIEVE_SUCCESS.getMessage(), pricingDataResponse);
			}else {
				return new UtrustResponse(StatusCodes.PRICING_DATA_RETRIEVE_FAIL.getStatusCode(),
						StatusCodes.PRICING_DATA_RETRIEVE_FAIL.getMessage(), null);
			}
		}
		catch(Exception e) {
			logger.error(Constants.EXCEPTION+"uctdmsId :"+uctdmsId , e);
			return new UtrustResponse(StatusCodes.PRICING_DATA_RETRIEVE_FAIL.getStatusCode(),
					StatusCodes.PRICING_DATA_RETRIEVE_FAIL.getMessage(), null);
		}
	}
	@Override
	@Transactional
	public UtrustResponse getEnquiryTimelineDetails(String enquiryNumber, HttpServletRequest request) {
		Integer uctdmsId = null;
		User user = null;
		try {
			logger.info("Inside getEnquiryTimelineDetails service");
			if (request.getHeader(Constants.UCTDMS_ID) != null) {
				uctdmsId = Integer.parseInt(request.getHeader(Constants.UCTDMS_ID));
				user = userRepository.getUserDetails(uctdmsId);

				if (user==null) {
					return new UtrustResponse(StatusCodes.UCTDMS_ID_NOT_FOUND.getStatusCode(),
							StatusCodes.UCTDMS_ID_NOT_FOUND.getMessage(), null);
				}
			}
			else {
				return new UtrustResponse(StatusCodes.UCTDMS_ID_NOT_EXISTS.getStatusCode(),
						StatusCodes.UCTDMS_ID_NOT_EXISTS.getMessage(), null);
			}
			List<EnquiryTimeline> enquiryTimeline = enquiryFollowupRepository.findByEnquiryNumber(enquiryNumber);
			List<EnquiryTimelineResponse> lEnquiryTimelineResponses = new ArrayList<EnquiryTimelineResponse>();
			EnquiryTimelineResponse enquiryTimelineResponse = null;
			if (!enquiryTimeline.isEmpty()) {
				for (EnquiryTimeline enquiryTimeline2 : enquiryTimeline) {
					// Possible values for DROP_ID = 2, CREATED_ID = 0, SUCCESS_ID = 3, FOLLOWUP_ID = 1
					if (enquiryTimeline2.getIsFollowup() == Constants.DROP_ID) {
						enquiryTimelineResponse = new EnquiryTimelineResponse();
						enquiryTimelineResponse.setFollowUpId(enquiryTimeline2.getFollowupId());
						enquiryTimelineResponse.setEnquiryNumber(enquiryTimeline2.getEnquiryNumber());
						enquiryTimelineResponse.setRemark(enquiryTimeline2.getAction());
						enquiryTimelineResponse.setDetailedRemark(enquiryTimeline2.getRemarks());
						enquiryTimelineResponse.setDate(enquiryTimeline2.getUpdatedDate());
						enquiryTimelineResponse.setIsFollowUp(false);
						enquiryTimelineResponse.setFollowupStatus(Constants.DROPPED);
						lEnquiryTimelineResponses.add(enquiryTimelineResponse);
					} else if (enquiryTimeline2.getIsFollowup() == Constants.CREATED_ID) {
						enquiryTimelineResponse = new EnquiryTimelineResponse();
						enquiryTimelineResponse.setFollowUpId(enquiryTimeline2.getFollowupId());
						enquiryTimelineResponse.setEnquiryNumber(enquiryTimeline2.getEnquiryNumber());
						enquiryTimelineResponse.setRemark(enquiryTimeline2.getAction());
						enquiryTimelineResponse.setDetailedRemark(enquiryTimeline2.getRemarks());
						enquiryTimelineResponse.setDate(enquiryTimeline2.getUpdatedDate());
						enquiryTimelineResponse.setIsFollowUp(false);
						enquiryTimelineResponse.setFollowupStatus(Constants.CREATED);
						lEnquiryTimelineResponses.add(enquiryTimelineResponse);
					} else if (enquiryTimeline2.getIsFollowup() == Constants.SUCCESS_ID) {
						enquiryTimelineResponse = new EnquiryTimelineResponse();
						enquiryTimelineResponse.setFollowUpId(enquiryTimeline2.getFollowupId());
						enquiryTimelineResponse.setEnquiryNumber(enquiryTimeline2.getEnquiryNumber());
						enquiryTimelineResponse.setRemark(enquiryTimeline2.getAction());
						enquiryTimelineResponse.setDetailedRemark(enquiryTimeline2.getRemarks());
						enquiryTimelineResponse.setDate(enquiryTimeline2.getUpdatedDate());
						enquiryTimelineResponse.setIsFollowUp(false);
						enquiryTimelineResponse.setFollowupStatus(Constants.SUCCESS);
						lEnquiryTimelineResponses.add(enquiryTimelineResponse);
					} else if (enquiryTimeline2.getIsFollowup() == Constants.FOLLOWUP_ID) {
						enquiryTimelineResponse = new EnquiryTimelineResponse();
						enquiryTimelineResponse.setFollowUpId(enquiryTimeline2.getFollowupId());
						enquiryTimelineResponse.setEnquiryNumber(enquiryTimeline2.getEnquiryNumber());
						enquiryTimelineResponse.setRemark(enquiryTimeline2.getAction());
						enquiryTimelineResponse.setDetailedRemark(enquiryTimeline2.getRemarks());
						enquiryTimelineResponse.setDate(enquiryTimeline2.getUpdatedDate());
						enquiryTimelineResponse.setIsFollowUp(false);
						enquiryTimelineResponse.setFollowupStatus(Constants.FOLLOW_UP);
						lEnquiryTimelineResponses.add(enquiryTimelineResponse);
					}
				}

				List<FollowUp> lFollowUps = followUpRepository.getFollowUp(enquiryNumber);
				if (!lFollowUps.isEmpty()) {
					for (int i = 0; i < lFollowUps.size(); i++) {
						if (i + 1 < lFollowUps.size()) {
							if (lFollowUps.get(i).getNextDate() != null && lFollowUps.get(i).getNextDate().equals(lFollowUps.get(i + 1).getActualDate())) {
								enquiryTimelineResponse = new EnquiryTimelineResponse();
								enquiryTimelineResponse.setFollowUpId(lFollowUps.get(i).getFollowUpId());
								enquiryTimelineResponse.setEnquiryNumber(enquiryNumber);
								enquiryTimelineResponse.setRemark(lFollowUps.get(i).getNextRemark());
								enquiryTimelineResponse.setDetailedRemark(lFollowUps.get(i).getNextDetailRemark());
								enquiryTimelineResponse.setDate(lFollowUps.get(i).getNextDate());
								enquiryTimelineResponse.setIsFollowUp(true);
								enquiryTimelineResponse.setFollowupStatus(Constants.DONE);
								lEnquiryTimelineResponses.add(enquiryTimelineResponse);
							} else if (lFollowUps.get(i).getNextDate() != null && lFollowUps.get(i).getActualDate()
									.compareTo(lFollowUps.get(i + 1).getNextDate()) < 0) {
								enquiryTimelineResponse = new EnquiryTimelineResponse();
								enquiryTimelineResponse.setFollowUpId(lFollowUps.get(i).getFollowUpId());
								enquiryTimelineResponse.setEnquiryNumber(enquiryNumber);
								enquiryTimelineResponse.setRemark(lFollowUps.get(i).getNextRemark());
								enquiryTimelineResponse.setDetailedRemark(lFollowUps.get(i).getNextDetailRemark());
								enquiryTimelineResponse.setDate(lFollowUps.get(i).getNextDate());
								enquiryTimelineResponse.setIsFollowUp(true);
								enquiryTimelineResponse.setFollowupStatus(Constants.MISSED);
								lEnquiryTimelineResponses.add(enquiryTimelineResponse);
							}else if(lFollowUps.get(i).getNextDate() != null){
								enquiryTimelineResponse = new EnquiryTimelineResponse();
								enquiryTimelineResponse.setFollowUpId(lFollowUps.get(i).getFollowUpId());
								enquiryTimelineResponse.setEnquiryNumber(enquiryNumber);
								enquiryTimelineResponse.setRemark(lFollowUps.get(i).getNextRemark());
								enquiryTimelineResponse.setDetailedRemark(lFollowUps.get(i).getNextDetailRemark());
								enquiryTimelineResponse.setDate(lFollowUps.get(i).getNextDate());
								enquiryTimelineResponse.setIsFollowUp(true);
								enquiryTimelineResponse.setFollowupStatus(Constants.PLAN);
								lEnquiryTimelineResponses.add(enquiryTimelineResponse);
							}
						} else {
							if (enquiryTimeline.get(enquiryTimeline.size() - 1).getIsFollowup() == Constants.DROP_ID) {
								enquiryTimelineResponse = new EnquiryTimelineResponse();
								enquiryTimelineResponse.setFollowUpId(lFollowUps.get(i).getFollowUpId());
								enquiryTimelineResponse.setEnquiryNumber(enquiryNumber);
								enquiryTimelineResponse.setRemark(lFollowUps.get(i).getNextRemark());
								enquiryTimelineResponse.setDetailedRemark(lFollowUps.get(i).getNextDetailRemark());
								enquiryTimelineResponse.setDate(lFollowUps.get(i).getNextDate());
								enquiryTimelineResponse.setIsFollowUp(true);
								enquiryTimelineResponse.setFollowupStatus(Constants.MISSED);
								lEnquiryTimelineResponses.add(enquiryTimelineResponse);
							}  else if (enquiryTimeline.get(enquiryTimeline.size() - 1).getIsFollowup() == Constants.SUCCESS_ID){
								enquiryTimelineResponse = new EnquiryTimelineResponse();
								enquiryTimelineResponse.setFollowUpId(lFollowUps.get(i).getFollowUpId());
								enquiryTimelineResponse.setEnquiryNumber(enquiryNumber);
								enquiryTimelineResponse.setRemark(lFollowUps.get(i).getNextRemark());
								enquiryTimelineResponse.setDetailedRemark(lFollowUps.get(i).getNextDetailRemark());
								enquiryTimelineResponse.setDate(lFollowUps.get(i).getNextDate());
								enquiryTimelineResponse.setIsFollowUp(true);
								enquiryTimelineResponse.setFollowupStatus(Constants.DONE);
								lEnquiryTimelineResponses.add(enquiryTimelineResponse);
							}else {
								enquiryTimelineResponse = new EnquiryTimelineResponse();
								enquiryTimelineResponse.setFollowUpId(lFollowUps.get(i).getFollowUpId());
								enquiryTimelineResponse.setEnquiryNumber(enquiryNumber);
								enquiryTimelineResponse.setRemark(lFollowUps.get(i).getNextRemark());
								enquiryTimelineResponse.setDetailedRemark(lFollowUps.get(i).getNextDetailRemark());
								enquiryTimelineResponse.setDate(lFollowUps.get(i).getNextDate());
								enquiryTimelineResponse.setIsFollowUp(true);
								enquiryTimelineResponse.setFollowupStatus(Constants.PLAN);
								lEnquiryTimelineResponses.add(enquiryTimelineResponse);
								}
							}
					}
				}

				// sorting based on enquiryTimelineResponse dates
				lEnquiryTimelineResponses.sort(Comparator.comparing(EnquiryTimelineResponse::getDate));
				Collections.reverse(lEnquiryTimelineResponses);
				
				return new UtrustResponse(StatusCodes.ENQUIRY_TIMELINE_DATA_RETRIEVE_SUCCESS.getStatusCode(),
						StatusCodes.ENQUIRY_TIMELINE_DATA_RETRIEVE_SUCCESS.getMessage(), lEnquiryTimelineResponses);
			} else {
				return new UtrustResponse(StatusCodes.ENQUIRY_TIMELINE_DATA_RETRIEVE_FAIL.getStatusCode(),
						StatusCodes.ENQUIRY_TIMELINE_DATA_RETRIEVE_FAIL.getMessage(), null);
			}

		} catch (Exception e) {
			logger.error(Constants.EXCEPTION + " enquiryNumber :" + enquiryNumber, e);
			return new UtrustResponse(StatusCodes.ENQUIRY_TIMELINE_DATA_RETRIEVE_FAIL.getStatusCode(),
					StatusCodes.ENQUIRY_TIMELINE_DATA_RETRIEVE_FAIL.getMessage(), null);
		}
	}

	@Override
	@Transactional
	public UtrustResponse getNegotionHistory(String enquiryNumber, HttpServletRequest request) {
		Integer uctdmsId = null;
		User user = null;
		String poLastName=null,ptlLastName=null;
		String poMiddleName=null,ptlMiddleName=null;
		String poFirstName=null,ptlFirstName=null;;
		try {
			logger.info("Inside getNegotionHistory service");
			if (request.getHeader(Constants.UCTDMS_ID) != null) {
				uctdmsId = Integer.parseInt(request.getHeader(Constants.UCTDMS_ID));
				user = userRepository.getUserDetails(uctdmsId);

				if (user==null) {
					return new UtrustResponse(StatusCodes.UCTDMS_ID_NOT_FOUND.getStatusCode(),
							StatusCodes.UCTDMS_ID_NOT_FOUND.getMessage(), null);
				}
			}
			else {
				return new UtrustResponse(StatusCodes.UCTDMS_ID_NOT_EXISTS.getStatusCode(),
						StatusCodes.UCTDMS_ID_NOT_EXISTS.getMessage(), null);
			}
			if (user.getUserRoleId() == Constants.PO_ROLE || user.getUserRoleId() == Constants.PTL_ROLE) {
				NegotiationHistResponse negotionHistResponse = null;
				List<NegotiationHistResponse> negotionHistResponseList = new ArrayList<>();
				List<NegotiationHistory> negotionHistoryList = enquiryRepository.getNegotiationHistory(enquiryNumber);
				if (negotionHistoryList != null && !negotionHistoryList.isEmpty()) {
					for (NegotiationHistory negotionHistory : negotionHistoryList) {
						negotionHistResponse = new NegotiationHistResponse();
						BeanUtils.copyProperties(negotionHistory, negotionHistResponse);
						int poId=negotionHistory.getPoId();
						int ptlId=negotionHistory.getPtlId();
						int userId=0;
						if(poId != 0) { 
							userId = poId;
						}else {
							userId = ptlId;
						}
						// setting user name
						user = userRepository.getUserDetails(userId);
						if(user != null) {
							poFirstName = user.getFirstName();
							poMiddleName = user.getMiddleName();
							poLastName = user.getLastName();
							user = userRepository.getUserDetails(user.getReportingTo());
							if(user != null) {
								ptlFirstName = user.getFirstName();
								ptlMiddleName = user.getMiddleName();
								ptlLastName = user.getLastName();
							}
						}
						if (poFirstName == null) {poFirstName = "";}
						if (poMiddleName == null) {poMiddleName = "";}
						if (poLastName == null) {poLastName = "";}
						negotionHistResponse.setPoName(poFirstName + " " + poMiddleName + " " + poLastName);
						
						if (ptlFirstName == null) {ptlFirstName = "";}
						if (ptlMiddleName == null) {ptlMiddleName = "";}
						if (ptlLastName == null) {ptlLastName = "";}
						negotionHistResponse.setPtlName(ptlFirstName + " " + ptlMiddleName + " " + ptlLastName);
						negotionHistResponseList.add(negotionHistResponse);
					}
					return new UtrustResponse(StatusCodes.NEGOTIATION_HISTORY_RETRIEVE_SUCCESS.getStatusCode(),
							StatusCodes.NEGOTIATION_HISTORY_RETRIEVE_SUCCESS.getMessage(), negotionHistResponseList);
				} else {
					logger.debug(StatusCodes.NEGOTIATION_HISTORY_RETRIEVE_FAIL.getMessage());
					return new UtrustResponse(StatusCodes.NEGOTIATION_HISTORY_RETRIEVE_FAIL.getStatusCode(),
							StatusCodes.NEGOTIATION_HISTORY_RETRIEVE_FAIL.getMessage(), negotionHistResponseList);
				}
			} else {
				logger.debug("User RoleId :"+user.getUserRoleId());
				return new UtrustResponse(StatusCodes.NEGOTIATION_HISTORY_ROLE_FAIL.getStatusCode(),
						StatusCodes.NEGOTIATION_HISTORY_ROLE_FAIL.getMessage());
			}
		} catch (Exception e) {
			logger.error(Constants.EXCEPTION , e);
			return new UtrustResponse(StatusCodes.NEGOTIATION_HISTORY_RETRIEVE_FAIL.getStatusCode(),
					StatusCodes.NEGOTIATION_HISTORY_RETRIEVE_FAIL.getMessage());
		}

	}

	@Override
	@Transactional
	public UtrustResponse getChartData(ChartDataRequest req, HttpServletRequest request) {

		logger.info("Inside EnquiryServiceImpl::getChartData with  req=" + req);

		PricingDataInfo pricingDataInfo = new PricingDataInfo();
		PricingData pricingData = new PricingData();

		ChartDataResponse chartDataResponse = new ChartDataResponse();
		PriceRangeResponse priceRangeResponse = new PriceRangeResponse();
		CarVolumeResponse carVolResp = new CarVolumeResponse();

		List<SimilarTransaction> similarTransactionList = new ArrayList<>();
		List<CarVolume> carVolumeList = new ArrayList<>();
		List<SimilarTransactionResponse> simTxnRespList = new ArrayList<>();
		List<Integer> volume = new ArrayList<>();
		List<Double> label = new ArrayList<>();

		Integer uctdmsId = null;
		User user = null;
		try {
			logger.info("Inside getChartData service");
			if (request.getHeader(Constants.UCTDMS_ID) != null) {
				uctdmsId = Integer.parseInt(request.getHeader(Constants.UCTDMS_ID));
				user = userRepository.getUserDetails(uctdmsId);

				if (user==null) {
					return new UtrustResponse(StatusCodes.UCTDMS_ID_NOT_FOUND.getStatusCode(),
							StatusCodes.UCTDMS_ID_NOT_FOUND.getMessage(), null);
				}
			}
			else {
				return new UtrustResponse(StatusCodes.UCTDMS_ID_NOT_EXISTS.getStatusCode(),
						StatusCodes.UCTDMS_ID_NOT_EXISTS.getMessage(), null);
			}
			if (req != null) {
				pricingDataInfo = enquiryRepository.getChartData(req.getCarMake(), req.getCarModel(), req.getVariant(),
						req.getCarColour(), req.getMileage(), req.getCity(), req.getPreviousOwner(), req.getQuality(),
						req.getFuel(), req.getTransmission(), req.getInsuranceType(), req.getMfdYear());
			}
			if (pricingDataInfo != null) {

				// preparing priceRangeResponse
				pricingData = pricingDataInfo.getPricingData();
				if (pricingData != null) {
					BeanUtils.copyProperties(pricingData, priceRangeResponse);
				}

				// preparing similarTransaction
				similarTransactionList = pricingDataInfo.getSimilarTransaction();
				if (similarTransactionList != null && !similarTransactionList.isEmpty()) {
					for (SimilarTransaction similarTransaction : similarTransactionList) {
						SimilarTransactionResponse simTxnResp = new SimilarTransactionResponse();
						BeanUtils.copyProperties(similarTransaction, simTxnResp);
						simTxnRespList.add(simTxnResp);
					}
				}

				// preparing Car Volume Response
				carVolumeList = pricingDataInfo.getCarVolumeList();
				if (carVolumeList != null && !carVolumeList.isEmpty()) {
					for (CarVolume carVol : carVolumeList) {
						label.add(carVol.getLabel());
						volume.add(carVol.getVolume());
					}
					carVolResp.setLabel(label);
					carVolResp.setVolume(volume);
				}

				chartDataResponse.setPriceRangeResponse(priceRangeResponse);
				chartDataResponse.setCarVolumeResponse(carVolResp);
				chartDataResponse.setSimilarTransactionResponse(simTxnRespList);

				return new UtrustResponse(StatusCodes.CHART_DATA_RETRIEVE_SUCCESS.getStatusCode(),
						StatusCodes.CHART_DATA_RETRIEVE_SUCCESS.getMessage(), chartDataResponse);

			}

			else {
				return new UtrustResponse(StatusCodes.CHART_DATA_RETRIEVE_FAIL.getStatusCode(),
						StatusCodes.CHART_DATA_RETRIEVE_FAIL.getMessage(), null);
			}
		} catch (Exception e) {
			logger.error(Constants.EXCEPTION, e);
			return new UtrustResponse(StatusCodes.CHART_DATA_RETRIEVE_FAIL.getStatusCode(),
					StatusCodes.CHART_DATA_RETRIEVE_FAIL.getMessage(), null);
		}
	}

	@Override
	@Transactional
	public UtrustResponse getCheckListDataByEnqNo(String enquiryNumber, HttpServletRequest request) {
		Integer uctdmsId = null;
		User user = null;
		try {
			logger.info("Inside getCheckListDataByEnqNo service");
			if (request.getHeader(Constants.UCTDMS_ID) != null) {
				uctdmsId = Integer.parseInt(request.getHeader(Constants.UCTDMS_ID));
				user = userRepository.getUserDetails(uctdmsId);

				if (user==null) {
					return new UtrustResponse(StatusCodes.UCTDMS_ID_NOT_FOUND.getStatusCode(),
							StatusCodes.UCTDMS_ID_NOT_FOUND.getMessage(), null);
				}
			}
			else {
				return new UtrustResponse(StatusCodes.UCTDMS_ID_NOT_EXISTS.getStatusCode(),
						StatusCodes.UCTDMS_ID_NOT_EXISTS.getMessage(), null);
			}
			List<Object[]> checklistJoinedResponse = checklistRepository.findChecklistByEnuqiryNumber(enquiryNumber);
			List<ChecklistMappingResponse> checklistResponses = new ArrayList<ChecklistMappingResponse>();
			ChecklistMappingResponses checklistMappingResponses = new ChecklistMappingResponses();
			int countOfSelectedDocs = 0;
			if (checklistJoinedResponse.size() != 0) {
				for (Object[] checklist : checklistJoinedResponse) {
					ChecklistMappingResponse checklistMappingResponse = new ChecklistMappingResponse();
					ChecklistResponse checklistResponse = new ChecklistResponse();
					if (checklist[8] != null) {
						String[] uploadedImages = checklist[8].toString().split(", ");
						if (uploadedImages.length != 0) {
							checklistMappingResponse.setImageUrls(Arrays.asList(uploadedImages));
						}
					}
					if (checklist[6] != null) {
						countOfSelectedDocs++;
					}
					checklistResponse.setId((int) checklist[0]);
					checklistResponse.setChecklist((String) checklist[2]);
					checklistMappingResponse.setChecklist(checklistResponse);
//					checklistMappingResponse.setIsUploaded(checklist[8] != null ? true : false);
					checklistResponse.setSelected(checklist[6] == null ? false : true);
					checklistMappingResponse.setTargetDate((Date) checklist[9]);
					checklistResponses.add(checklistMappingResponse);
				}

				checklistMappingResponses.setIsFirstTime(
						enquiryRepository.getEnquiry(enquiryNumber).getIsProcurementSaved() ? false : true);
				checklistMappingResponses.setCountOfSelectedItem(countOfSelectedDocs);
				checklistMappingResponses.setChecklistMappingData(checklistResponses);

				return new UtrustResponse(StatusCodes.PROCUREMENT_CHECKLIST_SUCCESS.getStatusCode(),
						StatusCodes.PROCUREMENT_CHECKLIST_SUCCESS.getMessage(), checklistMappingResponses);
			} else {
				return new UtrustResponse(StatusCodes.ENQUIRY_NOT_FOUND.getStatusCode(),
						StatusCodes.ENQUIRY_NOT_FOUND.getMessage(), null);
			}
		} catch (Exception e) {
			logger.error(Constants.EXCEPTION + " enquiryNumber : " + enquiryNumber, e);
			return new UtrustResponse(StatusCodes.PROCUREMENT_CHECKLIST_FAIL.getStatusCode(),
					StatusCodes.PROCUREMENT_CHECKLIST_FAIL.getMessage(), null);
		}

	}
	
	@Override
	@Transactional
	public UtrustResponse saveProcurementChecklistDetails(
			ProcurementChecklistAllRequests procurementChecklistMappingRequest, HttpServletRequest request) {
		Integer uctdmsId = null;
		User user = null;
		try {
			logger.info("Inside saveProcurementChecklistDetails service");
			if (request.getHeader(Constants.UCTDMS_ID) != null) {
				uctdmsId = Integer.parseInt(request.getHeader(Constants.UCTDMS_ID));
				user = userRepository.getUserDetails(uctdmsId);

				if (user==null) {
					return new UtrustResponse(StatusCodes.UCTDMS_ID_NOT_FOUND.getStatusCode(),
							StatusCodes.UCTDMS_ID_NOT_FOUND.getMessage(), null);
				}
			}
			else {
				return new UtrustResponse(StatusCodes.UCTDMS_ID_NOT_EXISTS.getStatusCode(),
						StatusCodes.UCTDMS_ID_NOT_EXISTS.getMessage(), null);
			}
			List<ProcurementChecklistMappingRequest> procurementChecklistRequest = procurementChecklistMappingRequest
					.getChecklist();
			if ((procurementChecklistRequest != null) && (procurementChecklistRequest.size() != 0)) {
				checklistMappingRepository
						.deleteAllByEnquiryNoAndDocCategory(procurementChecklistMappingRequest.getEnquiryNumber());
				List<ChecklistMapping> listChecklistMappings = new ArrayList<>();
				Enquiry enquiry = enquiryRepository.getEnquiry(procurementChecklistMappingRequest.getEnquiryNumber());
				if (enquiry != null) {
					for (ProcurementChecklistMappingRequest procChecklistMapping : procurementChecklistMappingRequest
							.getChecklist()) {
						ChecklistMapping checklistMapping = new ChecklistMapping();

						Optional<Checklist> optionalCheckList = checklistRepository
								.findById(procChecklistMapping.getChecklistItemId());
						Checklist checklist = optionalCheckList.get();
						checklistMapping.setChecklist(checklist);

						checklistMapping.setEnquiryNumber(procurementChecklistMappingRequest.getEnquiryNumber());

						String[] imageUrls = procChecklistMapping.getImageUrls();
						StringBuilder commaSaperatedImages = null;
						if (imageUrls != null) {
							commaSaperatedImages = new StringBuilder();
							for (int i = 0; i < imageUrls.length; i++) {
								if ((i + 1) != imageUrls.length) {
									commaSaperatedImages.append(imageUrls[i]).append(", ");
								} else {
									commaSaperatedImages.append(imageUrls[i]);
								}
							}
							checklistMapping.setDocumentUrl(commaSaperatedImages.toString());
						} else {
							checklistMapping.setTargetDate(procChecklistMapping.getTargetDate());
						}

						listChecklistMappings.add(checklistMapping);
					}
					checklistMappingRepository.saveAll(listChecklistMappings);
					// True stands for procurement data is saved
					enquiryRepository.updateProcFlagByEnquiryNumber(true,enquiry.getEnquiryNumber());
					return new UtrustResponse(StatusCodes.PROCUREMENT_CHECKLIST_SAVE_SUCCESS.getStatusCode(),
							StatusCodes.PROCUREMENT_CHECKLIST_SAVE_SUCCESS.getMessage(), null);
				} else {
					return new UtrustResponse(StatusCodes.PROCUREMENT_CHECKLIST_SAVE_FAIL.getStatusCode(),
							StatusCodes.PROCUREMENT_CHECKLIST_SAVE_FAIL.getMessage(), null);
				}
			} else {
				return new UtrustResponse(StatusCodes.PROCUREMENT_CHECKLIST_SAVE_FAIL.getStatusCode(),
						StatusCodes.PROCUREMENT_CHECKLIST_SAVE_FAIL.getMessage(), null);
			}

		} catch (Exception e) {
			logger.error(Constants.EXCEPTION + " procurementChecklistMappingRequest : " + procurementChecklistMappingRequest,e);
			return new UtrustResponse(StatusCodes.PROCUREMENT_CHECKLIST_SAVE_FAIL.getStatusCode(),
					StatusCodes.PROCUREMENT_CHECKLIST_SAVE_FAIL.getMessage(), null);
		}
	}
	
	@Override
	public UtrustResponse getParallelEnquiry(String registrationNumber, HttpServletRequest request) {

		Date currEnqDate = null;
		Date prevEnqDate = null;
		String prevEnqStatus = null;
		String currEnqStatus = null;
		Integer uctdmsId = null;
		
		List<Enquiry> allEnqList = null;
		List<ParallelEnqPairResponse> parlEnqPairRespList = null;

		User user = null;
		try {
			logger.info("Inside getParallelEnquiry service");
			if (request.getHeader(Constants.UCTDMS_ID) != null) {
				uctdmsId = Integer.parseInt(request.getHeader(Constants.UCTDMS_ID));
				user = userRepository.getUserDetails(uctdmsId);

				if (user==null) {
					return new UtrustResponse(StatusCodes.UCTDMS_ID_NOT_FOUND.getStatusCode(),
							StatusCodes.UCTDMS_ID_NOT_FOUND.getMessage(), null);
				}
			}
			else {
				return new UtrustResponse(StatusCodes.UCTDMS_ID_NOT_EXISTS.getStatusCode(),
						StatusCodes.UCTDMS_ID_NOT_EXISTS.getMessage(), null);
			}
			List<Vehicle> vehicleList = enquiryRepository.getParallelEnquiry(registrationNumber);
			if (vehicleList != null && !vehicleList.isEmpty() && vehicleList.size()>=2) {
				allEnqList = new ArrayList<>();
				for (Vehicle vehile : vehicleList) {
					List<Enquiry> enqList = vehile.getEnquiryList();
					for (Enquiry enquiry : enqList) {
						allEnqList.add(enquiry);
					}
				}
			
			Collections.sort(allEnqList, new Comparator<Enquiry>() {
				@Override
				public int compare(Enquiry enq1, Enquiry enq2) {
					return enq1.getCreatedAt().compareTo(enq2.getCreatedAt());
				}
			});
		}
			if (allEnqList != null && !allEnqList.isEmpty()) {
				parlEnqPairRespList = new ArrayList<>();
				for (int i = 0; i < allEnqList.size(); i++) {
					List<ParallelEnquiryResponse> parlEnqRespList = new ArrayList<>();
					int count = 0;
					for (int j = i + 1; j < allEnqList.size(); j++) {
						currEnqStatus = allEnqList.get(j).getEnquiryStatus();
						currEnqDate = allEnqList.get(j).getCreatedAt();
						prevEnqDate = allEnqList.get(i).getCreatedAt();
						prevEnqStatus = allEnqList.get(i).getEnquiryStatus();

						if (prevEnqStatus != null && currEnqStatus != null && !currEnqStatus.equalsIgnoreCase(Constants.DROPPED)
								&& !currEnqStatus.equalsIgnoreCase(Constants.SUCCESS) && !prevEnqStatus.equalsIgnoreCase(Constants.DROPPED)
								&& !prevEnqStatus.equalsIgnoreCase(Constants.SUCCESS)) {
						
							if (TimeUnit.MINUTES.convert((currEnqDate.getTime() - prevEnqDate.getTime()),
									TimeUnit.MILLISECONDS) <= Constants.TWO_DAYS_DIFFERENCE) {
						
								ParallelEnquiryResponse previousEnqResp = null;
								ParallelEnquiryResponse currentEnqResp = null;
								if (count == 0) {
									previousEnqResp = prepareParllEnqResp(allEnqList.get(i));
									parlEnqRespList.add(previousEnqResp);
									count++;
								}
								currentEnqResp = prepareParllEnqResp(allEnqList.get(j));
								parlEnqRespList.add(currentEnqResp);
							}else {
								break;
							}
						}else {
							break;
						}
					}
					if (parlEnqRespList != null && !parlEnqRespList.isEmpty()) {
						ParallelEnqPairResponse parlEnqPairResp = new ParallelEnqPairResponse();
						parlEnqPairResp.setParallelEnquiryResponse(parlEnqRespList);
						parlEnqPairRespList.add(parlEnqPairResp);
					}
				}
				
				return new UtrustResponse(StatusCodes.PARALLEL_ENQUIRY_DATA_RETRIEVE_SUCCESS.getStatusCode(),
						StatusCodes.PARALLEL_ENQUIRY_DATA_RETRIEVE_SUCCESS.getMessage(), parlEnqPairRespList);
			} else {
				return new UtrustResponse(StatusCodes.PARALLEL_ENQUIRY_DATA_RETRIEVE_FAIL.getStatusCode(),
						StatusCodes.PARALLEL_ENQUIRY_DATA_RETRIEVE_FAIL.getMessage(), null);
			}
		} catch (Exception e) {
			logger.error(Constants.EXCEPTION, e);
			return new UtrustResponse(StatusCodes.ENQUIRY_NOT_FOUND.getStatusCode(),
					StatusCodes.ENQUIRY_NOT_FOUND.getMessage(), null);
		}
	}

	private ParallelEnquiryResponse prepareParllEnqResp(Enquiry enq) {

		ParallelEnquiryResponse parllEnqResp = new ParallelEnquiryResponse();

		if (enq != null) {
			parllEnqResp.setEnqDate(enq.getCreatedAt());
			parllEnqResp.setEnqNumber(enq.getEnquiryNumber());
		}
		if (enq.getVehicle() != null) {
			if (enq.getVehicle().getMake() != null) {
				parllEnqResp.setMake(enq.getVehicle().getMake().getName());
			}
			if (enq.getVehicle().getModel() != null) {
				parllEnqResp.setModel(enq.getVehicle().getModel().getName());
			}
			if (enq.getVehicle().getVariant() != null) {
				parllEnqResp.setVarient(enq.getVehicle().getVariant().getName());
			}
		}

		if (enq.getDealerUserSo() != null) {
			if (enq.getDealerUserSo().getDealer() != null) {
				parllEnqResp.setDealerGroup(enq.getDealerUserSo().getDealer().getDealerGroup());
				parllEnqResp.setDealerLocation(enq.getDealerUserSo().getDealer().getDealerLocation());
				parllEnqResp.setDealerId(enq.getDealerUserSo().getDealer().getDealerId());
			}
		}

		return parllEnqResp;
	}

	@Override
	public UtrustResponse uploadImage(MultipartFile file,HttpServletRequest request) {
		
		Integer uctdmsId=null;
		User user = null;
		try {
			logger.info("Inside uploadImage service");
			if (request.getHeader(Constants.UCTDMS_ID) != null) {
				uctdmsId = Integer.parseInt(request.getHeader(Constants.UCTDMS_ID));
				user = userRepository.getUserDetails(uctdmsId);

				if (user==null) {
					return new UtrustResponse(StatusCodes.UCTDMS_ID_NOT_FOUND.getStatusCode(),
							StatusCodes.UCTDMS_ID_NOT_FOUND.getMessage(), null);
				}
			}
			else {
				return new UtrustResponse(StatusCodes.UCTDMS_ID_NOT_EXISTS.getStatusCode(),
						StatusCodes.UCTDMS_ID_NOT_EXISTS.getMessage(), null);
			}
			logger.info("uctdmsId "  +uctdmsId+" :  file :" +file);
			CloudStorageAccount storageAccount;
			CloudBlobClient blobClient = null; 
			CloudBlobContainer container = null;
			
			File convFile = convertToFile(file);
			// Parse the connection string and create a blob client to interact with Blob storage
			storageAccount = CloudStorageAccount.parse(storageConnection);
			blobClient = storageAccount.createCloudBlobClient();
			container = blobClient.getContainerReference(containerName);
 
			CloudBlockBlob blob = container.getBlockBlobReference(convFile.getName());
			// blob.setStreamWriteSizeInBytes(9048576);
  			blob.uploadFromFile(convFile.getAbsolutePath());

  			URI imagePath=blob.getUri();
  			logger.info("uctdmsId:"  +uctdmsId+" +Image path :"+imagePath);
  			

			return new UtrustResponse(StatusCodes.IMAGE_UPLOAD_SUCCUESS.getStatusCode(),
					StatusCodes.IMAGE_UPLOAD_SUCCUESS.getMessage(), imagePath.toString());
		
		} catch (Exception e) {
			logger.error(Constants.EXCEPTION+" : "+uctdmsId+" file name :"+file.getName(), e);
			return new UtrustResponse(StatusCodes.IMAGE_UPLOAD_FAIL.getStatusCode(),
					StatusCodes.IMAGE_UPLOAD_FAIL.getMessage(), null);
		}
	}

	private File convertToFile(MultipartFile file) throws FileNotFoundException, IOException {
		File convFile = new File( file.getOriginalFilename() );
		FileOutputStream fos = new FileOutputStream( convFile );
		fos.write( file.getBytes() );
		fos.close();
		return convFile;
	}

	@Override
	public UtrustResponse mapChecklistDocument(MapCheckListRequest checkListRequest, HttpServletRequest request) {

		Integer uctdmsId=null;
		User user = null;
		try {
			logger.info("Inside mapChecklistDocument service");
			if (request.getHeader(Constants.UCTDMS_ID) != null) {
				uctdmsId = Integer.parseInt(request.getHeader(Constants.UCTDMS_ID));
				user = userRepository.getUserDetails(uctdmsId);

				if (user==null) {
					return new UtrustResponse(StatusCodes.UCTDMS_ID_NOT_FOUND.getStatusCode(),
							StatusCodes.UCTDMS_ID_NOT_FOUND.getMessage(), null);
				}
			}
			else {
				return new UtrustResponse(StatusCodes.UCTDMS_ID_NOT_EXISTS.getStatusCode(),
						StatusCodes.UCTDMS_ID_NOT_EXISTS.getMessage(), null);
			}
			ChecklistMapping checklistMapping = checklistMappingRepository
					.getChecklistMapping(checkListRequest.getEnquiryNumber(), checkListRequest.getChecklistItemId());
			
 				String docUrlFromRequest=checkListRequest.getDocumentUrl();
 				String docUrlFromDb=null;
				// no document exists.
				if (checklistMapping.getDocumentUrl()==null || "".equals(checklistMapping.getDocumentUrl().trim())) {
					checklistMapping.setDocumentUrl(docUrlFromRequest);
					checklistMappingRepository.save(checklistMapping);

				}
				//One or more than one document exists
				else if (!docUrlFromRequest.equals(checklistMapping.getDocumentUrl())) {
					docUrlFromDb=checklistMapping.getDocumentUrl();
					docUrlFromDb=docUrlFromDb+","+docUrlFromRequest;
					checklistMapping.setDocumentUrl(docUrlFromDb);
					checklistMappingRepository.save(checklistMapping);
				} 
 
				return new UtrustResponse(StatusCodes.PROCUREMENT_CHECKLIST_MAP_SUCCESS.getStatusCode(),
						StatusCodes.PROCUREMENT_CHECKLIST_MAP_SUCCESS.getMessage(),null);
			
		} catch (Exception e) {
			logger.error(Constants.EXCEPTION+" : "+checkListRequest+" : " ,e);
			return new UtrustResponse(StatusCodes.PROCUREMENT_CHECKLIST_MAP_FAIL.getStatusCode(),
					StatusCodes.PROCUREMENT_CHECKLIST_MAP_FAIL.getMessage(),null);		}
	}
	
	@Override
	@Transactional
	public UtrustResponse getNewCarEnquiryDetails(BasicDetailsRequest basicRequest, HttpServletRequest request) {
		Integer uctdmsId=null;
		User user = null;
		try {
			logger.info("Inside getNewCarEnquiryDetails service");
			if (request.getHeader(Constants.UCTDMS_ID) != null) {
				uctdmsId = Integer.parseInt(request.getHeader(Constants.UCTDMS_ID));
				user = userRepository.getUserDetails(uctdmsId);

				if (user==null) {
					return new UtrustResponse(StatusCodes.UCTDMS_ID_NOT_FOUND.getStatusCode(),
							StatusCodes.UCTDMS_ID_NOT_FOUND.getMessage(), null);
				}
			}
			else {
				return new UtrustResponse(StatusCodes.UCTDMS_ID_NOT_EXISTS.getStatusCode(),
						StatusCodes.UCTDMS_ID_NOT_EXISTS.getMessage(), null);
			}
			List<EnquiryResponse> enquiryResponses = new ArrayList<>();
			List<Enquiry> lEnquiries = new ArrayList<>();
			if ((basicRequest.getEnquiryNumber() != null) && (basicRequest.getEnquiryNumber() != "")) {
				lEnquiries = enquiryRepository.findByEnquiryNumberInRange(basicRequest.getEnquiryNumber());
			} else if ((basicRequest.getMobileNumber() != null) && (basicRequest.getMobileNumber() != "")) {
				Customer customer = customerRepository.getCustomer(basicRequest.getMobileNumber());
				lEnquiries = customer.getListEnquiry();
			}
			if (lEnquiries != null && !lEnquiries.isEmpty()) {
				for (Enquiry enquiry : lEnquiries) {
					EnquiryResponse enquiryResponse =createEnquiryResponse(enquiry,user);
					FollowUp followUp = followUpRepository.getLatestFollowUp(enquiry.getEnquiryNumber());
					FollowUpResponse followUpResponse = createFollowUpResponse(followUp);
					enquiryResponse.setFollowUp(followUpResponse);
					BeanUtils.copyProperties(enquiry, enquiryResponse);
					enquiryResponses.add(enquiryResponse);
				}
				return new UtrustResponse(StatusCodes.NEW_CAR_ENQUIRY_SUCCESS.getStatusCode(),
						StatusCodes.NEW_CAR_ENQUIRY_SUCCESS.getMessage(), enquiryResponses);
			} else {
				return new UtrustResponse(StatusCodes.NEW_CAR_ENQUIRY_FAIL.getStatusCode(),
						StatusCodes.NEW_CAR_ENQUIRY_FAIL.getMessage(), enquiryResponses);
			}
		} catch (Exception e) {
			logger.error(Constants.EXCEPTION + e);
			return new UtrustResponse(StatusCodes.NEW_CAR_ENQUIRY_FAIL.getStatusCode(),
					StatusCodes.NEW_CAR_ENQUIRY_FAIL.getMessage(), null);
		}
	}

	/**
	 * Retrieving all notification list
	 * 
	 * @author Vipin
	 * @param request
	 */
	@Override
	public UtrustResponse getNotificationList(HttpServletRequest request) {

		List<NotificationListResponse> notificationResponseList = new ArrayList<>();
		int actionFlag = 0;
		Integer uctdmsId=null;
		User user = null;
		try {
			logger.info("Inside getNotificationList service");
			if (request.getHeader(Constants.UCTDMS_ID) != null) {
				uctdmsId = Integer.parseInt(request.getHeader(Constants.UCTDMS_ID));
				user = userRepository.getUserDetails(uctdmsId);

				if (user==null) {
					return new UtrustResponse(StatusCodes.UCTDMS_ID_NOT_FOUND.getStatusCode(),
							StatusCodes.UCTDMS_ID_NOT_FOUND.getMessage(), null);
				}
			}
			else {
				return new UtrustResponse(StatusCodes.UCTDMS_ID_NOT_EXISTS.getStatusCode(),
						StatusCodes.UCTDMS_ID_NOT_EXISTS.getMessage(), null);
			}
			
			List<NotificationList> notificationList = notificationListRepository.getNotificationList(uctdmsId);
			if (notificationList != null && !notificationList.isEmpty()) {
				for (NotificationList notification : notificationList) {
					if (!(Constants.ACTION_DONE.equals(notification.getStatus()))) {
						NotificationListResponse notificationResponse = new NotificationListResponse();
						String status = notification.getStatus();
						actionFlag = getActionFlag(status, notification);
						notificationResponse.setNotificationId(notification.getId());
						notificationResponse.setAction(actionFlag);
						notificationResponse.setCreatedAt(notification.getCreatedAt());
						notificationResponse.setNotificationMsg(notification.getNotificationMsg());
						notificationResponse.setSeen(notification.getSeen());
						notificationResponse.setNotificationMasterId(
								notification.getNotificationMaster().getNotificationMasterId());
						notificationResponse.setActionType(notification.getNotificationMaster().getAction());
						notificationResponse.setEnquiryNumber(notification.getEnquiryNumber());
						notificationResponse.setNotificationFromUser(notification.getFromUser());
						notificationResponse.setNotificationToUser(notification.getToUser());
						notificationResponseList.add(notificationResponse);
					}
				}
				return new UtrustResponse(StatusCodes.NOTIFICATION_LIST_SUCCESS.getStatusCode(),
						StatusCodes.NOTIFICATION_LIST_SUCCESS.getMessage(), notificationResponseList);
			} else {
				return new UtrustResponse(StatusCodes.NOTIFICATION_LIST_FAIL.getStatusCode(),
						StatusCodes.NOTIFICATION_LIST_FAIL.getMessage(), null);
			}
		} catch (Exception e) {
			logger.error(Constants.EXCEPTION, e + " uctdmsId::" + uctdmsId);
			return new UtrustResponse(StatusCodes.ENQUIRY_NOT_FOUND.getStatusCode(),
					StatusCodes.ENQUIRY_NOT_FOUND.getMessage(), null);
		}
	}
	
	/**
	 * calculating the action flag here 
	 * 
	 * @author BIKASH
	 * @param status
	 * @param notificationList
	 * @return
	 */
	private int getActionFlag(String status, NotificationList notificationList) {
		int actionFlag = 0;
		String actionItems = notificationList.getNotificationMaster().getActionItems() ;
		if (status != null) {
			if (Constants.ACCEPTED.equalsIgnoreCase(status)) {
				actionFlag = 2;
			} else if (Constants.REJECTED.equalsIgnoreCase(status)) {
				actionFlag = 3;
			} else if (Constants.APPROVED.equalsIgnoreCase(status)) {
				actionFlag = 4;
			}
		} else if (actionItems != null) {
			if(actionItems.contains(Constants.APPROVE_ACTION)) {
				actionFlag = 5;
			}else {
				actionFlag = 1;
			}
		} else {
			actionFlag = 0;
		}
		return actionFlag;
	}

	@Override
	@Transactional
	public UtrustResponse confirmSignoff(ProcurementSignOffRequest procurementSignOffRequest,
			HttpServletRequest request) {
		Integer uctdmsId=null;
		User user = null;
		try {
			logger.info("Inside confirmSignoff service");
			if (request.getHeader(Constants.UCTDMS_ID) != null) {
				uctdmsId = Integer.parseInt(request.getHeader(Constants.UCTDMS_ID));
				user = userRepository.getUserDetails(uctdmsId);

				if (user==null) {
					return new UtrustResponse(StatusCodes.UCTDMS_ID_NOT_FOUND.getStatusCode(),
							StatusCodes.UCTDMS_ID_NOT_FOUND.getMessage(), null);
				}
			}
			else {
				return new UtrustResponse(StatusCodes.UCTDMS_ID_NOT_EXISTS.getStatusCode(),
						StatusCodes.UCTDMS_ID_NOT_EXISTS.getMessage(), null);
			}
			String[] signOffDocsUrlList = procurementSignOffRequest.getImageUrls();
			if (signOffDocsUrlList != null && signOffDocsUrlList.length > 0) {

				Enquiry enquiry = enquiryRepository.getEnquiry(procurementSignOffRequest.getEnquiryNumber());
				if (enquiry != null) {
					Vehicle vehicle = enquiry.getVehicle();
					if(vehicle != null && vehicle.getVehicleStage() != null) {
						vehicle.setVehicleStage(enquiryEntityManager.getVehicleStage(Constants.COLLECTED_ID));
						vehicle.setCollectedDate(new Date());
						vehicleRepository.save(vehicle);
					}  

					ChecklistMapping checklistMapping =checklistMappingRepository.getChecklistMapping(enquiry.getEnquiryNumber(), Constants.SIGNOFF_DOC_ID);
					if (checklistMapping==null) {
						checklistMapping = new ChecklistMapping();
					}

					Optional<Checklist> optionalCheckList = checklistRepository
							.findById(Constants.SIGNOFF_DOC_ID);
					Checklist checklist = optionalCheckList.get();
					checklistMapping.setChecklist(checklist);

					checklistMapping.setEnquiryNumber(procurementSignOffRequest.getEnquiryNumber());

					StringBuilder commaSaperatedImages = null;

					commaSaperatedImages = new StringBuilder();
					for (int i = 0; i < signOffDocsUrlList.length; i++) {
						if ((i + 1) == signOffDocsUrlList.length) {
							commaSaperatedImages.append(signOffDocsUrlList[i]);

						} else {
							commaSaperatedImages.append(signOffDocsUrlList[i]).append(", ");
						}
					}
					checklistMapping.setDocumentUrl(commaSaperatedImages.toString());
					checklistMappingRepository.save(checklistMapping);
					// True stands for procurement data is saved
					enquiryRepository.updateProcFlagByEnquiryNumber(true,enquiry.getEnquiryNumber());
					
					return new UtrustResponse(StatusCodes.SIGNOFF_SUCCESS.getStatusCode(),
							StatusCodes.SIGNOFF_SUCCESS.getMessage(), null);

				} else {
					return new UtrustResponse(StatusCodes.ENQUIRY_NOT_FOUND.getStatusCode(),
							StatusCodes.ENQUIRY_NOT_FOUND.getMessage(), null);
				}
			}else {
				return new UtrustResponse(StatusCodes.SIGNOFF_SAVE_FAIL.getStatusCode(),
						StatusCodes.SIGNOFF_SAVE_FAIL.getMessage(), null);
			}

		} catch (Exception e) {
			logger.error(Constants.EXCEPTION + " procurementChecklistMappingRequest : " + procurementSignOffRequest,e);
			return new UtrustResponse(StatusCodes.PROCUREMENT_CHECKLIST_SAVE_FAIL.getStatusCode(),
					StatusCodes.PROCUREMENT_CHECKLIST_SAVE_FAIL.getMessage(), null);
		}
	}

	/**
	 * when user seen the notification message ,seen TimeStamp will update 
	 * @author BIKASH
	 * @param seenRequest
	 * @param uctdmsId
	 */
	@Override
	@Transactional
	public UtrustResponse seenNotification(SeenNotificationRequest seenRequest, HttpServletRequest request) {
		NotificationList notificationList = null;
		Integer uctdmsId=null;
		User user = null;
		try {
			logger.info("Inside seenNotification service");
			if (request.getHeader(Constants.UCTDMS_ID) != null) {
				uctdmsId = Integer.parseInt(request.getHeader(Constants.UCTDMS_ID));
				user = userRepository.getUserDetails(uctdmsId);

				if (user==null) {
					return new UtrustResponse(StatusCodes.UCTDMS_ID_NOT_FOUND.getStatusCode(),
							StatusCodes.UCTDMS_ID_NOT_FOUND.getMessage(), null);
				}
			}
			else {
				return new UtrustResponse(StatusCodes.UCTDMS_ID_NOT_EXISTS.getStatusCode(),
						StatusCodes.UCTDMS_ID_NOT_EXISTS.getMessage(), null);
			}
			if(seenRequest !=null && seenRequest.getIsSeen() !=null && seenRequest.getIsSeen()) {
				notificationList = notificationListRepository.getNotificationByIdAndEnquiryNumber(seenRequest.getNotificationId(),seenRequest.getEnquiryNumber());
				if(notificationList !=null) {
					notificationList.setSeen(new Date());
					notificationListRepository.save(notificationList);
					return new UtrustResponse(StatusCodes.SEEN_NOTIFICATION_SUCCESS.getStatusCode(),
							StatusCodes.SEEN_NOTIFICATION_SUCCESS.getMessage()); 
				}else {
					return new UtrustResponse(StatusCodes.NOTOFICATION_NOT_FOUND.getStatusCode(),
							StatusCodes.NOTOFICATION_NOT_FOUND.getMessage());
				}
			}
			return new UtrustResponse(StatusCodes.SEEN_NOTIFICATION_FAIL.getStatusCode(),
					StatusCodes.SEEN_NOTIFICATION_FAIL.getMessage());
		}
		catch(Exception e) {
			logger.error(Constants.EXCEPTION, e + " seenRequest ::" + seenRequest);
			return new UtrustResponse(StatusCodes.SEEN_NOTIFICATION_FAIL.getStatusCode(),
					StatusCodes.SEEN_NOTIFICATION_FAIL.getMessage(), null);
		}
	}

	/**
	 * This method will return colleted vehicle list
	 * 
	 * @author Vipin
	 * @param collVehReq
	 * @param request
	 */
	@Override
	public UtrustResponse collectedVehicles(CollectedVehiclesRequest collVehReq, HttpServletRequest request) {
		CollectedVehicleResponse collectedVehicleResponse = null;
		List<CollectedVehicleResponse> collectedVehicleResponsesList = new ArrayList<>();
		List<Enquiry> enquiryList = null;

		Integer uctdmsId = null;
		User user = null;
		try {
			logger.info("Inside collectedVehicles service");
			if (request.getHeader(Constants.UCTDMS_ID) != null) {
				uctdmsId = Integer.parseInt(request.getHeader(Constants.UCTDMS_ID));
				user = userRepository.getUserDetails(uctdmsId);

				if (user == null) {
					return new UtrustResponse(StatusCodes.UCTDMS_ID_NOT_FOUND.getStatusCode(),
							StatusCodes.UCTDMS_ID_NOT_FOUND.getMessage(), null);
				}
			} else {
				return new UtrustResponse(StatusCodes.UCTDMS_ID_NOT_EXISTS.getStatusCode(),
						StatusCodes.UCTDMS_ID_NOT_EXISTS.getMessage(), null);
			}

			enquiryList = enquiryRepository.getCollectedDocuments(collVehReq.getFromDate(), collVehReq.getToDate(),Constants.COLLECTED_ID);
			if (enquiryList != null) {
				for (Enquiry enquiry : enquiryList) {
					Vehicle vehicle=enquiry.getVehicle();

					collectedVehicleResponse = new CollectedVehicleResponse();
					collectedVehicleResponse.setCollecteddate(vehicle.getCollectedDate());
					collectedVehicleResponse.setColor(vehicle.getExteriorColor().getName());
					collectedVehicleResponse.setFuel(vehicle.getFuelType());
					collectedVehicleResponse.setMake(vehicle.getMake().getName());
					collectedVehicleResponse.setModel(vehicle.getModel().getName());
					collectedVehicleResponse.setOdoMeter(vehicle.getMileage());
					collectedVehicleResponse.setRegNumber(vehicle.getRegistrationNumber());
					collectedVehicleResponse.setTransmission(vehicle.getTransmissionType());
					collectedVehicleResponse.setVariant(vehicle.getVariant().getName());
					collectedVehicleResponse.setVehicleStageId(vehicle.getVehicleStage().getStageId());
					collectedVehicleResponse.setYear(vehicle.getYear());
					collectedVehicleResponse.setEnquiryNumber(vehicle.getEnquiryList().get(0).getEnquiryNumber());
 
					
					List count=checklistMappingRepository.getDocumentsCount(enquiry.getEnquiryNumber());
					Object o =count.get(0);
					Object[] objects = (Object[]) o;  
					BigInteger total= (BigInteger)objects[0];
					BigInteger pending= (BigInteger)objects[1];

					String signOfUrls=checklistMappingRepository.getSignOfUrls(enquiry.getEnquiryNumber(), Constants.SIGNOFF_DOC_ID) ;
					
					if (signOfUrls!=null) {
						collectedVehicleResponse.setSignOff(Arrays.asList(signOfUrls.split(",")));
					}

					
					 NegotiationHistory negotiationHistory = negotiationHistoryRepository.findByEnqNumber(enquiry.getEnquiryNumber());
					    Double price=0.0;
						if (negotiationHistory!=null) {
							Double latestOfferPrice=negotiationHistory.getLatestOfferPrice();
							if (latestOfferPrice!=null) {
								price=latestOfferPrice;
							}
							else {
								price=negotiationHistory.getOfferPrice();
							}
							
						}
					//int total= c
				//	int pending= (int) count[0];

					collectedVehicleResponse.setPendingDocument(pending.intValue());
					collectedVehicleResponse.setTotalDocuments(total.intValue());
					
					Integer poId = vehicle.getEnquiryList().get(0).getAssignTo();
					user = userRepository.getUserDetails(poId);
					if (user != null) {
						collectedVehicleResponse.setPoName(user.getFirstName() + " " + user.getLastName());
					}
					collectedVehicleResponsesList.add(collectedVehicleResponse);
				}
			}
			// sorting based on collectedVehicleResponsesList Collected date
			collectedVehicleResponsesList.sort(Comparator.comparing(CollectedVehicleResponse::getCollecteddate));
			Collections.reverse(collectedVehicleResponsesList);
			
			return new UtrustResponse(StatusCodes.COLLECETD_VEHICLE_SUCCESS.getStatusCode(),
					StatusCodes.COLLECETD_VEHICLE_SUCCESS.getMessage(), collectedVehicleResponsesList);

		} catch (Exception e) {
			logger.error(Constants.EXCEPTION, e );
			return new UtrustResponse(StatusCodes.COLLECETD_VEHICLE_FAIL.getStatusCode(),
					StatusCodes.COLLECETD_VEHICLE_FAIL.getMessage(), null);
		}
	}

	

	/**
	 * This method will return purchased vehicle list
	 * 
	 * @author Vipin
	 * @param collVehReq
	 * @param request
	 */
	@Override
	public UtrustResponse purchasedVehicles(CollectedVehiclesRequest collVehReq, HttpServletRequest request) {
		List<Enquiry> enquiryList = null;
		CollectedVehicleResponse collectedVehicleResponse = null;
		List<CollectedVehicleResponse> collectedVehicleResponsesList = new ArrayList<>();
		Integer uctdmsId = null;
		User user = null;
		try {
			logger.info("Inside purchasedVehicles service");
			if (request.getHeader(Constants.UCTDMS_ID) != null) {
				uctdmsId = Integer.parseInt(request.getHeader(Constants.UCTDMS_ID));
				user = userRepository.getUserDetails(uctdmsId);

				if (user == null) {
					return new UtrustResponse(StatusCodes.UCTDMS_ID_NOT_FOUND.getStatusCode(),
							StatusCodes.UCTDMS_ID_NOT_FOUND.getMessage(), null);
				}
			} else {
				return new UtrustResponse(StatusCodes.UCTDMS_ID_NOT_EXISTS.getStatusCode(),
						StatusCodes.UCTDMS_ID_NOT_EXISTS.getMessage(), null);
			}
			enquiryList = enquiryRepository.getPurchasedDocuments(collVehReq.getFromDate(), collVehReq.getToDate(),Constants.PURCHASED_ID);
			if (enquiryList != null) {
				for (Enquiry enquiry : enquiryList) {
					Vehicle vehicle=enquiry.getVehicle();

					collectedVehicleResponse = new CollectedVehicleResponse();
					collectedVehicleResponse.setCollecteddate(vehicle.getCollectedDate());
					collectedVehicleResponse.setColor(vehicle.getExteriorColor().getName());
					collectedVehicleResponse.setFuel(vehicle.getFuelType());
					collectedVehicleResponse.setMake(vehicle.getMake().getName());
					collectedVehicleResponse.setModel(vehicle.getModel().getName());
					collectedVehicleResponse.setOdoMeter(vehicle.getMileage());
					collectedVehicleResponse.setRegNumber(vehicle.getRegistrationNumber());
					collectedVehicleResponse.setTransmission(vehicle.getTransmissionType());
					collectedVehicleResponse.setVariant(vehicle.getVariant().getName());
					collectedVehicleResponse.setVehicleStageId(vehicle.getVehicleStage().getStageId());
					collectedVehicleResponse.setYear(vehicle.getYear());
					collectedVehicleResponse.setEnquiryNumber(vehicle.getEnquiryList().get(0).getEnquiryNumber());
 
				    NegotiationHistory negotiationHistory = negotiationHistoryRepository.findByEnqNumber(enquiry.getEnquiryNumber());
				    Double price=0.0;
					if (negotiationHistory!=null) {
						Double latestOfferPrice=negotiationHistory.getLatestOfferPrice();
						if (latestOfferPrice!=null) {
							price=latestOfferPrice;
						}
						else {
							price=negotiationHistory.getOfferPrice();
						}
					}
					collectedVehicleResponse.setPurchaseAmt(price);
					List count=checklistMappingRepository.getDocumentsCount(enquiry.getEnquiryNumber());
					Object o =count.get(0);
					Object[] objects = (Object[]) o;  
					BigInteger total= (BigInteger)objects[0];
					BigInteger pending= (BigInteger)objects[1];

					String signOfUrls=checklistMappingRepository.getSignOfUrls(enquiry.getEnquiryNumber(), Constants.SIGNOFF_DOC_ID) ;
					
					if (signOfUrls!=null) {
						collectedVehicleResponse.setSignOff(Arrays.asList(signOfUrls.split(",")));
					}

					//int total= c
				//	int pending= (int) count[0];

					collectedVehicleResponse.setPendingDocument(pending.intValue());
					collectedVehicleResponse.setTotalDocuments(total.intValue());
					
					Integer poId = vehicle.getEnquiryList().get(0).getAssignTo();
					user = userRepository.getUserDetails(poId);
					if (user != null) {
						collectedVehicleResponse.setPoName(user.getFirstName() + " " + user.getLastName());
					}
					collectedVehicleResponsesList.add(collectedVehicleResponse);
				}
			}
			// sorting based on collectedVehicleResponsesList Collected date
			collectedVehicleResponsesList.sort(Comparator.comparing(CollectedVehicleResponse::getCollecteddate));
			Collections.reverse(collectedVehicleResponsesList);
			
			return new UtrustResponse(StatusCodes.PURCHASED_VEHICLE_SUCCESS.getStatusCode(),
					StatusCodes.PURCHASED_VEHICLE_SUCCESS.getMessage(), collectedVehicleResponsesList);

		} catch (Exception e) {
			logger.error(Constants.EXCEPTION, e + " uctdmsId : " + uctdmsId, " collVehReq::" + collVehReq);
			return new UtrustResponse(StatusCodes.PURCHASED_VEHICLE_FAIL.getStatusCode(),
					StatusCodes.PURCHASED_VEHICLE_FAIL.getMessage(), null);
		}
	}

	@Override
	public UtrustResponse getSilentNotification(SeenNotificationRequest silenteenNotificationRequest,
			HttpServletRequest request) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	@Override
	public UtrustResponse pendingDocumentds(CollectedVehiclesRequest collVehReq, HttpServletRequest request) {
		List<Enquiry> enquiryList = null;

		CollectedVehicleResponse collectedVehicleResponse = null;
		PendingDocCustResponse pendingDocCustResponse = null;
		List<PendingDocumentResponse> pendingDocumentResponseList = new ArrayList<>();
		PendingDocumentResponse pendingDocumentResponse = null;
		String firstName = null;
		String middleName = null;
		String lastName = null;
		String mobileNo = null;

		Integer uctdmsId=null;
		User user = null;
		try {
			logger.info("Inside pendingDocumentds service");
			if (request.getHeader(Constants.UCTDMS_ID) != null) {
				uctdmsId = Integer.parseInt(request.getHeader(Constants.UCTDMS_ID));
				user = userRepository.getUserDetails(uctdmsId);

				if (user==null) {
					return new UtrustResponse(StatusCodes.UCTDMS_ID_NOT_FOUND.getStatusCode(),
							StatusCodes.UCTDMS_ID_NOT_FOUND.getMessage(), null);
				}
			}
			else {
				return new UtrustResponse(StatusCodes.UCTDMS_ID_NOT_EXISTS.getStatusCode(),
						StatusCodes.UCTDMS_ID_NOT_EXISTS.getMessage(), null);
			}
			if (collVehReq != null) {
				enquiryList = enquiryRepository.getPendingDocuments(collVehReq.getFromDate(), collVehReq.getToDate());
			}
			
			
			if (enquiryList != null) {
				for (Enquiry enquiry : enquiryList) {
					Vehicle vehicle=enquiry.getVehicle();

							collectedVehicleResponse = new CollectedVehicleResponse();
							pendingDocCustResponse = new PendingDocCustResponse();
   
							//collectedVehicleResponse.setPendingDocument(count);
							// setting vehicle response
							collectedVehicleResponse.setCollecteddate(vehicle.getCollectedDate());
							collectedVehicleResponse.setColor(vehicle.getExteriorColor().getName());
							collectedVehicleResponse.setFuel(vehicle.getFuelType());
							collectedVehicleResponse.setMake(vehicle.getMake().getName());
							collectedVehicleResponse.setModel(vehicle.getModel().getName());
							collectedVehicleResponse.setOdoMeter(vehicle.getMileage());
							collectedVehicleResponse.setRegNumber(vehicle.getRegistrationNumber());
							collectedVehicleResponse.setTransmission(vehicle.getTransmissionType());
							collectedVehicleResponse.setVariant(vehicle.getVariant().getName());
							
							List count=checklistMappingRepository.getDocumentsCount(enquiry.getEnquiryNumber());
							Object o =count.get(0);
							Object[] objects = (Object[]) o;  
							BigInteger total= (BigInteger)objects[0];
							BigInteger pending= (BigInteger)objects[1];

							String signOfUrls=checklistMappingRepository.getSignOfUrls(enquiry.getEnquiryNumber(), Constants.SIGNOFF_DOC_ID) ;
							if(signOfUrls != null) {
								collectedVehicleResponse.setSignOff(Arrays.asList(signOfUrls.split(",")));
							}

							//int total= c
						//	int pending= (int) count[0];

							collectedVehicleResponse.setPendingDocument(pending.intValue());
							collectedVehicleResponse.setTotalDocuments(total.intValue());
							if (vehicle.getVehicleStage()!=null) {
								collectedVehicleResponse.setVehicleStageId(vehicle.getVehicleStage().getStageId());
							}
 							collectedVehicleResponse.setYear(vehicle.getYear());
							collectedVehicleResponse.setEnquiryNumber(vehicle.getEnquiryList().get(0).getEnquiryNumber());

							// setting customer details response
							Customer customer=vehicle.getCustomer();
							if (customer != null) {
								firstName = customer.getFirstName();
								middleName = customer.getMiddleName();
								lastName = customer.getLastName();
								mobileNo = customer.getMobileNumber();
								if(middleName!=null)
								 pendingDocCustResponse.setName(firstName + " " + middleName + " " + lastName);
								else
									pendingDocCustResponse.setName(firstName + " " + lastName);
								pendingDocCustResponse.setMobileNo(mobileNo);
							}

							Integer poId = vehicle.getEnquiryList().get(0).getAssignTo();
							user = userRepository.getUserDetails(poId);
							if (user != null) {
								collectedVehicleResponse.setPoName(user.getFirstName() + " " + user.getLastName());
							}

							pendingDocumentResponse = new PendingDocumentResponse();
							pendingDocumentResponse.setCollectedVehicleResponse(collectedVehicleResponse);
							pendingDocumentResponse.setPendingDocCustResponse(pendingDocCustResponse);
							pendingDocumentResponseList.add(pendingDocumentResponse);
					}
				}
				return new UtrustResponse(StatusCodes.PENDING_DOCUMENTS_SUCCESS.getStatusCode(),
						StatusCodes.PENDING_DOCUMENTS_SUCCESS.getMessage(), pendingDocumentResponseList);

		} catch (Exception e) {
			logger.error(Constants.EXCEPTION, e + " uctdmsId : " + uctdmsId, " collVehReq::" + collVehReq);
			return new UtrustResponse(StatusCodes.PENDING_DOCUMENTS_FAIL.getStatusCode(),
					StatusCodes.PENDING_DOCUMENTS_FAIL.getMessage(), null);
		}
	}
	
	@Override
	@Transactional
	public UtrustResponse getSubordinates(HttpServletRequest request) {
		List<UserResponse> ptlList = null;
		List<UserResponse> polist = null;
		Integer uctdmsId = null;
		try {
			if (request.getHeader(Constants.UCTDMS_ID) != null) {
				uctdmsId = Integer.parseInt(request.getHeader(Constants.UCTDMS_ID));
				User user = userRepository.getUserDetails(uctdmsId);
				if (user == null) {
					return new UtrustResponse(StatusCodes.UCTDMS_ID_NOT_FOUND.getStatusCode(),
							StatusCodes.UCTDMS_ID_NOT_FOUND.getMessage(), null);
				}
			} else {
				return new UtrustResponse(StatusCodes.UCTDMS_ID_NOT_EXISTS.getStatusCode(),
						StatusCodes.UCTDMS_ID_NOT_EXISTS.getMessage(), null);
			}
			List<PTLUserResponse> ptlLists = new ArrayList<>();
			User user = userRepository.getUserDetails(uctdmsId);

			if (user.getUserRoleId() == Constants.UCM_ROLE) {
				logger.info("uctdmsId " + uctdmsId + "UCM_ROLE:" + Constants.UCM_ROLE);
				ptlList = entityManager.getListOfReporties(uctdmsId);
				if (ptlList != null) {
					for (UserResponse ptlUserResponse : ptlList) {
						PTLUserResponse ptlResponse = new PTLUserResponse();
						polist = entityManager.getListOfReporties(ptlUserResponse.getId());
						ptlResponse.setId(ptlUserResponse.getId());
						ptlResponse.setName(ptlUserResponse.getName());
						ptlResponse.setPoList(polist);
						ptlLists.add(ptlResponse);
					}
				}

				Map<String, List<PTLUserResponse>> ptlMap = new HashMap<>();
				ptlMap.put("ptlList", ptlLists);
				return new UtrustResponse(StatusCodes.FETCH_SUBORDINATES_SUCCESS.getStatusCode(),
						StatusCodes.FETCH_SUBORDINATES_SUCCESS.getMessage(), ptlMap);
			} else if (user.getUserRoleId() == Constants.PTL_ROLE) {
				logger.info("uctdmsId " + uctdmsId + "PTL_ROLE:" + Constants.PTL_ROLE);
				polist = entityManager.getListOfReporties(uctdmsId);

				Map<String, List<UserResponse>> poMap = new HashMap<>();
				poMap.put("poList", polist);
				return new UtrustResponse(StatusCodes.FETCH_SUBORDINATES_SUCCESS.getStatusCode(),
						StatusCodes.FETCH_SUBORDINATES_SUCCESS.getMessage(), poMap);
			}
			return new UtrustResponse(StatusCodes.FETCH_SUBORDINATES_SUCCESS.getStatusCode(),
					StatusCodes.FETCH_SUBORDINATES_SUCCESS.getMessage(), null);

		} catch (Exception e) {
			logger.error(Constants.EXCEPTION + "uctdmsId :" + uctdmsId, e);
			return new UtrustResponse(StatusCodes.FETCH_SUBORDINATES_FAIL.getStatusCode(),
					StatusCodes.FETCH_SUBORDINATES_FAIL.getMessage(), null);
		}
	}

	@Override
	public UtrustResponse sendOtp(OtpRequest otpRequest, HttpServletRequest request) {
		
		try {
			Integer uctdmsId = null;
 			int type=otpRequest.getType();
 			String mobileNumber=null;
 			Enquiry enquiry = null;
 			Customer customer = null;
 			User user = null;
 			String enqNumber =otpRequest.getEnquiryNumber();
			if (request.getHeader(Constants.UCTDMS_ID) != null) {
				uctdmsId = Integer.parseInt(request.getHeader(Constants.UCTDMS_ID));
				user = userRepository.getUserDetails(uctdmsId);
				if (user == null) {
					return new UtrustResponse(StatusCodes.UCTDMS_ID_NOT_FOUND.getStatusCode(),
							StatusCodes.UCTDMS_ID_NOT_FOUND.getMessage(), null);
				}
			} else {
				return new UtrustResponse(StatusCodes.UCTDMS_ID_NOT_EXISTS.getStatusCode(),
						StatusCodes.UCTDMS_ID_NOT_EXISTS.getMessage(), null);
			}
			String content = entityManager.getSMSContent(otpRequest.getType());
			Dealer dealer = user.getDealer();
			Random random = new Random();
			String newOtp = String.format("%04d", random.nextInt(10000));

			UserOtp userOtp= null ;
			String alternateMobileNumber=otpRequest.getAlternateMobile();
			mobileNumber=otpRequest.getMobileNumber();
			SimpleDateFormat format= new SimpleDateFormat("YYYY-MM-dd HH:mm:ss");
			String newDate=format.format(new Date());
			
			//Basic mobile verify & ENQUIRY not exist
			if (type == Constants.OTP_VERIFY_MOBILE_NUMBER && mobileNumber != null) {
				userOtp = userOtpRepository.getUserOtpByMobile(mobileNumber, type);
				//same OTP for 1 minute
			    if (userOtp != null && otpRequest.getIsResend()) {
					String userDate= format.format(userOtp.getCreatedAt());
					long diffSeconds= (format.parse(newDate).getTime()-format.parse(userDate).getTime())/1000;
			    	if(diffSeconds<=60) {
			    		newOtp = userOtp.getOtp();
			    	}
				}
				String dealerName = dealer.getDealerName();
				String dealerLocation = dealer.getDealerLocation();
	 			 
				content = content.replace(Constants.OTP, newOtp);
				content = content.replace(Constants.DEALER_NAME, dealerName);
				content = content.replace(Constants.DEALER_LOCATION, dealerLocation);
			    alternateMobileNumber=null;
			}
			// OTP_CONFIRM_PURCHASE  & alternateMobileNumber
			else if (type == Constants.OTP_CONFIRM_PURCHASE && alternateMobileNumber != null&&mobileNumber!=null) {
				enquiry = enquiryRepository.getEnquiry(otpRequest.getEnquiryNumber());
				if(enquiry == null) {
					return new UtrustResponse(StatusCodes.ENQUIRY_NOT_FOUND.getStatusCode(),
							StatusCodes.ENQUIRY_NOT_FOUND.getMessage(), null);
				}
				if (otpRequest.getFromPTL()==false) {
					customer = customerRepository.getCustomer(mobileNumber);
					if(customer == null) {
						return new UtrustResponse(StatusCodes.CUSTOMER_NOT_EXIST.getStatusCode(),
								StatusCodes.CUSTOMER_NOT_EXIST.getMessage(), null);
					}
					customer.setAlternateMobileNumber(alternateMobileNumber);
					customerRepository.save(customer);
					// deviceToken PTL
					UserDevice userDevice=deviceRepository.getUserDevice(user.getReportingTo());
					// Send push notification to PTL for approval
					notificationUtil.sendNotification(uctdmsId,user.getReportingTo(),Constants.EVENT_ALTERNATE_NUMBER_APPROVAL_REQUEST,userDevice,enquiry,null, null);
				}
				userOtp = userOtpRepository.getUserOtpByAlternateMobile(alternateMobileNumber, type);
				//same OTP for 1 minute
				if (userOtp != null && otpRequest.getIsResend()) {
					String userDate= format.format(userOtp.getCreatedAt());
					long diffSeconds= (format.parse(newDate).getTime()-format.parse(userDate).getTime())/1000;
			    	if(diffSeconds<=60) {
			    		newOtp = userOtp.getOtp();
			    	}
				}
				String dealerName = dealer.getDealerName();
				String dealerLocation = dealer.getDealerLocation();

				content = content.replace(Constants.OTP, newOtp);
				content = content.replace(Constants.DEALER_NAME, dealerName);
				content = content.replace(Constants.DEALER_LOCATION, dealerLocation);
			}
			// OTP_CONFIRM_PURCHASE  and enquiryNumber should be present
			else if(type == Constants.OTP_CONFIRM_PURCHASE && enqNumber != null){
				enquiry = enquiryRepository.getEnquiry(otpRequest.getEnquiryNumber());
				if(enquiry == null) {
					return new UtrustResponse(StatusCodes.ENQUIRY_NOT_FOUND.getStatusCode(),
							StatusCodes.ENQUIRY_NOT_FOUND.getMessage(), null);
				}
				customer = enquiry.getCustomer();
				
				if (mobileNumber.equals(customer.getMobileNumber())) {
					mobileNumber = customer.getMobileNumber();
				}
				else {
					return new UtrustResponse(StatusCodes.MISMATCH_ENQURY_AND_MOBILE.getStatusCode(),
							StatusCodes.MISMATCH_ENQURY_AND_MOBILE.getMessage(), null);
				}
				userOtp = userOtpRepository.getUserOtpByEnquiry(type,enqNumber,mobileNumber);
			
				//same OTP for 1 minute
				if (userOtp != null && otpRequest.getIsResend()) {
					String userDate= format.format(userOtp.getCreatedAt());
					long diffSeconds= (format.parse(newDate).getTime()-format.parse(userDate).getTime())/1000;
			    	if(diffSeconds<=60) {
			    		newOtp = userOtp.getOtp();
			    	}
				}
				
				String dealerName = dealer.getDealerName();
				String dealerLocation = dealer.getDealerLocation();
				content = content.replace(Constants.OTP, newOtp + "");
				content = content.replace(Constants.DEALER_NAME, dealerName);
				content = content.replace(Constants.DEALER_LOCATION, dealerLocation);
				alternateMobileNumber=null;
				
			}
			if (userOtp == null) {
				userOtp = new UserOtp();
			}
			
			if(!(newOtp.equals(userOtp.getOtp()))){
				// update otp in db
				userOtp.setCreatedAt(new Date());
				userOtp.setMobileNumber(mobileNumber);
				userOtp.setOtp(newOtp + "");
				userOtp.setType(otpRequest.getType());
				userOtp.setIsVerified(false);
				userOtp.setAlternateMobileNumber(alternateMobileNumber);
				userOtp.setEnquiryNumber(otpRequest.getEnquiryNumber());
				
				userOtpRepository.save(userOtp);
			}

			// send OTP to mobile number
			if (alternateMobileNumber==null || otpRequest.getFromPTL()) {
				if (otpRequest.getFromPTL()) {
					mobileNumber=alternateMobileNumber;
				}
				smsUtil.sendSMS(mobileNumber, content);
			}
			else{
				return new UtrustResponse(StatusCodes.ALTERNATE_MOBILE_APPROVAL.getStatusCode(),
						StatusCodes.ALTERNATE_MOBILE_APPROVAL.getMessage(), null);
			}
			return new UtrustResponse(StatusCodes.OTP_SENT_SUCCESS.getStatusCode(),
					StatusCodes.OTP_SENT_SUCCESS.getMessage(), null);

		} catch (Exception e) {
			logger.error("send otpRequest ::"+otpRequest+"\n"+Constants.EXCEPTION, e);
			return new UtrustResponse(StatusCodes.OTP_SENT_FAIL.getStatusCode(),
				StatusCodes.OTP_SENT_FAIL.getMessage(), null);}
	}
	

	@Override
	public UtrustResponse verifyOtp(OtpRequest otpRequest, HttpServletRequest request) {

		try {
			logger.info("verifyOtp : " + otpRequest);
			Integer uctdmsId = null;
			User user = null;
			String enqNumber = otpRequest.getEnquiryNumber();
			Enquiry enquiry = null;
			int type = otpRequest.getType();
			String alternateMobileNumber = otpRequest.getAlternateMobile();
			String mobileNumber = otpRequest.getMobileNumber();
			UserOtp userOtp = null;

			if (request.getHeader(Constants.UCTDMS_ID) != null) {
				uctdmsId = Integer.parseInt(request.getHeader(Constants.UCTDMS_ID));
				user = userRepository.getUserDetails(uctdmsId);
				if (user == null) {
					return new UtrustResponse(StatusCodes.UCTDMS_ID_NOT_FOUND.getStatusCode(),
							StatusCodes.UCTDMS_ID_NOT_FOUND.getMessage(), null);
				}
			} else {
				return new UtrustResponse(StatusCodes.UCTDMS_ID_NOT_EXISTS.getStatusCode(),
						StatusCodes.UCTDMS_ID_NOT_EXISTS.getMessage(), null);
			}
			
			SimpleDateFormat format= new SimpleDateFormat("YYYY-MM-dd HH:mm:ss");
			String newDate=format.format(new Date());

			// Basic VERIFY_MOBILE_NUMBER
			if (type == Constants.OTP_VERIFY_MOBILE_NUMBER && mobileNumber != null) {
				userOtp = userOtpRepository.getUserOtpByMobile(mobileNumber,
						Constants.OTP_VERIFY_MOBILE_NUMBER);
				if(userOtp != null) {
					String userDate= format.format(userOtp.getCreatedAt());
					long diffSeconds= (format.parse(newDate).getTime()-format.parse(userDate).getTime())/1000;
					if(diffSeconds <= 60) {
						if(userOtp.getOtp().equals(otpRequest.getOtp())) {
							userOtp.setIsVerified(true);
							userOtpRepository.save(userOtp);
							Customer customer = customerRepository.getCustomer(otpRequest.getMobileNumber());
							if (customer != null) {
								// setting customer verified
								customer.setIsVerified(true);
								customerRepository.save(customer);
							}
							return new UtrustResponse(StatusCodes.OTP_VERIFY_SUCCESS.getStatusCode(),
									StatusCodes.OTP_VERIFY_SUCCESS.getMessage(), null);
						} else {
							return new UtrustResponse(StatusCodes.OTP_DOES_NOT_MATCH.getStatusCode(),
									StatusCodes.OTP_DOES_NOT_MATCH.getMessage(), null);
						}
					}else {
						return new UtrustResponse(StatusCodes.OTP_EXPIRED.getStatusCode(),
								StatusCodes.OTP_EXPIRED.getMessage());
					}
				}else {
					return new UtrustResponse(StatusCodes.USEROTP_RECORD_NOT_FOUND.getStatusCode(),
							StatusCodes.USEROTP_RECORD_NOT_FOUND.getMessage());
				}
			}	


			// alternateMobileNumber && OTP_CONFIRM_PURCHASE
			else if (enqNumber != null && type == Constants.OTP_CONFIRM_PURCHASE && alternateMobileNumber != null
					&& mobileNumber != null) {
				Map<String, String> map = new HashMap<>();
				map.put(Constants.PURCHASE_NUMBER, null);
				userOtp = userOtpRepository.getUserOtpByAlternateMobile(otpRequest.getAlternateMobile(),
						Constants.OTP_CONFIRM_PURCHASE);
				
				enquiry = enquiryRepository.getEnquiry(enqNumber);
				if (enquiry == null) {
					return new UtrustResponse(StatusCodes.ENQUIRY_NOT_FOUND.getStatusCode(),
							StatusCodes.ENQUIRY_NOT_FOUND.getMessage(), null);
				}
				
				if (userOtp != null) {
					String userDate = format.format(userOtp.getCreatedAt());
					long diffSeconds = (format.parse(newDate).getTime() - format.parse(userDate).getTime()) / 1000;
					if (diffSeconds <= 60) {
						if (userOtp.getOtp().equals(otpRequest.getOtp())) {
							userOtp.setIsVerified(true);
							userOtpRepository.save(userOtp);
							Customer customer = customerRepository.getCustomer(mobileNumber);

							// saving purchase number to ENQUIRY
							if (otpRequest.getFromPTL()) {
								String purchaseNumber = enquiryRepository.getLatestPurchaseNumber();
								if (purchaseNumber == null) {
									purchaseNumber = Constants.PURCHASE + Constants.PURCHASE_INITIAL_NUMBER;
								} else {
									purchaseNumber = purchaseNumber.replace(Constants.PURCHASE, "");
									Integer purchaseNo = Integer.parseInt(purchaseNumber);
									purchaseNo++;
									purchaseNumber = Constants.PURCHASE + String.format("%04d", purchaseNo);
								}
								enquiry.setPurchaseNumber(purchaseNumber);
								enquiryRepository.save(enquiry);
								map.put(Constants.PURCHASE_NUMBER, purchaseNumber);
							}

							if (customer != null) {
								// setting customer verified
								customer.setIsVerified(true);
								customerRepository.save(customer);
							}
							return new UtrustResponse(StatusCodes.OTP_VERIFY_SUCCESS.getStatusCode(),
									StatusCodes.OTP_VERIFY_SUCCESS.getMessage(), map);
						} else {
							return new UtrustResponse(StatusCodes.OTP_DOES_NOT_MATCH.getStatusCode(),
									StatusCodes.OTP_DOES_NOT_MATCH.getMessage(), null);
						}
					} else {
						return new UtrustResponse(StatusCodes.OTP_EXPIRED.getStatusCode(),
								StatusCodes.OTP_EXPIRED.getMessage());
					}
				}else {
					return new UtrustResponse(StatusCodes.USEROTP_RECORD_NOT_FOUND.getStatusCode(),
							StatusCodes.USEROTP_RECORD_NOT_FOUND.getMessage());
				}
			}

			// OTP_CONFIRM_PURCHASE With ENQUIRY
			else if (alternateMobileNumber == null && enqNumber != null && mobileNumber != null
					&& type == Constants.OTP_CONFIRM_PURCHASE) {
				Map<String, String> map = new HashMap<>();
				enquiry = enquiryRepository.getEnquiry(enqNumber);
				if (enquiry == null) {
					return new UtrustResponse(StatusCodes.ENQUIRY_NOT_FOUND.getStatusCode(),
							StatusCodes.ENQUIRY_NOT_FOUND.getMessage(), null);
				}
				Vehicle vehicle = enquiry.getVehicle();
				Customer customer = enquiry.getCustomer();

				if (mobileNumber.equals(customer.getMobileNumber())) {
					mobileNumber = customer.getMobileNumber();
				} else {
					return new UtrustResponse(StatusCodes.MISMATCH_ENQURY_AND_MOBILE.getStatusCode(),
							StatusCodes.MISMATCH_ENQURY_AND_MOBILE.getMessage(), null);
				}
				userOtp = userOtpRepository.getUserOtpByEnquiry(Constants.OTP_CONFIRM_PURCHASE, enqNumber,
						mobileNumber);
				vehicle.setCollectedDate(new Date());
				if (userOtp != null) {
					String userDate = format.format(userOtp.getCreatedAt());
					long diffSeconds = (format.parse(newDate).getTime() - format.parse(userDate).getTime()) / 1000;
					if (diffSeconds <= 60) {
						if (userOtp.getOtp().equals(otpRequest.getOtp())) {
							vehicle.setPurchaseDate(new Date());
							vehicle.setVehicleStage(enquiryEntityManager.getVehicleStage(Constants.OTP_CONFIRM_PURCHASE));
							enquiry.setVehicle(vehicle);
							userOtp.setIsVerified(true);
							userOtpRepository.save(userOtp);
							// setting customer verified
							customer.setIsVerified(true);
							enquiry.setCustomer(customer);

							// saving purchase number to ENQUIRY
							String purchaseNumber = enquiryRepository.getLatestPurchaseNumber();
							if (purchaseNumber == null) {
								purchaseNumber = Constants.PURCHASE + Constants.PURCHASE_INITIAL_NUMBER;
							} else {
								purchaseNumber = purchaseNumber.replace(Constants.PURCHASE, "");
								Integer purchaseNo = Integer.parseInt(purchaseNumber);
								purchaseNo++;
								purchaseNumber = Constants.PURCHASE + String.format("%04d", purchaseNo);
							}
							enquiry.setPurchaseNumber(purchaseNumber);
							enquiryRepository.save(enquiry);
							map.put(Constants.PURCHASE_NUMBER, purchaseNumber);

							// deviceToken PTL
							UserDevice userDevice = deviceRepository.getUserDevice(user.getReportingTo());
							// Send push notification to PTL
							notificationUtil.sendNotification(uctdmsId, user.getReportingTo(),
									Constants.EVENT_VEHICLE_COLLECTION_CONFIRMED, userDevice, enquiry, null, null);

							return new UtrustResponse(StatusCodes.OTP_VERIFY_SUCCESS.getStatusCode(),
									StatusCodes.OTP_VERIFY_SUCCESS.getMessage(), map);

						} else {
							return new UtrustResponse(StatusCodes.OTP_DOES_NOT_MATCH.getStatusCode(),
									StatusCodes.OTP_DOES_NOT_MATCH.getMessage(), null);
						}
					} else {
						return new UtrustResponse(StatusCodes.OTP_EXPIRED.getStatusCode(),
								StatusCodes.OTP_EXPIRED.getMessage());
					}
				}else {
					return new UtrustResponse(StatusCodes.USEROTP_RECORD_NOT_FOUND.getStatusCode(),
							StatusCodes.USEROTP_RECORD_NOT_FOUND.getMessage());
				}
			}
				
			else if (type == Constants.OTP_COMPLETE_VALUATION) {
				// send otp to the customer
				String content = entityManager.getSMSContent(Constants.SMS_CONTENT_VALUATION);
				smsUtil.sendSMS(mobileNumber, content);
				return new UtrustResponse(StatusCodes.OTP_VERIFY_SUCCESS.getStatusCode(),
						StatusCodes.OTP_VERIFY_SUCCESS.getMessage(), null);
			}
			return new UtrustResponse(StatusCodes.NO_OTP_ACTION.getStatusCode(), 
					StatusCodes.NO_OTP_ACTION.getMessage(),null);
		} catch (Exception e) {
			logger.error(Constants.EXCEPTION, e);
			return new UtrustResponse(StatusCodes.OTP_VERIFY_FAIL.getStatusCode(),
					StatusCodes.OTP_VERIFY_FAIL.getMessage(), null);
		}
	}

	@Override
	public UtrustResponse getPricingChartData(PricingChartDataRequest pricingChartDataRequest,HttpServletRequest request) {

		ChartDataResponse_copy chartDataResponseCopy = null;
		CarVolumeResponse carVolResp = null;
		PriceRangeResponse priceRangeResponse = null;
		PricingChartDataInfo pricingChartDataInfo = null;

		List<SimilarTransaction_copy> similarTransactionList = null;
		List<CarVolume_copy> carVolumeList = new ArrayList<>();
		List<SimilarTransactionResponse> simTxnRespList = new ArrayList<>();
		List<Integer> volumeList = new ArrayList<>();
		List<Double> labelList = new ArrayList<>();

		Integer uctdmsId = null;
		User user = null;
		try {
			logger.info("Inside getPricingChartData service...");
			if (request.getHeader(Constants.UCTDMS_ID) != null) {
				uctdmsId = Integer.parseInt(request.getHeader(Constants.UCTDMS_ID));
				user = userRepository.getUserDetails(uctdmsId);

				if (user == null) {
					return new UtrustResponse(StatusCodes.UCTDMS_ID_NOT_FOUND.getStatusCode(),
							StatusCodes.UCTDMS_ID_NOT_FOUND.getMessage(), null);
				}
			} else {
				return new UtrustResponse(StatusCodes.UCTDMS_ID_NOT_EXISTS.getStatusCode(),
						StatusCodes.UCTDMS_ID_NOT_EXISTS.getMessage(), null);
			}
			pricingChartDataInfo = enquiryEntityManager.getPricingChartDataByByCarMake(pricingChartDataRequest.getCarMake());
			chartDataResponseCopy = new ChartDataResponse_copy();
			if (pricingChartDataInfo != null) {
				// preparing pricing data
				priceRangeResponse = new PriceRangeResponse();
				BeanUtils.copyProperties(pricingChartDataInfo, priceRangeResponse);

				// preparing similarTransaction
				similarTransactionList = pricingChartDataInfo.getSimilarTransaction();
				if (similarTransactionList != null && !(similarTransactionList.isEmpty())) {
					for (SimilarTransaction_copy similarTransaction : similarTransactionList) {
						SimilarTransactionResponse simTxnResp = new SimilarTransactionResponse();
						BeanUtils.copyProperties(similarTransaction, simTxnResp);
						simTxnRespList.add(simTxnResp);
					}
				}

				// preparing Car Volume Response
				carVolumeList = pricingChartDataInfo.getCarVolumeList();
				if (carVolumeList != null && !carVolumeList.isEmpty()) {
					for (CarVolume_copy carVol : carVolumeList) {
						labelList.add(carVol.getLabel());
						volumeList.add(carVol.getVolume());
					}
					carVolResp = new CarVolumeResponse();
					carVolResp.setLabel(labelList);
					carVolResp.setVolume(volumeList);
				}
				
				chartDataResponseCopy.setPriceRangeResponse(priceRangeResponse);
				chartDataResponseCopy.setCarVolumeResponse(carVolResp);
				chartDataResponseCopy.setSimilarTransactionResponse(simTxnRespList);

				return new UtrustResponse(StatusCodes.CHART_DATA_RETRIEVE_SUCCESS.getStatusCode(),
						StatusCodes.CHART_DATA_RETRIEVE_SUCCESS.getMessage(), chartDataResponseCopy);
			} else {
				logger.debug("Couldn't retrieve Chart data ::" + pricingChartDataRequest);
				return new UtrustResponse(StatusCodes.CHART_DATA_NOT_AVAILABLE.getStatusCode(),
						StatusCodes.CHART_DATA_NOT_AVAILABLE.getMessage(), chartDataResponseCopy);
			}
		} catch (Exception e) {
			logger.error("PricingChartDataRequest ::"+pricingChartDataRequest+"\n"+Constants.EXCEPTION, e);
			return new UtrustResponse(StatusCodes.CHART_DATA_RETRIEVE_FAIL.getStatusCode(),
					StatusCodes.CHART_DATA_RETRIEVE_FAIL.getMessage());
		}
	}
	
	
}

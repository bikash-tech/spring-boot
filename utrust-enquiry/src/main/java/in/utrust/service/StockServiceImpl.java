package in.utrust.service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import in.utrust.constants.Constants;
import in.utrust.constants.StatusCodes;
import in.utrust.model.Channel;
import in.utrust.model.Customer;
import in.utrust.model.Dealer;
import in.utrust.model.DealerUser;
import in.utrust.model.DemandStructure;
import in.utrust.model.Enquiry;
import in.utrust.model.EnquiryType;
import in.utrust.model.ExteriorColor;
import in.utrust.model.FollowUp;
import in.utrust.model.InsuranceType;
import in.utrust.model.Make;
import in.utrust.model.Model;
import in.utrust.model.NegotiationHistory;
import in.utrust.model.SellingReason;
import in.utrust.model.SourceName;
import in.utrust.model.SourceType;
import in.utrust.model.StatusReasoning;
import in.utrust.model.User;
import in.utrust.model.Variant;
import in.utrust.model.Vehicle;
import in.utrust.model.WantList;
import in.utrust.repository.DealerRepository;
import in.utrust.repository.EnquiryRepository;
import in.utrust.repository.FollowUpRepository;
import in.utrust.repository.NegotiationHistoryRepository;
import in.utrust.repository.UserRepository;
import in.utrust.repository.VehicleRepository;
import in.utrust.repository.WantlistRepository;
import in.utrust.request.StockMatchingRequest;
import in.utrust.response.ActualFollowUpResponse;
import in.utrust.response.BasicDetailsResponse;
import in.utrust.response.ChannelResponse;
import in.utrust.response.CustomerResponse;
import in.utrust.response.DemandStructureResponse;
import in.utrust.response.EnquiryResponse;
import in.utrust.response.EnquiryTypeResponse;
import in.utrust.response.ExteriorColorResponse;
import in.utrust.response.FollowUpResponse;
import in.utrust.response.InsuranceTypeResponse;
import in.utrust.response.MakeResponse;
import in.utrust.response.ModelResponse;
import in.utrust.response.NegotiationResponse;
import in.utrust.response.NextFollowUpResponse;
import in.utrust.response.SellingReasonResponse;
import in.utrust.response.SourceNameResponse;
import in.utrust.response.SourceTypeResponse;
import in.utrust.response.StatusReasoningResponse;
import in.utrust.response.StockResponse;
import in.utrust.response.UtrustResponse;
import in.utrust.response.VariantResponse;
import in.utrust.response.VehicleResponse;
import in.utrust.response.VehicleResponseStock;
import in.utrust.response.WantListResponse;

@Service("StockService")
public class StockServiceImpl implements StockService {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	WantlistRepository wantlistRepository;

	@Autowired
	VehicleRepository vehicleRepository;

	@Autowired
	EnquiryRepository enquiryRepository;

	@Autowired
	private FollowUpRepository followUpRepository;

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private DealerRepository dealerRepository;


	@Autowired
	private NegotiationHistoryRepository negotiationHistRepository;

	@Override
	@Transactional
	public UtrustResponse getVehicleStockData(Integer makeId, Integer modelId, Integer modelYear, Integer variantId,
			Integer pageNumber, HttpServletRequest request) {


		Integer uctdmsId=null;
		User user = null;
		try {
			logger.info("Inside Master Enquiry..");
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
			StockResponse stockResponse = new StockResponse();
			//Page number for response data from query
			pageNumber = pageNumber - 1;
			
			makeId = ((makeId == null) || (makeId == 0)) ? 0 : makeId;
			modelId = ((modelId == null) || (modelId == 0)) ? 0 : modelId;
			modelYear = ((modelYear == null) || (modelYear == 0)) ? 0 : modelYear;
			variantId = ((variantId == null) || (variantId == 0)) ? 0 : variantId;
			//Logic to get the Stock matching data by the given Page number
//			List<Vehicle> vehicle = vehicleRepository.getGivenStockData(modelId, makeId, variantId, modelYear,Constants.VEHICLE_SOLD,
//					PageRequest.of(pageNumber, 20));
			List<Vehicle> vehicle = null;
			List<VehicleResponseStock> lResponses = new ArrayList<>();
			if (!vehicle.isEmpty()) {
				for (Vehicle vehicle2 : vehicle) {
					VehicleResponseStock vehicleResponse = new VehicleResponseStock();
					Variant variant = vehicle2.getVariant();
					Model model = vehicle2.getModel();
					Make make = vehicle2.getMake();
					ExteriorColor color = vehicle2.getExteriorColor();
					if (variant != null) {
						VariantResponse variantResponse = new VariantResponse();
						variantResponse.setName(variant.getName());
						variantResponse.setVariantId(variant.getVariantId());
						vehicleResponse.setVariantResponse(variantResponse);
					}
					if (model != null) {
						ModelResponse modelResponse = new ModelResponse();
						modelResponse.setModelId(model.getModelId());
						modelResponse.setName(model.getName());
						vehicleResponse.setModelResponse(modelResponse);
					}
					if (make != null) {
						MakeResponse makeResponse = new MakeResponse();
						makeResponse.setMakeId(make.getMakeId());
						makeResponse.setName(make.getName());
						vehicleResponse.setMakeResponse(makeResponse);
					}
					if (color != null) {
//						vehicleResponse.setExteriorColorId(color.getExteriorColorId());
//						vehicleResponse.setExteriorColor(color.getName());
					}
					vehicleResponse.setRegistrationNumber(vehicle2.getRegistrationNumber());
					BeanUtils.copyProperties(vehicle2, vehicleResponse);
					lResponses.add(vehicleResponse);
				}
			}

			//Logic to get the Want_list data by the given page number
			List<Object[]> wantList = wantlistRepository.findByGivendata(modelId, makeId, variantId, modelYear,
					PageRequest.of(pageNumber, 20));

			List<WantListResponse> lWantlistResponses = new ArrayList<WantListResponse>();
			if (!wantList.isEmpty()) {
				for (Object[] wantlist2 : wantList) {
					WantListResponse wantlistResponse = new WantListResponse();
//					wantlistResponse.setWantlist_id((Integer) wantlist2[0]);
//					wantlistResponse.setWantlist_year((Integer) wantlist2[1]);
//					wantlistResponse.setWantlist_count((Integer) wantlist2[2]);
//					wantlistResponse.setCreated_date((Date) wantlist2[3]);
//					wantlistResponse.setUpdated_date((Date) wantlist2[4]);

					// Variant Response
					VariantResponse variantResponse = new VariantResponse();
					variantResponse.setVariantId((Integer) wantlist2[9]);
					variantResponse.setName((String) wantlist2[10]);
					wantlistResponse.setVariantResponse(variantResponse);

					// Model Response
					ModelResponse modelResponse = new ModelResponse();
					modelResponse.setModelId((Integer) wantlist2[5]);
					modelResponse.setName((String) wantlist2[6]);
					wantlistResponse.setModelResponse(modelResponse);

					// Make Response
					MakeResponse makeResponse = new MakeResponse();
					makeResponse.setMakeId((Integer) wantlist2[7]);
					makeResponse.setName((String) wantlist2[8]);
					wantlistResponse.setMakeResponse(makeResponse);

//					wantlistResponse.setColor_id((Integer) wantlist2[11]);
//					wantlistResponse.setColor_name((String) wantlist2[12]);
//					wantlistResponse.setUpdated_by_id((Integer) wantlist2[13]);
//					wantlistResponse.setUpdated_by_name((String) wantlist2[14]);
					BeanUtils.copyProperties(wantlist2, wantlistResponse);
					lWantlistResponses.add(wantlistResponse);
				}

			}

			//Logic to get the Buyer enquire data by the given page number
			List<Enquiry> lEnquiries = enquiryRepository.findByEnquiryCategoryInRange("Buyer",
					PageRequest.of(pageNumber, 20));
			List<EnquiryResponse> listEnqResponse = new ArrayList<>();
			for (Enquiry enquiry : lEnquiries) {
				EnquiryResponse enquiryResponse = stockBuyerEnquiryResponse(enquiry);
				listEnqResponse.add(enquiryResponse);
			}

			stockResponse.setStockMatchingResponse(lResponses);
			stockResponse.setWantListResponse(lWantlistResponses);
			stockResponse.setBuyerEnquiryResponse(listEnqResponse);

			return new UtrustResponse(StatusCodes.STOCK_ENQUIRY_DATA_SUCCESS.getStatusCode(),
					StatusCodes.STOCK_ENQUIRY_DATA_SUCCESS.getMessage(), stockResponse);
		}
		catch(Exception e) {
			logger.error(Constants.EXCEPTION, e+ "uctdmId :"+uctdmsId);
			return new UtrustResponse(StatusCodes.STOCK_ENQUIRY_DATA_FAIL.getStatusCode(),
					StatusCodes.STOCK_ENQUIRY_DATA_FAIL.getMessage(), null);
		}
		
	}

	/**
	 * Stock Data ENQUIRY
	 */
	
	@Override
	public UtrustResponse getVehicleStockData_Modified(StockMatchingRequest stockData, HttpServletRequest request) {
		
		VehicleResponseStock vehicleResponse = null;
		Integer uctdmsId = null;
		User user = null;
		try {
			logger.info("Inside Stock Data...");
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
			Integer makeId =stockData.getMakeId();
			Integer modelId =stockData.getModelId();
			Integer year=stockData.getYear();
			Integer variantId=stockData.getVariantId();
			
			makeId = (makeId == 0) ? null : makeId;
			modelId = (modelId == 0) ? null : modelId;
			year = (year == 0) ? null : year;
			variantId = (variantId == 0) ? null : variantId;

			StockResponse stockResponse = new StockResponse();
			
			Dealer dealer=user.getDealer();
			List<String> branchCodeList = dealerRepository.getDealerByDealerCode(dealer.getDealerCode());
			//Getting vehicle list after user login
			List<Vehicle> vehicleList = vehicleRepository.getGivenStockData(branchCodeList,makeId, modelId, variantId, year, Constants.VEHICLE_SOLD);
			
			// Logic to get Vehicle list
			List<VehicleResponseStock> vehicleResponseStockList = new ArrayList<>();
			for (Vehicle vehicle : vehicleList) {
				vehicleResponse = createStockMatchingVechileResponse(vehicle);
				vehicleResponseStockList.add(vehicleResponse);
			}

			//Logic to get the Buyer enquire data
			List<Enquiry> allBuyerEnquiryList=new ArrayList<>();
			for (Vehicle vehicle : vehicleList) {
				List<Enquiry> enqList = vehicle.getEnquiryList();
				for (Enquiry enquiry : enqList) {
					allBuyerEnquiryList.add(enquiry);
				}
			}
			EnquiryResponse enquiryResponse=null;
			List<EnquiryResponse> enquiryResponseList= new ArrayList<>();
			List<Enquiry> buyerEnquiryList = enquiryRepository.getBuyerEnquiry(branchCodeList,makeId, modelId, variantId, year,Constants.VEHICLE_SOLD,Constants.BUYER,Constants.DROPPED,Constants.SUCCESS);
			
			if (buyerEnquiryList != null && !(buyerEnquiryList.isEmpty())) {
				for (Enquiry enquiry : buyerEnquiryList) {
					enquiryResponse = stockBuyerEnquiryResponse(enquiry);
					enquiryResponseList.add(enquiryResponse);
				}
			}
			else {
				for (Enquiry enquiry : allBuyerEnquiryList) {
					enquiryResponse = stockBuyerEnquiryResponse(enquiry);
					enquiryResponseList.add(enquiryResponse);
				}
			}
			
			List<WantListResponse> wantlistResponsesList = new ArrayList<WantListResponse>();
			List<WantList> wantList=wantlistRepository.getWantListByBranchCodeList(branchCodeList);
			WantListResponse wantListResponse =null;
			
			for (WantList want : wantList) {
				wantListResponse=createStockMatchingWantListResponse(want);
				wantlistResponsesList.add(wantListResponse);
			}
			stockResponse.setWantListResponse(wantlistResponsesList);
			stockResponse.setBuyerEnquiryResponse(enquiryResponseList);
			stockResponse.setStockMatchingResponse(vehicleResponseStockList);
			
			return new UtrustResponse(StatusCodes.STOCK_ENQUIRY_DATA_SUCCESS.getStatusCode(),
					StatusCodes.STOCK_ENQUIRY_DATA_SUCCESS.getMessage(), stockResponse);
			
		} catch (Exception e) {
			logger.error("stockData request body ::"+stockData+"\n"+Constants.EXCEPTION, e);
			e.printStackTrace();
			return new UtrustResponse(StatusCodes.STOCK_ENQUIRY_DATA_FAIL.getStatusCode(),
					StatusCodes.STOCK_ENQUIRY_DATA_FAIL.getMessage(), null);
		}
	}
	
	/**
	 * Reusable method for VehicleResponseStock
	 * @param vehicle
	 * @return
	 */
	private VehicleResponseStock createStockMatchingVechileResponse(Vehicle vehicle) {
		Variant variant = null;
		Model model = null;
		Make make = null;
		ExteriorColor color = null;

		VehicleResponseStock vehicleResponseStock = new VehicleResponseStock();
		BeanUtils.copyProperties(vehicle, vehicleResponseStock);
		variant = vehicle.getVariant();
		model = vehicle.getModel();
		make = vehicle.getMake();
		color = vehicle.getExteriorColor();
		vehicleResponseStock.setVehicleStageId(vehicle.getVehicleStage().getStageId());
		if (variant != null) {
			VariantResponse variantResponse = new VariantResponse();
			variantResponse.setName(variant.getName());
			variantResponse.setVariantId(variant.getVariantId());
			vehicleResponseStock.setVariantResponse(variantResponse);
		}
		if (model != null) {
			ModelResponse modelResponse = new ModelResponse();
			modelResponse.setModelId(model.getModelId());
			modelResponse.setName(model.getName());
			vehicleResponseStock.setModelResponse(modelResponse);
		}
		if (make != null) {
			MakeResponse makeResponse = new MakeResponse();
			makeResponse.setMakeId(make.getMakeId());
			makeResponse.setName(make.getName());
			vehicleResponseStock.setMakeResponse(makeResponse);
		}
		if (color != null) {
			ExteriorColorResponse exteriorColorResponse=new ExteriorColorResponse();
			exteriorColorResponse.setExteriorColorId(color.getExteriorColorId());
			exteriorColorResponse.setName(color.getName());
			vehicleResponseStock.setColorResponse(exteriorColorResponse);
		}
		return vehicleResponseStock;
	}

	
	private WantListResponse createStockMatchingWantListResponse(WantList wantList) {
		Variant variant = null;
		Model model = null;
		Make make = null;
		ExteriorColor color = null;

		WantListResponse wantListResponse = new WantListResponse();
		BeanUtils.copyProperties(wantList, wantListResponse);
		variant = wantList.getVariant();
		model = wantList.getModel();
		make = wantList.getMake();
		color = wantList.getExteriorColor();
		User user=userRepository.getUserDetails(wantList.getUpdatedBy());
		wantListResponse.setWantListId(wantList.getId());
		if(user !=null) {
			wantListResponse.setUpdatedBy(user.getFirstName()+" "+user.getLastName());
		}
		if (variant != null) {
			VariantResponse variantResponse = new VariantResponse();
			variantResponse.setName(variant.getName());
			variantResponse.setVariantId(variant.getVariantId());
			wantListResponse.setVariantResponse(variantResponse);
		}
		if (model != null) {
			ModelResponse modelResponse = new ModelResponse();
			modelResponse.setModelId(model.getModelId());
			modelResponse.setName(model.getName());
			wantListResponse.setModelResponse(modelResponse);
		}
		if (make != null) {
			MakeResponse makeResponse = new MakeResponse();
			makeResponse.setMakeId(make.getMakeId());
			makeResponse.setName(make.getName());
			wantListResponse.setMakeResponse(makeResponse);
		}
		if (color != null) {
			ExteriorColorResponse colorResponse = new ExteriorColorResponse();
			colorResponse.setExteriorColorId(color.getExteriorColorId());
			colorResponse.setName(color.getName());
			wantListResponse.setColorResponse(colorResponse);
		}

		return wantListResponse;

	}


	/**
	 * Reusable method for getting ResponseEntity of ENQUIRY Object
	 * 
	 * @param enquiry
	 * @return EnquiryResponse
	 */
	private EnquiryResponse stockBuyerEnquiryResponse(Enquiry enquiry) {
		BasicDetailsResponse basicResponse = new BasicDetailsResponse();
		VehicleResponse vehicleResponse = null;
		EnquiryResponse enquiryResponse = null;
		CustomerResponse cusResponse = null;
		NegotiationResponse negotiationResponse = null;

		Customer customer = null;
		Vehicle vehicle = null;
		Variant variant = null;
		Model model = null;
		Make make = null;
		StatusReasoning statusReason = null;
		SourceName sourceName = null;
		DemandStructure demandStructure = null;
		Channel channel = null;
		SourceType sourceType = null;
		SellingReason sellingReason = null;
		EnquiryType enquiryType = null;
		ExteriorColor color = null;
		InsuranceType insuranceType = null;
		if (enquiry != null) {
			enquiryResponse = new EnquiryResponse();
			customer = enquiry.getCustomer();
			if (customer != null) {
				cusResponse = new CustomerResponse();
				BeanUtils.copyProperties(customer, cusResponse);
			}

			BeanUtils.copyProperties(enquiry, basicResponse);
			vehicle = enquiry.getVehicle();
			if (vehicle != null) {
				vehicleResponse = new VehicleResponse();
				variant = vehicle.getVariant();
				model = vehicle.getModel();
				make = vehicle.getMake();
				color = vehicle.getExteriorColor();
				insuranceType = vehicle.getInsuranceType();
				BeanUtils.copyProperties(vehicle, vehicleResponse);
				vehicleResponse.setVehicleStageId(vehicle.getVehicleStage().getStageId());
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
			NegotiationHistory NegotiationHistory = negotiationHistRepository
					.findByEnqNumber(enquiry.getEnquiryNumber());

			negotiationResponse = new NegotiationResponse();
			negotiationResponse.setActualPrice(enquiry.getActualPrice());
			negotiationResponse.setExpectedOffer(enquiry.getExpectedOffer());
			negotiationResponse.setSuggestedPrice(enquiry.getSuggestedPrice());
			if (NegotiationHistory != null) {
				negotiationResponse.setLatestExpectedPrice(NegotiationHistory.getLatestExpectedPrice());
				negotiationResponse.setLatestOfferPrice(NegotiationHistory.getLatestOfferPrice());
				negotiationResponse.setPtlRemarks(NegotiationHistory.getPtlRemark());
			}

			// setting basic details for enquiry
			statusReason = enquiry.getStatusReasoning();
			sourceName = enquiry.getSourceName();
			demandStructure = enquiry.getDemandStructure();
			channel = enquiry.getChannel();
			sourceType = enquiry.getSourceType();
			sellingReason = enquiry.getSellingReasoning();
			enquiryType = enquiry.getEnquiryType();

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

			basicResponse.setCustomer(cusResponse);

			DealerUser dealerUserSo = enquiry.getDealerUserSo();
			if (dealerUserSo != null) {
				basicResponse.setSoId(dealerUserSo.getDealerUserId());
				basicResponse.setSoName(dealerUserSo.getFirstName() + " " + dealerUserSo.getLastName());
			}

			DealerUser dealerUserStl = enquiry.getDealerUserStl();
			if (dealerUserStl != null) {
				basicResponse.setStlId(dealerUserStl.getDealerUserId());
				basicResponse.setStlName(dealerUserStl.getFirstName() + " " + dealerUserStl.getLastName());
			}

			basicResponse.setBudgetFrom(enquiry.getBudgetFrom());
			basicResponse.setBudgetTo(enquiry.getBudgetTo());
			enquiryResponse.setBasicDetails(basicResponse);
			enquiryResponse.setVehicle(vehicleResponse);
			enquiryResponse.setNegotiation(negotiationResponse);

			List<FollowUp> lFollowUps = followUpRepository.getFollowUp(enquiry.getEnquiryNumber());
			FollowUpResponse followUpResponse1 = new FollowUpResponse();
			if (!lFollowUps.isEmpty()) {
				FollowUp followUp = lFollowUps.get(lFollowUps.size() - 1);

				ActualFollowUpResponse actualFollowUpResponse = null;
				NextFollowUpResponse nextFollowUpResponse = null;
				boolean followUpFlag = false;

				actualFollowUpResponse = new ActualFollowUpResponse();
				actualFollowUpResponse.setDetailFollowUpRemark(followUp.getActualDetailRemark());
				actualFollowUpResponse.setFollowUpDate(followUp.getActualDate());
				actualFollowUpResponse.setFollowUpRemark(followUp.getActualRemark());

				nextFollowUpResponse = new NextFollowUpResponse();
				nextFollowUpResponse.setDetailFollowUpRemark(followUp.getNextDetailRemark());
				nextFollowUpResponse.setFollowUpDate(followUp.getNextDate());
				nextFollowUpResponse.setFollowUpRemark(followUp.getNextRemark());

				followUpResponse1.setActualFollowUp(actualFollowUpResponse);
				followUpResponse1.setNextFollowUp(nextFollowUpResponse);
				followUpResponse1.setFollowUpId(followUp.getFollowUpId());
				followUpResponse1.setEnquiryNumber(followUp.getEnquiryNumber());

				Calendar cal = Calendar.getInstance();
				if (followUp.getNextDate()!=null && cal.getTime().compareTo(followUp.getNextDate()) > 0) {
					followUpFlag = true;
				}
				followUpResponse1.setFollowUp(followUpFlag);
				BeanUtils.copyProperties(followUp, followUpResponse1);
			}
			enquiryResponse.setFollowUp(followUpResponse1);

		}
		return enquiryResponse;
	}

	
}
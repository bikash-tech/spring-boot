package in.utrust.service;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.utrust.constants.Constants;
import in.utrust.constants.StatusCodes;
import in.utrust.model.Channel;
import in.utrust.model.DemandStructure;
import in.utrust.model.EnquiryType;
import in.utrust.model.ExteriorColor;
import in.utrust.model.InsuranceType;
import in.utrust.model.Make;
import in.utrust.model.Model;
import in.utrust.model.SellingReason;
import in.utrust.model.SourceName;
import in.utrust.model.SourceType;
import in.utrust.model.StatusReasoning;
import in.utrust.model.User;
import in.utrust.model.Variant;
import in.utrust.repository.EnquiryEntityManager;
import in.utrust.repository.EnquiryTypeRepository;
import in.utrust.repository.MakeRepository;
import in.utrust.repository.ModelRepository;
import in.utrust.repository.UserRepository;
import in.utrust.response.ChannelResponse;
import in.utrust.response.DemandStructureResponse;
import in.utrust.response.EnquiryTypeResponse;
import in.utrust.response.EntityResponse;
import in.utrust.response.ExteriorColorResponse;
import in.utrust.response.InsuranceTypeResponse;
import in.utrust.response.MakeResponse;
import in.utrust.response.ModelEntityResponse;
import in.utrust.response.ModelResponse;
import in.utrust.response.SellingReasonResponse;
import in.utrust.response.SourceNameResponse;
import in.utrust.response.SourceTypeResponse;
import in.utrust.response.StatusReasoningResponse;
import in.utrust.response.UtrustResponse;
import in.utrust.response.VariantEntityResponse;
import in.utrust.response.VariantResponse;

/**
 * @author RamPrasad
 *
 */
@Service("EnquiryMasterDataService")
public class EnquiryMasterDataServiceImpl implements EnquiryMasterDataService {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private EnquiryTypeRepository enquiryTypeRepository;

	@Autowired
	private MakeRepository makeRepository;

	@Autowired
	private ModelRepository modelRepository;

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private EnquiryEntityManager enquiryEntityManager;
	
	@Autowired
	ValuationService valuationService;

	@Override
	@Transactional
	public UtrustResponse getMasterEnquiryDetails(HttpServletRequest request) {

		List<SourceName> snList = null;
		List<SourceType> sourceTypeList = null;
		List<EnquiryType> enquiryTypeList = null;
		List<StatusReasoning> stsRsnList = null;
		List<Channel> cList = null;
		List<SellingReason> srList = null;
		List<Make> mList = null;
		List<ExteriorColor> ecList = null;
		List<DemandStructure> demandStrList = null;
		List<InsuranceType> insuranceList = null;
		
		EntityResponse entityResponse = new EntityResponse();
		List<SourceNameResponse> sourceNameResponseList = new ArrayList<>();
		List<SourceTypeResponse> sourceTypeResponseList = new ArrayList<>();
		List<EnquiryTypeResponse> enquiryTypeResponseList = new ArrayList<>();
		List<StatusReasoningResponse> statusReasoningResponseList = new ArrayList<>();
		List<ChannelResponse> channelResponseList = new ArrayList<>();
		List<SellingReasonResponse> sellingReasonResponseList = new ArrayList<>();
		List<MakeResponse> makeResponseList = new ArrayList<>();
		List<ExteriorColorResponse> extColorResponseList = new ArrayList<>();
		List<DemandStructureResponse> demandStructureResponseList = new ArrayList<>();
		List<InsuranceTypeResponse> insuranceTypeResponseList = new ArrayList<>();

		SourceNameResponse resSrcName = null;
		SourceTypeResponse sourceTypeResponse = null;
		EnquiryTypeResponse enquiryTypeResponse = null;
		StatusReasoningResponse resStsReasoning = null;
		ChannelResponse resChannel = null;
		SellingReasonResponse resSellingReason = null;
		MakeResponse resMake = null;
		ExteriorColorResponse resExtColor = null;
		DemandStructureResponse demandStructureResponse = null;

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
			snList = enquiryEntityManager.getAllSourceName();
			if (snList != null) {
				for (SourceName srcName : snList) {
					resSrcName = new SourceNameResponse();
					BeanUtils.copyProperties(srcName, resSrcName);
					sourceNameResponseList.add(resSrcName);
				}
			}
			sourceTypeList = enquiryEntityManager.getAllSourceType();
			if (sourceTypeList != null) {
				for (SourceType sourceType : sourceTypeList) {
					sourceTypeResponse = new SourceTypeResponse();
					BeanUtils.copyProperties(sourceType, sourceTypeResponse);
					sourceTypeResponseList.add(sourceTypeResponse);
				}
			}
			
			enquiryTypeList = enquiryTypeRepository.findAll();
			if (enquiryTypeList != null) {
				for (EnquiryType enquiryType : enquiryTypeList) {
					enquiryTypeResponse = new EnquiryTypeResponse();
					BeanUtils.copyProperties(enquiryType, enquiryTypeResponse);
					enquiryTypeResponseList.add(enquiryTypeResponse);
				}
			}
			
			stsRsnList = enquiryEntityManager.getAllStatusReasoning();
			if (stsRsnList != null) {
				for (StatusReasoning stsReasoning : stsRsnList) {
					resStsReasoning = new StatusReasoningResponse();
					BeanUtils.copyProperties(stsReasoning, resStsReasoning);
					statusReasoningResponseList.add(resStsReasoning);
				}
			}

			cList = enquiryEntityManager.getAllChannel();
			if (cList != null) {
				for (Channel ch : cList) {
					resChannel = new ChannelResponse();
					BeanUtils.copyProperties(ch, resChannel);
					channelResponseList.add(resChannel);
				}
			}
			srList = enquiryEntityManager.getAllSellingReason();
			if (srList != null) {
				for (SellingReason sellRsn : srList) {
					resSellingReason = new SellingReasonResponse();
					BeanUtils.copyProperties(sellRsn, resSellingReason);
					sellingReasonResponseList.add(resSellingReason);
				}
			}
			mList = makeRepository.findAllMakeInOrder();
			if (mList != null) {
				//Toyota = 33 must be on 0th index
				//Maruti = 20 must be on 1st Index
				//Hyundai = 14 must be on 2nd Index
				//Honda =13 must be on 3rd Index
				//Mahindra = 19 must be on 4th Index
				for (Make mk : mList) {
					resMake = new MakeResponse();
					BeanUtils.copyProperties(mk, resMake);
					makeResponseList.add(resMake);	
				}
			}
			ecList = enquiryEntityManager.getAllExteriorColor();
			if (ecList != null) {
				for (ExteriorColor extClr : ecList) {
					resExtColor = new ExteriorColorResponse();
					BeanUtils.copyProperties(extClr, resExtColor);
					extColorResponseList.add(resExtColor);
				}
			}
			demandStrList = enquiryEntityManager.getAllDemandStructure();
			if (demandStrList != null) {
				for (DemandStructure demandStructure : demandStrList) {
					demandStructureResponse = new DemandStructureResponse();
					BeanUtils.copyProperties(demandStructure, demandStructureResponse);
					demandStructureResponseList.add(demandStructureResponse);
				}
			}

			insuranceList = enquiryEntityManager.getAllInsuranceType();
			if (insuranceList != null) {
				for (InsuranceType insuranceType : insuranceList) {
					InsuranceTypeResponse insuranceTypeResponse = new InsuranceTypeResponse();
					BeanUtils.copyProperties(insuranceType, insuranceTypeResponse);
					insuranceTypeResponseList.add(insuranceTypeResponse);
				}
			}
			
			entityResponse.setSourceNameList(sourceNameResponseList);
			entityResponse.setSourceTypeList(sourceTypeResponseList);
			entityResponse.setEnquiryTypeList(enquiryTypeResponseList);
			entityResponse.setChannelList(channelResponseList);
			entityResponse.setStatusReasoningList(statusReasoningResponseList);
			entityResponse.setSellingReasonList(sellingReasonResponseList);
			entityResponse.setMakeList(makeResponseList);
			entityResponse.setExteriorColorList(extColorResponseList);
			entityResponse.setDemandStructureList(demandStructureResponseList);
			entityResponse.setInsuranceTypeList(insuranceTypeResponseList);

			entityResponse.setValuationList(valuationService.getValuationMaster());
			logger.info("End of Master Enquiry..." + entityResponse);
			return new UtrustResponse(StatusCodes.GET_ENQUIRY_DATA_SUCCESS.getStatusCode(),
					StatusCodes.GET_ENQUIRY_DATA_SUCCESS.getMessage(), entityResponse);

		} catch (Exception e) {
			logger.error(Constants.EXCEPTION, e);
			return new UtrustResponse(StatusCodes.GET_ENQUIRY_DATA_FAIL.getStatusCode(),
					StatusCodes.GET_ENQUIRY_DATA_FAIL.getMessage(), entityResponse);
		}
	}

	@Override
	@Transactional
	public UtrustResponse getModelForMake(Integer makeId, HttpServletRequest request) {
		Make make = null;
		List<Model> mList = null;

		ModelEntityResponse modelResponse = new ModelEntityResponse();
		List<ModelResponse> modelResponseList = new ArrayList<>();

		ModelResponse resModel = null;
		Integer uctdmsId=null;
		User user = null;
		try {
			logger.info("Inside Master Model...");
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
			make = makeRepository.findByMakeId(makeId);
			if (make != null) {
				mList = make.getModelList();
				if (mList != null) {
					for (Model model : mList) {
						resModel = new ModelResponse();
						BeanUtils.copyProperties(model, resModel);
						modelResponseList.add(resModel);
					}
				}
			}
			modelResponse.setModelList(modelResponseList);
			logger.info("End of Master Model.." + modelResponse);
			return new UtrustResponse(StatusCodes.MODEL_DATA_SUCCESS.getStatusCode(),
					StatusCodes.MODEL_DATA_SUCCESS.getMessage(), modelResponse);
		} catch (Exception e) {
			logger.error("makeId ::"+makeId+Constants.EXCEPTION,e);
			return new UtrustResponse(StatusCodes.MODEL_DATA_FAIL.getStatusCode(),
					StatusCodes.MODEL_DATA_FAIL.getMessage(), modelResponse);
		}
	}

	@Override
	@Transactional
	public UtrustResponse getVariantForModel(Integer modelId , HttpServletRequest request) {
		Model model = null;
		List<Variant> vList = null;

		VariantEntityResponse variantResponse = new VariantEntityResponse();
		List<VariantResponse> variantResponseList = new ArrayList<>();

		VariantResponse resVariant = null;
		Integer uctdmsId=null;
		User user = null;
		try {
			logger.info("Inside Master Variant...");
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
			model = modelRepository.findByModelId(modelId);
			if (model != null) {
				vList = model.getVariantList();
				if (vList != null) {
					for (Variant variant : vList) {
						resVariant = new VariantResponse();
						BeanUtils.copyProperties(variant, resVariant);
						variantResponseList.add(resVariant);
					}
				}
			}
			variantResponse.setVariantList(variantResponseList);
			logger.info("End of Master Variant.." + variantResponse);
			return new UtrustResponse(StatusCodes.VARIANT_DATA_SUCCESS.getStatusCode(),
					StatusCodes.VARIANT_DATA_SUCCESS.getMessage(), variantResponse);
		} catch (Exception e) {
			logger.error("modelId ::"+modelId+Constants.EXCEPTION,e);
			return new UtrustResponse(StatusCodes.VARIANT_DATA_FAIL.getStatusCode(),
					StatusCodes.VARIANT_DATA_FAIL.getMessage(), variantResponse);
		}
	}
}

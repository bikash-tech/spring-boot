package in.utrust.service;

import javax.servlet.http.HttpServletRequest;
import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.utrust.constants.Constants;
import in.utrust.constants.StatusCodes;
import in.utrust.model.Enquiry;
import in.utrust.model.User;
import in.utrust.repository.EnquiryRepository;
import in.utrust.repository.UserRepository;
import in.utrust.request.BasicDetailsRequest;
import in.utrust.response.EnquiryResponse;
import in.utrust.response.UtrustResponse;

@Service("BuyerEnquiryService")
public class BuyerEnquiryServiceImpl implements BuyerEnquiryService {
	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private EnquiryRepository enquiryRepository;

	@Autowired
	private UserRepository userRepository;

	@Override
	@Transactional
	public UtrustResponse updateBuyerEnquiry(BasicDetailsRequest basicDetailsRequest, HttpServletRequest request) {
		EnquiryResponse enquiryResponse = new EnquiryResponse();

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
			Enquiry enquiry = enquiryRepository.findByEnquiryNumberAndBuyerEnquiryNo(basicDetailsRequest.getBuyerEnquiryNo(),
					basicDetailsRequest.getEnquiryNumber());
			int enquiryReturnedData = 0;
			if (enquiry == null) {
				enquiryReturnedData = enquiryRepository.updateBuyerEnquiryNumber(basicDetailsRequest.getBuyerEnquiryNo(),
						basicDetailsRequest.getEnquiryNumber());
				BeanUtils.copyProperties(enquiryReturnedData, enquiryResponse);
			}
			if (enquiryReturnedData == 1) {
				return new UtrustResponse(StatusCodes.BUYER_ENQUIRY_LINKED_SUCCESS.getStatusCode(),
						StatusCodes.BUYER_ENQUIRY_LINKED_SUCCESS.getMessage(), null);
			} else {
				return new UtrustResponse(StatusCodes.BUYER_ENQUIRY_LINKED_FAIL.getStatusCode(),
						StatusCodes.BUYER_ENQUIRY_LINKED_FAIL.getMessage(), null);
			}
		} catch (Exception e) {
			logger.error("request body for updateBuyerEnquiry ::"+basicDetailsRequest+Constants.EXCEPTION + e);
			return new UtrustResponse(StatusCodes.BUYER_ENQUIRY_LINKED_FAIL.getStatusCode(),
					StatusCodes.BUYER_ENQUIRY_LINKED_FAIL.getMessage(), null);
		}
	}
}
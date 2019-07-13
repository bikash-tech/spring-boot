package in.utrust.service;

import javax.servlet.http.HttpServletRequest;

import in.utrust.request.BasicDetailsRequest;
import in.utrust.response.UtrustResponse;

public interface BuyerEnquiryService {

	UtrustResponse updateBuyerEnquiry(BasicDetailsRequest basicDetailsRequest, HttpServletRequest request);
}
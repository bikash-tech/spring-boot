package in.utrust.service;

import javax.servlet.http.HttpServletRequest;

import in.utrust.response.UtrustResponse;

public interface EnquiryMasterDataService {

	UtrustResponse getMasterEnquiryDetails(HttpServletRequest request);

	UtrustResponse getModelForMake(Integer makeId, HttpServletRequest request);

	UtrustResponse getVariantForModel(Integer modelId, HttpServletRequest request);

}

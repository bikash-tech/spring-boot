package in.utrust.controller;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import in.utrust.response.UtrustResponse;
import in.utrust.service.EnquiryMasterDataService;

/**
 * @author RamPrasad
 *
 */
@RestController
@RequestMapping("/api/v1/master")
public class EnquiryMasterDataController {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	EnquiryMasterDataService enquiryMasterDataService;

	@GetMapping("/enquiry-details")
	public UtrustResponse masterEnquiry(HttpServletRequest request) {
		logger.info("Inside master enquiry");
		return enquiryMasterDataService.getMasterEnquiryDetails(request);
	}

	@GetMapping("/model/{makeId}")
	public UtrustResponse getModelForMake(@PathVariable("makeId") Integer makeId, HttpServletRequest request) {
		logger.info("Inside master make");
		return enquiryMasterDataService.getModelForMake(makeId, request);
	}

	@GetMapping("/variant/{modelId}")
	public UtrustResponse getVariantForModel(@PathVariable("modelId") Integer modelId, HttpServletRequest request) {
		logger.info("Inside master variant");
		return enquiryMasterDataService.getVariantForModel(modelId, request);
	}
	
}
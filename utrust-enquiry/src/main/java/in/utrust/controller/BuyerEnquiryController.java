package in.utrust.controller;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import in.utrust.request.BasicDetailsRequest;
import in.utrust.response.UtrustResponse;
import in.utrust.service.BuyerEnquiryService;

@RestController
@RequestMapping("/api/v1/buyer")
public class BuyerEnquiryController {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	BuyerEnquiryService buyerEnquiryService;

	@PutMapping("/link-buyer-enquiry")
	public UtrustResponse linkBuyerEnquiry(@RequestBody BasicDetailsRequest basicDetailsRequest, HttpServletRequest request) {
		logger.info("Update Buyer enquiry");
		return buyerEnquiryService.updateBuyerEnquiry(basicDetailsRequest,request);
	}
}
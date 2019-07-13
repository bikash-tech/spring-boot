/*package in.utrust.controller;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import in.utrust.constants.Constants;
import in.utrust.response.UtrustResponse;
import in.utrust.service.ValuationService;

 
@RestController
@RequestMapping(Constants.SELLER_BASE_URL)
public class ValuationController {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	ValuationService valuationService;

	@GetMapping("valuation/master")
	public UtrustResponse getValuationMaster(HttpServletRequest request) {
		logger.info("Inside master enquiry");
		return valuationService.getValuationMaster();
	}
	
}*/
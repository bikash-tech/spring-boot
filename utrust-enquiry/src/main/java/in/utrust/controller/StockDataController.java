package in.utrust.controller;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import in.utrust.request.StockMatchingRequest;
import in.utrust.response.UtrustResponse;
import in.utrust.service.StockService;

@RestController
@RequestMapping("/api/v1/stock")
public class StockDataController {
	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	StockService stockService;

	@PostMapping("/stock-data1")
	@ResponseBody
	public UtrustResponse getStockCount(@RequestBody StockMatchingRequest stockData, HttpServletRequest request) {
		logger.info("Inside getStockCount with stock Object: " + stockData);
		return stockService.getVehicleStockData(stockData.getMakeId(), stockData.getModelId(), stockData.getYear(),
				stockData.getVariantId(),stockData.getPageNumber(),request);
	} 

	@PostMapping("/stock-data")
	public UtrustResponse stockCountModified(@RequestBody StockMatchingRequest stockData, HttpServletRequest request) {
		logger.info("Inside getStockCount with stock Object: " + stockData);
		return stockService.getVehicleStockData_Modified(stockData, request);
	} 

}

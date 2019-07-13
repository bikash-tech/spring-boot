package in.utrust.service;

import javax.servlet.http.HttpServletRequest;

import in.utrust.request.StockMatchingRequest;
import in.utrust.response.UtrustResponse;

public interface StockService {

	UtrustResponse getVehicleStockData(Integer makeId, Integer modelId, Integer year, Integer variantId,
			Integer pageNumber, HttpServletRequest request);

	UtrustResponse getVehicleStockData_Modified(StockMatchingRequest stockData, HttpServletRequest request);
}

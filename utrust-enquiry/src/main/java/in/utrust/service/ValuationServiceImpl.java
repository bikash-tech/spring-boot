package in.utrust.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.utrust.constants.Constants;
import in.utrust.constants.StatusCodes;
import in.utrust.model.User;
import in.utrust.repository.UserRepository;
import in.utrust.repository.ValuationEntityManager;
import in.utrust.response.UtrustResponse;

/**
 * @author RamPrasad
 *
 */
@Service("ValuationService")
public class ValuationServiceImpl implements ValuationService {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired 
	ValuationEntityManager valuationEntityManager;
	
	@Autowired
	UserRepository userRepository;
	
	
	@Override
	@Transactional
	public Map<String, List> getValuationMaster() {
		try {
			@SuppressWarnings("rawtypes")
			Map<String, List> responseMap= new HashMap<>();
			responseMap.put("vinPlate", valuationEntityManager.getVinPlateResponse());
			responseMap.put("bodyType", valuationEntityManager.getBodyTypeResponse());
			responseMap.put("serviceHistory", valuationEntityManager.getServiceHistoryResponse());
			responseMap.put("currentCar", valuationEntityManager.getCurrentCarResponse());
			responseMap.put("carUsage", valuationEntityManager.getCurrentCarUsageResponse());
			responseMap.put("nocStatus", valuationEntityManager.getNocStatusResponse());
			responseMap.put("rcType", valuationEntityManager.getRCTypeResponse());
			responseMap.put("emission", valuationEntityManager.getEmmissionResponse());
			responseMap.put("insuranceType", valuationEntityManager.getInsuranceTypeResponse());
			responseMap.put("insuranceCompany", valuationEntityManager.getInsuranceCompanyResponse());
			return responseMap;
		} catch (Exception e) {
			logger.error(Constants.EXCEPTION ,e);
			 throw e;
		}
	}

	/*@Override
	@Transactional
	public UtrustResponse saveValuation(ValuationDetailsRequest valuationRequest,HttpServletRequest request) {
		 
		try {
			if (request.getHeader(Constants.UCTDMS_ID) != null) {
				int uctdmsId = Integer.parseInt(request.getHeader(Constants.UCTDMS_ID));
			   User user=userRepository.getUserDetails(uctdmsId);

				if (user==null) {
					return new UtrustResponse(StatusCodes.UCTDMS_ID_NOT_FOUND.getStatusCode(),
							StatusCodes.UCTDMS_ID_NOT_FOUND.getMessage(), null);
				}
			}
			else {
				return new UtrustResponse(StatusCodes.UCTDMS_ID_NOT_EXISTS.getStatusCode(),
						StatusCodes.UCTDMS_ID_NOT_EXISTS.getMessage(), null);
			}
			@SuppressWarnings("rawtypes")
			Map<String, List> responseMap= new HashMap<>();
			responseMap.put("vinPlate", valuationEntityManager.getVinPlateResponse());
			responseMap.put("bodyType", valuationEntityManager.getBodyTypeResponse());
			responseMap.put("serviceHistory", valuationEntityManager.getServiceHistoryResponse());
			responseMap.put("currentCar", valuationEntityManager.getCurrentCarResponse());
			responseMap.put("carUsage", valuationEntityManager.getCurrentCarUsageResponse());
			responseMap.put("nocStatus", valuationEntityManager.getNocStatusResponse());
			responseMap.put("rcType", valuationEntityManager.getRCTypeResponse());

			return new UtrustResponse(StatusCodes.VALUATION_MASTER_SUCCESS.getStatusCode(),StatusCodes.VALUATION_MASTER_SUCCESS.getMessage(), responseMap);
		} catch (Exception e) {
			logger.error(Constants.EXCEPTION ,e);
			return new UtrustResponse(StatusCodes.VALUATION_MASTER_FAIL.getStatusCode(),
					StatusCodes.VALUATION_MASTER_FAIL.getMessage(), null);
		}
	}*/
	
}

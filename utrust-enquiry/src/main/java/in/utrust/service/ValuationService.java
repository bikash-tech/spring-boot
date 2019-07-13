package in.utrust.service;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import in.utrust.response.UtrustResponse;

public interface ValuationService {
Map<String, List> getValuationMaster();
}

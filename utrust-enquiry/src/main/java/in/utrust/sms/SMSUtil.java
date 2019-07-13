package in.utrust.sms;

import org.json.simple.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import in.utrust.constants.Constants;

@Component
public class SMSUtil {
	
	private final Logger logger = LoggerFactory.getLogger(SMSUtil.class);

	@Value("${sms_gateway_url}")
	private String smsGateWayUrl;
	
	@Value("${sms_api_key}")
	private String smsApiKey;
	
	@Value("${sms_sender}")
	private String smsSender;
	
	
	
	public void sendSMS(String mobileNumber,String content){
		try {
			logger.info(" mobileNumber :" + mobileNumber+ "  content :" +content);
			RestTemplate restTemplate = new RestTemplate();
			JSONObject smsResponse = restTemplate.getForObject(smsGateWayUrl+ "api_key="+smsApiKey+ "&method=sms&message="+content+"&to="+mobileNumber+"&sender="+smsSender,JSONObject.class);
			logger.info("OTP STATUS !!!!!!!!!!!!!!!!!! " +smsResponse);
		    
		} catch (RestClientException e) {
			logger.error(Constants.EXCEPTION,e);
			throw e;
		}
	}

	
}

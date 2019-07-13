package in.utrust.controller;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.Base64;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import javax.servlet.http.HttpServletRequest;

import org.apache.http.conn.ssl.NoopHostnameVerifier;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.conn.ssl.TrustStrategy;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.json.simple.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author RamPrasad
 *
 */
@RestController
@RequestMapping("/api/v1/uctdms")
public class UctdmsEnquiryController {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());
/*
	@SuppressWarnings("unchecked")
	@PostMapping("/getlist")
	public Object saveEnquiry(HttpServletRequest request) {
		JSONObject response =null;
		try {
			final String uri = "https://182.19.37.220/tkml/sandbox/getlist/enquiry";
			//UCTDMSSavePoAllocationRequest uCTDMSSavePoAllocationRequest = new UCTDMSSavePoAllocationRequest();

			
		    HttpHeaders headers = new HttpHeaders();
	        headers.setContentType(MediaType.APPLICATION_JSON);
	        headers.set("X-IBM-Client-Id", "69a955a4a8948ee132d57a7f17396550");
	        headers.set("X-IBM-Client-Secret", "12ecd16233f7c78514d5bca037015778");

			
			RestTemplate restTemplate = new RestTemplate();
			
			JSONObject requestObject = new JSONObject();
			requestObject.put("mobileNo", "");
			requestObject.put("registrationNo", "");
			requestObject.put("fromDate", "01012018");
			requestObject.put("toDate", "01061018");
			requestObject.put("dlrCD", "GR031");
			requestObject.put("brcCD", "BL021");
			requestObject.put("uctdmsId", "1308705");
			requestObject.put("pageNumber", "10");

	        HttpEntity<JSONObject> httpEntity = new HttpEntity<>(headers);

	        
	        //HttpEntity<JSONObject> httpEntity = new HttpEntity<>(requestObject,headers);

		    response = restTemplate.postForObject(uri,httpEntity,JSONObject.class);

			logger.info("UtrustResponse :" + response);

			return response;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "Failed";

	}*/
	
	@PostMapping("/poalloc")
	public JSONObject poalloc(HttpServletRequest request) {
		JSONObject response =null;
		try {
			final String uri = "https://182.19.37.220/tkml/sandbox/save/poalloc";
			//UCTDMSSavePoAllocationRequest uCTDMSSavePoAllocationRequest = new UCTDMSSavePoAllocationRequest();

			
		    HttpHeaders headers = new HttpHeaders();
	        headers.setContentType(MediaType.APPLICATION_JSON);
	        headers.set("X-IBM-Client-Id", "913a1a2649a1b6e41a4c0edd2ed18c23");
	        headers.set("X-IBM-Client-Secret", "850252076e1e20f49c477e8620287601");

	        HttpEntity<String> httpEntity = new HttpEntity<String>(headers);
			
			//RestTemplate restTemplate = new RestTemplate();

		    response = getRestTemplate().postForObject(uri, httpEntity,JSONObject.class);

			logger.info("UtrustResponse :" + response);

			return response;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return response;

	}
	
	
	public RestTemplate getRestTemplate() throws KeyStoreException, NoSuchAlgorithmException, KeyManagementException {
	    TrustStrategy acceptingTrustStrategy = new TrustStrategy() {
	        @Override
	        public boolean isTrusted(X509Certificate[] x509Certificates, String s) throws CertificateException {
	            return true;
	        }
	    };
	    SSLContext sslContext = org.apache.http.ssl.SSLContexts.custom().loadTrustMaterial(null, acceptingTrustStrategy).build();
	    SSLConnectionSocketFactory csf = new SSLConnectionSocketFactory(sslContext, new NoopHostnameVerifier());
	    CloseableHttpClient httpClient = HttpClients.custom().setSSLSocketFactory(csf).build();
	    HttpComponentsClientHttpRequestFactory requestFactory = new HttpComponentsClientHttpRequestFactory();
	    requestFactory.setHttpClient(httpClient);
	    RestTemplate restTemplate = new RestTemplate(requestFactory);
	    return restTemplate;
	}
  
	
	@SuppressWarnings("unchecked")
	@PostMapping("/getlist")
	public Object saveEnquiry(HttpServletRequest request) {
		try {
			

			// Create a trust manager that does not validate certificate chains
			TrustManager[] trustAllCerts = new TrustManager[] {new X509TrustManager() {
			        public java.security.cert.X509Certificate[] getAcceptedIssuers() {
			            return null;
			        }
			        public void checkClientTrusted(X509Certificate[] certs, String authType) {
			        }
			        public void checkServerTrusted(X509Certificate[] certs, String authType) {
			        }
			    }
			};
 
			// Install the all-trusting trust manager
			SSLContext sc = SSLContext.getInstance("SSL");
			sc.init(null, trustAllCerts, new java.security.SecureRandom());
			HttpsURLConnection.setDefaultSSLSocketFactory(sc.getSocketFactory());
 
			// Create all-trusting host name verifier
			HostnameVerifier allHostsValid = new HostnameVerifier() {
			    public boolean verify(String hostname, SSLSession session) {
			        return true;
			    }
			};
 
			// Install the all-trusting host verifier
			HttpsURLConnection.setDefaultHostnameVerifier(allHostsValid);
 
			URL myURL = new URL("https://tkmloic-toyotakirloskar.integration.ocp.oraclecloud.com:443/ic/api/integration/v1/flows/rest/GETENQUIRYLIST/1.0/GetEnquiryList");
			
			HttpURLConnection myURLConnection = (HttpURLConnection)myURL.openConnection();
			
			
 			String encoded = Base64.getEncoder().encodeToString(("appconsumer"+":"+"Welcome#12345").getBytes(StandardCharsets.UTF_8));  //Java 8
 			myURLConnection.setRequestProperty("Authorization", "Basic "+encoded);
			
		 
 
			
			myURLConnection.setRequestMethod("POST");
			myURLConnection.setRequestProperty("Content-Type", "application/json; utf-8");
			myURLConnection.setRequestProperty("Accept", "application/json");
			myURLConnection.setDoOutput(true);

			
			JSONObject requestObject = new JSONObject();
			requestObject.put("mobileNo", "");
			requestObject.put("registrationNo", "");
			requestObject.put("fromDate", "01012018");
			requestObject.put("toDate", "01062018");
			requestObject.put("dlrCD", "GR031");
			requestObject.put("brcCD", "BL021");
			requestObject.put("uctdmsId", "1308705");
			requestObject.put("pageNumber", 10);
			
			
			try(OutputStream os = myURLConnection.getOutputStream()) {
			    byte[] input = requestObject.toJSONString().getBytes("utf-8");
			    os.write(input, 0, input.length);           
			}
			
			try(BufferedReader br = new BufferedReader(
					  new InputStreamReader(myURLConnection.getInputStream(), "utf-8"))) {
					    StringBuilder response = new StringBuilder();
					    String responseLine = null;
					    while ((responseLine = br.readLine()) != null) {
					        response.append(responseLine.trim());
					    }
					    System.out.println(response.toString());
					    return response.toString();
					}
        
		
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "Failed";

	}
}
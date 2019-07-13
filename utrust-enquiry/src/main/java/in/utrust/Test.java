package in.utrust;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.Reader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.security.cert.X509Certificate;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

import org.json.simple.JSONObject;
 
public class Test {
    @SuppressWarnings("unchecked")
	public static void main(String[] args) throws Exception {
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
 
			URL myURL = new URL("https://182.19.37.220/tkml/sandbox/getlist/enquiry");
			
			HttpURLConnection myURLConnection = (HttpURLConnection)myURL.openConnection();
			
			myURLConnection.setRequestProperty ("X-IBM-Client-Id", "69a955a4a8948ee132d57a7f17396550");
			myURLConnection.setRequestProperty ("X-IBM-Client-Secret", "12ecd16233f7c78514d5bca037015778");

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
			requestObject.put("pageNumber", "10");

			
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
					}
        
		} catch (Exception e) {
 			e.printStackTrace();
		}
    }
}
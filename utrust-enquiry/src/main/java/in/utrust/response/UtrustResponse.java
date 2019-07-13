package in.utrust.response;
/**
 * @author RamPrasad
 *
 */
public class UtrustResponse {
	private int statusCode;
	private String message;
	private Object responseData;
	
	public UtrustResponse() {		
	}

	public UtrustResponse(int statusCode, String message, Object responseData) {
		super();
		this.statusCode = statusCode;
		this.message = message;
		this.responseData = responseData;
	}

	public UtrustResponse(int statusCode, String message) {
		super();
		this.statusCode = statusCode;
		this.message = message;
 	}
	public int getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Object getResponseData() {
		return responseData;
	}

	public void setResponseData(Object responseData) {
		this.responseData = responseData;
	}
}

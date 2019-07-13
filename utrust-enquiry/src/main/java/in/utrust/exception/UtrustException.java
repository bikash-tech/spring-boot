package in.utrust.exception;
/**
 * @author RamPrasad
 *
 */
public class UtrustException extends Exception {

	private static final long serialVersionUID = -3720556808733991737L;

	Integer statusCode;
	Integer httpStatusCode;
	String localizedMessage;

	public UtrustException(Integer statusCode, Integer httpStatusCode,
			String message, String localizedMessage) {
		super(message);
		this.statusCode = statusCode;
		this.httpStatusCode = httpStatusCode;
		this.localizedMessage = localizedMessage;
	}

	public UtrustException(String message) {
		super(message);
	}

	public UtrustException() {
		super();
	}

	public String getLocalizedMessage() {
		return this.localizedMessage;
	}

	public Integer getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(Integer statusCode) {
		this.statusCode = statusCode;
	}

	public Integer getHttpStatusCode() {
		return httpStatusCode;
	}

	public void setHttpStatusCode(Integer httpStatusCode) {
		this.httpStatusCode = httpStatusCode;
	}

	public void setLocalizedMessage(String localizedMessage) {
		this.localizedMessage = localizedMessage;
	}

}

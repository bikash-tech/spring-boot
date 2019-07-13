package in.utrust.util;
import in.utrust.response.UtrustResponse;
/**
 * @author RamPrasad
 *
 */
public class ResponseUtil {
 	public static UtrustResponse getResponse(Integer statusCode,  String message,Object responseData) {
		return new UtrustResponse(statusCode, message, responseData);
	}
 	public static UtrustResponse getResponse(Integer statusCode,  String message) {
		return new UtrustResponse(statusCode, message);
	}
 	public static UtrustResponse getResponse(Integer statusCode, Integer httpStatusCode , String message,Object responseData) {
		return new UtrustResponse(statusCode, message, responseData);
	}
}

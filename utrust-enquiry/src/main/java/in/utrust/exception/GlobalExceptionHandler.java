package in.utrust.exception;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.ConversionNotSupportedException;
import org.springframework.beans.TypeMismatchException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.http.converter.HttpMessageNotWritableException;
import org.springframework.validation.BindException;
import org.springframework.web.HttpMediaTypeNotAcceptableException;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.ServletRequestBindingException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.multipart.support.MissingServletRequestPartException;
import org.springframework.web.servlet.NoHandlerFoundException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import in.utrust.response.UtrustResponse;
import in.utrust.util.ResponseUtil;
/**
 * @author RamPrasad
 *
 */
@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

	@ResponseStatus(value=HttpStatus.NOT_FOUND, reason="IOException occured")
	@ExceptionHandler(UtrustException.class)
	public @ResponseBody
	UtrustResponse handleException(HttpServletResponse response,UtrustException ex) {
		logger.info("GlobalExceptionHandler1......."+ ex.getHttpStatusCode());
		return ResponseUtil.getResponse(ex.getStatusCode(),ex.getHttpStatusCode(), ex.getMessage(),ex.getLocalizedMessage());
	}

	@ExceptionHandler(Exception.class)
	@ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
	public @ResponseBody
	UtrustResponse handleException(Exception ex) {
		logger.error("GlobalExceptionHandler2.......", ex);
		return ResponseUtil.getResponse( HttpStatus.INTERNAL_SERVER_ERROR.value(),"Internal Server error to write response");
	}

	@Override
	protected ResponseEntity<Object> handleNoHandlerFoundException(
			NoHandlerFoundException ex, HttpHeaders headers, HttpStatus status,
			WebRequest request) {
		logger.info("Exception handleNoHandlerFoundException ");
		UtrustResponse tataAppResponse = ResponseUtil.getResponse(
			  HttpStatus.BAD_REQUEST.value(),
				"Invalid Request, No Handler Found",
				"Invalid Request, No Handler Found");
		return new ResponseEntity(tataAppResponse, HttpStatus.BAD_REQUEST);
	}

	/*@Override
	protected ResponseEntity<Object> handleNoSuchRequestHandlingMethod(
			NoSuchRequestHandlingMethodException ex, HttpHeaders headers,
			HttpStatus status, WebRequest request) {
		UtrustResponse tataAppResponse = ResponseUtil.getResponse(
				 HttpStatus.BAD_REQUEST.value(),
				"Invalid Request, No Such Request Handling Methods Available",
				"Invalid Request, No Such Request Handling Methods Available");
		return new ResponseEntity(tataAppResponse, HttpStatus.BAD_REQUEST);
	}*/

	@Override
	protected ResponseEntity<Object> handleBindException(BindException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		UtrustResponse tataAppResponse = ResponseUtil.getResponse(
				 HttpStatus.BAD_REQUEST.value(),
				"Invalid Request Bind Not Found",
				"Invalid Request Bind Not Found");
		return new ResponseEntity(tataAppResponse, HttpStatus.BAD_REQUEST);
	}

	@Override
	protected ResponseEntity<Object> handleConversionNotSupported(
			ConversionNotSupportedException ex, HttpHeaders headers,
			HttpStatus status, WebRequest request) {
		UtrustResponse tataAppResponse = ResponseUtil.getResponse(
				 HttpStatus.BAD_REQUEST.value(),
				"Invalid Request Conversion Not Supported",
				"Invalid Request Conversion Not Supported");
		return new ResponseEntity(tataAppResponse, HttpStatus.BAD_REQUEST);
	}

	@Override
	protected ResponseEntity<Object> handleExceptionInternal(Exception ex,
			Object body, HttpHeaders headers, HttpStatus status,
			WebRequest request) {
		UtrustResponse tataAppResponse = ResponseUtil.getResponse(
 				HttpStatus.BAD_REQUEST.value(),
				"Invalid Request Internal Exception ",
				"Invalid Request Internal Exception ");
		return new ResponseEntity(tataAppResponse,
				HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@Override
	protected ResponseEntity<Object> handleHttpMediaTypeNotAcceptable(
			HttpMediaTypeNotAcceptableException ex, HttpHeaders headers,
			HttpStatus status, WebRequest request) {
		UtrustResponse tataAppResponse = ResponseUtil.getResponse(
				 HttpStatus.BAD_REQUEST.value(),
				"Invalid Request, Media Type Not Acceptable",
				"Invalid Request, Media Type Not Acceptable");
		return new ResponseEntity(tataAppResponse, HttpStatus.BAD_REQUEST);
	}

	@Override
	protected ResponseEntity<Object> handleHttpMediaTypeNotSupported(
			HttpMediaTypeNotSupportedException ex, HttpHeaders headers,
			HttpStatus status, WebRequest request) {
		UtrustResponse tataAppResponse = ResponseUtil.getResponse(
				 HttpStatus.BAD_REQUEST.value(),
				"Invalid Request, Media Type Not Supported",
				"Invalid Request, Media Type Not Supported");
		return new ResponseEntity(tataAppResponse, HttpStatus.BAD_REQUEST);
	}

	@Override
	protected ResponseEntity<Object> handleHttpMessageNotReadable(
			HttpMessageNotReadableException ex, HttpHeaders headers,
			HttpStatus status, WebRequest request) {
		UtrustResponse tataAppResponse = ResponseUtil
				.getResponse(
						
						HttpStatus.BAD_REQUEST.value(),
						"Invalid Request, Request Not Readable.Please check your JSON Input and Provide valid one",
						"Invalid Request, Request Not Readable.Please check your JSON Input and Provide valid one");
		return new ResponseEntity(tataAppResponse, HttpStatus.BAD_REQUEST);

	}

	/*@Override
	protected ResponseEntity<Object> handleHttpMessageNotWritable(
			HttpMessageNotWritableException ex, HttpHeaders headers,
			HttpStatus status, WebRequest request) {
		UtrustResponse tataAppResponse = ResponseUtil.getResponse(
				HttpStatus.INTERNAL_SERVER_ERROR.value(),
				HttpStatus.BAD_REQUEST.value(),
 				"Internal Server error to write response");
		return new ResponseEntity(tataAppResponse,
				HttpStatus.INTERNAL_SERVER_ERROR);
	}*/

	@Override
	protected ResponseEntity<Object> handleHttpRequestMethodNotSupported(
			HttpRequestMethodNotSupportedException ex, HttpHeaders headers,
			HttpStatus status, WebRequest request) {
		UtrustResponse tataAppResponse = ResponseUtil.getResponse(
				 HttpStatus.BAD_REQUEST.value(),
				"Invalid Request, Request Method Not Supported",
				"Invalid Request, Request Method Not Supported");
		return new ResponseEntity(tataAppResponse, HttpStatus.BAD_REQUEST);
	}

	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(
			MethodArgumentNotValidException ex, HttpHeaders headers,
			HttpStatus status, WebRequest request) {
		UtrustResponse tataAppResponse = ResponseUtil.getResponse(
				 HttpStatus.BAD_REQUEST.value(),
				"Invalid Request, Method Argument Not Valid",
				"Invalid Request, Method Argument Not Valid");
		return new ResponseEntity(tataAppResponse, HttpStatus.BAD_REQUEST);
	}

	@Override
	protected ResponseEntity<Object> handleMissingServletRequestParameter(
			MissingServletRequestParameterException ex, HttpHeaders headers,
			HttpStatus status, WebRequest request) {
		UtrustResponse tataAppResponse = ResponseUtil.getResponse(
				 HttpStatus.BAD_REQUEST.value(),
				"Invalid Request, Missing Request Parameter",
				"Invalid Request, Missing Request Parameter");
		return new ResponseEntity(tataAppResponse, HttpStatus.BAD_REQUEST);
	}

	@Override
	protected ResponseEntity<Object> handleMissingServletRequestPart(
			MissingServletRequestPartException ex, HttpHeaders headers,
			HttpStatus status, WebRequest request) {
		UtrustResponse tataAppResponse = ResponseUtil.getResponse(
				 HttpStatus.BAD_REQUEST.value(),
				"Invalid Request, Missing Request Part",
				"Invalid Request, Missing Request Part");
		return new ResponseEntity(tataAppResponse, HttpStatus.BAD_REQUEST);
	}

	@Override
	protected ResponseEntity<Object> handleServletRequestBindingException(
			ServletRequestBindingException ex, HttpHeaders headers,
			HttpStatus status, WebRequest request) {
		UtrustResponse tataAppResponse = ResponseUtil.getResponse(
				 HttpStatus.BAD_REQUEST.value(),
				"Invalid Request, unable to bind Request",
				"Invalid Request, Request Binding");
		return new ResponseEntity(tataAppResponse, HttpStatus.BAD_REQUEST);
	}

	@Override
	protected ResponseEntity<Object> handleTypeMismatch(
			TypeMismatchException ex, HttpHeaders headers, HttpStatus status,
			WebRequest request) {
		UtrustResponse tataAppResponse = ResponseUtil.getResponse(
				 HttpStatus.BAD_REQUEST.value(),
				"Invalid Request,Type Mismatch",
				"Invalid Request,Type Mismatch");
		return new ResponseEntity(tataAppResponse, HttpStatus.BAD_REQUEST);
	}

}

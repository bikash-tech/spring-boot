package in.utrust.request;

public class OtpRequest {
	private String enquiryNumber;
	private int type ;
	private Boolean isResend = false;
	private String otp;
	private String mobileNumber;
	private String alternateMobile;
	private Boolean fromPTL=false;
	
	public Boolean getFromPTL() {
		return fromPTL;
	}
	public void setFromPTL(Boolean fromPTL) {
		this.fromPTL = fromPTL;
	}
	public String getAlternateMobile() {
		return alternateMobile;
	}
	public void setAlternateMobile(String alternateMobile) {
		this.alternateMobile = alternateMobile;
	}
	public String getMobileNumber() {
		return mobileNumber;
	}
	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}
	public String getOtp() {
		return otp;
	}
	public void setOtp(String otp) {
		this.otp = otp;
	}
	public Boolean getIsResend() {
		return isResend;
	}
	public void setIsResend(Boolean isResend) {
		this.isResend = isResend;
	}
	public String getEnquiryNumber() {
		return enquiryNumber;
	}
	public void setEnquiryNumber(String enquiryNumber) {
		this.enquiryNumber = enquiryNumber;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	@Override
	public String toString() {
		return "OtpRequest [enquiryNumber=" + enquiryNumber + ", type=" + type + "]";
	}
	
}

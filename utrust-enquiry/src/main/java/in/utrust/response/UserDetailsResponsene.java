package in.utrust.response;

public class UserDetailsResponsene {
	private int userId=1;
	private int uctdmsId=1;
	private String firstName="KM";
	private String lastName="RAM";
	private String middleName="PRASAD";
	private String mobileNumber="9066666666";
	private String email="ram@gmail.com";
	
	EnquiryDetails dealerResponse;
	
	public EnquiryDetails getDealerResponse() {
		return dealerResponse;
	}
	public void setDealerResponse(EnquiryDetails dealerResponse) {
		this.dealerResponse = dealerResponse;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public int getUctdmsId() {
		return uctdmsId;
	}
	public void setUctdmsId(int uctdmsId) {
		this.uctdmsId = uctdmsId;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getMiddleName() {
		return middleName;
	}
	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}
	public String getMobileNumber() {
		return mobileNumber;
	}
	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}


}

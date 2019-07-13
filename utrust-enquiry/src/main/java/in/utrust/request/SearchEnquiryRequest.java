package in.utrust.request;

public class SearchEnquiryRequest {
	private String mobileNumber;
	private String registrationNumber;
	private String name;

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public String getRegistrationNumber() {
		return registrationNumber;
	}

	public void setRegistrationNumber(String registrationNumber) {
		this.registrationNumber = registrationNumber;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "SearchEnquiryRequest [mobileNumber=" + mobileNumber + ", registrationNumber=" + registrationNumber
				+ ", name=" + name + "]";
	}
	
}

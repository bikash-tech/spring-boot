package in.utrust.request;

public class ProcurementSignOffRequest {

	private String enquiryNumber;
	private String[] imageUrls;

	public String getEnquiryNumber() {
		return enquiryNumber;
	}
	
	public void setEnquiryNumber(String enquiryNumber) {
		this.enquiryNumber = enquiryNumber;
	}
	
	public String[] getImageUrls() {
		return imageUrls;
	}

	public void setImageUrls(String[] imageUrls) {
		this.imageUrls = imageUrls;
	}
	
}

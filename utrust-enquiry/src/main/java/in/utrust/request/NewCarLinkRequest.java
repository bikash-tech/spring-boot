package in.utrust.request;

public class NewCarLinkRequest {
	private String sellerEnquiryNumber;
	private String newCarEnquiryNumber;

	public String getSellerEnquiryNumber() {
		return sellerEnquiryNumber;
	}

	public void setSellerEnquiryNumber(String sellerEnquiryNumber) {
		this.sellerEnquiryNumber = sellerEnquiryNumber;
	}

	public String getNewCarEnquiryNumber() {
		return newCarEnquiryNumber;
	}

	public void setNewCarEnquiryNumber(String newCarEnquiryNumber) {
		this.newCarEnquiryNumber = newCarEnquiryNumber;
	}

	@Override
	public String toString() {
		return "NewCarLinkRequest [sellerEnquiryNumber=" + sellerEnquiryNumber + ", newCarEnquiryNumber="
				+ newCarEnquiryNumber + "]";
	}
}
